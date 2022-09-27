
<%@page import="com.interblocks.eod.util.bean.SessionUserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EOD simulator</title>    
        <jsp:include page="../../Styles.jsp" />  
    </head>

    <body style="overflow:hidden">
        <div class="wrapper">
            <jsp:include page="../../header.jsp" /> 

            <div class="body_content" id="includedContent">
                <div class="AddUser_box">
                    <div class="watermark"></div>
                    <div class="contentcenter">
                        <div class="form_table">
                            <table cellspacing="8" align="center">
                                <tr class="home_data">
                                    <td class="content_td homeLable" valign="top">iCore</td>
                                    <!-- <td class="content_td homeLable1"></td> -->
                                </tr>
                                <tr class="home_data">
                                    <td class="content_td homeLable" valign="top">Eod Test Simulator</td>
                                    <!-- <td class="content_td homeLable1"></td> -->
                                </tr>
                            </table>
                        </div>
                    </div>

            
                </div>
            </div>







            <jsp:include page="../../footer.jsp" /> 


        </div> <!--end of body_content-->

    </body>
</html>

