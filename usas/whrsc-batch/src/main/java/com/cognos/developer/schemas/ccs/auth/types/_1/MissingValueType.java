/**
 * MissingValueType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.ccs.auth.types._1;

public class MissingValueType  implements java.io.Serializable {
    private java.lang.String valueType;

    private com.cognos.developer.schemas.ccs.auth.types._1.EnumerationType[] enumeration;

    private java.lang.Object[] extension;

    public MissingValueType() {
    }

    public MissingValueType(
           java.lang.String valueType,
           com.cognos.developer.schemas.ccs.auth.types._1.EnumerationType[] enumeration,
           java.lang.Object[] extension) {
           this.valueType = valueType;
           this.enumeration = enumeration;
           this.extension = extension;
    }


    /**
     * Gets the valueType value for this MissingValueType.
     * 
     * @return valueType
     */
    public java.lang.String getValueType() {
        return valueType;
    }


    /**
     * Sets the valueType value for this MissingValueType.
     * 
     * @param valueType
     */
    public void setValueType(java.lang.String valueType) {
        this.valueType = valueType;
    }


    /**
     * Gets the enumeration value for this MissingValueType.
     * 
     * @return enumeration
     */
    public com.cognos.developer.schemas.ccs.auth.types._1.EnumerationType[] getEnumeration() {
        return enumeration;
    }


    /**
     * Sets the enumeration value for this MissingValueType.
     * 
     * @param enumeration
     */
    public void setEnumeration(com.cognos.developer.schemas.ccs.auth.types._1.EnumerationType[] enumeration) {
        this.enumeration = enumeration;
    }

    public com.cognos.developer.schemas.ccs.auth.types._1.EnumerationType getEnumeration(int i) {
        return this.enumeration[i];
    }

    public void setEnumeration(int i, com.cognos.developer.schemas.ccs.auth.types._1.EnumerationType _value) {
        this.enumeration[i] = _value;
    }


    /**
     * Gets the extension value for this MissingValueType.
     * 
     * @return extension
     */
    public java.lang.Object[] getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this MissingValueType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object[] extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MissingValueType)) return false;
        MissingValueType other = (MissingValueType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.valueType==null && other.getValueType()==null) || 
             (this.valueType!=null &&
              this.valueType.equals(other.getValueType()))) &&
            ((this.enumeration==null && other.getEnumeration()==null) || 
             (this.enumeration!=null &&
              java.util.Arrays.equals(this.enumeration, other.getEnumeration()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              java.util.Arrays.equals(this.extension, other.getExtension())));
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
        if (getValueType() != null) {
            _hashCode += getValueType().hashCode();
        }
        if (getEnumeration() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEnumeration());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEnumeration(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtension() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExtension());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExtension(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MissingValueType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "MissingValueType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "valueType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enumeration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "enumeration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "enumerationType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "__ExtensionType"));
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
