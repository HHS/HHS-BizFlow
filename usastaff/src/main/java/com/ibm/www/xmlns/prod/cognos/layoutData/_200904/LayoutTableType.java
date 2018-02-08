/**
 * LayoutTableType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class LayoutTableType  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String style;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableRowType[] trow;

    private java.lang.String summaryText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public LayoutTableType() {
    }

    public LayoutTableType(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String style,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableRowType[] trow,
           java.lang.String summaryText,
           java.lang.String annURL,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.trow = trow;
           this.summaryText = summaryText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this LayoutTableType.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this LayoutTableType.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this LayoutTableType.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this LayoutTableType.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this LayoutTableType.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this LayoutTableType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the trow value for this LayoutTableType.
     * 
     * @return trow
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableRowType[] getTrow() {
        return trow;
    }


    /**
     * Sets the trow value for this LayoutTableType.
     * 
     * @param trow
     */
    public void setTrow(com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableRowType[] trow) {
        this.trow = trow;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableRowType getTrow(int i) {
        return this.trow[i];
    }

    public void setTrow(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableRowType _value) {
        this.trow[i] = _value;
    }


    /**
     * Gets the summaryText value for this LayoutTableType.
     * 
     * @return summaryText
     */
    public java.lang.String getSummaryText() {
        return summaryText;
    }


    /**
     * Sets the summaryText value for this LayoutTableType.
     * 
     * @param summaryText
     */
    public void setSummaryText(java.lang.String summaryText) {
        this.summaryText = summaryText;
    }


    /**
     * Gets the annURL value for this LayoutTableType.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this LayoutTableType.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this LayoutTableType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this LayoutTableType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LayoutTableType)) return false;
        LayoutTableType other = (LayoutTableType) obj;
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
              this.style.equals(other.getStyle()))) &&
            ((this.trow==null && other.getTrow()==null) || 
             (this.trow!=null &&
              java.util.Arrays.equals(this.trow, other.getTrow()))) &&
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
            _hashCode += getStyle().hashCode();
        }
        if (getTrow() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTrow());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTrow(), i);
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
        new org.apache.axis.description.TypeDesc(LayoutTableType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutTableType"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trow");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "trow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutTableRowType"));
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
