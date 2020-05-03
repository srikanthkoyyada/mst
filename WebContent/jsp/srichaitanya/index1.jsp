<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome | MySuperTalent</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="This is the best plotform for a common man to showcase their skills.">
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
			<div class="app-main__outer" style="padding: 0px;">
				<div class="app-main__inner" style="padding: 0px;">
					<div class="row d-none d-lg-block" style="padding: 0px;">
						<img src="<%=request.getContextPath()%>/img/others.png"
							style="height: 620px;" />
					</div>
					<div class="row d-block d-sm-none" style="padding: 0px;">
						<img src="<%=request.getContextPath()%>/img/sc-mobile.png" />
					</div>
					<div class="row">
						<div class="col-md-12 text-center">
						<div class="main-card mb-3 card">
							<div class="card-body">
								<h5 class="card-title">Responsive</h5>
								<div class="slick-slider-responsive slick-initialized slick-slider slick-dotted">
									
									<div class="slick-list draggable">
										<div class="slick-track"
											style="opacity: 1; width: 1520px;">
											<div class="slick-slide slick-current slick-active"
												
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<img src="<%=request.getContextPath()%>/img/SCS891493_85.jpg"
														style="width: 100%;" class="img-responsive" /></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="1"
												aria-hidden="false" role="tabpanel" id="slick-slide41"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<img src="<%=request.getContextPath()%>/img/SCS891493_85.jpg"
														style="width: 100%;" class="img-responsive" /></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="2"
												aria-hidden="false" role="tabpanel" id="slick-slide42"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<img src="<%=request.getContextPath()%>/img/SCS891493_85.jpg"
														style="width: 100%;" class="img-responsive" /></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="3"
												aria-hidden="false" role="tabpanel" id="slick-slide43"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<img src="<%=request.getContextPath()%>/img/SCS891493_85.jpg"
														style="width: 100%;" class="img-responsive" /></div>
													</div>
												</div>
											</div>
											<div class="slick-slide" data-slick-index="4"
												aria-hidden="true" role="tabpanel" id="slick-slide44"
												aria-describedby="slick-slide-control41" tabindex="-1"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<img src="<%=request.getContextPath()%>/img/SCS891493_85.jpg"
														style="width: 100%;" class="img-responsive" /></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						
					</div>



			<%-- <h4>PAINTING</h4>
			<div class="col-md-3">
				<div class="thumbnail">
					<img src="<%=request.getContextPath()%>/img/SCS891493_85.jpg"
						style="width: 100%;" class="img-responsive" />
				</div>
			</div>
			<div class="col-md-9"></div> --%>
		</div>
		<!-- <div class="col-md-12 alert alert-light text-center">
			<h4>MUSIC</h4>
			<div class="col-md-3">
				<video width="100%" height="255" poster="placeholder.png" controls>
					<source
						src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS224990_35.mp4"
						type="video/mp4">
				</video>
				<a
					href="http://mysupertalent.com/srichaitanya/view/mst_competition/35"
					target="_blank"> GO TO ENTRY PAGE </a>
			</div>
		</div> -->
					

				</div>
				<jsp:include page="/common/footer.jsp"></jsp:include>
			</div>
			<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
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
			$('#home').addClass('mm-active');
		});
	</script>
</body>
</html>