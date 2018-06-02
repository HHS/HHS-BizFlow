/**
 * PromptAnswersType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class PromptAnswersType  implements java.io.Serializable {
    private java.lang.String parameter1;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue[] advanced;

    private java.lang.Object extension;

    public PromptAnswersType() {
    }

    public PromptAnswersType(
           java.lang.String parameter1,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue[] advanced,
           java.lang.Object extension) {
           this.parameter1 = parameter1;
           this.advanced = advanced;
           this.extension = extension;
    }


    /**
     * Gets the parameter1 value for this PromptAnswersType.
     * 
     * @return parameter1
     */
    public java.lang.String getParameter1() {
        return parameter1;
    }


    /**
     * Sets the parameter1 value for this PromptAnswersType.
     * 
     * @param parameter1
     */
    public void setParameter1(java.lang.String parameter1) {
        this.parameter1 = parameter1;
    }


    /**
     * Gets the advanced value for this PromptAnswersType.
     * 
     * @return advanced
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue[] getAdvanced() {
        return advanced;
    }


    /**
     * Sets the advanced value for this PromptAnswersType.
     * 
     * @param advanced
     */
    public void setAdvanced(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue[] advanced) {
        this.advanced = advanced;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue getAdvanced(int i) {
        return this.advanced[i];
    }

    public void setAdvanced(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue _value) {
        this.advanced[i] = _value;
    }


    /**
     * Gets the extension value for this PromptAnswersType.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PromptAnswersType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PromptAnswersType)) return false;
        PromptAnswersType other = (PromptAnswersType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.parameter1==null && other.getParameter1()==null) || 
             (this.parameter1!=null &&
              this.parameter1.equals(other.getParameter1()))) &&
            ((this.advanced==null && other.getAdvanced()==null) || 
             (this.advanced!=null &&
              java.util.Arrays.equals(this.advanced, other.getAdvanced()))) &&
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
        if (getParameter1() != null) {
            _hashCode += getParameter1().hashCode();
        }
        if (getAdvanced() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdvanced());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdvanced(), i);
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
        new org.apache.axis.description.TypeDesc(PromptAnswersType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameter1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Parameter1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("advanced");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "advanced"));
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
