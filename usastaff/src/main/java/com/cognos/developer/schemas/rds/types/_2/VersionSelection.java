/**
 * VersionSelection.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * Defines how a version is selected
 */
public class VersionSelection  implements java.io.Serializable {
    /* The version type. Can be NEW/LATEST/VERSION_NAME/NO_DATA/LIMITED_DATA */
    private VersionTypeEnum versionType;

    private java.lang.String versionName;

    /* Optionally a searchPath to the version object can be specified,
     * in place of the versionName. */
    private java.lang.String searchPath;

    private java.lang.Object extension;

    public VersionSelection() {
    }

    public VersionSelection(
           com.cognos.developer.schemas.rds.types._2.VersionTypeEnum versionType,
           java.lang.String versionName,
           java.lang.String searchPath,
           java.lang.Object extension) {
           this.versionType = versionType;
           this.versionName = versionName;
           this.searchPath = searchPath;
           this.extension = extension;
    }


    /**
     * Gets the versionType value for this VersionSelection.
     * 
     * @return versionType   * The version type. Can be NEW/LATEST/VERSION_NAME/NO_DATA/LIMITED_DATA
     */
    public VersionTypeEnum getVersionType() {
        return versionType;
    }


    /**
     * Sets the versionType value for this VersionSelection.
     * 
     * @param versionType   * The version type. Can be NEW/LATEST/VERSION_NAME/NO_DATA/LIMITED_DATA
     */
    public void setVersionType(com.cognos.developer.schemas.rds.types._2.VersionTypeEnum versionType) {
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
     * @return searchPath   * Optionally a searchPath to the version object can be specified,
     * in place of the versionName.
     */
    public java.lang.String getSearchPath() {
        return searchPath;
    }


    /**
     * Sets the searchPath value for this VersionSelection.
     * 
     * @param searchPath   * Optionally a searchPath to the version object can be specified,
     * in place of the versionName.
     */
    public void setSearchPath(java.lang.String searchPath) {
        this.searchPath = searchPath;
    }


    /**
     * Gets the extension value for this VersionSelection.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this VersionSelection.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "versionSelection"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "versionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "VersionTypeEnum"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "versionName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
