package com.interblocks.eod.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.interblocks.eod.service.LoginService;
import com.interblocks.eod.util.bean.HomeValues;
import com.interblocks.eod.util.bean.LoginBean;
import com.interblocks.eod.util.bean.ModuleBean;
import com.interblocks.eod.util.bean.PageBean;
import com.interblocks.eod.util.bean.SessionUserBean;


@CrossOrigin  (origins = "*", allowCredentials = "true", allowedHeaders = "*")
@Controller
public class LoginController {
	
    LoginBean loginBean = new LoginBean();
    HomeValues homeValues=new HomeValues();
    SessionUserBean sessionUserBean = new SessionUserBean();
    
    Map<ModuleBean, List<PageBean>> modulePageList = null;
    List<String> profilePageidList =  null;
    
    
    @Autowired
    LoginService loginService;

	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public String loadLoginPage(HttpServletRequest req) {
		try {
			
			System.out.println("start Login............");
			loginService.createTable();
			
			System.out.println("h2 fonction maskdata test hear............");
			loginService.loadH2Functions();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "pages/login/login.jsp";
	}
	
	
	@RequestMapping(value="/Testk",method=RequestMethod.GET)
	public String test(HttpServletRequest req) {	
			System.out.println("Testk......");		
		return "testK";
	}
	
	
    @RequestMapping(value = "/activeUsrLog", method = RequestMethod.POST)
	public String userloginActive(HttpServletRequest req,HttpSession session, @ModelAttribute("activeUsrLogForm") LoginBean fornlogindata,Model model) throws Exception {
           
            System.out.println("userloginActive==>"+fornlogindata.getPassword()+":"+fornlogindata.getUserName());
           // ModelAndView model=null;
           String resPage="";
            loginBean = loginService.getUserDetails(fornlogindata.getUserName());
            
            //if (PasswordHashFunction.matchPassword(fornlogindata.getPassword().trim(),loginBean.getPassword().trim() )) { 
            //if (fornlogindata.getPassword().equals(loginBean.getPassword())) { 
            if (true) { 
                System.out.println("password equals..");
                try {                        
                       //loginService.getsessionDetails(loginBean);
                        sessionUserBean.setUsername(loginBean.getUserName());
                        sessionUserBean.setMobile(loginBean.getMobile());
                        sessionUserBean.setProfileid(loginBean.getUserProfileId());
                        sessionUserBean.setStatus(loginBean.getStatus());

                        session = req.getSession(false);
                        if (session != null) {
                            session.invalidate();
                        }
                        session = req.getSession(true);
                        session.setAttribute("SessionObject", sessionUserBean);

                        sessionUserBean.setCurrentSessionId(session.getId());

                         profilePageidList = loginService.getUserprofilePageidList(loginBean.getUserProfileId());
                         session.setAttribute("profilePageidList", profilePageidList);

                         modulePageList = loginService.getModulePageByUser(loginBean.getUserProfileId());
                         session.setAttribute("modulePageList", modulePageList);
  
                         resPage = "pages/login/Home.jsp";
                         
                } catch (Exception ex) {
                    ex.printStackTrace();
//                    LogFileCreator.writeErrorToLog(ex);
                    model.addAttribute("error", "exeption occered");
            		resPage="pages/login/login.jsp";
                   
                }

            }else{
            		model.addAttribute("error", "Invalid username and password!");
            		resPage="pages/login/login.jsp";
            }
            return resPage;
	}
          
        
	@RequestMapping(value="/callHome",method=RequestMethod.GET)
	public String callHome(HttpServletRequest req) {
		try {
			System.out.println("clicked home");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "pages/login/Home.jsp";
	}
        
    @RequestMapping(value = {"/logout","/"}, method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,		
                @RequestParam(value = "logout", required = false) String logout, HttpServletRequest req,Model model) {
		
        System.out.println("call lgout...................................");
		if (error != null) model.addAttribute("error", "Invalid username");
		if (logout != null) model.addAttribute("msg", "You've been logged out successfully.");
		
		return "pages/login/login.jsp";

	}

}
