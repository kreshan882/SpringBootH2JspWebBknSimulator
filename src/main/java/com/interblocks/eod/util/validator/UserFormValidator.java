/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.interblocks.eod.util.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.interblocks.eod.model.TrxnBean;



@Service
public class UserFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return TrxnBean.class.equals(clazz);
    }


    
    @Override
    public void validate(Object target, Errors errors){
        TrxnBean trxnBean = (TrxnBean) target;

            try{
    
                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account_no", "NotEmpty.userForm.account_no","Empty account number");
                    if(!CommonValidator.validateNUMBER(trxnBean.getAccount_no())){
                        errors.rejectValue("account_no", "Pattern.userForm.name","Invalod account number");
                    }
                    
                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "crd_no", "NotEmpty.userForm.crd_no","Empty Card number");
                    if(trxnBean.getCrd_no().length() < 2){
                        errors.rejectValue("crd_no", "Length.userForm.crd_no","Card Number grater then 2 digits");
                    }
                    if(!CommonValidator.validateNUMBER(trxnBean.getCrd_no())){
                        errors.rejectValue("crd_no", "Pattern.userForm.crd_no","invalid Card number");
                    }

                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bill_amount", "NotEmpty.userForm.bill_amount","Empth Bill Amount");
                    if(!CommonValidator.validateNUMBER(trxnBean.getBill_amount())){
                        errors.rejectValue("bill_amount", "Pattern.userForm.bill_amount","Bill amount must number");
                    }

                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "settle_amount", "NotEmpty.userForm.settle_amount","Empth Settlement Amount");
                    if(!CommonValidator.validateNUMBER(trxnBean.getSettle_amount())){
                        errors.rejectValue("settle_amount", "Pattern.userForm.settle_amount","Invalid Settlement number");
                    }
                    
                    
                    if(trxnBean.getAccount_type().equals("0")){
                        errors.rejectValue("account_type", "NotEmpty.userForm.account_type","please select Account type");
                    }
                    if(trxnBean.getCurrency_code().equals("0")){
                        errors.rejectValue("currency_code", "NotEmpty.userForm.currency_code","please select currency code");
                    }


                System.out.println("validate hear....");
            }catch(Exception e){
                e.printStackTrace();
            }
           
            
    }

}
