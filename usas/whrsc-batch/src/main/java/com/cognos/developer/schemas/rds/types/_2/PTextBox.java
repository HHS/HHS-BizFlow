/**
 * PTextBox.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * A text box prompt
 */
public class PTextBox  implements java.io.Serializable {
    /* Name of the prompt value to be filled. */
    private java.lang.String name;

    /* True if this is a multi-value prompt. */
    private boolean multiSelect;

    /* True if this is a range prompt. Two text box UI elements should
     * be rendered by the client. */
    private boolean range;

    /* True if this prompt must be filled in to run the report. */
    private boolean required;

    private boolean numericOnly;

    /* True if this prompt should be submitted to the server immediately
     * if the value changes */
    private boolean autoSubmit;

    /* If available, the display name of the column that is being
     * prompted on */
    private java.lang.String columnName;

    private java.lang.Object extension;

    public PTextBox() {
    }

    public PTextBox(
           java.lang.String name,
           boolean multiSelect,
           boolean range,
           boolean required,
           boolean numericOnly,
           boolean autoSubmit,
           java.lang.String columnName,
           java.lang.Object extension) {
           this.name = name;
           this.multiSelect = multiSelect;
           this.range = range;
           this.required = required;
           this.numericOnly = numericOnly;
           this.autoSubmit = autoSubmit;
           this.columnName = columnName;
           this.extension = extension;
    }


    /**
     * Gets the name value for this PTextBox.
     * 
     * @return name   * Name of the prompt value to be filled.
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PTextBox.
     * 
     * @param name   * Name of the prompt value to be filled.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the multiSelect value for this PTextBox.
     * 
     * @return multiSelect   * True if this is a multi-value prompt.
     */
    public boolean isMultiSelect() {
        return multiSelect;
    }


    /**
     * Sets the multiSelect value for this PTextBox.
     * 
     * @param multiSelect   * True if this is a multi-value prompt.
     */
    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }


    /**
     * Gets the range value for this PTextBox.
     * 
     * @return range   * True if this is a range prompt. Two text box UI elements should
     * be rendered by the client.
     */
    public boolean isRange() {
        return range;
    }


    /**
     * Sets the range value for this PTextBox.
     * 
     * @param range   * True if this is a range prompt. Two text box UI elements should
     * be rendered by the client.
     */
    public void setRange(boolean range) {
        this.range = range;
    }


    /**
     * Gets the required value for this PTextBox.
     * 
     * @return required   * True if this prompt must be filled in to run the report.
     */
    public boolean isRequired() {
        return required;
    }


    /**
     * Sets the required value for this PTextBox.
     * 
     * @param required   * True if this prompt must be filled in to run the report.
     */
    public void setRequired(boolean required) {
        this.required = required;
    }


    /**
     * Gets the numericOnly value for this PTextBox.
     * 
     * @return numericOnly
     */
    public boolean isNumericOnly() {
        return numericOnly;
    }


    /**
     * Sets the numericOnly value for this PTextBox.
     * 
     * @param numericOnly
     */
    public void setNumericOnly(boolean numericOnly) {
        this.numericOnly = numericOnly;
    }


    /**
     * Gets the autoSubmit value for this PTextBox.
     * 
     * @return autoSubmit   * True if this prompt should be submitted to the server immediately
     * if the value changes
     */
    public boolean isAutoSubmit() {
        return autoSubmit;
    }


    /**
     * Sets the autoSubmit value for this PTextBox.
     * 
     * @param autoSubmit   * True if this prompt should be submitted to the server immediately
     * if the value changes
     */
    public void setAutoSubmit(boolean autoSubmit) {
        this.autoSubmit = autoSubmit;
    }


    /**
     * Gets the columnName value for this PTextBox.
     * 
     * @return columnName   * If available, the display name of the column that is being
     * prompted on
     */
    public java.lang.String getColumnName() {
        return columnName;
    }


    /**
     * Sets the columnName value for this PTextBox.
     * 
     * @param columnName   * If available, the display name of the column that is being
     * prompted on
     */
    public void setColumnName(java.lang.String columnName) {
        this.columnName = columnName;
    }


    /**
     * Gets the extension value for this PTextBox.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PTextBox.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTextBox)) return false;
        PTextBox other = (PTextBox) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.multiSelect == other.isMultiSelect() &&
            this.range == other.isRange() &&
            this.required == other.isRequired() &&
            this.numericOnly == other.isNumericOnly() &&
            this.autoSubmit == other.isAutoSubmit() &&
            ((this.columnName==null && other.getColumnName()==null) || 
             (this.columnName!=null &&
              this.columnName.equals(other.getColumnName()))) &&
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += (isMultiSelect() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRange() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRequired() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isNumericOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAutoSubmit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getColumnName() != null) {
            _hashCode += getColumnName().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTextBox.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PTextBox"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("multiSelect");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "multiSelect"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("range");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "range"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("required");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "required"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numericOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "numericOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoSubmit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "autoSubmit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("columnName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "columnName"));
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
