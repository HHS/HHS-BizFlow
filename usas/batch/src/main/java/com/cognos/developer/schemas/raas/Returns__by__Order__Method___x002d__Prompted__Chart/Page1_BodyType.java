/**
 * Page1_BodyType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Page1_BodyType  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_CrossTabType crosstab1;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart combination__Chart1;

    public Page1_BodyType() {
    }

    public Page1_BodyType(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_CrossTabType crosstab1,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart combination__Chart1) {
           this.crosstab1 = crosstab1;
           this.combination__Chart1 = combination__Chart1;
    }


    /**
     * Gets the crosstab1 value for this Page1_BodyType.
     * 
     * @return crosstab1
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_CrossTabType getCrosstab1() {
        return crosstab1;
    }


    /**
     * Sets the crosstab1 value for this Page1_BodyType.
     * 
     * @param crosstab1
     */
    public void setCrosstab1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_CrossTabType crosstab1) {
        this.crosstab1 = crosstab1;
    }


    /**
     * Gets the combination__Chart1 value for this Page1_BodyType.
     * 
     * @return combination__Chart1
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart getCombination__Chart1() {
        return combination__Chart1;
    }


    /**
     * Sets the combination__Chart1 value for this Page1_BodyType.
     * 
     * @param combination__Chart1
     */
    public void setCombination__Chart1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart combination__Chart1) {
        this.combination__Chart1 = combination__Chart1;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Page1_BodyType)) return false;
        Page1_BodyType other = (Page1_BodyType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.crosstab1==null && other.getCrosstab1()==null) || 
             (this.crosstab1!=null &&
              this.crosstab1.equals(other.getCrosstab1()))) &&
            ((this.combination__Chart1==null && other.getCombination__Chart1()==null) || 
             (this.combination__Chart1!=null &&
              this.combination__Chart1.equals(other.getCombination__Chart1())));
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
        if (getCrosstab1() != null) {
            _hashCode += getCrosstab1().hashCode();
        }
        if (getCombination__Chart1() != null) {
            _hashCode += getCombination__Chart1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Page1_BodyType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_BodyType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crosstab1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_CrossTabType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("combination__Chart1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Combination__Chart1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Chart"));
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
