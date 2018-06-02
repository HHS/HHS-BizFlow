/**
 * FilterResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class FilterResult  implements java.io.Serializable {
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum filterType;

    private java.lang.String filterValue;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElement[] reportElement;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public FilterResult() {
    }

    public FilterResult(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum filterType,
           java.lang.String filterValue,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElement[] reportElement,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.filterType = filterType;
           this.filterValue = filterValue;
           this.reportElement = reportElement;
           this.extension = extension;
    }


    /**
     * Gets the filterType value for this FilterResult.
     * 
     * @return filterType
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum getFilterType() {
        return filterType;
    }


    /**
     * Sets the filterType value for this FilterResult.
     * 
     * @param filterType
     */
    public void setFilterType(com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum filterType) {
        this.filterType = filterType;
    }


    /**
     * Gets the filterValue value for this FilterResult.
     * 
     * @return filterValue
     */
    public java.lang.String getFilterValue() {
        return filterValue;
    }


    /**
     * Sets the filterValue value for this FilterResult.
     * 
     * @param filterValue
     */
    public void setFilterValue(java.lang.String filterValue) {
        this.filterValue = filterValue;
    }


    /**
     * Gets the reportElement value for this FilterResult.
     * 
     * @return reportElement
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElement[] getReportElement() {
        return reportElement;
    }


    /**
     * Sets the reportElement value for this FilterResult.
     * 
     * @param reportElement
     */
    public void setReportElement(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElement[] reportElement) {
        this.reportElement = reportElement;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElement getReportElement(int i) {
        return this.reportElement[i];
    }

    public void setReportElement(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElement _value) {
        this.reportElement[i] = _value;
    }


    /**
     * Gets the extension value for this FilterResult.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this FilterResult.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FilterResult)) return false;
        FilterResult other = (FilterResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filterType==null && other.getFilterType()==null) || 
             (this.filterType!=null &&
              this.filterType.equals(other.getFilterType()))) &&
            ((this.filterValue==null && other.getFilterValue()==null) || 
             (this.filterValue!=null &&
              this.filterValue.equals(other.getFilterValue()))) &&
            ((this.reportElement==null && other.getReportElement()==null) || 
             (this.reportElement!=null &&
              java.util.Arrays.equals(this.reportElement, other.getReportElement()))) &&
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
        if (getFilterType() != null) {
            _hashCode += getFilterType().hashCode();
        }
        if (getFilterValue() != null) {
            _hashCode += getFilterValue().hashCode();
        }
        if (getReportElement() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReportElement());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReportElement(), i);
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
        new org.apache.axis.description.TypeDesc(FilterResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "filterType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterTypeEnum"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "filterValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportElement");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "reportElement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ReportElement"));
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
