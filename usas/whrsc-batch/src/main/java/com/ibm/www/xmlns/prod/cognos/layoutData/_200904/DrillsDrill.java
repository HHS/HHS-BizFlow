/**
 * DrillsDrill.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class DrillsDrill  implements java.io.Serializable {
    private java.lang.String drillRef;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrillParm[] parm;

    private java.lang.String bookmark;

    private java.lang.Object URLParameters;

    public DrillsDrill() {
    }

    public DrillsDrill(
           java.lang.String drillRef,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrillParm[] parm,
           java.lang.String bookmark,
           java.lang.Object URLParameters) {
           this.drillRef = drillRef;
           this.parm = parm;
           this.bookmark = bookmark;
           this.URLParameters = URLParameters;
    }


    /**
     * Gets the drillRef value for this DrillsDrill.
     * 
     * @return drillRef
     */
    public java.lang.String getDrillRef() {
        return drillRef;
    }


    /**
     * Sets the drillRef value for this DrillsDrill.
     * 
     * @param drillRef
     */
    public void setDrillRef(java.lang.String drillRef) {
        this.drillRef = drillRef;
    }


    /**
     * Gets the parm value for this DrillsDrill.
     * 
     * @return parm
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrillParm[] getParm() {
        return parm;
    }


    /**
     * Sets the parm value for this DrillsDrill.
     * 
     * @param parm
     */
    public void setParm(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrillParm[] parm) {
        this.parm = parm;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrillParm getParm(int i) {
        return this.parm[i];
    }

    public void setParm(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrillParm _value) {
        this.parm[i] = _value;
    }


    /**
     * Gets the bookmark value for this DrillsDrill.
     * 
     * @return bookmark
     */
    public java.lang.String getBookmark() {
        return bookmark;
    }


    /**
     * Sets the bookmark value for this DrillsDrill.
     * 
     * @param bookmark
     */
    public void setBookmark(java.lang.String bookmark) {
        this.bookmark = bookmark;
    }


    /**
     * Gets the URLParameters value for this DrillsDrill.
     * 
     * @return URLParameters
     */
    public java.lang.Object getURLParameters() {
        return URLParameters;
    }


    /**
     * Sets the URLParameters value for this DrillsDrill.
     * 
     * @param URLParameters
     */
    public void setURLParameters(java.lang.Object URLParameters) {
        this.URLParameters = URLParameters;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DrillsDrill)) return false;
        DrillsDrill other = (DrillsDrill) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.drillRef==null && other.getDrillRef()==null) || 
             (this.drillRef!=null &&
              this.drillRef.equals(other.getDrillRef()))) &&
            ((this.parm==null && other.getParm()==null) || 
             (this.parm!=null &&
              java.util.Arrays.equals(this.parm, other.getParm()))) &&
            ((this.bookmark==null && other.getBookmark()==null) || 
             (this.bookmark!=null &&
              this.bookmark.equals(other.getBookmark()))) &&
            ((this.URLParameters==null && other.getURLParameters()==null) || 
             (this.URLParameters!=null &&
              this.URLParameters.equals(other.getURLParameters())));
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
        if (getDrillRef() != null) {
            _hashCode += getDrillRef().hashCode();
        }
        if (getParm() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParm());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParm(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBookmark() != null) {
            _hashCode += getBookmark().hashCode();
        }
        if (getURLParameters() != null) {
            _hashCode += getURLParameters().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DrillsDrill.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>drills>drill"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drillRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drillRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "parm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>>drills>drill>parm"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookmark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "bookmark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("URLParameters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "URLParameters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
