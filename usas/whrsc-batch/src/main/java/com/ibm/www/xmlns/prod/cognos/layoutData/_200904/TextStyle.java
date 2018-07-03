/**
 * TextStyle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Defines text flow styles
 */
public class TextStyle  implements java.io.Serializable {
    /* True if wrapping is enabled */
    private java.lang.Boolean wrapping;

    /* Text Direction */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextDirectionEnum direction;

    /* Writing mode (used for some Asian language styles) */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.WritingModeEnum writingMode;

    /* ? */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextStyleBiDirectional biDirectional;

    /* Justification style */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.JustificationEnum justification;

    /* ? */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue kashidaSpace;

    /* True if word breaking is enabled */
    private java.lang.Boolean wordBreak;

    /* Style of word breaking */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.WordBreakEnum wordBreakStyle;

    /* Strict line breaking for japaneese */
    private java.lang.Boolean strictLineBreaking;

    public TextStyle() {
    }

    public TextStyle(
           java.lang.Boolean wrapping,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextDirectionEnum direction,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.WritingModeEnum writingMode,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextStyleBiDirectional biDirectional,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.JustificationEnum justification,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue kashidaSpace,
           java.lang.Boolean wordBreak,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.WordBreakEnum wordBreakStyle,
           java.lang.Boolean strictLineBreaking) {
           this.wrapping = wrapping;
           this.direction = direction;
           this.writingMode = writingMode;
           this.biDirectional = biDirectional;
           this.justification = justification;
           this.kashidaSpace = kashidaSpace;
           this.wordBreak = wordBreak;
           this.wordBreakStyle = wordBreakStyle;
           this.strictLineBreaking = strictLineBreaking;
    }


    /**
     * Gets the wrapping value for this TextStyle.
     * 
     * @return wrapping   * True if wrapping is enabled
     */
    public java.lang.Boolean getWrapping() {
        return wrapping;
    }


    /**
     * Sets the wrapping value for this TextStyle.
     * 
     * @param wrapping   * True if wrapping is enabled
     */
    public void setWrapping(java.lang.Boolean wrapping) {
        this.wrapping = wrapping;
    }


    /**
     * Gets the direction value for this TextStyle.
     * 
     * @return direction   * Text Direction
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextDirectionEnum getDirection() {
        return direction;
    }


    /**
     * Sets the direction value for this TextStyle.
     * 
     * @param direction   * Text Direction
     */
    public void setDirection(com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextDirectionEnum direction) {
        this.direction = direction;
    }


    /**
     * Gets the writingMode value for this TextStyle.
     * 
     * @return writingMode   * Writing mode (used for some Asian language styles)
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.WritingModeEnum getWritingMode() {
        return writingMode;
    }


    /**
     * Sets the writingMode value for this TextStyle.
     * 
     * @param writingMode   * Writing mode (used for some Asian language styles)
     */
    public void setWritingMode(com.ibm.www.xmlns.prod.cognos.layoutData._200904.WritingModeEnum writingMode) {
        this.writingMode = writingMode;
    }


    /**
     * Gets the biDirectional value for this TextStyle.
     * 
     * @return biDirectional   * ?
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextStyleBiDirectional getBiDirectional() {
        return biDirectional;
    }


    /**
     * Sets the biDirectional value for this TextStyle.
     * 
     * @param biDirectional   * ?
     */
    public void setBiDirectional(com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextStyleBiDirectional biDirectional) {
        this.biDirectional = biDirectional;
    }


    /**
     * Gets the justification value for this TextStyle.
     * 
     * @return justification   * Justification style
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.JustificationEnum getJustification() {
        return justification;
    }


    /**
     * Sets the justification value for this TextStyle.
     * 
     * @param justification   * Justification style
     */
    public void setJustification(com.ibm.www.xmlns.prod.cognos.layoutData._200904.JustificationEnum justification) {
        this.justification = justification;
    }


    /**
     * Gets the kashidaSpace value for this TextStyle.
     * 
     * @return kashidaSpace   * ?
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue getKashidaSpace() {
        return kashidaSpace;
    }


    /**
     * Sets the kashidaSpace value for this TextStyle.
     * 
     * @param kashidaSpace   * ?
     */
    public void setKashidaSpace(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue kashidaSpace) {
        this.kashidaSpace = kashidaSpace;
    }


    /**
     * Gets the wordBreak value for this TextStyle.
     * 
     * @return wordBreak   * True if word breaking is enabled
     */
    public java.lang.Boolean getWordBreak() {
        return wordBreak;
    }


