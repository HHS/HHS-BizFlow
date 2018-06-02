/**
 * GetTreePromptNodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class GetTreePromptNodeResponse  implements java.io.Serializable {
    private com.cognos.developer.schemas.rds.types._2.TreePromptNodeType treePromptNode;

    private java.lang.Object extension;

    public GetTreePromptNodeResponse() {
    }

    public GetTreePromptNodeResponse(
           com.cognos.developer.schemas.rds.types._2.TreePromptNodeType treePromptNode,
           java.lang.Object extension) {
           this.treePromptNode = treePromptNode;
           this.extension = extension;
    }


    /**
     * Gets the treePromptNode value for this GetTreePromptNodeResponse.
     * 
     * @return treePromptNode
     */
    public com.cognos.developer.schemas.rds.types._2.TreePromptNodeType getTreePromptNode() {
        return treePromptNode;
    }


    /**
     * Sets the treePromptNode value for this GetTreePromptNodeResponse.
     * 
     * @param treePromptNode
     */
    public void setTreePromptNode(com.cognos.developer.schemas.rds.types._2.TreePromptNodeType treePromptNode) {
        this.treePromptNode = treePromptNode;
    }


    /**
     * Gets the extension value for this GetTreePromptNodeResponse.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetTreePromptNodeResponse.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTreePromptNodeResponse)) return false;
        GetTreePromptNodeResponse other = (GetTreePromptNodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.treePromptNode==null && other.getTreePromptNode()==null) || 
             (this.treePromptNode!=null &&
              this.treePromptNode.equals(other.getTreePromptNode()))) &&
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
        if (getTreePromptNode() != null) {
            _hashCode += getTreePromptNode().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTreePromptNodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetTreePromptNodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("treePromptNode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "treePromptNode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "TreePromptNodeType"));
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
