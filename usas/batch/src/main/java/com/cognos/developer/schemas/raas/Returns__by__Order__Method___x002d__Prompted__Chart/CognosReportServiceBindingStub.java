/**
 * CognosReportServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class CognosReportServiceBindingStub extends org.apache.axis.client.Stub implements com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[28];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetReportRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetReportRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetReportResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFormattedReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drillFormatted");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillFormattedRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillFormattedResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPromptPage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptPageRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptPageRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptPageResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptPageResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPromptAnswers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCognosURL");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetCognosURLRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"), java.lang.Object.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CognosURLResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosURLResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetCognosURLResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("release");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReleaseRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReleaseRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ReleaseRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        oper.setReturnClass(java.lang.Object.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReleaseResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_FirstPage_x005fReportTitle2121");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_FirstPage_x005fReportTitle2121Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_FirstPage_x005fReportTitle2121RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_FirstPage_x005fReportTitle2121ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_FirstPage_x005fReportTitle2121Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFormatted_FirstPage_x005fReportTitle2121");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_FirstPage_x005fReportTitle2121Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_FirstPage_x005fReportTitle2121RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_FirstPage_x005FReportTitle2121RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_FirstPage_x005fReportTitle2121Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drill_FirstPage_x005fReportTitle2121");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_FirstPage_x005fReportTitle2121Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_FirstPage_x005fReportTitle2121ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_FirstPage_x005fReportTitle2121Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_Crosstab1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Crosstab1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Crosstab1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Crosstab1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Crosstab1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFormatted_Crosstab1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Crosstab1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Crosstab1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Crosstab1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Crosstab1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drill_Crosstab1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_Crosstab1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Crosstab1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_Crosstab1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_Combination__Chart1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFormatted_Combination__Chart1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Combination__Chart1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Combination__Chart1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Combination__Chart1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Combination__Chart1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drill_Combination__Chart1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_Combination__Chart1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_Combination__Chart1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_RunDate1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFormatted_RunDate1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_RunDate1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_RunDate1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_RunDate1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_RunDate1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drill_RunDate1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_RunDate1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_RunDate1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_PageNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_PageNumberRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_PageNumberRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_PageNumberResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_PageNumberResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFormatted_PageNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_PageNumberRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_PageNumberRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_PageNumberRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_PageNumberResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drill_PageNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_PageNumberRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_PageNumberResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_PageNumberResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_RunTime1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunTime1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunTime1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunTime1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunTime1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFormatted_RunTime1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_RunTime1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_RunTime1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_RunTime1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_RunTime1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drill_RunTime1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_RunTime1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunTime1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_RunTime1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("get_Page1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Page1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Page1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Page1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Page1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFormatted_Page1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Page1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Page1RequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Page1RequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Page1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("drill_Page1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_Page1Request"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType"), com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Page1ResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Drill_Page1Response"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFault"),
                      "com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType",
                      new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType"), 
                      true
                     ));
        _operations[27] = oper;

    }

    public CognosReportServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CognosReportServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CognosReportServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">>>drills>drill>parm");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrillParm.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">>CrossTab>table>row");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CrossTabTableRow.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">>drills>drill");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">Cell>extension");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CellExtension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">cgsDataInfo");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsDataInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">cgsPropCanvas");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsPropCanvas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">cgsProperties");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsProperties.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">Chart>regions");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartArea[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ChartArea");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "area");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">ChartArea>coord");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaCoord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">ChartArea>measure");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMeasure.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">ChartArea>member");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartAreaMember.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">Crosstab1_CrossTabType>table");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Row");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "row");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">CrossTab>table");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CrossTabTable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">DimensionRowOrColumn>extension");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumnExtension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">drills");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillsDrill[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">>drills>drill");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "drill");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">extension");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">GroupSection>footer");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Row");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "row");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">GroupSection>header");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Row");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "row");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">Image>extension");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ImageExtension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">StyleGroup>extension");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroupExtension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">TextStyle>biDirectional");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextStyleBiDirectional.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "BiDirectionEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.BiDirectionEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Bookmark");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Bookmark.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "BooleanValue");
            cachedSerQNames.add(qName);
            cls = boolean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "BorderStyle");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.BorderStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "BorderValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.BorderValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "BoxStyle");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.BoxStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSAuthenticationFaultType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSGeneralFaultType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CCSPromptFaultType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Cell");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cgsCanvasDef");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsCanvasDef.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cgsDataDef");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ListFrame");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "table");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cgsWidgetDef");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CgsWidgetDef.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Chart");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ChartArea");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ChartArea.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CognosURLResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosURLResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CrossTab");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CrossTab.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_CrossTabType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_CrossTabType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_Product__line_DimensionType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Product__line_DimensionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_Return__reason_DimensionType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Return__reason_DimensionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Crosstab1_Year_DimensionType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Crosstab1_Year_DimensionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DecimalValue");
            cachedSerQNames.add(qName);
            cls = double.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DimensionRowOrColumn");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DimensionRowOrColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DirectionEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DirectionEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Div");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Div.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "DrillRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "FontStyle");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.FontStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "FontValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.FontValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1ResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Combination__Chart1ResultsType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResultsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Crosstab1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Crosstab1ResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Crosstab1ResultsType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResultsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_FirstPage_x005fReportTitle2121RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_FirstPage_x005fReportTitle2121ResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_FirstPage_x005fReportTitle2121ResultsType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResultsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Page1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Page1ResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_Page1ResultsType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResultsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_PageNumberRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_PageNumberResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_PageNumberResultsType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResultsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1ResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunDate1ResultsType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResultsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunTime1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunTime1ResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Get_RunTime1ResultsType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResultsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Combination__Chart1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Combination__Chart1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Crosstab1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Crosstab1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_FirstPage_x005fReportTitle2121RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_FirstPage_x005FReportTitle2121RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_Page1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Page1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_PageNumberRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_PageNumberRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_RunDate1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_RunDate1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormatted_RunTime1RequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_RunTime1RequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetFormattedReportResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetReportRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GetReportResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "GroupSection");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GroupSection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "HAlignEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HAlignEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "HTML");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HTML.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "HyperLink");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HyperLink.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Image");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Image.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "IntegerValue");
            cachedSerQNames.add(qName);
            cls = int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "JustificationEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.JustificationEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "LayoutComponentReference");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.LayoutComponentReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "LineStyleEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.LineStyleEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ListFrame");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "MarginStyle");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.MarginStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PaddingStyle");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PaddingStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_BodyType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_BodyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_FooterType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_FooterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_HeaderType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_HeaderType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Page1_PageType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Page1_PageType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

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
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptAnswersType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptPageRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptPageResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PromptValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PValueArray");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PValueArrayItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PValueArrayItem");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "PValueArrayItem");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PValueArrayItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RangePValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RangePValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReleaseRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ReleaseRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Repeater");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Repeater.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RepeaterTable");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RepeaterTable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReportElement");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ReportElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReportElementArray");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ReportElement[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReportElement");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReportType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ReportType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RGBValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RGBValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RichText");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RichText.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RichTextElmt");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RichTextElmt.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RichTextElmtArray");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RichTextElmtArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Row");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Row.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RtList");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RtList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SessionType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SessionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SimplePValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SimplePValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SizeUnitEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeUnitEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "SizeValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.SizeValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Span");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Span.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "StatusEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StatusEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "StringValue");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "StyleGroup");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.StyleGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TableOfContents");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TableOfContents.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextDirectionEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextDirectionEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextStyle");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextStyle.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TFStateEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFStateEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TFValueTypeEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TFValueTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TocEntry");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TocEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TreePValue");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TreePValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "VAlignEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VAlignEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "VersionSelection");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionSelection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "VersionTypeEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.VersionTypeEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "WordBreakEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.WordBreakEnum.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "WritingModeEnum");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.WritingModeEnum.class;
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
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportResponseType getReport(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "getReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormattedReport(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "getFormattedReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType drillFormatted(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "drillFormatted"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageResponseType getPromptPage(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType {
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
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersResponseType getPromptAnswers(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType {
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
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosURLResponseType getCognosURL(java.lang.Object request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType {
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
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosURLResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosURLResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosURLResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public java.lang.Object release(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ReleaseRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType {
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
                return _resp;
            } catch (java.lang.Exception _exception) {
                return org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.Object.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType get_FirstPage_x005FReportTitle2121(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "get_FirstPage_x005fReportTitle2121"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_FirstPage_x005FReportTitle2121(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_FirstPage_x005FReportTitle2121RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "getFormatted_FirstPage_x005fReportTitle2121"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType drill_FirstPage_x005FReportTitle2121(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "drill_FirstPage_x005fReportTitle2121"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType get_Crosstab1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "get_Crosstab1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_Crosstab1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Crosstab1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "getFormatted_Crosstab1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType drill_Crosstab1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "drill_Crosstab1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType get_Combination__Chart1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "get_Combination__Chart1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_Combination__Chart1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Combination__Chart1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "getFormatted_Combination__Chart1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType drill_Combination__Chart1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "drill_Combination__Chart1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType get_RunDate1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "get_RunDate1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_RunDate1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_RunDate1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "getFormatted_RunDate1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType drill_RunDate1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "drill_RunDate1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType get_PageNumber(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "get_PageNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_PageNumber(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_PageNumberRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
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
        _call.setOperationName(new javax.xml.namespace.QName("", "getFormatted_PageNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType drill_PageNumber(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "drill_PageNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType get_RunTime1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "get_RunTime1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_RunTime1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_RunTime1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getFormatted_RunTime1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType drill_RunTime1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "drill_RunTime1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType get_Page1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "get_Page1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_Page1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Page1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getFormatted_Page1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType drill_Page1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "drill_Page1"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {request});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) {
              throw (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
