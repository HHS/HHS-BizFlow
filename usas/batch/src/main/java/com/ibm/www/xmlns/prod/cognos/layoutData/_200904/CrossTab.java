/**
 * CrossTab.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class CrossTab  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String[] style;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell corner;

    /* The top level group of column dimension values. */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn[] column;

    /* The top level group of row dimension values. */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn[] row;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] table;

    private java.lang.String summaryText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public CrossTab() {
    }

    public CrossTab(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String[] style,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell corner,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn[] column,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn[] row,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] table,
           java.lang.String summaryText,
           java.lang.String annURL,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.corner = corner;
           this.column = column;
           this.row = row;
           this.table = table;
           this.summaryText = summaryText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this CrossTab.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this CrossTab.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this CrossTab.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this CrossTab.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this CrossTab.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this CrossTab.
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
     * Gets the corner value for this CrossTab.
     * 
     * @return corner
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell getCorner() {
        return corner;
    }


    /**
     * Sets the corner value for this CrossTab.
     * 
     * @param corner
     */
    public void setCorner(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell corner) {
        this.corner = corner;
    }


    /**
     * Gets the column value for this CrossTab.
     * 
     * @return column   * The top level group of column dimension values.
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn[] getColumn() {
        return column;
    }


    /**
     * Sets the column value for this CrossTab.
     * 
     * @param column   * The top level group of column dimension values.
     */
    public void setColumn(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn[] column) {
        this.column = column;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn getColumn(int i) {
        return this.column[i];
    }

    public void setColumn(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn _value) {
        this.column[i] = _value;
    }


    /**
     * Gets the row value for this CrossTab.
     * 
     * @return row   * The top level group of row dimension values.
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn[] getRow() {
        return row;
    }


    /**
     * Sets the row value for this CrossTab.
     * 
     * @param row   * The top level group of row dimension values.
     */
    public void setRow(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn[] row) {
        this.row = row;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn getRow(int i) {
        return this.row[i];
    }

    public void setRow(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn _value) {
        this.row[i] = _value;
    }


    /**
     * Gets the table value for this CrossTab.
     * 
     * @return table
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] getTable() {
        return table;
    }


    /**
     * Sets the table value for this CrossTab.
     * 
     * @param table
     */
    public void setTable(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[] table) {
        this.table = table;
    }


    /**
     * Gets the summaryText value for this CrossTab.
     * 
     * @return summaryText
     */
    public java.lang.String getSummaryText() {
        return summaryText;
    }


    /**
     * Sets the summaryText value for this CrossTab.
     * 
     * @param summaryText
     */
    public void setSummaryText(java.lang.String summaryText) {
        this.summaryText = summaryText;
    }


    /**
     * Gets the annURL value for this CrossTab.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this CrossTab.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this CrossTab.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CrossTab.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrossTab)) return false;
        CrossTab other = (CrossTab) obj;
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
            ((this.corner==null && other.getCorner()==null) || 
             (this.corner!=null &&
              this.corner.equals(other.getCorner()))) &&
            ((this.column==null && other.getColumn()==null) || 
             (this.column!=null &&
              java.util.Arrays.equals(this.column, other.getColumn()))) &&
            ((this.row==null && other.getRow()==null) || 
             (this.row!=null &&
              java.util.Arrays.equals(this.row, other.getRow()))) &&
            ((this.table==null && other.getTable()==null) || 
             (this.table!=null &&
              java.util.Arrays.equals(this.table, other.getTable()))) &&
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
        if (getCorner() != null) {
            _hashCode += getCorner().hashCode();
        }
        if (getColumn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getColumn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getColumn(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getTable() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTable());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTable(), i);
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
        new org.apache.axis.description.TypeDesc(CrossTab.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "CrossTab"));
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
        elemField.setFieldName("corner");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "corner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Cell"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("column");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "column"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DimensionRowOrColumn"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("row");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "row"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DimensionRowOrColumn"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("table");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "table"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Row"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "row"));
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
