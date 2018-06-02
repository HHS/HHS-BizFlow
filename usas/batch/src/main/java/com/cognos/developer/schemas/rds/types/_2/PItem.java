/**
 * PItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * A prompt item
 */
public class PItem  implements java.io.Serializable {
    /* Represents a selectValue prompt, usually represented as either
     * a list box (multi-value) or as a dropdown list (single value) */
    private com.cognos.developer.schemas.rds.types._2.PListBox PListBox;

    /* Represents a type-in prompt. */
    private com.cognos.developer.schemas.rds.types._2.PTextBox PTextBox;

    /* Represents a tree prompt */
    private com.cognos.developer.schemas.rds.types._2.PTreePromptType PTreePrompt;

    /* Represents any of the datetime prompts (date, datetime, time,
     * and interval). Usually rendered with a calender control. */
    private com.cognos.developer.schemas.rds.types._2.PDateTimeBox PDateTimeBox;

    /* Represents a Data Source signon prompt */
    private com.cognos.developer.schemas.rds.types._2.PDataSourceType PDataSource;

    /* Represents a Search and Select promp */
    private com.cognos.developer.schemas.rds.types._2.PSearchAndSelectType PSearchAndSelect;

    private java.lang.Object extension;

    public PItem() {
    }

    public PItem(
           com.cognos.developer.schemas.rds.types._2.PListBox PListBox,
           com.cognos.developer.schemas.rds.types._2.PTextBox PTextBox,
           com.cognos.developer.schemas.rds.types._2.PTreePromptType PTreePrompt,
           com.cognos.developer.schemas.rds.types._2.PDateTimeBox PDateTimeBox,
           com.cognos.developer.schemas.rds.types._2.PDataSourceType PDataSource,
           com.cognos.developer.schemas.rds.types._2.PSearchAndSelectType PSearchAndSelect,
           java.lang.Object extension) {
           this.PListBox = PListBox;
           this.PTextBox = PTextBox;
           this.PTreePrompt = PTreePrompt;
           this.PDateTimeBox = PDateTimeBox;
           this.PDataSource = PDataSource;
           this.PSearchAndSelect = PSearchAndSelect;
           this.extension = extension;
    }


    /**
     * Gets the PListBox value for this PItem.
     * 
     * @return PListBox   * Represents a selectValue prompt, usually represented as either
     * a list box (multi-value) or as a dropdown list (single value)
     */
    public com.cognos.developer.schemas.rds.types._2.PListBox getPListBox() {
        return PListBox;
    }


    /**
     * Sets the PListBox value for this PItem.
     * 
     * @param PListBox   * Represents a selectValue prompt, usually represented as either
     * a list box (multi-value) or as a dropdown list (single value)
     */
    public void setPListBox(com.cognos.developer.schemas.rds.types._2.PListBox PListBox) {
        this.PListBox = PListBox;
    }


    /**
     * Gets the PTextBox value for this PItem.
     * 
     * @return PTextBox   * Represents a type-in prompt.
     */
    public com.cognos.developer.schemas.rds.types._2.PTextBox getPTextBox() {
        return PTextBox;
    }


    /**
     * Sets the PTextBox value for this PItem.
     * 
     * @param PTextBox   * Represents a type-in prompt.
     */
    public void setPTextBox(com.cognos.developer.schemas.rds.types._2.PTextBox PTextBox) {
        this.PTextBox = PTextBox;
    }


    /**
     * Gets the PTreePrompt value for this PItem.
     * 
     * @return PTreePrompt   * Represents a tree prompt
     */
    public com.cognos.developer.schemas.rds.types._2.PTreePromptType getPTreePrompt() {
        return PTreePrompt;
    }


    /**
     * Sets the PTreePrompt value for this PItem.
     * 
     * @param PTreePrompt   * Represents a tree prompt
     */
    public void setPTreePrompt(com.cognos.developer.schemas.rds.types._2.PTreePromptType PTreePrompt) {
        this.PTreePrompt = PTreePrompt;
    }


