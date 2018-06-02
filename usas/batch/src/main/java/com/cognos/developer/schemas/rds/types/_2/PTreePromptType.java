/**
 * PTreePromptType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * A Tree prompt
 */
public class PTreePromptType  implements java.io.Serializable {
    private java.lang.String name;

    private boolean multiSelect;

    private boolean required;

    private java.lang.String treeUI;

    private boolean canExpand;

    /* True if this prompt should be submitted to the server immediately
     * if the value changes */
    private boolean autoSubmit;

    private java.lang.String columnName;

    private com.cognos.developer.schemas.rds.types._2.POptions[] selections;

    private com.cognos.developer.schemas.rds.types._2.POptions[] selectionsAncestry;

    private com.cognos.developer.schemas.rds.types._2.TreePromptNodeType treeNode;

    private java.lang.Object extension;

    public PTreePromptType() {
    }

    public PTreePromptType(
           java.lang.String name,
           boolean multiSelect,
           boolean required,
           java.lang.String treeUI,
           boolean canExpand,
           boolean autoSubmit,
           java.lang.String columnName,
           com.cognos.developer.schemas.rds.types._2.POptions[] selections,
           com.cognos.developer.schemas.rds.types._2.POptions[] selectionsAncestry,
           com.cognos.developer.schemas.rds.types._2.TreePromptNodeType treeNode,
           java.lang.Object extension) {
           this.name = name;
           this.multiSelect = multiSelect;
           this.required = required;
           this.treeUI = treeUI;
           this.canExpand = canExpand;
           this.autoSubmit = autoSubmit;
           this.columnName = columnName;
           this.selections = selections;
           this.selectionsAncestry = selectionsAncestry;
           this.treeNode = treeNode;
           this.extension = extension;
    }


    /**
     * Gets the name value for this PTreePromptType.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PTreePromptType.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the multiSelect value for this PTreePromptType.
     * 
     * @return multiSelect
     */
    public boolean isMultiSelect() {
        return multiSelect;
    }


    /**
     * Sets the multiSelect value for this PTreePromptType.
     * 
     * @param multiSelect
     */
    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }


    /**
     * Gets the required value for this PTreePromptType.
     * 
     * @return required
     */
    public boolean isRequired() {
        return required;
    }


    /**
     * Sets the required value for this PTreePromptType.
     * 
     * @param required
     */
    public void setRequired(boolean required) {
        this.required = required;
    }


    /**
     * Gets the treeUI value for this PTreePromptType.
     * 
     * @return treeUI
     */
    public java.lang.String getTreeUI() {
        return treeUI;
    }


    /**
     * Sets the treeUI value for this PTreePromptType.
     * 
     * @param treeUI
     */
    public void setTreeUI(java.lang.String treeUI) {
        this.treeUI = treeUI;
    }


    /**
     * Gets the canExpand value for this PTreePromptType.
     * 
     * @return canExpand
     */
    public boolean isCanExpand() {
        return canExpand;
    }


    /**
     * Sets the canExpand value for this PTreePromptType.
     * 
     * @param canExpand
     */
    public void setCanExpand(boolean canExpand) {
        this.canExpand = canExpand;
    }


    /**
     * Gets the autoSubmit value for this PTreePromptType.
     * 
     * @return autoSubmit   * True if this prompt should be submitted to the server immediately
     * if the value changes
     */
    public boolean isAutoSubmit() {
        return autoSubmit;
    }


    /**
     * Sets the autoSubmit value for this PTreePromptType.
     * 
     * @param autoSubmit   * True if this prompt should be submitted to the server immediately
     * if the value changes
     */
    public void setAutoSubmit(boolean autoSubmit) {
        this.autoSubmit = autoSubmit;
    }


    /**
     * Gets the columnName value for this PTreePromptType.
     * 
     * @return columnName
     */
    public java.lang.String getColumnName() {
        return columnName;
    }


    /**
     * Sets the columnName value for this PTreePromptType.
     * 
     * @param columnName
     */
    public void setColumnName(java.lang.String columnName) {
        this.columnName = columnName;
    }


    /**
     * Gets the selections value for this PTreePromptType.
     * 
     * @return selections
     */
    public com.cognos.developer.schemas.rds.types._2.POptions[] getSelections() {
        return selections;
    }


    /**
     * Sets the selections value for this PTreePromptType.
     * 
     * @param selections
     */
    public void setSelections(com.cognos.developer.schemas.rds.types._2.POptions[] selections) {
        this.selections = selections;
    }


    /**
     * Gets the selectionsAncestry value for this PTreePromptType.
     * 
     * @return selectionsAncestry
     */
    public com.cognos.developer.schemas.rds.types._2.POptions[] getSelectionsAncestry() {
        return selectionsAncestry;
    }


    /**
     * Sets the selectionsAncestry value for this PTreePromptType.
     * 
     * @param selectionsAncestry
     */
    public void setSelectionsAncestry(com.cognos.developer.schemas.rds.types._2.POptions[] selectionsAncestry) {
        this.selectionsAncestry = selectionsAncestry;
    }


    /**
     * Gets the treeNode value for this PTreePromptType.
     * 
     * @return treeNode
     */
    public com.cognos.developer.schemas.rds.types._2.TreePromptNodeType getTreeNode() {
        return treeNode;
    }


    /**
     * Sets the treeNode value for this PTreePromptType.
     * 
     * @param treeNode
     */
    public void setTreeNode(com.cognos.developer.schemas.rds.types._2.TreePromptNodeType treeNode) {
        this.treeNode = treeNode;
    }


    /**
     * Gets the extension value for this PTreePromptType.
     * 
     * @return extension
     */
    public java.lang.Object getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PTreePromptType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTreePromptType)) return false;
        PTreePromptType other = (PTreePromptType) obj;
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
            this.required == other.isRequired() &&
            ((this.treeUI==null && other.getTreeUI()==null) || 
             (this.treeUI!=null &&
              this.treeUI.equals(other.getTreeUI()))) &&
            this.canExpand == other.isCanExpand() &&
            this.autoSubmit == other.isAutoSubmit() &&
            ((this.columnName==null && other.getColumnName()==null) || 
             (this.columnName!=null &&
              this.columnName.equals(other.getColumnName()))) &&
            ((this.selections==null && other.getSelections()==null) || 
             (this.selections!=null &&
              java.util.Arrays.equals(this.selections, other.getSelections()))) &&
            ((this.selectionsAncestry==null && other.getSelectionsAncestry()==null) || 
             (this.selectionsAncestry!=null &&
              java.util.Arrays.equals(this.selectionsAncestry, other.getSelectionsAncestry()))) &&
            ((this.treeNode==null && other.getTreeNode()==null) || 
             (this.treeNode!=null &&
              this.treeNode.equals(other.getTreeNode()))) &&
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
        _hashCode += (isRequired() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getTreeUI() != null) {
            _hashCode += getTreeUI().hashCode();
        }
        _hashCode += (isCanExpand() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAutoSubmit() ? Boolean.TRUE : Boolean.FALSE).hashCode();
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
        if (getSelectionsAncestry() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSelectionsAncestry());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSelectionsAncestry(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTreeNode() != null) {
            _hashCode += getTreeNode().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTreePromptType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PTreePromptType"));
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
        elemField.setFieldName("required");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "required"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("treeUI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "treeUI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canExpand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "canExpand"));
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
        elemField.setFieldName("selections");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "selections"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">selections"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selectionsAncestry");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "selectionsAncestry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "options"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("treeNode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "treeNode"));
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
