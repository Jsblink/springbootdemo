package com.smz.springbootdemo.domain;

public class PortalConfigModel {
    private String paramname;

    private String paramkey;

    private String paramvalue;

    private String paramdesc;

    private Integer version;

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname == null ? null : paramname.trim();
    }

    public String getParamkey() {
        return paramkey;
    }

    public void setParamkey(String paramkey) {
        this.paramkey = paramkey == null ? null : paramkey.trim();
    }

    public String getParamvalue() {
        return paramvalue;
    }

    public void setParamvalue(String paramvalue) {
        this.paramvalue = paramvalue == null ? null : paramvalue.trim();
    }

    public String getParamdesc() {
        return paramdesc;
    }

    public void setParamdesc(String paramdesc) {
        this.paramdesc = paramdesc == null ? null : paramdesc.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}