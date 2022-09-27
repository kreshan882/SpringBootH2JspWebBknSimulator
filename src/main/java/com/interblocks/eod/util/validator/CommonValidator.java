/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.interblocks.eod.util.validator;

import java.util.regex.Pattern;


public class CommonValidator {

    public static boolean validateEMPTY(String text) throws Exception { 
        return text.equals("") || text.split(text).equals("") ||  text == null;
    }
    
    public static boolean validateNAME(String text) throws Exception { 
        return text.matches("^[a-zA-Z0-9\\s]+$") &&    text.length() <= 50 ;
    }
    public static boolean validateUSERNAME(String text) throws Exception { 
        return text.matches("^[a-zA-Z_0-9]+$");
    }
    public static boolean validateNUMBER(String numericString) throws Exception { 
        return numericString.matches("^[0-9]*$") && numericString.length() <= 15;
    }
    public static boolean validateEMAIL(String email) throws Exception {  //   VF2
        return email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") &&    email.length() <= 50  ;
    }
    public static boolean validatePHONENO(String numericString) throws Exception { //   VF1
        return numericString.matches("^[0-9]*$") && numericString.length() <= 15;
    }
     public static boolean validateNIC(String nic) {           
        return nic.matches("^[0-9]+[VX]?$")&& nic.length() <= 10;
    }
    public static boolean validateSPECIALCHAR(String specialChars) throws Exception {       // VF5
        return specialChars.matches("[~@#$&!~]+");
    }

    public static boolean validateDESCRIPTION(String text) {                  
        return text.matches("^(.*/)?(?:$|(.+?)(?:(\\.[^.]*$)|$))") &&  text.length() <= 150;
    }
    
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static boolean validateIP(final String ip) {
        return PATTERN.matcher(ip).matches();
    }
    
     public static boolean validateURL(String text) {
        return text.matches("\\b(https?|ftp|file|ldap)://"
                + "[-A-Za-z0-9+&@#/%?=~_|!:,.;]"
                + "*[-A-Za-z0-9+&@#/%=~_|]") && text.length() <= 150;
    }
}
