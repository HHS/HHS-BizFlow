/**
 * LocationReference.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Spec Location reference
 */
public class LocationReference  implements java.io.Serializable {
    /* A reference "index" to the location in this entry. Corresponds
     * to the ref element within layout elements. */
    private java.lang.String ref;

    private java.lang.String di;

    /* a "location" reference of where this report element's context
     * in its source specification. */
    private java.lang.String loc;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public LocationReference() {
    }

    public LocationReference(
           java.lang.String ref,
           java.lang.String di,
           java.lang.String loc,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.ref = ref;
           this.di = di;
           this.loc = loc;
           this.extension = extension;
    }


    /**
     * Gets the ref value for this LocationReference.
     * 
     * @return ref   * A reference "index" to the location in this entry. Corresponds
     * to the ref element within layout elements.
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this LocationReference.
     * 
     * @param ref   * A reference "index" to the location in this entry. Corresponds
     * to the ref element within layout elements.
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the di value for this LocationReference.
     * 
     * @return di
     */
    public java.lang.String getDi() {
        return di;
    }


    /**
     * Sets the di value for this LocationReference.
     * 
     * @param di
     */
    public void setDi(java.lang.String di) {
        this.di = di;
    }


    /**
     * Gets the loc value for this LocationReference.
     * 
     * @return loc   * a "location" reference of where this report element's context
     * in its source specification.
     */
    public java.lang.String getLoc() {
        return loc;
    }


    /**
     * Sets the loc value for this LocationReference.
     * 
     * @param loc   * a "location" reference of where this report element's context
     * in its source specification.
     */
    public void setLoc(java.lang.String loc) {
        this.loc = loc;
    }


    /**
     * Gets the extension value for this LocationReference.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this LocationReference.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LocationReference)) return false;
        LocationReference other = (LocationReference) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ref==null && other.getRef()==null) || 
             (this.ref!=null &&
              this.ref.equals(other.getRef()))) &&
            ((this.di==null && other.getDi()==null) || 
             (this.di!=null &&
              this.di.equals(other.getDi()))) &&
            ((this.loc==null && other.getLoc()==null) || 
             (this.loc!=null &&
              this.loc.equals(other.getLoc()))) &&
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
        if (getRef() != null) {
            _hashCode += getRef().hashCode();
        }
        if (getDi() != null) {
            _hashCode += getDi().hashCode();
        }
        if (getLoc() != null) {
            _hashCode += getLoc().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LocationReference.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LocationReference"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ref");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("di");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "di"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "loc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
