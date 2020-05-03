<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.msb.constants.MsbConstants" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Entry by ${entry.user_name} for ${entry.entry_type } | MySuperTalent</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="Build whatever layout you need with our Architect framework.">
<meta name="msapplication-tap-highlight" content="no">
<!--
    =========================================================
    * ArchitectUI HTML Theme Dashboard - v1.0.0
    =========================================================
    * Product Page: https://dashboardpack.com
    * Copyright 2019 DashboardPack (https://dashboardpack.com)
    * Licensed under MIT (https://github.com/DashboardPack/architectui-html-theme-free/blob/master/LICENSE)
    =========================================================
    * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
    -->
<link href="<%=request.getContextPath()%>/assets/main.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/assets/main.cba69814a806ecc7945a.css"
	rel="stylesheet">
<style>
.hide {
	display: none;
}
</style>
</head>
<body>
	<div
		class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<jsp:include page="/common/collegeheader.jsp"></jsp:include>
		<!-- Theme settings removed from here -->
		<div class="app-main">
			<jsp:include page="/common/collegemenu.jsp"></jsp:include>
			<div class="app-main__outer">
				<div class="app-main__inner">
					<div class="app-page-title">
						<div class="page-title-wrapper">
							<div class="page-title-heading">
								<div class="page-title-icon">
									<i class="pe-7s-pen text-success"> </i>
								</div>
								<div>
									${entry.entry_type } Entry
									<%-- <div class="page-title-subheading">
										<c:if test="${param.success eq true }">
											Submitted Your Entry Successfully
										</c:if>
										<c:if test="${param.success eq false }">
											<c:if test="${param.exceeded eq true }">
											Entry Submission Failed
										</c:if>
											<c:if test="${param.exceeded eq false }">
											Technical Problem
										</c:if>
										</c:if>
									</div> --%>
								</div>
							</div>
							<div class="page-title-actions">
								<form action="#" id="like-form">
									<input type="hidden" name="entry_username" value="${entry.user_name}">
									<input type="hidden" name="entry_id" value="${entry.id}">
									<input type="hidden" name="comp_type" value="${entry.entry_type }">
									<input type="hidden" name="username" id="fb_username">
									<input type="hidden" name="fb_login" id="fb_login">
									<button type="submit" data-toggle="tooltip" id="like"
										title="Like This Entry" data-placement="bottom"
										class="btn-shadow mr-3 btn btn-warning">
										<i class="fa fa-thumbs-up fa-3x"></i>
									</button>
								</form>
								<button type="button" class="btn mr-2 mb-2 btn-primary hide" data-toggle="modal" data-target="#exampleModal"
									id="clickForLike">Basic Modal
							  	</button>
							</div>
						</div>
					</div>

					<div class="tab-content">
						<div class="tab-pane tabs-animation fade show active"
							id="tab-content-0" role="tabpanel">
							<!-- <h5 class="card-title">Grid Rows</h5> -->
							<div class="main-card mb-3 card">
								<div class="card-header">
									<i
										class="header-icon pe-7s-pen icon-gradient bg-plum-plate">
									</i>${entry.entry_type} entry by ${entry.user_name }
									<div class="btn-actions-pane-right actions-icon-btn">
										<button class="  btn btn-link btn-success">
											<i class="fa fa-eye btn-icon-wrapper"></i> &nbsp;${entry.visits } &nbsp; 
										</button>
										|
										<button class="btn btn-link btn-info">
											<i class="fa fa-thumbs-up btn-icon-wrapper"></i>  &nbsp;<span id="votes"><c:set var="votes" value="${ (entry.points-20)/2 }"></c:set>
											<fmt:formatNumber maxFractionDigits="0" value="${votes}" type="number"/> &nbsp;</span>
										</button>
									</div>
								</div>
								<div class="card-body">
									<blockquote>${entry.summary}</blockquote>
									<div class="divider"></div>
									<div style="max-height: 550px; overflow-y: scroll;padding: 7px;">
										${entry.content}
									</div>
								</div>
								<div class="d-block text-right card-footer">
									<c:if test="${not empty previousEntry}">
										<a href="${pageContext.request.contextPath}/college/view/text_competition/${previousEntry}"
											 class="btn btn-info btn-lg">Previous</a>											 
                    				</c:if>
                    				<c:if test="${not empty nextEntry}">
										<a href="${pageContext.request.contextPath}/college/view/text_competition/${nextEntry}"
											class="btn btn-success btn-lg">Next</a>											 
                      				</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="/common/footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="exampleModalLabel">Login Required</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	            </div>
	            <div class="modal-body">
	                <p class="mb-0">Student need to login to like an entry</p>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
	                <button type="button" class="btn btn-primary" onclick="redirectLogin()">Login</button>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- jQuery library -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/scripts/main.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/scripts/main.cba69814a806ecc7945a.js"></script>
	<!-- jQuery library -->
	<script
		src="<%=request.getContextPath()%>/assets/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/assets/bootstrap.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/jquery.inputlimiter.1.3.1.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/jquery.autosize.js"></script>
	<script	
		src="<%=request.getContextPath()%>/assets/jquery.validate.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/additional-methods.js"></script>
	<script	
		src="<%=request.getContextPath()%>/assets/bootbox.js"></script>
	<script>
		$('document').ready(function() {
			$('#entries').addClass('mm-active');
			$('[data-toggle=tooltip]').tooltip();
		});
	</script>
	<script>
	
	function getParameterByName(name) {
	    var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
	    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
	}
	jQuery(document).ready(function($) {
		
		if (!!(getParameterByName('vote')) && getParameterByName('vote') == 'yes' ){
			voteEntry();
			}
		$("#like-form").submit(function(event) {
			event.preventDefault();
			voteEntry();
		});

	});
	function voteEntryViaFB(email){
		$('#fb_username').val(email);
		$('#fb_login').val('yes');
		voteEntry();
	}
	function voteEntry() {
		var formData=$("#like-form").serialize();
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/college/validate-user-like",
			data : formData,
			timeout : 100000,
			beforeSend:function(){
			
				$('#like').prop('disabled',true);
			},
			success : function(data) {
				
				console.log("SUCCESS: ", data);
				
				if(data=='voted'){
					alert("Thank you for liking the entry.");
					var points=$('#points').text();
					$('#points').text(parseInt(points)+2);
					var votes=$('#votes').text();
					$('#votes').text(parseInt(votes)+1);
				}else if(data=='already-voted'){
					alert("You already voted,come again tomorrow. Thank you");
				}
				else if(data=='nouser'){
					$('#clickForLike').click();
				}
					
				$('#fb_username').val("");
				$('#fb_login').val("");
				$('#like').prop('disabled',false);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				bootbox.alert(e);
				$('#like').prop('disabled',false);
			},
			done : function(e) {
				console.log("DONE");
				$('#like').prop('disabled',false);
				$('#fb_username').val("");
				$('#fb_login').val("");
			}
		});

	}
	function redirectLogin() {
  	  var next="${requestScope['javax.servlet.forward.request_uri']}".replace('${pageContext.request.contextPath}',"");
			location.href="${pageContext.request.contextPath}/college/login?invalidsession=true&next="+next+"?vote=yes";
    }
</script>
</body>
</html>
