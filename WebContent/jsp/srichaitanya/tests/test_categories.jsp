<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.msb.constants.MsbConstants" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tests | My Super Talent</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="Know about what you can get at MySuperTalent.com">
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
									Tests
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
											<h5 class="card-title">Choose your standard</h5>
												<div class="mb-3">
													<div role="group" class="btn-group-sm nav btn-group">
														<a data-toggle="tab" href="#tab-eg12-0" style="margin-bottom: 10px;"
															class="btn-pill pl-3 btn btn-warning active">Junior Genius (Grades 1-3)</a>
														<a data-toggle="tab" href="#tab-eg12-1" style="margin-bottom: 10px;"
															class="btn btn-info">Prime Prodigy(Grades 4-6)</a>
														<a data-toggle="tab" href="#tab-eg12-2" style="margin-bottom: 10px;"
															class="btn-pill pr-3  btn btn-danger">Talented Teens (Grades 7-9)</a>
														<a data-toggle="tab" href="#tab-eg12-3" style="margin-bottom: 10px;"
															class="btn-pill pr-3  btn btn-success">Super Seniors (Grades 10-12)</a>
													</div>
												</div>
							
												<div class="tab-content">
													<div class="tab-pane show active" id="tab-eg12-0" role="tabpanel">
														<h4 class="center alert alert-warning">Junior Genius</h4>
														<div class="space-12"></div>
														<div style="margin-left: 120px;" id="kidload">
															<%-- <c:forEach items="${quizGenres}" var="genre">
																<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/${client}/${MsbConstants.KIDS}/${genre.genre_id}/0"><img alt=""
																	src="<%=request.getContextPath()%>/img/quiz/${genre.genre_id}.png"
																	class="img-rounded" height="160px" width="160px"></a>
															</c:forEach> --%>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/KID/3/0"><img alt=""
																	src="<%=request.getContextPath()%>/img/quiz/3.png"
																	class="img-rounded" height="160px" width="160px"></a>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/KID/5/0"><img alt=""
																	src="<%=request.getContextPath()%>/img/quiz/5.png"
																	class="img-rounded" height="160px" width="160px"></a>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/KID/6/0"><img alt=""
																	src="<%=request.getContextPath()%>/img/quiz/6.png"
																	class="img-rounded" height="160px" width="160px"></a>
														</div>
													</div>
													<div class="tab-pane" id="tab-eg12-1" role="tabpanel">
														<h4 class="center alert alert-info">Prime Prodigy</h4>
														<div class="space-12"></div>
														<div style="margin-left: 120px;" id="junload">												
															<%-- <c:forEach items="${quizGenres}" var="genre">												
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/${client}/${MsbConstants.JUNIOR}/${genre.genre_id}/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/${genre.genre_id}.png"
																class="img-rounded" height="160px" width="160px"></a>												
															</c:forEach> --%>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/JUN/1/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/1.png"
																class="img-rounded" height="160px" width="160px"></a>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/JUN/3/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/3.png"
																class="img-rounded" height="160px" width="160px"></a>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/JUN/5/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/5.png"
																class="img-rounded" height="160px" width="160px"></a>
															<%-- <a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/JUN/6/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/6.png"
																class="img-rounded" height="160px" width="160px"></a> --%>
														</div>
													</div>
							
													<div class="tab-pane" id="tab-eg12-2" role="tabpanel">
														<h4 class="center alert alert-danger">Talented Teens</h4>
														<div class="space-12"></div>				
														<div style="margin-left: 120px;" id="senload">											
															<%-- <c:forEach items="${quizGenres}" var="genre">
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/${client}/${MsbConstants.SENIOR}/${genre.genre_id}/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/${genre.genre_id}.png"
																class="img-rounded" height="160px" width="160px"></a>
															</c:forEach> --%>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/SEN/1/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/1.png"
																class="img-rounded" height="160px" width="160px"></a>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/SEN/2/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/2.png"
																class="img-rounded" height="160px" width="160px"></a>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/SEN/3/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/3.png"
																class="img-rounded" height="160px" width="160px"></a>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/SEN/5/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/5.png"
																class="img-rounded" height="160px" width="160px"></a>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/SEN/6/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/6.png"
																class="img-rounded" height="160px" width="160px"></a>
							
														</div>
													</div>
													
													<div class="tab-pane" id="tab-eg12-3" role="tabpanel">
														<h4 class="center alert alert-success">Super Seniors</h4>
														<div class="space-12"></div>				
														<div style="margin-left: 120px;" id="senload">											
															<%-- <c:forEach items="${quizGenres}" var="genre"> --%>
															<a href="${pageContext.servletContext.contextPath}/srichaitanya/tests/sc/SSEN/3/0"><img alt=""
																src="<%=request.getContextPath()%>/img/quiz/3.png"
																class="img-rounded" height="160px" width="160px"></a>
															<%-- </c:forEach> --%>
							
														</div>
													</div>
												</div>
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

	<script type="text/javascript">
		$('document').ready(function(){
			$('[data-toggle=tooltip]').tooltip();
		});
	</script>
	<script>
	$(function(){
	    
	    $('.tabsclick').click(function () {
            $('#senload').hide();
            $('#junload').hide();
            $('#kidload').hide();
	    	setTimeout(function(){
	            $('#loadbar').fadeOut();
	            $('#senload').show();
	            $('#junload').show();
	            $('#kidload').show();
	    	}, 100);
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