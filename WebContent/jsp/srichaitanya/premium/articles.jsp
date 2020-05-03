<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Blog | My Super Talent</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="This is an example dashboard created using build-in elements and components.">
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
									<i class="pe-7s-news-paper icon-gradient bg-mean-fruit"> </i>
								</div>
								<div>
									Blog Articles
									<!-- <div class="page-title-subheading">This is an example
										dashboard created using build-in elements and components.</div> -->
								</div>
							</div>
						</div>
					</div>
					<div class="tab-content">
						<div class="tab-pane tabs-animation fade show active"
							id="tab-content-0" role="tabpanel">
							<div class="main-card mb-3 card">
								<div class="card-body">
											<c:choose>
												<c:when test="${isPremium eq true }">
													<div class="row">
														<div class="col-md-9">
															<h3>Blog Categories :</h3>
															<ol>
																<li><a href="<%=request.getContextPath() %>/srichaitanya/premium/articles/technology/0">Technology</a></li>
																<li><a href="<%=request.getContextPath() %>/srichaitanya/premium/articles/history/0">History</a></li>
															</ol>
														</div>
														<div class="col-md-3">
															<a href="<%=request.getContextPath() %>/srichaitanya/user/write-article"
																class="btn btn-warning btn-block">WRITE AN ARTICLE</a>
														</div>
													</div>
												</c:when>
												<c:otherwise>
													<div class="row">
														<div class="col-md-9">
															<div class="text-center">
																<h4>You are not a premium user.</h4>
																<h5>Click below to get premium account.</h5>
																<%-- <a id="payment" class="im-checkout-btn text-center"
																	href="https://www.instamojo.com/mysuperbrain/premium-account-quarterly/?data_amount=500&data_readonly=data_amount&data_name=${SchoolStudent.username}&data_readonly=data_name&data_email=${SchoolStudent.mail}&data_phone=${SchoolStudent.phone}"
																	rel="im-checkout" data-text="MAKE PAYMENT" data-css-style="color:#ffffff; background:#1273de; width:300px; border-radius:4px"   data-layout="vertical"></a>
																<script src="https://js.instamojo.com/v1/button.js"></script> --%>
																<a href="https://www.instamojo.com/mysuperbrain/premium-account-quarterly/" rel="im-checkout" data-text="MAKE PAYMENT" data-css-style="color:#ffffff; background:#1273de; width:300px; border-radius:4px"   data-layout="vertical"></a>
																<script src="https://js.instamojo.com/v1/button.js"></script>
															</div>
														</div>
														<div class="col-md-3">
															<a href="https://www.instamojo.com/mysuperbrain/premium-account-quarterly/" rel="im-checkout" data-text="GET PREMIUM ACCOUNT" class="btn btn-info btn-block"  data-layout="vertical"></a>
															<script src="https://js.instamojo.com/v1/button.js"></script>
														</div>
													</div>
												</c:otherwise>
											</c:choose>
											<!-- PAGE CONTENT ENDS -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="/common/footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
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
			//$('#home').addClass('mm-active');
		});
	</script>
</body>
</html>