/**
 * DrillDefinitionsDrillModelPaths.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class DrillDefinitionsDrillModelPaths  implements java.io.Serializable {
    private java.lang.String[] objectPath;

    /* Locale used in the generation of this output. */
    private java.lang.String locale;

    public DrillDefinitionsDrillModelPaths() {
    }

    public DrillDefinitionsDrillModelPaths(
           java.lang.String[] objectPath,
           java.lang.String locale) {
           this.objectPath = objectPath;
           this.locale = locale;
    }


    /**
     * Gets the objectPath value for this DrillDefinitionsDrillModelPaths.
     * 
     * @return objectPath
     */
    public java.lang.String[] getObjectPath() {
        return objectPath;
    }


    /**
     * Sets the objectPath value for this DrillDefinitionsDrillModelPaths.
     * 
     * @param objectPath
     */
    public void setObjectPath(java.lang.String[] objectPath) {
        this.objectPath = objectPath;
    }

    public java.lang.String getObjectPath(int i) {
        return this.objectPath[i];
    }

    public void setObjectPath(int i, java.lang.String _value) {
        this.objectPath[i] = _value;
    }


    /**
     * Gets the locale value for this DrillDefinitionsDrillModelPaths.
     * 
     * @return locale   * Locale used in the generation of this output.
     */
    public java.lang.String getLocale() {
        return locale;
    }


    /**
     * Sets the locale value for this DrillDefinitionsDrillModelPaths.
     * 
     * @param locale   * Locale used in the generation of this output.
     */
    public void setLocale(java.lang.String locale) {
        this.locale = locale;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DrillDefinitionsDrillModelPaths)) return false;
        DrillDefinitionsDrillModelPaths other = (DrillDefinitionsDrillModelPaths) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objectPath==null && other.getObjectPath()==null) || 
             (this.objectPath!=null &&
              java.util.Arrays.equals(this.objectPath, other.getObjectPath()))) &&
            ((this.locale==null && other.getLocale()==null) || 
             (this.locale!=null &&
              this.locale.equals(other.getLocale())));
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
        if (getObjectPath() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObjectPath());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObjectPath(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLocale() != null) {
            _hashCode += getLocale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DrillDefinitionsDrillModelPaths.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>DrillDefinitions>drill>modelPaths"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "objectPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "locale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
