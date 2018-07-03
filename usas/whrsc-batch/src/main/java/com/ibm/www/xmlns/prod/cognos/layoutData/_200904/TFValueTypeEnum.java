/**
 * TFValueTypeEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class TFValueTypeEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TFValueTypeEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _date = "date";
    public static final java.lang.String _time = "time";
    public static final java.lang.String _datetime = "datetime";
    public static final java.lang.String _number = "number";
    public static final java.lang.String _currency = "currency";
    public static final java.lang.String _percent = "percent";
    public static final java.lang.String _text = "text";
    public static final java.lang.String _timeInterval = "timeInterval";
    public static final TFValueTypeEnum date = new TFValueTypeEnum(_date);
    public static final TFValueTypeEnum time = new TFValueTypeEnum(_time);
    public static final TFValueTypeEnum datetime = new TFValueTypeEnum(_datetime);
    public static final TFValueTypeEnum number = new TFValueTypeEnum(_number);
    public static final TFValueTypeEnum currency = new TFValueTypeEnum(_currency);
    public static final TFValueTypeEnum percent = new TFValueTypeEnum(_percent);
    public static final TFValueTypeEnum text = new TFValueTypeEnum(_text);
    public static final TFValueTypeEnum timeInterval = new TFValueTypeEnum(_timeInterval);
    public java.lang.String getValue() { return _value_;}
    public static TFValueTypeEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TFValueTypeEnum enumeration = (TFValueTypeEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TFValueTypeEnum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(TFValueTypeEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TFValueTypeEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
