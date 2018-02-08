/**
 * Crosstab1_Year_DimensionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Crosstab1_Year_DimensionType  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell name;

    private int start;

    private int size;

    public Crosstab1_Year_DimensionType() {
    }

    public Crosstab1_Year_DimensionType(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell name,
           int start,
           int size) {
           this.name = name;
           this.start = start;
           this.size = size;
    }


    /**
     * Gets the name value for this Crosstab1_Year_DimensionType.
     * 
     * @return name
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell getName() {
        return name;
    }


    /**
     * Sets the name value for this Crosstab1_Year_DimensionType.
     * 
     * @param name
     */
    public void setName(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell name) {
        this.name = name;
    }


    /**
     * Gets the start value for this Crosstab1_Year_DimensionType.
     * 
     * @return start
     */
    public int getStart() {
        return start;
    }


    /**
     * Sets the start value for this Crosstab1_Year_DimensionType.
     * 
     * @param start
     */
    public void setStart(int start) {
        this.start = start;
    }


    /**
     * Gets the size value for this Crosstab1_Year_DimensionType.
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * Sets the size value for this Crosstab1_Year_DimensionType.
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Crosstab1_Year_DimensionType)) return false;
        Crosstab1_Year_DimensionType other = (Crosstab1_Year_DimensionType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.start == other.getStart() &&
            this.size == other.getSize();
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getStart();
        _hashCode += getSize();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Crosstab1_Year_DimensionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_Year_DimensionType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Cell"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
