/**
 * Document.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * Definition of a Cognos Content artifact.
 */
public class Document  implements java.io.Serializable {
    /* A list of available secondary operations that can be performed
     * on this document, such as next page. */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations[] secondaryOperations;

    private java.lang.String schemaSubversion;

    private java.lang.String versionBase;

    private java.lang.String id;

    private java.lang.String[] style;

    /* a table of "location references" that describe a report elements
     * source location (e.g. relative to its  ReportSpec). */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference[] locationReference;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType[] pages;

    /* Definitions of drillthrough targets. These definitions are
     * indexed by the drill targets defined in cells. */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[] drillDefinitions;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup[] styleGroup;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public Document() {
    }

    public Document(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations[] secondaryOperations,
           java.lang.String schemaSubversion,
           java.lang.String versionBase,
           java.lang.String id,
           java.lang.String[] style,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference[] locationReference,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType[] pages,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[] drillDefinitions,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup[] styleGroup,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.secondaryOperations = secondaryOperations;
           this.schemaSubversion = schemaSubversion;
           this.versionBase = versionBase;
           this.id = id;
           this.style = style;
           this.locationReference = locationReference;
           this.pages = pages;
           this.drillDefinitions = drillDefinitions;
           this.styleGroup = styleGroup;
           this.extension = extension;
    }


    /**
     * Gets the secondaryOperations value for this Document.
     * 
     * @return secondaryOperations   * A list of available secondary operations that can be performed
     * on this document, such as next page.
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations[] getSecondaryOperations() {
        return secondaryOperations;
    }


    /**
     * Sets the secondaryOperations value for this Document.
     * 
     * @param secondaryOperations   * A list of available secondary operations that can be performed
     * on this document, such as next page.
     */
    public void setSecondaryOperations(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations[] secondaryOperations) {
        this.secondaryOperations = secondaryOperations;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations getSecondaryOperations(int i) {
        return this.secondaryOperations[i];
    }

    public void setSecondaryOperations(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations _value) {
        this.secondaryOperations[i] = _value;
    }


    /**
     * Gets the schemaSubversion value for this Document.
     * 
     * @return schemaSubversion
     */
    public java.lang.String getSchemaSubversion() {
        return schemaSubversion;
    }


    /**
     * Sets the schemaSubversion value for this Document.
     * 
     * @param schemaSubversion
     */
    public void setSchemaSubversion(java.lang.String schemaSubversion) {
        this.schemaSubversion = schemaSubversion;
    }


    /**
     * Gets the versionBase value for this Document.
     * 
     * @return versionBase
     */
    public java.lang.String getVersionBase() {
        return versionBase;
    }


    /**
     * Sets the versionBase value for this Document.
     * 
     * @param versionBase
     */
    public void setVersionBase(java.lang.String versionBase) {
        this.versionBase = versionBase;
    }


    /**
     * Gets the id value for this Document.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Document.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the style value for this Document.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this Document.
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
     * Gets the locationReference value for this Document.
     * 
     * @return locationReference   * a table of "location references" that describe a report elements
     * source location (e.g. relative to its  ReportSpec).
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference[] getLocationReference() {
        return locationReference;
    }


    /**
     * Sets the locationReference value for this Document.
     * 
     * @param locationReference   * a table of "location references" that describe a report elements
     * source location (e.g. relative to its  ReportSpec).
     */
    public void setLocationReference(com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference[] locationReference) {
        this.locationReference = locationReference;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference getLocationReference(int i) {
        return this.locationReference[i];
    }

    public void setLocationReference(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference _value) {
        this.locationReference[i] = _value;
    }


    /**
     * Gets the pages value for this Document.
     * 
     * @return pages
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType[] getPages() {
        return pages;
    }


    /**
     * Sets the pages value for this Document.
     * 
     * @param pages
     */
    public void setPages(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType[] pages) {
        this.pages = pages;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType getPages(int i) {
        return this.pages[i];
    }

    public void setPages(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType _value) {
        this.pages[i] = _value;
    }


    /**
     * Gets the drillDefinitions value for this Document.
     * 
     * @return drillDefinitions   * Definitions of drillthrough targets. These definitions are
     * indexed by the drill targets defined in cells.
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[] getDrillDefinitions() {
        return drillDefinitions;
    }


    /**
     * Sets the drillDefinitions value for this Document.
     * 
     * @param drillDefinitions   * Definitions of drillthrough targets. These definitions are
     * indexed by the drill targets defined in cells.
     */
    public void setDrillDefinitions(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[] drillDefinitions) {
        this.drillDefinitions = drillDefinitions;
    }


    /**
     * Gets the styleGroup value for this Document.
     * 
     * @return styleGroup
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup[] getStyleGroup() {
        return styleGroup;
    }


    /**
     * Sets the styleGroup value for this Document.
     * 
     * @param styleGroup
     */
    public void setStyleGroup(com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup[] styleGroup) {
        this.styleGroup = styleGroup;
    }

    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup getStyleGroup(int i) {
        return this.styleGroup[i];
    }

    public void setStyleGroup(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup _value) {
        this.styleGroup[i] = _value;
    }


    /**
     * Gets the extension value for this Document.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this Document.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Document)) return false;
        Document other = (Document) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.secondaryOperations==null && other.getSecondaryOperations()==null) || 
             (this.secondaryOperations!=null &&
              java.util.Arrays.equals(this.secondaryOperations, other.getSecondaryOperations()))) &&
            ((this.schemaSubversion==null && other.getSchemaSubversion()==null) || 
             (this.schemaSubversion!=null &&
              this.schemaSubversion.equals(other.getSchemaSubversion()))) &&
            ((this.versionBase==null && other.getVersionBase()==null) || 
             (this.versionBase!=null &&
              this.versionBase.equals(other.getVersionBase()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              java.util.Arrays.equals(this.style, other.getStyle()))) &&
            ((this.locationReference==null && other.getLocationReference()==null) || 
             (this.locationReference!=null &&
              java.util.Arrays.equals(this.locationReference, other.getLocationReference()))) &&
            ((this.pages==null && other.getPages()==null) || 
             (this.pages!=null &&
              java.util.Arrays.equals(this.pages, other.getPages()))) &&
            ((this.drillDefinitions==null && other.getDrillDefinitions()==null) || 
             (this.drillDefinitions!=null &&
              java.util.Arrays.equals(this.drillDefinitions, other.getDrillDefinitions()))) &&
            ((this.styleGroup==null && other.getStyleGroup()==null) || 
             (this.styleGroup!=null &&
              java.util.Arrays.equals(this.styleGroup, other.getStyleGroup()))) &&
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
        if (getSecondaryOperations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecondaryOperations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecondaryOperations(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSchemaSubversion() != null) {
            _hashCode += getSchemaSubversion().hashCode();
        }
        if (getVersionBase() != null) {
            _hashCode += getVersionBase().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
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
        if (getLocationReference() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLocationReference());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLocationReference(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPages() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPages());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPages(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDrillDefinitions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDrillDefinitions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDrillDefinitions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStyleGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStyleGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStyleGroup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Document.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Document"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secondaryOperations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "secondaryOperations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "secondaryOperations"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("schemaSubversion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "schemaSubversion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionBase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "versionBase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "id"));
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
        elemField.setFieldName("locationReference");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "locationReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "locationReference"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pages");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pages"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drillDefinitions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drillDefinitions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">DrillDefinitions>drill"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drill"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("styleGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "styleGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "styleGroup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
