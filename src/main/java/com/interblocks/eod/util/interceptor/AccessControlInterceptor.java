/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interblocks.eod.util.interceptor;

import com.interblocks.eod.controller.LoginController;
import com.interblocks.eod.util.AccessControlService;
import com.interblocks.eod.util.bean.SessionUserBean;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kreshan
 */
public class AccessControlInterceptor implements HandlerInterceptor {
    
    @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        try {
            HandlerMethod hm = (HandlerMethod) handler;
            java.lang.reflect.Method method = hm.getMethod();
            Class c = (Class) method.getDeclaringClass();
            Object action = c.newInstance();

            if (action instanceof LoginController) {
                return true;
            } else {

                List<String> profilePageidList = (List<String>) request.getSession().getAttribute("profilePageidList");

                if (profilePageidList != null) {
                    if (action instanceof AccessControlService) {

                        if (((AccessControlService) action).checkAccess(profilePageidList)) {
                            return true;
                        } else {
                            return false;
                        }

                    } else {
                        return false;
                    }

                } else {
                    return false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("You don't have access to this page");
            return false;
        }

     }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
    }
    

}
