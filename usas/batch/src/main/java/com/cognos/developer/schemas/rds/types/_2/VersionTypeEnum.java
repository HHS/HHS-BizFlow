/**
 * VersionTypeEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class VersionTypeEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected VersionTypeEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NEW = "NEW";
    public static final java.lang.String _LATEST = "LATEST";
    public static final java.lang.String _VERSION_NAME = "VERSION_NAME";
    public static final java.lang.String _NO_DATA = "NO_DATA";
    public static final java.lang.String _LIMITED_DATA = "LIMITED_DATA";
    public static final VersionTypeEnum NEW = new VersionTypeEnum(_NEW);
    public static final VersionTypeEnum LATEST = new VersionTypeEnum(_LATEST);
    public static final VersionTypeEnum VERSION_NAME = new VersionTypeEnum(_VERSION_NAME);
    public static final VersionTypeEnum NO_DATA = new VersionTypeEnum(_NO_DATA);
    public static final VersionTypeEnum LIMITED_DATA = new VersionTypeEnum(_LIMITED_DATA);
    public java.lang.String getValue() { return _value_;}
    public static VersionTypeEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        VersionTypeEnum enumeration = (VersionTypeEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static VersionTypeEnum fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    @Override
	public boolean equals(java.lang.Object obj) {return (obj == this);}
    @Override
	public int hashCode() { return toString().hashCode();}
    @Override
	public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VersionTypeEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "VersionTypeEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
