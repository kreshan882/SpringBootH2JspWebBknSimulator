/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interblocks.eod.util;


import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
//import org.jpos.iso.ISOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
public class Util {

    @Autowired
    HttpServletRequest httpServletRequest;


    public static Map<String, String> getAccountList() throws Exception {
        Map<String, String> userProfList = new HashMap<String, String>();
        userProfList.put("CREDIT", "CREDIT");
        userProfList.put("DEBIT", "DEBIT");

        return userProfList;
    }

    public static Map<Integer, String> getEodFunctList() throws Exception {
        Map<Integer, String> eodFunList = new HashMap<Integer, String>();
        eodFunList.put(1, "Cash Interest Calculate");
        eodFunList.put(2, "Retail Interest Calculate");
        eodFunList.put(3, "Settled Transactions");
        eodFunList.put(4, "Auto Pay Run");
        

        return eodFunList;
    }
    
    public static Map<String, String> getCurrencyList() throws Exception {
        Map<String, String> curencyList = new HashMap<String, String>();
        curencyList.put("114", "114");
        curencyList.put("115", "115");

        return curencyList;
    }
    
    public static Map<String, String> getTrxnTypeList() throws Exception {
        Map<String, String> curencyList = new HashMap<String, String>();
        curencyList.put("100", "WITH");
        curencyList.put("102", "DEPO");

        return curencyList;
    }
    
    public static Map<String, String> getProdTypeList() throws Exception {
        Map<String, String> curencyList = new HashMap<String, String>();
        curencyList.put("PRD562", "ATM");
        curencyList.put("PRD563", "POS");

        return curencyList;
    }



    public static Map<String, String> getStatusList() throws Exception {
        Map<String, String> statusList = new HashMap<String, String>();
        statusList.put("01", "Active");
        statusList.put("02", "InActive");

        return statusList;
    }

    public static Date getLocalDate() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        java.sql.Date date2 = new java.sql.Date(d.getTime());
        return date2;
    }

    public static Timestamp getTimeStamp() {
        java.util.Date date = new java.util.Date();
        return new Timestamp(date.getTime());
    }
 
     
    
    public static String getOSLogPath(String logpath) throws Exception {
        String path = null;
        try {
            String linuxPath = logpath + "/";
            String removeFirstSlash = linuxPath.substring(linuxPath.indexOf("/") + 1);
            String removeToSecondSlash = removeFirstSlash.substring(removeFirstSlash.indexOf("/"));
            String conForwordToBack = removeToSecondSlash.replace("/", "\\");
            if (System.getProperty("os.name").startsWith("Windows")) {
                path = "C:" + conForwordToBack;
            } else if (System.getProperty("os.name").startsWith("Linux")) {
                path = linuxPath;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return path;
    }
    


}
