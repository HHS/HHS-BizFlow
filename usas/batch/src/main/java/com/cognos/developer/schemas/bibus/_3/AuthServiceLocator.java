/**
 * AuthServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.bibus._3;

import java.rmi.Remote;

public class AuthServiceLocator extends org.apache.axis.client.Service implements com.cognos.developer.schemas.bibus._3.AuthService {

    public AuthServiceLocator() {
    }


    public AuthServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuthServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AuthServicePort
    private java.lang.String AuthServicePort_address = "http://localhost:80/ibmcognos/cgi-bin/cognos.cgi";

    @Override
	public java.lang.String getAuthServicePortAddress() {
        return AuthServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AuthServicePortWSDDServiceName = "AuthServicePort";

    public java.lang.String getAuthServicePortWSDDServiceName() {
        return AuthServicePortWSDDServiceName;
    }

    public void setAuthServicePortWSDDServiceName(java.lang.String name) {
        AuthServicePortWSDDServiceName = name;
    }

    @Override
	public AuthService getAuthServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AuthServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return (AuthService) getAuthServicePort(endpoint);
    }

    @Override
	public AuthService getAuthServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cognos.developer.schemas.bibus._3.AuthServiceBindingStub _stub = new com.cognos.developer.schemas.bibus._3.AuthServiceBindingStub(portAddress, this);
            _stub.setPortName(getAuthServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAuthServicePortEndpointAddress(java.lang.String address) {
        AuthServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cognos.developer.schemas.bibus._3.AuthServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cognos.developer.schemas.bibus._3.AuthServiceBindingStub _stub = new com.cognos.developer.schemas.bibus._3.AuthServiceBindingStub(new java.net.URL(AuthServicePort_address), this);
                _stub.setPortName(getAuthServicePortWSDDServiceName());
                return (Remote) _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AuthServicePort".equals(inputPortName)) {
            return (Remote) getAuthServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
	public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://developer.cognos.com/schemas/bibus/3/", "AuthService");
    }

    private java.util.HashSet ports = null;

    @Override
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/bibus/3/", "AuthServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AuthServicePort".equals(portName)) {
            setAuthServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