    /**
     * Sets the wordBreak value for this TextStyle.
     * 
     * @param wordBreak   * True if word breaking is enabled
     */
    public void setWordBreak(java.lang.Boolean wordBreak) {
        this.wordBreak = wordBreak;
    }


    /**
     * Gets the wordBreakStyle value for this TextStyle.
     * 
     * @return wordBreakStyle   * Style of word breaking
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.WordBreakEnum getWordBreakStyle() {
        return wordBreakStyle;
    }


    /**
     * Sets the wordBreakStyle value for this TextStyle.
     * 
     * @param wordBreakStyle   * Style of word breaking
     */
    public void setWordBreakStyle(com.ibm.www.xmlns.prod.cognos.layoutData._200904.WordBreakEnum wordBreakStyle) {
        this.wordBreakStyle = wordBreakStyle;
    }


    /**
     * Gets the strictLineBreaking value for this TextStyle.
     * 
     * @return strictLineBreaking   * Strict line breaking for japaneese
     */
    public java.lang.Boolean getStrictLineBreaking() {
        return strictLineBreaking;
    }


    /**
     * Sets the strictLineBreaking value for this TextStyle.
     * 
     * @param strictLineBreaking   * Strict line breaking for japaneese
     */
    public void setStrictLineBreaking(java.lang.Boolean strictLineBreaking) {
        this.strictLineBreaking = strictLineBreaking;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TextStyle)) return false;
        TextStyle other = (TextStyle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.wrapping==null && other.getWrapping()==null) || 
             (this.wrapping!=null &&
              this.wrapping.equals(other.getWrapping()))) &&
            ((this.direction==null && other.getDirection()==null) || 
             (this.direction!=null &&
              this.direction.equals(other.getDirection()))) &&
            ((this.writingMode==null && other.getWritingMode()==null) || 
             (this.writingMode!=null &&
              this.writingMode.equals(other.getWritingMode()))) &&
            ((this.biDirectional==null && other.getBiDirectional()==null) || 
             (this.biDirectional!=null &&
              this.biDirectional.equals(other.getBiDirectional()))) &&
            ((this.justification==null && other.getJustification()==null) || 
             (this.justification!=null &&
              this.justification.equals(other.getJustification()))) &&
            ((this.kashidaSpace==null && other.getKashidaSpace()==null) || 
             (this.kashidaSpace!=null &&
              this.kashidaSpace.equals(other.getKashidaSpace()))) &&
            ((this.wordBreak==null && other.getWordBreak()==null) || 
             (this.wordBreak!=null &&
              this.wordBreak.equals(other.getWordBreak()))) &&
            ((this.wordBreakStyle==null && other.getWordBreakStyle()==null) || 
             (this.wordBreakStyle!=null &&
              this.wordBreakStyle.equals(other.getWordBreakStyle()))) &&
            ((this.strictLineBreaking==null && other.getStrictLineBreaking()==null) || 
             (this.strictLineBreaking!=null &&
              this.strictLineBreaking.equals(other.getStrictLineBreaking())));
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
        if (getWrapping() != null) {
            _hashCode += getWrapping().hashCode();
        }
        if (getDirection() != null) {
            _hashCode += getDirection().hashCode();
        }
        if (getWritingMode() != null) {
            _hashCode += getWritingMode().hashCode();
        }
        if (getBiDirectional() != null) {
            _hashCode += getBiDirectional().hashCode();
        }
        if (getJustification() != null) {
            _hashCode += getJustification().hashCode();
        }
        if (getKashidaSpace() != null) {
            _hashCode += getKashidaSpace().hashCode();
        }
        if (getWordBreak() != null) {
            _hashCode += getWordBreak().hashCode();
        }
        if (getWordBreakStyle() != null) {
            _hashCode += getWordBreakStyle().hashCode();
        }
        if (getStrictLineBreaking() != null) {
            _hashCode += getStrictLineBreaking().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TextStyle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextStyle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wrapping");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "wrapping"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "direction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextDirectionEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("writingMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "writingMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "WritingModeEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("biDirectional");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "biDirectional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">TextStyle>biDirectional"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("justification");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "justification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "JustificationEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kashidaSpace");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "kashidaSpace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SizeValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wordBreak");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "wordBreak"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wordBreakStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "wordBreakStyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "WordBreakEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strictLineBreaking");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "strictLineBreaking"));
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
