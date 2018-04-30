/**
 * CgsCanvasDef.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class CgsCanvasDef  implements java.io.Serializable {
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsWidgetDef[] cgsWidget;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsPropCanvas cgsPropCanvas;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public CgsCanvasDef() {
    }

    public CgsCanvasDef(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsWidgetDef[] cgsWidget,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsPropCanvas cgsPropCanvas,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.cgsWidget = cgsWidget;
           this.cgsPropCanvas = cgsPropCanvas;
           this.extension = extension;
    }


    /**
     * Gets the cgsWidget value for this CgsCanvasDef.
     * 
     * @return cgsWidget
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsWidgetDef[] getCgsWidget() {
        return cgsWidget;
    }


    /**
     * Sets the cgsWidget value for this CgsCanvasDef.
     * 
     * @param cgsWidget
     */
    public void setCgsWidget(com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsWidgetDef[] cgsWidget) {
        this.cgsWidget = cgsWidget;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsWidgetDef getCgsWidget(int i) {
        return this.cgsWidget[i];
    }

    public void setCgsWidget(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsWidgetDef _value) {
        this.cgsWidget[i] = _value;
    }


    /**
     * Gets the cgsPropCanvas value for this CgsCanvasDef.
     * 
     * @return cgsPropCanvas
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsPropCanvas getCgsPropCanvas() {
        return cgsPropCanvas;
    }


    /**
     * Sets the cgsPropCanvas value for this CgsCanvasDef.
     * 
     * @param cgsPropCanvas
     */
    public void setCgsPropCanvas(com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsPropCanvas cgsPropCanvas) {
        this.cgsPropCanvas = cgsPropCanvas;
    }


    /**
     * Gets the extension value for this CgsCanvasDef.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this CgsCanvasDef.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CgsCanvasDef)) return false;
        CgsCanvasDef other = (CgsCanvasDef) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cgsWidget==null && other.getCgsWidget()==null) || 
             (this.cgsWidget!=null &&
              java.util.Arrays.equals(this.cgsWidget, other.getCgsWidget()))) &&
            ((this.cgsPropCanvas==null && other.getCgsPropCanvas()==null) || 
             (this.cgsPropCanvas!=null &&
              this.cgsPropCanvas.equals(other.getCgsPropCanvas()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension())));
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
        if (getCgsWidget() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCgsWidget());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCgsWidget(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCgsPropCanvas() != null) {
            _hashCode += getCgsPropCanvas().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CgsCanvasDef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cgsCanvasDef"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cgsWidget");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cgsWidget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cgsWidgetDef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cgsPropCanvas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cgsPropCanvas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">cgsPropCanvas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">extension"));
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
