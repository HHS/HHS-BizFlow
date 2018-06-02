/**
 * FontStyle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Defines font styles
 */
public class FontStyle  implements java.io.Serializable {
    private java.lang.Boolean bold;

    private java.lang.Boolean italics;

    private java.lang.Boolean underline;

    private java.lang.Boolean overline;

    private java.lang.Boolean strikethrough;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public FontStyle() {
    }

    public FontStyle(
           java.lang.Boolean bold,
           java.lang.Boolean italics,
           java.lang.Boolean underline,
           java.lang.Boolean overline,
           java.lang.Boolean strikethrough,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.bold = bold;
           this.italics = italics;
           this.underline = underline;
           this.overline = overline;
           this.strikethrough = strikethrough;
           this.extension = extension;
    }


    /**
     * Gets the bold value for this FontStyle.
     * 
     * @return bold
     */
    public java.lang.Boolean getBold() {
        return bold;
    }


    /**
     * Sets the bold value for this FontStyle.
     * 
     * @param bold
     */
    public void setBold(java.lang.Boolean bold) {
        this.bold = bold;
    }


    /**
     * Gets the italics value for this FontStyle.
     * 
     * @return italics
     */
    public java.lang.Boolean getItalics() {
        return italics;
    }


    /**
     * Sets the italics value for this FontStyle.
     * 
     * @param italics
     */
    public void setItalics(java.lang.Boolean italics) {
        this.italics = italics;
    }


    /**
     * Gets the underline value for this FontStyle.
     * 
     * @return underline
     */
    public java.lang.Boolean getUnderline() {
        return underline;
    }


    /**
     * Sets the underline value for this FontStyle.
     * 
     * @param underline
     */
    public void setUnderline(java.lang.Boolean underline) {
        this.underline = underline;
    }


    /**
     * Gets the overline value for this FontStyle.
     * 
     * @return overline
     */
    public java.lang.Boolean getOverline() {
        return overline;
    }


    /**
     * Sets the overline value for this FontStyle.
     * 
     * @param overline
     */
    public void setOverline(java.lang.Boolean overline) {
        this.overline = overline;
    }


    /**
     * Gets the strikethrough value for this FontStyle.
     * 
     * @return strikethrough
     */
    public java.lang.Boolean getStrikethrough() {
        return strikethrough;
    }


    /**
     * Sets the strikethrough value for this FontStyle.
     * 
     * @param strikethrough
     */
    public void setStrikethrough(java.lang.Boolean strikethrough) {
        this.strikethrough = strikethrough;
    }


    /**
     * Gets the extension value for this FontStyle.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this FontStyle.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FontStyle)) return false;
        FontStyle other = (FontStyle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bold==null && other.getBold()==null) || 
             (this.bold!=null &&
              this.bold.equals(other.getBold()))) &&
            ((this.italics==null && other.getItalics()==null) || 
             (this.italics!=null &&
              this.italics.equals(other.getItalics()))) &&
            ((this.underline==null && other.getUnderline()==null) || 
             (this.underline!=null &&
              this.underline.equals(other.getUnderline()))) &&
            ((this.overline==null && other.getOverline()==null) || 
             (this.overline!=null &&
              this.overline.equals(other.getOverline()))) &&
            ((this.strikethrough==null && other.getStrikethrough()==null) || 
             (this.strikethrough!=null &&
              this.strikethrough.equals(other.getStrikethrough()))) &&
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
        if (getBold() != null) {
            _hashCode += getBold().hashCode();
        }
        if (getItalics() != null) {
            _hashCode += getItalics().hashCode();
        }
        if (getUnderline() != null) {
            _hashCode += getUnderline().hashCode();
        }
        if (getOverline() != null) {
            _hashCode += getOverline().hashCode();
        }
        if (getStrikethrough() != null) {
            _hashCode += getStrikethrough().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FontStyle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FontStyle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bold");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "bold"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("italics");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "italics"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("underline");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "underline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overline");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "overline"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strikethrough");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "strikethrough"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
