package com.cognos.developer.schemas.bibus._3;

public class ReportDataServicePortProxy implements com.cognos.developer.schemas.bibus._3.ReportDataServicePort {
  private String _endpoint = null;
  private com.cognos.developer.schemas.bibus._3.ReportDataServicePort reportDataServicePort = null;
  
  public ReportDataServicePortProxy() {
    _initReportDataServicePortProxy();
  }
  
  public ReportDataServicePortProxy(String endpoint) {
    _endpoint = endpoint;
    _initReportDataServicePortProxy();
  }
  
  private void _initReportDataServicePortProxy() {
    try {
      reportDataServicePort = (new com.cognos.developer.schemas.bibus._3.ReportDataServiceLocator()).getReportDataServiceBinding();
      if (reportDataServicePort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reportDataServicePort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reportDataServicePort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reportDataServicePort != null)
      ((javax.xml.rpc.Stub)reportDataServicePort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cognos.developer.schemas.bibus._3.ReportDataServicePort getReportDataServicePort() {
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort;
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getOutput(com.cognos.developer.schemas.rds.types._2.GetOutputRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getOutput(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse drill(com.cognos.developer.schemas.rds.types._2.DrillRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.drill(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.ReleaseResponse release(com.cognos.developer.schemas.rds.types._2.ReleaseRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.release(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetCognosURLResponse getCognosURL(com.cognos.developer.schemas.rds.types._2.GetCognosURLRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getCognosURL(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetPromptPageResponse getPromptPage(com.cognos.developer.schemas.rds.types._2.GetPromptPageRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getPromptPage(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetPromptAnswersResponse getPromptAnswers(com.cognos.developer.schemas.rds.types._2.GetPromptAnswersRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getPromptAnswers(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeResponse getTreePromptNode(com.cognos.developer.schemas.rds.types._2.GetTreePromptNodeRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getTreePromptNode(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getReportPrompts(com.cognos.developer.schemas.rds.types._2.GetReportPromptsRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getReportPrompts(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getPagedReportData(com.cognos.developer.schemas.rds.types._2.GetPagedReportDataRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getPagedReportData(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse forward(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.forward(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse back(com.cognos.developer.schemas.rds.types._2.BackRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.back(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse reprompt(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.reprompt(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse finish(com.cognos.developer.schemas.rds.types._2.ForwardRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.finish(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse next(com.cognos.developer.schemas.rds.types._2.NextRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.next(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse previous(com.cognos.developer.schemas.rds.types._2.PreviousRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.previous(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse last(com.cognos.developer.schemas.rds.types._2.LastRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.last(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse getReportData(com.cognos.developer.schemas.rds.types._2.GetReportDataRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getReportData(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionResponse getPromptDescription(com.cognos.developer.schemas.rds.types._2.GetPromptDescriptionRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getPromptDescription(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputResponse first(com.cognos.developer.schemas.rds.types._2.FirstRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.first(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputFormatResponse getOutputFormat(com.cognos.developer.schemas.rds.types._2.GetOutputFormatRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getOutputFormat(request);
  }
  
  @Override
public com.cognos.developer.schemas.rds.types._2.GetOutputFormatsResponse getOutputFormats(com.cognos.developer.schemas.rds.types._2.GetOutputFormatsRequest request) throws java.rmi.RemoteException, com.cognos.developer.schemas.rds.types._2.CCSAuthenticationFault, com.cognos.developer.schemas.rds.types._2.CCSPromptFault, com.cognos.developer.schemas.rds.types._2.CCSGeneralFault{
    if (reportDataServicePort == null)
      _initReportDataServicePortProxy();
    return reportDataServicePort.getOutputFormats(request);
  }
  
  
}