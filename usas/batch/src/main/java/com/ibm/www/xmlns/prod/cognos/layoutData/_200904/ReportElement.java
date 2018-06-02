/**
 * ReportElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;


/**
 * This element is a placeholder for all report elements, that could
 * be returned as a reportLet of the report (including Image, Chart,
 * TextFrame, ListFrame, Crosstab, Page, etc).
 */
public class ReportElement  implements java.io.Serializable {
    /* TextFrane */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame txt;

    /* ListFrame */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.ListFrame lst;

    /* Cell */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell cell;

    /* CrossTab */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.CrossTab ctab;

    /* Chart */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Chart cht;

    /* Image */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image img;

    /* HyperLink */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.HyperLink hlink;

    /* HTML */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.HTML html;

    /* RichText */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichText rtxt;

    /* Repeater */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Repeater rept;

    /* Repeater Table */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.RepeaterTable reptbl;

    /* BookMark */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Bookmark bmrk;

    /* Table of Contents */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.TableOfContents toc;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutComponentReference lcr;

    /* Layout Table */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableType tbl;

    /* Layout Block */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutBlockType blk;

    /* Singleton */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SingletonType sngl;

    /* IWidget */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.WidgetType widget;

    /* Text Box Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextBoxPromptType p_txtbox;

    /* Select Value Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectValuePromptType p_value;

    /* Select Date Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDatePromptType p_date;

    /* Select Time Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectTimePromptType p_time;

    /* Select DateTime Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDateTimePromptType p_dtime;

    /* Select Interval Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectIntervalPromptType p_intrvl;

    /* DataSource Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.DataSourcePromptType p_dsrc;

    /* Search Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.SearchAndSelectPromptType p_srch;

    /* Tree Prompt */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.TreePromptType p_tree;

    /* Prompt Button */
    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptButtonType p_btn;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public ReportElement() {
    }

    public ReportElement(
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame txt,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.ListFrame lst,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell cell,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.CrossTab ctab,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Chart cht,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image img,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.HyperLink hlink,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.HTML html,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichText rtxt,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Repeater rept,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.RepeaterTable reptbl,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Bookmark bmrk,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.TableOfContents toc,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutComponentReference lcr,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableType tbl,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutBlockType blk,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SingletonType sngl,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.WidgetType widget,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextBoxPromptType p_txtbox,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectValuePromptType p_value,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDatePromptType p_date,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectTimePromptType p_time,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDateTimePromptType p_dtime,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectIntervalPromptType p_intrvl,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.DataSourcePromptType p_dsrc,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.SearchAndSelectPromptType p_srch,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.TreePromptType p_tree,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptButtonType p_btn,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
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
           this.tbl = tbl;
           this.blk = blk;
           this.sngl = sngl;
           this.widget = widget;
           this.p_txtbox = p_txtbox;
           this.p_value = p_value;
           this.p_date = p_date;
           this.p_time = p_time;
           this.p_dtime = p_dtime;
           this.p_intrvl = p_intrvl;
           this.p_dsrc = p_dsrc;
           this.p_srch = p_srch;
           this.p_tree = p_tree;
           this.p_btn = p_btn;
           this.extension = extension;
    }


    /**
     * Gets the txt value for this ReportElement.
     * 
     * @return txt   * TextFrane
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame getTxt() {
        return txt;
    }


    /**
     * Sets the txt value for this ReportElement.
     * 
     * @param txt   * TextFrane
     */
    public void setTxt(com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextFrame txt) {
        this.txt = txt;
    }


    /**
     * Gets the lst value for this ReportElement.
     * 
     * @return lst   * ListFrame
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.ListFrame getLst() {
        return lst;
    }


    /**
     * Sets the lst value for this ReportElement.
     * 
     * @param lst   * ListFrame
     */
    public void setLst(com.ibm.www.xmlns.prod.cognos.layoutData._200904.ListFrame lst) {
        this.lst = lst;
    }


    /**
     * Gets the cell value for this ReportElement.
     * 
     * @return cell   * Cell
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell getCell() {
        return cell;
    }


    /**
     * Sets the cell value for this ReportElement.
     * 
     * @param cell   * Cell
     */
    public void setCell(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Cell cell) {
        this.cell = cell;
    }


    /**
     * Gets the ctab value for this ReportElement.
     * 
     * @return ctab   * CrossTab
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.CrossTab getCtab() {
        return ctab;
    }


    /**
     * Sets the ctab value for this ReportElement.
     * 
     * @param ctab   * CrossTab
     */
    public void setCtab(com.ibm.www.xmlns.prod.cognos.layoutData._200904.CrossTab ctab) {
        this.ctab = ctab;
    }


