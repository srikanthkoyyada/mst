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
<title>Login | MySuperTalent</title>
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
									<i class="pe-7s-key icon-gradient bg-mean-fruit"> </i>
								</div>
								<div>
									User Login
									<div class="page-title-subheading"><a href="<%=request.getContextPath()%>/others/register">Not yet Registered ? Click Here</a></div>
								</div>
							</div>

						</div>
					</div>
					<div class="tab-content">
						<div class="tab-pane tabs-animation fade show active"
							id="tab-content-0" role="tabpanel">
							<div class="main-card mb-3 card col-sm-6 offset-sm-3">
								<div class="card-body">
									<c:if test="${param.invalidsession eq true }">
										<div class="alert alert-danger">Session Expired!/Login
											Required. Please login below</div>
									</c:if>
									<c:if test="${AuthError != null}">
										<div class="alert alert-warning">${AuthError }</div>
									</c:if>
									<div class="card-body">
										<h5 class="card-title">Login</h5>
										<div>
											<form:form method="POST" action="../others/validateLogin"
												modelAttribute="user" autocomplete="off" class="">
												<div class="position-relative row form-group">
													<label for="exampleEmail" class="col-sm-3 col-form-label">Email/Username</label>
		                                            <div class="col-sm-8">
		                                            	<input name="username" id="username" placeholder="Email/Username" type="text" class="form-control">
		                                            </div>
		                                        </div>
		                                        <div class="position-relative row form-group">
		                                        	<label for="examplePassword" class="col-sm-3 col-form-label">Password</label>
		                                            <div class="col-sm-8">
		                                            	<input name="password" id="password" placeholder="password" type="password" class="form-control">
		                                            </div>
		                                        </div>
												<input type="hidden" name="next" value="${param.next }">
												<div class="position-relative row form-check">
		                                            <div class="col-sm-10 offset-sm-2">
		                                                <button class="btn btn-secondary" type="Submit">Sign In</button>
		                                            </div>
		                                        </div>
											</form:form>
											<div class="divider"></div>
											<a href="<%=request.getContextPath()%>/others/forgot"
												class="back-to-login-link"> <i
												class="ace-icon fa fa-arrow-left"></i> &nbsp;Forgot
												Password? Click here to Recover
											</a>
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
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/assets/scripts/main.js"></script>
</body>
</html>