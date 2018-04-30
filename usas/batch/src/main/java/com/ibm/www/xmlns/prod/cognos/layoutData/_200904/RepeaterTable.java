/**
 * RepeaterTable.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class RepeaterTable  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String[] style;

    /* Specifies whether a table is laid out horizontally(true) or
     * vertically(false). */
    private java.lang.Boolean horizontalLayout;

    /* The number of repeaterTable elements per row (if specified). */
    private java.lang.Integer horizontalSize;

    /* The number of repeaterTable elements per column (if specified). */
    private java.lang.Integer verticalSize;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] row;

    private java.lang.String summaryText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public RepeaterTable() {
    }

    public RepeaterTable(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String[] style,
           java.lang.Boolean horizontalLayout,
           java.lang.Integer horizontalSize,
           java.lang.Integer verticalSize,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] row,
           java.lang.String summaryText,
           java.lang.String annURL,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.horizontalLayout = horizontalLayout;
           this.horizontalSize = horizontalSize;
           this.verticalSize = verticalSize;
           this.row = row;
           this.summaryText = summaryText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this RepeaterTable.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this RepeaterTable.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this RepeaterTable.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this RepeaterTable.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this RepeaterTable.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this RepeaterTable.
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
     * Gets the horizontalLayout value for this RepeaterTable.
     * 
     * @return horizontalLayout   * Specifies whether a table is laid out horizontally(true) or
     * vertically(false).
     */
    public java.lang.Boolean getHorizontalLayout() {
        return horizontalLayout;
    }


    /**
     * Sets the horizontalLayout value for this RepeaterTable.
     * 
     * @param horizontalLayout   * Specifies whether a table is laid out horizontally(true) or
     * vertically(false).
     */
    public void setHorizontalLayout(java.lang.Boolean horizontalLayout) {
        this.horizontalLayout = horizontalLayout;
    }


    /**
     * Gets the horizontalSize value for this RepeaterTable.
     * 
     * @return horizontalSize   * The number of repeaterTable elements per row (if specified).
     */
    public java.lang.Integer getHorizontalSize() {
        return horizontalSize;
    }


    /**
     * Sets the horizontalSize value for this RepeaterTable.
     * 
     * @param horizontalSize   * The number of repeaterTable elements per row (if specified).
     */
    public void setHorizontalSize(java.lang.Integer horizontalSize) {
        this.horizontalSize = horizontalSize;
    }


    /**
     * Gets the verticalSize value for this RepeaterTable.
     * 
     * @return verticalSize   * The number of repeaterTable elements per column (if specified).
     */
    public java.lang.Integer getVerticalSize() {
        return verticalSize;
    }


    /**
     * Sets the verticalSize value for this RepeaterTable.
     * 
     * @param verticalSize   * The number of repeaterTable elements per column (if specified).
     */
    public void setVerticalSize(java.lang.Integer verticalSize) {
        this.verticalSize = verticalSize;
    }


    /**
     * Gets the row value for this RepeaterTable.
     * 
     * @return row
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] getRow() {
        return row;
    }


    /**
     * Sets the row value for this RepeaterTable.
     * 
     * @param row
     */
    public void setRow(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] row) {
        this.row = row;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row getRow(int i) {
        return this.row[i];
    }

    public void setRow(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row _value) {
        this.row[i] = _value;
    }


    /**
     * Gets the summaryText value for this RepeaterTable.
     * 
     * @return summaryText
     */
    public java.lang.String getSummaryText() {
        return summaryText;
    }


    /**
     * Sets the summaryText value for this RepeaterTable.
     * 
     * @param summaryText
     */
    public void setSummaryText(java.lang.String summaryText) {
        this.summaryText = summaryText;
    }


    /**
     * Gets the annURL value for this RepeaterTable.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this RepeaterTable.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this RepeaterTable.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this RepeaterTable.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RepeaterTable)) return false;
        RepeaterTable other = (RepeaterTable) obj;
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
            ((this.horizontalLayout==null && other.getHorizontalLayout()==null) || 
             (this.horizontalLayout!=null &&
              this.horizontalLayout.equals(other.getHorizontalLayout()))) &&
            ((this.horizontalSize==null && other.getHorizontalSize()==null) || 
             (this.horizontalSize!=null &&
              this.horizontalSize.equals(other.getHorizontalSize()))) &&
            ((this.verticalSize==null && other.getVerticalSize()==null) || 
             (this.verticalSize!=null &&
              this.verticalSize.equals(other.getVerticalSize()))) &&
            ((this.row==null && other.getRow()==null) || 
             (this.row!=null &&
              java.util.Arrays.equals(this.row, other.getRow()))) &&
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
        if (getHorizontalLayout() != null) {
            _hashCode += getHorizontalLayout().hashCode();
        }
        if (getHorizontalSize() != null) {
            _hashCode += getHorizontalSize().hashCode();
        }
        if (getVerticalSize() != null) {
            _hashCode += getVerticalSize().hashCode();
        }
        if (getRow() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRow());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRow(), i);
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
        new org.apache.axis.description.TypeDesc(RepeaterTable.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RepeaterTable"));
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
        elemField.setFieldName("horizontalLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "horizontalLayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horizontalSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "horizontalSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verticalSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "verticalSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("row");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "row"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Row"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
