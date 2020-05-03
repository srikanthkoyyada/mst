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
<title>Competitions | My Super Talent</title>
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
									<i class="pe-7s-target icon-gradient bg-mean-fruit"> </i>
								</div>
								<div>
									Competitions
									<!-- <div class="page-title-subheading">This is an example
										dashboard created using build-in elements and components.</div> -->
								</div>
							</div>

						</div>
					</div>
					<%-- <div class="row">
						<div class="col-md-6">
	                        <div class="mb-3 card text-white bg-primary">
	                            <div class="card-header">Music</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/mst_competition/music">PARTICIPATE
	                            </a>
	                        </div>
	                        <div class="mb-3 card text-white bg-success">
	                            <div class="card-header">Dance</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/mst_competition/dance">PARTICIPATE
	                            </a>
	                        </div>
	                        <div class="mb-3 card text-white bg-warning">
	                            <div class="card-header">Writing</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/text_competition/writing">PARTICIPATE
	                            </a>
	                        </div>
	                        <div class="mb-3 card text-white bg-dark">
	                            <div class="card-header">Poetry</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/text_competition/poetry">PARTICIPATE
	                            </a>
	                        </div>
	                        <div class="mb-3 card text-white bg-info">
	                            <div class="card-header">Cooking</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/mst_competition/cooking">PARTICIPATE
	                            </a>
	                        </div>
	                        <div class="mb-3 card text-white bg-danger">
	                            <div class="card-header">Quiz</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/music_competition">PARTICIPATE
	                            </a>
	                        </div>
	                    </div>
	                    <div class="col-md-6">
	                        <div class="mb-3 card text-white bg-primary">
	                            <div class="card-header">Speaking</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/mst_competition/speaking">PARTICIPATE
	                            </a>
	                        </div>
	                        <div class="mb-3 card text-white bg-success">
	                            <div class="card-header">Jokes</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/multi_competition/jokes">PARTICIPATE
	                            </a>
	                        </div>
	                        <div class="mb-3 card text-white bg-warning">
	                            <div class="card-header">Sports</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/mst_competition/sports">PARTICIPATE
	                            </a>
	                        </div>
	                        <div class="mb-3 card text-white bg-dark">
	                            <div class="card-header">Painting</div>
	                            <div class="card-body">With supporting text below as a natural lead-in to additional content.</div>
	                            <a class="card-footer"
	                            	 href="<%=request.getContextPath() %>/srichaitanya/user/mst_competition/painting">PARTICIPATE
	                            </a>
	                        </div>
	                    </div>
					</div> --%>
					<div class="row text-center">
						<div class="col-md-4">
							<div class="alert ">
								<a
									href="<%=request.getContextPath()%>/srichaitanya/tests/sc">
									<img
									src="<%=request.getContextPath()%>/assets/images/competitions/quiz.png" />
								<h5>QUIZ</h5>
								</a>
							</div>
						</div>
						<div class="col-md-4">
							<div class="alert ">
								<a
									href="<%=request.getContextPath()%>/srichaitanya/music/competition-list">
									<img
									src="<%=request.getContextPath()%>/assets/images/competitions/Music.png" />
								<h5>MUSIC</h5>
								</a>
							</div>
						</div>
						<div class="col-md-4">
							<div class="alert ">
								<a
									href="<%=request.getContextPath()%>/srichaitanya/dance/competition-list">
									<img
									src="<%=request.getContextPath()%>/assets/images/competitions/Dance.png" />
								<h5>DANCE</h5>
								</a>
							</div>
						</div>
						<div class="col-md-4">
							<div class="alert ">
								<a
									href="<%=request.getContextPath()%>/srichaitanya/painting/competition-list">
									<img
									src="<%=request.getContextPath()%>/assets/images/competitions/Painting.png" />
								<h5>PAINTING</h5>
								</a>
							</div>
						</div>
						<div class="col-md-4">
							<div class="alert ">
								<a
									href="<%=request.getContextPath()%>/srichaitanya/writing/competition-list">
									<img
									src="<%=request.getContextPath()%>/assets/images/competitions/Writing.png" />
								<h5>WRITING</h5>
								</a>
							</div>
						</div>
						<div class="col-md-4">
							<div class="alert ">
								<a
									href="<%=request.getContextPath()%>/srichaitanya/speaking/competition-list">
									<img
									src="<%=request.getContextPath()%>/assets/images/competitions/Speaking.png" />
								<h5>SPEAKING</h5>
								</a>
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
				$('#competitions').addClass('mm-active');
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