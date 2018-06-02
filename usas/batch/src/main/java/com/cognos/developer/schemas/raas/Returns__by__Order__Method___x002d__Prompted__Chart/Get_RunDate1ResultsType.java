/**
 * Get_RunDate1ResultsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Get_RunDate1ResultsType  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runDate1;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup[] styleGroup;

    public Get_RunDate1ResultsType() {
    }

    public Get_RunDate1ResultsType(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runDate1,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup[] styleGroup) {
           this.runDate1 = runDate1;
           this.styleGroup = styleGroup;
    }


    /**
     * Gets the runDate1 value for this Get_RunDate1ResultsType.
     * 
     * @return runDate1
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame getRunDate1() {
        return runDate1;
    }


    /**
     * Sets the runDate1 value for this Get_RunDate1ResultsType.
     * 
     * @param runDate1
     */
    public void setRunDate1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runDate1) {
        this.runDate1 = runDate1;
    }


    /**
     * Gets the styleGroup value for this Get_RunDate1ResultsType.
     * 
     * @return styleGroup
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup[] getStyleGroup() {
        return styleGroup;
    }


    /**
     * Sets the styleGroup value for this Get_RunDate1ResultsType.
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
        if (!(obj instanceof Get_RunDate1ResultsType)) return false;
        Get_RunDate1ResultsType other = (Get_RunDate1ResultsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.runDate1==null && other.getRunDate1()==null) || 
             (this.runDate1!=null &&
              this.runDate1.equals(other.getRunDate1()))) &&
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
        if (getRunDate1() != null) {
            _hashCode += getRunDate1().hashCode();
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
        new org.apache.axis.description.TypeDesc(Get_RunDate1ResultsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1ResultsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("runDate1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RunDate1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame"));
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