    /**
     * Gets the cht value for this ReportElement.
     * 
     * @return cht   * Chart
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Chart getCht() {
        return cht;
    }


    /**
     * Sets the cht value for this ReportElement.
     * 
     * @param cht   * Chart
     */
    public void setCht(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Chart cht) {
        this.cht = cht;
    }


    /**
     * Gets the img value for this ReportElement.
     * 
     * @return img   * Image
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image getImg() {
        return img;
    }


    /**
     * Sets the img value for this ReportElement.
     * 
     * @param img   * Image
     */
    public void setImg(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Image img) {
        this.img = img;
    }


    /**
     * Gets the hlink value for this ReportElement.
     * 
     * @return hlink   * HyperLink
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.HyperLink getHlink() {
        return hlink;
    }


    /**
     * Sets the hlink value for this ReportElement.
     * 
     * @param hlink   * HyperLink
     */
    public void setHlink(com.ibm.www.xmlns.prod.cognos.layoutData._200904.HyperLink hlink) {
        this.hlink = hlink;
    }


    /**
     * Gets the html value for this ReportElement.
     * 
     * @return html   * HTML
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.HTML getHtml() {
        return html;
    }


    /**
     * Sets the html value for this ReportElement.
     * 
     * @param html   * HTML
     */
    public void setHtml(com.ibm.www.xmlns.prod.cognos.layoutData._200904.HTML html) {
        this.html = html;
    }


    /**
     * Gets the rtxt value for this ReportElement.
     * 
     * @return rtxt   * RichText
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichText getRtxt() {
        return rtxt;
    }


    /**
     * Sets the rtxt value for this ReportElement.
     * 
     * @param rtxt   * RichText
     */
    public void setRtxt(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RichText rtxt) {
        this.rtxt = rtxt;
    }


    /**
     * Gets the rept value for this ReportElement.
     * 
     * @return rept   * Repeater
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Repeater getRept() {
        return rept;
    }


    /**
     * Sets the rept value for this ReportElement.
     * 
     * @param rept   * Repeater
     */
    public void setRept(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Repeater rept) {
        this.rept = rept;
    }


    /**
     * Gets the reptbl value for this ReportElement.
     * 
     * @return reptbl   * Repeater Table
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.RepeaterTable getReptbl() {
        return reptbl;
    }


    /**
     * Sets the reptbl value for this ReportElement.
     * 
     * @param reptbl   * Repeater Table
     */
    public void setReptbl(com.ibm.www.xmlns.prod.cognos.layoutData._200904.RepeaterTable reptbl) {
        this.reptbl = reptbl;
    }


    /**
     * Gets the bmrk value for this ReportElement.
     * 
     * @return bmrk   * BookMark
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Bookmark getBmrk() {
        return bmrk;
    }


    /**
     * Sets the bmrk value for this ReportElement.
     * 
     * @param bmrk   * BookMark
     */
    public void setBmrk(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Bookmark bmrk) {
        this.bmrk = bmrk;
    }


    /**
     * Gets the toc value for this ReportElement.
     * 
     * @return toc   * Table of Contents
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.TableOfContents getToc() {
        return toc;
    }


    /**
     * Sets the toc value for this ReportElement.
     * 
     * @param toc   * Table of Contents
     */
    public void setToc(com.ibm.www.xmlns.prod.cognos.layoutData._200904.TableOfContents toc) {
        this.toc = toc;
    }


    /**
     * Gets the lcr value for this ReportElement.
     * 
     * @return lcr
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutComponentReference getLcr() {
        return lcr;
    }


    /**
     * Sets the lcr value for this ReportElement.
     * 
     * @param lcr
     */
    public void setLcr(com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutComponentReference lcr) {
        this.lcr = lcr;
    }


    /**
     * Gets the tbl value for this ReportElement.
     * 
     * @return tbl   * Layout Table
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableType getTbl() {
        return tbl;
    }


    /**
     * Sets the tbl value for this ReportElement.
     * 
     * @param tbl   * Layout Table
     */
    public void setTbl(com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutTableType tbl) {
        this.tbl = tbl;
    }


    /**
     * Gets the blk value for this ReportElement.
     * 
     * @return blk   * Layout Block
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutBlockType getBlk() {
        return blk;
    }


    /**
     * Sets the blk value for this ReportElement.
     * 
     * @param blk   * Layout Block
     */
    public void setBlk(com.ibm.www.xmlns.prod.cognos.layoutData._200904.LayoutBlockType blk) {
        this.blk = blk;
    }


    /**
     * Gets the sngl value for this ReportElement.
     * 
     * @return sngl   * Singleton
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SingletonType getSngl() {
        return sngl;
    }


    /**
     * Sets the sngl value for this ReportElement.
     * 
     * @param sngl   * Singleton
     */
    public void setSngl(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SingletonType sngl) {
        this.sngl = sngl;
    }


