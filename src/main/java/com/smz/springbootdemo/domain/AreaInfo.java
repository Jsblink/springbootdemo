package com.smz.springbootdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "areaInfo")
public class AreaInfo implements Serializable {

    @Id
    @Column(name = "areaid")
    private Integer areaId;
    @Column(name = "areaname")
    private String areaName;
    @Column(name = "areacode")
    private String areaCode;
    @Column(name = "parentid")
    private Integer parentId;
    @Column(name = "tombtime")
    private Integer tombTime;
    private Integer version;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTombTime() {
        return tombTime;
    }

    public void setTombTime(Integer tombTime) {
        this.tombTime = tombTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
