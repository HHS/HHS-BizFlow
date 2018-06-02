/**
 * Page1_FooterType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Page1_FooterType  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runDate1;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame pageNumber;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runTime1;

    public Page1_FooterType() {
    }

    public Page1_FooterType(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runDate1,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame pageNumber,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runTime1) {
           this.runDate1 = runDate1;
           this.pageNumber = pageNumber;
           this.runTime1 = runTime1;
    }


    /**
     * Gets the runDate1 value for this Page1_FooterType.
     * 
     * @return runDate1
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame getRunDate1() {
        return runDate1;
    }


    /**
     * Sets the runDate1 value for this Page1_FooterType.
     * 
     * @param runDate1
     */
    public void setRunDate1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runDate1) {
        this.runDate1 = runDate1;
    }


    /**
     * Gets the pageNumber value for this Page1_FooterType.
     * 
     * @return pageNumber
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame getPageNumber() {
        return pageNumber;
    }


    /**
     * Sets the pageNumber value for this Page1_FooterType.
     * 
     * @param pageNumber
     */
    public void setPageNumber(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame pageNumber) {
        this.pageNumber = pageNumber;
    }


    /**
     * Gets the runTime1 value for this Page1_FooterType.
     * 
     * @return runTime1
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame getRunTime1() {
        return runTime1;
    }


    /**
     * Sets the runTime1 value for this Page1_FooterType.
     * 
     * @param runTime1
     */
    public void setRunTime1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame runTime1) {
        this.runTime1 = runTime1;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Page1_FooterType)) return false;
        Page1_FooterType other = (Page1_FooterType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.runDate1==null && other.getRunDate1()==null) || 
             (this.runDate1!=null &&
              this.runDate1.equals(other.getRunDate1()))) &&
            ((this.pageNumber==null && other.getPageNumber()==null) || 
             (this.pageNumber!=null &&
              this.pageNumber.equals(other.getPageNumber()))) &&
            ((this.runTime1==null && other.getRunTime1()==null) || 
             (this.runTime1!=null &&
              this.runTime1.equals(other.getRunTime1())));
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
        if (getRunDate1() != null) {
            _hashCode += getRunDate1().hashCode();
        }
        if (getPageNumber() != null) {
            _hashCode += getPageNumber().hashCode();
        }
        if (getRunTime1() != null) {
            _hashCode += getRunTime1().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Page1_FooterType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_FooterType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("runDate1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RunDate1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PageNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("runTime1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RunTime1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame"));
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