    /**
     * Gets the widget value for this ReportElement.
     * 
     * @return widget   * IWidget
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.WidgetType getWidget() {
        return widget;
    }


    /**
     * Sets the widget value for this ReportElement.
     * 
     * @param widget   * IWidget
     */
    public void setWidget(com.ibm.www.xmlns.prod.cognos.layoutData._200904.WidgetType widget) {
        this.widget = widget;
    }


    /**
     * Gets the p_txtbox value for this ReportElement.
     * 
     * @return p_txtbox   * Text Box Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextBoxPromptType getP_txtbox() {
        return p_txtbox;
    }


    /**
     * Sets the p_txtbox value for this ReportElement.
     * 
     * @param p_txtbox   * Text Box Prompt
     */
    public void setP_txtbox(com.ibm.www.xmlns.prod.cognos.layoutData._200904.TextBoxPromptType p_txtbox) {
        this.p_txtbox = p_txtbox;
    }


    /**
     * Gets the p_value value for this ReportElement.
     * 
     * @return p_value   * Select Value Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectValuePromptType getP_value() {
        return p_value;
    }


    /**
     * Sets the p_value value for this ReportElement.
     * 
     * @param p_value   * Select Value Prompt
     */
    public void setP_value(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectValuePromptType p_value) {
        this.p_value = p_value;
    }


    /**
     * Gets the p_date value for this ReportElement.
     * 
     * @return p_date   * Select Date Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDatePromptType getP_date() {
        return p_date;
    }


    /**
     * Sets the p_date value for this ReportElement.
     * 
     * @param p_date   * Select Date Prompt
     */
    public void setP_date(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDatePromptType p_date) {
        this.p_date = p_date;
    }


    /**
     * Gets the p_time value for this ReportElement.
     * 
     * @return p_time   * Select Time Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectTimePromptType getP_time() {
        return p_time;
    }


    /**
     * Sets the p_time value for this ReportElement.
     * 
     * @param p_time   * Select Time Prompt
     */
    public void setP_time(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectTimePromptType p_time) {
        this.p_time = p_time;
    }


    /**
     * Gets the p_dtime value for this ReportElement.
     * 
     * @return p_dtime   * Select DateTime Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDateTimePromptType getP_dtime() {
        return p_dtime;
    }


    /**
     * Sets the p_dtime value for this ReportElement.
     * 
     * @param p_dtime   * Select DateTime Prompt
     */
    public void setP_dtime(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectDateTimePromptType p_dtime) {
        this.p_dtime = p_dtime;
    }


    /**
     * Gets the p_intrvl value for this ReportElement.
     * 
     * @return p_intrvl   * Select Interval Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectIntervalPromptType getP_intrvl() {
        return p_intrvl;
    }


    /**
     * Sets the p_intrvl value for this ReportElement.
     * 
     * @param p_intrvl   * Select Interval Prompt
     */
    public void setP_intrvl(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SelectIntervalPromptType p_intrvl) {
        this.p_intrvl = p_intrvl;
    }


    /**
     * Gets the p_dsrc value for this ReportElement.
     * 
     * @return p_dsrc   * DataSource Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.DataSourcePromptType getP_dsrc() {
        return p_dsrc;
    }


    /**
     * Sets the p_dsrc value for this ReportElement.
     * 
     * @param p_dsrc   * DataSource Prompt
     */
    public void setP_dsrc(com.ibm.www.xmlns.prod.cognos.layoutData._200904.DataSourcePromptType p_dsrc) {
        this.p_dsrc = p_dsrc;
    }


    /**
     * Gets the p_srch value for this ReportElement.
     * 
     * @return p_srch   * Search Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.SearchAndSelectPromptType getP_srch() {
        return p_srch;
    }


    /**
     * Sets the p_srch value for this ReportElement.
     * 
     * @param p_srch   * Search Prompt
     */
    public void setP_srch(com.ibm.www.xmlns.prod.cognos.layoutData._200904.SearchAndSelectPromptType p_srch) {
        this.p_srch = p_srch;
    }


    /**
     * Gets the p_tree value for this ReportElement.
     * 
     * @return p_tree   * Tree Prompt
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.TreePromptType getP_tree() {
        return p_tree;
    }


    /**
     * Sets the p_tree value for this ReportElement.
     * 
     * @param p_tree   * Tree Prompt
     */
    public void setP_tree(com.ibm.www.xmlns.prod.cognos.layoutData._200904.TreePromptType p_tree) {
        this.p_tree = p_tree;
    }


    /**
     * Gets the p_btn value for this ReportElement.
     * 
     * @return p_btn   * Prompt Button
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptButtonType getP_btn() {
        return p_btn;
    }


    /**
     * Sets the p_btn value for this ReportElement.
     * 
     * @param p_btn   * Prompt Button
     */
    public void setP_btn(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptButtonType p_btn) {
        this.p_btn = p_btn;
    }


