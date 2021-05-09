package com.smz.springbootdemo.generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * subscriberinfo
 * @author 
 */
@Data
public class Subscriberinfo implements Serializable {
    private Integer usersn;

    private String userid;

    private String username;

    private Byte userstate;

    private String telnumber;

    private Date firstlogintime;

    private Integer areaid;

    private Integer groupid;

    private String password;

    private Byte operatetype;

    private Integer tombtime;

    private Integer version;

    private Integer areaId;

    private Integer tombTime;

    private static final long serialVersionUID = 1L;
}