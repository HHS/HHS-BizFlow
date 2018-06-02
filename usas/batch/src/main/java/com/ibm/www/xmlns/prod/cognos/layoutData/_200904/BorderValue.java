/**
 * BorderValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Defines a border style parameters
 */
public class BorderValue  implements java.io.Serializable {
    /* Border Color */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RGBValue color;

    /* Line Style */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.LineStyleEnum lineStyle;

    /* Line Width */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue width;

    public BorderValue() {
    }

    public BorderValue(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RGBValue color,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.LineStyleEnum lineStyle,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue width) {
           this.color = color;
           this.lineStyle = lineStyle;
           this.width = width;
    }


    /**
     * Gets the color value for this BorderValue.
     * 
     * @return color   * Border Color
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RGBValue getColor() {
        return color;
    }


    /**
     * Sets the color value for this BorderValue.
     * 
     * @param color   * Border Color
     */
    public void setColor(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RGBValue color) {
        this.color = color;
    }


    /**
     * Gets the lineStyle value for this BorderValue.
     * 
     * @return lineStyle   * Line Style
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LineStyleEnum getLineStyle() {
        return lineStyle;
    }


    /**
     * Sets the lineStyle value for this BorderValue.
     * 
     * @param lineStyle   * Line Style
     */
    public void setLineStyle(com.ibm.www.xmlns.prod.cognos.layoutData._200904.LineStyleEnum lineStyle) {
        this.lineStyle = lineStyle;
    }


    /**
     * Gets the width value for this BorderValue.
     * 
     * @return width   * Line Width
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue getWidth() {
        return width;
    }


    /**
     * Sets the width value for this BorderValue.
     * 
     * @param width   * Line Width
     */
    public void setWidth(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue width) {
        this.width = width;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BorderValue)) return false;
        BorderValue other = (BorderValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.color==null && other.getColor()==null) || 
             (this.color!=null &&
              this.color.equals(other.getColor()))) &&
            ((this.lineStyle==null && other.getLineStyle()==null) || 
             (this.lineStyle!=null &&
              this.lineStyle.equals(other.getLineStyle()))) &&
            ((this.width==null && other.getWidth()==null) || 
             (this.width!=null &&
              this.width.equals(other.getWidth())));
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
        if (getColor() != null) {
            _hashCode += getColor().hashCode();
        }
        if (getLineStyle() != null) {
            _hashCode += getLineStyle().hashCode();
        }
        if (getWidth() != null) {
            _hashCode += getWidth().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BorderValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BorderValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("color");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "color"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RGBValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lineStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "lineStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LineStyleEnum"));
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
