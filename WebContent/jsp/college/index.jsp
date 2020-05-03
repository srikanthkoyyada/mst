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
			<div class="app-main__outer" style="padding: 0px;">
				<div class="app-main__inner" style="padding: 0px;">
					<div class="row" style="padding: 0px;">
	                    <img src="<%=request.getContextPath() %>/img/others.png" style="width: 100%; height: 620px;"/>
	                        <!-- <div class="main-card mb-3 card">
	                            <div class="card-body">
	                                <h5 class="card-title">Basic Bootstrap 4 Carousel</h5>
	                                <div id="carouselExampleControls1" class="carousel slide" data-ride="carousel">
	                                    <div class="carousel-inner">
	                                        <div class="carousel-item">
	                                            <img class="d-block w-100" src="https://via.placeholder.com/800x400" alt="First slide">
	                                        </div>
	                                        <div class="carousel-item active">
	                                            <img class="d-block w-100" src="https://via.placeholder.com/800x400" alt="Second slide">
	                                        </div>
	                                        <div class="carousel-item">
	                                            <img class="d-block w-100" src="https://via.placeholder.com/800x400" alt="Third slide">
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
	                        </div> -->
	                    
	                    <!-- <div class="col-md-5"></div> -->
					</div>
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
			$('#home').addClass('mm-active');
		});
	</script>
</body>
</html>