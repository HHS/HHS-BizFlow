/**
 * SizeUnitEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class SizeUnitEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected SizeUnitEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _PX = "PX";
    public static final java.lang.String _PERCENT = "PERCENT";
    public static final java.lang.String _CM = "CM";
    public static final java.lang.String _MM = "MM";
    public static final java.lang.String _IN = "IN";
    public static final java.lang.String _PT = "PT";
    public static final java.lang.String _PC = "PC";
    public static final java.lang.String _EM = "EM";
    public static final java.lang.String _EX = "EX";
    public static final SizeUnitEnum PX = new SizeUnitEnum(_PX);
    public static final SizeUnitEnum PERCENT = new SizeUnitEnum(_PERCENT);
    public static final SizeUnitEnum CM = new SizeUnitEnum(_CM);
    public static final SizeUnitEnum MM = new SizeUnitEnum(_MM);
    public static final SizeUnitEnum IN = new SizeUnitEnum(_IN);
    public static final SizeUnitEnum PT = new SizeUnitEnum(_PT);
    public static final SizeUnitEnum PC = new SizeUnitEnum(_PC);
    public static final SizeUnitEnum EM = new SizeUnitEnum(_EM);
    public static final SizeUnitEnum EX = new SizeUnitEnum(_EX);
    public java.lang.String getValue() { return _value_;}
    public static SizeUnitEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        SizeUnitEnum enumeration = (SizeUnitEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static SizeUnitEnum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(SizeUnitEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SizeUnitEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
