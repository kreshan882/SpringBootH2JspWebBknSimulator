/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interblocks.eod.controller;


import com.interblocks.eod.model.TrxnBean;
import com.interblocks.eod.service.LoginService;
import com.interblocks.eod.service.TrxnService;
import com.interblocks.eod.util.AccessControlService;
import com.interblocks.eod.util.LogFileCreator;
import com.interblocks.eod.util.PageVarList;
import com.interblocks.eod.util.Util;
import com.interblocks.eod.util.validator.UserFormValidator;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kreshan
 */
@Controller
public class TrxnController implements AccessControlService {
//    UserAddInputBean loginBean = new UserAddInputBean();

    HttpSession session = null;
    


    @Autowired
    UserFormValidator userFormValidator;

    Util util=new Util();;
//    UserFormValidator userFormValidator=new UserFormValidator();
    
    @Autowired
    private MessageSource messageSource;
    

    @Autowired
    TrxnService trxnService;


    @RequestMapping(value="/trxnLoad",method= RequestMethod.GET)
	public String trxnLoad(HttpServletRequest req, Model model) {
            System.out.println("Transaction Load");
            session=req.getSession(false);
            try{

                TrxnBean trxn = new TrxnBean();
                getDropdownValues(model);
                model.addAttribute("userForm", trxn);
                
                List<TrxnBean> trxnlist = new ArrayList<>();
                trxnlist = trxnService.getTrxnList();
                model.addAttribute("trxnlist", trxnlist);
                
                //model.addAttribute("msg", "User add page");
                System.out.println("Transaction Loaded, call page");
            }catch(Exception e){
                e.printStackTrace();
                LogFileCreator.writeErrorToLog(e);
            }

            return "pages/user/trxnAdd.jsp";

    }

    @RequestMapping(value = "/trxnSubmit", method = RequestMethod.POST)
    public String trxnSubmit(@ModelAttribute("userForm") @Validated TrxnBean trxnBean,
            BindingResult result, Model model) {
        
        System.out.println("transaction submit....."+trxnBean.getAccount_type());
            userFormValidator.validate(trxnBean, result);
            
            try{
            	if (result.hasErrors()) {
            		System.out.println("validation fail....");
                    model.addAttribute("error", messageSource.getMessage(result.getFieldError(),null));
                }else{
                	System.out.println("validation pass....");
                	System.out.println("acc num:"+trxnBean.getAccount_no());
                    System.out.println("account_type:"+trxnBean.getAccount_type());
                    int res=trxnService.insertTransaction(trxnBean);
                    
                	System.out.println("res:"+res);
                	System.out.println("result.hasErrors():"+result.hasErrors());
                    if (result.hasErrors()) {
                        model.addAttribute("error", messageSource.getMessage(result.getFieldError(),null));
                    }else{
                    	
                        
                        model.addAttribute("userForm",new TrxnBean());
                        model.addAttribute("msg", "Transaction Added Successfully!");
                        //LogFileCreator.writeInforToLog("Transaction Added Successfully!");
                    }
                }
                
                getDropdownValues(model);
                
                //efresh table                
                List<TrxnBean> trxnlist = new ArrayList<>();
                trxnlist = trxnService.getTrxnList();
                model.addAttribute("trxnlist", trxnlist);
                
            }catch(Exception e){
                e.printStackTrace();
                LogFileCreator.writeErrorToLog(e);
                model.addAttribute("error", "error on user add");
            }
            
            return "pages/user/trxnAdd.jsp";
    }

    @RequestMapping(value="/deleteTrans",method= RequestMethod.POST)
    public @ResponseBody TrxnBean deleteTrans(@RequestParam String trxn_number) {
    	TrxnBean trxnBean = new TrxnBean();
        try{
            System.out.println("User Delete !!!>>"+trxn_number);
            int res= trxnService.deleteTransaction(trxnBean,trxn_number);
            System.out.println("res:"+res);
            trxnBean.setDeleteSucsess(1);
            trxnBean.setDeleteMessage("transaction Deleted Sucsessfully");
        }catch(Exception e){
            e.printStackTrace();
            LogFileCreator.writeErrorToLog(e);
            trxnBean.setDeleteSucsess(0);
            trxnBean.setDeleteMessage("Transaction Deleted fail");
        }
        return trxnBean;
    }
    
    
    private void getDropdownValues(Model model) {
            try{
            
            model.addAttribute("eofFunctList", util.getEodFunctList());
            model.addAttribute("statusList", util.getStatusList()); 
            
            model.addAttribute("accountList", util.getAccountList());
            model.addAttribute("currencyList", util.getCurrencyList()); 
            
            model.addAttribute("trxnTypeList", util.getTrxnTypeList());
            model.addAttribute("prodTypeList", util.getProdTypeList()); 
                
            }catch(Exception e){
                e.printStackTrace();
                LogFileCreator.writeErrorToLog(e);
            }
           
	}

    @Override
    public boolean checkAccess(List<String> profilePageidList) {
        System.out.println("user check access");
        boolean status = false;
        String page = PageVarList.ADD_USER;
        if (profilePageidList.contains(page)) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }
}
