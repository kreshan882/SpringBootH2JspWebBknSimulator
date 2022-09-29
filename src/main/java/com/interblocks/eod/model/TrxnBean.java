/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interblocks.eod.model;

import org.hibernate.validator.constraints.NotEmpty;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

/**
 *
 * @author kreshan
 */


public class TrxnBean {

	
    private String trxn_number;    
    private String crd_no;
    private String mask_crd_no;
    private String account_no;
    private String account_serial;
    
    private String account_type;
    private String currency_code;
    private String trxn_typ;
    private String trxn_cat;
    private String int_fee_typ;
    
    private String trxn_status;
    private String bill_amount;
    private String settle_amount;
    private String trxn_days;
    private String trxn_add_date;
    
    private String statement_age;
    private String bkn_dx_status_code;
    private String cust_typ;
    private String prod_typ;
    private String issue_typ;
    
    private String primary_acct_no;
    private String primary_acct_serial;
    private String bank_code;
    private String added_date;
    private String eod_settrx;
    
    private String eod_intcal;
    private String eod_autpay;
    private String eod_done;
    
//-----------------------------------------------------------

//    private String activationMethod;
//    private String name;
//    private String email;
//    private String mobileNo;
//    private int userProfile;
//    private int applicationProfile;
//    private String firstLoginStatus;
//    private String status;
//    private String authMethod;
//    private String certificate;
//    private String publicKey;
//    private String privateKey;
//    private String timestamp;
//    private String password;
//    private String confirmPassword;
//
//
    private String uptrxn_number;
    private String upaccount_no;
    private String upcrd_no;
    private String upprod_typ;
    
    
    private int deleteSucsess;
    private String deleteMessage;

    
    
//    public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getUptrxn_number() {
		return uptrxn_number;
	}

	public void setUptrxn_number(String uptrxn_number) {
		this.uptrxn_number = uptrxn_number;
	}

	public String getUpaccount_no() {
		return upaccount_no;
	}

	public void setUpaccount_no(String upaccount_no) {
		this.upaccount_no = upaccount_no;
	}

	public String getUpcrd_no() {
		return upcrd_no;
	}

	public void setUpcrd_no(String upcrd_no) {
		this.upcrd_no = upcrd_no;
	}

	public String getUpprod_typ() {
		return upprod_typ;
	}

	public void setUpprod_typ(String upprod_typ) {
		this.upprod_typ = upprod_typ;
	}

	public String getDeleteMessage() {
        return deleteMessage;
    }

    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }
    

    public int getDeleteSucsess() {
        return deleteSucsess;
    }

    public void setDeleteSucsess(int deleteSucsess) {
        this.deleteSucsess = deleteSucsess;
    }



	public String getTrxn_number() {
		return trxn_number;
	}

	public void setTrxn_number(String trxn_number) {
		this.trxn_number = trxn_number;
	}

	public String getCrd_no() {
		return crd_no;
	}

	public void setCrd_no(String crd_no) {
		this.crd_no = crd_no;
	}

	public String getMask_crd_no() {
		return mask_crd_no;
	}

	public void setMask_crd_no(String mask_crd_no) {
		this.mask_crd_no = mask_crd_no;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAccount_serial() {
		return account_serial;
	}

	public void setAccount_serial(String account_serial) {
		this.account_serial = account_serial;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	public String getTrxn_typ() {
		return trxn_typ;
	}

	public void setTrxn_typ(String trxn_typ) {
		this.trxn_typ = trxn_typ;
	}

	public String getTrxn_cat() {
		return trxn_cat;
	}

	public void setTrxn_cat(String trxn_cat) {
		this.trxn_cat = trxn_cat;
	}

	public String getInt_fee_typ() {
		return int_fee_typ;
	}

	public void setInt_fee_typ(String int_fee_typ) {
		this.int_fee_typ = int_fee_typ;
	}

	public String getTrxn_status() {
		return trxn_status;
	}

	public void setTrxn_status(String trxn_status) {
		this.trxn_status = trxn_status;
	}

	public String getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(String bill_amount) {
		this.bill_amount = bill_amount;
	}

	public String getSettle_amount() {
		return settle_amount;
	}

	public void setSettle_amount(String settle_amount) {
		this.settle_amount = settle_amount;
	}

	public String getTrxn_days() {
		return trxn_days;
	}

	public void setTrxn_days(String trxn_days) {
		this.trxn_days = trxn_days;
	}

	public String getTrxn_add_date() {
		return trxn_add_date;
	}

	public void setTrxn_add_date(String trxn_add_date) {
		this.trxn_add_date = trxn_add_date;
	}

	public String getStatement_age() {
		return statement_age;
	}

	public void setStatement_age(String statement_age) {
		this.statement_age = statement_age;
	}

	public String getBkn_dx_status_code() {
		return bkn_dx_status_code;
	}

	public void setBkn_dx_status_code(String bkn_dx_status_code) {
		this.bkn_dx_status_code = bkn_dx_status_code;
	}

	public String getCust_typ() {
		return cust_typ;
	}

	public void setCust_typ(String cust_typ) {
		this.cust_typ = cust_typ;
	}

	public String getProd_typ() {
		return prod_typ;
	}

	public void setProd_typ(String prod_typ) {
		this.prod_typ = prod_typ;
	}

	public String getIssue_typ() {
		return issue_typ;
	}

	public void setIssue_typ(String issue_typ) {
		this.issue_typ = issue_typ;
	}

	public String getPrimary_acct_no() {
		return primary_acct_no;
	}

	public void setPrimary_acct_no(String primary_acct_no) {
		this.primary_acct_no = primary_acct_no;
	}

	public String getPrimary_acct_serial() {
		return primary_acct_serial;
	}

	public void setPrimary_acct_serial(String primary_acct_serial) {
		this.primary_acct_serial = primary_acct_serial;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getAdded_date() {
		return added_date;
	}

	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}

	public String getEod_settrx() {
		return eod_settrx;
	}

	public void setEod_settrx(String eod_settrx) {
		this.eod_settrx = eod_settrx;
	}

	public String getEod_intcal() {
		return eod_intcal;
	}

	public void setEod_intcal(String eod_intcal) {
		this.eod_intcal = eod_intcal;
	}

	public String getEod_autpay() {
		return eod_autpay;
	}

	public void setEod_autpay(String eod_autpay) {
		this.eod_autpay = eod_autpay;
	}

	public String getEod_done() {
		return eod_done;
	}

	public void setEod_done(String eod_done) {
		this.eod_done = eod_done;
	}

  
    
}
