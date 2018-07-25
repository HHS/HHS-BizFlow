/**
 * ReportElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart;


/**
 * This element is a placeholder for all report elements, that could
 * be returned as a reportLet of the report (including Image, Chart,
 * TextFrame, ListFrame, Crosstab, Page, etc).
 */
public class ReportElement  implements java.io.Serializable {
    /* TextFrane */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame txt;

    /* ListFrame */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame lst;

    /* Cell */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell cell;

    /* CrossTab */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CrossTab ctab;

    /* Chart */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart cht;

    /* Image */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Image img;

    /* HyperLink */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HyperLink hlink;

    /* HTML */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HTML html;

    /* RichText */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RichText rtxt;

    /* Repeater */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Repeater rept;

    /* Repeater Table */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RepeaterTable reptbl;

    /* BookMark */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Bookmark bmrk;

    /* Table of Contents */
    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TableOfContents toc;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.LayoutComponentReference lcr;

    private com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension;

    public ReportElement() {
    }

    public ReportElement(
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame txt,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame lst,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell cell,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CrossTab ctab,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart cht,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Image img,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HyperLink hlink,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HTML html,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RichText rtxt,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Repeater rept,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RepeaterTable reptbl,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Bookmark bmrk,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TableOfContents toc,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.LayoutComponentReference lcr,
           com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
           this.txt = txt;
           this.lst = lst;
           this.cell = cell;
           this.ctab = ctab;
           this.cht = cht;
           this.img = img;
           this.hlink = hlink;
           this.html = html;
           this.rtxt = rtxt;
           this.rept = rept;
           this.reptbl = reptbl;
           this.bmrk = bmrk;
           this.toc = toc;
           this.lcr = lcr;
           this.extension = extension;
    }


    /**
     * Gets the txt value for this ReportElement.
     * 
     * @return txt   * TextFrane
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame getTxt() {
        return txt;
    }


    /**
     * Sets the txt value for this ReportElement.
     * 
     * @param txt   * TextFrane
     */
    public void setTxt(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TextFrame txt) {
        this.txt = txt;
    }


    /**
     * Gets the lst value for this ReportElement.
     * 
     * @return lst   * ListFrame
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame getLst() {
        return lst;
    }


    /**
     * Sets the lst value for this ReportElement.
     * 
     * @param lst   * ListFrame
     */
    public void setLst(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.ListFrame lst) {
        this.lst = lst;
    }


    /**
     * Gets the cell value for this ReportElement.
     * 
     * @return cell   * Cell
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell getCell() {
        return cell;
    }


    /**
     * Sets the cell value for this ReportElement.
     * 
     * @param cell   * Cell
     */
    public void setCell(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Cell cell) {
        this.cell = cell;
    }


    /**
     * Gets the ctab value for this ReportElement.
     * 
     * @return ctab   * CrossTab
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CrossTab getCtab() {
        return ctab;
    }


    /**
     * Sets the ctab value for this ReportElement.
     * 
     * @param ctab   * CrossTab
     */
    public void setCtab(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.CrossTab ctab) {
        this.ctab = ctab;
    }


    /**
     * Gets the cht value for this ReportElement.
     * 
     * @return cht   * Chart
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart getCht() {
        return cht;
    }


    /**
     * Sets the cht value for this ReportElement.
     * 
     * @param cht   * Chart
     */
    public void setCht(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Chart cht) {
        this.cht = cht;
    }


    /**
     * Gets the img value for this ReportElement.
     * 
     * @return img   * Image
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Image getImg() {
        return img;
    }


    /**
     * Sets the img value for this ReportElement.
     * 
     * @param img   * Image
     */
    public void setImg(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Image img) {
        this.img = img;
    }


    /**
     * Gets the hlink value for this ReportElement.
     * 
     * @return hlink   * HyperLink
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HyperLink getHlink() {
        return hlink;
    }


    /**
     * Sets the hlink value for this ReportElement.
     * 
     * @param hlink   * HyperLink
     */
    public void setHlink(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HyperLink hlink) {
        this.hlink = hlink;
    }


    /**
     * Gets the html value for this ReportElement.
     * 
     * @return html   * HTML
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HTML getHtml() {
        return html;
    }


    /**
     * Sets the html value for this ReportElement.
     * 
     * @param html   * HTML
     */
    public void setHtml(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.HTML html) {
        this.html = html;
    }


    /**
     * Gets the rtxt value for this ReportElement.
     * 
     * @return rtxt   * RichText
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RichText getRtxt() {
        return rtxt;
    }


    /**
     * Sets the rtxt value for this ReportElement.
     * 
     * @param rtxt   * RichText
     */
    public void setRtxt(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RichText rtxt) {
        this.rtxt = rtxt;
    }


    /**
     * Gets the rept value for this ReportElement.
     * 
     * @return rept   * Repeater
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Repeater getRept() {
        return rept;
    }


    /**
     * Sets the rept value for this ReportElement.
     * 
     * @param rept   * Repeater
     */
    public void setRept(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Repeater rept) {
        this.rept = rept;
    }


    /**
     * Gets the reptbl value for this ReportElement.
     * 
     * @return reptbl   * Repeater Table
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RepeaterTable getReptbl() {
        return reptbl;
    }


    /**
     * Sets the reptbl value for this ReportElement.
     * 
     * @param reptbl   * Repeater Table
     */
    public void setReptbl(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.RepeaterTable reptbl) {
        this.reptbl = reptbl;
    }


