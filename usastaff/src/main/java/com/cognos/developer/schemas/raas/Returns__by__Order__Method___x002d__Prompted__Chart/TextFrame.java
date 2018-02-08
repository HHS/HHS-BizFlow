/**
 * TextFrame.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class TextFrame  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String ctx;

    private java.lang.String[] style;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[] drills;

    private java.lang.String val;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFStateEnum valErrorState;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFValueTypeEnum valTyp;

    /* Formatted value for the text field. If the formatted value
     * is the same as the raw value, then this element will not be present. */
    private java.lang.String fmtVal;

    /* ICU specification of the formatting string for this field. */
    private java.lang.String fmtPatrn;

    /* Excel-type formatting pattern for this field. If not present,
     * assume "General". */
    private java.lang.String exclPatrn;

    /* Locale used for formatting */
    private java.lang.String fmtLoc;

    /* A scaling factor (number of digits)  that should be applied
     * to the raw value in element val, to get the formattted value. */
    private java.lang.Integer fmtScale;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension;

    public TextFrame() {
    }

    public TextFrame(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String ctx,
           java.lang.String[] style,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[] drills,
           java.lang.String val,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFStateEnum valErrorState,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFValueTypeEnum valTyp,
           java.lang.String fmtVal,
           java.lang.String fmtPatrn,
           java.lang.String exclPatrn,
           java.lang.String fmtLoc,
           java.lang.Integer fmtScale,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
           this.id = id;
           this.ref = ref;
           this.ctx = ctx;
           this.style = style;
           this.drills = drills;
           this.val = val;
           this.valErrorState = valErrorState;
           this.valTyp = valTyp;
           this.fmtVal = fmtVal;
           this.fmtPatrn = fmtPatrn;
           this.exclPatrn = exclPatrn;
           this.fmtLoc = fmtLoc;
           this.fmtScale = fmtScale;
           this.extension = extension;
    }


    /**
     * Gets the id value for this TextFrame.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this TextFrame.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this TextFrame.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this TextFrame.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the ctx value for this TextFrame.
     * 
     * @return ctx
     */
    public java.lang.String getCtx() {
        return ctx;
    }


    /**
     * Sets the ctx value for this TextFrame.
     * 
     * @param ctx
     */
    public void setCtx(java.lang.String ctx) {
        this.ctx = ctx;
    }


    /**
     * Gets the style value for this TextFrame.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this TextFrame.
     * 
     * @param style
     */
    public void setStyle(java.lang.String[] style) {
        this.style = style;
    }

    public java.lang.String getStyle(int i) {
        return this.style[i];
    }

    public void setStyle(int i, java.lang.String _value) {
        this.style[i] = _value;
    }


    /**
     * Gets the drills value for this TextFrame.
     * 
     * @return drills
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[] getDrills() {
        return drills;
    }


    /**
     * Sets the drills value for this TextFrame.
     * 
     * @param drills
     */
    public void setDrills(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[] drills) {
        this.drills = drills;
    }


    /**
     * Gets the val value for this TextFrame.
     * 
     * @return val
     */
    public java.lang.String getVal() {
        return val;
    }


    /**
     * Sets the val value for this TextFrame.
     * 
     * @param val
     */
    public void setVal(java.lang.String val) {
        this.val = val;
    }


    /**
     * Gets the valErrorState value for this TextFrame.
     * 
     * @return valErrorState
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFStateEnum getValErrorState() {
        return valErrorState;
    }


    /**
     * Sets the valErrorState value for this TextFrame.
     * 
     * @param valErrorState
     */
    public void setValErrorState(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFStateEnum valErrorState) {
        this.valErrorState = valErrorState;
    }


    /**
     * Gets the valTyp value for this TextFrame.
     * 
     * @return valTyp
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFValueTypeEnum getValTyp() {
        return valTyp;
    }


    /**
     * Sets the valTyp value for this TextFrame.
     * 
     * @param valTyp
     */
    public void setValTyp(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFValueTypeEnum valTyp) {
        this.valTyp = valTyp;
    }


    /**
     * Gets the fmtVal value for this TextFrame.
     * 
     * @return fmtVal   * Formatted value for the text field. If the formatted value
     * is the same as the raw value, then this element will not be present.
     */
    public java.lang.String getFmtVal() {
        return fmtVal;
    }


    /**
     * Sets the fmtVal value for this TextFrame.
     * 
     * @param fmtVal   * Formatted value for the text field. If the formatted value
     * is the same as the raw value, then this element will not be present.
     */
    public void setFmtVal(java.lang.String fmtVal) {
        this.fmtVal = fmtVal;
    }


    /**
     * Gets the fmtPatrn value for this TextFrame.
     * 
     * @return fmtPatrn   * ICU specification of the formatting string for this field.
     */
    public java.lang.String getFmtPatrn() {
        return fmtPatrn;
    }


    /**
     * Sets the fmtPatrn value for this TextFrame.
     * 
     * @param fmtPatrn   * ICU specification of the formatting string for this field.
     */
    public void setFmtPatrn(java.lang.String fmtPatrn) {
        this.fmtPatrn = fmtPatrn;
    }


    /**
     * Gets the exclPatrn value for this TextFrame.
     * 
     * @return exclPatrn   * Excel-type formatting pattern for this field. If not present,
     * assume "General".
     */
    public java.lang.String getExclPatrn() {
        return exclPatrn;
    }


    /**
     * Sets the exclPatrn value for this TextFrame.
     * 
     * @param exclPatrn   * Excel-type formatting pattern for this field. If not present,
     * assume "General".
     */
    public void setExclPatrn(java.lang.String exclPatrn) {
        this.exclPatrn = exclPatrn;
    }


    /**
     * Gets the fmtLoc value for this TextFrame.
     * 
     * @return fmtLoc   * Locale used for formatting
     */
    public java.lang.String getFmtLoc() {
        return fmtLoc;
    }


    /**
     * Sets the fmtLoc value for this TextFrame.
     * 
     * @param fmtLoc   * Locale used for formatting
     */
    public void setFmtLoc(java.lang.String fmtLoc) {
        this.fmtLoc = fmtLoc;
    }


    /**
     * Gets the fmtScale value for this TextFrame.
     * 
     * @return fmtScale   * A scaling factor (number of digits)  that should be applied
     * to the raw value in element val, to get the formattted value.
     */
    public java.lang.Integer getFmtScale() {
        return fmtScale;
    }


    /**
     * Sets the fmtScale value for this TextFrame.
     * 
     * @param fmtScale   * A scaling factor (number of digits)  that should be applied
     * to the raw value in element val, to get the formattted value.
     */
    public void setFmtScale(java.lang.Integer fmtScale) {
        this.fmtScale = fmtScale;
    }


    /**
     * Gets the extension value for this TextFrame.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this TextFrame.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TextFrame)) return false;
        TextFrame other = (TextFrame) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ref==null && other.getRef()==null) || 
             (this.ref!=null &&
              this.ref.equals(other.getRef()))) &&
            ((this.ctx==null && other.getCtx()==null) || 
             (this.ctx!=null &&
              this.ctx.equals(other.getCtx()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              java.util.Arrays.equals(this.style, other.getStyle()))) &&
            ((this.drills==null && other.getDrills()==null) || 
             (this.drills!=null &&
              java.util.Arrays.equals(this.drills, other.getDrills()))) &&
            ((this.val==null && other.getVal()==null) || 
             (this.val!=null &&
              this.val.equals(other.getVal()))) &&
            ((this.valErrorState==null && other.getValErrorState()==null) || 
             (this.valErrorState!=null &&
              this.valErrorState.equals(other.getValErrorState()))) &&
            ((this.valTyp==null && other.getValTyp()==null) || 
             (this.valTyp!=null &&
              this.valTyp.equals(other.getValTyp()))) &&
            ((this.fmtVal==null && other.getFmtVal()==null) || 
             (this.fmtVal!=null &&
              this.fmtVal.equals(other.getFmtVal()))) &&
            ((this.fmtPatrn==null && other.getFmtPatrn()==null) || 
             (this.fmtPatrn!=null &&
              this.fmtPatrn.equals(other.getFmtPatrn()))) &&
            ((this.exclPatrn==null && other.getExclPatrn()==null) || 
             (this.exclPatrn!=null &&
              this.exclPatrn.equals(other.getExclPatrn()))) &&
            ((this.fmtLoc==null && other.getFmtLoc()==null) || 
             (this.fmtLoc!=null &&
              this.fmtLoc.equals(other.getFmtLoc()))) &&
            ((this.fmtScale==null && other.getFmtScale()==null) || 
             (this.fmtScale!=null &&
              this.fmtScale.equals(other.getFmtScale()))) &&
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getRef() != null) {
            _hashCode += getRef().hashCode();
        }
        if (getCtx() != null) {
            _hashCode += getCtx().hashCode();
        }
        if (getStyle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStyle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStyle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDrills() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDrills());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDrills(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVal() != null) {
            _hashCode += getVal().hashCode();
        }
        if (getValErrorState() != null) {
            _hashCode += getValErrorState().hashCode();
        }
        if (getValTyp() != null) {
            _hashCode += getValTyp().hashCode();
        }
        if (getFmtVal() != null) {
            _hashCode += getFmtVal().hashCode();
        }
        if (getFmtPatrn() != null) {
            _hashCode += getFmtPatrn().hashCode();
        }
        if (getExclPatrn() != null) {
            _hashCode += getExclPatrn().hashCode();
        }
        if (getFmtLoc() != null) {
            _hashCode += getFmtLoc().hashCode();
        }
        if (getFmtScale() != null) {
            _hashCode += getFmtScale().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TextFrame.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ref");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctx");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ctx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "style"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "style"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drills");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "drills"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">drills"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("val");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "val"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valErrorState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "valErrorState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TFStateEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valTyp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "valTyp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TFValueTypeEnum"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fmtVal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "fmtVal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fmtPatrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "fmtPatrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exclPatrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "exclPatrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fmtLoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "fmtLoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fmtScale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "fmtScale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">extension"));
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
