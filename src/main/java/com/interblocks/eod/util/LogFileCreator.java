/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interblocks.eod.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.interblocks.eod.util.bean.SessionUserBean;

/**
 *
 * @author dimuthu_h
 */
public class LogFileCreator {
    
    public static String WebLogPath = "/opt/ecss/logs/webAppLogs/";

    public static void writeErrorToLog(Throwable aThrowable) {

        BufferedWriter bw = null;
        String msg = "";
        String newLine = "";
        String errpath = WebLogPath + "errors";
        try {

            String filename = Util.getOSLogPath(errpath) + Util.getLocalDate() + "_ECSS_WebApp_error.txt";
            msg = newLine + "\n" + getTime() + "\n" + getStackTrace(aThrowable);
            bw = new BufferedWriter(new FileWriter(filename, true));
            bw.write(msg);
            bw.newLine();
            bw.flush();

        } catch (Exception ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        }
    }
    
    public static void writeInforToLog(String msgIn) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false);
        HttpServletRequest request = attr.getRequest();
        SessionUserBean sub = (SessionUserBean)session.getAttribute("SessionObject");
        
        //HttpSession session = HttpServletRequest.getSession(false);
        //HttpServletRequest request = ServletActionContext.getRequest();
        //SessionUserBean sub = (SessionUserBean) ServletActionContext.getRequest().getSession(false).getAttribute("SessionObject");
        
        String msg,ip;
        ip = request.getRemoteAddr();
        BufferedWriter bw = null;
        String newLine = "";
        String infoPath = WebLogPath+ "infors";
        try {

            String filename = Util.getOSLogPath(infoPath) + Util.getLocalDate() + "_ECSS_WebApp_infor.txt";
            msg = newLine + "\n" + getTime() + "\n" +"   LOGIN USER : "+sub.getUsername()+"  USER IP : "+ip+" "+msgIn;
            bw = new BufferedWriter(new FileWriter(filename, true));
            bw.write(msg);
            bw.newLine();
            bw.flush();

        } catch (Exception ioe) {   
            ioe.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        }
    }



    private static String getTime() {
        GregorianCalendar now = new GregorianCalendar();
        return now.getTime().toString();
    }

    private static String getStackTrace(Throwable aThrowable) throws Exception {
        String re = "";
        Writer result = null;
        PrintWriter printWriter = null;
        try {
            result = new StringWriter();
            printWriter = new PrintWriter(result);

            aThrowable.printStackTrace(printWriter);
            re = result.toString();
            result.close();
            printWriter.close();

        } catch (Exception e) {
            throw e;
        } finally {

            try {
                if (result != null) {
                    result.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }

            } catch (IOException e) {
                throw e;
            }
        }
        return re;
    }
}
