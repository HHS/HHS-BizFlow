/**
 * VAlignEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class VAlignEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected VAlignEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _value1 = "TOP";
    public static final java.lang.String _value2 = "MIDDLE";
    public static final java.lang.String _value3 = "BOTTOM";
    public static final java.lang.String _value4 = "SUPER";
    public static final java.lang.String _value5 = "SUB";
    public static final java.lang.String _value6 = "TEXT-TOP";
    public static final java.lang.String _value7 = "TEXT-BOTTOM";
    public static final java.lang.String _value8 = "LENGTH";
    public static final java.lang.String _value9 = "%";
    public static final java.lang.String _value10 = "BASELINE";
    public static final VAlignEnum value1 = new VAlignEnum(_value1);
    public static final VAlignEnum value2 = new VAlignEnum(_value2);
    public static final VAlignEnum value3 = new VAlignEnum(_value3);
    public static final VAlignEnum value4 = new VAlignEnum(_value4);
    public static final VAlignEnum value5 = new VAlignEnum(_value5);
    public static final VAlignEnum value6 = new VAlignEnum(_value6);
    public static final VAlignEnum value7 = new VAlignEnum(_value7);
    public static final VAlignEnum value8 = new VAlignEnum(_value8);
    public static final VAlignEnum value9 = new VAlignEnum(_value9);
    public static final VAlignEnum value10 = new VAlignEnum(_value10);
    public java.lang.String getValue() { return _value_;}
    public static VAlignEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        VAlignEnum enumeration = (VAlignEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static VAlignEnum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(VAlignEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "VAlignEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
