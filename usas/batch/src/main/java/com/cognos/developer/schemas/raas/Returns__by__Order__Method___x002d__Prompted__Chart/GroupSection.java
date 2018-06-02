/**
 * GroupSection.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;


/**
 * A grouping level for a listframe.
 */
public class GroupSection  implements java.io.Serializable {
    /* If applicable, the dataItem (from the respective query) corresponding
     * to this grouping level. */
    private java.lang.String di;

    /* If applicable, the dataItem value  corresponding to this grouping
     * level selection . */
    private java.lang.String dv;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] header;

    /* group Column Titles */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell[] colTitle;

    /* List Row */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] row;

    /* Nested Group level */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GroupSection[] grp;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] footer;

    /* Level of this group */
    private int depth;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension;

    public GroupSection() {
    }

    public GroupSection(
           java.lang.String di,
           java.lang.String dv,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] header,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell[] colTitle,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] row,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GroupSection[] grp,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] footer,
           int depth,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
           this.di = di;
           this.dv = dv;
           this.header = header;
           this.colTitle = colTitle;
           this.row = row;
           this.grp = grp;
           this.footer = footer;
           this.depth = depth;
           this.extension = extension;
    }


    /**
     * Gets the di value for this GroupSection.
     * 
     * @return di   * If applicable, the dataItem (from the respective query) corresponding
     * to this grouping level.
     */
    public java.lang.String getDi() {
        return di;
    }


    /**
     * Sets the di value for this GroupSection.
     * 
     * @param di   * If applicable, the dataItem (from the respective query) corresponding
     * to this grouping level.
     */
    public void setDi(java.lang.String di) {
        this.di = di;
    }


    /**
     * Gets the dv value for this GroupSection.
     * 
     * @return dv   * If applicable, the dataItem value  corresponding to this grouping
     * level selection .
     */
    public java.lang.String getDv() {
        return dv;
    }


    /**
     * Sets the dv value for this GroupSection.
     * 
     * @param dv   * If applicable, the dataItem value  corresponding to this grouping
     * level selection .
     */
    public void setDv(java.lang.String dv) {
        this.dv = dv;
    }


    /**
     * Gets the header value for this GroupSection.
     * 
     * @return header
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] getHeader() {
        return header;
    }


    /**
     * Sets the header value for this GroupSection.
     * 
     * @param header
     */
    public void setHeader(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] header) {
        this.header = header;
    }


    /**
     * Gets the colTitle value for this GroupSection.
     * 
     * @return colTitle   * group Column Titles
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell[] getColTitle() {
        return colTitle;
    }


    /**
     * Sets the colTitle value for this GroupSection.
     * 
     * @param colTitle   * group Column Titles
     */
    public void setColTitle(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell[] colTitle) {
        this.colTitle = colTitle;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell getColTitle(int i) {
        return this.colTitle[i];
    }

    public void setColTitle(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell _value) {
        this.colTitle[i] = _value;
    }


    /**
     * Gets the row value for this GroupSection.
     * 
     * @return row   * List Row
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] getRow() {
        return row;
    }


    /**
     * Sets the row value for this GroupSection.
     * 
     * @param row   * List Row
     */
    public void setRow(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] row) {
        this.row = row;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row getRow(int i) {
        return this.row[i];
    }

    public void setRow(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row _value) {
        this.row[i] = _value;
    }


    /**
     * Gets the grp value for this GroupSection.
     * 
     * @return grp   * Nested Group level
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GroupSection[] getGrp() {
        return grp;
    }


    /**
     * Sets the grp value for this GroupSection.
     * 
     * @param grp   * Nested Group level
     */
    public void setGrp(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GroupSection[] grp) {
        this.grp = grp;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GroupSection getGrp(int i) {
        return this.grp[i];
    }

    public void setGrp(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GroupSection _value) {
        this.grp[i] = _value;
    }


    /**
     * Gets the footer value for this GroupSection.
     * 
     * @return footer
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] getFooter() {
        return footer;
    }


    /**
     * Sets the footer value for this GroupSection.
     * 
     * @param footer
     */
    public void setFooter(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] footer) {
        this.footer = footer;
    }


    /**
     * Gets the depth value for this GroupSection.
     * 
     * @return depth   * Level of this group
     */
    public int getDepth() {
        return depth;
    }


    /**
     * Sets the depth value for this GroupSection.
     * 
     * @param depth   * Level of this group
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }


    /**
     * Gets the extension value for this GroupSection.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GroupSection.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GroupSection)) return false;
        GroupSection other = (GroupSection) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.di==null && other.getDi()==null) || 
             (this.di!=null &&
              this.di.equals(other.getDi()))) &&
            ((this.dv==null && other.getDv()==null) || 
             (this.dv!=null &&
              this.dv.equals(other.getDv()))) &&
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              java.util.Arrays.equals(this.header, other.getHeader()))) &&
            ((this.colTitle==null && other.getColTitle()==null) || 
             (this.colTitle!=null &&
              java.util.Arrays.equals(this.colTitle, other.getColTitle()))) &&
            ((this.row==null && other.getRow()==null) || 
             (this.row!=null &&
              java.util.Arrays.equals(this.row, other.getRow()))) &&
            ((this.grp==null && other.getGrp()==null) || 
             (this.grp!=null &&
              java.util.Arrays.equals(this.grp, other.getGrp()))) &&
            ((this.footer==null && other.getFooter()==null) || 
             (this.footer!=null &&
              java.util.Arrays.equals(this.footer, other.getFooter()))) &&
            this.depth == other.getDepth() &&
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
        if (getDi() != null) {
            _hashCode += getDi().hashCode();
        }
        if (getDv() != null) {
            _hashCode += getDv().hashCode();
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
        if (getGrp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGrp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGrp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        _hashCode += getDepth();
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GroupSection.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GroupSection"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("di");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "di"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dv");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "dv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("header");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "header"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Row"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "row"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("colTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "colTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Cell"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("row");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "row"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Row"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "grp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GroupSection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("footer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "footer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Row"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "row"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depth");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "depth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
