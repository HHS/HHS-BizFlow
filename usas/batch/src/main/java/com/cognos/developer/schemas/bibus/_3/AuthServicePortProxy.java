package com.cognos.developer.schemas.bibus._3;

public class AuthServicePortProxy implements com.cognos.developer.schemas.bibus._3.AuthServicePort {
  private String _endpoint = null;
  private com.cognos.developer.schemas.bibus._3.AuthServicePort authServicePort = null;
  
  public AuthServicePortProxy() {
    _initAuthServicePortProxy();
  }
  
  public AuthServicePortProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthServicePortProxy();
  }
  
  private void _initAuthServicePortProxy() {
    try {
      authServicePort = (AuthServicePort) (new com.cognos.developer.schemas.bibus._3.AuthServiceLocator()).getAuthServicePort();
      if (authServicePort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authServicePort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authServicePort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authServicePort != null)
      ((javax.xml.rpc.Stub)authServicePort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cognos.developer.schemas.bibus._3.AuthServicePort getAuthServicePort() {
    if (authServicePort == null)
      _initAuthServicePortProxy();
    return authServicePort;
  }
  
  @Override
public com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType logon(com.cognos.developer.schemas.ccs.auth.types._1.LogonRequestType parameter) throws java.rmi.RemoteException{
    if (authServicePort == null)
      _initAuthServicePortProxy();
    return authServicePort.logon(parameter);
  }
  
  @Override
public com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType logoff(com.cognos.developer.schemas.ccs.auth.types._1.LogoffRequestType parameter) throws java.rmi.RemoteException{
    if (authServicePort == null)
      _initAuthServicePortProxy();
    return authServicePort.logoff(parameter);
  }
  
  
}