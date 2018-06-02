/**
 * OutputType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class OutputType  implements java.io.Serializable {
    private com.cognos.developer.schemas.rds.types._2.LDXOutputType LDXOutput;

    private com.cognos.developer.schemas.rds.types._2.PromptAnswerOutputType promptAnswerOutput;

    private java.lang.String formatOutput;

    private java.lang.Object extension;

    public OutputType() {
    }

    public OutputType(
           com.cognos.developer.schemas.rds.types._2.LDXOutputType LDXOutput,
           com.cognos.developer.schemas.rds.types._2.PromptAnswerOutputType promptAnswerOutput,
           java.lang.String formatOutput,
           java.lang.Object extension) {
           this.LDXOutput = LDXOutput;
           this.promptAnswerOutput = promptAnswerOutput;
           this.formatOutput = formatOutput;
           this.extension = extension;
    }


    /**
     * Gets the LDXOutput value for this OutputType.
     * 
     * @return LDXOutput
     */
    public com.cognos.developer.schemas.rds.types._2.LDXOutputType getLDXOutput() {
        return LDXOutput;
    }


    /**
     * Sets the LDXOutput value for this OutputType.
     * 
     * @param LDXOutput
     */
    public void setLDXOutput(com.cognos.developer.schemas.rds.types._2.LDXOutputType LDXOutput) {
        this.LDXOutput = LDXOutput;
    }


    /**
     * Gets the promptAnswerOutput value for this OutputType.
     * 
     * @return promptAnswerOutput
     */
    public com.cognos.developer.schemas.rds.types._2.PromptAnswerOutputType getPromptAnswerOutput() {
        return promptAnswerOutput;
    }


    /**
     * Sets the promptAnswerOutput value for this OutputType.
     * 
     * @param promptAnswerOutput
     */
    public void setPromptAnswerOutput(com.cognos.developer.schemas.rds.types._2.PromptAnswerOutputType promptAnswerOutput) {
        this.promptAnswerOutput = promptAnswerOutput;
    }


    /**
     * Gets the formatOutput value for this OutputType.
     * 
     * @return formatOutput
     */
    public java.lang.String getFormatOutput() {
        return formatOutput;
    }


    /**
     * Sets the formatOutput value for this OutputType.
     * 
     * @param formatOutput
     */
    public void setFormatOutput(java.lang.String formatOutput) {
        this.formatOutput = formatOutput;
    }


    /**
     * Gets the extension value for this OutputType.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this OutputType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutputType)) return false;
        OutputType other = (OutputType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LDXOutput==null && other.getLDXOutput()==null) || 
             (this.LDXOutput!=null &&
              this.LDXOutput.equals(other.getLDXOutput()))) &&
            ((this.promptAnswerOutput==null && other.getPromptAnswerOutput()==null) || 
             (this.promptAnswerOutput!=null &&
              this.promptAnswerOutput.equals(other.getPromptAnswerOutput()))) &&
            ((this.formatOutput==null && other.getFormatOutput()==null) || 
             (this.formatOutput!=null &&
              this.formatOutput.equals(other.getFormatOutput()))) &&
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
        if (getLDXOutput() != null) {
            _hashCode += getLDXOutput().hashCode();
        }
        if (getPromptAnswerOutput() != null) {
            _hashCode += getPromptAnswerOutput().hashCode();
        }
        if (getFormatOutput() != null) {
            _hashCode += getFormatOutput().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "OutputType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LDXOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "LDXOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "LDXOutputType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promptAnswerOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PromptAnswerOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PromptAnswerOutputType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatOutput");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "FormatOutput"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
