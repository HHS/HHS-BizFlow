/**
 * SimplePValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class SimplePValue  implements java.io.Serializable {
    private boolean inclusive;

    private java.lang.String useValue;

    private java.lang.String displayValue;

    public SimplePValue() {
    }

    public SimplePValue(
           boolean inclusive,
           java.lang.String useValue,
           java.lang.String displayValue) {
           this.inclusive = inclusive;
           this.useValue = useValue;
           this.displayValue = displayValue;
    }


    /**
     * Gets the inclusive value for this SimplePValue.
     * 
     * @return inclusive
     */
    public boolean isInclusive() {
        return inclusive;
    }


    /**
     * Sets the inclusive value for this SimplePValue.
     * 
     * @param inclusive
     */
    public void setInclusive(boolean inclusive) {
        this.inclusive = inclusive;
    }


    /**
     * Gets the useValue value for this SimplePValue.
     * 
     * @return useValue
     */
    public java.lang.String getUseValue() {
        return useValue;
    }


    /**
     * Sets the useValue value for this SimplePValue.
     * 
     * @param useValue
     */
    public void setUseValue(java.lang.String useValue) {
        this.useValue = useValue;
    }


    /**
     * Gets the displayValue value for this SimplePValue.
     * 
     * @return displayValue
     */
    public java.lang.String getDisplayValue() {
        return displayValue;
    }


    /**
     * Sets the displayValue value for this SimplePValue.
     * 
     * @param displayValue
     */
    public void setDisplayValue(java.lang.String displayValue) {
        this.displayValue = displayValue;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SimplePValue)) return false;
        SimplePValue other = (SimplePValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.inclusive == other.isInclusive() &&
            ((this.useValue==null && other.getUseValue()==null) || 
             (this.useValue!=null &&
              this.useValue.equals(other.getUseValue()))) &&
            ((this.displayValue==null && other.getDisplayValue()==null) || 
             (this.displayValue!=null &&
              this.displayValue.equals(other.getDisplayValue())));
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
        _hashCode += (isInclusive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUseValue() != null) {
            _hashCode += getUseValue().hashCode();
        }
        if (getDisplayValue() != null) {
            _hashCode += getDisplayValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SimplePValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SimplePValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inclusive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "inclusive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "BooleanValue"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "useValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "displayValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
