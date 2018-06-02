/**
 * ChartArea.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class ChartArea  implements java.io.Serializable {
    /* A logical reference to the part of the chart being labeled,
     * in this area definition. */
    private java.lang.String type;

    /* The coordinates for the set of points that define the area's
     * region in the chart image. */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaCoord[] coord;

    private java.lang.String alternateText;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[] drills;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction[] drillAction;

    /* The label or tooltip that applies to this area's region.. */
    private java.lang.String label;

    private java.lang.String ctx;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMember[] member;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMeasure[] measure;

    public ChartArea() {
    }

    public ChartArea(
           java.lang.String type,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaCoord[] coord,
           java.lang.String alternateText,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[] drills,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction[] drillAction,
           java.lang.String label,
           java.lang.String ctx,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMember[] member,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMeasure[] measure) {
           this.type = type;
           this.coord = coord;
           this.alternateText = alternateText;
           this.drills = drills;
           this.drillAction = drillAction;
           this.label = label;
           this.ctx = ctx;
           this.member = member;
           this.measure = measure;
    }


    /**
     * Gets the type value for this ChartArea.
     * 
     * @return type   * A logical reference to the part of the chart being labeled,
     * in this area definition.
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this ChartArea.
     * 
     * @param type   * A logical reference to the part of the chart being labeled,
     * in this area definition.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the coord value for this ChartArea.
     * 
     * @return coord   * The coordinates for the set of points that define the area's
     * region in the chart image.
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaCoord[] getCoord() {
        return coord;
    }


    /**
     * Sets the coord value for this ChartArea.
     * 
     * @param coord   * The coordinates for the set of points that define the area's
     * region in the chart image.
     */
    public void setCoord(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaCoord[] coord) {
        this.coord = coord;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaCoord getCoord(int i) {
        return this.coord[i];
    }

    public void setCoord(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaCoord _value) {
        this.coord[i] = _value;
    }


    /**
     * Gets the alternateText value for this ChartArea.
     * 
     * @return alternateText
     */
    public java.lang.String getAlternateText() {
        return alternateText;
    }


    /**
     * Sets the alternateText value for this ChartArea.
     * 
     * @param alternateText
     */
    public void setAlternateText(java.lang.String alternateText) {
        this.alternateText = alternateText;
    }


    /**
     * Gets the drills value for this ChartArea.
     * 
     * @return drills
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[] getDrills() {
        return drills;
    }


    /**
     * Sets the drills value for this ChartArea.
     * 
     * @param drills
     */
    public void setDrills(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[] drills) {
        this.drills = drills;
    }


    /**
     * Gets the drillAction value for this ChartArea.
     * 
     * @return drillAction
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction[] getDrillAction() {
        return drillAction;
    }


    /**
     * Sets the drillAction value for this ChartArea.
     * 
     * @param drillAction
     */
    public void setDrillAction(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction[] drillAction) {
        this.drillAction = drillAction;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction getDrillAction(int i) {
        return this.drillAction[i];
    }

    public void setDrillAction(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction _value) {
        this.drillAction[i] = _value;
    }


    /**
     * Gets the label value for this ChartArea.
     * 
     * @return label   * The label or tooltip that applies to this area's region..
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this ChartArea.
     * 
     * @param label   * The label or tooltip that applies to this area's region..
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the ctx value for this ChartArea.
     * 
     * @return ctx
     */
    public java.lang.String getCtx() {
        return ctx;
    }


    /**
     * Sets the ctx value for this ChartArea.
     * 
     * @param ctx
     */
    public void setCtx(java.lang.String ctx) {
        this.ctx = ctx;
    }


    /**
     * Gets the member value for this ChartArea.
     * 
     * @return member
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMember[] getMember() {
        return member;
    }


    /**
     * Sets the member value for this ChartArea.
     * 
     * @param member
     */
    public void setMember(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMember[] member) {
        this.member = member;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMember getMember(int i) {
        return this.member[i];
    }

    public void setMember(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMember _value) {
        this.member[i] = _value;
    }


    /**
     * Gets the measure value for this ChartArea.
     * 
     * @return measure
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMeasure[] getMeasure() {
        return measure;
    }


    /**
     * Sets the measure value for this ChartArea.
     * 
     * @param measure
     */
    public void setMeasure(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMeasure[] measure) {
        this.measure = measure;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMeasure getMeasure(int i) {
        return this.measure[i];
    }

    public void setMeasure(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMeasure _value) {
        this.measure[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChartArea)) return false;
        ChartArea other = (ChartArea) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.coord==null && other.getCoord()==null) || 
             (this.coord!=null &&
              java.util.Arrays.equals(this.coord, other.getCoord()))) &&
            ((this.alternateText==null && other.getAlternateText()==null) || 
             (this.alternateText!=null &&
              this.alternateText.equals(other.getAlternateText()))) &&
            ((this.drills==null && other.getDrills()==null) || 
             (this.drills!=null &&
              java.util.Arrays.equals(this.drills, other.getDrills()))) &&
            ((this.drillAction==null && other.getDrillAction()==null) || 
             (this.drillAction!=null &&
              java.util.Arrays.equals(this.drillAction, other.getDrillAction()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.ctx==null && other.getCtx()==null) || 
             (this.ctx!=null &&
              this.ctx.equals(other.getCtx()))) &&
            ((this.member==null && other.getMember()==null) || 
             (this.member!=null &&
              java.util.Arrays.equals(this.member, other.getMember()))) &&
            ((this.measure==null && other.getMeasure()==null) || 
             (this.measure!=null &&
              java.util.Arrays.equals(this.measure, other.getMeasure())));
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
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getCoord() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCoord());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCoord(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAlternateText() != null) {
            _hashCode += getAlternateText().hashCode();
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
        if (getDrillAction() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDrillAction());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDrillAction(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getCtx() != null) {
            _hashCode += getCtx().hashCode();
        }
        if (getMember() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMember());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMember(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMeasure() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMeasure());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMeasure(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChartArea.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ChartArea"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coord");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "coord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">ChartArea>coord"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alternateText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "alternateText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drills");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drills"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">drills"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drillAction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drillAction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drillAction"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctx");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ctx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("member");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "member"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">ChartArea>member"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("measure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "measure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">ChartArea>measure"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
