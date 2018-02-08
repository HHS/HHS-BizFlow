/**
 * PItemArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * An array of prompt items
 */
public class PItemArray  implements java.io.Serializable {
    private boolean canFinish;

    private boolean hasNextPage;

    private com.cognos.developer.schemas.rds.types._2.PItem[] item;

    private PromptValue promptValues;

    public PItemArray() {
    }

    public PItemArray(
           boolean canFinish,
           boolean hasNextPage,
           com.cognos.developer.schemas.rds.types._2.PItem[] item,
           com.cognos.developer.schemas.rds.types._2.PromptValue promptValues) {
           this.canFinish = canFinish;
           this.hasNextPage = hasNextPage;
           this.item = item;
           this.promptValues = promptValues;
    }


    /**
     * Gets the canFinish value for this PItemArray.
     * 
     * @return canFinish
     */
    public boolean isCanFinish() {
        return canFinish;
    }


    /**
     * Sets the canFinish value for this PItemArray.
     * 
     * @param canFinish
     */
    public void setCanFinish(boolean canFinish) {
        this.canFinish = canFinish;
    }


    /**
     * Gets the hasNextPage value for this PItemArray.
     * 
     * @return hasNextPage
     */
    public boolean isHasNextPage() {
        return hasNextPage;
    }


    /**
     * Sets the hasNextPage value for this PItemArray.
     * 
     * @param hasNextPage
     */
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }


    /**
     * Gets the item value for this PItemArray.
     * 
     * @return item
     */
    public com.cognos.developer.schemas.rds.types._2.PItem[] getItem() {
        return item;
    }


    /**
     * Sets the item value for this PItemArray.
     * 
     * @param item
     */
    public void setItem(com.cognos.developer.schemas.rds.types._2.PItem[] item) {
        this.item = item;
    }

    public com.cognos.developer.schemas.rds.types._2.PItem getItem(int i) {
        return this.item[i];
    }

    public void setItem(int i, com.cognos.developer.schemas.rds.types._2.PItem _value) {
        this.item[i] = _value;
    }


    /**
     * Gets the promptValues value for this PItemArray.
     * 
     * @return promptValues
     */
    public PromptValue getPromptValues() {
        return promptValues;
    }


    /**
     * Sets the promptValues value for this PItemArray.
     * 
     * @param promptValues
     */
    public void setPromptValues(com.cognos.developer.schemas.rds.types._2.PromptValue promptValues) {
        this.promptValues = promptValues;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PItemArray)) return false;
        PItemArray other = (PItemArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.canFinish == other.isCanFinish() &&
            this.hasNextPage == other.isHasNextPage() &&
            ((this.item==null && other.getItem()==null) || 
             (this.item!=null &&
              java.util.Arrays.equals(this.item, other.getItem()))) &&
            ((this.promptValues==null && other.getPromptValues()==null) || 
             (this.promptValues!=null &&
              this.promptValues.equals(other.getPromptValues())));
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
        _hashCode += (isCanFinish() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHasNextPage() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPromptValues() != null) {
            _hashCode += getPromptValues().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PItemArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PItemArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canFinish");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "canFinish"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasNextPage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "hasNextPage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "item"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promptValues");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "promptValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PromptValue"));
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
