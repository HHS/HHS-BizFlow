/**
 * LineStyleEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class LineStyleEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected LineStyleEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NONE = "NONE";
    public static final java.lang.String _SOLID = "SOLID";
    public static final java.lang.String _DOUBLE = "DOUBLE";
    public static final java.lang.String _DOTTED = "DOTTED";
    public static final java.lang.String _DASHED = "DASHED";
    public static final java.lang.String _GROOVE = "GROOVE";
    public static final java.lang.String _RIDGE = "RIDGE";
    public static final java.lang.String _INSET = "INSET";
    public static final java.lang.String _OUTSET = "OUTSET";
    public static final LineStyleEnum NONE = new LineStyleEnum(_NONE);
    public static final LineStyleEnum SOLID = new LineStyleEnum(_SOLID);
    public static final LineStyleEnum DOUBLE = new LineStyleEnum(_DOUBLE);
    public static final LineStyleEnum DOTTED = new LineStyleEnum(_DOTTED);
    public static final LineStyleEnum DASHED = new LineStyleEnum(_DASHED);
    public static final LineStyleEnum GROOVE = new LineStyleEnum(_GROOVE);
    public static final LineStyleEnum RIDGE = new LineStyleEnum(_RIDGE);
    public static final LineStyleEnum INSET = new LineStyleEnum(_INSET);
    public static final LineStyleEnum OUTSET = new LineStyleEnum(_OUTSET);
    public java.lang.String getValue() { return _value_;}
    public static LineStyleEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        LineStyleEnum enumeration = (LineStyleEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static LineStyleEnum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(LineStyleEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LineStyleEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
