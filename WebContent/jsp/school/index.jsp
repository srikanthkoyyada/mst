<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome | My Super Talent</title>
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
<link href="<%=request.getContextPath()%>/assets/main.cba69814a806ecc7945a.css"
	rel="stylesheet">
<style>
.slider-item {
	max-height: 140px;
}
</style>
</head>
<body>
	<div
		class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<jsp:include page="/common/schoolheader.jsp"></jsp:include>
		<!-- Theme settings removed from here -->
		<div class="app-main">
			<jsp:include page="/common/schoolmenu.jsp"></jsp:include>
			<div class="app-main__outer">
				<div class="app-main__inner" style="padding: 0px;">
					<div class="row d-none d-lg-block">
						<img src="<%=request.getContextPath()%>/img/mstkidsimage.png" style="width: 100%;" />
					</div>
					<div class="row d-block d-sm-none" style="padding: 0px;">
						<img src="<%=request.getContextPath()%>/img/sc-mobile.png" style="width: 100%;" />
					</div>
					<div class="row d-none d-lg-block">
						<div class="main-card mb-3 card text-center">
							<div class="card-body">
								<h5 class="card-title">Paintings</h5>
								<div class="slick-slider-responsive slick-initialized slick-slider slick-dotted">
									<div class="slick-list draggable">
										<div class="slick-track"
											style="opacity: 1;">
											<div class="slick-slide slick-current slick-active"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<a href="http://mysupertalent.com/school/view/mst_competition/38"
																target="_blank"> <img src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS836357_38.jpg"
														style="width: 100%;" class="img-responsive" /></a></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="1"
												aria-hidden="false" role="tabpanel" id="slick-slide41"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<a href="http://mysupertalent.com/school/view/mst_competition/426"
																target="_blank"> <img src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS307716_426.57"
														style="width: 100%;" class="img-responsive" /></a></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="2"
												aria-hidden="false" role="tabpanel" id="slick-slide42"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<a href="http://mysupertalent.com/school/view/mst_competition/415"
																target="_blank"> <img src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS250336_415.jpg"
														style="width: 100%;" class="img-responsive" /></a></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="3"
												aria-hidden="false" role="tabpanel" id="slick-slide43"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<a href="http://mysupertalent.com/school/view/mst_competition/411"
																target="_blank"> <img src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS580656_411.JPG"
														style="width: 100%;" class="img-responsive" /></a></div>
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
															<a href="http://mysupertalent.com/school/view/mst_competition/410"
																target="_blank"> <img src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS568593_410.jpg"
														style="width: 100%;" class="img-responsive" /></a></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row d-block d-sm-none" style="padding: 0px;">
						<div class="main-card mb-3 card">
	                        <div class="card-body">
	                            <h5 class="card-title">Paintings</h5>
	                            <div id="carouselExampleControls1" class="carousel slide" data-ride="carousel">
	                                <div class="carousel-inner">
	                                    <div class="carousel-item active">
	                                        <a href="http://mysupertalent.com/school/view/mst_competition/38" target="_blank">
	                                        	<img class="d-block w-100" 
	                                        		src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS836357_38.jpg" alt="First slide">
	                                        </a>
	                                    </div>
	                                    <div class="carousel-item">
		                                    <a href="http://mysupertalent.com/school/view/mst_competition/426" target="_blank">
		                                        <img class="d-block w-100"
		                                        	src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS307716_426.57" alt="Second slide">
		                                    </a>
	                                    </div>
	                                    <div class="carousel-item">
	                                    	<a href="http://mysupertalent.com/school/view/mst_competition/415" target="_blank">
	                                        	<img class="d-block w-100" 
	                                        		src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS250336_415.jpg" alt="Third slide">
	                                        </a>
	                                    </div>
	                                    <div class="carousel-item">
	                                    	<a href="http://mysupertalent.com/school/view/mst_competition/411" target="_blank">
	                                        	<img class="d-block w-100" 
	                                        		src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS580656_411.JPG" alt="Fourth slide">
	                                        </a>
	                                    </div>
	                                    <div class="carousel-item">
	                                    	<a href="http://mysupertalent.com/school/view/mst_competition/410" target="_blank">
	                                        	<img class="d-block w-100" 
	                                        		src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS568593_410.jpg" alt="Fifth slide">
	                                        </a>
	                                    </div>
	                                </div>
	                                <a class="carousel-control-prev" href="#carouselExampleControls1" role="button" data-slide="prev">
	                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	                                    <span class="sr-only">Previous</span>
	                                </a>
	                                <a class="carousel-control-next" href="#carouselExampleControls1" role="button" data-slide="next">
	                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	                                    <span class="sr-only">Next</span>
	                                </a>
	                            </div>
	                        </div>
	                    </div>
					</div>
					<div class="row">
						<div class="main-card mb-3 card text-center">
							<div class="card-body">
								<h5 class="card-title">Music</h5>
								<div class="slick-slider-responsive slick-initialized slick-slider slick-dotted">
									<div class="slick-list draggable">
										<div class="slick-track"
											style="opacity: 1;">
											<div class="slick-slide slick-current slick-active"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<video style="width: 100%;" class="img-responsive" controls><source src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS573324_1070.mp4"
																class="img-responsive" type="video/mp4"></video></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="1"
												aria-hidden="false" role="tabpanel" id="slick-slide41"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<video style="width: 100%;" class="img-responsive" controls><source src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS472759_1117.mp4"
																class="img-responsive" type="video/mp4"></video></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="2"
												aria-hidden="false" role="tabpanel" id="slick-slide42"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<video style="width: 100%;" class="img-responsive" controls><source src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS481248_1091.mp4"
																class="img-responsive" type="video/mp4"></video></div>
													</div>
												</div>
											</div>
											<div class="slick-slide slick-active" data-slick-index="3"
												aria-hidden="false" role="tabpanel" id="slick-slide43"
												style="width: 250px;">
												<div>
													<div style="width: 100%; display: inline-block;">
														<div class="slider-item" style="background: #fff;">
															<video style="width: 100%;" class="img-responsive" controls><source src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS927513_495.mp4"
																class="img-responsive" type="video/mp4"></video></div>
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
															<video style="width: 100%;" class="img-responsive" controls><source src="http://mysupertalent.com/user_images/Comp_Sub/MST/SCS485780_430.mp4"
																class="img-responsive" type="video/mp4"></video></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="/common/footer.jsp"></jsp:include>
			</div>
			<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
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
			//$('#competitions').addClass('mm-active');
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
