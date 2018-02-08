/**
 * Page1_PageType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Page1_PageType  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_HeaderType header;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_BodyType body;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_FooterType footer;

    public Page1_PageType() {
    }

    public Page1_PageType(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_HeaderType header,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_BodyType body,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_FooterType footer) {
           this.header = header;
           this.body = body;
           this.footer = footer;
    }


    /**
     * Gets the header value for this Page1_PageType.
     * 
     * @return header
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_HeaderType getHeader() {
        return header;
    }


    /**
     * Sets the header value for this Page1_PageType.
     * 
     * @param header
     */
    public void setHeader(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_HeaderType header) {
        this.header = header;
    }


    /**
     * Gets the body value for this Page1_PageType.
     * 
     * @return body
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_BodyType getBody() {
        return body;
    }


    /**
     * Sets the body value for this Page1_PageType.
     * 
     * @param body
     */
    public void setBody(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_BodyType body) {
        this.body = body;
    }


    /**
     * Gets the footer value for this Page1_PageType.
     * 
     * @return footer
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_FooterType getFooter() {
        return footer;
    }


    /**
     * Sets the footer value for this Page1_PageType.
     * 
     * @param footer
     */
    public void setFooter(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_FooterType footer) {
        this.footer = footer;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Page1_PageType)) return false;
        Page1_PageType other = (Page1_PageType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              this.header.equals(other.getHeader()))) &&
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody()))) &&
            ((this.footer==null && other.getFooter()==null) || 
             (this.footer!=null &&
              this.footer.equals(other.getFooter())));
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
        if (getHeader() != null) {
            _hashCode += getHeader().hashCode();
        }
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        if (getFooter() != null) {
            _hashCode += getFooter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Page1_PageType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_PageType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("header");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "header"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_HeaderType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "body"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_BodyType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("footer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "footer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_FooterType"));
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
