/**
 * LDXOutputType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class LDXOutputType  implements java.io.Serializable {
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Document document;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResultSet filterResultSet;

    public LDXOutputType() {
    }

    public LDXOutputType(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Document document,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResultSet filterResultSet) {
           this.document = document;
           this.filterResultSet = filterResultSet;
    }


    /**
     * Gets the document value for this LDXOutputType.
     * 
     * @return document
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Document getDocument() {
        return document;
    }


    /**
     * Sets the document value for this LDXOutputType.
     * 
     * @param document
     */
    public void setDocument(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Document document) {
        this.document = document;
    }


    /**
     * Gets the filterResultSet value for this LDXOutputType.
     * 
     * @return filterResultSet
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResultSet getFilterResultSet() {
        return filterResultSet;
    }


    /**
     * Sets the filterResultSet value for this LDXOutputType.
     * 
     * @param filterResultSet
     */
    public void setFilterResultSet(com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResultSet filterResultSet) {
        this.filterResultSet = filterResultSet;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LDXOutputType)) return false;
        LDXOutputType other = (LDXOutputType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.document==null && other.getDocument()==null) || 
             (this.document!=null &&
              this.document.equals(other.getDocument()))) &&
            ((this.filterResultSet==null && other.getFilterResultSet()==null) || 
             (this.filterResultSet!=null &&
              this.filterResultSet.equals(other.getFilterResultSet())));
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
        if (getDocument() != null) {
            _hashCode += getDocument().hashCode();
        }
        if (getFilterResultSet() != null) {
            _hashCode += getFilterResultSet().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LDXOutputType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "LDXOutputType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "document"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Document"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterResultSet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "filterResultSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterResultSet"));
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
