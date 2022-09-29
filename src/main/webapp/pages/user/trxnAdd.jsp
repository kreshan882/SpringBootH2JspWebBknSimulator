

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

   

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Transaction Post</title>
        ${msg}
        <jsp:include page="../../Styles.jsp" /> 
        <script type="text/javascript">
//            $.subscribe('resetButton', function(event, data) {
//                $('#divmsg').empty();
//                resetData();
//            });
//            
//            function resetData(){
//                $('#userAdd').trigger("reset");
//            }
             
                    
		function confirmDelete(keyval,keyval2) {
                $("#dialog-confirm").html('<br><b><font size="3" color="red"><center>Please confirm to delete transaction : ' + keyval2 + ' ');
                // Define the Dialog and its properties.
                $("#dialog-confirm").dialog({
                    resizable: false,
                    modal: true,
                    title: "Delete transaction confirmation",
                    height: 150,
                    width: 400,
                    closeOnEscape: false,
                    buttons: {
                        "Yes": function () {
                            $(this).dialog('close');
                            deleteTrxn(keyval);
                        },
                            "No": function () {
                            $(this).dialog('close');
                        }
                    }
                });
            }
            
		function deleteTrxn(keyval) {
            $.ajax({
                url: '${pageContext.request.contextPath}/deleteTrans',
                data: {trxn_number: keyval},
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
                        title: "Delete transaction status",
                        height: 150,
                        width: 400,
                        closeOnEscape: false,
                        buttons: {
                            "Ok": function () {
                                window.location.href = '${pageContext.request.contextPath}/trxnLoad';
                                $(this).dialog('close');
                            }
                        }
                        
                    });
                }
            });
        }
        
        function editUser(keyval) {
                alert('ddd');
                $('#divmsg').empty();
                $.ajax({
                    url: '${pageContext.request.contextPath}/FindTxans',
                    data: {trxn_number: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        $('#userEdit').show();
                        $('#userAdd').hide();
                       // $('#upusernamecopy').val(data.upusernamecopy);
                       // $('#upusername').val(data.upusername);
                       // $('#upusername').attr('readOnly', true).val();
                        
                      $('#uptrxn_number').val(data.trxn_number);
                      $('#upaccount_no').val(data.account_no);
                      $('#upcrd_no').val(data.crd_no);
                      $('#upprod_typ').val(data.prod_typ);
                  
                    },
                    error: function (data) {
                        window.location = "${pageContext.request.contextPath}/LogoutloginCall.blb?";
                    }
                });
            }
        </script>
    </head>
    <body style="overflow:hidden">
        <div class="wrapper">

            <jsp:include page="../../header.jsp" /> 



            <div class="body_content" id="includedContent">

                <div class="watermark"></div>
                <div class="heading">Transaction Post</div>
                    <div class="AddUser_box "> 
                    
                        <div class="divmsg">
                            <c:if test="${not empty error}">
                                <div class="error" >${error}</div>
                            </c:if>
                            <c:if test="${not empty msg}">
                                <div class="msgsuccess">${msg}</div>
                            </c:if>
                        </div>

                            
                    <div class="contentcenter">
                        <div class="container">

                            <spring:url value="/trxnSubmit" var="userActionUrl" />

                            <form:form id="userAdd"  class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">

                                <table class="form_table" border="0px">
                                    
                                    <tr>
                                        <td class="content_td formLable">Account Number<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:input path="account_no" type="text" cssClass="textField"
                                                id="account_no" name="account_no" placeholder="8844550024" />
                                        </td>
                                        <td class="content_td formLable">Card Number<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:input path="crd_no" type="text" cssClass="textField"
                                                id="crd_no" placeholder="12341234" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="content_td formLable">Bill Amount<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:input path="bill_amount" type="text" cssClass="textField"
                                                id="bill_amount" placeholder="1000" />
                                        </td>
                                        <td class="content_td formLable">Settlement Amount<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:input path="settle_amount" type="text" cssClass="textField"
                                                id="settle_amount" placeholder="10" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="content_td formLable">Account Type<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:select path="account_type" class="textField">
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${accountList}" />
                                            </form:select>
                                        </td>
                                        <td class="content_td formLable">Currency Code<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:select path="currency_code" class="textField">
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${currencyList}" />
                                            </form:select>
                                        </td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        <td class="content_td formLable">Transaction Type<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:select path="trxn_typ" class="textField">
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${trxnTypeList}" />
                                            </form:select>
                                        </td>
                                        <td class="content_td formLable">Product Type<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:select path="prod_typ" class="textField">
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${prodTypeList}" />
                                            </form:select>
                                        </td>
                                        
                                    </tr>

                                     
                                    <tr>
                                        <td></td> 
                                    </tr>
                                    <tr>
                                    <td align="left" colspan="7">
                                    	<button type="reset" class="button_reset">Reset
                                        </button>
                                        <button type="submit" class="button_ssave">Add Transaction
                                        </button>
                                        
                                    </td>
                                    </tr>
                                 </table>
                            </form:form>
                            <spring:url value="/trxnUpdate" var="userEditActionUrl" />

                            <form:form id="userEdit"  class="form-horizontal" method="post" modelAttribute="userForm" action="${userEditActionUrl}" cssStyle="display:none">

                                <table class="form_table" border="0px">
                                <form:hidden path="uptrxn_number" type="text" cssClass="textField"
                                id="uptrxn_number" name="uptrxn_number" cssStyle="display:none" />
                                
                                    <tr>
                                        <td class="content_td formLable">Account Number<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:input path="upaccount_no" type="text" cssClass="textField"
                                                id="upaccount_no" name="upaccount_no"  />
                                        </td>
                                        <td class="content_td formLable">Card Number<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:input path="upcrd_no" type="text" cssClass="textField"
                                                id="upcrd_no" name="upcrd_no"  />
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="content_td formLable">Product Type<span class="mandatory">*</span></td>
                                        <td class="content_td formLable">:</td>
                                        <td><form:select path="upprod_typ" class="textField" id="upprod_typ">
                                                <form:option value="0" label="--- Select ---" />
                                                <form:options items="${prodTypeList}" />
                                            </form:select>
                                        </td>
                                        
                                    </tr>

                                     
                                    <tr>
                                        <td></td> 
                                    </tr>
                                    <tr>
                                    <td align="left" colspan="7">
                                    	<button type="reset" class="button_reset">Reset
                                        </button>
                                        <button type="submit" class="button_ssave">Modifi Transaction
                                        </button>
                                        
                                    </td>
                                    </tr>
                                 </table>
                            </form:form>

                        </div>
                         <%--load table--%>
                            <div id="dialog-confirm"></div>
                            <div id="dialog-status"></div>
                            <div class="viewuser_tbl">
                            <div id="tablediv">
                            <table id="userView" class="table table-striped table-bordered table-hover" width="100%">
                                <thead>
                                    <tr>
                                        <th data-class="expand" class="tbl_heading">Account Number</th>
                                        <th data-class="expand" class="tbl_heading">Card Number</th>
                                        <th data-class="expand" class="tbl_heading">Bill Amount</th>
                                        <th data-class="expand" class="tbl_heading">Settlement Amount</th>
                                        
                                        <th data-class="expand" class="tbl_heading">Account type</th>
                                        <th data-class="expand" class="tbl_heading">Currency code</th>
                                        <th data-class="expand" class="tbl_heading">Trxn type</th>
                                        <th data-class="expand" class="tbl_heading">Product type</th>
										
										<th data-class="expand" class="tbl_heading">Modify</th>
                                        <th data-class="expand" class="tbl_heading">Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var = "trxnlist" items = "${trxnlist}">
                                        <tr>
                                            <c:set var="trxn_number" value="${trxnlist.trxn_number}"/>
                                            <c:set var="crd_no" value="${trxnlist.crd_no}"/>
                                           <%--  <td>${trxnlist.account_no}</td> --%>
                                            <td>${trxnlist.account_no}</td>
                                            <td>${trxnlist.crd_no}</td>
                                            <td>${trxnlist.bill_amount}</td>
                                            <td>${trxnlist.settle_amount}</td>
                                            
                                            <td>${trxnlist.account_type}</td>
                                            <td>${trxnlist.currency_code}</td>
                                            <td>${trxnlist.trxn_typ}</td>
                                            <td>${trxnlist.prod_typ}</td>

                                            <td style="text-align: center;"><a href='#' onclick='editUser("${trxn_number}");'><img src ='${pageContext.request.contextPath}/resources/images/iconEdit.png' /></a></td> 
                                            <td style="text-align: center;"><button onclick='confirmDelete("${trxn_number}","${crd_no}");'><img src ='${pageContext.request.contextPath}/resources/images/iconDelete.png' /></button></td>
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
