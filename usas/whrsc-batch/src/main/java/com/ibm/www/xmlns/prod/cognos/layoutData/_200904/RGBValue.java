/**
 * RGBValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Defines an RGB Color
 */
public class RGBValue  implements java.io.Serializable {
    private int red;

    private int green;

    private int blue;

    /* Represents the alpha value of the color from 0.0 (transparent)
     * to 1.0 (opaque). Default is 1.0 if undefined */
    private java.lang.Double alpha;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public RGBValue() {
    }

    public RGBValue(
           int red,
           int green,
           int blue,
           java.lang.Double alpha,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.red = red;
           this.green = green;
           this.blue = blue;
           this.alpha = alpha;
           this.extension = extension;
    }


    /**
     * Gets the red value for this RGBValue.
     * 
     * @return red
     */
    public int getRed() {
        return red;
    }


    /**
     * Sets the red value for this RGBValue.
     * 
     * @param red
     */
    public void setRed(int red) {
        this.red = red;
    }


    /**
     * Gets the green value for this RGBValue.
     * 
     * @return green
     */
    public int getGreen() {
        return green;
    }


    /**
     * Sets the green value for this RGBValue.
     * 
     * @param green
     */
    public void setGreen(int green) {
        this.green = green;
    }


    /**
     * Gets the blue value for this RGBValue.
     * 
     * @return blue
     */
    public int getBlue() {
        return blue;
    }


    /**
     * Sets the blue value for this RGBValue.
     * 
     * @param blue
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }


    /**
     * Gets the alpha value for this RGBValue.
     * 
     * @return alpha   * Represents the alpha value of the color from 0.0 (transparent)
     * to 1.0 (opaque). Default is 1.0 if undefined
     */
    public java.lang.Double getAlpha() {
        return alpha;
    }


    /**
     * Sets the alpha value for this RGBValue.
     * 
     * @param alpha   * Represents the alpha value of the color from 0.0 (transparent)
     * to 1.0 (opaque). Default is 1.0 if undefined
     */
    public void setAlpha(java.lang.Double alpha) {
        this.alpha = alpha;
    }


    /**
     * Gets the extension value for this RGBValue.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this RGBValue.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RGBValue)) return false;
        RGBValue other = (RGBValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.red == other.getRed() &&
            this.green == other.getGreen() &&
            this.blue == other.getBlue() &&
            ((this.alpha==null && other.getAlpha()==null) || 
             (this.alpha!=null &&
              this.alpha.equals(other.getAlpha()))) &&
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
        _hashCode += getRed();
        _hashCode += getGreen();
        _hashCode += getBlue();
        if (getAlpha() != null) {
            _hashCode += getAlpha().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RGBValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RGBValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("red");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Red"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("green");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Green"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Blue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alpha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Alpha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
