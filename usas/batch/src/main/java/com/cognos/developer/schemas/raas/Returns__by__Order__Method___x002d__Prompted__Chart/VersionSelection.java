/**
 * VersionSelection.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class VersionSelection  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionTypeEnum versionType;

    private java.lang.String versionName;

    private java.lang.String searchPath;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension;

    public VersionSelection() {
    }

    public VersionSelection(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionTypeEnum versionType,
           java.lang.String versionName,
           java.lang.String searchPath,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
           this.versionType = versionType;
           this.versionName = versionName;
           this.searchPath = searchPath;
           this.extension = extension;
    }


    /**
     * Gets the versionType value for this VersionSelection.
     * 
     * @return versionType
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionTypeEnum getVersionType() {
        return versionType;
    }


    /**
     * Sets the versionType value for this VersionSelection.
     * 
     * @param versionType
     */
    public void setVersionType(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionTypeEnum versionType) {
        this.versionType = versionType;
    }


    /**
     * Gets the versionName value for this VersionSelection.
     * 
     * @return versionName
     */
    public java.lang.String getVersionName() {
        return versionName;
    }


    /**
     * Sets the versionName value for this VersionSelection.
     * 
     * @param versionName
     */
    public void setVersionName(java.lang.String versionName) {
        this.versionName = versionName;
    }


    /**
     * Gets the searchPath value for this VersionSelection.
     * 
     * @return searchPath
     */
    public java.lang.String getSearchPath() {
        return searchPath;
    }


    /**
     * Sets the searchPath value for this VersionSelection.
     * 
     * @param searchPath
     */
    public void setSearchPath(java.lang.String searchPath) {
        this.searchPath = searchPath;
    }


    /**
     * Gets the extension value for this VersionSelection.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this VersionSelection.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VersionSelection)) return false;
        VersionSelection other = (VersionSelection) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.versionType==null && other.getVersionType()==null) || 
             (this.versionType!=null &&
              this.versionType.equals(other.getVersionType()))) &&
            ((this.versionName==null && other.getVersionName()==null) || 
             (this.versionName!=null &&
              this.versionName.equals(other.getVersionName()))) &&
            ((this.searchPath==null && other.getSearchPath()==null) || 
             (this.searchPath!=null &&
              this.searchPath.equals(other.getSearchPath()))) &&
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
        if (getVersionType() != null) {
            _hashCode += getVersionType().hashCode();
        }
        if (getVersionName() != null) {
            _hashCode += getVersionName().hashCode();
        }
        if (getSearchPath() != null) {
            _hashCode += getSearchPath().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VersionSelection.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "VersionSelection"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "versionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "VersionTypeEnum"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "versionName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "searchPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
