//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.25 at 05:48:09 PM CEST 
//


package es.rickyepoderi.wbxml.bind.wvcsp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientID",
    "functions",
    "allFunctions"
})
@XmlRootElement(name = "Service-Response")
public class ServiceResponse {

    @XmlElement(name = "ClientID", required = true)
    protected ClientID clientID;
    @XmlElement(name = "Functions")
    protected Functions functions;
    @XmlElement(name = "AllFunctions")
    protected AllFunctions allFunctions;

    /**
     * Gets the value of the clientID property.
     * 
     * @return
     *     possible object is
     *     {@link ClientID }
     *     
     */
    public ClientID getClientID() {
        return clientID;
    }

    /**
     * Sets the value of the clientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientID }
     *     
     */
    public void setClientID(ClientID value) {
        this.clientID = value;
    }

    /**
     * Gets the value of the functions property.
     * 
     * @return
     *     possible object is
     *     {@link Functions }
     *     
     */
    public Functions getFunctions() {
        return functions;
    }

    /**
     * Sets the value of the functions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Functions }
     *     
     */
    public void setFunctions(Functions value) {
        this.functions = value;
    }

    /**
     * Gets the value of the allFunctions property.
     * 
     * @return
     *     possible object is
     *     {@link AllFunctions }
     *     
     */
    public AllFunctions getAllFunctions() {
        return allFunctions;
    }

    /**
     * Sets the value of the allFunctions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllFunctions }
     *     
     */
    public void setAllFunctions(AllFunctions value) {
        this.allFunctions = value;
    }

}
