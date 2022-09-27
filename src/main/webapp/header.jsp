



<%@page import="com.interblocks.eod.util.ModuleComparator"%>
<%@page import="java.util.TreeSet"%>
<%@page import="com.interblocks.eod.util.bean.PageBean"%>
<%@page import="com.interblocks.eod.util.bean.ModuleBean"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<div class="banner1">
    <div class="leftimg"></div>
   <!-- <div class="rightimg"></div> -->  
</div><!--end of banner1-->


    <div class="ticker">
        <div id="pheader" class="ticker_heading"></div><!--ticker current path-->
        <div class="username"><span class="caps">${SessionObject.username}</span></div> 
        <a href="/logout?logout"><div class="logout"><span class="login_data"></span></div></a>
       <font><a href="callHome"><img src="${pageContext.request.contextPath}/resources/images/home.png"/></a></font></a>

    </div><!--end of ticker-->  
    

        
<div class="column" id="column1">        
    <div class="dragbox" id="item1">
        <h2>Menu</h2>
        <div class="dragbox-content" >
            
            <div id='accordian'>
                <ul>



                    <%

                        try {
                            
                            
                            HashMap<ModuleBean, List<PageBean>> sectionPageList = (HashMap<ModuleBean, List<PageBean>>) request.getSession().getAttribute("modulePageList");

                            ModuleComparator sec1 = new ModuleComparator();
                            Set<ModuleBean> section = new TreeSet<ModuleBean>(sec1);

                            Set<ModuleBean> section1 = sectionPageList.keySet();
                            for (ModuleBean sec2 : section1) {
                                section.add(sec2);
                            }

                            int secId = 1;
                            int pageId = 1000;
                            out.println("<li class=\'main-navigation-menu\' id=\'treemenu\' >");
                            ////////////////////////////////////
                            for (ModuleBean sec : section) {
                                out.println("<h3>" + sec.getMODULE_NAME() + "</h3>");
                                out.println("<ul id=\"" + secId + "\">");
                                
                                
                                List<PageBean> pageList = sectionPageList.get(sec);
                                for (PageBean pageBean : pageList) {
                                   

                                    pageId++;
                                    out.println("<li>");
                                    out.println("<a id= " + pageId + " href=\'" + request.getContextPath() +"/"+ pageBean.getPAGE_URL() + ".action\'>");
                                    out.println("<span class=\'title\'>" + pageBean.getPAGE_NAME() + "</span>");
                                    out.println("</a>");

                                    out.println("</li>");
                                    
                                    

                                }
                                secId++;
                                out.println("</ul>");
                            }
                            out.println("</li>");
                            /////////////////////////////////////
                        } catch (Exception ee) {

                            ee.printStackTrace();
                        }
                    %>


                </ul>  
            </div> <!--end of accordian_menu_bar-->
        </div>
    </div>

</div><!--end of left_menu_bar-->

