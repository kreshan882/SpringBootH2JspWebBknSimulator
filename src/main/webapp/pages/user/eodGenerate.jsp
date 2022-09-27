


<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

   

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Generate EOD</title>
        ${msg}
        <jsp:include page="../../Styles.jsp" /> 
        
        <link type="text/css" rel="stylesheet" href="<spring:url value='/resources/css/main.css' />" />
        <script type="text/javascript">
            
            $(document).ready(function() {
                var a = ${first};
                if(a==1){
                    $('#userEditAndView').hide();
                }
                $('#userView').DataTable();
            } );
            
            function editUser(keyval) {
                $('#divmsg').empty();
                $('#userEditAndView').show();
                $.ajax({
                    url: '${pageContext.request.contextPath}/userGetUpdateData',
                    data: {userid: keyval},
                    dataType: 'json',
                    type: "POST",
                    success: function(data) {
                        $('#updated').val('1');
                        $('#upUserID').val(data.upUserID);
                        $('#name').val(data.name);
                        $('#userID').val(data.userID);
                        $('#mobileNo').val(data.mobileNo);
                        $('#email').val(data.email);                            
                        $('#userProfile').val(data.userProfile);
                        $('#applicationProfile').val(data.applicationProfile);
                        $('#activationMethod').val(data.activationMethod);                            
                        $('#authMethod').val(data.authMethod);
                        $('#status').val(data.status);
                    }
                });
            }
            
            function resetUpadteData() {
                $('#divmsg').empty();
                var userid = $('#upUserID').val();
                $.ajax({
                    url: '${pageContext.request.contextPath}/userGetUpdateData',
                    data: {userid: userid},
                    dataType: 'json',
                    type: "POST",
                    success: function(data) {
                        $('#updated').val('1');
                        $('#name').val(data.name);
                        $('#userID').val(data.userID);
                        $('#mobileNo').val(data.mobileNo);
                        $('#email').val(data.email);                            
                        $('#userProfile').val(data.userProfile);
                        $('#applicationProfile').val(data.applicationProfile);
                        $('#activationMethod').val(data.activationMethod);                            
                        $('#authMethod').val(data.authMethod);
                        $('#status').val(data.status);
                    }
                });
            }
            
            function confirmDelete(keyval,keyval2) {
                $("#dialog-confirm").html('<br><b><font size="3" color="red"><center>Please confirm to delete user : ' + keyval2 + ' ');
                // Define the Dialog and its properties.
                $("#dialog-confirm").dialog({
                    resizable: false,
                    modal: true,
                    title: "Delete user confirmation",
                    height: 150,
                    width: 400,
                    closeOnEscape: false,
                    buttons: {
                        "Yes": function () {
                            $(this).dialog('close');
                            deleteUser(keyval);
                        },
                            "No": function () {
                            $(this).dialog('close');
                        }
                    }
                });
            }
            
            function deleteUser(keyval) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/deleteUser',
                    data: {userID: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function(data) {
                        if (data.deleteSucsess == 1) {
                            $("#dialog-status").html('<br><b><font size="3" color="green"><center>' + data.deleteMessage + ' ');
                        } else {
                            $("#dialog-status").html('<br><b><font size="3" color="red"><center>' + data.deleteMessage + ' ');
                        }
                        $("#dialog-status").dialog({
                            resizable: false,
                            modal: true,
                            title: "Delete user status",
                            height: 150,
                            width: 400,
                            closeOnEscape: false,
                            buttons: {
                                "Ok": function () {
                                    window.location.href = '${pageContext.request.contextPath}/userEditAndView';
                                    $(this).dialog('close');
                                }
                            }
                            
                        });
                    }
                });
            }

            
            
//            function deleteUser(keyval){
//                $('#divmsg').empty();
//                $("#deletedialog").data('keyval', keyval).dialog('open');
//                $("#deletedialog").html('<br><b><font size="3" color="red"><center>Please confirm to delete institute :'+keyval);
//
//            return false;
//}
            
