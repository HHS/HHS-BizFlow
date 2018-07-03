/**
 * RichTextElmt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * This element is a placeholder for all rich text elements choices
 * that can existing in a RichText area.
 */
public class RichTextElmt  implements java.io.Serializable {
    /* TextFrane */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame txt;

    /* A div container */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Div div;

    /* a span container */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Span span;

    /* a list container (ordered or unordered). */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtList rtList;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTable table;

    /* An image element */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image img;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public RichTextElmt() {
    }

    public RichTextElmt(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame txt,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Div div,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Span span,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtList rtList,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTable table,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image img,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.txt = txt;
           this.div = div;
           this.span = span;
           this.rtList = rtList;
           this.table = table;
           this.img = img;
           this.extension = extension;
    }


    /**
     * Gets the txt value for this RichTextElmt.
     * 
     * @return txt   * TextFrane
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame getTxt() {
        return txt;
    }


    /**
     * Sets the txt value for this RichTextElmt.
     * 
     * @param txt   * TextFrane
     */
    public void setTxt(com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame txt) {
        this.txt = txt;
    }


    /**
     * Gets the div value for this RichTextElmt.
     * 
     * @return div   * A div container
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Div getDiv() {
        return div;
    }


    /**
     * Sets the div value for this RichTextElmt.
     * 
     * @param div   * A div container
     */
    public void setDiv(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Div div) {
        this.div = div;
    }


    /**
     * Gets the span value for this RichTextElmt.
     * 
     * @return span   * a span container
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Span getSpan() {
        return span;
    }


    /**
     * Sets the span value for this RichTextElmt.
     * 
     * @param span   * a span container
     */
    public void setSpan(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Span span) {
        this.span = span;
    }


    /**
     * Gets the rtList value for this RichTextElmt.
     * 
     * @return rtList   * a list container (ordered or unordered).
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtList getRtList() {
        return rtList;
    }


    /**
     * Sets the rtList value for this RichTextElmt.
     * 
     * @param rtList   * a list container (ordered or unordered).
     */
    public void setRtList(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtList rtList) {
        this.rtList = rtList;
    }


    /**
     * Gets the table value for this RichTextElmt.
     * 
     * @return table
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTable getTable() {
        return table;
    }


    /**
     * Sets the table value for this RichTextElmt.
     * 
     * @param table
     */
    public void setTable(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTable table) {
        this.table = table;
    }


    /**
     * Gets the img value for this RichTextElmt.
     * 
     * @return img   * An image element
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image getImg() {
        return img;
    }


    /**
     * Sets the img value for this RichTextElmt.
     * 
     * @param img   * An image element
     */
    public void setImg(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image img) {
        this.img = img;
    }


    /**
     * Gets the extension value for this RichTextElmt.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this RichTextElmt.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
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
            ((this.table==null && other.getTable()==null) || 
             (this.table!=null &&
              this.table.equals(other.getTable()))) &&
            ((this.img==null && other.getImg()==null) || 
             (this.img!=null &&
              this.img.equals(other.getImg()))) &&
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
        if (getTable() != null) {
            _hashCode += getTable().hashCode();
        }
        if (getImg() != null) {
            _hashCode += getImg().hashCode();
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RichTextElmt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextFrame"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("div");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "div"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Div"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("span");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "span"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Span"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "rtList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtList"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("table");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "table"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtTable"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("img");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "img"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Image"));
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
