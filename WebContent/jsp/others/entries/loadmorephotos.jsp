<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.msb.dao.OtherDAOImpl"%>
<%@page import="com.msb.model.MSTCompetition"%>
<%@page import="java.util.List"%>
<%@page import="com.msb.dao.CompetitionDAOImpl"%>
<%@page import="com.msb.dao.CompetitionDAO"%>
 <%
 CompetitionDAO competitionDAO=new CompetitionDAOImpl();
 OtherDAOImpl detailsDAO=new OtherDAOImpl();
 List<MSTCompetition> photographyBeans=null;
 //if(request.getParameter("cname")!=null && request.getParameter("ccode")!=null){
    String type=request.getParameter("type");
    int userCategory=Integer.parseInt(request.getParameter("uc"));
    int offset=Integer.parseInt(request.getParameter("start"));
    int limit=1;
	
	photographyBeans=competitionDAO.getAllMSTEntries(type, userCategory, limit, offset);
 //}else
	 //if(request.getParameter("start")!=null){
		 //int offset=Integer.parseInt(request.getParameter("start"));
		 //photographyBeans=competitionDAO.getAllPhotographyEntries(offset); 
	 //}
	%>
	<%if(photographyBeans!=null && photographyBeans.size()>0){
						for(MSTCompetition bean:photographyBeans){
										
					%>
					<div class="media-box push">
                    		<div class="media-box-image mb-open-popup" data-overlay-effect="push-down-100%">
                      			
                       				<div data-thumbnail="<%=request.getContextPath() %>/img/kids.png"></div> 
                       			
                        		<div class="thumbnail-overlay">
                            		<a href="<%=request.getContextPath()%>/jsp/others/view/mst_competition/${entry.id}"
                            			target="_blank" class="media-box-title" style="color: black;">View|Like|Share</a>
                        		</div>
                    		</div>
		                   <div class="media-box-content">
		                   		<div class="media-box-title">${entry.entry_summary }</div>
							</div>
						</div>
					
					
					

					<%
						} }else{
					out.write("null");
						}%>