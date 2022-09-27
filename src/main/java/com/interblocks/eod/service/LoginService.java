/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.interblocks.eod.service;

import com.interblocks.eod.model.TrxnBean;
import com.interblocks.eod.util.Status;
import com.interblocks.eod.util.bean.LoginBean;
import com.interblocks.eod.util.bean.ModuleBean;
import com.interblocks.eod.util.bean.PageBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void createTable() throws Exception{
		System.out.println("start creating table [BKN_DX_TRXN_REC]");
   
		jdbcTemplate.execute("CREATE TABLE BKN_DX_TRXN_REC ("
				+ "TRXN_NUMBER NUMBER(20,0) NOT NULL AUTO_INCREMENT, CRD_NO VARCHAR2(80 BYTE), MASK_CRD_NO VARCHAR2(20 BYTE), ACCOUNT_NO VARCHAR2(30 BYTE),ACCOUNT_SERIAL NUMBER(20,0), "
				+ "ACCOUNT_TYPE VARCHAR2(10 BYTE), CURRENCY_CODE VARCHAR2(3 BYTE), TRXN_TYP VARCHAR2(4 BYTE), TRXN_CAT VARCHAR2(10 BYTE), INT_FEE_TYP VARCHAR2(50 BYTE), "
				+ "TRXN_STATUS NUMBER(2,0), BILL_AMOUNT NUMBER(16,0),SETTLE_AMOUNT NUMBER(16,0), TRXN_DAYS NUMBER(4,0), TRXN_ADD_DATE DATE, "
				+ "STATEMENT_AGE NUMBER(4,0),BKN_DX_STATUS_CODE NUMBER(2,0), CUST_TYP VARCHAR2(20 BYTE), PROD_TYP VARCHAR2(15 BYTE), ISSUE_TYP VARCHAR2(10 BYTE), "
				+ "PRIMARY_ACCT_NO VARCHAR2(30 BYTE), PRIMARY_ACCT_SERIAL NUMBER(20,0), BANK_CODE VARCHAR2(10 BYTE), ADDED_DATE DATE DEFAULT (GETDATE()), EOD_SETTRX NUMBER(1,0), "
				+ "EOD_INTCAL NUMBER(1,0), EOD_AUTPAY NUMBER(1,0), EOD_DONE NUMBER(1,0) )");
			
		System.out.println("End create Table [BKN_DX_TRXN_REC]");
		
        jdbcTemplate.update("Insert into BKN_DX_TRXN_REC( "
				+ "CRD_NO,MASK_CRD_NO,ACCOUNT_NO,ACCOUNT_SERIAL,"
				+ "ACCOUNT_TYPE,CURRENCY_CODE,TRXN_TYP,TRXN_CAT,INT_FEE_TYP,"
				+ "TRXN_STATUS,BILL_AMOUNT,SETTLE_AMOUNT,TRXN_DAYS,TRXN_ADD_DATE,"
				+ "STATEMENT_AGE,BKN_DX_STATUS_CODE,CUST_TYP,PROD_TYP,ISSUE_TYP,"
				+ "PRIMARY_ACCT_NO,PRIMARY_ACCT_SERIAL,BANK_CODE,EOD_SETTRX,"
				+ "EOD_INTCAL,EOD_AUTPAY,EOD_DONE) "
				+ "values ("
				+ "?,'458528XX..XX1626',?,'6945',"
				+ "'CREDIT','144','100','CHS','INTEREST_FEE',"
				+ "4,?,?,236,to_date('02-AUG-18','DD-MON-RR'),"
				+ "7,1,'CUST','PRD562','PRNCPL',"
				+ "null,null,'0001',0,"
				+ "0,0,0)",
				new Object[] {
	            		"1234123412341234", "12345678", "10000", "12000"
	            });
        		//card num | account no | bill amount*100 | settle amount *100

        System.out.println("End insert test row 1");
        
//        jdbcTemplate.execute("CREATE ALIAS MASK_DATA FOR \"com.interblocks.eod.controller.Functions.MASK_DATA\"");
//        System.out.println("End create function [MASK_DATA]");
	}


    public LoginBean getUserDetails(String username){
        LoginBean user = new LoginBean();
                user.setUserName("admin");
                user.setPassword("password");
                user.setStatus("01");
                user.setMobile("0777656565");
                user.setUserProfileId(1);
        return user;
    }


    public List<String> getUserprofilePageidList(int userProfileId) throws SQLException, Exception{
         
        List<String> pageidlist=new ArrayList<String>();
        pageidlist.add("0101");
        pageidlist.add("0102");
        pageidlist.add("0201");
        return pageidlist;
    }

    public Map<ModuleBean, List<PageBean>> getModulePageByUser(int userProfileId) throws Exception {

        Map<ModuleBean, List<PageBean>>  modulePageList = new HashMap<ModuleBean, List<PageBean>>();

        ModuleBean module = new ModuleBean();
            module.setMODULE_ID("01");
            module.setMODULE_NAME("Eod Management");

                    List<PageBean> pageList= pageList = new ArrayList<PageBean>();
                    PageBean page = new PageBean();
                    page.setPAGE_ID("0101");
                    page.setPAGE_NAME("Transaction Post");
                    page.setPAGE_URL("trxnLoad");
                    pageList.add(page);
                    
                    PageBean page2 = new PageBean();
                    page2.setPAGE_ID("0102");
                    page2.setPAGE_NAME("Generate Eod");
                    page2.setPAGE_URL("eodLoad");
                    pageList.add(page2);
                    
                    modulePageList.put(module, pageList);
                    
        return modulePageList;
    }

    public void loadH2Functions() throws Exception{
    	System.out.println("lodding");
//    	Connection con=DriverManager.getConnection("jdbc:h2:mem:testdb", "IBL_D_SIM", "IBL_D_SIM");
//    	System.out.println("con:"+con);
//        Statement stat = con.createStatement();
//
//        // Using a custom Java function
//        stat.execute("CREATE ALIAS IS_PRIME FOR \"org.h2.samples.Function.isPrime\" ");
//        ResultSet rs;
//        rs = stat.executeQuery("SELECT IS_PRIME(X), X FROM SYSTEM_RANGE(1, 20) ORDER BY X");
//        while (rs.next()) {
//            boolean isPrime = rs.getBoolean(1);
//            if (isPrime) {
//                int x = rs.getInt(2);
//                System.out.println(x + " is prime");
//            }
//        }
    }
    
    
    
    //backup kreshan
