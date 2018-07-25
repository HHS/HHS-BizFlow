/**
 * ChartArea.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class ChartArea  implements java.io.Serializable {
    /* A logical reference to the part of the chart being labeled,
     * in this area definition. */
    private java.lang.String type;

    /* The coordinates for the set of points that define the area's
     * region in the chart image. */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaCoord[] coord;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[] drills;

    /* The label or tooltip that applies to this area's region.. */
    private java.lang.String label;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMember[] member;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMeasure[] measure;

    public ChartArea() {
    }

    public ChartArea(
           java.lang.String type,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaCoord[] coord,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[] drills,
           java.lang.String label,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMember[] member,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMeasure[] measure) {
           this.type = type;
           this.coord = coord;
           this.drills = drills;
           this.label = label;
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
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaCoord[] getCoord() {
        return coord;
    }


    /**
     * Sets the coord value for this ChartArea.
     * 
     * @param coord   * The coordinates for the set of points that define the area's
     * region in the chart image.
     */
    public void setCoord(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaCoord[] coord) {
        this.coord = coord;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaCoord getCoord(int i) {
        return this.coord[i];
    }

    public void setCoord(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaCoord _value) {
        this.coord[i] = _value;
    }


    /**
     * Gets the drills value for this ChartArea.
     * 
     * @return drills
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[] getDrills() {
        return drills;
    }


    /**
     * Sets the drills value for this ChartArea.
     * 
     * @param drills
     */
    public void setDrills(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[] drills) {
        this.drills = drills;
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
     * Gets the member value for this ChartArea.
     * 
     * @return member
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMember[] getMember() {
        return member;
    }


    /**
     * Sets the member value for this ChartArea.
     * 
     * @param member
     */
    public void setMember(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMember[] member) {
        this.member = member;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMember getMember(int i) {
        return this.member[i];
    }

    public void setMember(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMember _value) {
        this.member[i] = _value;
    }


    /**
     * Gets the measure value for this ChartArea.
     * 
     * @return measure
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMeasure[] getMeasure() {
        return measure;
    }


    /**
     * Sets the measure value for this ChartArea.
     * 
     * @param measure
     */
    public void setMeasure(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMeasure[] measure) {
        this.measure = measure;
    }

    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMeasure getMeasure(int i) {
        return this.measure[i];
    }

    public void setMeasure(int i, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMeasure _value) {
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
            ((this.drills==null && other.getDrills()==null) || 
             (this.drills!=null &&
              java.util.Arrays.equals(this.drills, other.getDrills()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
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
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ChartArea"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coord");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "coord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">ChartArea>coord"));
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
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("member");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "member"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">ChartArea>member"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("measure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "measure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">ChartArea>measure"));
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
