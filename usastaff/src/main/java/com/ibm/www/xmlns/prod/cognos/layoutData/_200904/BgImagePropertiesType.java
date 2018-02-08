/**
 * BgImagePropertiesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class BgImagePropertiesType  implements java.io.Serializable {
    /* Position of the background image. The valid values of the string
     * are the same as in CSS, i.e. top left, top center */
    private java.lang.String position;

    /* If fixed, the background image does not scroll with the page.
     * If scroll (default), then it scrolls with the page. */
    private java.lang.String attachment;

    /* Specifies how the background image should be repeated */
    private java.lang.String repeat;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public BgImagePropertiesType() {
    }

    public BgImagePropertiesType(
           java.lang.String position,
           java.lang.String attachment,
           java.lang.String repeat,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.position = position;
           this.attachment = attachment;
           this.repeat = repeat;
           this.extension = extension;
    }


    /**
     * Gets the position value for this BgImagePropertiesType.
     * 
     * @return position   * Position of the background image. The valid values of the string
     * are the same as in CSS, i.e. top left, top center
     */
    public java.lang.String getPosition() {
        return position;
    }


    /**
     * Sets the position value for this BgImagePropertiesType.
     * 
     * @param position   * Position of the background image. The valid values of the string
     * are the same as in CSS, i.e. top left, top center
     */
    public void setPosition(java.lang.String position) {
        this.position = position;
    }


    /**
     * Gets the attachment value for this BgImagePropertiesType.
     * 
     * @return attachment   * If fixed, the background image does not scroll with the page.
     * If scroll (default), then it scrolls with the page.
     */
    public java.lang.String getAttachment() {
        return attachment;
    }


    /**
     * Sets the attachment value for this BgImagePropertiesType.
     * 
     * @param attachment   * If fixed, the background image does not scroll with the page.
     * If scroll (default), then it scrolls with the page.
     */
    public void setAttachment(java.lang.String attachment) {
        this.attachment = attachment;
    }


    /**
     * Gets the repeat value for this BgImagePropertiesType.
     * 
     * @return repeat   * Specifies how the background image should be repeated
     */
    public java.lang.String getRepeat() {
        return repeat;
    }


    /**
     * Sets the repeat value for this BgImagePropertiesType.
     * 
     * @param repeat   * Specifies how the background image should be repeated
     */
    public void setRepeat(java.lang.String repeat) {
        this.repeat = repeat;
    }


    /**
     * Gets the extension value for this BgImagePropertiesType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this BgImagePropertiesType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BgImagePropertiesType)) return false;
        BgImagePropertiesType other = (BgImagePropertiesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.position==null && other.getPosition()==null) || 
             (this.position!=null &&
              this.position.equals(other.getPosition()))) &&
            ((this.attachment==null && other.getAttachment()==null) || 
             (this.attachment!=null &&
              this.attachment.equals(other.getAttachment()))) &&
            ((this.repeat==null && other.getRepeat()==null) || 
             (this.repeat!=null &&
              this.repeat.equals(other.getRepeat()))) &&
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
        if (getPosition() != null) {
            _hashCode += getPosition().hashCode();
        }
        if (getAttachment() != null) {
            _hashCode += getAttachment().hashCode();
        }
        if (getRepeat() != null) {
            _hashCode += getRepeat().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BgImagePropertiesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "bgImagePropertiesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("position");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "position"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "attachment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repeat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "repeat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
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
