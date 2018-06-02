/**
 * PValueArrayItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class PValueArrayItem  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SimplePValue simplePValue;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RangePValue rangePValue;

    /* Never used. */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TreePValue treePValue;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension;

    public PValueArrayItem() {
    }

    public PValueArrayItem(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SimplePValue simplePValue,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RangePValue rangePValue,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TreePValue treePValue,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
           this.simplePValue = simplePValue;
           this.rangePValue = rangePValue;
           this.treePValue = treePValue;
           this.extension = extension;
    }


    /**
     * Gets the simplePValue value for this PValueArrayItem.
     * 
     * @return simplePValue
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SimplePValue getSimplePValue() {
        return simplePValue;
    }


    /**
     * Sets the simplePValue value for this PValueArrayItem.
     * 
     * @param simplePValue
     */
    public void setSimplePValue(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SimplePValue simplePValue) {
        this.simplePValue = simplePValue;
    }


    /**
     * Gets the rangePValue value for this PValueArrayItem.
     * 
     * @return rangePValue
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RangePValue getRangePValue() {
        return rangePValue;
    }


    /**
     * Sets the rangePValue value for this PValueArrayItem.
     * 
     * @param rangePValue
     */
    public void setRangePValue(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RangePValue rangePValue) {
        this.rangePValue = rangePValue;
    }


    /**
     * Gets the treePValue value for this PValueArrayItem.
     * 
     * @return treePValue   * Never used.
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TreePValue getTreePValue() {
        return treePValue;
    }


    /**
     * Sets the treePValue value for this PValueArrayItem.
     * 
     * @param treePValue   * Never used.
     */
    public void setTreePValue(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TreePValue treePValue) {
        this.treePValue = treePValue;
    }


    /**
     * Gets the extension value for this PValueArrayItem.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PValueArrayItem.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PValueArrayItem)) return false;
        PValueArrayItem other = (PValueArrayItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.simplePValue==null && other.getSimplePValue()==null) || 
             (this.simplePValue!=null &&
              this.simplePValue.equals(other.getSimplePValue()))) &&
            ((this.rangePValue==null && other.getRangePValue()==null) || 
             (this.rangePValue!=null &&
              this.rangePValue.equals(other.getRangePValue()))) &&
            ((this.treePValue==null && other.getTreePValue()==null) || 
             (this.treePValue!=null &&
              this.treePValue.equals(other.getTreePValue()))) &&
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
        if (getSimplePValue() != null) {
            _hashCode += getSimplePValue().hashCode();
        }
        if (getRangePValue() != null) {
            _hashCode += getRangePValue().hashCode();
        }
        if (getTreePValue() != null) {
            _hashCode += getTreePValue().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PValueArrayItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PValueArrayItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("simplePValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SimplePValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SimplePValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rangePValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RangePValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RangePValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("treePValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TreePValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TreePValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">extension"));
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
