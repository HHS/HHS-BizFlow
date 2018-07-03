/**
 * SearchPValueType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class SearchPValueType  implements java.io.Serializable {
    /* The keywords you are searching on */
    private java.lang.String value;

    /* The parameter that the search is associated with */
    private java.lang.String parameterName;

    /* The ID of the PSearchAndSelect prompt control */
    private java.lang.String id;

    /* Perform a case insensitive search. Defaults to true */
    private java.lang.Boolean caseInsensitive;

    /* If true, then the results must start with the first keyword
     * and contain the remaining keywords. If matchAnywhere is also true,
     * then the search must contain all the keywords in any order */
    private java.lang.Boolean matchAll;

    /* If true, then the result must contain any of the key words.
     * If both this and matchAll are false, then the search result includes
     * anything that starts with any of the key words */
    private java.lang.Boolean matchAnywhere;

    private java.lang.Object extension;

    public SearchPValueType() {
    }

    public SearchPValueType(
           java.lang.String value,
           java.lang.String parameterName,
           java.lang.String id,
           java.lang.Boolean caseInsensitive,
           java.lang.Boolean matchAll,
           java.lang.Boolean matchAnywhere,
           java.lang.Object extension) {
           this.value = value;
           this.parameterName = parameterName;
           this.id = id;
           this.caseInsensitive = caseInsensitive;
           this.matchAll = matchAll;
           this.matchAnywhere = matchAnywhere;
           this.extension = extension;
    }


    /**
     * Gets the value value for this SearchPValueType.
     * 
     * @return value   * The keywords you are searching on
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this SearchPValueType.
     * 
     * @param value   * The keywords you are searching on
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the parameterName value for this SearchPValueType.
     * 
     * @return parameterName   * The parameter that the search is associated with
     */
    public java.lang.String getParameterName() {
        return parameterName;
    }


    /**
     * Sets the parameterName value for this SearchPValueType.
     * 
     * @param parameterName   * The parameter that the search is associated with
     */
    public void setParameterName(java.lang.String parameterName) {
        this.parameterName = parameterName;
    }


    /**
     * Gets the id value for this SearchPValueType.
     * 
     * @return id   * The ID of the PSearchAndSelect prompt control
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this SearchPValueType.
     * 
     * @param id   * The ID of the PSearchAndSelect prompt control
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the caseInsensitive value for this SearchPValueType.
     * 
     * @return caseInsensitive   * Perform a case insensitive search. Defaults to true
     */
    public java.lang.Boolean getCaseInsensitive() {
        return caseInsensitive;
    }


    /**
     * Sets the caseInsensitive value for this SearchPValueType.
     * 
     * @param caseInsensitive   * Perform a case insensitive search. Defaults to true
     */
    public void setCaseInsensitive(java.lang.Boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }


    /**
     * Gets the matchAll value for this SearchPValueType.
     * 
     * @return matchAll   * If true, then the results must start with the first keyword
     * and contain the remaining keywords. If matchAnywhere is also true,
     * then the search must contain all the keywords in any order
     */
    public java.lang.Boolean getMatchAll() {
        return matchAll;
    }


    /**
     * Sets the matchAll value for this SearchPValueType.
     * 
     * @param matchAll   * If true, then the results must start with the first keyword
     * and contain the remaining keywords. If matchAnywhere is also true,
     * then the search must contain all the keywords in any order
     */
    public void setMatchAll(java.lang.Boolean matchAll) {
        this.matchAll = matchAll;
    }


    /**
     * Gets the matchAnywhere value for this SearchPValueType.
     * 
     * @return matchAnywhere   * If true, then the result must contain any of the key words.
     * If both this and matchAll are false, then the search result includes
     * anything that starts with any of the key words
     */
    public java.lang.Boolean getMatchAnywhere() {
        return matchAnywhere;
    }


    /**
     * Sets the matchAnywhere value for this SearchPValueType.
     * 
     * @param matchAnywhere   * If true, then the result must contain any of the key words.
     * If both this and matchAll are false, then the search result includes
     * anything that starts with any of the key words
     */
    public void setMatchAnywhere(java.lang.Boolean matchAnywhere) {
        this.matchAnywhere = matchAnywhere;
    }


    /**
     * Gets the extension value for this SearchPValueType.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this SearchPValueType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchPValueType)) return false;
        SearchPValueType other = (SearchPValueType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.parameterName==null && other.getParameterName()==null) || 
             (this.parameterName!=null &&
              this.parameterName.equals(other.getParameterName()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.caseInsensitive==null && other.getCaseInsensitive()==null) || 
             (this.caseInsensitive!=null &&
              this.caseInsensitive.equals(other.getCaseInsensitive()))) &&
            ((this.matchAll==null && other.getMatchAll()==null) || 
             (this.matchAll!=null &&
              this.matchAll.equals(other.getMatchAll()))) &&
            ((this.matchAnywhere==null && other.getMatchAnywhere()==null) || 
             (this.matchAnywhere!=null &&
              this.matchAnywhere.equals(other.getMatchAnywhere()))) &&
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
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getParameterName() != null) {
            _hashCode += getParameterName().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getCaseInsensitive() != null) {
            _hashCode += getCaseInsensitive().hashCode();
        }
        if (getMatchAll() != null) {
            _hashCode += getMatchAll().hashCode();
        }
        if (getMatchAnywhere() != null) {
            _hashCode += getMatchAnywhere().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchPValueType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchPValueType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameterName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "parameterName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseInsensitive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "caseInsensitive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchAll");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "matchAll"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchAnywhere");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "matchAnywhere"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
