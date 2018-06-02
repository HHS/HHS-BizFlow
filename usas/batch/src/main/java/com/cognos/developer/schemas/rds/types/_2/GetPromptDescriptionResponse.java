/**
 * GetPromptDescriptionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class GetPromptDescriptionResponse  implements java.io.Serializable {
    /* Prompt Items on this page */
    private com.cognos.developer.schemas.rds.types._2.PItemArray prompts;

    /* Used for subsequent requests, such as getting the next page
     * or search and select prompts */
    private java.lang.String conversationID;

    private java.lang.Object extension;

    public GetPromptDescriptionResponse() {
    }

    public GetPromptDescriptionResponse(
           com.cognos.developer.schemas.rds.types._2.PItemArray prompts,
           java.lang.String conversationID,
           java.lang.Object extension) {
           this.prompts = prompts;
           this.conversationID = conversationID;
           this.extension = extension;
    }


    /**
     * Gets the prompts value for this GetPromptDescriptionResponse.
     * 
     * @return prompts   * Prompt Items on this page
     */
    public com.cognos.developer.schemas.rds.types._2.PItemArray getPrompts() {
        return prompts;
    }


    /**
     * Sets the prompts value for this GetPromptDescriptionResponse.
     * 
     * @param prompts   * Prompt Items on this page
     */
    public void setPrompts(com.cognos.developer.schemas.rds.types._2.PItemArray prompts) {
        this.prompts = prompts;
    }


    /**
     * Gets the conversationID value for this GetPromptDescriptionResponse.
     * 
     * @return conversationID   * Used for subsequent requests, such as getting the next page
     * or search and select prompts
     */
    public java.lang.String getConversationID() {
        return conversationID;
    }


    /**
     * Sets the conversationID value for this GetPromptDescriptionResponse.
     * 
     * @param conversationID   * Used for subsequent requests, such as getting the next page
     * or search and select prompts
     */
    public void setConversationID(java.lang.String conversationID) {
        this.conversationID = conversationID;
    }


    /**
     * Gets the extension value for this GetPromptDescriptionResponse.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetPromptDescriptionResponse.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetPromptDescriptionResponse)) return false;
        GetPromptDescriptionResponse other = (GetPromptDescriptionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.prompts==null && other.getPrompts()==null) || 
             (this.prompts!=null &&
              this.prompts.equals(other.getPrompts()))) &&
            ((this.conversationID==null && other.getConversationID()==null) || 
             (this.conversationID!=null &&
              this.conversationID.equals(other.getConversationID()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    @Override
	public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPrompts() != null) {
            _hashCode += getPrompts().hashCode();
        }
        if (getConversationID() != null) {
            _hashCode += getConversationID().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPromptDescriptionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptDescriptionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prompts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "prompts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PItemArray"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conversationID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "conversationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
