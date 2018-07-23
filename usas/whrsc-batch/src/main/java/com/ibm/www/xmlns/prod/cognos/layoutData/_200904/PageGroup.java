/**
 * PageGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * A grouping level for groups of pages. Page breaks for the group
 * can be defined, based on a dataItem changing.
 */
public class PageGroup  implements java.io.Serializable {
    /* If applicable, the dataItem (from the respective query) corresponding
     * to this page group. */
    private java.lang.String di;

    /* If applicable, the dataItem value corresponding to this page
     * group selection. */
    private java.lang.String dv;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType[] pages;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public PageGroup() {
    }

    public PageGroup(
           java.lang.String di,
           java.lang.String dv,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType[] pages,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.di = di;
           this.dv = dv;
           this.pages = pages;
           this.extension = extension;
    }


    /**
     * Gets the di value for this PageGroup.
     * 
     * @return di   * If applicable, the dataItem (from the respective query) corresponding
     * to this page group.
     */
    public java.lang.String getDi() {
        return di;
    }


    /**
     * Sets the di value for this PageGroup.
     * 
     * @param di   * If applicable, the dataItem (from the respective query) corresponding
     * to this page group.
     */
    public void setDi(java.lang.String di) {
        this.di = di;
    }


    /**
     * Gets the dv value for this PageGroup.
     * 
     * @return dv   * If applicable, the dataItem value corresponding to this page
     * group selection.
     */
    public java.lang.String getDv() {
        return dv;
    }


    /**
     * Sets the dv value for this PageGroup.
     * 
     * @param dv   * If applicable, the dataItem value corresponding to this page
     * group selection.
     */
    public void setDv(java.lang.String dv) {
        this.dv = dv;
    }


    /**
     * Gets the pages value for this PageGroup.
     * 
     * @return pages
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType[] getPages() {
        return pages;
    }


    /**
     * Sets the pages value for this PageGroup.
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
     * Gets the extension value for this PageGroup.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PageGroup.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PageGroup)) return false;
        PageGroup other = (PageGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.di==null && other.getDi()==null) || 
             (this.di!=null &&
              this.di.equals(other.getDi()))) &&
            ((this.dv==null && other.getDv()==null) || 
             (this.dv!=null &&
              this.dv.equals(other.getDv()))) &&
            ((this.pages==null && other.getPages()==null) || 
             (this.pages!=null &&
              java.util.Arrays.equals(this.pages, other.getPages()))) &&
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
        if (getDi() != null) {
            _hashCode += getDi().hashCode();
        }
        if (getDv() != null) {
            _hashCode += getDv().hashCode();
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
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PageGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PageGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("di");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "di"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dv");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "dv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pages");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pages"));
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
