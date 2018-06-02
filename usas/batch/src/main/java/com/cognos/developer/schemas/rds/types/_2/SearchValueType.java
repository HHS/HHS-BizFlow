/**
 * SearchValueType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class SearchValueType  implements java.io.Serializable {
    private java.lang.String srchval;

    private java.lang.String swsID;

    private java.lang.String pname;

    private java.lang.Boolean nocase;

    private java.lang.Boolean mtchAny;

    private java.lang.Boolean mtchAll;

    private java.lang.Object extension;

    public SearchValueType() {
    }

    public SearchValueType(
           java.lang.String srchval,
           java.lang.String swsID,
           java.lang.String pname,
           java.lang.Boolean nocase,
           java.lang.Boolean mtchAny,
           java.lang.Boolean mtchAll,
           java.lang.Object extension) {
           this.srchval = srchval;
           this.swsID = swsID;
           this.pname = pname;
           this.nocase = nocase;
           this.mtchAny = mtchAny;
           this.mtchAll = mtchAll;
           this.extension = extension;
    }


    /**
     * Gets the srchval value for this SearchValueType.
     * 
     * @return srchval
     */
    public java.lang.String getSrchval() {
        return srchval;
    }


    /**
     * Sets the srchval value for this SearchValueType.
     * 
     * @param srchval
     */
    public void setSrchval(java.lang.String srchval) {
        this.srchval = srchval;
    }


    /**
     * Gets the swsID value for this SearchValueType.
     * 
     * @return swsID
     */
    public java.lang.String getSwsID() {
        return swsID;
    }


    /**
     * Sets the swsID value for this SearchValueType.
     * 
     * @param swsID
     */
    public void setSwsID(java.lang.String swsID) {
        this.swsID = swsID;
    }


    /**
     * Gets the pname value for this SearchValueType.
     * 
     * @return pname
     */
    public java.lang.String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this SearchValueType.
     * 
     * @param pname
     */
    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }


    /**
     * Gets the nocase value for this SearchValueType.
     * 
     * @return nocase
     */
    public java.lang.Boolean getNocase() {
        return nocase;
    }


    /**
     * Sets the nocase value for this SearchValueType.
     * 
     * @param nocase
     */
    public void setNocase(java.lang.Boolean nocase) {
        this.nocase = nocase;
    }


    /**
     * Gets the mtchAny value for this SearchValueType.
     * 
     * @return mtchAny
     */
    public java.lang.Boolean getMtchAny() {
        return mtchAny;
    }


    /**
     * Sets the mtchAny value for this SearchValueType.
     * 
     * @param mtchAny
     */
    public void setMtchAny(java.lang.Boolean mtchAny) {
        this.mtchAny = mtchAny;
    }


    /**
     * Gets the mtchAll value for this SearchValueType.
     * 
     * @return mtchAll
     */
    public java.lang.Boolean getMtchAll() {
        return mtchAll;
    }


    /**
     * Sets the mtchAll value for this SearchValueType.
     * 
     * @param mtchAll
     */
    public void setMtchAll(java.lang.Boolean mtchAll) {
        this.mtchAll = mtchAll;
    }


    /**
     * Gets the extension value for this SearchValueType.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this SearchValueType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchValueType)) return false;
        SearchValueType other = (SearchValueType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.srchval==null && other.getSrchval()==null) || 
             (this.srchval!=null &&
              this.srchval.equals(other.getSrchval()))) &&
            ((this.swsID==null && other.getSwsID()==null) || 
             (this.swsID!=null &&
              this.swsID.equals(other.getSwsID()))) &&
            ((this.pname==null && other.getPname()==null) || 
             (this.pname!=null &&
              this.pname.equals(other.getPname()))) &&
            ((this.nocase==null && other.getNocase()==null) || 
             (this.nocase!=null &&
              this.nocase.equals(other.getNocase()))) &&
            ((this.mtchAny==null && other.getMtchAny()==null) || 
             (this.mtchAny!=null &&
              this.mtchAny.equals(other.getMtchAny()))) &&
            ((this.mtchAll==null && other.getMtchAll()==null) || 
             (this.mtchAll!=null &&
              this.mtchAll.equals(other.getMtchAll()))) &&
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
        if (getSrchval() != null) {
            _hashCode += getSrchval().hashCode();
        }
        if (getSwsID() != null) {
            _hashCode += getSwsID().hashCode();
        }
        if (getPname() != null) {
            _hashCode += getPname().hashCode();
        }
        if (getNocase() != null) {
            _hashCode += getNocase().hashCode();
        }
        if (getMtchAny() != null) {
            _hashCode += getMtchAny().hashCode();
        }
        if (getMtchAll() != null) {
            _hashCode += getMtchAll().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchValueType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchValueType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("srchval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "srchval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("swsID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "swsID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "pname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nocase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "nocase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mtchAny");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "mtchAny"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mtchAll");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "mtchAll"));
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
