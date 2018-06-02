/**
 * DrillDefinitionsDrill.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class DrillDefinitionsDrill  implements java.io.Serializable {
    private java.lang.String drillRef;

    private java.lang.String label;

    private boolean showInNewWindow;

    private boolean sendFilterContext;

    private java.lang.String prompt;

    private java.lang.String outputFormat;

    private java.lang.String method;

    private java.lang.String targetPath;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillParametersParameter[] parameters;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillModelPaths modelPaths;

    private java.lang.String url;

    public DrillDefinitionsDrill() {
    }

    public DrillDefinitionsDrill(
           java.lang.String drillRef,
           java.lang.String label,
           boolean showInNewWindow,
           boolean sendFilterContext,
           java.lang.String prompt,
           java.lang.String outputFormat,
           java.lang.String method,
           java.lang.String targetPath,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillParametersParameter[] parameters,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillModelPaths modelPaths,
           java.lang.String url) {
           this.drillRef = drillRef;
           this.label = label;
           this.showInNewWindow = showInNewWindow;
           this.sendFilterContext = sendFilterContext;
           this.prompt = prompt;
           this.outputFormat = outputFormat;
           this.method = method;
           this.targetPath = targetPath;
           this.parameters = parameters;
           this.modelPaths = modelPaths;
           this.url = url;
    }


    /**
     * Gets the drillRef value for this DrillDefinitionsDrill.
     * 
     * @return drillRef
     */
    public java.lang.String getDrillRef() {
        return drillRef;
    }


    /**
     * Sets the drillRef value for this DrillDefinitionsDrill.
     * 
     * @param drillRef
     */
    public void setDrillRef(java.lang.String drillRef) {
        this.drillRef = drillRef;
    }


    /**
     * Gets the label value for this DrillDefinitionsDrill.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this DrillDefinitionsDrill.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the showInNewWindow value for this DrillDefinitionsDrill.
     * 
     * @return showInNewWindow
     */
    public boolean isShowInNewWindow() {
        return showInNewWindow;
    }


    /**
     * Sets the showInNewWindow value for this DrillDefinitionsDrill.
     * 
     * @param showInNewWindow
     */
    public void setShowInNewWindow(boolean showInNewWindow) {
        this.showInNewWindow = showInNewWindow;
    }


    /**
     * Gets the sendFilterContext value for this DrillDefinitionsDrill.
     * 
     * @return sendFilterContext
     */
    public boolean isSendFilterContext() {
        return sendFilterContext;
    }


    /**
     * Sets the sendFilterContext value for this DrillDefinitionsDrill.
     * 
     * @param sendFilterContext
     */
    public void setSendFilterContext(boolean sendFilterContext) {
        this.sendFilterContext = sendFilterContext;
    }


    /**
     * Gets the prompt value for this DrillDefinitionsDrill.
     * 
     * @return prompt
     */
    public java.lang.String getPrompt() {
        return prompt;
    }


    /**
     * Sets the prompt value for this DrillDefinitionsDrill.
     * 
     * @param prompt
     */
    public void setPrompt(java.lang.String prompt) {
        this.prompt = prompt;
    }


    /**
     * Gets the outputFormat value for this DrillDefinitionsDrill.
     * 
     * @return outputFormat
     */
    public java.lang.String getOutputFormat() {
        return outputFormat;
    }


    /**
     * Sets the outputFormat value for this DrillDefinitionsDrill.
     * 
     * @param outputFormat
     */
    public void setOutputFormat(java.lang.String outputFormat) {
        this.outputFormat = outputFormat;
    }


    /**
     * Gets the method value for this DrillDefinitionsDrill.
     * 
     * @return method
     */
    public java.lang.String getMethod() {
        return method;
    }


    /**
     * Sets the method value for this DrillDefinitionsDrill.
     * 
     * @param method
     */
    public void setMethod(java.lang.String method) {
        this.method = method;
    }


    /**
     * Gets the targetPath value for this DrillDefinitionsDrill.
     * 
     * @return targetPath
     */
    public java.lang.String getTargetPath() {
        return targetPath;
    }


    /**
     * Sets the targetPath value for this DrillDefinitionsDrill.
     * 
     * @param targetPath
     */
    public void setTargetPath(java.lang.String targetPath) {
        this.targetPath = targetPath;
    }


    /**
     * Gets the parameters value for this DrillDefinitionsDrill.
     * 
     * @return parameters
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillParametersParameter[] getParameters() {
        return parameters;
    }


    /**
     * Sets the parameters value for this DrillDefinitionsDrill.
     * 
     * @param parameters
     */
    public void setParameters(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillParametersParameter[] parameters) {
        this.parameters = parameters;
    }


    /**
     * Gets the modelPaths value for this DrillDefinitionsDrill.
     * 
     * @return modelPaths
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillModelPaths getModelPaths() {
        return modelPaths;
    }


    /**
     * Sets the modelPaths value for this DrillDefinitionsDrill.
     * 
     * @param modelPaths
     */
    public void setModelPaths(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillModelPaths modelPaths) {
        this.modelPaths = modelPaths;
    }


    /**
     * Gets the url value for this DrillDefinitionsDrill.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this DrillDefinitionsDrill.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DrillDefinitionsDrill)) return false;
        DrillDefinitionsDrill other = (DrillDefinitionsDrill) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.drillRef==null && other.getDrillRef()==null) || 
             (this.drillRef!=null &&
              this.drillRef.equals(other.getDrillRef()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            this.showInNewWindow == other.isShowInNewWindow() &&
            this.sendFilterContext == other.isSendFilterContext() &&
            ((this.prompt==null && other.getPrompt()==null) || 
             (this.prompt!=null &&
              this.prompt.equals(other.getPrompt()))) &&
            ((this.outputFormat==null && other.getOutputFormat()==null) || 
             (this.outputFormat!=null &&
              this.outputFormat.equals(other.getOutputFormat()))) &&
            ((this.method==null && other.getMethod()==null) || 
             (this.method!=null &&
              this.method.equals(other.getMethod()))) &&
            ((this.targetPath==null && other.getTargetPath()==null) || 
             (this.targetPath!=null &&
              this.targetPath.equals(other.getTargetPath()))) &&
            ((this.parameters==null && other.getParameters()==null) || 
             (this.parameters!=null &&
              java.util.Arrays.equals(this.parameters, other.getParameters()))) &&
            ((this.modelPaths==null && other.getModelPaths()==null) || 
             (this.modelPaths!=null &&
              this.modelPaths.equals(other.getModelPaths()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        if (getDrillRef() != null) {
            _hashCode += getDrillRef().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        _hashCode += (isShowInNewWindow() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSendFilterContext() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPrompt() != null) {
            _hashCode += getPrompt().hashCode();
        }
        if (getOutputFormat() != null) {
            _hashCode += getOutputFormat().hashCode();
        }
        if (getMethod() != null) {
            _hashCode += getMethod().hashCode();
        }
        if (getTargetPath() != null) {
            _hashCode += getTargetPath().hashCode();
        }
        if (getParameters() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParameters());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParameters(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getModelPaths() != null) {
            _hashCode += getModelPaths().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DrillDefinitionsDrill.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">DrillDefinitions>drill"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("drillRef");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drillRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showInNewWindow");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "showInNewWindow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendFilterContext");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "sendFilterContext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prompt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "prompt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "outputFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("method");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "method"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "targetPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameters");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "parameters"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>>DrillDefinitions>drill>parameters>parameter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "parameter"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modelPaths");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "modelPaths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>DrillDefinitions>drill>modelPaths"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
