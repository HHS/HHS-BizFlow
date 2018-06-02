/**
 * MarginStyle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;


/**
 * Defines Box Margins
 */
public class MarginStyle  implements java.io.Serializable {
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue top;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue left;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue right;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue bottom;

    public MarginStyle() {
    }

    public MarginStyle(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue top,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue left,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue right,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue bottom) {
           this.top = top;
           this.left = left;
           this.right = right;
           this.bottom = bottom;
    }


    /**
     * Gets the top value for this MarginStyle.
     * 
     * @return top
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue getTop() {
        return top;
    }


    /**
     * Sets the top value for this MarginStyle.
     * 
     * @param top
     */
    public void setTop(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue top) {
        this.top = top;
    }


    /**
     * Gets the left value for this MarginStyle.
     * 
     * @return left
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue getLeft() {
        return left;
    }


    /**
     * Sets the left value for this MarginStyle.
     * 
     * @param left
     */
    public void setLeft(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue left) {
        this.left = left;
    }


    /**
     * Gets the right value for this MarginStyle.
     * 
     * @return right
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue getRight() {
        return right;
    }


    /**
     * Sets the right value for this MarginStyle.
     * 
     * @param right
     */
    public void setRight(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue right) {
        this.right = right;
    }


    /**
     * Gets the bottom value for this MarginStyle.
     * 
     * @return bottom
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue getBottom() {
        return bottom;
    }


    /**
     * Sets the bottom value for this MarginStyle.
     * 
     * @param bottom
     */
    public void setBottom(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue bottom) {
        this.bottom = bottom;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MarginStyle)) return false;
        MarginStyle other = (MarginStyle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.top==null && other.getTop()==null) || 
             (this.top!=null &&
              this.top.equals(other.getTop()))) &&
            ((this.left==null && other.getLeft()==null) || 
             (this.left!=null &&
              this.left.equals(other.getLeft()))) &&
            ((this.right==null && other.getRight()==null) || 
             (this.right!=null &&
              this.right.equals(other.getRight()))) &&
            ((this.bottom==null && other.getBottom()==null) || 
             (this.bottom!=null &&
              this.bottom.equals(other.getBottom())));
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
        if (getTop() != null) {
            _hashCode += getTop().hashCode();
        }
        if (getLeft() != null) {
            _hashCode += getLeft().hashCode();
        }
        if (getRight() != null) {
            _hashCode += getRight().hashCode();
        }
        if (getBottom() != null) {
            _hashCode += getBottom().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MarginStyle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "MarginStyle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("top");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "top"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SizeValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("left");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "left"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SizeValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("right");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "right"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SizeValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bottom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "bottom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SizeValue"));
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
