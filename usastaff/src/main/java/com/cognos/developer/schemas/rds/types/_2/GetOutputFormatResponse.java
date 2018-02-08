/**
 * GetOutputFormatResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class GetOutputFormatResponse  implements java.io.Serializable {
    private java.lang.String outputFormatURL;

    private java.lang.String xmlData;

    private java.lang.Object extension;

    public GetOutputFormatResponse() {
    }

    public GetOutputFormatResponse(
           java.lang.String outputFormatURL,
           java.lang.String xmlData,
           java.lang.Object extension) {
           this.outputFormatURL = outputFormatURL;
           this.xmlData = xmlData;
           this.extension = extension;
    }


    /**
     * Gets the outputFormatURL value for this GetOutputFormatResponse.
     * 
     * @return outputFormatURL
     */
    public java.lang.String getOutputFormatURL() {
        return outputFormatURL;
    }


    /**
     * Sets the outputFormatURL value for this GetOutputFormatResponse.
     * 
     * @param outputFormatURL
     */
    public void setOutputFormatURL(java.lang.String outputFormatURL) {
        this.outputFormatURL = outputFormatURL;
    }


    /**
     * Gets the xmlData value for this GetOutputFormatResponse.
     * 
     * @return xmlData
     */
    public java.lang.String getXmlData() {
        return xmlData;
    }


    /**
     * Sets the xmlData value for this GetOutputFormatResponse.
     * 
     * @param xmlData
     */
    public void setXmlData(java.lang.String xmlData) {
        this.xmlData = xmlData;
    }


    /**
     * Gets the extension value for this GetOutputFormatResponse.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetOutputFormatResponse.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOutputFormatResponse)) return false;
        GetOutputFormatResponse other = (GetOutputFormatResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.outputFormatURL==null && other.getOutputFormatURL()==null) || 
             (this.outputFormatURL!=null &&
              this.outputFormatURL.equals(other.getOutputFormatURL()))) &&
            ((this.xmlData==null && other.getXmlData()==null) || 
             (this.xmlData!=null &&
              this.xmlData.equals(other.getXmlData()))) &&
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
        if (getOutputFormatURL() != null) {
            _hashCode += getOutputFormatURL().hashCode();
        }
        if (getXmlData() != null) {
            _hashCode += getXmlData().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOutputFormatResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputFormatURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "outputFormatURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "xmlData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
