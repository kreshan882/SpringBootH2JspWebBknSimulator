/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interblocks.eod.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.interblocks.eod.model.TrxnBean;

/**
 *
 * @author kreshan
 */

@Service
public class TrxnService {


//    @Autowired
//    TrxnBean user;

//    @Autowired
//    PasswordHashFunction hashFunction;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	TrxnBean user=new TrxnBean();
	
	   public List<TrxnBean> getTrxnList() throws Exception {
		   
	        String query = "select account_no,crd_no,bill_amount,settle_amount,"
	        		+ "account_type,currency_code,trxn_typ,prod_typ,trxn_number from BKN_DX_TRXN_REC"; 
	        List<TrxnBean> actors = jdbcTemplate.query(
	        		query,
	        	    new Object[] {},
	        	    new RowMapper<TrxnBean>() {
	        	        public TrxnBean mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	        	TrxnBean c = new TrxnBean();
		                      c.setAccount_no(rs.getString(1));
		                      c.setCrd_no(rs.getString(2));
		                      c.setBill_amount(rs.getString(3));
		                      c.setSettle_amount(rs.getString(4));
		                      c.setAccount_type(rs.getString(5));
		                      c.setCurrency_code(rs.getString(6));
		                      c.setTrxn_typ(rs.getString(7));
		                      c.setProd_typ(rs.getString(8));
		                      c.setTrxn_number(rs.getString(9));
		        	          return c;
	        	        }
	        	    });
	        return actors;
	        
	    }
	   
	   

	
    public int insertTransaction(TrxnBean trxnBean) {
    	  	
    	System.out.println("==>"+trxnBean.getAccount_no()+":"+trxnBean.getCrd_no()+":"+trxnBean.getBill_amount()+":"+trxnBean.getSettle_amount() );
        return jdbcTemplate.update("Insert into BKN_DX_TRXN_REC( "
				+ "CRD_NO,MASK_CRD_NO,ACCOUNT_NO,ACCOUNT_SERIAL,ACCOUNT_TYPE,"
				+ "CURRENCY_CODE,TRXN_TYP,TRXN_CAT,INT_FEE_TYP,TRXN_STATUS,"
				+ "BILL_AMOUNT,SETTLE_AMOUNT,TRXN_DAYS,TRXN_ADD_DATE,STATEMENT_AGE,"
				+ "BKN_DX_STATUS_CODE,CUST_TYP,PROD_TYP,ISSUE_TYP,PRIMARY_ACCT_NO,"
				+ "PRIMARY_ACCT_SERIAL,BANK_CODE,EOD_SETTRX,EOD_INTCAL,"
				+ "EOD_AUTPAY,EOD_DONE) "
				
				+ "values ("
				+ "?,'458528XX..XX1626',?,'6945',?,"
				+ "?,?,'CHS','INTEREST_FEE',4,"
				+ "?,?,236,to_date('02-AUG-18','DD-MON-RR'),7,"
				+ "1,'CUST',?,'PRNCPL',null,"
				+ "null,'0001',0,0,"
				+ "0,0)",
            new Object[] {
            		trxnBean.getCrd_no(), trxnBean.getAccount_no(),trxnBean.getAccount_type(), trxnBean.getCurrency_code(),
            		trxnBean.getTrxn_typ(), trxnBean.getBill_amount(), trxnBean.getSettle_amount(),  trxnBean.getProd_typ() 
            });
    
    }
    
    public int deleteTransaction(TrxnBean trxnBean, String trxn_number) {
	  	
    	System.out.println("deleted trxn_number ==>"+trxn_number);
        return jdbcTemplate.update("delete FROM BKN_DX_TRXN_REC where TRXN_NUMBER =?",
            new Object[] {
            		trxn_number 
            });
    
    }
