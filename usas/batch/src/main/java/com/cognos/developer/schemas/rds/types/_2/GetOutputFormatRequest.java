/**
 * GetOutputFormatRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class GetOutputFormatRequest  implements java.io.Serializable {
    private java.lang.String sourceID;

    private com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType;

    private java.lang.String outputFormatName;

    private com.cognos.developer.schemas.rds.types._2.Filter[] filters;

    private VersionSelection version;

    private com.cognos.developer.schemas.rds.types._2.BurstType burstInfo;

    private java.lang.Boolean saveOutput;

    private PromptValue[] promptValues;

    private java.lang.Object extension;

    public GetOutputFormatRequest() {
    }

    public GetOutputFormatRequest(
           java.lang.String sourceID,
           com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType,
           java.lang.String outputFormatName,
           com.cognos.developer.schemas.rds.types._2.Filter[] filters,
           com.cognos.developer.schemas.rds.types._2.VersionSelection version,
           com.cognos.developer.schemas.rds.types._2.BurstType burstInfo,
           java.lang.Boolean saveOutput,
           com.cognos.developer.schemas.rds.types._2.PromptValue[] promptValues,
           java.lang.Object extension) {
           this.sourceID = sourceID;
           this.sourceType = sourceType;
           this.outputFormatName = outputFormatName;
           this.filters = filters;
           this.version = version;
           this.burstInfo = burstInfo;
           this.saveOutput = saveOutput;
           this.promptValues = promptValues;
           this.extension = extension;
    }


    /**
     * Gets the sourceID value for this GetOutputFormatRequest.
     * 
     * @return sourceID
     */
    public java.lang.String getSourceID() {
        return sourceID;
    }


    /**
     * Sets the sourceID value for this GetOutputFormatRequest.
     * 
     * @param sourceID
     */
    public void setSourceID(java.lang.String sourceID) {
        this.sourceID = sourceID;
    }


    /**
     * Gets the sourceType value for this GetOutputFormatRequest.
     * 
     * @return sourceType
     */
    public com.cognos.developer.schemas.rds.types._2.SourceTypeEnum getSourceType() {
        return sourceType;
    }


    /**
     * Sets the sourceType value for this GetOutputFormatRequest.
     * 
     * @param sourceType
     */
    public void setSourceType(com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType) {
        this.sourceType = sourceType;
    }


    /**
     * Gets the outputFormatName value for this GetOutputFormatRequest.
     * 
     * @return outputFormatName
     */
    public java.lang.String getOutputFormatName() {
        return outputFormatName;
    }


    /**
     * Sets the outputFormatName value for this GetOutputFormatRequest.
     * 
     * @param outputFormatName
     */
    public void setOutputFormatName(java.lang.String outputFormatName) {
        this.outputFormatName = outputFormatName;
    }


    /**
     * Gets the filters value for this GetOutputFormatRequest.
     * 
     * @return filters
     */
    public com.cognos.developer.schemas.rds.types._2.Filter[] getFilters() {
        return filters;
    }


    /**
     * Sets the filters value for this GetOutputFormatRequest.
     * 
     * @param filters
     */
    public void setFilters(com.cognos.developer.schemas.rds.types._2.Filter[] filters) {
        this.filters = filters;
    }

    public com.cognos.developer.schemas.rds.types._2.Filter getFilters(int i) {
        return this.filters[i];
    }

    public void setFilters(int i, com.cognos.developer.schemas.rds.types._2.Filter _value) {
        this.filters[i] = _value;
    }


    /**
     * Gets the version value for this GetOutputFormatRequest.
     * 
     * @return version
     */
    public VersionSelection getVersion() {
        return version;
    }


    /**
     * Sets the version value for this GetOutputFormatRequest.
     * 
     * @param version
     */
    public void setVersion(com.cognos.developer.schemas.rds.types._2.VersionSelection version) {
        this.version = version;
    }


    /**
     * Gets the burstInfo value for this GetOutputFormatRequest.
     * 
     * @return burstInfo
     */
    public com.cognos.developer.schemas.rds.types._2.BurstType getBurstInfo() {
        return burstInfo;
    }


    /**
     * Sets the burstInfo value for this GetOutputFormatRequest.
     * 
     * @param burstInfo
     */
    public void setBurstInfo(com.cognos.developer.schemas.rds.types._2.BurstType burstInfo) {
        this.burstInfo = burstInfo;
    }


    /**
     * Gets the saveOutput value for this GetOutputFormatRequest.
     * 
     * @return saveOutput
     */
    public java.lang.Boolean getSaveOutput() {
        return saveOutput;
    }


    /**
     * Sets the saveOutput value for this GetOutputFormatRequest.
     * 
     * @param saveOutput
     */
    public void setSaveOutput(java.lang.Boolean saveOutput) {
        this.saveOutput = saveOutput;
    }


    /**
     * Gets the promptValues value for this GetOutputFormatRequest.
     * 
     * @return promptValues
     */
    public PromptValue[] getPromptValues() {
        return promptValues;
    }


    /**
     * Sets the promptValues value for this GetOutputFormatRequest.
     * 
     * @param promptValues
     */
    public void setPromptValues(com.cognos.developer.schemas.rds.types._2.PromptValue[] promptValues) {
        this.promptValues = promptValues;
    }

    public PromptValue getPromptValues(int i) {
        return this.promptValues[i];
    }

    public void setPromptValues(int i, com.cognos.developer.schemas.rds.types._2.PromptValue _value) {
        this.promptValues[i] = _value;
    }


    /**
     * Gets the extension value for this GetOutputFormatRequest.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetOutputFormatRequest.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOutputFormatRequest)) return false;
        GetOutputFormatRequest other = (GetOutputFormatRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sourceID==null && other.getSourceID()==null) || 
             (this.sourceID!=null &&
              this.sourceID.equals(other.getSourceID()))) &&
            ((this.sourceType==null && other.getSourceType()==null) || 
             (this.sourceType!=null &&
              this.sourceType.equals(other.getSourceType()))) &&
            ((this.outputFormatName==null && other.getOutputFormatName()==null) || 
             (this.outputFormatName!=null &&
              this.outputFormatName.equals(other.getOutputFormatName()))) &&
            ((this.filters==null && other.getFilters()==null) || 
             (this.filters!=null &&
              java.util.Arrays.equals(this.filters, other.getFilters()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.burstInfo==null && other.getBurstInfo()==null) || 
             (this.burstInfo!=null &&
              this.burstInfo.equals(other.getBurstInfo()))) &&
            ((this.saveOutput==null && other.getSaveOutput()==null) || 
             (this.saveOutput!=null &&
              this.saveOutput.equals(other.getSaveOutput()))) &&
            ((this.promptValues==null && other.getPromptValues()==null) || 
             (this.promptValues!=null &&
              java.util.Arrays.equals(this.promptValues, other.getPromptValues()))) &&
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
        if (getSourceID() != null) {
            _hashCode += getSourceID().hashCode();
        }
        if (getSourceType() != null) {
            _hashCode += getSourceType().hashCode();
        }
        if (getOutputFormatName() != null) {
            _hashCode += getOutputFormatName().hashCode();
        }
        if (getFilters() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFilters());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFilters(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getBurstInfo() != null) {
            _hashCode += getBurstInfo().hashCode();
        }
        if (getSaveOutput() != null) {
            _hashCode += getSaveOutput().hashCode();
        }
        if (getPromptValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPromptValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPromptValues(), i);
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
        new org.apache.axis.description.TypeDesc(GetOutputFormatRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "sourceID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "sourceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SourceTypeEnum"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputFormatName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "outputFormatName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "filters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "filters"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "versionSelection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("burstInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "burstInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "BurstType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saveOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "saveOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promptValues");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "promptValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "promptValues"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