    /**
     * Gets the extension value for this ReportElement.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this ReportElement.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
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
            ((this.tbl==null && other.getTbl()==null) || 
             (this.tbl!=null &&
              this.tbl.equals(other.getTbl()))) &&
            ((this.blk==null && other.getBlk()==null) || 
             (this.blk!=null &&
              this.blk.equals(other.getBlk()))) &&
            ((this.sngl==null && other.getSngl()==null) || 
             (this.sngl!=null &&
              this.sngl.equals(other.getSngl()))) &&
            ((this.widget==null && other.getWidget()==null) || 
             (this.widget!=null &&
              this.widget.equals(other.getWidget()))) &&
            ((this.p_txtbox==null && other.getP_txtbox()==null) || 
             (this.p_txtbox!=null &&
              this.p_txtbox.equals(other.getP_txtbox()))) &&
            ((this.p_value==null && other.getP_value()==null) || 
             (this.p_value!=null &&
              this.p_value.equals(other.getP_value()))) &&
            ((this.p_date==null && other.getP_date()==null) || 
             (this.p_date!=null &&
              this.p_date.equals(other.getP_date()))) &&
            ((this.p_time==null && other.getP_time()==null) || 
             (this.p_time!=null &&
              this.p_time.equals(other.getP_time()))) &&
            ((this.p_dtime==null && other.getP_dtime()==null) || 
             (this.p_dtime!=null &&
              this.p_dtime.equals(other.getP_dtime()))) &&
            ((this.p_intrvl==null && other.getP_intrvl()==null) || 
             (this.p_intrvl!=null &&
              this.p_intrvl.equals(other.getP_intrvl()))) &&
            ((this.p_dsrc==null && other.getP_dsrc()==null) || 
             (this.p_dsrc!=null &&
              this.p_dsrc.equals(other.getP_dsrc()))) &&
            ((this.p_srch==null && other.getP_srch()==null) || 
             (this.p_srch!=null &&
              this.p_srch.equals(other.getP_srch()))) &&
            ((this.p_tree==null && other.getP_tree()==null) || 
             (this.p_tree!=null &&
              this.p_tree.equals(other.getP_tree()))) &&
            ((this.p_btn==null && other.getP_btn()==null) || 
             (this.p_btn!=null &&
              this.p_btn.equals(other.getP_btn()))) &&
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
        if (getTbl() != null) {
            _hashCode += getTbl().hashCode();
        }
        if (getBlk() != null) {
            _hashCode += getBlk().hashCode();
        }
        if (getSngl() != null) {
            _hashCode += getSngl().hashCode();
        }
        if (getWidget() != null) {
            _hashCode += getWidget().hashCode();
        }
        if (getP_txtbox() != null) {
            _hashCode += getP_txtbox().hashCode();
        }
        if (getP_value() != null) {
            _hashCode += getP_value().hashCode();
        }
        if (getP_date() != null) {
            _hashCode += getP_date().hashCode();
        }
        if (getP_time() != null) {
            _hashCode += getP_time().hashCode();
        }
        if (getP_dtime() != null) {
            _hashCode += getP_dtime().hashCode();
        }
        if (getP_intrvl() != null) {
            _hashCode += getP_intrvl().hashCode();
        }
        if (getP_dsrc() != null) {
            _hashCode += getP_dsrc().hashCode();
        }
        if (getP_srch() != null) {
            _hashCode += getP_srch().hashCode();
        }
        if (getP_tree() != null) {
            _hashCode += getP_tree().hashCode();
        }
        if (getP_btn() != null) {
            _hashCode += getP_btn().hashCode();
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ReportElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("txt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextFrame"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lst");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "lst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ListFrame"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cell");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cell"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Cell"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ctab");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ctab"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "CrossTab"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cht");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cht"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Chart"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("img");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "img"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Image"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hlink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "hlink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "HyperLink"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("html");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "html"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "HTML"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtxt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "rtxt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RichText"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rept");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "rept"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Repeater"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reptbl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "reptbl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "RepeaterTable"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bmrk");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "bmrk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "Bookmark"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "toc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TableOfContents"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lcr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "lcr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutComponentReference"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tbl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "tbl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutTableType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blk");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "blk"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "LayoutBlockType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sngl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "sngl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SingletonType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("widget");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "widget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "WidgetType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_txtbox");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_txtbox"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TextBoxPromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectValuePromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectDatePromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectTimePromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_dtime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_dtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectDateTimePromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_intrvl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_intrvl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectIntervalPromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_dsrc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_dsrc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "DataSourcePromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_srch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_srch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SearchAndSelectPromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_tree");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_tree"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TreePromptType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_btn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "p_btn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PromptButtonType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">extension"));
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
