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
<title>View Entries | MySuperTalent</title>
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
</head>
<body>
	<div
		class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<jsp:include page="/common/scheader.jsp"></jsp:include>
		<!-- Theme settings removed from here -->
		<div class="app-main">
			<jsp:include page="/common/scmenu.jsp"></jsp:include>
			<div class="app-main__outer">
				<div class="app-main__inner">
					<div class="app-page-title">
						<div class="page-title-wrapper">
							<div class="page-title-heading">
								<div class="page-title-icon">
									<i class="pe-7s-look text-success"> </i>
								</div>
								<div>
									View Entries
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
						</div>
					</div>

					<div class="tab-content">
						<div class="row text-center">
									<!-- <h5 class="card-title">Grid Rows</h5> -->
									<div class="col-md-4">
										<div class="alert ">
											<a
												href="<%=request.getContextPath()%>/srichaitanya/mst_entries/painting/10/0">
												<img
												src="<%=request.getContextPath()%>/assets/images/competitions/Painting.png" />
												<h5>PAINTING</h5>
											</a>
										</div>
									</div>
									<div class="col-md-4">
										<div class="alert ">
											<a
												href="<%=request.getContextPath()%>/srichaitanya/text_entries/writing/10/0">
												<img
												src="<%=request.getContextPath()%>/assets/images/competitions/Writing.png" />
												<h5>WRITING</h5>
											</a>
										</div>
									</div>
									<div class="col-md-4">
										<div class="alert ">
											<a
												href="<%=request.getContextPath()%>/srichaitanya/mst_entries/music/10/0">
												<img
												src="<%=request.getContextPath()%>/assets/images/competitions/Music.png" />
												<h5>MUSIC</h5>
											</a>
										</div>
									</div>
									<div class="col-md-4">
										<div class="alert ">
											<a
												href="<%=request.getContextPath()%>/srichaitanya/mst_entries/dance/10/0">
												<img
												src="<%=request.getContextPath()%>/assets/images/competitions/Dance.png" />
												<h5>DANCE</h5>
											</a>
										</div>
									</div>
									<div class="col-md-4">
										<div class="alert ">
											<a
												href="<%=request.getContextPath()%>/srichaitanya/mst_entries/speaking/10/0">
												<img
												src="<%=request.getContextPath()%>/assets/images/competitions/Speaking.png" />
												<h5>SPEAKING</h5>
											</a>
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
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/assets/scripts/main.js"></script>
		<script src="<%=request.getContextPath()%>/assets/jquery.js"></script>
		<script src="<%=request.getContextPath()%>/assets/bootstrap.js"></script>
		<script
			src="<%=request.getContextPath()%>/assets/jquery.inputlimiter.1.3.1.js"></script>
		<script src="<%=request.getContextPath()%>/assets/jquery.autosize.js"></script>
		<script src="<%=request.getContextPath()%>/assets/jquery.validate.js"></script>
		<script
			src="<%=request.getContextPath()%>/assets/additional-methods.js"></script>
		<script src="<%=request.getContextPath()%>/assets/bootbox.js"></script>
		<script>
			$('document').ready(function() {
				$('#entries').addClass('mm-active');
			});
		</script>
		<script>
			$('document').ready(function(){
				if($('#premium').val()==0){
					$('#clickForPremium').click();
				}
			});
		</script>
</body>
</html>
