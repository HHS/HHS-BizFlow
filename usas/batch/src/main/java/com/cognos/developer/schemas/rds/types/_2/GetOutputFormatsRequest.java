/**
 * GetOutputFormatsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class GetOutputFormatsRequest  implements java.io.Serializable {
    private java.lang.String sourceID;

    private com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType;

    private java.lang.Object extension;

    public GetOutputFormatsRequest() {
    }

    public GetOutputFormatsRequest(
           java.lang.String sourceID,
           com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType,
           java.lang.Object extension) {
           this.sourceID = sourceID;
           this.sourceType = sourceType;
           this.extension = extension;
    }


    /**
     * Gets the sourceID value for this GetOutputFormatsRequest.
     * 
     * @return sourceID
     */
    public java.lang.String getSourceID() {
        return sourceID;
    }


    /**
     * Sets the sourceID value for this GetOutputFormatsRequest.
     * 
     * @param sourceID
     */
    public void setSourceID(java.lang.String sourceID) {
        this.sourceID = sourceID;
    }


    /**
     * Gets the sourceType value for this GetOutputFormatsRequest.
     * 
     * @return sourceType
     */
    public com.cognos.developer.schemas.rds.types._2.SourceTypeEnum getSourceType() {
        return sourceType;
    }


    /**
     * Sets the sourceType value for this GetOutputFormatsRequest.
     * 
     * @param sourceType
     */
    public void setSourceType(com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType) {
        this.sourceType = sourceType;
    }


    /**
     * Gets the extension value for this GetOutputFormatsRequest.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetOutputFormatsRequest.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOutputFormatsRequest)) return false;
        GetOutputFormatsRequest other = (GetOutputFormatsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sourceID==null && other.getSourceID()==null) || 
             (this.sourceID!=null &&
              this.sourceID.equals(other.getSourceID()))) &&
            ((this.sourceType==null && other.getSourceType()==null) || 
             (this.sourceType!=null &&
              this.sourceType.equals(other.getSourceType()))) &&
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
        if (getSourceID() != null) {
            _hashCode += getSourceID().hashCode();
        }
        if (getSourceType() != null) {
            _hashCode += getSourceType().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOutputFormatsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "sourceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "sourceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SourceTypeEnum"));
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
