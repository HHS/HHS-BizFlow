/**
 * CellExtension.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class CellExtension  implements java.io.Serializable {
    private java.lang.Boolean canDrillUp;

    private java.lang.Boolean canDrillDown;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension;

    public CellExtension() {
    }

    public CellExtension(
           java.lang.Boolean canDrillUp,
           java.lang.Boolean canDrillDown,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
           this.canDrillUp = canDrillUp;
           this.canDrillDown = canDrillDown;
           this.extension = extension;
    }


    /**
     * Gets the canDrillUp value for this CellExtension.
     * 
     * @return canDrillUp
     */
    public java.lang.Boolean getCanDrillUp() {
        return canDrillUp;
    }


    /**
     * Sets the canDrillUp value for this CellExtension.
     * 
     * @param canDrillUp
     */
    public void setCanDrillUp(java.lang.Boolean canDrillUp) {
        this.canDrillUp = canDrillUp;
    }


    /**
     * Gets the canDrillDown value for this CellExtension.
     * 
     * @return canDrillDown
     */
    public java.lang.Boolean getCanDrillDown() {
        return canDrillDown;
    }


    /**
     * Sets the canDrillDown value for this CellExtension.
     * 
     * @param canDrillDown
     */
    public void setCanDrillDown(java.lang.Boolean canDrillDown) {
        this.canDrillDown = canDrillDown;
    }


    /**
     * Gets the extension value for this CellExtension.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CellExtension.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CellExtension)) return false;
        CellExtension other = (CellExtension) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.canDrillUp==null && other.getCanDrillUp()==null) || 
             (this.canDrillUp!=null &&
              this.canDrillUp.equals(other.getCanDrillUp()))) &&
            ((this.canDrillDown==null && other.getCanDrillDown()==null) || 
             (this.canDrillDown!=null &&
              this.canDrillDown.equals(other.getCanDrillDown()))) &&
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
        if (getCanDrillUp() != null) {
            _hashCode += getCanDrillUp().hashCode();
        }
        if (getCanDrillDown() != null) {
            _hashCode += getCanDrillDown().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CellExtension.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">Cell>extension"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canDrillUp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "canDrillUp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canDrillDown");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "canDrillDown"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
