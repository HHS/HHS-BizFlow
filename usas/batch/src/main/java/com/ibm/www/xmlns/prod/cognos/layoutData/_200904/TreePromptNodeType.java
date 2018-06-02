/**
 * TreePromptNodeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Represents a parent node
 */
public class TreePromptNodeType  implements java.io.Serializable {
    /* Children of the parent tree node */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType[] child;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public TreePromptNodeType() {
    }

    public TreePromptNodeType(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType[] child,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.child = child;
           this.extension = extension;
    }


    /**
     * Gets the child value for this TreePromptNodeType.
     * 
     * @return child   * Children of the parent tree node
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType[] getChild() {
        return child;
    }


    /**
     * Sets the child value for this TreePromptNodeType.
     * 
     * @param child   * Children of the parent tree node
     */
    public void setChild(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType[] child) {
        this.child = child;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType getChild(int i) {
        return this.child[i];
    }

    public void setChild(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType _value) {
        this.child[i] = _value;
    }


    /**
     * Gets the extension value for this TreePromptNodeType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this TreePromptNodeType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
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
            ((this.child==null && other.getChild()==null) || 
             (this.child!=null &&
              java.util.Arrays.equals(this.child, other.getChild()))) &&
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
        if (getChild() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getChild());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getChild(), i);
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TreePromptNodeType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("child");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "child"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SimplePromptValueType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">extension"));
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
