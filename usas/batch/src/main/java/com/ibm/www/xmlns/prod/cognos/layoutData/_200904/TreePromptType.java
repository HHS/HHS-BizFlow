/**
 * TreePromptType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class TreePromptType  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String[] style;

    private java.lang.String pname;

    private java.lang.Boolean req;

    private java.lang.Boolean noadorn;

    private java.lang.Boolean multi;

    private java.lang.String cascadeon;

    private java.lang.Boolean prepopulate;

    private java.lang.Integer rows;

    private java.lang.Boolean disabled;

    private java.lang.String treeUI;

    /* Number of levels to prepopulate */
    private java.lang.Integer prepopulatelevels;

    private java.lang.Boolean canExpand;

    /* Parent Tree node */
    private TreePromptNodeType node;

    /* False by default */
    private java.lang.Boolean moreData;

    private java.lang.Integer memberDisplayCountDefault;

    private java.lang.Integer memberDisplayCountLimit;

    private java.lang.Integer maximumValueCount;

    private java.lang.Integer skipValueCount;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selOptions;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType ancestors;

    private java.lang.String choicesDeselectAllText;

    private java.lang.String resultsDeselectAllText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public TreePromptType() {
    }

    public TreePromptType(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String[] style,
           java.lang.String pname,
           java.lang.Boolean req,
           java.lang.Boolean noadorn,
           java.lang.Boolean multi,
           java.lang.String cascadeon,
           java.lang.Boolean prepopulate,
           java.lang.Integer rows,
           java.lang.Boolean disabled,
           java.lang.String treeUI,
           java.lang.Integer prepopulatelevels,
           java.lang.Boolean canExpand,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.TreePromptNodeType node,
           java.lang.Boolean moreData,
           java.lang.Integer memberDisplayCountDefault,
           java.lang.Integer memberDisplayCountLimit,
           java.lang.Integer maximumValueCount,
           java.lang.Integer skipValueCount,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selOptions,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType ancestors,
           java.lang.String choicesDeselectAllText,
           java.lang.String resultsDeselectAllText,
           java.lang.String annURL,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
           this.id = id;
           this.ref = ref;
           this.style = style;
           this.pname = pname;
           this.req = req;
           this.noadorn = noadorn;
           this.multi = multi;
           this.cascadeon = cascadeon;
           this.prepopulate = prepopulate;
           this.rows = rows;
           this.disabled = disabled;
           this.treeUI = treeUI;
           this.prepopulatelevels = prepopulatelevels;
           this.canExpand = canExpand;
           this.node = node;
           this.moreData = moreData;
           this.memberDisplayCountDefault = memberDisplayCountDefault;
           this.memberDisplayCountLimit = memberDisplayCountLimit;
           this.maximumValueCount = maximumValueCount;
           this.skipValueCount = skipValueCount;
           this.selOptions = selOptions;
           this.selChoices = selChoices;
           this.ancestors = ancestors;
           this.choicesDeselectAllText = choicesDeselectAllText;
           this.resultsDeselectAllText = resultsDeselectAllText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this TreePromptType.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this TreePromptType.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this TreePromptType.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this TreePromptType.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this TreePromptType.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this TreePromptType.
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
     * Gets the pname value for this TreePromptType.
     * 
     * @return pname
     */
    public java.lang.String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this TreePromptType.
     * 
     * @param pname
     */
    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }


    /**
     * Gets the req value for this TreePromptType.
     * 
     * @return req
     */
    public java.lang.Boolean getReq() {
        return req;
    }


    /**
     * Sets the req value for this TreePromptType.
     * 
     * @param req
     */
    public void setReq(java.lang.Boolean req) {
        this.req = req;
    }


    /**
     * Gets the noadorn value for this TreePromptType.
     * 
     * @return noadorn
     */
    public java.lang.Boolean getNoadorn() {
        return noadorn;
    }


    /**
     * Sets the noadorn value for this TreePromptType.
     * 
     * @param noadorn
     */
    public void setNoadorn(java.lang.Boolean noadorn) {
        this.noadorn = noadorn;
    }


    /**
     * Gets the multi value for this TreePromptType.
     * 
     * @return multi
     */
    public java.lang.Boolean getMulti() {
        return multi;
    }


    /**
     * Sets the multi value for this TreePromptType.
     * 
     * @param multi
     */
    public void setMulti(java.lang.Boolean multi) {
        this.multi = multi;
    }


    /**
     * Gets the cascadeon value for this TreePromptType.
     * 
     * @return cascadeon
     */
    public java.lang.String getCascadeon() {
        return cascadeon;
    }


    /**
     * Sets the cascadeon value for this TreePromptType.
     * 
     * @param cascadeon
     */
    public void setCascadeon(java.lang.String cascadeon) {
        this.cascadeon = cascadeon;
    }


    /**
     * Gets the prepopulate value for this TreePromptType.
     * 
     * @return prepopulate
     */
    public java.lang.Boolean getPrepopulate() {
        return prepopulate;
    }


    /**
     * Sets the prepopulate value for this TreePromptType.
     * 
     * @param prepopulate
     */
    public void setPrepopulate(java.lang.Boolean prepopulate) {
        this.prepopulate = prepopulate;
    }


    /**
     * Gets the rows value for this TreePromptType.
     * 
     * @return rows
     */
    public java.lang.Integer getRows() {
        return rows;
    }


    /**
     * Sets the rows value for this TreePromptType.
     * 
     * @param rows
     */
    public void setRows(java.lang.Integer rows) {
        this.rows = rows;
    }


    /**
     * Gets the disabled value for this TreePromptType.
     * 
     * @return disabled
     */
    public java.lang.Boolean getDisabled() {
        return disabled;
    }


    /**
     * Sets the disabled value for this TreePromptType.
     * 
     * @param disabled
     */
    public void setDisabled(java.lang.Boolean disabled) {
        this.disabled = disabled;
    }


    /**
     * Gets the treeUI value for this TreePromptType.
     * 
     * @return treeUI
     */
    public java.lang.String getTreeUI() {
        return treeUI;
    }


    /**
     * Sets the treeUI value for this TreePromptType.
     * 
     * @param treeUI
     */
    public void setTreeUI(java.lang.String treeUI) {
        this.treeUI = treeUI;
    }


    /**
     * Gets the prepopulatelevels value for this TreePromptType.
     * 
     * @return prepopulatelevels   * Number of levels to prepopulate
     */
    public java.lang.Integer getPrepopulatelevels() {
        return prepopulatelevels;
    }


    /**
     * Sets the prepopulatelevels value for this TreePromptType.
     * 
     * @param prepopulatelevels   * Number of levels to prepopulate
     */
    public void setPrepopulatelevels(java.lang.Integer prepopulatelevels) {
        this.prepopulatelevels = prepopulatelevels;
    }


    /**
     * Gets the canExpand value for this TreePromptType.
     * 
     * @return canExpand
     */
    public java.lang.Boolean getCanExpand() {
        return canExpand;
    }


    /**
     * Sets the canExpand value for this TreePromptType.
     * 
     * @param canExpand
     */
    public void setCanExpand(java.lang.Boolean canExpand) {
        this.canExpand = canExpand;
    }


    /**
     * Gets the node value for this TreePromptType.
     * 
     * @return node   * Parent Tree node
     */
    public TreePromptNodeType getNode() {
        return node;
    }


    /**
     * Sets the node value for this TreePromptType.
     * 
     * @param node   * Parent Tree node
     */
    public void setNode(com.ibm.www.xmlns.prod.cognos.layoutData._200904.TreePromptNodeType node) {
        this.node = node;
    }


    /**
     * Gets the moreData value for this TreePromptType.
     * 
     * @return moreData   * False by default
     */
    public java.lang.Boolean getMoreData() {
        return moreData;
    }


    /**
     * Sets the moreData value for this TreePromptType.
     * 
     * @param moreData   * False by default
     */
    public void setMoreData(java.lang.Boolean moreData) {
        this.moreData = moreData;
    }


    /**
     * Gets the memberDisplayCountDefault value for this TreePromptType.
     * 
     * @return memberDisplayCountDefault
     */
    public java.lang.Integer getMemberDisplayCountDefault() {
        return memberDisplayCountDefault;
    }


    /**
     * Sets the memberDisplayCountDefault value for this TreePromptType.
     * 
     * @param memberDisplayCountDefault
     */
    public void setMemberDisplayCountDefault(java.lang.Integer memberDisplayCountDefault) {
        this.memberDisplayCountDefault = memberDisplayCountDefault;
    }


    /**
     * Gets the memberDisplayCountLimit value for this TreePromptType.
     * 
     * @return memberDisplayCountLimit
     */
    public java.lang.Integer getMemberDisplayCountLimit() {
        return memberDisplayCountLimit;
    }


    /**
     * Sets the memberDisplayCountLimit value for this TreePromptType.
     * 
     * @param memberDisplayCountLimit
     */
    public void setMemberDisplayCountLimit(java.lang.Integer memberDisplayCountLimit) {
        this.memberDisplayCountLimit = memberDisplayCountLimit;
    }


    /**
     * Gets the maximumValueCount value for this TreePromptType.
     * 
     * @return maximumValueCount
     */
    public java.lang.Integer getMaximumValueCount() {
        return maximumValueCount;
    }


    /**
     * Sets the maximumValueCount value for this TreePromptType.
     * 
     * @param maximumValueCount
     */
    public void setMaximumValueCount(java.lang.Integer maximumValueCount) {
        this.maximumValueCount = maximumValueCount;
    }


    /**
     * Gets the skipValueCount value for this TreePromptType.
     * 
     * @return skipValueCount
     */
    public java.lang.Integer getSkipValueCount() {
        return skipValueCount;
    }


    /**
     * Sets the skipValueCount value for this TreePromptType.
     * 
     * @param skipValueCount
     */
    public void setSkipValueCount(java.lang.Integer skipValueCount) {
        this.skipValueCount = skipValueCount;
    }


    /**
     * Gets the selOptions value for this TreePromptType.
     * 
     * @return selOptions
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType getSelOptions() {
        return selOptions;
    }


    /**
     * Sets the selOptions value for this TreePromptType.
     * 
     * @param selOptions
     */
    public void setSelOptions(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selOptions) {
        this.selOptions = selOptions;
    }


    /**
     * Gets the selChoices value for this TreePromptType.
     * 
     * @return selChoices
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType getSelChoices() {
        return selChoices;
    }


    /**
     * Sets the selChoices value for this TreePromptType.
     * 
     * @param selChoices
     */
    public void setSelChoices(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices) {
        this.selChoices = selChoices;
    }


    /**
     * Gets the ancestors value for this TreePromptType.
     * 
     * @return ancestors
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType getAncestors() {
        return ancestors;
    }


    /**
     * Sets the ancestors value for this TreePromptType.
     * 
     * @param ancestors
     */
    public void setAncestors(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType ancestors) {
        this.ancestors = ancestors;
    }


    /**
     * Gets the choicesDeselectAllText value for this TreePromptType.
     * 
     * @return choicesDeselectAllText
     */
    public java.lang.String getChoicesDeselectAllText() {
        return choicesDeselectAllText;
    }


    /**
     * Sets the choicesDeselectAllText value for this TreePromptType.
     * 
     * @param choicesDeselectAllText
     */
    public void setChoicesDeselectAllText(java.lang.String choicesDeselectAllText) {
        this.choicesDeselectAllText = choicesDeselectAllText;
    }


    /**
     * Gets the resultsDeselectAllText value for this TreePromptType.
     * 
     * @return resultsDeselectAllText
     */
    public java.lang.String getResultsDeselectAllText() {
        return resultsDeselectAllText;
    }


    /**
     * Sets the resultsDeselectAllText value for this TreePromptType.
     * 
     * @param resultsDeselectAllText
     */
    public void setResultsDeselectAllText(java.lang.String resultsDeselectAllText) {
        this.resultsDeselectAllText = resultsDeselectAllText;
    }


    /**
     * Gets the annURL value for this TreePromptType.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this TreePromptType.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this TreePromptType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this TreePromptType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TreePromptType)) return false;
        TreePromptType other = (TreePromptType) obj;
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
            ((this.treeUI==null && other.getTreeUI()==null) || 
             (this.treeUI!=null &&
              this.treeUI.equals(other.getTreeUI()))) &&
            ((this.prepopulatelevels==null && other.getPrepopulatelevels()==null) || 
             (this.prepopulatelevels!=null &&
              this.prepopulatelevels.equals(other.getPrepopulatelevels()))) &&
            ((this.canExpand==null && other.getCanExpand()==null) || 
             (this.canExpand!=null &&
              this.canExpand.equals(other.getCanExpand()))) &&
            ((this.node==null && other.getNode()==null) || 
             (this.node!=null &&
              this.node.equals(other.getNode()))) &&
            ((this.moreData==null && other.getMoreData()==null) || 
             (this.moreData!=null &&
              this.moreData.equals(other.getMoreData()))) &&
            ((this.memberDisplayCountDefault==null && other.getMemberDisplayCountDefault()==null) || 
             (this.memberDisplayCountDefault!=null &&
              this.memberDisplayCountDefault.equals(other.getMemberDisplayCountDefault()))) &&
            ((this.memberDisplayCountLimit==null && other.getMemberDisplayCountLimit()==null) || 
             (this.memberDisplayCountLimit!=null &&
              this.memberDisplayCountLimit.equals(other.getMemberDisplayCountLimit()))) &&
            ((this.maximumValueCount==null && other.getMaximumValueCount()==null) || 
             (this.maximumValueCount!=null &&
              this.maximumValueCount.equals(other.getMaximumValueCount()))) &&
            ((this.skipValueCount==null && other.getSkipValueCount()==null) || 
             (this.skipValueCount!=null &&
              this.skipValueCount.equals(other.getSkipValueCount()))) &&
            ((this.selOptions==null && other.getSelOptions()==null) || 
             (this.selOptions!=null &&
              this.selOptions.equals(other.getSelOptions()))) &&
            ((this.selChoices==null && other.getSelChoices()==null) || 
             (this.selChoices!=null &&
              this.selChoices.equals(other.getSelChoices()))) &&
            ((this.ancestors==null && other.getAncestors()==null) || 
             (this.ancestors!=null &&
              this.ancestors.equals(other.getAncestors()))) &&
            ((this.choicesDeselectAllText==null && other.getChoicesDeselectAllText()==null) || 
             (this.choicesDeselectAllText!=null &&
              this.choicesDeselectAllText.equals(other.getChoicesDeselectAllText()))) &&
            ((this.resultsDeselectAllText==null && other.getResultsDeselectAllText()==null) || 
             (this.resultsDeselectAllText!=null &&
              this.resultsDeselectAllText.equals(other.getResultsDeselectAllText()))) &&
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
        if (getTreeUI() != null) {
            _hashCode += getTreeUI().hashCode();
        }
        if (getPrepopulatelevels() != null) {
            _hashCode += getPrepopulatelevels().hashCode();
        }
        if (getCanExpand() != null) {
            _hashCode += getCanExpand().hashCode();
        }
        if (getNode() != null) {
            _hashCode += getNode().hashCode();
        }
        if (getMoreData() != null) {
            _hashCode += getMoreData().hashCode();
        }
        if (getMemberDisplayCountDefault() != null) {
            _hashCode += getMemberDisplayCountDefault().hashCode();
        }
        if (getMemberDisplayCountLimit() != null) {
            _hashCode += getMemberDisplayCountLimit().hashCode();
        }
        if (getMaximumValueCount() != null) {
            _hashCode += getMaximumValueCount().hashCode();
        }
        if (getSkipValueCount() != null) {
            _hashCode += getSkipValueCount().hashCode();
        }
        if (getSelOptions() != null) {
            _hashCode += getSelOptions().hashCode();
        }
        if (getSelChoices() != null) {
            _hashCode += getSelChoices().hashCode();
        }
        if (getAncestors() != null) {
            _hashCode += getAncestors().hashCode();
        }
        if (getChoicesDeselectAllText() != null) {
            _hashCode += getChoicesDeselectAllText().hashCode();
        }
        if (getResultsDeselectAllText() != null) {
            _hashCode += getResultsDeselectAllText().hashCode();
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
        new org.apache.axis.description.TypeDesc(TreePromptType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TreePromptType"));
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
        elemField.setFieldName("treeUI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "treeUI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepopulatelevels");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "prepopulatelevels"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canExpand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "canExpand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("node");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "node"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "TreePromptNodeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moreData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "moreData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberDisplayCountDefault");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "memberDisplayCountDefault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("memberDisplayCountLimit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "memberDisplayCountLimit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maximumValueCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "maximumValueCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skipValueCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "skipValueCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("ancestors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ancestors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PromptSelectionsType"));
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
        elemField.setFieldName("resultsDeselectAllText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "resultsDeselectAllText"));
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
