/**
 * SearchAndSelectPromptType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class SearchAndSelectPromptType  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String[] style;

    private java.lang.String pname;

    private java.lang.Boolean req;

    private java.lang.Boolean noadorn;

    private java.lang.Boolean range;

    private java.lang.Boolean multi;

    private java.lang.String cascadeon;

    private java.lang.Boolean prepopulate;

    private java.lang.Integer rows;

    private java.lang.Boolean disabled;

    /* True if the search returned no results */
    private java.lang.Boolean noresults;

    /* If true, match anywhere */
    private java.lang.Boolean mtchany;

    /* If true, match all */
    private java.lang.Boolean mtchall;

    /* True if the search options should be expanded */
    private java.lang.Boolean showopt;

    /* The search value - used when preserving the search context */
    private java.lang.String srchval;

    /* If true, case insensitive */
    private java.lang.Boolean nocase;

    private java.lang.String cname;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selOptions;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices;

    private java.lang.String keywordsText;

    private java.lang.String searchInstructionsText;

    private java.lang.String choicesText;

    private java.lang.String choiceText;

    private java.lang.String resultsText;

    private java.lang.String choicesSelectAllText;

    private java.lang.String choicesDeselectAllText;

    private java.lang.String resultsSelectAllText;

    private java.lang.String resultsDeselectAllText;

    private java.lang.String deselectText;

    private java.lang.String removeText;

    private java.lang.String insertText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public SearchAndSelectPromptType() {
    }

    public SearchAndSelectPromptType(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String[] style,
           java.lang.String pname,
           java.lang.Boolean req,
           java.lang.Boolean noadorn,
           java.lang.Boolean range,
           java.lang.Boolean multi,
           java.lang.String cascadeon,
           java.lang.Boolean prepopulate,
           java.lang.Integer rows,
           java.lang.Boolean disabled,
           java.lang.Boolean noresults,
           java.lang.Boolean mtchany,
           java.lang.Boolean mtchall,
           java.lang.Boolean showopt,
           java.lang.String srchval,
           java.lang.Boolean nocase,
           java.lang.String cname,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selOptions,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices,
           java.lang.String keywordsText,
           java.lang.String searchInstructionsText,
           java.lang.String choicesText,
           java.lang.String choiceText,
           java.lang.String resultsText,
           java.lang.String choicesSelectAllText,
           java.lang.String choicesDeselectAllText,
           java.lang.String resultsSelectAllText,
           java.lang.String resultsDeselectAllText,
           java.lang.String deselectText,
           java.lang.String removeText,
           java.lang.String insertText,
           java.lang.String annURL,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.pname = pname;
           this.req = req;
           this.noadorn = noadorn;
           this.range = range;
           this.multi = multi;
           this.cascadeon = cascadeon;
           this.prepopulate = prepopulate;
           this.rows = rows;
           this.disabled = disabled;
           this.noresults = noresults;
           this.mtchany = mtchany;
           this.mtchall = mtchall;
           this.showopt = showopt;
           this.srchval = srchval;
           this.nocase = nocase;
           this.cname = cname;
           this.selOptions = selOptions;
           this.selChoices = selChoices;
           this.keywordsText = keywordsText;
           this.searchInstructionsText = searchInstructionsText;
           this.choicesText = choicesText;
           this.choiceText = choiceText;
           this.resultsText = resultsText;
           this.choicesSelectAllText = choicesSelectAllText;
           this.choicesDeselectAllText = choicesDeselectAllText;
           this.resultsSelectAllText = resultsSelectAllText;
           this.resultsDeselectAllText = resultsDeselectAllText;
           this.deselectText = deselectText;
           this.removeText = removeText;
           this.insertText = insertText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this SearchAndSelectPromptType.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this SearchAndSelectPromptType.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this SearchAndSelectPromptType.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this SearchAndSelectPromptType.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this SearchAndSelectPromptType.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this SearchAndSelectPromptType.
     * 
     * @param style
     */
    public void setStyle(java.lang.String[] style) {
        this.style = style;
    }

    public java.lang.String getStyle(int i) {
        return this.style[i];
    }

    public void setStyle(int i, java.lang.String _value) {
        this.style[i] = _value;
    }


    /**
     * Gets the pname value for this SearchAndSelectPromptType.
     * 
     * @return pname
     */
    public java.lang.String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this SearchAndSelectPromptType.
     * 
     * @param pname
     */
    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }


    /**
     * Gets the req value for this SearchAndSelectPromptType.
     * 
     * @return req
     */
    public java.lang.Boolean getReq() {
        return req;
    }


    /**
     * Sets the req value for this SearchAndSelectPromptType.
     * 
     * @param req
     */
    public void setReq(java.lang.Boolean req) {
        this.req = req;
    }


    /**
     * Gets the noadorn value for this SearchAndSelectPromptType.
     * 
     * @return noadorn
     */
    public java.lang.Boolean getNoadorn() {
        return noadorn;
    }


    /**
     * Sets the noadorn value for this SearchAndSelectPromptType.
     * 
     * @param noadorn
     */
    public void setNoadorn(java.lang.Boolean noadorn) {
        this.noadorn = noadorn;
    }


    /**
     * Gets the range value for this SearchAndSelectPromptType.
     * 
     * @return range
     */
    public java.lang.Boolean getRange() {
        return range;
    }


    /**
     * Sets the range value for this SearchAndSelectPromptType.
     * 
     * @param range
     */
    public void setRange(java.lang.Boolean range) {
        this.range = range;
    }


    /**
     * Gets the multi value for this SearchAndSelectPromptType.
     * 
     * @return multi
     */
    public java.lang.Boolean getMulti() {
        return multi;
    }


    /**
     * Sets the multi value for this SearchAndSelectPromptType.
     * 
     * @param multi
     */
    public void setMulti(java.lang.Boolean multi) {
        this.multi = multi;
    }


    /**
     * Gets the cascadeon value for this SearchAndSelectPromptType.
     * 
     * @return cascadeon
     */
    public java.lang.String getCascadeon() {
        return cascadeon;
    }


    /**
     * Sets the cascadeon value for this SearchAndSelectPromptType.
     * 
     * @param cascadeon
     */
    public void setCascadeon(java.lang.String cascadeon) {
        this.cascadeon = cascadeon;
    }


    /**
     * Gets the prepopulate value for this SearchAndSelectPromptType.
     * 
     * @return prepopulate
     */
    public java.lang.Boolean getPrepopulate() {
        return prepopulate;
    }


    /**
     * Sets the prepopulate value for this SearchAndSelectPromptType.
     * 
     * @param prepopulate
     */
    public void setPrepopulate(java.lang.Boolean prepopulate) {
        this.prepopulate = prepopulate;
    }


    /**
     * Gets the rows value for this SearchAndSelectPromptType.
     * 
     * @return rows
     */
    public java.lang.Integer getRows() {
        return rows;
    }


    /**
     * Sets the rows value for this SearchAndSelectPromptType.
     * 
     * @param rows
     */
    public void setRows(java.lang.Integer rows) {
        this.rows = rows;
    }


    /**
     * Gets the disabled value for this SearchAndSelectPromptType.
     * 
     * @return disabled
     */
    public java.lang.Boolean getDisabled() {
        return disabled;
    }


    /**
     * Sets the disabled value for this SearchAndSelectPromptType.
     * 
     * @param disabled
     */
    public void setDisabled(java.lang.Boolean disabled) {
        this.disabled = disabled;
    }


    /**
     * Gets the noresults value for this SearchAndSelectPromptType.
     * 
     * @return noresults   * True if the search returned no results
     */
    public java.lang.Boolean getNoresults() {
        return noresults;
    }


    /**
     * Sets the noresults value for this SearchAndSelectPromptType.
     * 
     * @param noresults   * True if the search returned no results
     */
    public void setNoresults(java.lang.Boolean noresults) {
        this.noresults = noresults;
    }


    /**
     * Gets the mtchany value for this SearchAndSelectPromptType.
     * 
     * @return mtchany   * If true, match anywhere
     */
    public java.lang.Boolean getMtchany() {
        return mtchany;
    }


    /**
     * Sets the mtchany value for this SearchAndSelectPromptType.
     * 
     * @param mtchany   * If true, match anywhere
     */
    public void setMtchany(java.lang.Boolean mtchany) {
        this.mtchany = mtchany;
    }


    /**
     * Gets the mtchall value for this SearchAndSelectPromptType.
     * 
     * @return mtchall   * If true, match all
     */
    public java.lang.Boolean getMtchall() {
        return mtchall;
    }


    /**
     * Sets the mtchall value for this SearchAndSelectPromptType.
     * 
     * @param mtchall   * If true, match all
     */
    public void setMtchall(java.lang.Boolean mtchall) {
        this.mtchall = mtchall;
    }


    /**
     * Gets the showopt value for this SearchAndSelectPromptType.
     * 
     * @return showopt   * True if the search options should be expanded
     */
    public java.lang.Boolean getShowopt() {
        return showopt;
    }


    /**
     * Sets the showopt value for this SearchAndSelectPromptType.
     * 
     * @param showopt   * True if the search options should be expanded
     */
    public void setShowopt(java.lang.Boolean showopt) {
        this.showopt = showopt;
    }


    /**
     * Gets the srchval value for this SearchAndSelectPromptType.
     * 
     * @return srchval   * The search value - used when preserving the search context
     */
    public java.lang.String getSrchval() {
        return srchval;
    }


    /**
     * Sets the srchval value for this SearchAndSelectPromptType.
     * 
     * @param srchval   * The search value - used when preserving the search context
     */
    public void setSrchval(java.lang.String srchval) {
        this.srchval = srchval;
    }


    /**
     * Gets the nocase value for this SearchAndSelectPromptType.
     * 
     * @return nocase   * If true, case insensitive
     */
    public java.lang.Boolean getNocase() {
        return nocase;
    }


    /**
     * Sets the nocase value for this SearchAndSelectPromptType.
     * 
     * @param nocase   * If true, case insensitive
     */
    public void setNocase(java.lang.Boolean nocase) {
        this.nocase = nocase;
    }


    /**
     * Gets the cname value for this SearchAndSelectPromptType.
     * 
     * @return cname
     */
    public java.lang.String getCname() {
        return cname;
    }


    /**
     * Sets the cname value for this SearchAndSelectPromptType.
     * 
     * @param cname
     */
    public void setCname(java.lang.String cname) {
        this.cname = cname;
    }


    /**
     * Gets the selOptions value for this SearchAndSelectPromptType.
     * 
     * @return selOptions
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType getSelOptions() {
        return selOptions;
    }


    /**
     * Sets the selOptions value for this SearchAndSelectPromptType.
     * 
     * @param selOptions
     */
    public void setSelOptions(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selOptions) {
        this.selOptions = selOptions;
    }


    /**
     * Gets the selChoices value for this SearchAndSelectPromptType.
     * 
     * @return selChoices
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType getSelChoices() {
        return selChoices;
    }


    /**
     * Sets the selChoices value for this SearchAndSelectPromptType.
     * 
     * @param selChoices
     */
    public void setSelChoices(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices) {
        this.selChoices = selChoices;
    }


    /**
     * Gets the keywordsText value for this SearchAndSelectPromptType.
     * 
     * @return keywordsText
     */
    public java.lang.String getKeywordsText() {
        return keywordsText;
    }


    /**
     * Sets the keywordsText value for this SearchAndSelectPromptType.
     * 
     * @param keywordsText
     */
    public void setKeywordsText(java.lang.String keywordsText) {
        this.keywordsText = keywordsText;
    }


    /**
     * Gets the searchInstructionsText value for this SearchAndSelectPromptType.
     * 
     * @return searchInstructionsText
     */
    public java.lang.String getSearchInstructionsText() {
        return searchInstructionsText;
    }


    /**
     * Sets the searchInstructionsText value for this SearchAndSelectPromptType.
     * 
     * @param searchInstructionsText
     */
    public void setSearchInstructionsText(java.lang.String searchInstructionsText) {
        this.searchInstructionsText = searchInstructionsText;
    }


    /**
     * Gets the choicesText value for this SearchAndSelectPromptType.
     * 
     * @return choicesText
     */
    public java.lang.String getChoicesText() {
        return choicesText;
    }


    /**
     * Sets the choicesText value for this SearchAndSelectPromptType.
     * 
     * @param choicesText
     */
    public void setChoicesText(java.lang.String choicesText) {
        this.choicesText = choicesText;
    }


    /**
     * Gets the choiceText value for this SearchAndSelectPromptType.
     * 
     * @return choiceText
     */
    public java.lang.String getChoiceText() {
        return choiceText;
    }


    /**
     * Sets the choiceText value for this SearchAndSelectPromptType.
     * 
     * @param choiceText
     */
    public void setChoiceText(java.lang.String choiceText) {
        this.choiceText = choiceText;
    }


    /**
     * Gets the resultsText value for this SearchAndSelectPromptType.
     * 
     * @return resultsText
     */
    public java.lang.String getResultsText() {
        return resultsText;
    }


    /**
     * Sets the resultsText value for this SearchAndSelectPromptType.
     * 
     * @param resultsText
     */
    public void setResultsText(java.lang.String resultsText) {
        this.resultsText = resultsText;
    }


    /**
     * Gets the choicesSelectAllText value for this SearchAndSelectPromptType.
     * 
     * @return choicesSelectAllText
     */
    public java.lang.String getChoicesSelectAllText() {
        return choicesSelectAllText;
    }


    /**
     * Sets the choicesSelectAllText value for this SearchAndSelectPromptType.
     * 
     * @param choicesSelectAllText
     */
    public void setChoicesSelectAllText(java.lang.String choicesSelectAllText) {
        this.choicesSelectAllText = choicesSelectAllText;
    }


    /**
     * Gets the choicesDeselectAllText value for this SearchAndSelectPromptType.
     * 
     * @return choicesDeselectAllText
     */
    public java.lang.String getChoicesDeselectAllText() {
        return choicesDeselectAllText;
    }


    /**
     * Sets the choicesDeselectAllText value for this SearchAndSelectPromptType.
     * 
     * @param choicesDeselectAllText
     */
    public void setChoicesDeselectAllText(java.lang.String choicesDeselectAllText) {
        this.choicesDeselectAllText = choicesDeselectAllText;
    }


    /**
     * Gets the resultsSelectAllText value for this SearchAndSelectPromptType.
     * 
     * @return resultsSelectAllText
     */
    public java.lang.String getResultsSelectAllText() {
        return resultsSelectAllText;
    }


    /**
     * Sets the resultsSelectAllText value for this SearchAndSelectPromptType.
     * 
     * @param resultsSelectAllText
     */
    public void setResultsSelectAllText(java.lang.String resultsSelectAllText) {
        this.resultsSelectAllText = resultsSelectAllText;
    }


    /**
     * Gets the resultsDeselectAllText value for this SearchAndSelectPromptType.
     * 
     * @return resultsDeselectAllText
     */
    public java.lang.String getResultsDeselectAllText() {
        return resultsDeselectAllText;
    }


    /**
     * Sets the resultsDeselectAllText value for this SearchAndSelectPromptType.
     * 
     * @param resultsDeselectAllText
     */
    public void setResultsDeselectAllText(java.lang.String resultsDeselectAllText) {
        this.resultsDeselectAllText = resultsDeselectAllText;
    }


    /**
     * Gets the deselectText value for this SearchAndSelectPromptType.
     * 
     * @return deselectText
     */
    public java.lang.String getDeselectText() {
        return deselectText;
    }


    /**
     * Sets the deselectText value for this SearchAndSelectPromptType.
     * 
     * @param deselectText
     */
    public void setDeselectText(java.lang.String deselectText) {
        this.deselectText = deselectText;
    }


    /**
     * Gets the removeText value for this SearchAndSelectPromptType.
     * 
     * @return removeText
     */
    public java.lang.String getRemoveText() {
        return removeText;
    }


    /**
     * Sets the removeText value for this SearchAndSelectPromptType.
     * 
     * @param removeText
     */
    public void setRemoveText(java.lang.String removeText) {
        this.removeText = removeText;
    }


    /**
     * Gets the insertText value for this SearchAndSelectPromptType.
     * 
     * @return insertText
     */
    public java.lang.String getInsertText() {
        return insertText;
    }


    /**
     * Sets the insertText value for this SearchAndSelectPromptType.
     * 
     * @param insertText
     */
    public void setInsertText(java.lang.String insertText) {
        this.insertText = insertText;
    }


    /**
     * Gets the annURL value for this SearchAndSelectPromptType.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this SearchAndSelectPromptType.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this SearchAndSelectPromptType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this SearchAndSelectPromptType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchAndSelectPromptType)) return false;
        SearchAndSelectPromptType other = (SearchAndSelectPromptType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ref==null && other.getRef()==null) || 
             (this.ref!=null &&
              this.ref.equals(other.getRef()))) &&
            ((this.style==null && other.getStyle()==null) || 
             (this.style!=null &&
              java.util.Arrays.equals(this.style, other.getStyle()))) &&
            ((this.pname==null && other.getPname()==null) || 
             (this.pname!=null &&
              this.pname.equals(other.getPname()))) &&
            ((this.req==null && other.getReq()==null) || 
             (this.req!=null &&
              this.req.equals(other.getReq()))) &&
            ((this.noadorn==null && other.getNoadorn()==null) || 
             (this.noadorn!=null &&
              this.noadorn.equals(other.getNoadorn()))) &&
            ((this.range==null && other.getRange()==null) || 
             (this.range!=null &&
              this.range.equals(other.getRange()))) &&
            ((this.multi==null && other.getMulti()==null) || 
             (this.multi!=null &&
              this.multi.equals(other.getMulti()))) &&
            ((this.cascadeon==null && other.getCascadeon()==null) || 
             (this.cascadeon!=null &&
              this.cascadeon.equals(other.getCascadeon()))) &&
            ((this.prepopulate==null && other.getPrepopulate()==null) || 
             (this.prepopulate!=null &&
              this.prepopulate.equals(other.getPrepopulate()))) &&
            ((this.rows==null && other.getRows()==null) || 
             (this.rows!=null &&
              this.rows.equals(other.getRows()))) &&
            ((this.disabled==null && other.getDisabled()==null) || 
             (this.disabled!=null &&
              this.disabled.equals(other.getDisabled()))) &&
            ((this.noresults==null && other.getNoresults()==null) || 
             (this.noresults!=null &&
              this.noresults.equals(other.getNoresults()))) &&
            ((this.mtchany==null && other.getMtchany()==null) || 
             (this.mtchany!=null &&
              this.mtchany.equals(other.getMtchany()))) &&
            ((this.mtchall==null && other.getMtchall()==null) || 
             (this.mtchall!=null &&
              this.mtchall.equals(other.getMtchall()))) &&
            ((this.showopt==null && other.getShowopt()==null) || 
             (this.showopt!=null &&
              this.showopt.equals(other.getShowopt()))) &&
            ((this.srchval==null && other.getSrchval()==null) || 
             (this.srchval!=null &&
              this.srchval.equals(other.getSrchval()))) &&
            ((this.nocase==null && other.getNocase()==null) || 
             (this.nocase!=null &&
              this.nocase.equals(other.getNocase()))) &&
            ((this.cname==null && other.getCname()==null) || 
             (this.cname!=null &&
              this.cname.equals(other.getCname()))) &&
            ((this.selOptions==null && other.getSelOptions()==null) || 
             (this.selOptions!=null &&
              this.selOptions.equals(other.getSelOptions()))) &&
            ((this.selChoices==null && other.getSelChoices()==null) || 
             (this.selChoices!=null &&
              this.selChoices.equals(other.getSelChoices()))) &&
            ((this.keywordsText==null && other.getKeywordsText()==null) || 
             (this.keywordsText!=null &&
              this.keywordsText.equals(other.getKeywordsText()))) &&
            ((this.searchInstructionsText==null && other.getSearchInstructionsText()==null) || 
             (this.searchInstructionsText!=null &&
              this.searchInstructionsText.equals(other.getSearchInstructionsText()))) &&
            ((this.choicesText==null && other.getChoicesText()==null) || 
             (this.choicesText!=null &&
              this.choicesText.equals(other.getChoicesText()))) &&
            ((this.choiceText==null && other.getChoiceText()==null) || 
             (this.choiceText!=null &&
              this.choiceText.equals(other.getChoiceText()))) &&
            ((this.resultsText==null && other.getResultsText()==null) || 
             (this.resultsText!=null &&
              this.resultsText.equals(other.getResultsText()))) &&
            ((this.choicesSelectAllText==null && other.getChoicesSelectAllText()==null) || 
             (this.choicesSelectAllText!=null &&
              this.choicesSelectAllText.equals(other.getChoicesSelectAllText()))) &&
            ((this.choicesDeselectAllText==null && other.getChoicesDeselectAllText()==null) || 
             (this.choicesDeselectAllText!=null &&
              this.choicesDeselectAllText.equals(other.getChoicesDeselectAllText()))) &&
            ((this.resultsSelectAllText==null && other.getResultsSelectAllText()==null) || 
             (this.resultsSelectAllText!=null &&
              this.resultsSelectAllText.equals(other.getResultsSelectAllText()))) &&
            ((this.resultsDeselectAllText==null && other.getResultsDeselectAllText()==null) || 
             (this.resultsDeselectAllText!=null &&
              this.resultsDeselectAllText.equals(other.getResultsDeselectAllText()))) &&
            ((this.deselectText==null && other.getDeselectText()==null) || 
             (this.deselectText!=null &&
              this.deselectText.equals(other.getDeselectText()))) &&
            ((this.removeText==null && other.getRemoveText()==null) || 
             (this.removeText!=null &&
              this.removeText.equals(other.getRemoveText()))) &&
            ((this.insertText==null && other.getInsertText()==null) || 
             (this.insertText!=null &&
              this.insertText.equals(other.getInsertText()))) &&
            ((this.annURL==null && other.getAnnURL()==null) || 
             (this.annURL!=null &&
              this.annURL.equals(other.getAnnURL()))) &&
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getRef() != null) {
            _hashCode += getRef().hashCode();
        }
        if (getStyle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStyle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStyle(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPname() != null) {
            _hashCode += getPname().hashCode();
        }
        if (getReq() != null) {
            _hashCode += getReq().hashCode();
        }
        if (getNoadorn() != null) {
            _hashCode += getNoadorn().hashCode();
        }
        if (getRange() != null) {
            _hashCode += getRange().hashCode();
        }
        if (getMulti() != null) {
            _hashCode += getMulti().hashCode();
        }
        if (getCascadeon() != null) {
            _hashCode += getCascadeon().hashCode();
        }
        if (getPrepopulate() != null) {
            _hashCode += getPrepopulate().hashCode();
        }
        if (getRows() != null) {
            _hashCode += getRows().hashCode();
        }
        if (getDisabled() != null) {
            _hashCode += getDisabled().hashCode();
        }
        if (getNoresults() != null) {
            _hashCode += getNoresults().hashCode();
        }
        if (getMtchany() != null) {
            _hashCode += getMtchany().hashCode();
        }
        if (getMtchall() != null) {
            _hashCode += getMtchall().hashCode();
        }
        if (getShowopt() != null) {
            _hashCode += getShowopt().hashCode();
        }
        if (getSrchval() != null) {
            _hashCode += getSrchval().hashCode();
        }
        if (getNocase() != null) {
            _hashCode += getNocase().hashCode();
        }
        if (getCname() != null) {
            _hashCode += getCname().hashCode();
        }
        if (getSelOptions() != null) {
            _hashCode += getSelOptions().hashCode();
        }
        if (getSelChoices() != null) {
            _hashCode += getSelChoices().hashCode();
        }
        if (getKeywordsText() != null) {
            _hashCode += getKeywordsText().hashCode();
        }
        if (getSearchInstructionsText() != null) {
            _hashCode += getSearchInstructionsText().hashCode();
        }
        if (getChoicesText() != null) {
            _hashCode += getChoicesText().hashCode();
        }
        if (getChoiceText() != null) {
            _hashCode += getChoiceText().hashCode();
        }
        if (getResultsText() != null) {
            _hashCode += getResultsText().hashCode();
        }
        if (getChoicesSelectAllText() != null) {
            _hashCode += getChoicesSelectAllText().hashCode();
        }
        if (getChoicesDeselectAllText() != null) {
            _hashCode += getChoicesDeselectAllText().hashCode();
        }
        if (getResultsSelectAllText() != null) {
            _hashCode += getResultsSelectAllText().hashCode();
        }
        if (getResultsDeselectAllText() != null) {
            _hashCode += getResultsDeselectAllText().hashCode();
        }
        if (getDeselectText() != null) {
            _hashCode += getDeselectText().hashCode();
        }
        if (getRemoveText() != null) {
            _hashCode += getRemoveText().hashCode();
        }
        if (getInsertText() != null) {
            _hashCode += getInsertText().hashCode();
        }
        if (getAnnURL() != null) {
            _hashCode += getAnnURL().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchAndSelectPromptType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SearchAndSelectPromptType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ref");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("style");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "style"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "pname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("req");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "req"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noadorn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "noadorn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("range");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "range"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("multi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "multi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cascadeon");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cascadeon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepopulate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "prepopulate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rows");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "rows"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "IntegerValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disabled");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "disabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "BooleanValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noresults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "noresults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mtchany");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "mtchany"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mtchall");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "mtchall"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showopt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "showopt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("srchval");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "srchval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nocase");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "nocase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "cname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selOptions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "selOptions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PromptSelectionsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selChoices");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "selChoices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PromptSelectionsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordsText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "keywordsText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchInstructionsText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "searchInstructionsText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("choicesText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "choicesText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("choiceText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "choiceText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultsText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "resultsText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("choicesSelectAllText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "choicesSelectAllText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("choicesDeselectAllText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "choicesDeselectAllText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultsSelectAllText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "resultsSelectAllText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultsDeselectAllText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "resultsDeselectAllText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deselectText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "deselectText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("removeText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "removeText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insertText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "insertText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "annURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
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
