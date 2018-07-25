/**
 * StyleGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;


/**
 * Style Definition
 */
public class StyleGroup  implements java.io.Serializable {
    private java.lang.String name;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.FontValue font;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextStyle textStyle;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.BoxStyle boxStyle;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue fgColor;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue bgColor;

    private java.lang.String bgImageURL;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HAlignEnum hAlign;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VAlignEnum vAlign;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroupExtension extension;

    public StyleGroup() {
    }

    public StyleGroup(
           java.lang.String name,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.FontValue font,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextStyle textStyle,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.BoxStyle boxStyle,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue fgColor,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue bgColor,
           java.lang.String bgImageURL,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HAlignEnum hAlign,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VAlignEnum vAlign,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroupExtension extension) {
           this.name = name;
           this.font = font;
           this.textStyle = textStyle;
           this.boxStyle = boxStyle;
           this.fgColor = fgColor;
           this.bgColor = bgColor;
           this.bgImageURL = bgImageURL;
           this.hAlign = hAlign;
           this.vAlign = vAlign;
           this.extension = extension;
    }


    /**
     * Gets the name value for this StyleGroup.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this StyleGroup.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the font value for this StyleGroup.
     * 
     * @return font
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.FontValue getFont() {
        return font;
    }


    /**
     * Sets the font value for this StyleGroup.
     * 
     * @param font
     */
    public void setFont(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.FontValue font) {
        this.font = font;
    }


    /**
     * Gets the textStyle value for this StyleGroup.
     * 
     * @return textStyle
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextStyle getTextStyle() {
        return textStyle;
    }


    /**
     * Sets the textStyle value for this StyleGroup.
     * 
     * @param textStyle
     */
    public void setTextStyle(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextStyle textStyle) {
        this.textStyle = textStyle;
    }


    /**
     * Gets the boxStyle value for this StyleGroup.
     * 
     * @return boxStyle
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.BoxStyle getBoxStyle() {
        return boxStyle;
    }


    /**
     * Sets the boxStyle value for this StyleGroup.
     * 
     * @param boxStyle
     */
    public void setBoxStyle(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.BoxStyle boxStyle) {
        this.boxStyle = boxStyle;
    }


    /**
     * Gets the fgColor value for this StyleGroup.
     * 
     * @return fgColor
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue getFgColor() {
        return fgColor;
    }


    /**
     * Sets the fgColor value for this StyleGroup.
     * 
     * @param fgColor
     */
    public void setFgColor(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue fgColor) {
        this.fgColor = fgColor;
    }


    /**
     * Gets the bgColor value for this StyleGroup.
     * 
     * @return bgColor
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue getBgColor() {
        return bgColor;
    }


    /**
     * Sets the bgColor value for this StyleGroup.
     * 
     * @param bgColor
     */
    public void setBgColor(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue bgColor) {
        this.bgColor = bgColor;
    }


    /**
     * Gets the bgImageURL value for this StyleGroup.
     * 
     * @return bgImageURL
     */
    public java.lang.String getBgImageURL() {
        return bgImageURL;
    }


    /**
     * Sets the bgImageURL value for this StyleGroup.
     * 
     * @param bgImageURL
     */
    public void setBgImageURL(java.lang.String bgImageURL) {
        this.bgImageURL = bgImageURL;
    }


    /**
     * Gets the hAlign value for this StyleGroup.
     * 
     * @return hAlign
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HAlignEnum getHAlign() {
        return hAlign;
    }


    /**
     * Sets the hAlign value for this StyleGroup.
     * 
     * @param hAlign
     */
    public void setHAlign(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HAlignEnum hAlign) {
        this.hAlign = hAlign;
    }


    /**
     * Gets the vAlign value for this StyleGroup.
     * 
     * @return vAlign
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VAlignEnum getVAlign() {
        return vAlign;
    }


    /**
     * Sets the vAlign value for this StyleGroup.
     * 
     * @param vAlign
     */
    public void setVAlign(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VAlignEnum vAlign) {
        this.vAlign = vAlign;
    }


    /**
     * Gets the extension value for this StyleGroup.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroupExtension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this StyleGroup.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroupExtension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StyleGroup)) return false;
        StyleGroup other = (StyleGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.font==null && other.getFont()==null) || 
             (this.font!=null &&
              this.font.equals(other.getFont()))) &&
            ((this.textStyle==null && other.getTextStyle()==null) || 
             (this.textStyle!=null &&
              this.textStyle.equals(other.getTextStyle()))) &&
            ((this.boxStyle==null && other.getBoxStyle()==null) || 
             (this.boxStyle!=null &&
              this.boxStyle.equals(other.getBoxStyle()))) &&
            ((this.fgColor==null && other.getFgColor()==null) || 
             (this.fgColor!=null &&
              this.fgColor.equals(other.getFgColor()))) &&
            ((this.bgColor==null && other.getBgColor()==null) || 
             (this.bgColor!=null &&
              this.bgColor.equals(other.getBgColor()))) &&
            ((this.bgImageURL==null && other.getBgImageURL()==null) || 
             (this.bgImageURL!=null &&
              this.bgImageURL.equals(other.getBgImageURL()))) &&
            ((this.hAlign==null && other.getHAlign()==null) || 
             (this.hAlign!=null &&
              this.hAlign.equals(other.getHAlign()))) &&
            ((this.vAlign==null && other.getVAlign()==null) || 
             (this.vAlign!=null &&
              this.vAlign.equals(other.getVAlign()))) &&
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getFont() != null) {
            _hashCode += getFont().hashCode();
        }
        if (getTextStyle() != null) {
            _hashCode += getTextStyle().hashCode();
        }
        if (getBoxStyle() != null) {
            _hashCode += getBoxStyle().hashCode();
        }
        if (getFgColor() != null) {
            _hashCode += getFgColor().hashCode();
        }
        if (getBgColor() != null) {
            _hashCode += getBgColor().hashCode();
        }
        if (getBgImageURL() != null) {
            _hashCode += getBgImageURL().hashCode();
        }
        if (getHAlign() != null) {
            _hashCode += getHAlign().hashCode();
        }
        if (getVAlign() != null) {
            _hashCode += getVAlign().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StyleGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "StyleGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("font");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "font"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "FontValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("textStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "textStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextStyle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boxStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "boxStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "BoxStyle"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fgColor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "fgColor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RGBValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bgColor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "bgColor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RGBValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bgImageURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "bgImageURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HAlign");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "hAlign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "HAlignEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VAlign");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "vAlign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "VAlignEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">StyleGroup>extension"));
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
