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
<title>Music | My Super Talent</title>
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
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
</head>
<body>
	<div
		class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<jsp:include page="/common/schoolheader.jsp"></jsp:include>
		<!-- Theme settings removed from here -->
		<div class="app-main">
			<jsp:include page="/common/schoolmenu.jsp"></jsp:include>
			<div class="app-main__outer">
				<div class="app-main__inner">
					<div class="app-page-title">
						<div class="page-title-wrapper">
							<div class="page-title-heading">
								<div class="page-title-icon">
									<i class="pe-7s-news-paper icon-gradient bg-mean-fruit"> </i>
								</div>
								<div>
									Music
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
										<div class="col-md-8">
											<c:choose>
												<c:when test="${isPremium eq true }">
													<div class="row text-center">
														<table class="table no-footer" id="music" style="clear: none;">
															<thead><tr><th></th></tr>
															</thead>
															<tbody>
																<tr>
																	<td>
																		<h4>Introduction</h4>
																		<iframe src="https://player.vimeo.com/video/165735705" style="width: 100%;"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 1</h4>
																		<iframe src="https://player.vimeo.com/video/165910924" style="width: 100%;"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 2</h4>
																		<iframe src="https://player.vimeo.com/video/165910933"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 3</h4>
																		<iframe src="https://player.vimeo.com/video/166200594"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 4</h4>
																		<iframe src="https://player.vimeo.com/video/166200930"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 5</h4>
																		<iframe src="https://player.vimeo.com/video/168337871"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 6</h4>
																		<iframe src="https://player.vimeo.com/video/168338391"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 7</h4>
																		<iframe src="https://player.vimeo.com/video/168338896"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 8</h4>
																		<iframe src="https://player.vimeo.com/video/168339442"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
																<tr>
																	<td>
																		<h4>Session 9</h4>
																		<iframe src="https://player.vimeo.com/video/168339891"
																			frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>
		
																	</td>
																</tr>
															</tbody>
														</table>
													</div>
													</c:when>
													<c:otherwise>
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
													</c:otherwise>
												</c:choose>
											<!-- PAGE CONTENT ENDS -->
										</div>
										<div class="col-md-3"></div>
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
  
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
	<script>
		$('document').ready(function() {
			//$('#home').addClass('mm-active');
			    $('#music').DataTable({
			    	//"dom": false,               //'<"top"i>rt<"bottom"flp><"clear">',
			    	//"fixedHeader": false,
				    //"LengthChange": false,
				    //"filter": false,
				    //"info": false,
				    //"AutoWidth": false,
			    	
			    	
			    	
			    	"pageLength" : 4,
			    	"ordering": false,
			    	"info":     false
					//"LengthChange" : false
					//"Length" : false
			    });
			//$('#crafts').dataTable({
				//'pageLength' : 2,
				//"aLengthMenu" : [ [ 4, 10, 20, -1 ], [ 4, 10, 20, "All" ] ]
			//});
			$('#music_length').hide();
			$('#music_filter').hide();
		});
	</script>
</body>
</html>