//	jdbcTemplate.execute("CREATE TABLE Test_K(trxnID INT PRIMARY KEY,  crd_no VARCHAR(255),  bill_amount VARCHAR(255))");
//	
//    jdbcTemplate.update("insert into Test_K(trxnID, crd_no, bill_amount) values('111',  ?, ?)",
//            new Object[] {
//                "1234","1000.00"
//            });
//    
//    String query = "select trxnID,crd_no from Test_K"; 
//
//    //new Object[] {userId, dateFrom, dateTo},//inpit data
//    List<TrxnBean> actors = jdbcTemplate.query(
//    		query,
//    	    new Object[] {},
//    	    new RowMapper<TrxnBean>() {
//    	        public TrxnBean mapRow(ResultSet rs, int rowNum) throws SQLException {
//    	        	TrxnBean c = new TrxnBean();
//    	            c.setTrxnID(rs.getString(1));
//    	            c.setAccount_no(rs.getString(2));
//    	            return c;
//    	        }
//    	    });
//    
//    System.out.println("actors:"+actors.size());
//
//    
//
//
//	jdbcTemplate.execute("CREATE TABLE BKN_DX_TRXN_REC ("
//			+ "TRXN_NUMBER NUMBER(20,0) NOT NULL AUTO_INCREMENT, CRD_NO VARCHAR2(80 BYTE), MASK_CRD_NO VARCHAR2(20 BYTE), ACCOUNT_NO VARCHAR2(30 BYTE),ACCOUNT_SERIAL NUMBER(20,0), "
//			+ "ACCOUNT_TYPE VARCHAR2(10 BYTE), CURRENCY_CODE VARCHAR2(3 BYTE), TRXN_TYP VARCHAR2(4 BYTE), TRXN_CAT VARCHAR2(10 BYTE), INT_FEE_TYP VARCHAR2(50 BYTE), "
//			+ "TRXN_STATUS NUMBER(2,0), BILL_AMOUNT NUMBER(16,0),SETTLE_AMOUNT NUMBER(16,0), TRXN_DAYS NUMBER(4,0), TRXN_ADD_DATE DATE, "
//			+ "STATEMENT_AGE NUMBER(4,0),BKN_DX_STATUS_CODE NUMBER(2,0), CUST_TYP VARCHAR2(20 BYTE), PROD_TYP VARCHAR2(15 BYTE), ISSUE_TYP VARCHAR2(10 BYTE), "
//			+ "PRIMARY_ACCT_NO VARCHAR2(30 BYTE), PRIMARY_ACCT_SERIAL NUMBER(20,0), BANK_CODE VARCHAR2(10 BYTE), ADDED_DATE DATE, EOD_SETTRX NUMBER(1,0), "
//			+ "EOD_INTCAL NUMBER(1,0), EOD_AUTPAY NUMBER(1,0), EOD_DONE NUMBER(1,0) )");
//		
//	System.out.println("End create Table BKN_DX_TRXN_REC");
//	
//    jdbcTemplate.update("Insert into BKN_DX_TRXN_REC( "
//			+ "TRXN_NUMBER,CRD_NO,MASK_CRD_NO,ACCOUNT_NO,ACCOUNT_SERIAL,"
//			+ "ACCOUNT_TYPE,CURRENCY_CODE,TRXN_TYP,TRXN_CAT,INT_FEE_TYP,"
//			+ "TRXN_STATUS,BILL_AMOUNT,SETTLE_AMOUNT,TRXN_DAYS,TRXN_ADD_DATE,"
//			+ "STATEMENT_AGE,BKN_DX_STATUS_CODE,CUST_TYP,PROD_TYP,ISSUE_TYP,"
//			+ "PRIMARY_ACCT_NO,PRIMARY_ACCT_SERIAL,BANK_CODE,ADDED_DATE,EOD_SETTRX,"
//			+ "EOD_INTCAL,EOD_AUTPAY,EOD_DONE) "
//			+ "values ("
//			+ "'480559',?,'458528XX..XX1626',?,'6945',"
//			+ "'CREDIT','144','100','PCH','INTEREST_FEE',"
//			+ "4,?,?,236,to_date('02-AUG-18','DD-MON-RR'),"
//			+ "7,1,'CUST','PRD562','PRNCPL',"
//			+ "null,null,'0001',to_date('26-MAR-19','DD-MON-RR'),0,"
//			+ "0,0,0)",
//			new Object[] {
//            		"ddddd", "ddddd", "11", "12"
//            });
//    
//	jdbcTemplate.execute("Insert into BKN_DX_TRXN_REC( "
//	+ "TRXN_NUMBER,CRD_NO,MASK_CRD_NO,ACCOUNT_NO,ACCOUNT_SERIAL,"
//	+ "ACCOUNT_TYPE,CURRENCY_CODE,TRXN_TYP,TRXN_CAT,INT_FEE_TYP,"
//	+ "TRXN_STATUS,BILL_AMOUNT,SETTLE_AMOUNT,TRXN_DAYS,TRXN_ADD_DATE,"
//	+ "STATEMENT_AGE,BKN_DX_STATUS_CODE,CUST_TYP,PROD_TYP,ISSUE_TYP,"
//	+ "PRIMARY_ACCT_NO,PRIMARY_ACCT_SERIAL,BANK_CODE,ADDED_DATE,EOD_SETTRX,"
//	+ "EOD_INTCAL,EOD_AUTPAY,EOD_DONE) "
//	+ "values ("
//	+ "480559,'001A147824B79736552E170EB0E9AA1ECC4F3EF153F05F048EAE35AE7DA11F4FC8C','458528XX..XX1626','0000039011440000070477',6945,"
//	+ "'CREDIT','144','100','PCH','INTEREST_FEE',"
//	+ "4,100000,50000,236,to_date('02-AUG-18','DD-MON-RR'),"
//	+ "7,1,'CUST','PRD562','PRNCPL',"
//	+ "null,null,'0001',to_date('26-MAR-19','DD-MON-RR'),0,"
//	+ "0,0,0);");
//System.out.println("insert one row");
//
//
//try {
//Connection con=DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
//System.out.println("con:"+con);
//PreparedStatement stat=con.prepareStatement("Insert into BKN_DX_TRXN_REC( "
//		+ "TRXN_NUMBER,CRD_NO,MASK_CRD_NO,ACCOUNT_NO,ACCOUNT_SERIAL,"
//		+ "ACCOUNT_TYPE,CURRENCY_CODE,TRXN_TYP,TRXN_CAT,INT_FEE_TYP,"
//		+ "TRXN_STATUS,BILL_AMOUNT,SETTLE_AMOUNT,TRXN_DAYS,TRXN_ADD_DATE,"
//		+ "STATEMENT_AGE,BKN_DX_STATUS_CODE,CUST_TYP,PROD_TYP,ISSUE_TYP,"
//		+ "PRIMARY_ACCT_NO,PRIMARY_ACCT_SERIAL,BANK_CODE,ADDED_DATE,EOD_SETTRX,"
//		+ "EOD_INTCAL,EOD_AUTPAY,EOD_DONE) "
//		+ "values ("
//		+ "?, '001A147824B79736552E170EB0E9AA1ECC4F3EF153F05F048EAE35AE7DA11F4FC8A','458528XX..XX1626','0000039011440000070477',6945,"
//		+ "'CREDIT','144','100','PCH','INTEREST_FEE',"
//		+ "4,200000,60000,236,to_date('02-AUG-18','DD-MON-RR'),"
//		+ "7,1,'CUST','PRD562','PRNCPL',"
//		+ "null,null,'0001',to_date('26-MAR-19','DD-MON-RR'),0,"
//		+ "0,0,0);");
//stat.setString(1, "111111");
//stat.execute();
////stat.setString(1, "111111");
//System.out.println("table ctete using query");
//
//
//
//} catch (SQLException e) {
//e.printStackTrace();
//}
//System.out.println("insert using jdbcTemplate");
// https://dzone.com/articles/spring-boot-and-spring-jdbc-with-h2
		

}
