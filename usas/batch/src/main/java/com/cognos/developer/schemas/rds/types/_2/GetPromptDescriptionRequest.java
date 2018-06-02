/**
 * GetPromptDescriptionRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class GetPromptDescriptionRequest  implements java.io.Serializable {
    private java.lang.String sourceID;

    private com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType;

    /* Used if there are multiple promp pages. The response to this
     * request will contain a conversation ID, which must be passed into
     * the the next DescribePromptsRequest to fetch the second page. */
    private java.lang.String conversationID;

    /* If true, indicates that the current page should be repromtped
     * instead of going to the next page. Used when a prompt description
     * has the attribute autoSubmit=true */
    private java.lang.Boolean reprompt;

    /* The answers from previous prompt pages */
    private PromptValue[] promptValues;

    private com.cognos.developer.schemas.rds.types._2.SearchPValueType searchPValue;

    private java.lang.Object extension;

    public GetPromptDescriptionRequest() {
    }

    public GetPromptDescriptionRequest(
           java.lang.String sourceID,
           com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType,
           java.lang.String conversationID,
           java.lang.Boolean reprompt,
           com.cognos.developer.schemas.rds.types._2.PromptValue[] promptValues,
           com.cognos.developer.schemas.rds.types._2.SearchPValueType searchPValue,
           java.lang.Object extension) {
           this.sourceID = sourceID;
           this.sourceType = sourceType;
           this.conversationID = conversationID;
           this.reprompt = reprompt;
           this.promptValues = promptValues;
           this.searchPValue = searchPValue;
           this.extension = extension;
    }


    /**
     * Gets the sourceID value for this GetPromptDescriptionRequest.
     * 
     * @return sourceID
     */
    public java.lang.String getSourceID() {
        return sourceID;
    }


    /**
     * Sets the sourceID value for this GetPromptDescriptionRequest.
     * 
     * @param sourceID
     */
    public void setSourceID(java.lang.String sourceID) {
        this.sourceID = sourceID;
    }


    /**
     * Gets the sourceType value for this GetPromptDescriptionRequest.
     * 
     * @return sourceType
     */
    public com.cognos.developer.schemas.rds.types._2.SourceTypeEnum getSourceType() {
        return sourceType;
    }


    /**
     * Sets the sourceType value for this GetPromptDescriptionRequest.
     * 
     * @param sourceType
     */
    public void setSourceType(com.cognos.developer.schemas.rds.types._2.SourceTypeEnum sourceType) {
        this.sourceType = sourceType;
    }


    /**
     * Gets the conversationID value for this GetPromptDescriptionRequest.
     * 
     * @return conversationID   * Used if there are multiple promp pages. The response to this
     * request will contain a conversation ID, which must be passed into
     * the the next DescribePromptsRequest to fetch the second page.
     */
    public java.lang.String getConversationID() {
        return conversationID;
    }


    /**
     * Sets the conversationID value for this GetPromptDescriptionRequest.
     * 
     * @param conversationID   * Used if there are multiple promp pages. The response to this
     * request will contain a conversation ID, which must be passed into
     * the the next DescribePromptsRequest to fetch the second page.
     */
    public void setConversationID(java.lang.String conversationID) {
        this.conversationID = conversationID;
    }


    /**
     * Gets the reprompt value for this GetPromptDescriptionRequest.
     * 
     * @return reprompt   * If true, indicates that the current page should be repromtped
     * instead of going to the next page. Used when a prompt description
     * has the attribute autoSubmit=true
     */
    public java.lang.Boolean getReprompt() {
        return reprompt;
    }


    /**
     * Sets the reprompt value for this GetPromptDescriptionRequest.
     * 
     * @param reprompt   * If true, indicates that the current page should be repromtped
     * instead of going to the next page. Used when a prompt description
     * has the attribute autoSubmit=true
     */
    public void setReprompt(java.lang.Boolean reprompt) {
        this.reprompt = reprompt;
    }


    /**
     * Gets the promptValues value for this GetPromptDescriptionRequest.
     * 
     * @return promptValues   * The answers from previous prompt pages
     */
    public PromptValue[] getPromptValues() {
        return promptValues;
    }


    /**
     * Sets the promptValues value for this GetPromptDescriptionRequest.
     * 
     * @param promptValues   * The answers from previous prompt pages
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
     * Gets the searchPValue value for this GetPromptDescriptionRequest.
     * 
     * @return searchPValue
     */
    public com.cognos.developer.schemas.rds.types._2.SearchPValueType getSearchPValue() {
        return searchPValue;
    }


    /**
     * Sets the searchPValue value for this GetPromptDescriptionRequest.
     * 
     * @param searchPValue
     */
    public void setSearchPValue(com.cognos.developer.schemas.rds.types._2.SearchPValueType searchPValue) {
        this.searchPValue = searchPValue;
    }


    /**
     * Gets the extension value for this GetPromptDescriptionRequest.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetPromptDescriptionRequest.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetPromptDescriptionRequest)) return false;
        GetPromptDescriptionRequest other = (GetPromptDescriptionRequest) obj;
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
            ((this.conversationID==null && other.getConversationID()==null) || 
             (this.conversationID!=null &&
              this.conversationID.equals(other.getConversationID()))) &&
            ((this.reprompt==null && other.getReprompt()==null) || 
             (this.reprompt!=null &&
              this.reprompt.equals(other.getReprompt()))) &&
            ((this.promptValues==null && other.getPromptValues()==null) || 
             (this.promptValues!=null &&
              java.util.Arrays.equals(this.promptValues, other.getPromptValues()))) &&
            ((this.searchPValue==null && other.getSearchPValue()==null) || 
             (this.searchPValue!=null &&
              this.searchPValue.equals(other.getSearchPValue()))) &&
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
        if (getConversationID() != null) {
            _hashCode += getConversationID().hashCode();
        }
        if (getReprompt() != null) {
            _hashCode += getReprompt().hashCode();
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
        if (getSearchPValue() != null) {
            _hashCode += getSearchPValue().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPromptDescriptionRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptDescriptionRequest"));
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
        elemField.setFieldName("conversationID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "conversationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reprompt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "reprompt"));
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
        elemField.setFieldName("searchPValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchPValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchPValueType"));
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
