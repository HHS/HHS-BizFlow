/**
 * AuthServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.bibus._3;

import java.net.URL;
import java.rmi.Remote;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.TypeMappingRegistry;
import javax.xml.rpc.handler.HandlerRegistry;

import org.apache.axis.AxisFault;

public class AuthServiceBindingStub extends org.apache.axis.client.Stub implements AuthService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[2];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("logon");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "logonRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "LogonRequestType"), com.cognos.developer.schemas.ccs.auth.types._1.LogonRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "LogonResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "logonResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("logoff");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "logoffRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "LogoffRequestType"), com.cognos.developer.schemas.ccs.auth.types._1.LogoffRequestType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "logoffResponseType"));
        oper.setReturnClass(com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "logoffResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

    }

    public AuthServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AuthServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AuthServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/bibus/3/", "biBusHeader");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.bibus._3.BiBusHeader.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", ">LogonResponseType>result");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseTypeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", ">MissingValueType>valueType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "__ExtensionType");
            cachedSerQNames.add(qName);
            cls = java.lang.Object[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType");
            qName2 = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "accountInfoType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.AccountInfoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "CredentialElementType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.CredentialElementType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "CredentialType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.CredentialType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "enumerationType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.EnumerationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "LogoffRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.LogoffRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "logoffResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "LogonRequestType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.LogonRequestType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "LogonResponseType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "MissingValueType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.MissingValueType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "ResponseCode");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.ResponseCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://developer.cognos.com/schemas/ccs/auth/types/1", "ValueElementType");
            cachedSerQNames.add(qName);
            cls = com.cognos.developer.schemas.ccs.auth.types._1.ValueElementType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    @Override
	public org.apache.axis.client.Call createCall() {
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
            try {
				throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
			} catch (AxisFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return _call;
    }

    public com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType logon(com.cognos.developer.schemas.ccs.auth.types._1.LogonRequestType parameter) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/auth/1");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/auth/1", "logon"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameter});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.ccs.auth.types._1.LogonResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType logoff(com.cognos.developer.schemas.ccs.auth.types._1.LogoffRequestType parameter) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://developer.cognos.com/schemas/rds/auth/1");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/rds/auth/1", "logoff"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameter});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, com.cognos.developer.schemas.ccs.auth.types._1.LogoffResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

	@Override
	public Call createCall(QName arg0) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Call createCall(QName arg0, QName arg1) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Call createCall(QName arg0, String arg1) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Call[] getCalls(QName arg0) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandlerRegistry getHandlerRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Remote getPort(Class arg0) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Remote getPort(QName arg0, Class arg1) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getPorts() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QName getServiceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeMappingRegistry getTypeMappingRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getWSDLDocumentLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthServicePortAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthService getAuthServicePort() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthService getAuthServicePort(URL portAddress)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
