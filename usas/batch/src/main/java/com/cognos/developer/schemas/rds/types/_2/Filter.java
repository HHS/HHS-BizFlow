/**
 * Filter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * Defines a filter
 */
public class Filter  implements java.io.Serializable {
    private java.lang.String filterValue;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum filterType;

    private java.lang.Object extension;

    public Filter() {
    }

    public Filter(
           java.lang.String filterValue,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum filterType,
           java.lang.Object extension) {
           this.filterValue = filterValue;
           this.filterType = filterType;
           this.extension = extension;
    }


    /**
     * Gets the filterValue value for this Filter.
     * 
     * @return filterValue
     */
    public java.lang.String getFilterValue() {
        return filterValue;
    }


    /**
     * Sets the filterValue value for this Filter.
     * 
     * @param filterValue
     */
    public void setFilterValue(java.lang.String filterValue) {
        this.filterValue = filterValue;
    }


    /**
     * Gets the filterType value for this Filter.
     * 
     * @return filterType
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum getFilterType() {
        return filterType;
    }


    /**
     * Sets the filterType value for this Filter.
     * 
     * @param filterType
     */
    public void setFilterType(com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum filterType) {
        this.filterType = filterType;
    }


    /**
     * Gets the extension value for this Filter.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this Filter.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Filter)) return false;
        Filter other = (Filter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filterValue==null && other.getFilterValue()==null) || 
             (this.filterValue!=null &&
              this.filterValue.equals(other.getFilterValue()))) &&
            ((this.filterType==null && other.getFilterType()==null) || 
             (this.filterType!=null &&
              this.filterType.equals(other.getFilterType()))) &&
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
        if (getFilterValue() != null) {
            _hashCode += getFilterValue().hashCode();
        }
        if (getFilterType() != null) {
            _hashCode += getFilterType().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Filter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "Filter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "filterValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "filterType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterTypeEnum"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
