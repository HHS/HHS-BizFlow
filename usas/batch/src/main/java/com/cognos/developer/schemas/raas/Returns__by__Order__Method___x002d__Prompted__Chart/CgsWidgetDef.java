/**
 * CgsWidgetDef.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class CgsWidgetDef  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame[] cgsData;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsDataInfo cgsDataInfo;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsProperties cgsProperties;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension;

    public CgsWidgetDef() {
    }

    public CgsWidgetDef(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame[] cgsData,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsDataInfo cgsDataInfo,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsProperties cgsProperties,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
           this.cgsData = cgsData;
           this.cgsDataInfo = cgsDataInfo;
           this.cgsProperties = cgsProperties;
           this.extension = extension;
    }


    /**
     * Gets the cgsData value for this CgsWidgetDef.
     * 
     * @return cgsData
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame[] getCgsData() {
        return cgsData;
    }


    /**
     * Sets the cgsData value for this CgsWidgetDef.
     * 
     * @param cgsData
     */
    public void setCgsData(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame[] cgsData) {
        this.cgsData = cgsData;
    }


    /**
     * Gets the cgsDataInfo value for this CgsWidgetDef.
     * 
     * @return cgsDataInfo
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsDataInfo getCgsDataInfo() {
        return cgsDataInfo;
    }


    /**
     * Sets the cgsDataInfo value for this CgsWidgetDef.
     * 
     * @param cgsDataInfo
     */
    public void setCgsDataInfo(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsDataInfo cgsDataInfo) {
        this.cgsDataInfo = cgsDataInfo;
    }


    /**
     * Gets the cgsProperties value for this CgsWidgetDef.
     * 
     * @return cgsProperties
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsProperties getCgsProperties() {
        return cgsProperties;
    }


    /**
     * Sets the cgsProperties value for this CgsWidgetDef.
     * 
     * @param cgsProperties
     */
    public void setCgsProperties(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsProperties cgsProperties) {
        this.cgsProperties = cgsProperties;
    }


    /**
     * Gets the extension value for this CgsWidgetDef.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CgsWidgetDef.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CgsWidgetDef)) return false;
        CgsWidgetDef other = (CgsWidgetDef) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cgsData==null && other.getCgsData()==null) || 
             (this.cgsData!=null &&
              java.util.Arrays.equals(this.cgsData, other.getCgsData()))) &&
            ((this.cgsDataInfo==null && other.getCgsDataInfo()==null) || 
             (this.cgsDataInfo!=null &&
              this.cgsDataInfo.equals(other.getCgsDataInfo()))) &&
            ((this.cgsProperties==null && other.getCgsProperties()==null) || 
             (this.cgsProperties!=null &&
              this.cgsProperties.equals(other.getCgsProperties()))) &&
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
        if (getCgsData() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCgsData());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCgsData(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCgsDataInfo() != null) {
            _hashCode += getCgsDataInfo().hashCode();
        }
        if (getCgsProperties() != null) {
            _hashCode += getCgsProperties().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CgsWidgetDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cgsWidgetDef"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cgsData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cgsData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ListFrame"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "table"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cgsDataInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cgsDataInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">cgsDataInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cgsProperties");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cgsProperties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">cgsProperties"));
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
