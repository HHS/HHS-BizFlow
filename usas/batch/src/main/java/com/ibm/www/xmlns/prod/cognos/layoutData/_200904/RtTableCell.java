/**
 * RtTableCell.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Rich Text Table Cell type
 */
public class RtTableCell  implements java.io.Serializable {
    private java.lang.String[] style;

    /* Row span */
    private java.lang.Integer rspan;

    /* Column span */
    private java.lang.Integer cspan;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmt[] item;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public RtTableCell() {
    }

    public RtTableCell(
           java.lang.String[] style,
           java.lang.Integer rspan,
           java.lang.Integer cspan,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmt[] item,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.style = style;
           this.rspan = rspan;
           this.cspan = cspan;
           this.item = item;
           this.extension = extension;
    }


    /**
     * Gets the style value for this RtTableCell.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this RtTableCell.
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
     * Gets the rspan value for this RtTableCell.
     * 
     * @return rspan   * Row span
     */
    public java.lang.Integer getRspan() {
        return rspan;
    }


    /**
     * Sets the rspan value for this RtTableCell.
     * 
     * @param rspan   * Row span
     */
    public void setRspan(java.lang.Integer rspan) {
        this.rspan = rspan;
    }


    /**
     * Gets the cspan value for this RtTableCell.
     * 
     * @return cspan   * Column span
     */
    public java.lang.Integer getCspan() {
        return cspan;
    }


    /**
     * Sets the cspan value for this RtTableCell.
     * 
     * @param cspan   * Column span
     */
    public void setCspan(java.lang.Integer cspan) {
        this.cspan = cspan;
    }


    /**
     * Gets the item value for this RtTableCell.
     * 
     * @return item
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmt[] getItem() {
        return item;
    }


    /**
     * Sets the item value for this RtTableCell.
     * 
     * @param item
     */
    public void setItem(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmt[] item) {
        this.item = item;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmt getItem(int i) {
        return this.item[i];
    }

    public void setItem(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmt _value) {
        this.item[i] = _value;
    }


    /**
     * Gets the extension value for this RtTableCell.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this RtTableCell.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RtTableCell)) return false;
        RtTableCell other = (RtTableCell) obj;
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
            ((this.rspan==null && other.getRspan()==null) || 
             (this.rspan!=null &&
              this.rspan.equals(other.getRspan()))) &&
            ((this.cspan==null && other.getCspan()==null) || 
             (this.cspan!=null &&
              this.cspan.equals(other.getCspan()))) &&
            ((this.item==null && other.getItem()==null) || 
             (this.item!=null &&
              java.util.Arrays.equals(this.item, other.getItem()))) &&
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
        if (getRspan() != null) {
            _hashCode += getRspan().hashCode();
        }
        if (getCspan() != null) {
            _hashCode += getCspan().hashCode();
        }
        if (getItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RtTableCell.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtTableCell"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rspan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "rspan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cspan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cspan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RichTextElmt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
