/**
 * Chart.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class Chart  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String[] style;

    private java.lang.String url;

    /* This element holds the labels or tooltips that correspond to
     * regions of the chart image referenced in the url element */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartArea[] regions;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsCanvasDef details;

    private java.lang.String alternateText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public Chart() {
    }

    public Chart(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String[] style,
           java.lang.String url,
           ChartArea[] regions,
           CgsCanvasDef details,
           java.lang.String alternateText,
           java.lang.String annURL,
           Extension extension) {
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.url = url;
           this.regions = regions;
           this.details = details;
           this.alternateText = alternateText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this Chart.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Chart.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this Chart.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this Chart.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this Chart.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this Chart.
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
     * Gets the url value for this Chart.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this Chart.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the regions value for this Chart.
     * 
     * @return regions   * This element holds the labels or tooltips that correspond to
     * regions of the chart image referenced in the url element
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartArea[] getRegions() {
        return regions;
    }


    /**
     * Sets the regions value for this Chart.
     * 
     * @param regions   * This element holds the labels or tooltips that correspond to
     * regions of the chart image referenced in the url element
     */
    public void setRegions(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartArea[] regions) {
        this.regions = regions;
    }


    /**
     * Gets the details value for this Chart.
     * 
     * @return details
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsCanvasDef getDetails() {
        return details;
    }


    /**
     * Sets the details value for this Chart.
     * 
     * @param details
     */
    public void setDetails(com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsCanvasDef details) {
        this.details = details;
    }


    /**
     * Gets the alternateText value for this Chart.
     * 
     * @return alternateText
     */
    public java.lang.String getAlternateText() {
        return alternateText;
    }


    /**
     * Sets the alternateText value for this Chart.
     * 
     * @param alternateText
     */
    public void setAlternateText(java.lang.String alternateText) {
        this.alternateText = alternateText;
    }


    /**
     * Gets the annURL value for this Chart.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this Chart.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this Chart.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this Chart.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Chart)) return false;
        Chart other = (Chart) obj;
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
              java.util.Arrays.equals(this.style, other.getStyle()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.regions==null && other.getRegions()==null) || 
             (this.regions!=null &&
              java.util.Arrays.equals(this.regions, other.getRegions()))) &&
            ((this.details==null && other.getDetails()==null) || 
             (this.details!=null &&
              this.details.equals(other.getDetails()))) &&
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
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getRegions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDetails() != null) {
            _hashCode += getDetails().hashCode();
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
        new org.apache.axis.description.TypeDesc(Chart.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Chart"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
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
        elemField.setFieldName("regions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "regions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ChartArea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "area"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("details");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "details"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cgsCanvasDef"));
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
