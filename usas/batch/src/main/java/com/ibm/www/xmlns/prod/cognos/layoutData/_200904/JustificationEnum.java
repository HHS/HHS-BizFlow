/**
 * JustificationEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class JustificationEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected JustificationEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _value1 = "DISTRIBUTE";
    public static final java.lang.String _value2 = "DISTRIBUTE LINES";
    public static final java.lang.String _value3 = "INTERCLUSTER";
    public static final java.lang.String _value4 = "INTERIDEOGRAPH";
    public static final java.lang.String _value5 = "INTERWORD";
    public static final java.lang.String _value6 = "KASHIDA";
    public static final java.lang.String _value7 = "NEWSPAPER";
    public static final JustificationEnum value1 = new JustificationEnum(_value1);
    public static final JustificationEnum value2 = new JustificationEnum(_value2);
    public static final JustificationEnum value3 = new JustificationEnum(_value3);
    public static final JustificationEnum value4 = new JustificationEnum(_value4);
    public static final JustificationEnum value5 = new JustificationEnum(_value5);
    public static final JustificationEnum value6 = new JustificationEnum(_value6);
    public static final JustificationEnum value7 = new JustificationEnum(_value7);
    public java.lang.String getValue() { return _value_;}
    public static JustificationEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        JustificationEnum enumeration = (JustificationEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static JustificationEnum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(JustificationEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "JustificationEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
