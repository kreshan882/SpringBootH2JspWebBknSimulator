package com.interblocks.eod;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.interblocks.eod.service.LoginService;
import com.interblocks.eod.util.Log;


//@ComponentScan(basePackages={"com.interblocks.eod.login",
//							 "com.interblocks.eod.trxn"
//							})
//@ComponentScan(basePackages={"com.interblocks.eod.util.validator"})

@SpringBootApplication
public class TestBknSimulatorApplication implements ServletContextListener{

	public static void main(String[] args) {
		SpringApplication.run(TestBknSimulatorApplication.class, args);
		
	}

    @Override
    public void contextInitialized(ServletContextEvent sce) {     
    		System.out.println("Build : 29/09/2022");   
            System.out.println("Global variable initialized .....");  
            Log.info("innnnnn");
    		Log.debug("ddddd");
    		Log.warn("wwwww");
    		Log.error("eeee");
    		Log.fatal("fffff");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("Global Variable Destroyed.");
    }
    
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        return Server.createTcpServer(
          "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }
}
