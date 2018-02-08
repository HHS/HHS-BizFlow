/**
 * ReportDataServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.bibus._3;

public class ReportDataServiceBindingStub extends org.apache.axis.client.Stub implements com.cognos.developer.schemas.bibus._3.ReportDataServicePort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[21];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPagedReportData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetPagedReportDataRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPagedReportDataRequest"), com.cognos.developer.schemas.rds.types._2.GetPagedReportDataRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOutput");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputRequest"), com.cognos.developer.schemas.rds.types._2.GetOutputRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drill");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "DrillRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">DrillRequest"), com.cognos.developer.schemas.rds.types._2.DrillRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("release");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "ReleaseRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">ReleaseRequest"), com.cognos.developer.schemas.rds.types._2.ReleaseRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">ReleaseResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.ReleaseResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "ReleaseResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPromptPage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetPromptPageRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptPageRequest"), com.cognos.developer.schemas.rds.types._2.GetPromptPageRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptPageResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetPromptPageResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetPromptPageResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPromptAnswers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetPromptAnswersRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptAnswersRequest"), com.cognos.developer.schemas.rds.types._2.GetPromptAnswersRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptAnswersResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetPromptAnswersResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetPromptAnswersResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCognosURL");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetCognosURLRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetCognosURLRequest"), com.cognos.developer.schemas.rds.types._2.GetCognosURLRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetCognosURLResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetCognosURLResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetCognosURLResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTreePromptNode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetTreePromptNodeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetTreePromptNodeRequest"), com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetTreePromptNodeResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetTreePromptNodeResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReportPrompts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetReportPromptsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetReportPromptsRequest"), com.cognos.developer.schemas.rds.types._2.GetReportPromptsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("forward");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "ForwardRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "ForwardRequestType"), com.cognos.developer.schemas.rds.types._2.ForwardRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("back");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "BackRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">BackRequest"), com.cognos.developer.schemas.rds.types._2.BackRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("reprompt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "RepromptRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "ForwardRequestType"), com.cognos.developer.schemas.rds.types._2.ForwardRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("finish");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "FinishRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "ForwardRequestType"), com.cognos.developer.schemas.rds.types._2.ForwardRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("next");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "NextRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">NextRequest"), com.cognos.developer.schemas.rds.types._2.NextRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("previous");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PreviousRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">PreviousRequest"), com.cognos.developer.schemas.rds.types._2.PreviousRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("last");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "LastRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">LastRequest"), com.cognos.developer.schemas.rds.types._2.LastRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReportData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetReportDataRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetReportDataRequest"), com.cognos.developer.schemas.rds.types._2.GetReportDataRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPromptDescription");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetPromptDescriptionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptDescriptionRequest"), com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptDescriptionResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetPromptDescriptionResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("first");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "FirstRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">FirstRequest"), com.cognos.developer.schemas.rds.types._2.FirstRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOutputFormat");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputFormatRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatRequest"), com.cognos.developer.schemas.rds.types._2.GetOutputFormatRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputFormatResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputFormatResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOutputFormats");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputFormatsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatsRequest"), com.cognos.developer.schemas.rds.types._2.GetOutputFormatsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatsResponse"));
        oper.setReturnClass(com.cognos.developer.schemas.rds.types._2.GetOutputFormatsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "GetOutputFormatsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSPromptFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSPromptFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.rds.types._2.CCSGeneralFault",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault"), 
                      true
                     ));
        _operations[20] = oper;

    }

    public ReportDataServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ReportDataServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ReportDataServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/bibus/3/", "biBusHeader");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.bibus._3.BiBusHeader.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">BackRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.BackRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSAuthenticationFault");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSGeneralFault");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.CCSGeneralFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">CCSPromptFault");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.CCSPromptFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">DrillRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.DrillRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">FirstRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.FirstRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetCognosURLRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetCognosURLRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetCognosURLResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetCognosURLResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetOutputFormatRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetOutputFormatResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatsRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetOutputFormatsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputFormatsResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetOutputFormatsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetOutputRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetOutputResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPagedReportDataRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetPagedReportDataRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptAnswersRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetPromptAnswersRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptAnswersResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetPromptAnswersResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptDescriptionRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptDescriptionResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptPageRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetPromptPageRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetPromptPageResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetPromptPageResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetReportDataRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetReportDataRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetReportPromptsRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetReportPromptsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetTreePromptNodeRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">GetTreePromptNodeResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">LastRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.LastRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">NextRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.NextRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">PreviousRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PreviousRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">promptAnswers");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PromptAnswers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">PTreePromptType>selectionsAncestry");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.POptions[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "options");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">ReleaseRequest");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.ReleaseRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">ReleaseResponse");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.ReleaseResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">selections");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.POptions[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "options");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">SessionType>status");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.SessionTypeStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", ">supportedFormats");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.SupportedFormats.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "apiVersion");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.ApiVersion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "BurstType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.BurstType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "CalendarType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.CalendarType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "connectionType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.ConnectionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "DateTimeValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.DateTimeValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "DirectionEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.DirectionEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "DTValueType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.DTValueType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "Filter");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.Filter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "ForwardRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.ForwardRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "LDXOutputType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.LDXOutputType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "OutputType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.OutputType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PDataSourceType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PDataSourceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PDateTimeBox");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PDateTimeBox.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PItem");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PItemArray");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PItemArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PListBox");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PListBox.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "POptions");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.POptions.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PromptAnswerOutputType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PromptAnswerOutputType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PromptValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PromptValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PSearchAndSelectType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PSearchAndSelectType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PTextBox");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PTextBox.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PTreePromptType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PTreePromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PValueArray");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PValueArrayItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PValueArrayItem");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "PValueArrayItem");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.PValueArrayItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "RangePValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.RangePValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchPValueType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.SearchPValueType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "searchValueType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.SearchValueType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SessionType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.SessionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "signonType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.SignonType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SimplePValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.SimplePValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "SourceTypeEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.SourceTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "TreePromptNodeType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.TreePromptNodeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "versionSelection");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.VersionSelection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/types/2", "VersionTypeEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.rds.types._2.VersionTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>>DrillDefinitions>drill>parameters>parameter");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillParametersParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>>drills>drill>parm");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrillParm.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>drillAction>direction");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>DrillDefinitions>drill>modelPaths");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillModelPaths.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>DrillDefinitions>drill>parameters");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrillParametersParameter[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>>DrillDefinitions>drill>parameters>parameter");
            qName2 = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "parameter");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>drills>drill");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>secondaryOperations>value");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">bgImagePropertiesType>attachment");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">bgImagePropertiesType>repeat");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">cgsDataInfo");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsDataInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">cgsPropCanvas");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsPropCanvas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">cgsProperties");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsProperties.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">Chart>regions");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartArea[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ChartArea");
            qName2 = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "area");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">ChartArea>coord");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaCoord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">ChartArea>measure");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMeasure.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">ChartArea>member");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartAreaMember.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">clndr");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">CrossTab>table");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Row");
            qName2 = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "row");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">dateUI");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">drillAction");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillAction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">DrillDefinitions>drill");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">drills");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillsDrill[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">>drills>drill");
            qName2 = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drill");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">extension");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">footer");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Row");
            qName2 = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "row");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">header");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Row");
            qName2 = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "row");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">PromptButtonType>bType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">secondaryOperations");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SecondaryOperations.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">SelectTimePromptType>cmode");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">SelectTimePromptType>timeUI");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">SelectValuePromptType>selectUI");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">TextStyle>biDirectional");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextStyleBiDirectional.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">TreePromptType>treeUI");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "bgImagePropertiesType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.BgImagePropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BiDirectionEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.BiDirectionEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BlockExtensionType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.BlockExtensionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Bookmark");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Bookmark.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue");
            cachedSerQNames.add(qName);
            cls = boolean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BorderStyle");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.BorderStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BorderValue");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.BorderValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BoxStyle");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.BoxStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "CalendarType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.CalendarType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Cell");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cgsCanvasDef");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsCanvasDef.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cgsDataDef");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ListFrame[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ListFrame");
            qName2 = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "table");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cgsWidgetDef");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.CgsWidgetDef.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Chart");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Chart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ChartArea");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ChartArea.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "connectionType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ConnectionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "CrossTab");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.CrossTab.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DataSourcePromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DataSourcePromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DateTimeValue");
            cachedSerQNames.add(qName);
            cls = java.util.Calendar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DateValue");
            cachedSerQNames.add(qName);
            cls = java.util.Date.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DecimalValue");
            cachedSerQNames.add(qName);
            cls = double.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DimensionRowOrColumn");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DimensionRowOrColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Div");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Div.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Document");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Document.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DrillDefinitions");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.DrillDefinitionsDrill[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">DrillDefinitions>drill");
            qName2 = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "drill");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterResult");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterResultSet");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterResultSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FilterTypeEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.FilterTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FontStyle");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.FontStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "FontValue");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.FontValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "GroupSection");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.GroupSection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "HAlignEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.HAlignEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "HTML");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.HTML.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "HyperLink");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.HyperLink.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Image");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "IntegerValue");
            cachedSerQNames.add(qName);
            cls = int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "JustificationEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.JustificationEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutBlockType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutBlockType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutCellType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutCellType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutComponentReference");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutComponentReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutTableRowType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableRowType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutTableType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LineStyleEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.LineStyleEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ListFrame");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ListFrame.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LocationReference");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.LocationReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "MarginStyle");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.MarginStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PaddingStyle");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.PaddingStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Page");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Page.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PageGroup");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.PageGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pagesType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.PagesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PromptButtonType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptButtonType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PromptSelectionsType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RangePromptValueType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RangePromptValueType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Repeater");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Repeater.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RepeaterTable");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RepeaterTable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ReportElement");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ReportElementArray");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.ReportElementArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RGBValue");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RGBValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RichText");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichText.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RichTextElmt");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RichTextElmtArray");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichTextElmtArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Row");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Row.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtList");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtTable");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtTableCell");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTableCell.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtTableRow");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtTableRow.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RtxtExtensionType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.RtxtExtensionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SearchAndSelectPromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SearchAndSelectPromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectDatePromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDatePromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectDateTimePromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDateTimePromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectIntervalPromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectIntervalPromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectTimePromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectTimePromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectValuePromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectValuePromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "signonType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SignonType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SimplePromptValueType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SimplePromptValueType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SingletonType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SingletonType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SizeUnitEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeUnitEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SizeValue");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.SizeValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Span");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.Span.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StyleGroup");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.StyleGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TableOfContents");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TableOfContents.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextBoxPromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextBoxPromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextDirectionEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextDirectionEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextFrame");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextStyle");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TFStateEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TFStateEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TFValueTypeEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TFValueTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TimeValue");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.Time.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TocEntry");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TocEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TreePromptNodeType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TreePromptNodeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TreePromptType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.TreePromptType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "VAlignEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.VAlignEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "WidgetType");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.WidgetType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "WordBreakEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.WordBreakEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "WritingModeEnum");
            cachedSerQNames.add(qName);
            cls = com.ibm.www.xmlns.prod.cognos.layoutData._200904.WritingModeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getPagedReportData(com.cognos.developer.schemas.rds.types._2.GetPagedReportDataRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getPagedReportData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getOutput(com.cognos.developer.schemas.rds.types._2.GetOutputRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getOutput"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse drill(com.cognos.developer.schemas.rds.types._2.DrillRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "drill"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.ReleaseResponse release(com.cognos.developer.schemas.rds.types._2.ReleaseRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "release"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.ReleaseResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.ReleaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.ReleaseResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetPromptPageResponse getPromptPage(com.cognos.developer.schemas.rds.types._2.GetPromptPageRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getPromptPage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetPromptPageResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetPromptPageResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetPromptPageResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetPromptAnswersResponse getPromptAnswers(com.cognos.developer.schemas.rds.types._2.GetPromptAnswersRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getPromptAnswers"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetPromptAnswersResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetPromptAnswersResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetPromptAnswersResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetCognosURLResponse getCognosURL(com.cognos.developer.schemas.rds.types._2.GetCognosURLRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getCognosURL"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetCognosURLResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetCognosURLResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetCognosURLResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeResponse getTreePromptNode(com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getTreePromptNode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getReportPrompts(com.cognos.developer.schemas.rds.types._2.GetReportPromptsRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getReportPrompts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse forward(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "forward"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse back(com.cognos.developer.schemas.rds.types._2.BackRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "back"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse reprompt(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "reprompt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse finish(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "finish"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse next(com.cognos.developer.schemas.rds.types._2.NextRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "next"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse previous(com.cognos.developer.schemas.rds.types._2.PreviousRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "previous"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse last(com.cognos.developer.schemas.rds.types._2.LastRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "last"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getReportData(com.cognos.developer.schemas.rds.types._2.GetReportDataRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getReportData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }


    /**
     * DEPRECATED
     */
    @Override
	public com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionResponse getPromptDescription(com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getPromptDescription"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputResponse first(com.cognos.developer.schemas.rds.types._2.FirstRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "first"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputFormatResponse getOutputFormat(com.cognos.developer.schemas.rds.types._2.GetOutputFormatRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getOutputFormat"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputFormatResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputFormatResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputFormatResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.rds.types._2.GetOutputFormatsResponse getOutputFormats(com.cognos.developer.schemas.rds.types._2.GetOutputFormatsRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getOutputFormats"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputFormatsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.rds.types._2.GetOutputFormatsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.rds.types._2.GetOutputFormatsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSPromptFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSPromptFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) {
              throw (com.cognos.developer.schemas.rds.types._2.CCSGeneralFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
