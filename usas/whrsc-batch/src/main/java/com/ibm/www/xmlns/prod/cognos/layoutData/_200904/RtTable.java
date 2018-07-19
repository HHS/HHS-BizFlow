/**
 * RtTable.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Rich Text Table type
 */
public class RtTable  implements java.io.Serializable {
    private java.lang.String[] style;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTableRow[] tr;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtxtExtensionType extension;

    public RtTable() {
    }

    public RtTable(
           java.lang.String[] style,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTableRow[] tr,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtxtExtensionType extension) {
           this.style = style;
           this.tr = tr;
           this.extension = extension;
    }


    /**
     * Gets the style value for this RtTable.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this RtTable.
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
     * Gets the tr value for this RtTable.
     * 
     * @return tr
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTableRow[] getTr() {
        return tr;
    }


    /**
     * Sets the tr value for this RtTable.
     * 
     * @param tr
     */
    public void setTr(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTableRow[] tr) {
        this.tr = tr;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTableRow getTr(int i) {
        return this.tr[i];
    }

    public void setTr(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTableRow _value) {
        this.tr[i] = _value;
    }


    /**
     * Gets the extension value for this RtTable.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtxtExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this RtTable.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtxtExtensionType extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RtTable)) return false;
        RtTable other = (RtTable) obj;
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
            ((this.tr==null && other.getTr()==null) || 
             (this.tr!=null &&
              java.util.Arrays.equals(this.tr, other.getTr()))) &&
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
        if (getTr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTr(), i);
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
        new org.apache.axis.description.TypeDesc(RtTable.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtTable"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "tr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtTableRow"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtxtExtensionType"));
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