//            function upadteData() {
//                var user = $('#userEditAndView').serializeArray();
//                
//                var jsonString = {};
//                
//                $.each(user, function() { 
//                    jsonString[this.name] = this.value; 
//                });
//                
//                $.ajax({
//                    url: '${pageContext.request.contextPath}/userUpdate',
//                    data: {jsonData: JSON.stringify(jsonString)},
//                    dataType: 'json',
//                    type: "POST",
//                    success: function(data) {
//                        var s = document.getElementById("divmsg");
//                        var msg = data.updateMsg;
//                        
//                        if(data.updateSucsess==0){
//                            s.innerHTML = "<div class='error'><p><span>"+msg+"</span></p></div>";
//                        }else{
//                            s.innerHTML = "<div class='msgsuccess'><p><span>"+msg+"</span></p></div>";
//                            $('#userView').DataTable().reload();
//                        }
//
//                    },
//                    error : function (error){
//                        console.log(error);
//                    }
//                });
//            }

        </script>
    </head>
    <body style="overflow:hidden">
        <div class="wrapper">

            <jsp:include page="../../header.jsp" /> 



            <div class="body_content" id="includedContent">

                <div class="watermark"></div>
                <div class="heading">Generate EOD</div>
                    <div class="AddUser_box "> 
                    
                        <div class="divmsg" id = "divmsg">
                            <c:if test="${not empty error}">
                                <div class="error" >${error}</div>
                            </c:if>
                            <c:if test="${not empty msg}">
                                <div id="msg" class="msgsuccess">${msg}</div>
                            </c:if>
                        </div>

                            
                    <div class="contentcenter">
                        <div class="container">
                            <%--<c:if test="${first}!=1">--%>
                                <spring:url value="/userUpdate" var="userActionUrl" />

                            <form:form id="userEditAndView" class="form-horizontal" method="post" modelAttribute="userViewForm" action="${userActionUrl}">

                                <table class="form_table" border="0px">
                                    

                                    <tr>
                                        <td class="content_td formLable">Eod Functions<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:select path="status" class="textField">
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${eofFunctList}" />
                                            </form:select>
                                        </td>
                                    </tr>
                                     
                                    <tr>
                                        <td></td> 
                                    </tr>
                                    <tr>
                                    <td align="left" colspan="7">
                                        <button type="submit" class="button_ssave">Generate
                                        </button>
                                        <button type="button" onclick="resetUpadteData();" class="button_reset">Reset
                                        </button>
                                    </td>
                                    </tr>
                                 </table>
                            </form:form>
                            </div>
                            <%--</c:if>--%>
                            <div id="dialog-confirm"></div>
                            <div id="dialog-status"></div>
                            <div class="viewuser_tbl">
                            <div id="tablediv">
                            <table id="userView" class="table table-striped table-bordered table-hover" width="100%">
                                <thead>
                                    <tr>
                                        <th data-class="expand" class="tbl_heading">Account Number</th>
                                        <th data-class="expand" class="tbl_heading">Name</th>
                                        <th data-class="expand" class="tbl_heading">Amount</th>
                                        <th data-class="expand" class="tbl_heading">Email</th>
                                        <th data-class="expand" class="tbl_heading">User Profile</th>
                                        <th data-class="expand" class="tbl_heading">Application Profile</th>
                                        <th data-class="expand" class="tbl_heading">Activation Method</th>
                                        <th data-class="expand" class="tbl_heading">Authentication Method</th>
                                        <th data-class="expand" class="tbl_heading">Service Fee</th>
                                        <th data-class="expand" class="tbl_heading">Gen EOD</th>
                                        <th data-class="expand" class="tbl_heading">Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var = "userlist" items = "${userlist}">
                                        <tr>
                                            <c:set var="userId" value="${userlist.userID}"/>
                                            <c:set var="username" value="${userlist.name}"/>
                                            <td>${userlist.userID}</td>
                                            <td>${userlist.name}</td>
                                            <td>${userlist.mobileNo}</td>
                                            <td>${userlist.email}</td>
                                            <td>${userlist.userProfileDesc}</td>
                                            <td>${userlist.applicationProfileDesc}</td>
                                            <td>${userlist.activationMethod}</td>
                                            <td>${userlist.authMethod}</td>
                                            <td>${userlist.status}</td>
                                            <td style="text-align: center;"><a href='#' onclick='editUser("${userId}");'><img src ='${pageContext.request.contextPath}/resources/images/iconEdit.png' /></a></td>
                                            <td style="text-align: center;"><button onclick='confirmDelete("${userId}","${username}");'><img src ='${pageContext.request.contextPath}/resources/images/iconDelete.png' /></button></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                                </div>

                        </div>
                        
                    </div>
                      
                </div>

            </div><!--end of body_content-->


            


            <jsp:include page="../../footer.jsp" /> 



        </div> 

    </body>
</html>
