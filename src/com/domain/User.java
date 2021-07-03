package com.domain;

import java.io.Serializable;

/**
 * @author aidenli
 */
public class User implements Serializable {
    private Integer uno;
    private String uname;
    private String upass;
    private String truename;

    /**
     * 装载一个用户信息
     * user status 1: ok, 2: not ok
     */
    private String flag;


    public User() {
    }

    public User(Integer uno, String uname, String upass, String truename, String flag) {
        this.uno = uno;
        this.uname = uname;
        this.upass = upass;
        this.truename = truename;
        this.flag = flag;
    }

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
