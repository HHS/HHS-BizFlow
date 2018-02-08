/**
 * GetReportDataRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class GetReportDataRequest  implements java.io.Serializable {
    private java.lang.String sourceID;

    private com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType;

    private java.lang.Integer rowLimit;

    private VersionSelection version;

    private com.cognos.developer.schemas.rds.types._2.BurstType burstInfo;

    private java.lang.Boolean excludePage;

    private com.cognos.developer.schemas.rds.types._2.Filter[] filters;

    private java.lang.String format;

    private java.lang.Boolean includeLayout;

    private java.lang.Boolean saveOutput;

    /* If true, include logical page breaks in the							output */
    private java.lang.Boolean includePageBreaks;

    private PromptValue[] promptValues;

    /* Placeholder for future extensions */
    private java.lang.Object extension;

    /* When present and set to true generated URLs will be relative
     * ones */
    private java.lang.Boolean useRelativeURL;

    public GetReportDataRequest() {
    }

    public GetReportDataRequest(
           java.lang.String sourceID,
           com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType,
           java.lang.Integer rowLimit,
           com.cognos.developer.schemas.rds.types._2.VersionSelection version,
           com.cognos.developer.schemas.rds.types._2.BurstType burstInfo,
           java.lang.Boolean excludePage,
           com.cognos.developer.schemas.rds.types._2.Filter[] filters,
           java.lang.String format,
           java.lang.Boolean includeLayout,
           java.lang.Boolean saveOutput,
           java.lang.Boolean includePageBreaks,
           com.cognos.developer.schemas.rds.types._2.PromptValue[] promptValues,
           java.lang.Object extension,
           java.lang.Boolean useRelativeURL) {
           this.sourceID = sourceID;
           this.sourceType = sourceType;
           this.rowLimit = rowLimit;
           this.version = version;
           this.burstInfo = burstInfo;
           this.excludePage = excludePage;
           this.filters = filters;
           this.format = format;
           this.includeLayout = includeLayout;
           this.saveOutput = saveOutput;
           this.includePageBreaks = includePageBreaks;
           this.promptValues = promptValues;
           this.extension = extension;
           this.useRelativeURL = useRelativeURL;
    }


    /**
     * Gets the sourceID value for this GetReportDataRequest.
     * 
     * @return sourceID
     */
    public java.lang.String getSourceID() {
        return sourceID;
    }


    /**
     * Sets the sourceID value for this GetReportDataRequest.
     * 
     * @param sourceID
     */
    public void setSourceID(java.lang.String sourceID) {
        this.sourceID = sourceID;
    }


    /**
     * Gets the sourceType value for this GetReportDataRequest.
     * 
     * @return sourceType
     */
    public com.cognos.developer.schemas.rds.types._2.SourceTypeEnum getSourceType() {
        return sourceType;
    }


    /**
     * Sets the sourceType value for this GetReportDataRequest.
     * 
     * @param sourceType
     */
    public void setSourceType(com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType) {
        this.sourceType = sourceType;
    }


    /**
     * Gets the rowLimit value for this GetReportDataRequest.
     * 
     * @return rowLimit
     */
    public java.lang.Integer getRowLimit() {
        return rowLimit;
    }


    /**
     * Sets the rowLimit value for this GetReportDataRequest.
     * 
     * @param rowLimit
     */
    public void setRowLimit(java.lang.Integer rowLimit) {
        this.rowLimit = rowLimit;
    }


    /**
     * Gets the version value for this GetReportDataRequest.
     * 
     * @return version
     */
    public VersionSelection getVersion() {
        return version;
    }


    /**
     * Sets the version value for this GetReportDataRequest.
     * 
     * @param version
     */
    public void setVersion(com.cognos.developer.schemas.rds.types._2.VersionSelection version) {
        this.version = version;
    }


    /**
     * Gets the burstInfo value for this GetReportDataRequest.
     * 
     * @return burstInfo
     */
    public com.cognos.developer.schemas.rds.types._2.BurstType getBurstInfo() {
        return burstInfo;
    }


    /**
     * Sets the burstInfo value for this GetReportDataRequest.
     * 
     * @param burstInfo
     */
    public void setBurstInfo(com.cognos.developer.schemas.rds.types._2.BurstType burstInfo) {
        this.burstInfo = burstInfo;
    }


    /**
     * Gets the excludePage value for this GetReportDataRequest.
     * 
     * @return excludePage
     */
    public java.lang.Boolean getExcludePage() {
        return excludePage;
    }


    /**
     * Sets the excludePage value for this GetReportDataRequest.
     * 
     * @param excludePage
     */
    public void setExcludePage(java.lang.Boolean excludePage) {
        this.excludePage = excludePage;
    }


    /**
     * Gets the filters value for this GetReportDataRequest.
     * 
     * @return filters
     */
    public com.cognos.developer.schemas.rds.types._2.Filter[] getFilters() {
        return filters;
    }


    /**
     * Sets the filters value for this GetReportDataRequest.
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
     * Gets the format value for this GetReportDataRequest.
     * 
     * @return format
     */
    public java.lang.String getFormat() {
        return format;
    }


    /**
     * Sets the format value for this GetReportDataRequest.
     * 
     * @param format
     */
    public void setFormat(java.lang.String format) {
        this.format = format;
    }


    /**
     * Gets the includeLayout value for this GetReportDataRequest.
     * 
     * @return includeLayout
     */
    public java.lang.Boolean getIncludeLayout() {
        return includeLayout;
    }


    /**
     * Sets the includeLayout value for this GetReportDataRequest.
     * 
     * @param includeLayout
     */
    public void setIncludeLayout(java.lang.Boolean includeLayout) {
        this.includeLayout = includeLayout;
    }


    /**
     * Gets the saveOutput value for this GetReportDataRequest.
     * 
     * @return saveOutput
     */
    public java.lang.Boolean getSaveOutput() {
        return saveOutput;
    }


    /**
     * Sets the saveOutput value for this GetReportDataRequest.
     * 
     * @param saveOutput
     */
    public void setSaveOutput(java.lang.Boolean saveOutput) {
        this.saveOutput = saveOutput;
    }


    /**
     * Gets the includePageBreaks value for this GetReportDataRequest.
     * 
     * @return includePageBreaks   * If true, include logical page breaks in the							output
     */
    public java.lang.Boolean getIncludePageBreaks() {
        return includePageBreaks;
    }


    /**
     * Sets the includePageBreaks value for this GetReportDataRequest.
     * 
     * @param includePageBreaks   * If true, include logical page breaks in the							output
     */
    public void setIncludePageBreaks(java.lang.Boolean includePageBreaks) {
        this.includePageBreaks = includePageBreaks;
    }


    /**
     * Gets the promptValues value for this GetReportDataRequest.
     * 
     * @return promptValues
     */
    public PromptValue[] getPromptValues() {
        return promptValues;
    }


    /**
     * Sets the promptValues value for this GetReportDataRequest.
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
     * Gets the extension value for this GetReportDataRequest.
     * 
     * @return extension   * Placeholder for future extensions
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetReportDataRequest.
     * 
     * @param extension   * Placeholder for future extensions
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }


    /**
     * Gets the useRelativeURL value for this GetReportDataRequest.
     * 
     * @return useRelativeURL   * When present and set to true generated URLs will be relative
     * ones
     */
    public java.lang.Boolean getUseRelativeURL() {
        return useRelativeURL;
    }


    /**
     * Sets the useRelativeURL value for this GetReportDataRequest.
     * 
     * @param useRelativeURL   * When present and set to true generated URLs will be relative
     * ones
     */
    public void setUseRelativeURL(java.lang.Boolean useRelativeURL) {
        this.useRelativeURL = useRelativeURL;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReportDataRequest)) return false;
        GetReportDataRequest other = (GetReportDataRequest) obj;
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
            ((this.rowLimit==null && other.getRowLimit()==null) || 
             (this.rowLimit!=null &&
              this.rowLimit.equals(other.getRowLimit()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.burstInfo==null && other.getBurstInfo()==null) || 
             (this.burstInfo!=null &&
              this.burstInfo.equals(other.getBurstInfo()))) &&
            ((this.excludePage==null && other.getExcludePage()==null) || 
             (this.excludePage!=null &&
              this.excludePage.equals(other.getExcludePage()))) &&
            ((this.filters==null && other.getFilters()==null) || 
             (this.filters!=null &&
              java.util.Arrays.equals(this.filters, other.getFilters()))) &&
            ((this.format==null && other.getFormat()==null) || 
             (this.format!=null &&
              this.format.equals(other.getFormat()))) &&
            ((this.includeLayout==null && other.getIncludeLayout()==null) || 
             (this.includeLayout!=null &&
              this.includeLayout.equals(other.getIncludeLayout()))) &&
            ((this.saveOutput==null && other.getSaveOutput()==null) || 
             (this.saveOutput!=null &&
              this.saveOutput.equals(other.getSaveOutput()))) &&
            ((this.includePageBreaks==null && other.getIncludePageBreaks()==null) || 
             (this.includePageBreaks!=null &&
              this.includePageBreaks.equals(other.getIncludePageBreaks()))) &&
            ((this.promptValues==null && other.getPromptValues()==null) || 
             (this.promptValues!=null &&
              java.util.Arrays.equals(this.promptValues, other.getPromptValues()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension()))) &&
            ((this.useRelativeURL==null && other.getUseRelativeURL()==null) || 
             (this.useRelativeURL!=null &&
              this.useRelativeURL.equals(other.getUseRelativeURL())));
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
        if (getRowLimit() != null) {
            _hashCode += getRowLimit().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getBurstInfo() != null) {
            _hashCode += getBurstInfo().hashCode();
        }
        if (getExcludePage() != null) {
            _hashCode += getExcludePage().hashCode();
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
        if (getFormat() != null) {
            _hashCode += getFormat().hashCode();
        }
        if (getIncludeLayout() != null) {
            _hashCode += getIncludeLayout().hashCode();
        }
        if (getSaveOutput() != null) {
            _hashCode += getSaveOutput().hashCode();
        }
        if (getIncludePageBreaks() != null) {
            _hashCode += getIncludePageBreaks().hashCode();
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
        if (getUseRelativeURL() != null) {
            _hashCode += getUseRelativeURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetReportDataRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetReportDataRequest"));
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
        elemField.setFieldName("rowLimit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "rowLimit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "IntegerValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("excludePage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "excludePage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("format");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "format"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeLayout");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "includeLayout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
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
        elemField.setFieldName("includePageBreaks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "includePageBreaks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useRelativeURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "useRelativeURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
