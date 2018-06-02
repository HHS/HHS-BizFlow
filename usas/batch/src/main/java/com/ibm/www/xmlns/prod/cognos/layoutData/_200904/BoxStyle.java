/**
 * BoxStyle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Defines Box styles (border, size, margins and padding)
 */
public class BoxStyle  implements java.io.Serializable {
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue height;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue width;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.MarginStyle margin;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PaddingStyle padding;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.BorderStyle border;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public BoxStyle() {
    }

    public BoxStyle(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue height,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue width,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.MarginStyle margin,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PaddingStyle padding,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.BorderStyle border,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.height = height;
           this.width = width;
           this.margin = margin;
           this.padding = padding;
           this.border = border;
           this.extension = extension;
    }


    /**
     * Gets the height value for this BoxStyle.
     * 
     * @return height
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue getHeight() {
        return height;
    }


    /**
     * Sets the height value for this BoxStyle.
     * 
     * @param height
     */
    public void setHeight(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue height) {
        this.height = height;
    }


    /**
     * Gets the width value for this BoxStyle.
     * 
     * @return width
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue getWidth() {
        return width;
    }


    /**
     * Sets the width value for this BoxStyle.
     * 
     * @param width
     */
    public void setWidth(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue width) {
        this.width = width;
    }


    /**
     * Gets the margin value for this BoxStyle.
     * 
     * @return margin
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.MarginStyle getMargin() {
        return margin;
    }


    /**
     * Sets the margin value for this BoxStyle.
     * 
     * @param margin
     */
    public void setMargin(com.ibm.www.xmlns.prod.cognos.layoutData._200904.MarginStyle margin) {
        this.margin = margin;
    }


    /**
     * Gets the padding value for this BoxStyle.
     * 
     * @return padding
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PaddingStyle getPadding() {
        return padding;
    }


    /**
     * Sets the padding value for this BoxStyle.
     * 
     * @param padding
     */
    public void setPadding(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PaddingStyle padding) {
        this.padding = padding;
    }


    /**
     * Gets the border value for this BoxStyle.
     * 
     * @return border
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.BorderStyle getBorder() {
        return border;
    }


    /**
     * Sets the border value for this BoxStyle.
     * 
     * @param border
     */
    public void setBorder(com.ibm.www.xmlns.prod.cognos.layoutData._200904.BorderStyle border) {
        this.border = border;
    }


    /**
     * Gets the extension value for this BoxStyle.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this BoxStyle.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BoxStyle)) return false;
        BoxStyle other = (BoxStyle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.height==null && other.getHeight()==null) || 
             (this.height!=null &&
              this.height.equals(other.getHeight()))) &&
            ((this.width==null && other.getWidth()==null) || 
             (this.width!=null &&
              this.width.equals(other.getWidth()))) &&
            ((this.margin==null && other.getMargin()==null) || 
             (this.margin!=null &&
              this.margin.equals(other.getMargin()))) &&
            ((this.padding==null && other.getPadding()==null) || 
             (this.padding!=null &&
              this.padding.equals(other.getPadding()))) &&
            ((this.border==null && other.getBorder()==null) || 
             (this.border!=null &&
              this.border.equals(other.getBorder()))) &&
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
        if (getHeight() != null) {
            _hashCode += getHeight().hashCode();
        }
        if (getWidth() != null) {
            _hashCode += getWidth().hashCode();
        }
        if (getMargin() != null) {
            _hashCode += getMargin().hashCode();
        }
        if (getPadding() != null) {
            _hashCode += getPadding().hashCode();
        }
        if (getBorder() != null) {
            _hashCode += getBorder().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BoxStyle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BoxStyle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("height");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "height"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SizeValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("width");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "width"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SizeValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("margin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "margin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "MarginStyle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("padding");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "padding"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PaddingStyle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("border");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "border"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BorderStyle"));
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
