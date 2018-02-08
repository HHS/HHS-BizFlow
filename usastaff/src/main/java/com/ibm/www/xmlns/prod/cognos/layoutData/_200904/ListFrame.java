/**
 * ListFrame.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class ListFrame  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String[] style;

    /* List Column Title */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell[] colTitle;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] header;

    /* If true, page header is rendered after the overall List Header */
    private java.lang.Boolean headerAfterOverall;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.GroupSection group;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] footer;

    /* If available, the summary text for this item */
    private java.lang.String summaryText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public ListFrame() {
    }

    public ListFrame(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String[] style,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell[] colTitle,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] header,
           java.lang.Boolean headerAfterOverall,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.GroupSection group,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] footer,
           java.lang.String summaryText,
           java.lang.String annURL,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.colTitle = colTitle;
           this.header = header;
           this.headerAfterOverall = headerAfterOverall;
           this.group = group;
           this.footer = footer;
           this.summaryText = summaryText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this ListFrame.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ListFrame.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this ListFrame.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this ListFrame.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this ListFrame.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this ListFrame.
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
     * Gets the colTitle value for this ListFrame.
     * 
     * @return colTitle   * List Column Title
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell[] getColTitle() {
        return colTitle;
    }


    /**
     * Sets the colTitle value for this ListFrame.
     * 
     * @param colTitle   * List Column Title
     */
    public void setColTitle(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell[] colTitle) {
        this.colTitle = colTitle;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell getColTitle(int i) {
        return this.colTitle[i];
    }

    public void setColTitle(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell _value) {
        this.colTitle[i] = _value;
    }


    /**
     * Gets the header value for this ListFrame.
     * 
     * @return header
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] getHeader() {
        return header;
    }


    /**
     * Sets the header value for this ListFrame.
     * 
     * @param header
     */
    public void setHeader(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] header) {
        this.header = header;
    }


    /**
     * Gets the headerAfterOverall value for this ListFrame.
     * 
     * @return headerAfterOverall   * If true, page header is rendered after the overall List Header
     */
    public java.lang.Boolean getHeaderAfterOverall() {
        return headerAfterOverall;
    }


    /**
     * Sets the headerAfterOverall value for this ListFrame.
     * 
     * @param headerAfterOverall   * If true, page header is rendered after the overall List Header
     */
    public void setHeaderAfterOverall(java.lang.Boolean headerAfterOverall) {
        this.headerAfterOverall = headerAfterOverall;
    }


    /**
     * Gets the group value for this ListFrame.
     * 
     * @return group
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.GroupSection getGroup() {
        return group;
    }


    /**
     * Sets the group value for this ListFrame.
     * 
     * @param group
     */
    public void setGroup(com.ibm.www.xmlns.prod.cognos.layoutData._200904.GroupSection group) {
        this.group = group;
    }


    /**
     * Gets the footer value for this ListFrame.
     * 
     * @return footer
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] getFooter() {
        return footer;
    }


    /**
     * Sets the footer value for this ListFrame.
     * 
     * @param footer
     */
    public void setFooter(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] footer) {
        this.footer = footer;
    }


    /**
     * Gets the summaryText value for this ListFrame.
     * 
     * @return summaryText   * If available, the summary text for this item
     */
    public java.lang.String getSummaryText() {
        return summaryText;
    }


    /**
     * Sets the summaryText value for this ListFrame.
     * 
     * @param summaryText   * If available, the summary text for this item
     */
    public void setSummaryText(java.lang.String summaryText) {
        this.summaryText = summaryText;
    }


    /**
     * Gets the annURL value for this ListFrame.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this ListFrame.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this ListFrame.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this ListFrame.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListFrame)) return false;
        ListFrame other = (ListFrame) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ref==null && other.getRef()==null) || 
             (this.ref!=null &&
              this.ref.equals(other.getRef()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              java.util.Arrays.equals(this.style, other.getStyle()))) &&
            ((this.colTitle==null && other.getColTitle()==null) || 
             (this.colTitle!=null &&
              java.util.Arrays.equals(this.colTitle, other.getColTitle()))) &&
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              java.util.Arrays.equals(this.header, other.getHeader()))) &&
            ((this.headerAfterOverall==null && other.getHeaderAfterOverall()==null) || 
             (this.headerAfterOverall!=null &&
              this.headerAfterOverall.equals(other.getHeaderAfterOverall()))) &&
            ((this.group==null && other.getGroup()==null) || 
             (this.group!=null &&
              this.group.equals(other.getGroup()))) &&
            ((this.footer==null && other.getFooter()==null) || 
             (this.footer!=null &&
              java.util.Arrays.equals(this.footer, other.getFooter()))) &&
            ((this.summaryText==null && other.getSummaryText()==null) || 
             (this.summaryText!=null &&
              this.summaryText.equals(other.getSummaryText()))) &&
            ((this.annURL==null && other.getAnnURL()==null) || 
             (this.annURL!=null &&
              this.annURL.equals(other.getAnnURL()))) &&
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
        if (getColTitle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getColTitle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getColTitle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHeader() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHeader());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHeader(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHeaderAfterOverall() != null) {
            _hashCode += getHeaderAfterOverall().hashCode();
        }
        if (getGroup() != null) {
            _hashCode += getGroup().hashCode();
        }
        if (getFooter() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFooter());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFooter(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSummaryText() != null) {
            _hashCode += getSummaryText().hashCode();
        }
        if (getAnnURL() != null) {
            _hashCode += getAnnURL().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListFrame.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ListFrame"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("colTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "colTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Cell"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("header");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "header"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">header"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("headerAfterOverall");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "headerAfterOverall"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "group"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "GroupSection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("footer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "footer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">footer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "summaryText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "annURL"));
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
