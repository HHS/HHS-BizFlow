/**
 * PromptAnswersResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class PromptAnswersResponseType  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue[] promptValues;

    private java.lang.Object extension;

    public PromptAnswersResponseType() {
    }

    public PromptAnswersResponseType(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue[] promptValues,
           java.lang.Object extension) {
           this.promptValues = promptValues;
           this.extension = extension;
    }


    /**
     * Gets the promptValues value for this PromptAnswersResponseType.
     * 
     * @return promptValues
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue[] getPromptValues() {
        return promptValues;
    }


    /**
     * Sets the promptValues value for this PromptAnswersResponseType.
     * 
     * @param promptValues
     */
    public void setPromptValues(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue[] promptValues) {
        this.promptValues = promptValues;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue getPromptValues(int i) {
        return this.promptValues[i];
    }

    public void setPromptValues(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue _value) {
        this.promptValues[i] = _value;
    }


    /**
     * Gets the extension value for this PromptAnswersResponseType.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PromptAnswersResponseType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PromptAnswersResponseType)) return false;
        PromptAnswersResponseType other = (PromptAnswersResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.promptValues==null && other.getPromptValues()==null) || 
             (this.promptValues!=null &&
              java.util.Arrays.equals(this.promptValues, other.getPromptValues()))) &&
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
        if (getPromptValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPromptValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPromptValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PromptAnswersResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promptValues");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "promptValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "extension"));
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
