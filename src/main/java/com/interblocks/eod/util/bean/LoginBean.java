/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.interblocks.eod.util.bean;


public class LoginBean {
    private String userName;
    private String password;
    
    private String newpassword;
    private String otppassword;
    private String mobile;
    private int userProfileId;

    private String status;
    
    private String error;
    
    
    public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(int userProfileId) {
        this.userProfileId = userProfileId;
    }

    
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getOtppassword() {
        return otppassword;
    }

    public void setOtppassword(String otppassword) {
        this.otppassword = otppassword;
    }
    
    
}
