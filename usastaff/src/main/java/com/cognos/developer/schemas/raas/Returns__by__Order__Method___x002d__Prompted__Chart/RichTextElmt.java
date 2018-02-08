/**
 * RichTextElmt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;


/**
 * This element is a placeholder for all rich text elements choices
 * that can existing in a RichText area.
 */
public class RichTextElmt  implements java.io.Serializable {
    /* TextFrane */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame txt;

    /* A div container */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Div div;

    /* a span container */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Span span;

    /* a list container (ordered or unordered). */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RtList rtList;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension;

    public RichTextElmt() {
    }

    public RichTextElmt(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame txt,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Div div,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Span span,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RtList rtList,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
           this.txt = txt;
           this.div = div;
           this.span = span;
           this.rtList = rtList;
           this.extension = extension;
    }


    /**
     * Gets the txt value for this RichTextElmt.
     * 
     * @return txt   * TextFrane
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame getTxt() {
        return txt;
    }


    /**
     * Sets the txt value for this RichTextElmt.
     * 
     * @param txt   * TextFrane
     */
    public void setTxt(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame txt) {
        this.txt = txt;
    }


    /**
     * Gets the div value for this RichTextElmt.
     * 
     * @return div   * A div container
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Div getDiv() {
        return div;
    }


    /**
     * Sets the div value for this RichTextElmt.
     * 
     * @param div   * A div container
     */
    public void setDiv(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Div div) {
        this.div = div;
    }


    /**
     * Gets the span value for this RichTextElmt.
     * 
     * @return span   * a span container
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Span getSpan() {
        return span;
    }


    /**
     * Sets the span value for this RichTextElmt.
     * 
     * @param span   * a span container
     */
    public void setSpan(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Span span) {
        this.span = span;
    }


    /**
     * Gets the rtList value for this RichTextElmt.
     * 
     * @return rtList   * a list container (ordered or unordered).
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RtList getRtList() {
        return rtList;
    }


    /**
     * Sets the rtList value for this RichTextElmt.
     * 
     * @param rtList   * a list container (ordered or unordered).
     */
    public void setRtList(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RtList rtList) {
        this.rtList = rtList;
    }


    /**
     * Gets the extension value for this RichTextElmt.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this RichTextElmt.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RichTextElmt)) return false;
        RichTextElmt other = (RichTextElmt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.txt==null && other.getTxt()==null) || 
             (this.txt!=null &&
              this.txt.equals(other.getTxt()))) &&
            ((this.div==null && other.getDiv()==null) || 
             (this.div!=null &&
              this.div.equals(other.getDiv()))) &&
            ((this.span==null && other.getSpan()==null) || 
             (this.span!=null &&
              this.span.equals(other.getSpan()))) &&
            ((this.rtList==null && other.getRtList()==null) || 
             (this.rtList!=null &&
              this.rtList.equals(other.getRtList()))) &&
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
        if (getTxt() != null) {
            _hashCode += getTxt().hashCode();
        }
        if (getDiv() != null) {
            _hashCode += getDiv().hashCode();
        }
        if (getSpan() != null) {
            _hashCode += getSpan().hashCode();
        }
        if (getRtList() != null) {
            _hashCode += getRtList().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RichTextElmt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RichTextElmt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("div");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "div"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Div"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("span");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "span"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Span"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "rtList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RtList"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">extension"));
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
