/**
 * Returns__by__Order__Method___x002D__Prompted__Chart_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;

public class Returns__by__Order__Method___x002D__Prompted__Chart_ServiceLocator extends org.apache.axis.client.Service implements com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart_Service {

    public Returns__by__Order__Method___x002D__Prompted__Chart_ServiceLocator() {
    }


    public Returns__by__Order__Method___x002D__Prompted__Chart_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Returns__by__Order__Method___x002D__Prompted__Chart_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Returns__by__Order__Method___x002d__Prompted__Chart_Service
    private java.lang.String Returns__by__Order__Method___x002d__Prompted__Chart_Service_address = "http://localhost:80/ibmcognos/cgi-bin/cognos.cgi/rds//*%255B%2540name%253D%2527Public%2520Folders%2527%255D/*%255B%2540name%253D%2527Samples%2527%255D/*%255B%2540name%253D%2527Models%2527%255D/*%255B%2540name%253D%2527GO%2520Data%2520Warehouse%2520%2528analysis%2529%2527%255D/*%255B%2540name%253D%2527Report%2520Studio%2520Report%2520Samples%2527%255D/*%255B%2540name%253D%2527Returns%2520by%2520Order%2520Method%2520-%2520Prompted%2520Chart%2527%255D";

    @Override
	public java.lang.String getReturns__by__Order__Method___x002d__Prompted__Chart_ServiceAddress() {
        return Returns__by__Order__Method___x002d__Prompted__Chart_Service_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Returns__by__Order__Method___x002d__Prompted__Chart_ServiceWSDDServiceName = "Returns__by__Order__Method___x002d__Prompted__Chart_Service";

    public java.lang.String getReturns__by__Order__Method___x002d__Prompted__Chart_ServiceWSDDServiceName() {
        return Returns__by__Order__Method___x002d__Prompted__Chart_ServiceWSDDServiceName;
    }

    public void setReturns__by__Order__Method___x002d__Prompted__Chart_ServiceWSDDServiceName(java.lang.String name) {
        Returns__by__Order__Method___x002d__Prompted__Chart_ServiceWSDDServiceName = name;
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart getReturns__by__Order__Method___x002d__Prompted__Chart_Service() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Returns__by__Order__Method___x002d__Prompted__Chart_Service_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReturns__by__Order__Method___x002d__Prompted__Chart_Service(endpoint);
    }

    @Override
	public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart getReturns__by__Order__Method___x002d__Prompted__Chart_Service(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosReportServiceBindingStub _stub = new com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosReportServiceBindingStub(portAddress, this);
            _stub.setPortName(getReturns__by__Order__Method___x002d__Prompted__Chart_ServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReturns__by__Order__Method___x002d__Prompted__Chart_ServiceEndpointAddress(java.lang.String address) {
        Returns__by__Order__Method___x002d__Prompted__Chart_Service_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Returns__by__Order__Method___x002D__Prompted__Chart.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosReportServiceBindingStub _stub = new com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CognosReportServiceBindingStub(new java.net.URL(Returns__by__Order__Method___x002d__Prompted__Chart_Service_address), this);
                _stub.setPortName(getReturns__by__Order__Method___x002d__Prompted__Chart_ServiceWSDDServiceName());
                return _stub;
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
        if ("Returns__by__Order__Method___x002d__Prompted__Chart_Service".equals(inputPortName)) {
            return getReturns__by__Order__Method___x002d__Prompted__Chart_Service();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
	public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Returns__by__Order__Method___x002d__Prompted__Chart_Service");
    }

    private java.util.HashSet ports = null;

    @Override
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Returns__by__Order__Method___x002d__Prompted__Chart_Service"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Returns__by__Order__Method___x002d__Prompted__Chart_Service".equals(portName)) {
            setReturns__by__Order__Method___x002d__Prompted__Chart_ServiceEndpointAddress(address);
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
