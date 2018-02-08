/**
 * CCSPromptFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class CCSPromptFault  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    /* A descriptive message of the the error that occured */
    private java.lang.String message1;

    private java.lang.String promptID;

    /* A URL to provide HTML prompting */
    private java.lang.String url;

    private java.lang.Object extension;

    public CCSPromptFault() {
    }

    public CCSPromptFault(
           java.lang.String message1,
           java.lang.String promptID,
           java.lang.String url,
           java.lang.Object extension) {
        this.message1 = message1;
        this.promptID = promptID;
        this.url = url;
        this.extension = extension;
    }


    /**
     * Gets the message1 value for this CCSPromptFault.
     * 
     * @return message1   * A descriptive message of the the error that occured
     */
    public java.lang.String getMessage1() {
        return message1;
    }


    /**
     * Sets the message1 value for this CCSPromptFault.
     * 
     * @param message1   * A descriptive message of the the error that occured
     */
    public void setMessage1(java.lang.String message1) {
        this.message1 = message1;
    }


    /**
     * Gets the promptID value for this CCSPromptFault.
     * 
     * @return promptID
     */
    public java.lang.String getPromptID() {
        return promptID;
    }


    /**
     * Sets the promptID value for this CCSPromptFault.
     * 
     * @param promptID
     */
    public void setPromptID(java.lang.String promptID) {
        this.promptID = promptID;
    }


    /**
     * Gets the url value for this CCSPromptFault.
     * 
     * @return url   * A URL to provide HTML prompting
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this CCSPromptFault.
     * 
     * @param url   * A URL to provide HTML prompting
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the extension value for this CCSPromptFault.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CCSPromptFault.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CCSPromptFault)) return false;
        CCSPromptFault other = (CCSPromptFault) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.message1==null && other.getMessage1()==null) || 
             (this.message1!=null &&
              this.message1.equals(other.getMessage1()))) &&
            ((this.promptID==null && other.getPromptID()==null) || 
             (this.promptID!=null &&
              this.promptID.equals(other.getPromptID()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
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
        if (getMessage1() != null) {
            _hashCode += getMessage1().hashCode();
        }
        if (getPromptID() != null) {
            _hashCode += getPromptID().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CCSPromptFault.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promptID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "promptID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "url"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    @Override
	public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
