<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${param.type } Competition| MySuperTalent</title>
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
<link href="<%=request.getContextPath()%>/assets/main.cba69814a806ecc7945a.css"
	rel="stylesheet">
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
									<c:if test="${fn:substring(type, 0, 5) == 'music'}">
										<i class="pe-7s-music text-success"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 5) == 'dance'}">
										<i class="fa fa-child icon-gradient bg-warm-flame"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 8) == 'speaking'}">
										<i class="pe-7s-micro text-success"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 7) == 'cooking'}">
										<i class="pe-7s-junk icon-gradient bg-warm-flame"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 6) == 'sports'}">
										<i class="pe-7s-target text-success"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 8) == 'painting'}">
										<i class="pe-7s-paint text-success"> </i>
									</c:if>
								</div>
								<div>
									${param.type } Competition
									<div class="page-title-subheading">
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
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="tab-content">
						<div class="tab-pane tabs-animation fade show active"
							id="tab-content-0" role="tabpanel">
							<div class="main-card mb-3 card">
								<div class="card-body">
									<!-- <h5 class="card-title">Grid Rows</h5> -->
									<c:if test="${param.success eq true }">
										<div class="alert alert-success fade show">
											Your ${param.type } Entry Successfully submitted .Click on below
												button to view and share entry to get more points
										</div>
										<a
											href="${pageContext.request.contextPath}/college/view/mst_competition/${param.id}"
											class="btn btn-md btn-primary">View &amp; Share</a>
									</c:if>
									<c:if test="${param.success eq false }">
										<c:if test="${param.exceeded eq true }">
											<div class="alert alert-danger fade show">
												You reached maximum number of submissions for this
													entry! Please click on competitions to proceed.
											</div>
										</c:if>
										<c:if test="${param.exceeded eq false }">
											<div class="alert alert-warning fade show">
												There is a technical problem. Please try again
													later
											</div>
										</c:if>

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
	<!-- jQuery library -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/scripts/main.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/scripts/main.cba69814a806ecc7945a.js"></script>
	<!-- jQuery library -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/assets/scripts/main.js"></script>
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
		$('document').ready(function(){
			$('#uploadtalent').addClass('mm-active');
		});
	</script>
</body>
</html>
