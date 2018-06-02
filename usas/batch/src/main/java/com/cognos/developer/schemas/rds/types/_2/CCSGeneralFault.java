/**
 * CCSGeneralFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class CCSGeneralFault  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    /* A descriptive message about the error that occured */
    private java.lang.String message1;

    /* Additional trace data, if available */
    private java.lang.String trace;

    public CCSGeneralFault() {
    }

    public CCSGeneralFault(
           java.lang.String message1,
           java.lang.String trace) {
        this.message1 = message1;
        this.trace = trace;
    }


    /**
     * Gets the message1 value for this CCSGeneralFault.
     * 
     * @return message1   * A descriptive message about the error that occured
     */
    public java.lang.String getMessage1() {
        return message1;
    }


    /**
     * Sets the message1 value for this CCSGeneralFault.
     * 
     * @param message1   * A descriptive message about the error that occured
     */
    public void setMessage1(java.lang.String message1) {
        this.message1 = message1;
    }


    /**
     * Gets the trace value for this CCSGeneralFault.
     * 
     * @return trace   * Additional trace data, if available
     */
    public java.lang.String getTrace() {
        return trace;
    }


    /**
     * Sets the trace value for this CCSGeneralFault.
     * 
     * @param trace   * Additional trace data, if available
     */
    public void setTrace(java.lang.String trace) {
        this.trace = trace;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CCSGeneralFault)) return false;
        CCSGeneralFault other = (CCSGeneralFault) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.message1==null && other.getMessage1()==null) || 
             (this.message1!=null &&
              this.message1.equals(other.getMessage1()))) &&
            ((this.trace==null && other.getTrace()==null) || 
             (this.trace!=null &&
              this.trace.equals(other.getTrace())));
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
        if (getMessage1() != null) {
            _hashCode += getMessage1().hashCode();
        }
        if (getTrace() != null) {
            _hashCode += getTrace().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CCSGeneralFault.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trace");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "trace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    @Override
	public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
