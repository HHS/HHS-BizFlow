/**
 * AuthServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.bibus._3;

public interface AuthServicePort extends java.rmi.Remote {
    public com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType logon(com.cognos.developer.schemas.ccs.auth.types._1.LogonRequestType parameter) throws java.rmi.RemoteException;
    public com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType logoff(com.cognos.developer.schemas.ccs.auth.types._1.LogoffRequestType parameter) throws java.rmi.RemoteException;
}
