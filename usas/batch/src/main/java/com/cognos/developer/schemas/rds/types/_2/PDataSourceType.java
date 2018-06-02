/**
 * PDataSourceType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;


/**
 * A Data source prompts
 */
public class PDataSourceType  implements java.io.Serializable {
    private java.lang.String name;

    private com.cognos.developer.schemas.rds.types._2.ConnectionType connection;

    private com.cognos.developer.schemas.rds.types._2.SignonType[] signon;

    public PDataSourceType() {
    }

    public PDataSourceType(
           java.lang.String name,
           com.cognos.developer.schemas.rds.types._2.ConnectionType connection,
           com.cognos.developer.schemas.rds.types._2.SignonType[] signon) {
           this.name = name;
           this.connection = connection;
           this.signon = signon;
    }


    /**
     * Gets the name value for this PDataSourceType.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PDataSourceType.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the connection value for this PDataSourceType.
     * 
     * @return connection
     */
    public com.cognos.developer.schemas.rds.types._2.ConnectionType getConnection() {
        return connection;
    }


    /**
     * Sets the connection value for this PDataSourceType.
     * 
     * @param connection
     */
    public void setConnection(com.cognos.developer.schemas.rds.types._2.ConnectionType connection) {
        this.connection = connection;
    }


    /**
     * Gets the signon value for this PDataSourceType.
     * 
     * @return signon
     */
    public com.cognos.developer.schemas.rds.types._2.SignonType[] getSignon() {
        return signon;
    }


    /**
     * Sets the signon value for this PDataSourceType.
     * 
     * @param signon
     */
    public void setSignon(com.cognos.developer.schemas.rds.types._2.SignonType[] signon) {
        this.signon = signon;
    }

    public com.cognos.developer.schemas.rds.types._2.SignonType getSignon(int i) {
        return this.signon[i];
    }

    public void setSignon(int i, com.cognos.developer.schemas.rds.types._2.SignonType _value) {
        this.signon[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PDataSourceType)) return false;
        PDataSourceType other = (PDataSourceType) obj;
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
            ((this.connection==null && other.getConnection()==null) || 
             (this.connection!=null &&
              this.connection.equals(other.getConnection()))) &&
            ((this.signon==null && other.getSignon()==null) || 
             (this.signon!=null &&
              java.util.Arrays.equals(this.signon, other.getSignon())));
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
        if (getConnection() != null) {
            _hashCode += getConnection().hashCode();
        }
        if (getSignon() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSignon());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSignon(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PDataSourceType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PDataSourceType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("connection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "connection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "connectionType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "signon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "signonType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
