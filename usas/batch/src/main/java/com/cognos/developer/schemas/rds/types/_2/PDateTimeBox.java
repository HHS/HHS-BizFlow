/**
 * PDateTimeBox.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * A Date/Time prompt
 */
public class PDateTimeBox  implements java.io.Serializable {
    /* Name of the prompt value to be filled. */
    private java.lang.String name;

    /* True if this is a multi-value prompt */
    private boolean multiSelect;

    /* True if this is a range prompt. */
    private boolean range;

    /* True if this prompt must be filled in to run the report. */
    private boolean required;

    /* Type of prompt (date, time, interval, etc.) */
    private com.cognos.developer.schemas.rds.types._2.DTValueType valueType;

    /* True if this prompt should be submitted to the server immediately
     * if the value changes */
    private boolean autoSubmit;

    /* Type of calendar to use. */
    private com.cognos.developer.schemas.rds.types._2.CalendarType calendarType;

    /* Display seconds. */
    private java.lang.Boolean displaySeconds;

    /* Display milliseconds. */
    private java.lang.Boolean displayMilliseconds;

    /* first date that can be selected. */
    private com.cognos.developer.schemas.rds.types._2.DateTimeValue firstDate;

    /* last date that can be selected. */
    private com.cognos.developer.schemas.rds.types._2.DateTimeValue lastDate;

    /* If available, the display name of the column that is being
     * prompted on */
    private java.lang.String columnName;

    private com.cognos.developer.schemas.rds.types._2.POptions[] selections;

    private java.lang.Object extension;

    public PDateTimeBox() {
    }

    public PDateTimeBox(
           java.lang.String name,
           boolean multiSelect,
           boolean range,
           boolean required,
           com.cognos.developer.schemas.rds.types._2.DTValueType valueType,
           boolean autoSubmit,
           com.cognos.developer.schemas.rds.types._2.CalendarType calendarType,
           java.lang.Boolean displaySeconds,
           java.lang.Boolean displayMilliseconds,
           com.cognos.developer.schemas.rds.types._2.DateTimeValue firstDate,
           com.cognos.developer.schemas.rds.types._2.DateTimeValue lastDate,
           java.lang.String columnName,
           com.cognos.developer.schemas.rds.types._2.POptions[] selections,
           java.lang.Object extension) {
           this.name = name;
           this.multiSelect = multiSelect;
           this.range = range;
           this.required = required;
           this.valueType = valueType;
           this.autoSubmit = autoSubmit;
           this.calendarType = calendarType;
           this.displaySeconds = displaySeconds;
           this.displayMilliseconds = displayMilliseconds;
           this.firstDate = firstDate;
           this.lastDate = lastDate;
           this.columnName = columnName;
           this.selections = selections;
           this.extension = extension;
    }


    /**
     * Gets the name value for this PDateTimeBox.
     * 
     * @return name   * Name of the prompt value to be filled.
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PDateTimeBox.
     * 
     * @param name   * Name of the prompt value to be filled.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the multiSelect value for this PDateTimeBox.
     * 
     * @return multiSelect   * True if this is a multi-value prompt
     */
    public boolean isMultiSelect() {
        return multiSelect;
    }


