<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>
	<div
		class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<jsp:include page="/common/othersheader.jsp"></jsp:include>
		<!-- Theme settings removed from here -->
		<div class="app-main">
			<jsp:include page="/common/othersmenu.jsp"></jsp:include>
			<div class="app-main__outer">
				<div class="app-main__inner">
					<div class="app-page-title">
						<div class="page-title-wrapper">
							<div class="page-title-heading">
								<div class="page-title-icon">
									<i class="pe-7s-car icon-gradient bg-mean-fruit"> </i>
								</div>
								<div>
									Analytics Dashboard
									<div class="page-title-subheading">This is an example
										dashboard created using build-in elements and components.</div>
								</div>
							</div>
							<div class="page-title-actions">
								<button type="button" data-toggle="tooltip"
									title="Example Tooltip" data-placement="bottom"
									class="btn-shadow mr-3 btn btn-dark">
									<i class="fa fa-star"></i>
								</button>
								<div class="d-inline-block dropdown">
									<button type="button" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"
										class="btn-shadow dropdown-toggle btn btn-info">
										<span class="btn-icon-wrapper pr-2 opacity-7"> <i
											class="fa fa-business-time fa-w-20"></i>
										</span> Buttons
									</button>
									<div tabindex="-1" role="menu" aria-hidden="true"
										class="dropdown-menu dropdown-menu-right">
										<ul class="nav flex-column">
											<li class="nav-item"><a href="javascript:void(0);"
												class="nav-link"> <i class="nav-link-icon lnr-inbox"></i>
													<span> Inbox </span>
													<div class="ml-auto badge badge-pill badge-secondary">86</div>
											</a></li>
											<li class="nav-item"><a href="javascript:void(0);"
												class="nav-link"> <i class="nav-link-icon lnr-book"></i>
													<span> Book </span>
													<div class="ml-auto badge badge-pill badge-danger">5</div>
											</a></li>
											<li class="nav-item"><a href="javascript:void(0);"
												class="nav-link"> <i class="nav-link-icon lnr-picture"></i>
													<span> Picture </span>
											</a></li>
											<li class="nav-item"><a disabled
												href="javascript:void(0);" class="nav-link disabled"> <i
													class="nav-link-icon lnr-file-empty"></i> <span>
														File Disabled </span>
											</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						
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
