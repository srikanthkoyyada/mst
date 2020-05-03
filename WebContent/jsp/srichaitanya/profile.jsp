<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Profile | My Super Talent</title>
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
									<i class="pe-7s-user icon-gradient bg-mean-fruit"> </i>
								</div>
								<div>
									${user.name }'s Profile
									<!-- <div class="page-title-subheading">This is an example
										dashboard created using build-in elements and components.</div> -->
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div
								class="card-shadow-primary profile-responsive card-border mb-3 card">
								<div class="dropdown-menu-header">
									<div class="dropdown-menu-header-inner bg-focus">
										<div class="menu-header-image opacity-3"
											style="background-image: url('<%=request.getContextPath()%>/assets/images/dropdown-header/city4.jpg');"></div>
										<div class="menu-header-content btn-pane-right">
											<div class="avatar-icon-wrapper mr-2 avatar-icon-xl">
												<div class="avatar-icon rounded">
													<img
														src="<%=request.getContextPath()%>/resources/DisplaySchoolUserProfileImage"
														alt="Avatar 5">
												</div>
											</div>
											<div>
												<h5 class="menu-header-title">${user.name }</h5>
												<h6 class="menu-header-subtitle">${user.branch }</h6>
											</div>
											<div class="menu-header-btn-pane">
												<button class="ladda-button btn btn-pill btn-dark"
													data-style="slide-right">
													<span class="ladda-label">Points : ${user.points }</span><span
														class="ladda-spinner"></span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<ul class="list-group list-group-flush">
									<li class="list-group-item">
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">

												<div class="widget-content-left">
													<div class="widget-heading">Writing Entries</div>
												</div>
												<div class="widget-content-right">
													<div class="widget-numbers widget-numbers-sm text-primary">
														<span>${write }</span>
													</div>
												</div>
											</div>
										</div>
									</li>
									<li class="list-group-item">
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">

												<div class="widget-content-left">
													<div class="widget-heading">Poetry Entries</div>
												</div>
												<div class="widget-content-right">
													<div class="widget-numbers widget-numbers-sm text-warning">
														<span>${poetry }</span>
													</div>
												</div>
											</div>
										</div>
									</li>
									<li class="list-group-item">
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left">
													<div class="widget-heading">Dance Entries</div>
												</div>
												<div class="widget-content-right">
													<div class="widget-numbers widget-numbers-sm text-danger">
														<span>${dance }</span>
													</div>
												</div>
											</div>
										</div>
									</li>
									<li class="list-group-item">
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left">
													<div class="widget-heading">Music Entries</div>
												</div>
												<div class="widget-content-right">
													<div class="widget-numbers widget-numbers-sm text-info">
														<span>${music }</span>
													</div>
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
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
		<script>
			$('document').ready(function(){
				if($('#premium').val()==0){
					$('#clickForPremium').click();
				}
			});
		</script>
</body>
</html>
