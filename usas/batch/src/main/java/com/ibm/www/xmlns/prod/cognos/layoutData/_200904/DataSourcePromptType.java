/**
 * DataSourcePromptType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class DataSourcePromptType  implements java.io.Serializable {
    private java.lang.String pname;

    private java.lang.String faultcode;

    private java.lang.String faultstring;

    private java.lang.String dataSourceName;

    private java.lang.Integer logonFailureCount;

    private java.lang.String persistPrompt;

    private ConnectionType[] connection;

    private SignonType[] signon;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public DataSourcePromptType() {
    }

    public DataSourcePromptType(
           java.lang.String pname,
           java.lang.String faultcode,
           java.lang.String faultstring,
           java.lang.String dataSourceName,
           java.lang.Integer logonFailureCount,
           java.lang.String persistPrompt,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ConnectionType[] connection,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SignonType[] signon,
           java.lang.String annURL,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.pname = pname;
           this.faultcode = faultcode;
           this.faultstring = faultstring;
           this.dataSourceName = dataSourceName;
           this.logonFailureCount = logonFailureCount;
           this.persistPrompt = persistPrompt;
           this.connection = connection;
           this.signon = signon;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the pname value for this DataSourcePromptType.
     * 
     * @return pname
     */
    public java.lang.String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this DataSourcePromptType.
     * 
     * @param pname
     */
    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }


    /**
     * Gets the faultcode value for this DataSourcePromptType.
     * 
     * @return faultcode
     */
    public java.lang.String getFaultcode() {
        return faultcode;
    }


    /**
     * Sets the faultcode value for this DataSourcePromptType.
     * 
     * @param faultcode
     */
    public void setFaultcode(java.lang.String faultcode) {
        this.faultcode = faultcode;
    }


    /**
     * Gets the faultstring value for this DataSourcePromptType.
     * 
     * @return faultstring
     */
    public java.lang.String getFaultstring() {
        return faultstring;
    }


    /**
     * Sets the faultstring value for this DataSourcePromptType.
     * 
     * @param faultstring
     */
    public void setFaultstring(java.lang.String faultstring) {
        this.faultstring = faultstring;
    }


    /**
     * Gets the dataSourceName value for this DataSourcePromptType.
     * 
     * @return dataSourceName
     */
    public java.lang.String getDataSourceName() {
        return dataSourceName;
    }


    /**
     * Sets the dataSourceName value for this DataSourcePromptType.
     * 
     * @param dataSourceName
     */
    public void setDataSourceName(java.lang.String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }


    /**
     * Gets the logonFailureCount value for this DataSourcePromptType.
     * 
     * @return logonFailureCount
     */
    public java.lang.Integer getLogonFailureCount() {
        return logonFailureCount;
    }


    /**
     * Sets the logonFailureCount value for this DataSourcePromptType.
     * 
     * @param logonFailureCount
     */
    public void setLogonFailureCount(java.lang.Integer logonFailureCount) {
        this.logonFailureCount = logonFailureCount;
    }


    /**
     * Gets the persistPrompt value for this DataSourcePromptType.
     * 
     * @return persistPrompt
     */
    public java.lang.String getPersistPrompt() {
        return persistPrompt;
    }


    /**
     * Sets the persistPrompt value for this DataSourcePromptType.
     * 
     * @param persistPrompt
     */
    public void setPersistPrompt(java.lang.String persistPrompt) {
        this.persistPrompt = persistPrompt;
    }


    /**
     * Gets the connection value for this DataSourcePromptType.
     * 
     * @return connection
     */
    public ConnectionType[] getConnection() {
        return connection;
    }


    /**
     * Sets the connection value for this DataSourcePromptType.
     * 
     * @param connection
     */
    public void setConnection(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ConnectionType[] connection) {
        this.connection = connection;
    }

    public ConnectionType getConnection(int i) {
        return this.connection[i];
    }

    public void setConnection(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.ConnectionType _value) {
        this.connection[i] = _value;
    }


    /**
     * Gets the signon value for this DataSourcePromptType.
     * 
     * @return signon
     */
    public SignonType[] getSignon() {
        return signon;
    }


    /**
     * Sets the signon value for this DataSourcePromptType.
     * 
     * @param signon
     */
    public void setSignon(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SignonType[] signon) {
        this.signon = signon;
    }

    public SignonType getSignon(int i) {
        return this.signon[i];
    }

    public void setSignon(int i, com.ibm.www.xmlns.prod.cognos.layoutData._200904.SignonType _value) {
        this.signon[i] = _value;
    }


    /**
     * Gets the annURL value for this DataSourcePromptType.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this DataSourcePromptType.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this DataSourcePromptType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this DataSourcePromptType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataSourcePromptType)) return false;
        DataSourcePromptType other = (DataSourcePromptType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pname==null && other.getPname()==null) || 
             (this.pname!=null &&
              this.pname.equals(other.getPname()))) &&
            ((this.faultcode==null && other.getFaultcode()==null) || 
             (this.faultcode!=null &&
              this.faultcode.equals(other.getFaultcode()))) &&
            ((this.faultstring==null && other.getFaultstring()==null) || 
             (this.faultstring!=null &&
              this.faultstring.equals(other.getFaultstring()))) &&
            ((this.dataSourceName==null && other.getDataSourceName()==null) || 
             (this.dataSourceName!=null &&
              this.dataSourceName.equals(other.getDataSourceName()))) &&
            ((this.logonFailureCount==null && other.getLogonFailureCount()==null) || 
             (this.logonFailureCount!=null &&
              this.logonFailureCount.equals(other.getLogonFailureCount()))) &&
            ((this.persistPrompt==null && other.getPersistPrompt()==null) || 
             (this.persistPrompt!=null &&
              this.persistPrompt.equals(other.getPersistPrompt()))) &&
            ((this.connection==null && other.getConnection()==null) || 
             (this.connection!=null &&
              java.util.Arrays.equals(this.connection, other.getConnection()))) &&
            ((this.signon==null && other.getSignon()==null) || 
             (this.signon!=null &&
              java.util.Arrays.equals(this.signon, other.getSignon()))) &&
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
        if (getPname() != null) {
            _hashCode += getPname().hashCode();
        }
        if (getFaultcode() != null) {
            _hashCode += getFaultcode().hashCode();
        }
        if (getFaultstring() != null) {
            _hashCode += getFaultstring().hashCode();
        }
        if (getDataSourceName() != null) {
            _hashCode += getDataSourceName().hashCode();
        }
        if (getLogonFailureCount() != null) {
            _hashCode += getLogonFailureCount().hashCode();
        }
        if (getPersistPrompt() != null) {
            _hashCode += getPersistPrompt().hashCode();
        }
        if (getConnection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getConnection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getConnection(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSignon() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSignon());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSignon(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(DataSourcePromptType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DataSourcePromptType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faultcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "faultcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faultstring");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "faultstring"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataSourceName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "dataSourceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logonFailureCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "logonFailureCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persistPrompt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "persistPrompt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("connection");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "connection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "connectionType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "signon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "signonType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
