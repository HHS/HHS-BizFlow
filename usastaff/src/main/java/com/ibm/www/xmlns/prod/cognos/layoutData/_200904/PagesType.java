/**
 * PagesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class PagesType  implements java.io.Serializable {
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Page page;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PageGroup pageGroup;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public PagesType() {
    }

    public PagesType(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Page page,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PageGroup pageGroup,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.page = page;
           this.pageGroup = pageGroup;
           this.extension = extension;
    }


    /**
     * Gets the page value for this PagesType.
     * 
     * @return page
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Page getPage() {
        return page;
    }


    /**
     * Sets the page value for this PagesType.
     * 
     * @param page
     */
    public void setPage(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Page page) {
        this.page = page;
    }


    /**
     * Gets the pageGroup value for this PagesType.
     * 
     * @return pageGroup
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PageGroup getPageGroup() {
        return pageGroup;
    }


    /**
     * Sets the pageGroup value for this PagesType.
     * 
     * @param pageGroup
     */
    public void setPageGroup(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PageGroup pageGroup) {
        this.pageGroup = pageGroup;
    }


    /**
     * Gets the extension value for this PagesType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this PagesType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PagesType)) return false;
        PagesType other = (PagesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.page==null && other.getPage()==null) || 
             (this.page!=null &&
              this.page.equals(other.getPage()))) &&
            ((this.pageGroup==null && other.getPageGroup()==null) || 
             (this.pageGroup!=null &&
              this.pageGroup.equals(other.getPageGroup()))) &&
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
        if (getPage() != null) {
            _hashCode += getPage().hashCode();
        }
        if (getPageGroup() != null) {
            _hashCode += getPageGroup().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PagesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pagesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("page");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "page"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Page"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pageGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PageGroup"));
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
