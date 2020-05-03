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
<title>Articles List | My Super Talent</title>
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
	href="<%=request.getContextPath()%>/assets/summernote/summernote.css"
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
									Articles List
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
									<div class="row">
										<div class="col-md-9">
											<c:choose>
												<c:when test="${isPremium eq true }">
													<c:if test="${not empty articles }">
														<table class="table" id="blog">
															<thead style="display: none;">
																<tr>
																	<th></th>
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${articles}" var="article">
																	<tr>
																		<td>
																			<!-- POST BODY -->
																			<div class="alert alert-dark">
																				<div class="post-title">
																					<h3 class="md">
																						<a
																							href="<%=request.getContextPath()%>/srichaitanya/premium/article/${article.article_id}">${article.title}</a>
																					</h3>
																				</div>
																				<div class="pull-right">
																					by <a href="#">${article.user_saved}</a> on
																					${article.date_created}
																				</div>
																				<div class="space-10"></div>
																				<div class="post-content">
																					<p align="justify">${article.summary}</p>
																				</div>
																				<div class="post-link">
																					<a class="btn btn-success"
																						href="<%=request.getContextPath()%>/srichaitanya/premium/article/${article.article_id}">
																						<i class="fa fa-play-circle-o"></i> Read More
																					</a>
																				</div>
																			</div> <!-- END / POST BODY -->
																		</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
														<%-- <c:if test="${totalArticlesCount gt 10 }">
														<div align="right">
															<tag:paginate max="10" offset="${offset}"
																count="${totalArticlesCount}"
																uri="${pageContext.servletContext.contextPath}/srichaitanya/premium/articles/${category}"
																next="Next" previous="Previous" />
														</div>
													</c:if> --%>
													</c:if>
													<c:if test="${empty articles }">
														<h3>There are no articles in this category.</h3>
													</c:if>
												</c:when>
												<c:otherwise>
													<div class="text-center">
														<h4>You are not a premium user.</h4>
														<h5>Click below to get premium account.</h5>
														<%-- <a id="payment" class="im-checkout-btn text-center"
														href="https://www.instamojo.com/mysuperbrain/premium-account-quarterly/?data_amount=500&data_readonly=data_amount&data_name=${SchoolStudent.username}&data_readonly=data_name&data_email=${SchoolStudent.mail}&data_phone=${SchoolStudent.phone}"
														rel="im-checkout" data-text="MAKE PAYMENT" data-css-style="color:#ffffff; background:#1273de; width:300px; border-radius:4px"   data-layout="vertical"></a>
													<script src="https://js.instamojo.com/v1/button.js"></script> --%>
														<a
															href="https://www.instamojo.com/mysuperbrain/premium-account-quarterly/"
															rel="im-checkout" data-text="MAKE PAYMENT"
															data-css-style="color:#ffffff; background:#1273de; width:300px; border-radius:4px"
															data-layout="vertical"></a>
														<script src="https://js.instamojo.com/v1/button.js"></script>
													</div>
												</c:otherwise>
											</c:choose>

										</div>
										<div class="col-md-3">
											<a href="<%=request.getContextPath() %>/srichaitanya/user/write-article"
												class="btn btn-warning btn-block">WRITE AN ARTICLE</a>

											<!-- WIDGET CATEGORIES -->
											<div class="widget widget_categories">
												<h4 class="sm">Categories</h4>
												<ul style="font-size: 13px;">
													<c:forEach items="${categories}" var="category">
														<li><a
															href="<%=request.getContextPath()%>/srichaitanya/premium/articles/${category}/0">${category}</a></li>
													</c:forEach>

												</ul>
											</div>
											<!-- END / WIDGET CATEGORIES -->

											<!-- WIDGET RECENT POST -->
											<div class="widget widget_recent_post">
												<h4 class="sm">Recent posts</h4>
												<ul>
													<c:forEach items="${recentArticles}" var="article">
														<li><a
															href="<%=request.getContextPath()%>/srichaitanya/premium/article/${article.article_id}">${article.title}</a>
														</li>
													</c:forEach>

												</ul>
											</div>
											<!-- END / WIDGET RECENT POST -->
											<div class="space-12"></div>

										</div>
										<!-- /.col -->
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

	<!-- [if lte IE 8]> -->
	<script src="<%=request.getContextPath()%>/assets/js/excanvas.js"></script>
	<!-- [endif] -->
	<script
		src="<%=request.getContextPath()%>/assets/summernote/summernote.js"></script>

	<script type="text/javascript">
		$('document').ready(function() {
			$('[data-toggle=tooltip]').tooltip();
		});
	</script>
</body>
</html>