    /**
     * Gets the bmrk value for this ReportElement.
     * 
     * @return bmrk   * BookMark
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Bookmark getBmrk() {
        return bmrk;
    }


    /**
     * Sets the bmrk value for this ReportElement.
     * 
     * @param bmrk   * BookMark
     */
    public void setBmrk(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Bookmark bmrk) {
        this.bmrk = bmrk;
    }


    /**
     * Gets the toc value for this ReportElement.
     * 
     * @return toc   * Table of Contents
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TableOfContents getToc() {
        return toc;
    }


    /**
     * Sets the toc value for this ReportElement.
     * 
     * @param toc   * Table of Contents
     */
    public void setToc(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.TableOfContents toc) {
        this.toc = toc;
    }


    /**
     * Gets the lcr value for this ReportElement.
     * 
     * @return lcr
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.LayoutComponentReference getLcr() {
        return lcr;
    }


    /**
     * Sets the lcr value for this ReportElement.
     * 
     * @param lcr
     */
    public void setLcr(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.LayoutComponentReference lcr) {
        this.lcr = lcr;
    }


    /**
     * Gets the extension value for this ReportElement.
     * 
     * @return extension
     */
    public com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this ReportElement.
     * 
     * @param extension
     */
    public void setExtension(com.cognos.developer.schemas.raas.Returns__by__Order__Method___x002d__Prompted__Chart.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReportElement)) return false;
        ReportElement other = (ReportElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.txt==null && other.getTxt()==null) || 
             (this.txt!=null &&
              this.txt.equals(other.getTxt()))) &&
            ((this.lst==null && other.getLst()==null) || 
             (this.lst!=null &&
              this.lst.equals(other.getLst()))) &&
            ((this.cell==null && other.getCell()==null) || 
             (this.cell!=null &&
              this.cell.equals(other.getCell()))) &&
            ((this.ctab==null && other.getCtab()==null) || 
             (this.ctab!=null &&
              this.ctab.equals(other.getCtab()))) &&
            ((this.cht==null && other.getCht()==null) || 
             (this.cht!=null &&
              this.cht.equals(other.getCht()))) &&
            ((this.img==null && other.getImg()==null) || 
             (this.img!=null &&
              this.img.equals(other.getImg()))) &&
            ((this.hlink==null && other.getHlink()==null) || 
             (this.hlink!=null &&
              this.hlink.equals(other.getHlink()))) &&
            ((this.html==null && other.getHtml()==null) || 
             (this.html!=null &&
              this.html.equals(other.getHtml()))) &&
            ((this.rtxt==null && other.getRtxt()==null) || 
             (this.rtxt!=null &&
              this.rtxt.equals(other.getRtxt()))) &&
            ((this.rept==null && other.getRept()==null) || 
             (this.rept!=null &&
              this.rept.equals(other.getRept()))) &&
            ((this.reptbl==null && other.getReptbl()==null) || 
             (this.reptbl!=null &&
              this.reptbl.equals(other.getReptbl()))) &&
            ((this.bmrk==null && other.getBmrk()==null) || 
             (this.bmrk!=null &&
              this.bmrk.equals(other.getBmrk()))) &&
            ((this.toc==null && other.getToc()==null) || 
             (this.toc!=null &&
              this.toc.equals(other.getToc()))) &&
            ((this.lcr==null && other.getLcr()==null) || 
             (this.lcr!=null &&
              this.lcr.equals(other.getLcr()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    @Override
	public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getTxt() != null) {
            _hashCode += getTxt().hashCode();
        }
        if (getLst() != null) {
            _hashCode += getLst().hashCode();
        }
        if (getCell() != null) {
            _hashCode += getCell().hashCode();
        }
        if (getCtab() != null) {
            _hashCode += getCtab().hashCode();
        }
        if (getCht() != null) {
            _hashCode += getCht().hashCode();
        }
        if (getImg() != null) {
            _hashCode += getImg().hashCode();
        }
        if (getHlink() != null) {
            _hashCode += getHlink().hashCode();
        }
        if (getHtml() != null) {
            _hashCode += getHtml().hashCode();
        }
        if (getRtxt() != null) {
            _hashCode += getRtxt().hashCode();
        }
        if (getRept() != null) {
            _hashCode += getRept().hashCode();
        }
        if (getReptbl() != null) {
            _hashCode += getReptbl().hashCode();
        }
        if (getBmrk() != null) {
            _hashCode += getBmrk().hashCode();
        }
        if (getToc() != null) {
            _hashCode += getToc().hashCode();
        }
        if (getLcr() != null) {
            _hashCode += getLcr().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReportElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ReportElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TextFrame"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lst");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "lst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ListFrame"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cell");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cell"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Cell"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "ctab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "CrossTab"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cht");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "cht"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Chart"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("img");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "img"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Image"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hlink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "hlink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "HyperLink"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("html");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "html"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "HTML"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtxt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "rtxt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RichText"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rept");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "rept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Repeater"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reptbl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "reptbl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "RepeaterTable"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmrk");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "bmrk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "Bookmark"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "toc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "TableOfContents"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lcr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "lcr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "LayoutComponentReference"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://developer.cognos.com/schemas/raas/Returns__by__Order__Method___x002d__Prompted__Chart", ">extension"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
