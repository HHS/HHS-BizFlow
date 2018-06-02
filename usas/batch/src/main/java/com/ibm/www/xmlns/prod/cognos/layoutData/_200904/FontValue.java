/**
 * FontValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Defines a font
 */
public class FontValue  implements java.io.Serializable {
    private java.lang.String family;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue size;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.FontStyle fontStyle;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public FontValue() {
    }

    public FontValue(
           java.lang.String family,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue size,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.FontStyle fontStyle,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.family = family;
           this.size = size;
           this.fontStyle = fontStyle;
           this.extension = extension;
    }


    /**
     * Gets the family value for this FontValue.
     * 
     * @return family
     */
    public java.lang.String getFamily() {
        return family;
    }


    /**
     * Sets the family value for this FontValue.
     * 
     * @param family
     */
    public void setFamily(java.lang.String family) {
        this.family = family;
    }


    /**
     * Gets the size value for this FontValue.
     * 
     * @return size
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue getSize() {
        return size;
    }


    /**
     * Sets the size value for this FontValue.
     * 
     * @param size
     */
    public void setSize(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue size) {
        this.size = size;
    }


    /**
     * Gets the fontStyle value for this FontValue.
     * 
     * @return fontStyle
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.FontStyle getFontStyle() {
        return fontStyle;
    }


    /**
     * Sets the fontStyle value for this FontValue.
     * 
     * @param fontStyle
     */
    public void setFontStyle(com.ibm.www.xmlns.prod.cognos.layoutData._200904.FontStyle fontStyle) {
        this.fontStyle = fontStyle;
    }


    /**
     * Gets the extension value for this FontValue.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this FontValue.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FontValue)) return false;
        FontValue other = (FontValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.family==null && other.getFamily()==null) || 
             (this.family!=null &&
              this.family.equals(other.getFamily()))) &&
            ((this.size==null && other.getSize()==null) || 
             (this.size!=null &&
              this.size.equals(other.getSize()))) &&
            ((this.fontStyle==null && other.getFontStyle()==null) || 
             (this.fontStyle!=null &&
              this.fontStyle.equals(other.getFontStyle()))) &&
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
        if (getFamily() != null) {
            _hashCode += getFamily().hashCode();
        }
        if (getSize() != null) {
            _hashCode += getSize().hashCode();
        }
        if (getFontStyle() != null) {
            _hashCode += getFontStyle().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FontValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FontValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("family");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "family"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SizeValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fontStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "fontStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FontStyle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
