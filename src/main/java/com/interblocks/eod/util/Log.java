package com.interblocks.eod.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
private static  Logger logger = LogManager.getLogger("com.interblocks.eod");

private static boolean bDebugEnabled = true;


public static int TRACE = Level.TRACE.intLevel();
public static int DEBUG = Level.DEBUG.intLevel();
public static int INFO = Level.INFO.intLevel();
public static int WARN = Level.WARN.intLevel();
public static int ERROR = Level.ERROR.intLevel();
public static int FATAL = Level.FATAL.intLevel();


//----------------------------------------------------------------------------------------------------------------------
static
{
    String sLogger ="com.interblocks.eod";
    if(sLogger != null) logger = LogManager.getLogger(sLogger);

}

//----------------------------------------------------------------------------------------------------------------------
public static void fatal(String sMsg)
{
    try
    {
        logger.fatal(sMsg);
    }
    catch (Exception e)
    {
        System.err.println("LOGGER 'FATAL' STATEMENT PRINTING ERROR.");
        e.printStackTrace();
    }
}

//----------------------------------------------------------------------------------------------------------------------
public static void error(String sMsg)
{
    try
    {
        logger.error(sMsg);
    }
    catch (Exception e)
    {
        System.err.println("LOGGER 'ERROR' STATEMENT PRINTING ERROR.");
        e.printStackTrace();
    }
}

//----------------------------------------------------------------------------------------------------------------------
public static void warn(String sMsg)
{
    try
    {
        logger.warn(sMsg);
    }
    catch (Exception e)
    {
        System.err.println("LOGGER 'WARN' STATEMENT PRINTING ERROR.");
        e.printStackTrace();
    }
}

//----------------------------------------------------------------------------------------------------------------------
public static void info(String sMsg)
{
    try
    {
        logger.info(sMsg);
    }
    catch (Exception e)
    {
        System.err.println("LOGGER 'INFO' STATEMENT PRINTING ERROR.");
        e.printStackTrace();
    }
}

//----------------------------------------------------------------------------------------------------------------------
public static void debug(String sMsg)
{
    if (bDebugEnabled)
    {
        try
        {
            logger.debug(sMsg);
        }
        catch (Exception e)
        {
            System.err.println("LOGGER 'DEBUG' STATEMENT PRINTING ERROR.");
            e.printStackTrace();
        }
    }
}
}