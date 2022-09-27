

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true"%>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/main.css' />" />
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/buttons.css' />" />
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/familytree.css' />" />
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/font-awesome.css' />" />
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/dataTables.bootstrap.min.css' />" />
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/bootstrap.min.css' />" />
        <link type="image/ico" rel="shortcut icon" href="<spring:url value='/resources/images/favicon.ico' />" />
        <!--****************new left panel css************** -->
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/leftpanel/styles.css' />" />
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/leftpanel/style.css' />" />
         <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/jquery-ui.css' />" />


        <script type="text/javascript" src="<c:url value='/resources/js/leftpanel/jquery-2.1.4.js' />"></script>
        <script type="text/javascript" src="<c:url value='/resources/js/jquery-2.1.4.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/resources/js/TreeMenu.js' />"></script>
        <script type="text/javascript" src="<c:url value='/resources/js/div.js' />"></script>
        <script type="text/javascript" src="<c:url value='/resources/js/jquery.cookie.js' />"></script>

<!--        ***********left panel dragable****
        <script type="text/javascript" src="<c:url value='/resources/js/leftpanel/jquery-ui.js' />"></script>      
        ***********bottem togel****
       <script type="text/javascript" src="<c:url value='/resources/js/leftpanel/interface.js' />"></script>
       -->
        <script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/resources/js/dataTables.bootstrap.min.js' />"></script>
        <!--<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui.min.js' />"></script>-->
<!--        <script type="text/javascript" src="<c:url value='/resources/js/jquery.js' />"></script>-->
        <script type="text/javascript" src="<c:url value='/resources/js/jquery-ui.js' />"></script>
        
<!--check box-->
        <script type="text/javascript">


        </script>

        <script type="text/javascript" >
            
            $(document).ready(function () {
               
                var idpage = $.cookie("selectedpage");
                var idpageval = "#" + idpage;
                var idsec = $.cookie("selectedsec");
                var idsecval = "#" + idsec;
                
                $(this).find(idpageval).addClass('active');
                $(idsecval).slideDown();
                

                $("#accordian h3").click(function () {
                    $("#accordian ul ul").slideUp();
                    if (!$(this).next().is(":visible"))
                    {
                        $(this).next().slideDown();
                        $.cookie("selectedsec", $(this).next().attr("id"), {path: "/", expires: 1});
                    }
                });
                
                $('.dragbox').each(function () {
                              $(this).find('h2').click(function () {
                                      $(this).siblings('.dragbox-content').slideUp();
                                      if(!$(this).next().is(":visible")){
                                          $(this).siblings('.dragbox-content').slideDown();
                                      }
                              })
                 });
                  

            })

            $(function () {
                $('#accordian ul ul li').click(function () {
                    $.cookie("selectedpage", $(this).find('a').attr("id"), {path: "/", expires: 1});
                })
            });

        </script>

    </head>
</html>

