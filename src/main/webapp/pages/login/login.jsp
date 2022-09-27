<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/login.css'/>" />
        <link type="image/ico" rel="shortcut icon" href="<spring:url value='/resources/images/favicon.ico' />" />

        <title>Login Page</title>
        
        <script type="text/javascript">
//            function resetForm() {
//                document.getElementById("loginForm").reset();
//                $('#divmsg').empty();
//            }
        </script>
    </head>

    <body>
        <div class="login_body">

            <div class="header">
                <div class="leftimg"></div>
                <!--<div class="rightimg"></div>-->
                <div class="login_ticker">
                    <div class="login_content"></div>
                </div>

            </div>
            <!--login form-->

            <div class="watermark"></div>
            <div class="content">

                <div id="dialog">
                    <!--<form name="loginForm" id="loginForm" action="< c:url value='j_spring_security_check' />" method='POST'> -->
                    <form name="loginForm" id="loginForm" modelAttribute="activeUsrLogForm" action="activeUsrLog" method='POST'>

                        <table>
                            <tr>
                                <td class="lable">User:</td>
                                <td class="lable">:</td>
                                <td colspan="2"><input type='text' name='username'      id='username' class="form-field" /></td>
                            </tr>
                            <tr>
                                <td class="lable">Password:</td>
                                <td class="lable">:</td>
                                <td colspan="2"><input type='password' name='password' id='password' class="form-field" /></td>
                            </tr>
                            <tr>
                                <td colspan="2"></td>
                                <td><input type="submit" value="Login" class="login_button" /></td>
                                <td><input type="button" value="Reset" class="reset_button" onclick="resetForm()"/></td>
                            </tr>
                        </table>
                        <div id="divmsg">
                            <c:if test="${not empty error}">
                                <div style="color: red" class="lable" >${error}</div>
                            </c:if>
                            <c:if test="${not empty msg}">
                                <div style="color: red" class="lable">${msg}</div>
                            </c:if>
                        </div>
                    </form>
                </div>
            </div>
            <!--end of login form-->


            <div class="footer"><jsp:include page="../../footer.jsp" /></div>
        </div>
    </body>
</html>