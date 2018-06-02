/**
 * ValueElementType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.ccs.auth.types._1;

public class ValueElementType  implements java.io.Serializable {
    private java.lang.String actualValue;

    private com.cognos.developer.schemas.ccs.auth.types._1.MissingValueType missingValue;

    private java.lang.Object[] extension;

    public ValueElementType() {
    }

    public ValueElementType(
           java.lang.String actualValue,
           com.cognos.developer.schemas.ccs.auth.types._1.MissingValueType missingValue,
           java.lang.Object[] extension) {
           this.actualValue = actualValue;
           this.missingValue = missingValue;
           this.extension = extension;
    }


    /**
     * Gets the actualValue value for this ValueElementType.
     * 
     * @return actualValue
     */
    public java.lang.String getActualValue() {
        return actualValue;
    }


    /**
     * Sets the actualValue value for this ValueElementType.
     * 
     * @param actualValue
     */
    public void setActualValue(java.lang.String actualValue) {
        this.actualValue = actualValue;
    }


    /**
     * Gets the missingValue value for this ValueElementType.
     * 
     * @return missingValue
     */
    public com.cognos.developer.schemas.ccs.auth.types._1.MissingValueType getMissingValue() {
        return missingValue;
    }


    /**
     * Sets the missingValue value for this ValueElementType.
     * 
     * @param missingValue
     */
    public void setMissingValue(com.cognos.developer.schemas.ccs.auth.types._1.MissingValueType missingValue) {
        this.missingValue = missingValue;
    }


    /**
     * Gets the extension value for this ValueElementType.
     * 
     * @return extension
     */
    public java.lang.Object[] getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this ValueElementType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object[] extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValueElementType)) return false;
        ValueElementType other = (ValueElementType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.actualValue==null && other.getActualValue()==null) || 
             (this.actualValue!=null &&
              this.actualValue.equals(other.getActualValue()))) &&
            ((this.missingValue==null && other.getMissingValue()==null) || 
             (this.missingValue!=null &&
              this.missingValue.equals(other.getMissingValue()))) &&
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
        if (getActualValue() != null) {
            _hashCode += getActualValue().hashCode();
        }
        if (getMissingValue() != null) {
            _hashCode += getMissingValue().hashCode();
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
        new org.apache.axis.description.TypeDesc(ValueElementType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "ValueElementType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "actualValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("missingValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "missingValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "MissingValueType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
