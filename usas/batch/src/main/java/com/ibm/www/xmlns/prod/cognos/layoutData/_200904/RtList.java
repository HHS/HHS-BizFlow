/**
 * RtList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Rich Text List type
 */
public class RtList  implements java.io.Serializable {
    private java.lang.String[] style;

    /* Defines if this is an ordered list - e.g. numbered (true) or
     * an unordered list (false). */
    private boolean ordered;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmtArray[] listItem;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public RtList() {
    }

    public RtList(
           java.lang.String[] style,
           boolean ordered,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmtArray[] listItem,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.style = style;
           this.ordered = ordered;
           this.listItem = listItem;
           this.extension = extension;
    }


    /**
     * Gets the style value for this RtList.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this RtList.
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
     * Gets the ordered value for this RtList.
     * 
     * @return ordered   * Defines if this is an ordered list - e.g. numbered (true) or
     * an unordered list (false).
     */
    public boolean isOrdered() {
        return ordered;
    }


    /**
     * Sets the ordered value for this RtList.
     * 
     * @param ordered   * Defines if this is an ordered list - e.g. numbered (true) or
     * an unordered list (false).
     */
    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }


    /**
     * Gets the listItem value for this RtList.
     * 
     * @return listItem
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmtArray[] getListItem() {
        return listItem;
    }


    /**
     * Sets the listItem value for this RtList.
     * 
     * @param listItem
     */
    public void setListItem(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmtArray[] listItem) {
        this.listItem = listItem;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmtArray getListItem(int i) {
        return this.listItem[i];
    }

    public void setListItem(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmtArray _value) {
        this.listItem[i] = _value;
    }


    /**
     * Gets the extension value for this RtList.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this RtList.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RtList)) return false;
        RtList other = (RtList) obj;
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
            this.ordered == other.isOrdered() &&
            ((this.listItem==null && other.getListItem()==null) || 
             (this.listItem!=null &&
              java.util.Arrays.equals(this.listItem, other.getListItem()))) &&
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
        _hashCode += (isOrdered() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getListItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListItem(), i);
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
        new org.apache.axis.description.TypeDesc(RtList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordered");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ordered"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listItem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "listItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RichTextElmtArray"));
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