    /**
     * Sets the multiSelect value for this PDateTimeBox.
     * 
     * @param multiSelect   * True if this is a multi-value prompt
     */
    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }


    /**
     * Gets the range value for this PDateTimeBox.
     * 
     * @return range   * True if this is a range prompt.
     */
    public boolean isRange() {
        return range;
    }


    /**
     * Sets the range value for this PDateTimeBox.
     * 
     * @param range   * True if this is a range prompt.
     */
    public void setRange(boolean range) {
        this.range = range;
    }


    /**
     * Gets the required value for this PDateTimeBox.
     * 
     * @return required   * True if this prompt must be filled in to run the report.
     */
    public boolean isRequired() {
        return required;
    }


    /**
     * Sets the required value for this PDateTimeBox.
     * 
     * @param required   * True if this prompt must be filled in to run the report.
     */
    public void setRequired(boolean required) {
        this.required = required;
    }


    /**
     * Gets the valueType value for this PDateTimeBox.
     * 
     * @return valueType   * Type of prompt (date, time, interval, etc.)
     */
    public com.cognos.developer.schemas.rds.types._2.DTValueType getValueType() {
        return valueType;
    }


    /**
     * Sets the valueType value for this PDateTimeBox.
     * 
     * @param valueType   * Type of prompt (date, time, interval, etc.)
     */
    public void setValueType(com.cognos.developer.schemas.rds.types._2.DTValueType valueType) {
        this.valueType = valueType;
    }


    /**
     * Gets the autoSubmit value for this PDateTimeBox.
     * 
     * @return autoSubmit   * True if this prompt should be submitted to the server immediately
     * if the value changes
     */
    public boolean isAutoSubmit() {
        return autoSubmit;
    }


    /**
     * Sets the autoSubmit value for this PDateTimeBox.
     * 
     * @param autoSubmit   * True if this prompt should be submitted to the server immediately
     * if the value changes
     */
    public void setAutoSubmit(boolean autoSubmit) {
        this.autoSubmit = autoSubmit;
    }


    /**
     * Gets the calendarType value for this PDateTimeBox.
     * 
     * @return calendarType   * Type of calendar to use.
     */
    public com.cognos.developer.schemas.rds.types._2.CalendarType getCalendarType() {
        return calendarType;
    }


    /**
     * Sets the calendarType value for this PDateTimeBox.
     * 
     * @param calendarType   * Type of calendar to use.
     */
    public void setCalendarType(com.cognos.developer.schemas.rds.types._2.CalendarType calendarType) {
        this.calendarType = calendarType;
    }


    /**
     * Gets the displaySeconds value for this PDateTimeBox.
     * 
     * @return displaySeconds   * Display seconds.
     */
    public java.lang.Boolean getDisplaySeconds() {
        return displaySeconds;
    }


    /**
     * Sets the displaySeconds value for this PDateTimeBox.
     * 
     * @param displaySeconds   * Display seconds.
     */
    public void setDisplaySeconds(java.lang.Boolean displaySeconds) {
        this.displaySeconds = displaySeconds;
    }


    /**
     * Gets the displayMilliseconds value for this PDateTimeBox.
     * 
     * @return displayMilliseconds   * Display milliseconds.
     */
    public java.lang.Boolean getDisplayMilliseconds() {
        return displayMilliseconds;
    }


    /**
     * Sets the displayMilliseconds value for this PDateTimeBox.
     * 
     * @param displayMilliseconds   * Display milliseconds.
     */
    public void setDisplayMilliseconds(java.lang.Boolean displayMilliseconds) {
        this.displayMilliseconds = displayMilliseconds;
    }


    /**
     * Gets the firstDate value for this PDateTimeBox.
     * 
     * @return firstDate   * first date that can be selected.
     */
    public com.cognos.developer.schemas.rds.types._2.DateTimeValue getFirstDate() {
        return firstDate;
    }


    /**
     * Sets the firstDate value for this PDateTimeBox.
     * 
     * @param firstDate   * first date that can be selected.
     */
    public void setFirstDate(com.cognos.developer.schemas.rds.types._2.DateTimeValue firstDate) {
        this.firstDate = firstDate;
    }


    /**
     * Gets the lastDate value for this PDateTimeBox.
     * 
     * @return lastDate   * last date that can be selected.
     */
    public com.cognos.developer.schemas.rds.types._2.DateTimeValue getLastDate() {
        return lastDate;
    }


    /**
     * Sets the lastDate value for this PDateTimeBox.
     * 
     * @param lastDate   * last date that can be selected.
     */
    public void setLastDate(com.cognos.developer.schemas.rds.types._2.DateTimeValue lastDate) {
        this.lastDate = lastDate;
    }


    /**
     * Gets the columnName value for this PDateTimeBox.
     * 
     * @return columnName   * If available, the display name of the column that is being
     * prompted on
     */
    public java.lang.String getColumnName() {
        return columnName;
    }


    /**
     * Sets the columnName value for this PDateTimeBox.
     * 
     * @param columnName   * If available, the display name of the column that is being
     * prompted on
     */
    public void setColumnName(java.lang.String columnName) {
        this.columnName = columnName;
    }


    /**
     * Gets the selections value for this PDateTimeBox.
     * 
     * @return selections
     */
    public com.cognos.developer.schemas.rds.types._2.POptions[] getSelections() {
        return selections;
    }


    /**
     * Sets the selections value for this PDateTimeBox.
     * 
     * @param selections
     */
    public void setSelections(com.cognos.developer.schemas.rds.types._2.POptions[] selections) {
        this.selections = selections;
    }


    /**
     * Gets the extension value for this PDateTimeBox.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PDateTimeBox.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PDateTimeBox)) return false;
        PDateTimeBox other = (PDateTimeBox) obj;
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
            ((this.valueType==null && other.getValueType()==null) || 
             (this.valueType!=null &&
              this.valueType.equals(other.getValueType()))) &&
            this.autoSubmit == other.isAutoSubmit() &&
            ((this.calendarType==null && other.getCalendarType()==null) || 
             (this.calendarType!=null &&
              this.calendarType.equals(other.getCalendarType()))) &&
            ((this.displaySeconds==null && other.getDisplaySeconds()==null) || 
             (this.displaySeconds!=null &&
              this.displaySeconds.equals(other.getDisplaySeconds()))) &&
            ((this.displayMilliseconds==null && other.getDisplayMilliseconds()==null) || 
             (this.displayMilliseconds!=null &&
              this.displayMilliseconds.equals(other.getDisplayMilliseconds()))) &&
            ((this.firstDate==null && other.getFirstDate()==null) || 
             (this.firstDate!=null &&
              this.firstDate.equals(other.getFirstDate()))) &&
            ((this.lastDate==null && other.getLastDate()==null) || 
             (this.lastDate!=null &&
              this.lastDate.equals(other.getLastDate()))) &&
            ((this.columnName==null && other.getColumnName()==null) || 
             (this.columnName!=null &&
              this.columnName.equals(other.getColumnName()))) &&
            ((this.selections==null && other.getSelections()==null) || 
             (this.selections!=null &&
              java.util.Arrays.equals(this.selections, other.getSelections()))) &&
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
        if (getValueType() != null) {
            _hashCode += getValueType().hashCode();
        }
        _hashCode += (isAutoSubmit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCalendarType() != null) {
            _hashCode += getCalendarType().hashCode();
        }
        if (getDisplaySeconds() != null) {
            _hashCode += getDisplaySeconds().hashCode();
        }
        if (getDisplayMilliseconds() != null) {
            _hashCode += getDisplayMilliseconds().hashCode();
        }
        if (getFirstDate() != null) {
            _hashCode += getFirstDate().hashCode();
        }
        if (getLastDate() != null) {
            _hashCode += getLastDate().hashCode();
        }
        if (getColumnName() != null) {
            _hashCode += getColumnName().hashCode();
        }
        if (getSelections() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSelections());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSelections(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PDateTimeBox.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PDateTimeBox"));
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
        elemField.setFieldName("valueType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "valueType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "DTValueType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autoSubmit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "autoSubmit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendarType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "calendarType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CalendarType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displaySeconds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "displaySeconds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayMilliseconds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "displayMilliseconds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "firstDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "DateTimeValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "lastDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "DateTimeValue"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("selections");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "selections"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">selections"));
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
