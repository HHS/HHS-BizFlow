/**
 * FilterResultSet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class FilterResultSet  implements java.io.Serializable {
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations[] secondaryOperations;

    private java.lang.String versionBase;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference[] locationReference;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResult[] filterResult;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[] drillDefinitions;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup[] styleGroup;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public FilterResultSet() {
    }

    public FilterResultSet(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations[] secondaryOperations,
           java.lang.String versionBase,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference[] locationReference,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResult[] filterResult,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[] drillDefinitions,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup[] styleGroup,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.secondaryOperations = secondaryOperations;
           this.versionBase = versionBase;
           this.locationReference = locationReference;
           this.filterResult = filterResult;
           this.drillDefinitions = drillDefinitions;
           this.styleGroup = styleGroup;
           this.extension = extension;
    }


    /**
     * Gets the secondaryOperations value for this FilterResultSet.
     * 
     * @return secondaryOperations
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations[] getSecondaryOperations() {
        return secondaryOperations;
    }


    /**
     * Sets the secondaryOperations value for this FilterResultSet.
     * 
     * @param secondaryOperations
     */
    public void setSecondaryOperations(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations[] secondaryOperations) {
        this.secondaryOperations = secondaryOperations;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations getSecondaryOperations(int i) {
        return this.secondaryOperations[i];
    }

    public void setSecondaryOperations(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations _value) {
        this.secondaryOperations[i] = _value;
    }


    /**
     * Gets the versionBase value for this FilterResultSet.
     * 
     * @return versionBase
     */
    public java.lang.String getVersionBase() {
        return versionBase;
    }


    /**
     * Sets the versionBase value for this FilterResultSet.
     * 
     * @param versionBase
     */
    public void setVersionBase(java.lang.String versionBase) {
        this.versionBase = versionBase;
    }


    /**
     * Gets the locationReference value for this FilterResultSet.
     * 
     * @return locationReference
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference[] getLocationReference() {
        return locationReference;
    }


    /**
     * Sets the locationReference value for this FilterResultSet.
     * 
     * @param locationReference
     */
    public void setLocationReference(com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference[] locationReference) {
        this.locationReference = locationReference;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference getLocationReference(int i) {
        return this.locationReference[i];
    }

    public void setLocationReference(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference _value) {
        this.locationReference[i] = _value;
    }


    /**
     * Gets the filterResult value for this FilterResultSet.
     * 
     * @return filterResult
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResult[] getFilterResult() {
        return filterResult;
    }


    /**
     * Sets the filterResult value for this FilterResultSet.
     * 
     * @param filterResult
     */
    public void setFilterResult(com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResult[] filterResult) {
        this.filterResult = filterResult;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResult getFilterResult(int i) {
        return this.filterResult[i];
    }

    public void setFilterResult(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResult _value) {
        this.filterResult[i] = _value;
    }


    /**
     * Gets the drillDefinitions value for this FilterResultSet.
     * 
     * @return drillDefinitions
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[] getDrillDefinitions() {
        return drillDefinitions;
    }


    /**
     * Sets the drillDefinitions value for this FilterResultSet.
     * 
     * @param drillDefinitions
     */
    public void setDrillDefinitions(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[] drillDefinitions) {
        this.drillDefinitions = drillDefinitions;
    }


    /**
     * Gets the styleGroup value for this FilterResultSet.
     * 
     * @return styleGroup
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup[] getStyleGroup() {
        return styleGroup;
    }


    /**
     * Sets the styleGroup value for this FilterResultSet.
     * 
     * @param styleGroup
     */
    public void setStyleGroup(com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup[] styleGroup) {
        this.styleGroup = styleGroup;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup getStyleGroup(int i) {
        return this.styleGroup[i];
    }

    public void setStyleGroup(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup _value) {
        this.styleGroup[i] = _value;
    }


    /**
     * Gets the extension value for this FilterResultSet.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this FilterResultSet.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FilterResultSet)) return false;
        FilterResultSet other = (FilterResultSet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.secondaryOperations==null && other.getSecondaryOperations()==null) || 
             (this.secondaryOperations!=null &&
              java.util.Arrays.equals(this.secondaryOperations, other.getSecondaryOperations()))) &&
            ((this.versionBase==null && other.getVersionBase()==null) || 
             (this.versionBase!=null &&
              this.versionBase.equals(other.getVersionBase()))) &&
            ((this.locationReference==null && other.getLocationReference()==null) || 
             (this.locationReference!=null &&
              java.util.Arrays.equals(this.locationReference, other.getLocationReference()))) &&
            ((this.filterResult==null && other.getFilterResult()==null) || 
             (this.filterResult!=null &&
              java.util.Arrays.equals(this.filterResult, other.getFilterResult()))) &&
            ((this.drillDefinitions==null && other.getDrillDefinitions()==null) || 
             (this.drillDefinitions!=null &&
              java.util.Arrays.equals(this.drillDefinitions, other.getDrillDefinitions()))) &&
            ((this.styleGroup==null && other.getStyleGroup()==null) || 
             (this.styleGroup!=null &&
              java.util.Arrays.equals(this.styleGroup, other.getStyleGroup()))) &&
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
        if (getSecondaryOperations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecondaryOperations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecondaryOperations(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVersionBase() != null) {
            _hashCode += getVersionBase().hashCode();
        }
        if (getLocationReference() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLocationReference());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLocationReference(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFilterResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFilterResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFilterResult(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDrillDefinitions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDrillDefinitions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDrillDefinitions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FilterResultSet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterResultSet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondaryOperations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "secondaryOperations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "secondaryOperations"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionBase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "versionBase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locationReference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "locationReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "locationReference"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filterResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "filterResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drillDefinitions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drillDefinitions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">DrillDefinitions>drill"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drill"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("styleGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "styleGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "styleGroup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">extension"));
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
