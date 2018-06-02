/**
 * TFStateEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class TFStateEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TFStateEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _OK = "OK";
    public static final java.lang.String _NULL = "NULL";
    public static final java.lang.String _NA = "NA";
    public static final java.lang.String _DIV0 = "DIV0";
    public static final java.lang.String _OVERFLOW = "OVERFLOW";
    public static final java.lang.String _SECURITY = "SECURITY";
    public static final java.lang.String _CASTING = "CASTING";
    public static final java.lang.String _OTHER_ERROR = "OTHER_ERROR";
    public static final TFStateEnum OK = new TFStateEnum(_OK);
    public static final TFStateEnum NULL = new TFStateEnum(_NULL);
    public static final TFStateEnum NA = new TFStateEnum(_NA);
    public static final TFStateEnum DIV0 = new TFStateEnum(_DIV0);
    public static final TFStateEnum OVERFLOW = new TFStateEnum(_OVERFLOW);
    public static final TFStateEnum SECURITY = new TFStateEnum(_SECURITY);
    public static final TFStateEnum CASTING = new TFStateEnum(_CASTING);
    public static final TFStateEnum OTHER_ERROR = new TFStateEnum(_OTHER_ERROR);
    public java.lang.String getValue() { return _value_;}
    public static TFStateEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TFStateEnum enumeration = (TFStateEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TFStateEnum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(TFStateEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TFStateEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
