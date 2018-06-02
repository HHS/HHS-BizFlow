/**
 * Get_Combination__Chart1ResultsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Get_Combination__Chart1ResultsType  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart combination__Chart1;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup[] styleGroup;

    public Get_Combination__Chart1ResultsType() {
    }

    public Get_Combination__Chart1ResultsType(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart combination__Chart1,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup[] styleGroup) {
           this.combination__Chart1 = combination__Chart1;
           this.styleGroup = styleGroup;
    }


    /**
     * Gets the combination__Chart1 value for this Get_Combination__Chart1ResultsType.
     * 
     * @return combination__Chart1
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart getCombination__Chart1() {
        return combination__Chart1;
    }


    /**
     * Sets the combination__Chart1 value for this Get_Combination__Chart1ResultsType.
     * 
     * @param combination__Chart1
     */
    public void setCombination__Chart1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart combination__Chart1) {
        this.combination__Chart1 = combination__Chart1;
    }


    /**
     * Gets the styleGroup value for this Get_Combination__Chart1ResultsType.
     * 
     * @return styleGroup
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup[] getStyleGroup() {
        return styleGroup;
    }


    /**
     * Sets the styleGroup value for this Get_Combination__Chart1ResultsType.
     * 
     * @param styleGroup
     */
    public void setStyleGroup(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup[] styleGroup) {
        this.styleGroup = styleGroup;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup getStyleGroup(int i) {
        return this.styleGroup[i];
    }

    public void setStyleGroup(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup _value) {
        this.styleGroup[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Combination__Chart1ResultsType)) return false;
        Get_Combination__Chart1ResultsType other = (Get_Combination__Chart1ResultsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.combination__Chart1==null && other.getCombination__Chart1()==null) || 
             (this.combination__Chart1!=null &&
              this.combination__Chart1.equals(other.getCombination__Chart1()))) &&
            ((this.styleGroup==null && other.getStyleGroup()==null) || 
             (this.styleGroup!=null &&
              java.util.Arrays.equals(this.styleGroup, other.getStyleGroup())));
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
        if (getCombination__Chart1() != null) {
            _hashCode += getCombination__Chart1().hashCode();
        }
        if (getStyleGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStyleGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStyleGroup(), i);
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
        new org.apache.axis.description.TypeDesc(Get_Combination__Chart1ResultsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1ResultsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("combination__Chart1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Combination__Chart1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Chart"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("styleGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "styleGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "StyleGroup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
