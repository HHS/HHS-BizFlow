/**
 * Image.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class Image  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String style;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[] drills;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction[] drillAction;

    /* An absolute URI path to an image file. */
    private java.lang.String url;

    private java.lang.Boolean isCMMMap;

    private java.lang.String alternateText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public Image() {
    }

    public Image(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String style,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[] drills,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction[] drillAction,
           java.lang.String url,
           java.lang.Boolean isCMMMap,
           java.lang.String alternateText,
           java.lang.String annURL,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.drills = drills;
           this.drillAction = drillAction;
           this.url = url;
           this.isCMMMap = isCMMMap;
           this.alternateText = alternateText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this Image.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Image.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this Image.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this Image.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this Image.
     * 
     * @return style
     */
    public java.lang.String getStyle() {
        return style;
    }


    /**
     * Sets the style value for this Image.
     * 
     * @param style
     */
    public void setStyle(java.lang.String style) {
        this.style = style;
    }


    /**
     * Gets the drills value for this Image.
     * 
     * @return drills
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[] getDrills() {
        return drills;
    }


    /**
     * Sets the drills value for this Image.
     * 
     * @param drills
     */
    public void setDrills(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[] drills) {
        this.drills = drills;
    }


    /**
     * Gets the drillAction value for this Image.
     * 
     * @return drillAction
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction[] getDrillAction() {
        return drillAction;
    }


    /**
     * Sets the drillAction value for this Image.
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
     * Gets the url value for this Image.
     * 
     * @return url   * An absolute URI path to an image file.
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this Image.
     * 
     * @param url   * An absolute URI path to an image file.
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the isCMMMap value for this Image.
     * 
     * @return isCMMMap
     */
    public java.lang.Boolean getIsCMMMap() {
        return isCMMMap;
    }


    /**
     * Sets the isCMMMap value for this Image.
     * 
     * @param isCMMMap
     */
    public void setIsCMMMap(java.lang.Boolean isCMMMap) {
        this.isCMMMap = isCMMMap;
    }


    /**
     * Gets the alternateText value for this Image.
     * 
     * @return alternateText
     */
    public java.lang.String getAlternateText() {
        return alternateText;
    }


    /**
     * Sets the alternateText value for this Image.
     * 
     * @param alternateText
     */
    public void setAlternateText(java.lang.String alternateText) {
        this.alternateText = alternateText;
    }


    /**
     * Gets the annURL value for this Image.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this Image.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this Image.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this Image.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Image)) return false;
        Image other = (Image) obj;
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
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              this.style.equals(other.getStyle()))) &&
            ((this.drills==null && other.getDrills()==null) || 
             (this.drills!=null &&
              java.util.Arrays.equals(this.drills, other.getDrills()))) &&
            ((this.drillAction==null && other.getDrillAction()==null) || 
             (this.drillAction!=null &&
              java.util.Arrays.equals(this.drillAction, other.getDrillAction()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.isCMMMap==null && other.getIsCMMMap()==null) || 
             (this.isCMMMap!=null &&
              this.isCMMMap.equals(other.getIsCMMMap()))) &&
            ((this.alternateText==null && other.getAlternateText()==null) || 
             (this.alternateText!=null &&
              this.alternateText.equals(other.getAlternateText()))) &&
            ((this.annURL==null && other.getAnnURL()==null) || 
             (this.annURL!=null &&
              this.annURL.equals(other.getAnnURL()))) &&
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
        if (getStyle() != null) {
            _hashCode += getStyle().hashCode();
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
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getIsCMMMap() != null) {
            _hashCode += getIsCMMMap().hashCode();
        }
        if (getAlternateText() != null) {
            _hashCode += getAlternateText().hashCode();
        }
        if (getAnnURL() != null) {
            _hashCode += getAnnURL().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Image.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Image"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ref");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
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
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCMMMap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "isCMMMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alternateText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "alternateText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "annURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
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