    /**
     * Gets the PDateTimeBox value for this PItem.
     * 
     * @return PDateTimeBox   * Represents any of the datetime prompts (date, datetime, time,
     * and interval). Usually rendered with a calender control.
     */
    public com.cognos.developer.schemas.rds.types._2.PDateTimeBox getPDateTimeBox() {
        return PDateTimeBox;
    }


    /**
     * Sets the PDateTimeBox value for this PItem.
     * 
     * @param PDateTimeBox   * Represents any of the datetime prompts (date, datetime, time,
     * and interval). Usually rendered with a calender control.
     */
    public void setPDateTimeBox(com.cognos.developer.schemas.rds.types._2.PDateTimeBox PDateTimeBox) {
        this.PDateTimeBox = PDateTimeBox;
    }


    /**
     * Gets the PDataSource value for this PItem.
     * 
     * @return PDataSource   * Represents a Data Source signon prompt
     */
    public com.cognos.developer.schemas.rds.types._2.PDataSourceType getPDataSource() {
        return PDataSource;
    }


    /**
     * Sets the PDataSource value for this PItem.
     * 
     * @param PDataSource   * Represents a Data Source signon prompt
     */
    public void setPDataSource(com.cognos.developer.schemas.rds.types._2.PDataSourceType PDataSource) {
        this.PDataSource = PDataSource;
    }


    /**
     * Gets the PSearchAndSelect value for this PItem.
     * 
     * @return PSearchAndSelect   * Represents a Search and Select promp
     */
    public com.cognos.developer.schemas.rds.types._2.PSearchAndSelectType getPSearchAndSelect() {
        return PSearchAndSelect;
    }


    /**
     * Sets the PSearchAndSelect value for this PItem.
     * 
     * @param PSearchAndSelect   * Represents a Search and Select promp
     */
    public void setPSearchAndSelect(com.cognos.developer.schemas.rds.types._2.PSearchAndSelectType PSearchAndSelect) {
        this.PSearchAndSelect = PSearchAndSelect;
    }


    /**
     * Gets the extension value for this PItem.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PItem.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PItem)) return false;
        PItem other = (PItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PListBox==null && other.getPListBox()==null) || 
             (this.PListBox!=null &&
              this.PListBox.equals(other.getPListBox()))) &&
            ((this.PTextBox==null && other.getPTextBox()==null) || 
             (this.PTextBox!=null &&
              this.PTextBox.equals(other.getPTextBox()))) &&
            ((this.PTreePrompt==null && other.getPTreePrompt()==null) || 
             (this.PTreePrompt!=null &&
              this.PTreePrompt.equals(other.getPTreePrompt()))) &&
            ((this.PDateTimeBox==null && other.getPDateTimeBox()==null) || 
             (this.PDateTimeBox!=null &&
              this.PDateTimeBox.equals(other.getPDateTimeBox()))) &&
            ((this.PDataSource==null && other.getPDataSource()==null) || 
             (this.PDataSource!=null &&
              this.PDataSource.equals(other.getPDataSource()))) &&
            ((this.PSearchAndSelect==null && other.getPSearchAndSelect()==null) || 
             (this.PSearchAndSelect!=null &&
              this.PSearchAndSelect.equals(other.getPSearchAndSelect()))) &&
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
        if (getPListBox() != null) {
            _hashCode += getPListBox().hashCode();
        }
        if (getPTextBox() != null) {
            _hashCode += getPTextBox().hashCode();
        }
        if (getPTreePrompt() != null) {
            _hashCode += getPTreePrompt().hashCode();
        }
        if (getPDateTimeBox() != null) {
            _hashCode += getPDateTimeBox().hashCode();
        }
        if (getPDataSource() != null) {
            _hashCode += getPDataSource().hashCode();
        }
        if (getPSearchAndSelect() != null) {
            _hashCode += getPSearchAndSelect().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PListBox");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PListBox"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PListBox"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PTextBox");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PTextBox"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PTextBox"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PTreePrompt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PTreePrompt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PTreePromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PDateTimeBox");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PDateTimeBox"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PDateTimeBox"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PDataSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PDataSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PDataSourceType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PSearchAndSelect");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PSearchAndSelect"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PSearchAndSelectType"));
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
