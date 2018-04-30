/**
 * Crosstab1_CrossTabType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Crosstab1_CrossTabType  implements java.io.Serializable {
    private java.lang.String[] style;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame corner;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Return__reason_DimensionType[] return__reason;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Year_DimensionType[] year;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Product__line_DimensionType[] product__line;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] table;

    public Crosstab1_CrossTabType() {
    }

    public Crosstab1_CrossTabType(
           java.lang.String[] style,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame corner,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Return__reason_DimensionType[] return__reason,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Year_DimensionType[] year,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Product__line_DimensionType[] product__line,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] table) {
           this.style = style;
           this.corner = corner;
           this.return__reason = return__reason;
           this.year = year;
           this.product__line = product__line;
           this.table = table;
    }


    /**
     * Gets the style value for this Crosstab1_CrossTabType.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this Crosstab1_CrossTabType.
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
     * Gets the corner value for this Crosstab1_CrossTabType.
     * 
     * @return corner
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame getCorner() {
        return corner;
    }


    /**
     * Sets the corner value for this Crosstab1_CrossTabType.
     * 
     * @param corner
     */
    public void setCorner(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame corner) {
        this.corner = corner;
    }


    /**
     * Gets the return__reason value for this Crosstab1_CrossTabType.
     * 
     * @return return__reason
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Return__reason_DimensionType[] getReturn__reason() {
        return return__reason;
    }


    /**
     * Sets the return__reason value for this Crosstab1_CrossTabType.
     * 
     * @param return__reason
     */
    public void setReturn__reason(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Return__reason_DimensionType[] return__reason) {
        this.return__reason = return__reason;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Return__reason_DimensionType getReturn__reason(int i) {
        return this.return__reason[i];
    }

    public void setReturn__reason(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Return__reason_DimensionType _value) {
        this.return__reason[i] = _value;
    }


    /**
     * Gets the year value for this Crosstab1_CrossTabType.
     * 
     * @return year
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Year_DimensionType[] getYear() {
        return year;
    }


    /**
     * Sets the year value for this Crosstab1_CrossTabType.
     * 
     * @param year
     */
    public void setYear(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Year_DimensionType[] year) {
        this.year = year;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Year_DimensionType getYear(int i) {
        return this.year[i];
    }

    public void setYear(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Year_DimensionType _value) {
        this.year[i] = _value;
    }


    /**
     * Gets the product__line value for this Crosstab1_CrossTabType.
     * 
     * @return product__line
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Product__line_DimensionType[] getProduct__line() {
        return product__line;
    }


    /**
     * Sets the product__line value for this Crosstab1_CrossTabType.
     * 
     * @param product__line
     */
    public void setProduct__line(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Product__line_DimensionType[] product__line) {
        this.product__line = product__line;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Product__line_DimensionType getProduct__line(int i) {
        return this.product__line[i];
    }

    public void setProduct__line(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Product__line_DimensionType _value) {
        this.product__line[i] = _value;
    }


    /**
     * Gets the table value for this Crosstab1_CrossTabType.
     * 
     * @return table
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] getTable() {
        return table;
    }


    /**
     * Sets the table value for this Crosstab1_CrossTabType.
     * 
     * @param table
     */
    public void setTable(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[] table) {
        this.table = table;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Crosstab1_CrossTabType)) return false;
        Crosstab1_CrossTabType other = (Crosstab1_CrossTabType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              java.util.Arrays.equals(this.style, other.getStyle()))) &&
            ((this.corner==null && other.getCorner()==null) || 
             (this.corner!=null &&
              this.corner.equals(other.getCorner()))) &&
            ((this.return__reason==null && other.getReturn__reason()==null) || 
             (this.return__reason!=null &&
              java.util.Arrays.equals(this.return__reason, other.getReturn__reason()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              java.util.Arrays.equals(this.year, other.getYear()))) &&
            ((this.product__line==null && other.getProduct__line()==null) || 
             (this.product__line!=null &&
              java.util.Arrays.equals(this.product__line, other.getProduct__line()))) &&
            ((this.table==null && other.getTable()==null) || 
             (this.table!=null &&
              java.util.Arrays.equals(this.table, other.getTable())));
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
        if (getReturn__reason() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReturn__reason());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReturn__reason(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getYear() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getYear());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getYear(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProduct__line() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProduct__line());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProduct__line(), i);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Crosstab1_CrossTabType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_CrossTabType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "style"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "style"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corner");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "corner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("return__reason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Return__reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_Return__reason_DimensionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_Year_DimensionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("product__line");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Product__line"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_Product__line_DimensionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("table");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "table"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Row"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "row"));
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
