/**
 * PValueArrayItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class PValueArrayItem  implements java.io.Serializable {
    /* A simple prompt value */
    private SimplePValue simplePValue;

    /* A range prompt value */
    private RangePValue rangePValue;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType sval;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType rval;

    private java.lang.Object extension;

    public PValueArrayItem() {
    }

    public PValueArrayItem(
           com.cognos.developer.schemas.rds.types._2.SimplePValue simplePValue,
           com.cognos.developer.schemas.rds.types._2.RangePValue rangePValue,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType sval,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType rval,
           java.lang.Object extension) {
           this.simplePValue = simplePValue;
           this.rangePValue = rangePValue;
           this.sval = sval;
           this.rval = rval;
           this.extension = extension;
    }


    /**
     * Gets the simplePValue value for this PValueArrayItem.
     * 
     * @return simplePValue   * A simple prompt value
     */
    public SimplePValue getSimplePValue() {
        return simplePValue;
    }


    /**
     * Sets the simplePValue value for this PValueArrayItem.
     * 
     * @param simplePValue   * A simple prompt value
     */
    public void setSimplePValue(com.cognos.developer.schemas.rds.types._2.SimplePValue simplePValue) {
        this.simplePValue = simplePValue;
    }


    /**
     * Gets the rangePValue value for this PValueArrayItem.
     * 
     * @return rangePValue   * A range prompt value
     */
    public RangePValue getRangePValue() {
        return rangePValue;
    }


    /**
     * Sets the rangePValue value for this PValueArrayItem.
     * 
     * @param rangePValue   * A range prompt value
     */
    public void setRangePValue(com.cognos.developer.schemas.rds.types._2.RangePValue rangePValue) {
        this.rangePValue = rangePValue;
    }


    /**
     * Gets the sval value for this PValueArrayItem.
     * 
     * @return sval
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType getSval() {
        return sval;
    }


    /**
     * Sets the sval value for this PValueArrayItem.
     * 
     * @param sval
     */
    public void setSval(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType sval) {
        this.sval = sval;
    }


    /**
     * Gets the rval value for this PValueArrayItem.
     * 
     * @return rval
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType getRval() {
        return rval;
    }


    /**
     * Sets the rval value for this PValueArrayItem.
     * 
     * @param rval
     */
    public void setRval(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType rval) {
        this.rval = rval;
    }


    /**
     * Gets the extension value for this PValueArrayItem.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PValueArrayItem.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PValueArrayItem)) return false;
        PValueArrayItem other = (PValueArrayItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.simplePValue==null && other.getSimplePValue()==null) || 
             (this.simplePValue!=null &&
              this.simplePValue.equals(other.getSimplePValue()))) &&
            ((this.rangePValue==null && other.getRangePValue()==null) || 
             (this.rangePValue!=null &&
              this.rangePValue.equals(other.getRangePValue()))) &&
            ((this.sval==null && other.getSval()==null) || 
             (this.sval!=null &&
              this.sval.equals(other.getSval()))) &&
            ((this.rval==null && other.getRval()==null) || 
             (this.rval!=null &&
              this.rval.equals(other.getRval()))) &&
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
        if (getSimplePValue() != null) {
            _hashCode += getSimplePValue().hashCode();
        }
        if (getRangePValue() != null) {
            _hashCode += getRangePValue().hashCode();
        }
        if (getSval() != null) {
            _hashCode += getSval().hashCode();
        }
        if (getRval() != null) {
            _hashCode += getRval().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PValueArrayItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PValueArrayItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("simplePValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SimplePValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SimplePValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rangePValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "RangePValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "RangePValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "sval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SimplePromptValueType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "rval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RangePromptValueType"));
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
