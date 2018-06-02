/**
 * SelectDatePromptType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.xmlns.prod.cognos.layoutData._200904;

public class SelectDatePromptType  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String ref;

    private java.lang.String[] style;

    private java.lang.String pname;

    private java.lang.Boolean req;

    private java.lang.Boolean noadorn;

    private java.lang.Boolean range;

    private java.lang.Boolean multi;

    private java.lang.String dateUI;

    private java.lang.String clndr;

    /* First possible date */
    private java.util.Date fdate;

    /* Last possible date */
    private java.util.Date ldate;

    private java.lang.String cname;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices;

    private java.lang.String choicesText;

    private java.lang.String fromText;

    private java.lang.String toText;

    private java.lang.String lowestValueText;

    private java.lang.String highestValueText;

    private java.lang.String choicesSelectAllText;

    private java.lang.String choicesDeselectAllText;

    private java.lang.String removeText;

    private java.lang.String insertText;

    private java.lang.String annURL;

    private com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension;

    public SelectDatePromptType() {
    }

    public SelectDatePromptType(
           java.lang.String id,
           java.lang.String ref,
           java.lang.String[] style,
           java.lang.String pname,
           java.lang.Boolean req,
           java.lang.Boolean noadorn,
           java.lang.Boolean range,
           java.lang.Boolean multi,
           java.lang.String dateUI,
           java.lang.String clndr,
           java.util.Date fdate,
           java.util.Date ldate,
           java.lang.String cname,
           com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices,
           java.lang.String choicesText,
           java.lang.String fromText,
           java.lang.String toText,
           java.lang.String lowestValueText,
           java.lang.String highestValueText,
           java.lang.String choicesSelectAllText,
           java.lang.String choicesDeselectAllText,
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
           this.dateUI = dateUI;
           this.clndr = clndr;
           this.fdate = fdate;
           this.ldate = ldate;
           this.cname = cname;
           this.selChoices = selChoices;
           this.choicesText = choicesText;
           this.fromText = fromText;
           this.toText = toText;
           this.lowestValueText = lowestValueText;
           this.highestValueText = highestValueText;
           this.choicesSelectAllText = choicesSelectAllText;
           this.choicesDeselectAllText = choicesDeselectAllText;
           this.removeText = removeText;
           this.insertText = insertText;
           this.annURL = annURL;
           this.extension = extension;
    }


    /**
     * Gets the id value for this SelectDatePromptType.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this SelectDatePromptType.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the ref value for this SelectDatePromptType.
     * 
     * @return ref
     */
    public java.lang.String getRef() {
        return ref;
    }


    /**
     * Sets the ref value for this SelectDatePromptType.
     * 
     * @param ref
     */
    public void setRef(java.lang.String ref) {
        this.ref = ref;
    }


    /**
     * Gets the style value for this SelectDatePromptType.
     * 
     * @return style
     */
    public java.lang.String[] getStyle() {
        return style;
    }


    /**
     * Sets the style value for this SelectDatePromptType.
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
     * Gets the pname value for this SelectDatePromptType.
     * 
     * @return pname
     */
    public java.lang.String getPname() {
        return pname;
    }


    /**
     * Sets the pname value for this SelectDatePromptType.
     * 
     * @param pname
     */
    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }


    /**
     * Gets the req value for this SelectDatePromptType.
     * 
     * @return req
     */
    public java.lang.Boolean getReq() {
        return req;
    }


    /**
     * Sets the req value for this SelectDatePromptType.
     * 
     * @param req
     */
    public void setReq(java.lang.Boolean req) {
        this.req = req;
    }


    /**
     * Gets the noadorn value for this SelectDatePromptType.
     * 
     * @return noadorn
     */
    public java.lang.Boolean getNoadorn() {
        return noadorn;
    }


    /**
     * Sets the noadorn value for this SelectDatePromptType.
     * 
     * @param noadorn
     */
    public void setNoadorn(java.lang.Boolean noadorn) {
        this.noadorn = noadorn;
    }


    /**
     * Gets the range value for this SelectDatePromptType.
     * 
     * @return range
     */
    public java.lang.Boolean getRange() {
        return range;
    }


    /**
     * Sets the range value for this SelectDatePromptType.
     * 
     * @param range
     */
    public void setRange(java.lang.Boolean range) {
        this.range = range;
    }


    /**
     * Gets the multi value for this SelectDatePromptType.
     * 
     * @return multi
     */
    public java.lang.Boolean getMulti() {
        return multi;
    }


    /**
     * Sets the multi value for this SelectDatePromptType.
     * 
     * @param multi
     */
    public void setMulti(java.lang.Boolean multi) {
        this.multi = multi;
    }


    /**
     * Gets the dateUI value for this SelectDatePromptType.
     * 
     * @return dateUI
     */
    public java.lang.String getDateUI() {
        return dateUI;
    }


    /**
     * Sets the dateUI value for this SelectDatePromptType.
     * 
     * @param dateUI
     */
    public void setDateUI(java.lang.String dateUI) {
        this.dateUI = dateUI;
    }


    /**
     * Gets the clndr value for this SelectDatePromptType.
     * 
     * @return clndr
     */
    public java.lang.String getClndr() {
        return clndr;
    }


    /**
     * Sets the clndr value for this SelectDatePromptType.
     * 
     * @param clndr
     */
    public void setClndr(java.lang.String clndr) {
        this.clndr = clndr;
    }


    /**
     * Gets the fdate value for this SelectDatePromptType.
     * 
     * @return fdate   * First possible date
     */
    public java.util.Date getFdate() {
        return fdate;
    }


    /**
     * Sets the fdate value for this SelectDatePromptType.
     * 
     * @param fdate   * First possible date
     */
    public void setFdate(java.util.Date fdate) {
        this.fdate = fdate;
    }


    /**
     * Gets the ldate value for this SelectDatePromptType.
     * 
     * @return ldate   * Last possible date
     */
    public java.util.Date getLdate() {
        return ldate;
    }


    /**
     * Sets the ldate value for this SelectDatePromptType.
     * 
     * @param ldate   * Last possible date
     */
    public void setLdate(java.util.Date ldate) {
        this.ldate = ldate;
    }


    /**
     * Gets the cname value for this SelectDatePromptType.
     * 
     * @return cname
     */
    public java.lang.String getCname() {
        return cname;
    }


    /**
     * Sets the cname value for this SelectDatePromptType.
     * 
     * @param cname
     */
    public void setCname(java.lang.String cname) {
        this.cname = cname;
    }


    /**
     * Gets the selChoices value for this SelectDatePromptType.
     * 
     * @return selChoices
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType getSelChoices() {
        return selChoices;
    }


    /**
     * Sets the selChoices value for this SelectDatePromptType.
     * 
     * @param selChoices
     */
    public void setSelChoices(com.ibm.www.xmlns.prod.cognos.layoutData._200904.PromptSelectionsType selChoices) {
        this.selChoices = selChoices;
    }


    /**
     * Gets the choicesText value for this SelectDatePromptType.
     * 
     * @return choicesText
     */
    public java.lang.String getChoicesText() {
        return choicesText;
    }


    /**
     * Sets the choicesText value for this SelectDatePromptType.
     * 
     * @param choicesText
     */
    public void setChoicesText(java.lang.String choicesText) {
        this.choicesText = choicesText;
    }


    /**
     * Gets the fromText value for this SelectDatePromptType.
     * 
     * @return fromText
     */
    public java.lang.String getFromText() {
        return fromText;
    }


    /**
     * Sets the fromText value for this SelectDatePromptType.
     * 
     * @param fromText
     */
    public void setFromText(java.lang.String fromText) {
        this.fromText = fromText;
    }


    /**
     * Gets the toText value for this SelectDatePromptType.
     * 
     * @return toText
     */
    public java.lang.String getToText() {
        return toText;
    }


    /**
     * Sets the toText value for this SelectDatePromptType.
     * 
     * @param toText
     */
    public void setToText(java.lang.String toText) {
        this.toText = toText;
    }


    /**
     * Gets the lowestValueText value for this SelectDatePromptType.
     * 
     * @return lowestValueText
     */
    public java.lang.String getLowestValueText() {
        return lowestValueText;
    }


    /**
     * Sets the lowestValueText value for this SelectDatePromptType.
     * 
     * @param lowestValueText
     */
    public void setLowestValueText(java.lang.String lowestValueText) {
        this.lowestValueText = lowestValueText;
    }


    /**
     * Gets the highestValueText value for this SelectDatePromptType.
     * 
     * @return highestValueText
     */
    public java.lang.String getHighestValueText() {
        return highestValueText;
    }


    /**
     * Sets the highestValueText value for this SelectDatePromptType.
     * 
     * @param highestValueText
     */
    public void setHighestValueText(java.lang.String highestValueText) {
        this.highestValueText = highestValueText;
    }


    /**
     * Gets the choicesSelectAllText value for this SelectDatePromptType.
     * 
     * @return choicesSelectAllText
     */
    public java.lang.String getChoicesSelectAllText() {
        return choicesSelectAllText;
    }


    /**
     * Sets the choicesSelectAllText value for this SelectDatePromptType.
     * 
     * @param choicesSelectAllText
     */
    public void setChoicesSelectAllText(java.lang.String choicesSelectAllText) {
        this.choicesSelectAllText = choicesSelectAllText;
    }


    /**
     * Gets the choicesDeselectAllText value for this SelectDatePromptType.
     * 
     * @return choicesDeselectAllText
     */
    public java.lang.String getChoicesDeselectAllText() {
        return choicesDeselectAllText;
    }


    /**
     * Sets the choicesDeselectAllText value for this SelectDatePromptType.
     * 
     * @param choicesDeselectAllText
     */
    public void setChoicesDeselectAllText(java.lang.String choicesDeselectAllText) {
        this.choicesDeselectAllText = choicesDeselectAllText;
    }


    /**
     * Gets the removeText value for this SelectDatePromptType.
     * 
     * @return removeText
     */
    public java.lang.String getRemoveText() {
        return removeText;
    }


    /**
     * Sets the removeText value for this SelectDatePromptType.
     * 
     * @param removeText
     */
    public void setRemoveText(java.lang.String removeText) {
        this.removeText = removeText;
    }


    /**
     * Gets the insertText value for this SelectDatePromptType.
     * 
     * @return insertText
     */
    public java.lang.String getInsertText() {
        return insertText;
    }


    /**
     * Sets the insertText value for this SelectDatePromptType.
     * 
     * @param insertText
     */
    public void setInsertText(java.lang.String insertText) {
        this.insertText = insertText;
    }


    /**
     * Gets the annURL value for this SelectDatePromptType.
     * 
     * @return annURL
     */
    public java.lang.String getAnnURL() {
        return annURL;
    }


    /**
     * Sets the annURL value for this SelectDatePromptType.
     * 
     * @param annURL
     */
    public void setAnnURL(java.lang.String annURL) {
        this.annURL = annURL;
    }


    /**
     * Gets the extension value for this SelectDatePromptType.
     * 
     * @return extension
     */
    public com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this SelectDatePromptType.
     * 
     * @param extension
     */
    public void setExtension(com.ibm.www.xmlns.prod.cognos.layoutData._200904.Extension extension) {
        this.extension = extension;
    }

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SelectDatePromptType)) return false;
        SelectDatePromptType other = (SelectDatePromptType) obj;
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
            ((this.dateUI==null && other.getDateUI()==null) || 
             (this.dateUI!=null &&
              this.dateUI.equals(other.getDateUI()))) &&
            ((this.clndr==null && other.getClndr()==null) || 
             (this.clndr!=null &&
              this.clndr.equals(other.getClndr()))) &&
            ((this.fdate==null && other.getFdate()==null) || 
             (this.fdate!=null &&
              this.fdate.equals(other.getFdate()))) &&
            ((this.ldate==null && other.getLdate()==null) || 
             (this.ldate!=null &&
              this.ldate.equals(other.getLdate()))) &&
            ((this.cname==null && other.getCname()==null) || 
             (this.cname!=null &&
              this.cname.equals(other.getCname()))) &&
            ((this.selChoices==null && other.getSelChoices()==null) || 
             (this.selChoices!=null &&
              this.selChoices.equals(other.getSelChoices()))) &&
            ((this.choicesText==null && other.getChoicesText()==null) || 
             (this.choicesText!=null &&
              this.choicesText.equals(other.getChoicesText()))) &&
            ((this.fromText==null && other.getFromText()==null) || 
             (this.fromText!=null &&
              this.fromText.equals(other.getFromText()))) &&
            ((this.toText==null && other.getToText()==null) || 
             (this.toText!=null &&
              this.toText.equals(other.getToText()))) &&
            ((this.lowestValueText==null && other.getLowestValueText()==null) || 
             (this.lowestValueText!=null &&
              this.lowestValueText.equals(other.getLowestValueText()))) &&
            ((this.highestValueText==null && other.getHighestValueText()==null) || 
             (this.highestValueText!=null &&
              this.highestValueText.equals(other.getHighestValueText()))) &&
            ((this.choicesSelectAllText==null && other.getChoicesSelectAllText()==null) || 
             (this.choicesSelectAllText!=null &&
              this.choicesSelectAllText.equals(other.getChoicesSelectAllText()))) &&
            ((this.choicesDeselectAllText==null && other.getChoicesDeselectAllText()==null) || 
             (this.choicesDeselectAllText!=null &&
              this.choicesDeselectAllText.equals(other.getChoicesDeselectAllText()))) &&
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
        if (getDateUI() != null) {
            _hashCode += getDateUI().hashCode();
        }
        if (getClndr() != null) {
            _hashCode += getClndr().hashCode();
        }
        if (getFdate() != null) {
            _hashCode += getFdate().hashCode();
        }
        if (getLdate() != null) {
            _hashCode += getLdate().hashCode();
        }
        if (getCname() != null) {
            _hashCode += getCname().hashCode();
        }
        if (getSelChoices() != null) {
            _hashCode += getSelChoices().hashCode();
        }
        if (getChoicesText() != null) {
            _hashCode += getChoicesText().hashCode();
        }
        if (getFromText() != null) {
            _hashCode += getFromText().hashCode();
        }
        if (getToText() != null) {
            _hashCode += getToText().hashCode();
        }
        if (getLowestValueText() != null) {
            _hashCode += getLowestValueText().hashCode();
        }
        if (getHighestValueText() != null) {
            _hashCode += getHighestValueText().hashCode();
        }
        if (getChoicesSelectAllText() != null) {
            _hashCode += getChoicesSelectAllText().hashCode();
        }
        if (getChoicesDeselectAllText() != null) {
            _hashCode += getChoicesDeselectAllText().hashCode();
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
        new org.apache.axis.description.TypeDesc(SelectDatePromptType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "SelectDatePromptType"));
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
        elemField.setFieldName("dateUI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "dateUI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">dateUI"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clndr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "clndr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", ">clndr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fdate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "fdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ldate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "ldate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
        elemField.setFieldName("selChoices");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "selChoices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "PromptSelectionsType"));
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
        elemField.setFieldName("fromText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "fromText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "toText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowestValueText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "lowestValueText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "StringValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highestValueText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/xmlns/prod/cognos/layoutData/200904", "highestValueText"));
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
