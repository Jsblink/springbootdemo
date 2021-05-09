package com.smz.springbootdemo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="subscriberinfo")
public class SubscriberInfo implements Serializable {


    private static final long serialVersionUID = 4500072892425294181L;
    //必须得有ID，否则No identifier specified for entity: com.smz.springbootdemo.domain.SubscriberInfo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usersn", insertable = false, updatable = false)
    private Integer usersn;

    @Column(name = "userid", nullable = false)
    private  String	userId;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "telnumber")
    private String telnumber;

    private  Integer userstate;

    private  String firstlogintime;

    @Column(name = "areaid", insertable = false, updatable = false)
    private Integer areaId;

    @OneToOne
    @JoinColumn(name = "areaid", referencedColumnName = "areaid")
    private  AreaInfo areaInfo;

    private  Integer groupid;

    private  String	password;

    @Column(name = "operatetype")
    private  Integer operateType;

    @Column(name = "tombTime")
    private  Integer tombTime;

    private  Integer version;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserstate() {
        return userstate;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    public String getFirstlogintime() {
        return firstlogintime;
    }

    public void setFirstlogintime(String firstlogintime) {
        this.firstlogintime = firstlogintime;
    }



    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Integer getTombtime() {
        return tombTime;
    }

    public void setTombtime(Integer tombtime) {
        this.tombTime = tombtime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getUsersn() {
        return usersn;
    }

    public void setUsersn(Integer usersn) {
        this.usersn = usersn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    @Override
    public String toString() {
        return "SubscriberInfo{" +
                "usersn=" + usersn +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", telnumber='" + telnumber + '\'' +
                ", userstate=" + userstate +
                ", firstlogintime='" + firstlogintime + '\'' +
                ", areaId=" + areaId +
                ", groupid=" + groupid +
                ", password='" + password + '\'' +
                ", operateType=" + operateType +
                ", tombTime=" + tombTime +
                ", version=" + version +
                '}';
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public AreaInfo getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(AreaInfo areaInfo) {
        this.areaInfo = areaInfo;
    }

    public Integer getTombTime() {
        return tombTime;
    }

    public void setTombTime(Integer tombTime) {
        this.tombTime = tombTime;
    }

}
