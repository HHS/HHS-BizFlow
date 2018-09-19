package gov.hhs.ehrp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMXMLObject 
{
	
	public static String tagDelimiter = "/"; 
	public static String attributeDelimiter = "@";
	Document doc = null; 
	private Log log;
	/**
	 * 
	 */
	public DOMXMLObject(String xmlString) 
	{
		log = LogFactory.getLog(this.getClass());
		DocumentBuilderFactory dbf = null; 
	   	DocumentBuilder db = null; 
		if(xmlString!=null)
		{
	        try 
			{
				dbf = DocumentBuilderFactory.newInstance(); 
				db = dbf.newDocumentBuilder(); 
				InputStream ins = new ByteArrayInputStream(xmlString.getBytes());
				doc = db.parse(ins);
			}
	        catch (ParserConfigurationException e) 
			{
				e.printStackTrace();
			} 
	        catch (SAXException e) 
			{
				e.printStackTrace();
			} 
	        catch (IOException e) 
			{
				e.printStackTrace();
			} 
		}
	}
	
	public DOMXMLObject(File xmlFile) 
	{
		log = LogFactory.getLog(this.getClass());
		StringBuffer myXMLString = new StringBuffer();
		try 
		{
			InputStream ins = new FileInputStream(xmlFile);
			int readVal = -1;
			while ( (readVal = ins.read())!=-1)
			{
				myXMLString.append((char)readVal);
			}
			ins.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DocumentBuilderFactory dbf = null; 
	   	DocumentBuilder db = null; 
		if(myXMLString!=null)
		{
	        try 
			{
				dbf = DocumentBuilderFactory.newInstance(); 
				db = dbf.newDocumentBuilder(); 
				InputStream ins = new ByteArrayInputStream(myXMLString.toString().getBytes());
				doc = db.parse(ins);
				ins.close();
			}
	        catch (ParserConfigurationException e) 
			{
				e.printStackTrace();
			} 
	        catch (SAXException e) 
			{
				e.printStackTrace();
			} 
	        catch (IOException e) 
			{
				e.printStackTrace();
			} 
		}
		

	}
	
	
	public NodeList getNodeList(Node startNode , String relativeXmlNodePath)
	{
		NodeList nodes = null;
		String[] nodeHierarchy = parseTagHierarchy(relativeXmlNodePath);
		if(nodeHierarchy!=null &&  nodeHierarchy.length>0)
		{
			if(nodeHierarchy.length==1)
				nodes = getAllChilds(startNode,nodeHierarchy[0]);
			else
			{	
				Node parent = startNode;
				
				for (int i=0;i<nodeHierarchy.length-1;i++)
				{
					if(parent!=null)
					{
						Node child = getOnlyChild(parent,nodeHierarchy[i]);
						parent = child;
					}
					
				}
				if (parent!=null)
					nodes = getAllChilds(parent,nodeHierarchy[nodeHierarchy.length-1]);
			}
		}
		return nodes;
	}
	
	
	public NodeList getNodeList(String xmlNodePath)
	{
		NodeList nodes = null;
		String[] nodeHierarchy = parseTagHierarchy(xmlNodePath);
		
		if(nodeHierarchy!=null &&  nodeHierarchy.length>0)
		{
			if(nodeHierarchy.length==1)
				nodes = getAllChilds(doc,nodeHierarchy[0]);
			else
			{	
				Node parent = getOnlyChild(doc,nodeHierarchy[0]); 
				for (int i=1;i<nodeHierarchy.length-1;i++)
				{
					log.debug("Node Hierarchy = "+nodeHierarchy[i]);
					if(parent!=null)
					{
						Node child = getOnlyChild(parent,nodeHierarchy[i]);
						parent = child;
					}
					
				}
				if (parent!=null)
				{
					nodes = getAllChilds(parent,nodeHierarchy[nodeHierarchy.length-1]);
					log.debug("Node Hierarchy = "+nodeHierarchy[nodeHierarchy.length-1]);
				}
			}
		}
		return nodes;
	}
	
	
	public Node getOnlyNode(String xmlNodePath)
	{
		Node node = null;
		String[] nodeHierarchy = parseTagHierarchy(xmlNodePath);
		if(nodeHierarchy!=null &&  nodeHierarchy.length>0)
		{
				Node parent = getOnlyChild(doc,nodeHierarchy[0]);
				for (int i=1;i<nodeHierarchy.length;i++)
				{
					if(parent!=null)
					{
						Node child = getOnlyChild(parent,nodeHierarchy[i]);
						parent = child;
					}
					
				}
				node= parent;
				
		}
		return node;
	}
	
	
	public Node getOnlyNode(Node startNode , String relativeXmlNodePath)
	{
		Node node = null;
		String[] nodeHierarchy = parseTagHierarchy(relativeXmlNodePath);
		if(startNode!=null && nodeHierarchy!=null &&  nodeHierarchy.length>0)
		{
				Node parent = startNode;
				for (int i=0;i<nodeHierarchy.length;i++)
				{
					if(parent!=null)
					{
						Node child = getOnlyChild(parent,nodeHierarchy[i]);
						parent = child;
					}
					
				}
				node= parent;
		}
		return node;
	}
	
	
	public String getAttributeValue(String xmlNodePath)
	{
		String attrValue = "";
		if(xmlNodePath!=null)
		{
			String[] splitValue = xmlNodePath.split(attributeDelimiter);
			if(splitValue!=null && splitValue.length>1)
			{
				String[] nodeHierarchy = parseTagHierarchy(splitValue[0]);
				if(nodeHierarchy!=null &&  nodeHierarchy.length>0)
				{
					Node parent = getOnlyChild(doc,nodeHierarchy[0]);
					for (int i=1;i<nodeHierarchy.length;i++)
					{
						if(parent!=null)
						{
							Node child = getOnlyChild(parent,nodeHierarchy[i]);
							parent = child;
							
						}
						
					}
					if(parent != null)
							attrValue = getAttributeValue(parent,splitValue[1]);
				}
			}
		}
		return attrValue;
	}
	
	public String getAttributeValueRelative(Node startNode , String relativeXmlNodePath)
	{
		String attrValue = "";
		if(relativeXmlNodePath!=null && startNode!=null)
		{
			String[] splitValue = relativeXmlNodePath.split(attributeDelimiter);
			if(splitValue!=null && splitValue.length>1)
			{
				String[] nodeHierarchy = parseTagHierarchy(splitValue[0]);
				if(nodeHierarchy!=null &&  nodeHierarchy.length>0)
				{
					Node parent = startNode;
					for (int i=0;i<nodeHierarchy.length;i++)
					{
						if(parent!=null)
						{
							Node child = getOnlyChild(parent,nodeHierarchy[i]);
							parent = child;
						}
						
					}
					if(parent != null)
							attrValue = getAttributeValue(parent,splitValue[1]);
				}
			}
		}
		return attrValue;
	}
	
	
	public String getAttributeValue(Node node , String attributeName)
	{
		String attrValue = "";
		if (node!=null && node.hasAttributes() && attributeName!=null)
		{
			NamedNodeMap map =  node.getAttributes();
			Node attribute = map.getNamedItem(attributeName);
			if(attribute!=null)
			{
				attrValue = attribute.getNodeValue();
				log.debug(attribute.getNodeValue());
			}
		}
		return attrValue;
	}
	
	
			
	public Node getRootNode()
	{
		Node rootNode = null;
		if (doc!=null)
		{
			rootNode = doc.getFirstChild();
		}
		if (rootNode!=null)
			log.debug(rootNode.getNodeName());
		return rootNode;
	}
	
	
	public String getNodeContent(Node node)
	{
		String text ="";
		if (node!=null)
		{
			try {
				if(node.getFirstChild()!=null)
					text = node.getFirstChild().getNodeValue();
			} 
			catch (DOMException e) {
				e.printStackTrace();
			}
		}
		log.debug(text);
		return text;
	}
	
	
	public NodeList getAllChilds(Node parentNode , String childNodeName)
	{
		NodeList childNodes = null;
		if(parentNode!=null)
		{
			childNodes =  parentNode.getChildNodes();
			//log.debug("childNodes Length *****= "+childNodes.getLength());
			Node clonedParentNode = parentNode.cloneNode(true);
			Node clonedParentNode2 = parentNode.cloneNode(true);
			NodeList clonedChildNodes = clonedParentNode2.getChildNodes();
			childNodes = clonedChildNodes;
			// remove all the childs from the parent node
			while(clonedParentNode.getChildNodes().getLength()>0)
				clonedParentNode.removeChild(clonedParentNode.getChildNodes().item(0));
			
			if (childNodes!=null && childNodes.getLength()>0 && childNodeName!=null)
			{
				for(int i=childNodes.getLength()-1;i>=0;i--)
				{
					if (childNodes.item(i).getNodeName().equalsIgnoreCase(childNodeName))
					{
						clonedParentNode.appendChild(childNodes.item(i));
						//log.debug("added node*= "+i);
					}
				}
				childNodes = clonedParentNode.getChildNodes();
			}
		}
		if(childNodes!=null)
			log.debug(""+childNodes.getLength());
		return childNodes;
	}
	

	
	public Node getOnlyChild(Node parentNode , String childNodeName)
	{
		Node childNode = null;
		if(parentNode!=null)
		{
			NodeList nodes =  parentNode.getChildNodes();
			if (nodes!=null && nodes.getLength()>0)
			{
				for(int i=0;i<nodes.getLength();i++)
				{
					if (nodes.item(i).getNodeName().equalsIgnoreCase(childNodeName))
					{
						childNode = nodes.item(i);
						break;
					}
				}
			}
		}
		if(childNode!=null)
			log.debug(childNode.getNodeName());
		return childNode;
	}
	
	
	private String[] parseTagHierarchy(String xmlNodePath)
	{
		StringTokenizer tokenizer = new StringTokenizer(xmlNodePath,tagDelimiter);
		int countToken = tokenizer.countTokens();
		String[] tagHierarchy = null;
		if(countToken>0)
		{
			tagHierarchy = new String[countToken];
			int count = 0;
			while(tokenizer.hasMoreTokens())
			{
				tagHierarchy[count] = tokenizer.nextToken();
				count++;
			}
		}
		return tagHierarchy;
	}

}
