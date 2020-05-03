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
<title>User Entries | MySuperTalent</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="${username }'s entries at MySuperTalent.com ">
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
									User Entries
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
					<div class="tab-pane tabs-animation fade show active"
							id="tab-content-0" role="tabpanel">
							<div class="main-card mb-3 card">
								<div class="card-body">
						<div class="col-md-9">

							<ul class="tabs-animated-shadow tabs-animated nav">
								<li class="nav-item"><a role="tab" class="nav-link active"
									data-toggle="tab" href="#texts-tab" id="get-texts"> <span>Writing</span>
								</a></li>
								<li class="nav-item"><a role="tab" class="nav-link"
									data-toggle="tab" href="#paints-tab" id="get-paints"> <span>Painting</span>
								</a></li>
								<!-- <li class="nav-item">
								<a data-toggle="tab" class="nav-link" href="#paints-tab" aria-expanded="true" id="get-paints">Painitngs</a>
							</li> -->
								<li class="nav-item"><a role="tab" class="nav-link"
									data-toggle="tab" href="#musics-tab" id="get-musics"> <span>Music</span>
								</a></li>
								<li class="nav-item"><a role="tab" class="nav-link"
									data-toggle="tab" href="#dances-tab" id="get-dances"> <span>Dance</span>
								</a></li>
								<li class="nav-item"><a role="tab" class="nav-link"
									data-toggle="tab" href="#dialogues-tab" id="get-dialogues">
										<span>Speaking</span>
								</a></li>
							</ul>

							<div class="tab-content">
								<div class="tab-pane active" id="texts-tab" role="tabpanel">
									<c:if test="${not empty writing }">
										<c:forEach items="${writing }" var="essay">
											<div class="alert alert-info">
												<h5 class="card-title">${essay.competition.topic}
													<small class="pull-right">${essay.user_name}&nbsp;&nbsp;</small>
												</h5>
												${essay.summary }
												<div class="divider"></div>
												<a class="btn btn-primary" target="_blank"
													href="<%=request.getContextPath() %>/srichaitanya/view/text_competition/${essay.id}">VIEW
													ENTRY</a>
											</div>
										</c:forEach>
									</c:if>
									<c:if test="${empty writing }">
										<h6>No Entries Found</h6>
									</c:if>
								</div>
								<div class="tab-pane scroll" id="paints-tab" role="tabpanel">

								</div>
								<div class="tab-pane scroll" id="musics-tab" role="tabpanel">

								</div>
								<div class="tab-pane scroll" id="dances-tab" role="tabpanel">

								</div>
								<div class="tab-pane scroll" id="dialogues-tab" role="tabpanel">

								</div>
							</div>
						</div></div></div></div>
					</div>
				</div>
				<jsp:include page="/common/footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<span class="hide" id="is-texts-loaded">no</span>
	<span class="hide" id="is-paints-loaded">no</span>
	<span class="hide" id="is-dances-loaded">no</span>
	<span class="hide" id="is-musics-loaded">no</span>
	<span class="hide" id="is-dialogues-loaded">no</span>
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
		$('document')
				.ready(
						function() {
							$('#entries').addClass('mm-active');

							$('#get-texts')
									.click(
											function() {
												if ($('#is-texts-loaded')
														.text() == 'no') {
													$
															.ajax({
																type : "GET",
																url : "${pageContext.request.contextPath}/alltexts/${user.username}",
																timeout : 100000,
																beforeSend : function() {
																	$(
																			'#texts-tab')
																			.append(
																					'<i class="col-md-6 col-md-offset-3 ace-icon fa fa-spinner fa-spin orange fa-5x center" id="loading"></i>');
																},
																success : function(
																		data) {

																	console
																			.log(
																					"SUCCESS: ",
																					data);

																	$(
																			'#texts-tab')
																			.empty();
																	$(
																			'#texts-tab')
																			.html(
																					data);
																	$(
																			'#is-texts-loaded')
																			.text(
																					'yes');
																},
																error : function(
																		e) {
																	console
																			.log(
																					"ERROR: ",
																					e);

																},
																done : function(
																		e) {
																	console
																			.log("DONE");
																	$(
																			'#loading')
																			.remove();

																}
															});
												}

											});
							$('#get-paints')
									.click(
											function() {
												if ($('#is-paints-loaded')
														.text() == 'no') {
													$
															.ajax({
																type : "GET",
																url : "${pageContext.request.contextPath}/allmst/painting/${user.username}",
																timeout : 100000,
																beforeSend : function() {
																	$(
																			'#paints-tab')
																			.append(
																					'<i class="col-md-6 col-md-offset-5 ace-icon fa fa-spinner fa-spin orange fa-5x center" id="loading"></i>');
																},
																success : function(
																		data) {

																	console
																			.log(
																					"SUCCESS: ",
																					data);

																	$(
																			'#paints-tab')
																			.empty();
																	$(
																			'#paints-tab')
																			.html(
																					data);
																	$(
																			'#is-paints-loaded')
																			.text(
																					'yes')
																},
																error : function(
																		e) {
																	console
																			.log(
																					"ERROR: ",
																					e);

																},
																done : function(
																		e) {
																	console
																			.log("DONE");
																	$(
																			'#loading')
																			.remove();

																}
															});
												}
											});
							$('#get-dances')
									.click(
											function() {
												if ($('#is-dances-loaded')
														.text() == 'no') {
													$
															.ajax({
																type : "GET",
																url : "${pageContext.request.contextPath}/allmst/dance/${user.username}",
																timeout : 100000,
																beforeSend : function() {
																	$(
																			'#dances-tab')
																			.append(
																					'<i class="col-md-6 col-md-offset-5 ace-icon fa fa-spinner fa-spin orange fa-5x center" id="loading"></i>');
																},
																success : function(
																		data) {

																	console
																			.log(
																					"SUCCESS: ",
																					data);

																	$(
																			'#dances-tab')
																			.empty();
																	$(
																			'#dances-tab')
																			.html(
																					data);
																	$(
																			'#is-dances-loaded')
																			.text(
																					'yes')
																},
																error : function(
																		e) {
																	console
																			.log(
																					"ERROR: ",
																					e);

																},
																done : function(
																		e) {
																	console
																			.log("DONE");
																	$(
																			'#loading')
																			.remove();

																}
															});
												}
											});
							$('#get-musics')
									.click(
											function() {
												if ($('#is-musics-loaded')
														.text() == 'no') {
													$
															.ajax({
																type : "GET",
																url : "${pageContext.request.contextPath}/allmst/music/${user.username}",
																timeout : 100000,
																beforeSend : function() {
																	$(
																			'#musics-tab')
																			.append(
																					'<i class="col-md-6 col-md-offset-5 ace-icon fa fa-spinner fa-spin orange fa-5x center" id="loading"></i>');
																},
																success : function(
																		data) {

																	console
																			.log(
																					"SUCCESS: ",
																					data);

																	$(
																			'#musics-tab')
																			.empty();
																	$(
																			'#musics-tab')
																			.html(
																					data);
																	$(
																			'#is-musics-loaded')
																			.text(
																					'yes')
																},
																error : function(
																		e) {
																	console
																			.log(
																					"ERROR: ",
																					e);

																},
																done : function(
																		e) {
																	console
																			.log("DONE");
																	$(
																			'#loading')
																			.remove();

																}
															});
												}
											});
							$('#get-dialogues')
									.click(
											function() {
												if ($('#is-dialogues-loaded')
														.text() == 'no') {
													$
															.ajax({
																type : "GET",
																url : "${pageContext.request.contextPath}/allmst/speaking/${user.username}",
																timeout : 100000,
																beforeSend : function() {
																	$(
																			'#dialogues-tab')
																			.append(
																					'<i class="col-md-6 col-md-offset-5 ace-icon fa fa-spinner fa-spin orange fa-5x center" id="loading"></i>');
																},
																success : function(
																		data) {

																	console
																			.log(
																					"SUCCESS: ",
																					data);

																	$(
																			'#dialogues-tab')
																			.empty();
																	$(
																			'#dialogues-tab')
																			.html(
																					data);
																	$(
																			'#is-dialogues-loaded')
																			.text(
																					'yes')
																},
																error : function(
																		e) {
																	console
																			.log(
																					"ERROR: ",
																					e);

																},
																done : function(
																		e) {
																	console
																			.log("DONE");
																	$(
																			'#loading')
																			.remove();

																}
															});
												}
											});

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