//
//    public boolean addNewUser(TrxnBean user) throws Exception {
//    	
//    	
//    	
//    	
////        Connection con = null;
////        PreparedStatement ps = null;
////        boolean insertion = false;
////        try {
////
////            String sql = "INSERT INTO ECSSS_USER(USER_ID,ACTIVATION_METHOD,NAME,MOBILE,USER_PROFILE,STATUS,AUTH_METHOD,APP_PROFILE_ID,EMAIL) VALUES (?,?,?,?,?,?,?,?,?)";
////
////            con = dataSource.getConnection();
////            ps = con.prepareStatement(sql);
////            ps.setString(1, user.getUserID());
////            ps.setString(2, user.getActivationMethod());
////            ps.setString(3, user.getName());
////            ps.setString(4, user.getMobileNo());
////            ps.setInt(5, user.getUserProfile());
////            ps.setString(6, Status.NEW_USER);
////            ps.setString(7, user.getAuthMethod());
////            ps.setInt(8, user.getApplicationProfile());
////            ps.setString(9, user.getEmail());
////
////            if (ps.execute()) {
////                insertion = true;
////            }
////        } catch (Exception e) {
////            throw e;
////        } finally {
////            if (ps != null) {
////                ps.close();
////            }
////            if (con != null) {
////                con.close();
////            }
////        }
//        return true;
//    }
    
 
//
////    @Autowired
////    private TrxnRepository trxnRepository;
////
////    public List<TrxnBean> getAllLectuers(){
////        return trxnRepository.findAll ();
////    }
////    
//    
////    public void getUserDetails(TrxnBean user, String userid) throws Exception{
//////        Connection con = null;
//////        PreparedStatement ps = null;
//////        ResultSet rs = null;
//////        try{
//////            String sql = "SELECT * FROM ECSSS_USER WHERE USER_ID = ?"; 
//////            con = dataSource.getConnection();
//////            ps = con.prepareStatement(sql);
//////            ps.setString(1, userid);
//////            rs = ps.executeQuery();
//////            while (rs.next()) {
//////                user.setUpUserID(userid);
//////                user.setUserID(rs.getString("USER_ID"));
//////                user.setName(rs.getString("NAME"));
//////                user.setMobileNo(rs.getString("MOBILE"));
//////                user.setEmail(rs.getString("EMAIL"));
//////                user.setUserProfile(rs.getInt("USER_PROFILE"));
//////                user.setApplicationProfile(rs.getInt("APP_PROFILE_ID"));
//////                user.setActivationMethod(rs.getString("ACTIVATION_METHOD"));
//////                user.setAuthMethod(rs.getString("AUTH_METHOD"));
//////                user.setStatus(rs.getString("STATUS"));
//////            }
//////
//////        }catch(Exception e){
//////            throw  e;
//////        }finally{
//////            if(rs!=null){
//////                rs.close();
//////            }if(ps!=null){
//////                ps.close();
//////            }if(con!=null){
//////                con.close();
//////            }
//////        }
////    }
////    
////    public boolean updateUser(TrxnBean user) throws Exception{
////        Connection con = null;
////        PreparedStatement ps = null;
////        boolean update = false;
//////        try{
//////            
//////            String sql = "UPDATE ECSSS_USER SET NAME=?,MOBILE=?,EMAIL=?,USER_PROFILE=?,APP_PROFILE_ID=?,ACTIVATION_METHOD=?,AUTH_METHOD=?,STATUS=? WHERE USER_ID=?"; 
//////            
//////            con = dataSource.getConnection();
//////            ps = con.prepareStatement(sql);
//////            ps.setString(1, user.getName());
//////            ps.setString(2, user.getMobileNo());
//////            ps.setString(3, user.getEmail());
//////            ps.setInt(4, user.getUserProfile());
//////            ps.setInt(5, user.getApplicationProfile());
//////            ps.setString(6, user.getActivationMethod());
//////            ps.setString(7, user.getAuthMethod());
//////            ps.setString(8, user.getStatus());
//////            ps.setString(9, user.getUpUserID());
//////            
//////            if(ps.executeUpdate()==1){
//////                update = true;
//////            }
//////        }catch(Exception e){
//////            throw  e;
//////        }finally{
//////            if(ps!=null){
//////                ps.close();
//////            }if(con!=null){
//////                con.close();
//////            }
//////        }
////        return update;
////    }
////    
////     public void deleteUser(TrxnBean user,String userid) throws Exception{
//////        Connection con = null;
//////        PreparedStatement ps = null;
//////        int delete ;
//////        try{
//////            
//////            String sql = "DELETE FROM ECSSS_USER WHERE USER_ID = ?"; 
//////            con = dataSource.getConnection();
//////            con.setAutoCommit(false);
//////            ps = con.prepareStatement(sql);
//////            ps.setString(1, userid);
//////            delete = ps.executeUpdate();
//////            
//////            if(delete==1){
//////                user.setDeleteSucsess(delete);
//////                user.setDeleteMessage("User Deleted Sucsessfully");
//////                con.commit();
//////            }else{
//////                user.setDeleteSucsess(0);
//////                user.setDeleteMessage("User Deleting Error");
//////                con.rollback();
//////            }
//////            
//////        }catch(Exception e){
//////            throw  e;
//////        }finally{
//////            if(ps!=null){
//////                ps.close();
//////            }if(con!=null){
//////                con.close();
//////            }
//////        }
////     }
// 
}
