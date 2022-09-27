package com.interblocks.eod.controller;

import java.sql.Connection;
import java.sql.SQLException;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;


//https://stackoverflow.com/questions/17293598/how-to-write-a-function-in-the-h2-database-without-using-java
//create procudure= functions
//CREATE ALIAS countBooks FOR "com.interblocks.eod.controller.Functions.countBooks";
//CREATE ALIAS MASK_DATA FOR "com.interblocks.eod.controller.Functions.MASK_DATA";
//CREATE ALIAS GET_DATA FOR "com.interblocks.eod.controller.Functions.GET_DATA";
public class Functions {
//	public static int countBooks(Connection connection, Integer authorId)   throws SQLException {
//		        // Translate your T-SQL statements to jOOQ statements
////		        return DSL.using(connection, SQLDialect.H2)
////		                  .selectCount()
////		                  //.from(BKN_DS_EOD_PARM)
////		                  //.where(BOOK.AUTHOR_ID.eq(authorId))
////		                  .fetchOne(0, int.class);
//		        return 3;
//		    }
	
	public static String MASK_DATA(String cardNum)   throws SQLException {
		System.out.println("MASK_DATA:"+cardNum);
        return cardNum;
    }
	
	public static String GET_DATA(String cardNum)   throws SQLException {
		System.out.println("GET_DATA:"+cardNum);
        return cardNum;
    }
}
