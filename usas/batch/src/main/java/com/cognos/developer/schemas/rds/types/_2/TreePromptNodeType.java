/**
 * TreePromptNodeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * Represents a parent node
 */
public class TreePromptNodeType  implements java.io.Serializable {
    private com.cognos.developer.schemas.rds.types._2.POptions[] options;

    private java.lang.Object extension;

    public TreePromptNodeType() {
    }

    public TreePromptNodeType(
           com.cognos.developer.schemas.rds.types._2.POptions[] options,
           java.lang.Object extension) {
           this.options = options;
           this.extension = extension;
    }


    /**
     * Gets the options value for this TreePromptNodeType.
     * 
     * @return options
     */
    public com.cognos.developer.schemas.rds.types._2.POptions[] getOptions() {
        return options;
    }


    /**
     * Sets the options value for this TreePromptNodeType.
     * 
     * @param options
     */
    public void setOptions(com.cognos.developer.schemas.rds.types._2.POptions[] options) {
        this.options = options;
    }

    public com.cognos.developer.schemas.rds.types._2.POptions getOptions(int i) {
        return this.options[i];
    }

    public void setOptions(int i, com.cognos.developer.schemas.rds.types._2.POptions _value) {
        this.options[i] = _value;
    }


    /**
     * Gets the extension value for this TreePromptNodeType.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this TreePromptNodeType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TreePromptNodeType)) return false;
        TreePromptNodeType other = (TreePromptNodeType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.options==null && other.getOptions()==null) || 
             (this.options!=null &&
              java.util.Arrays.equals(this.options, other.getOptions()))) &&
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
        if (getOptions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOptions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOptions(), i);
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
        new org.apache.axis.description.TypeDesc(TreePromptNodeType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "TreePromptNodeType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("options");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "options"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "options"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
