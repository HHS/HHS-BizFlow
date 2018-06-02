/**
 * AccountInfoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.ccs.auth.types._1;

@SuppressWarnings("serial")
public class AccountInfoType  implements java.io.Serializable {
    private java.lang.String accountID;

    private java.lang.String displayName;

    private java.lang.Object[] extension;

    public AccountInfoType() {
    }

    public AccountInfoType(
           java.lang.String accountID,
           java.lang.String displayName,
           java.lang.Object[] extension) {
           this.accountID = accountID;
           this.displayName = displayName;
           this.extension = extension;
    }


    /**
     * Gets the accountID value for this AccountInfoType.
     * 
     * @return accountID
     */
    public java.lang.String getAccountID() {
        return accountID;
    }


    /**
     * Sets the accountID value for this AccountInfoType.
     * 
     * @param accountID
     */
    public void setAccountID(java.lang.String accountID) {
        this.accountID = accountID;
    }


    /**
     * Gets the displayName value for this AccountInfoType.
     * 
     * @return displayName
     */
    public java.lang.String getDisplayName() {
        return displayName;
    }


    /**
     * Sets the displayName value for this AccountInfoType.
     * 
     * @param displayName
     */
    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }


    /**
     * Gets the extension value for this AccountInfoType.
     * 
     * @return extension
     */
    public java.lang.Object[] getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this AccountInfoType.
     * 
     * @param extension
     */
    public void setExtension(java.lang.Object[] extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	@SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountInfoType)) return false;
        AccountInfoType other = (AccountInfoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountID==null && other.getAccountID()==null) || 
             (this.accountID!=null &&
              this.accountID.equals(other.getAccountID()))) &&
            ((this.displayName==null && other.getDisplayName()==null) || 
             (this.displayName!=null &&
              this.displayName.equals(other.getDisplayName()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              java.util.Arrays.equals(this.extension, other.getExtension())));
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
        if (getAccountID() != null) {
            _hashCode += getAccountID().hashCode();
        }
        if (getDisplayName() != null) {
            _hashCode += getDisplayName().hashCode();
        }
        if (getExtension() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExtension());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExtension(), i);
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
        new org.apache.axis.description.TypeDesc(AccountInfoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "accountInfoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "accountID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("displayName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "displayName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "__ExtensionType"));
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
           @SuppressWarnings("rawtypes") java.lang.Class _javaType,  
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
           @SuppressWarnings("rawtypes") java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
