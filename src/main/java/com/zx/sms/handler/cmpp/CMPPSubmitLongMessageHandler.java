package com.zx.sms.handler.cmpp;

import io.netty.channel.ChannelHandlerContext;

import org.apache.commons.lang.StringUtils;
import org.marre.sms.SmsMessage;

import com.zx.sms.codec.cmpp.msg.CmppSubmitRequestMessage;
import com.zx.sms.codec.cmpp.msg.CmppSubmitResponseMessage;
import com.zx.sms.codec.cmpp.msg.LongMessageFrame;
import com.zx.sms.codec.cmpp.wap.AbstractLongMessageHandler;
import com.zx.sms.common.util.DefaultSequenceNumberUtil;
import com.zx.sms.common.util.MsgId;

public class CMPPSubmitLongMessageHandler extends AbstractLongMessageHandler<CmppSubmitRequestMessage> {

	@Override
	protected void response(ChannelHandlerContext ctx, CmppSubmitRequestMessage msg) {
		//短信片断未接收完全，直接给网关回复resp，等待其它片断
		CmppSubmitResponseMessage responseMessage = new CmppSubmitResponseMessage(msg.getHeader());
		responseMessage.setMsgId(new MsgId());
		responseMessage.setResult(0);
		ctx.channel().writeAndFlush(responseMessage);
		
	}

	@Override
	protected boolean needHandleLongMessage(CmppSubmitRequestMessage msg) {
		return true;
	}

	@Override
	protected LongMessageFrame generateFrame(CmppSubmitRequestMessage msg) {
		LongMessageFrame frame = new LongMessageFrame();
		frame.setTppid(msg.getTppid());
		frame.setTpudhi(msg.getTpudhi());
		frame.setMsgfmt(msg.getMsgfmt());
		frame.setMsgContentBytes(msg.getMsgContentBytes());
		frame.setMsgLength((short)msg.getMsgLength());
		return frame;
	}

	@Override
	protected String generateFrameKey(CmppSubmitRequestMessage msg) {
		return StringUtils.join(msg.getDestterminalId(), "|");
	}

	@Override
	protected CmppSubmitRequestMessage generateMessage(CmppSubmitRequestMessage t, LongMessageFrame frame)throws Exception {
		CmppSubmitRequestMessage requestMessage = t.clone();
		requestMessage.setPknumber(frame.getPknumber());
		requestMessage.setPktotal(frame.getPktotal());
		requestMessage.setTppid(frame.getTppid());
		requestMessage.setTpudhi(frame.getTpudhi());
		requestMessage.setMsgfmt(frame.getMsgfmt());
		requestMessage.setMsgContentBytes(frame.getMsgContentBytes());
		requestMessage.setMsgLength((short)frame.getMsgLength());
		
		if(frame.getPknumber()!=1){
			requestMessage.getHeader().setSequenceId(DefaultSequenceNumberUtil.getSequenceNo());
		}
		return requestMessage;
	}

	@Override
	protected SmsMessage getSmsMessage(CmppSubmitRequestMessage t) {
		
		return t.getMsg();
	}

	@Override
	protected void resetMessageContent(CmppSubmitRequestMessage t, SmsMessage content) {
		t.setMsg(content);
	}

}
