/**
 * PromptSelectionsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class PromptSelectionsType  implements java.io.Serializable {
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType[] sval;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType[] rval;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public PromptSelectionsType() {
    }

    public PromptSelectionsType(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType[] sval,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType[] rval,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.sval = sval;
           this.rval = rval;
           this.extension = extension;
    }


    /**
     * Gets the sval value for this PromptSelectionsType.
     * 
     * @return sval
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType[] getSval() {
        return sval;
    }


    /**
     * Sets the sval value for this PromptSelectionsType.
     * 
     * @param sval
     */
    public void setSval(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType[] sval) {
        this.sval = sval;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType getSval(int i) {
        return this.sval[i];
    }

    public void setSval(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType _value) {
        this.sval[i] = _value;
    }


    /**
     * Gets the rval value for this PromptSelectionsType.
     * 
     * @return rval
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType[] getRval() {
        return rval;
    }


    /**
     * Sets the rval value for this PromptSelectionsType.
     * 
     * @param rval
     */
    public void setRval(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType[] rval) {
        this.rval = rval;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType getRval(int i) {
        return this.rval[i];
    }

    public void setRval(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType _value) {
        this.rval[i] = _value;
    }


    /**
     * Gets the extension value for this PromptSelectionsType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PromptSelectionsType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PromptSelectionsType)) return false;
        PromptSelectionsType other = (PromptSelectionsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sval==null && other.getSval()==null) || 
             (this.sval!=null &&
              java.util.Arrays.equals(this.sval, other.getSval()))) &&
            ((this.rval==null && other.getRval()==null) || 
             (this.rval!=null &&
              java.util.Arrays.equals(this.rval, other.getRval()))) &&
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
        if (getSval() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSval());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSval(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRval() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRval());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRval(), i);
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
        new org.apache.axis.description.TypeDesc(PromptSelectionsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PromptSelectionsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "sval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "sval"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "rval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "rval"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">extension"));
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
