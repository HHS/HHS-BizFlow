/**
 * SimplePromptValueType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class SimplePromptValueType  implements java.io.Serializable {
    /* Use value of the prompt */
    private java.lang.String use;

    /* Display value of the prompt, if available */
    private java.lang.String disp;

    /* True if it represents a null use value */
    private java.lang.Boolean nullUse;

    /* True if it represents a null display value */
    private java.lang.Boolean nullDisp;

    public SimplePromptValueType() {
    }

    public SimplePromptValueType(
           java.lang.String use,
           java.lang.String disp,
           java.lang.Boolean nullUse,
           java.lang.Boolean nullDisp) {
           this.use = use;
           this.disp = disp;
           this.nullUse = nullUse;
           this.nullDisp = nullDisp;
    }


    /**
     * Gets the use value for this SimplePromptValueType.
     * 
     * @return use   * Use value of the prompt
     */
    public java.lang.String getUse() {
        return use;
    }


    /**
     * Sets the use value for this SimplePromptValueType.
     * 
     * @param use   * Use value of the prompt
     */
    public void setUse(java.lang.String use) {
        this.use = use;
    }


    /**
     * Gets the disp value for this SimplePromptValueType.
     * 
     * @return disp   * Display value of the prompt, if available
     */
    public java.lang.String getDisp() {
        return disp;
    }


    /**
     * Sets the disp value for this SimplePromptValueType.
     * 
     * @param disp   * Display value of the prompt, if available
     */
    public void setDisp(java.lang.String disp) {
        this.disp = disp;
    }


    /**
     * Gets the nullUse value for this SimplePromptValueType.
     * 
     * @return nullUse   * True if it represents a null use value
     */
    public java.lang.Boolean getNullUse() {
        return nullUse;
    }


    /**
     * Sets the nullUse value for this SimplePromptValueType.
     * 
     * @param nullUse   * True if it represents a null use value
     */
    public void setNullUse(java.lang.Boolean nullUse) {
        this.nullUse = nullUse;
    }


    /**
     * Gets the nullDisp value for this SimplePromptValueType.
     * 
     * @return nullDisp   * True if it represents a null display value
     */
    public java.lang.Boolean getNullDisp() {
        return nullDisp;
    }


    /**
     * Sets the nullDisp value for this SimplePromptValueType.
     * 
     * @param nullDisp   * True if it represents a null display value
     */
    public void setNullDisp(java.lang.Boolean nullDisp) {
        this.nullDisp = nullDisp;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SimplePromptValueType)) return false;
        SimplePromptValueType other = (SimplePromptValueType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.use==null && other.getUse()==null) || 
             (this.use!=null &&
              this.use.equals(other.getUse()))) &&
            ((this.disp==null && other.getDisp()==null) || 
             (this.disp!=null &&
              this.disp.equals(other.getDisp()))) &&
            ((this.nullUse==null && other.getNullUse()==null) || 
             (this.nullUse!=null &&
              this.nullUse.equals(other.getNullUse()))) &&
            ((this.nullDisp==null && other.getNullDisp()==null) || 
             (this.nullDisp!=null &&
              this.nullDisp.equals(other.getNullDisp())));
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
        if (getUse() != null) {
            _hashCode += getUse().hashCode();
        }
        if (getDisp() != null) {
            _hashCode += getDisp().hashCode();
        }
        if (getNullUse() != null) {
            _hashCode += getNullUse().hashCode();
        }
        if (getNullDisp() != null) {
            _hashCode += getNullDisp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SimplePromptValueType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SimplePromptValueType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("use");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "use"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "disp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nullUse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "nullUse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nullDisp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "nullDisp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
