/**
 * ForwardRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class ForwardRequestType  implements java.io.Serializable {
    private SessionType session;

    private PromptValue[] promptValues;

    private com.cognos.developer.schemas.rds.types._2.SearchValueType searchValue;

    private java.lang.Object extension;

    public ForwardRequestType() {
    }

    public ForwardRequestType(
           com.cognos.developer.schemas.rds.types._2.SessionType session,
           com.cognos.developer.schemas.rds.types._2.PromptValue[] promptValues,
           com.cognos.developer.schemas.rds.types._2.SearchValueType searchValue,
           java.lang.Object extension) {
           this.session = session;
           this.promptValues = promptValues;
           this.searchValue = searchValue;
           this.extension = extension;
    }


    /**
     * Gets the session value for this ForwardRequestType.
     * 
     * @return session
     */
    public SessionType getSession() {
        return session;
    }


    /**
     * Sets the session value for this ForwardRequestType.
     * 
     * @param session
     */
    public void setSession(com.cognos.developer.schemas.rds.types._2.SessionType session) {
        this.session = session;
    }


    /**
     * Gets the promptValues value for this ForwardRequestType.
     * 
     * @return promptValues
     */
    public PromptValue[] getPromptValues() {
        return promptValues;
    }


    /**
     * Sets the promptValues value for this ForwardRequestType.
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
     * Gets the searchValue value for this ForwardRequestType.
     * 
     * @return searchValue
     */
    public com.cognos.developer.schemas.rds.types._2.SearchValueType getSearchValue() {
        return searchValue;
    }


    /**
     * Sets the searchValue value for this ForwardRequestType.
     * 
     * @param searchValue
     */
    public void setSearchValue(com.cognos.developer.schemas.rds.types._2.SearchValueType searchValue) {
        this.searchValue = searchValue;
    }


    /**
     * Gets the extension value for this ForwardRequestType.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this ForwardRequestType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ForwardRequestType)) return false;
        ForwardRequestType other = (ForwardRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.session==null && other.getSession()==null) || 
             (this.session!=null &&
              this.session.equals(other.getSession()))) &&
            ((this.promptValues==null && other.getPromptValues()==null) || 
             (this.promptValues!=null &&
              java.util.Arrays.equals(this.promptValues, other.getPromptValues()))) &&
            ((this.searchValue==null && other.getSearchValue()==null) || 
             (this.searchValue!=null &&
              this.searchValue.equals(other.getSearchValue()))) &&
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
        if (getSession() != null) {
            _hashCode += getSession().hashCode();
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
        if (getSearchValue() != null) {
            _hashCode += getSearchValue().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ForwardRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "ForwardRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("session");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "session"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SessionType"));
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
        elemField.setFieldName("searchValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchValueType"));
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
