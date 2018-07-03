/**
 * ConnectionType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class ConnectionType  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String searchPath;

    private boolean selected;

    private SignonType[] signon;

    public ConnectionType() {
    }

    public ConnectionType(
           java.lang.String name,
           java.lang.String searchPath,
           boolean selected,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SignonType[] signon) {
           this.name = name;
           this.searchPath = searchPath;
           this.selected = selected;
           this.signon = signon;
    }


    /**
     * Gets the name value for this ConnectionType.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ConnectionType.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the searchPath value for this ConnectionType.
     * 
     * @return searchPath
     */
    public java.lang.String getSearchPath() {
        return searchPath;
    }


    /**
     * Sets the searchPath value for this ConnectionType.
     * 
     * @param searchPath
     */
    public void setSearchPath(java.lang.String searchPath) {
        this.searchPath = searchPath;
    }


    /**
     * Gets the selected value for this ConnectionType.
     * 
     * @return selected
     */
    public boolean isSelected() {
        return selected;
    }


    /**
     * Sets the selected value for this ConnectionType.
     * 
     * @param selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    /**
     * Gets the signon value for this ConnectionType.
     * 
     * @return signon
     */
    public SignonType[] getSignon() {
        return signon;
    }


    /**
     * Sets the signon value for this ConnectionType.
     * 
     * @param signon
     */
    public void setSignon(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SignonType[] signon) {
        this.signon = signon;
    }

    public SignonType getSignon(int i) {
        return this.signon[i];
    }

    public void setSignon(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.SignonType _value) {
        this.signon[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConnectionType)) return false;
        ConnectionType other = (ConnectionType) obj;
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
            ((this.searchPath==null && other.getSearchPath()==null) || 
             (this.searchPath!=null &&
              this.searchPath.equals(other.getSearchPath()))) &&
            this.selected == other.isSelected() &&
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
        if (getSearchPath() != null) {
            _hashCode += getSearchPath().hashCode();
        }
        _hashCode += (isSelected() ? Boolean.TRUE : Boolean.FALSE).hashCode();
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
        new org.apache.axis.description.TypeDesc(ConnectionType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "connectionType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "searchPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selected");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "selected"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "signon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "signonType"));
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
