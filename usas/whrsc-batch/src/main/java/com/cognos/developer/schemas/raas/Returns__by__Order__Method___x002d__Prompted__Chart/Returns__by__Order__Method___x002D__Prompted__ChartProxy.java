package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Returns__by__Order__Method___x002D__Prompted__ChartProxy implements com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart {
  private String _endpoint = null;
  private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart returns__by__Order__Method___x002D__Prompted__Chart = null;
  
  public Returns__by__Order__Method___x002D__Prompted__ChartProxy() {
    _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
  }
  
  public Returns__by__Order__Method___x002D__Prompted__ChartProxy(String endpoint) {
    _endpoint = endpoint;
    _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
  }
  
  private void _initReturns__by__Order__Method___x002D__Prompted__ChartProxy() {
    try {
      returns__by__Order__Method___x002D__Prompted__Chart = (new com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart_ServiceLocator()).getReturns__by__Order__Method___x002d__Prompted__Chart_Service();
      if (returns__by__Order__Method___x002D__Prompted__Chart != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)returns__by__Order__Method___x002D__Prompted__Chart)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)returns__by__Order__Method___x002D__Prompted__Chart)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (returns__by__Order__Method___x002D__Prompted__Chart != null)
      ((javax.xml.rpc.Stub)returns__by__Order__Method___x002D__Prompted__Chart)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart getReturns__by__Order__Method___x002D__Prompted__Chart() {
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart;
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportResponseType getReport(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetReportRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getReport(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormattedReport(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getFormattedReport(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType drillFormatted(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.drillFormatted(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageResponseType getPromptPage(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptPageRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getPromptPage(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersResponseType getPromptAnswers(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.PromptAnswersRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getPromptAnswers(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosURLResponseType getCognosURL(java.lang.Object request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getCognosURL(request);
  }
  
  @Override
public java.lang.Object release(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ReleaseRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.release(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType get_FirstPage_x005FReportTitle2121(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.get_FirstPage_x005FReportTitle2121(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_FirstPage_x005FReportTitle2121(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_FirstPage_x005FReportTitle2121RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getFormatted_FirstPage_x005FReportTitle2121(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_FirstPage_x005FReportTitle2121ResponseType drill_FirstPage_x005FReportTitle2121(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.drill_FirstPage_x005FReportTitle2121(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType get_Crosstab1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.get_Crosstab1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_Crosstab1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Crosstab1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getFormatted_Crosstab1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Crosstab1ResponseType drill_Crosstab1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.drill_Crosstab1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType get_Combination__Chart1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.get_Combination__Chart1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_Combination__Chart1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Combination__Chart1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getFormatted_Combination__Chart1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Combination__Chart1ResponseType drill_Combination__Chart1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.drill_Combination__Chart1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType get_RunDate1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.get_RunDate1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_RunDate1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_RunDate1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getFormatted_RunDate1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunDate1ResponseType drill_RunDate1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.drill_RunDate1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType get_PageNumber(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.get_PageNumber(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_PageNumber(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_PageNumberRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getFormatted_PageNumber(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_PageNumberResponseType drill_PageNumber(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.drill_PageNumber(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType get_RunTime1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.get_RunTime1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_RunTime1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_RunTime1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getFormatted_RunTime1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_RunTime1ResponseType drill_RunTime1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.drill_RunTime1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType get_Page1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.get_Page1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormattedReportResponseType getFormatted_Page1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.GetFormatted_Page1RequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.getFormatted_Page1(request);
  }
  
  @Override
public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Get_Page1ResponseType drill_Page1(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.DrillRequestType request) throws java.rmi.RemoteException, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSAuthenticationFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSGeneralFaultType, com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CCSPromptFaultType{
    if (returns__by__Order__Method___x002D__Prompted__Chart == null)
      _initReturns__by__Order__Method___x002D__Prompted__ChartProxy();
    return returns__by__Order__Method___x002D__Prompted__Chart.drill_Page1(request);
  }
  
  
}