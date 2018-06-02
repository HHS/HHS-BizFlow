/**
 * ReportDataServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.bibus._3;

public interface ReportDataServicePort extends java.rmi.Remote {
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getOutput(com.cognos.developer.schemas.rds.types._2.GetOutputRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse drill(com.cognos.developer.schemas.rds.types._2.DrillRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.ReleaseResponse release(com.cognos.developer.schemas.rds.types._2.ReleaseRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetCognosURLResponse getCognosURL(com.cognos.developer.schemas.rds.types._2.GetCognosURLRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetPromptPageResponse getPromptPage(com.cognos.developer.schemas.rds.types._2.GetPromptPageRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetPromptAnswersResponse getPromptAnswers(com.cognos.developer.schemas.rds.types._2.GetPromptAnswersRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeResponse getTreePromptNode(com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getReportPrompts(com.cognos.developer.schemas.rds.types._2.GetReportPromptsRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getPagedReportData(com.cognos.developer.schemas.rds.types._2.GetPagedReportDataRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse forward(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse back(com.cognos.developer.schemas.rds.types._2.BackRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse reprompt(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse finish(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse next(com.cognos.developer.schemas.rds.types._2.NextRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse previous(com.cognos.developer.schemas.rds.types._2.PreviousRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse last(com.cognos.developer.schemas.rds.types._2.LastRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getReportData(com.cognos.developer.schemas.rds.types._2.GetReportDataRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;

    /**
     * DEPRECATED
     */
    public com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionResponse getPromptDescription(com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputResponse first(com.cognos.developer.schemas.rds.types._2.FirstRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputFormatResponse getOutputFormat(com.cognos.developer.schemas.rds.types._2.GetOutputFormatRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
    public com.cognos.developer.schemas.rds.types._2.GetOutputFormatsResponse getOutputFormats(com.cognos.developer.schemas.rds.types._2.GetOutputFormatsRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault;
}
