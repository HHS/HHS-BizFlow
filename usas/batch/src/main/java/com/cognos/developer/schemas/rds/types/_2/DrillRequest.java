/**
 * DrillRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.rds.types._2;

public class DrillRequest  implements java.io.Serializable {
    private SessionType session;

    /* The contextId related to the object being drilled on */
    private java.lang.String contextID;

    /* The direction to drill, up or down */
    private DirectionEnum direction;

    public DrillRequest() {
    }

    public DrillRequest(
           com.cognos.developer.schemas.rds.types._2.SessionType session,
           java.lang.String contextID,
           com.cognos.developer.schemas.rds.types._2.DirectionEnum direction) {
           this.session = session;
           this.contextID = contextID;
           this.direction = direction;
    }


    /**
     * Gets the session value for this DrillRequest.
     * 
     * @return session
     */
    public SessionType getSession() {
        return session;
    }


    /**
     * Sets the session value for this DrillRequest.
     * 
     * @param session
     */
    public void setSession(com.cognos.developer.schemas.rds.types._2.SessionType session) {
        this.session = session;
    }


    /**
     * Gets the contextID value for this DrillRequest.
     * 
     * @return contextID   * The contextId related to the object being drilled on
     */
    public java.lang.String getContextID() {
        return contextID;
    }


    /**
     * Sets the contextID value for this DrillRequest.
     * 
     * @param contextID   * The contextId related to the object being drilled on
     */
    public void setContextID(java.lang.String contextID) {
        this.contextID = contextID;
    }


    /**
     * Gets the direction value for this DrillRequest.
     * 
     * @return direction   * The direction to drill, up or down
     */
    public DirectionEnum getDirection() {
        return direction;
    }


    /**
     * Sets the direction value for this DrillRequest.
     * 
     * @param direction   * The direction to drill, up or down
     */
    public void setDirection(com.cognos.developer.schemas.rds.types._2.DirectionEnum direction) {
        this.direction = direction;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DrillRequest)) return false;
        DrillRequest other = (DrillRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.session==null && other.getSession()==null) || 
             (this.session!=null &&
              this.session.equals(other.getSession()))) &&
            ((this.contextID==null && other.getContextID()==null) || 
             (this.contextID!=null &&
              this.contextID.equals(other.getContextID()))) &&
            ((this.direction==null && other.getDirection()==null) || 
             (this.direction!=null &&
              this.direction.equals(other.getDirection())));
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
        if (getSession() != null) {
            _hashCode += getSession().hashCode();
        }
        if (getContextID() != null) {
            _hashCode += getContextID().hashCode();
        }
        if (getDirection() != null) {
            _hashCode += getDirection().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DrillRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">DrillRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("session");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "session"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SessionType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contextID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "contextID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direction");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "direction"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "DirectionEnum"));
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
