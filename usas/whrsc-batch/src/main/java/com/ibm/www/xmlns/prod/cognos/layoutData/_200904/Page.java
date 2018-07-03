/**
 * Page.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Definition of a page.
 */
public class Page  implements java.io.Serializable {
    private java.lang.Boolean canFinish;

    private java.lang.Boolean canNext;

    private java.lang.Boolean canBack;

    private java.lang.String id;

    /* Location Reference */
    private java.lang.String ref;

    private java.lang.String[] style;

    /* Page header, containing elements in the header. */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray header;

    /* Page body containing elements in the body. */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray body;

    /* Page footer containing elements in the footer */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray footer;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public Page() {
    }

    public Page(
           java.lang.Boolean canFinish,
           java.lang.Boolean canNext,
           java.lang.Boolean canBack,
           java.lang.String id,
           java.lang.String ref,
           java.lang.String[] style,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray header,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray body,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray footer,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.canFinish = canFinish;
           this.canNext = canNext;
           this.canBack = canBack;
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.header = header;
           this.body = body;
           this.footer = footer;
           this.extension = extension;
    }


    /**
     * Gets the canFinish value for this Page.
     * 
     * @return canFinish
     */
    public java.lang.Boolean getCanFinish() {
        return canFinish;
    }


    /**
     * Sets the canFinish value for this Page.
     * 
     * @param canFinish
     */
    public void setCanFinish(java.lang.Boolean canFinish) {
        this.canFinish = canFinish;
    }


    /**
     * Gets the canNext value for this Page.
     * 
     * @return canNext
     */
    public java.lang.Boolean getCanNext() {
        return canNext;
    }


    /**
     * Sets the canNext value for this Page.
     * 
     * @param canNext
     */
    public void setCanNext(java.lang.Boolean canNext) {
        this.canNext = canNext;
    }


    /**
     * Gets the canBack value for this Page.
     * 
     * @return canBack
     */
    public java.lang.Boolean getCanBack() {
        return canBack;
    }


    /**
     * Sets the canBack value for this Page.
     * 
     * @param canBack
     */
    public void setCanBack(java.lang.Boolean canBack) {
        this.canBack = canBack;
    }


    /**
     * Gets the id value for this Page.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Page.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this Page.
     * 
     * @return ref   * Location Reference
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this Page.
     * 
     * @param ref   * Location Reference
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this Page.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this Page.
     * 
     * @param style
     */
    public void setStyle(java.lang.String[] style) {
        this.style = style;
    }

    public java.lang.String getStyle(int i) {
        return this.style[i];
    }

    public void setStyle(int i, java.lang.String _value) {
        this.style[i] = _value;
    }


    /**
     * Gets the header value for this Page.
     * 
     * @return header   * Page header, containing elements in the header.
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray getHeader() {
        return header;
    }


    /**
     * Sets the header value for this Page.
     * 
     * @param header   * Page header, containing elements in the header.
     */
    public void setHeader(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray header) {
        this.header = header;
    }


    /**
     * Gets the body value for this Page.
     * 
     * @return body   * Page body containing elements in the body.
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray getBody() {
        return body;
    }


    /**
     * Sets the body value for this Page.
     * 
     * @param body   * Page body containing elements in the body.
     */
    public void setBody(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray body) {
        this.body = body;
    }


    /**
     * Gets the footer value for this Page.
     * 
     * @return footer   * Page footer containing elements in the footer
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray getFooter() {
        return footer;
    }


    /**
     * Sets the footer value for this Page.
     * 
     * @param footer   * Page footer containing elements in the footer
     */
    public void setFooter(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray footer) {
        this.footer = footer;
    }


    /**
     * Gets the extension value for this Page.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this Page.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Page)) return false;
        Page other = (Page) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.canFinish==null && other.getCanFinish()==null) || 
             (this.canFinish!=null &&
              this.canFinish.equals(other.getCanFinish()))) &&
            ((this.canNext==null && other.getCanNext()==null) || 
             (this.canNext!=null &&
              this.canNext.equals(other.getCanNext()))) &&
            ((this.canBack==null && other.getCanBack()==null) || 
             (this.canBack!=null &&
              this.canBack.equals(other.getCanBack()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ref==null && other.getRef()==null) || 
             (this.ref!=null &&
              this.ref.equals(other.getRef()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              java.util.Arrays.equals(this.style, other.getStyle()))) &&
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              this.header.equals(other.getHeader()))) &&
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody()))) &&
            ((this.footer==null && other.getFooter()==null) || 
             (this.footer!=null &&
              this.footer.equals(other.getFooter()))) &&
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
        if (getCanFinish() != null) {
            _hashCode += getCanFinish().hashCode();
        }
        if (getCanNext() != null) {
            _hashCode += getCanNext().hashCode();
        }
        if (getCanBack() != null) {
            _hashCode += getCanBack().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getRef() != null) {
            _hashCode += getRef().hashCode();
        }
        if (getStyle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStyle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStyle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHeader() != null) {
            _hashCode += getHeader().hashCode();
        }
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        if (getFooter() != null) {
            _hashCode += getFooter().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Page.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Page"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canFinish");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "canFinish"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canNext");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "canNext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canBack");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "canBack"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ref");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("header");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "header"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ReportElementArray"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "body"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ReportElementArray"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("footer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "footer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ReportElementArray"));
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
