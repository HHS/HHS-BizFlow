/**
 * GetReportRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class GetReportRequestType  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SessionType session;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionSelection version;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersType promptAnswers;

    public GetReportRequestType() {
    }

    public GetReportRequestType(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SessionType session,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionSelection version,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersType promptAnswers) {
           this.session = session;
           this.version = version;
           this.promptAnswers = promptAnswers;
    }


    /**
     * Gets the session value for this GetReportRequestType.
     * 
     * @return session
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SessionType getSession() {
        return session;
    }


    /**
     * Sets the session value for this GetReportRequestType.
     * 
     * @param session
     */
    public void setSession(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SessionType session) {
        this.session = session;
    }


    /**
     * Gets the version value for this GetReportRequestType.
     * 
     * @return version
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionSelection getVersion() {
        return version;
    }


    /**
     * Sets the version value for this GetReportRequestType.
     * 
     * @param version
     */
    public void setVersion(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionSelection version) {
        this.version = version;
    }


    /**
     * Gets the promptAnswers value for this GetReportRequestType.
     * 
     * @return promptAnswers
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersType getPromptAnswers() {
        return promptAnswers;
    }


    /**
     * Sets the promptAnswers value for this GetReportRequestType.
     * 
     * @param promptAnswers
     */
    public void setPromptAnswers(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersType promptAnswers) {
        this.promptAnswers = promptAnswers;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReportRequestType)) return false;
        GetReportRequestType other = (GetReportRequestType) obj;
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
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.promptAnswers==null && other.getPromptAnswers()==null) || 
             (this.promptAnswers!=null &&
              this.promptAnswers.equals(other.getPromptAnswers())));
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
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getPromptAnswers() != null) {
            _hashCode += getPromptAnswers().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetReportRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetReportRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("session");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "session"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SessionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "VersionSelection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promptAnswers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "promptAnswers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersType"));
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
