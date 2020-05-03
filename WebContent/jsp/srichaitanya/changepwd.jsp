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
<title>Change Password | My Super Talent</title>
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
									Change Password
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
										<div class="col-md-12">
											<c:if test="${param.invalid eq true }">
												<div class="alert alert-warning">You entered a wrong
													current password</div>
											</c:if>
											<c:if test="${param.success eq true }">
												<div class="alert alert-success">Password changed
													successfully</div>
											</c:if>
											<c:if test="${param.success eq false }">
												<div class="alert alert-danger">There is a technical
													problem.Please try later.</div>
											</c:if>
											<div id="loginbox" style="margin-top: 50px;"
												class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
												<div class="panel panel-info">
													<div class="panel-heading">
														<div class="panel-title"></div>
													</div>
													<div style="padding-top: 30px" class="panel-body">
														<form method="POST" id="changepwd-form" action="" class="">


															<h4 class="header blue bolder smaller">Change
																Password</h4>
															<div class="space-10"></div>
															<div class="position-relative form-group"">
																<label class="col-sm-4 control-label no-padding-right"
																	for="form-field-pwd">Old Password</label>

																<div class="col-sm-8">
																	<input class="col-xs-12 col-sm-10" type="password"
																		placeholder="Current Password" name="oldpwd"
																		id="oldpwd">
																</div>
															</div>
															<div class="position-relative form-group"">
																<label class="col-sm-4 control-label no-padding-right"
																	for="form-field-npwd">New Password</label>

																<div class="col-sm-8">
																	<input class="col-xs-12 col-sm-10" type="password"
																		placeholder="New Password" name="newpwd" id="newpwd">
																</div>
															</div>
															<div class="position-relative form-group"">
																<label class="col-sm-4 control-label no-padding-right"
																	for="form-field-username">Confirm Password</label>

																<div class="col-sm-8">
																	<input class="col-xs-12 col-sm-10" type="password"
																		placeholder="Confirm Password" name="newcpwd"
																		id="newcpwd">
																</div>
															</div>
															<div class="space-24"></div>
															<div class="clearfix form-actions">
																<div class="col-md-offset-3 col-md-9">
																	<button id="changepwd-submit" class="btn btn-success"
																		data-loading-text="Please Wait....." type="submit">
																		<i class="ace-icon fa fa-check bigger-110"></i> Change
																	</button>
																	&nbsp;&nbsp;&nbsp;
																	<button class="btn btn-primary" type="reset">
																		<i class="ace-icon fa fa-refresh bigger-110"></i>
																		Reset
																	</button>

																</div>
															</div>
														</form>

													</div>
												</div>
											</div>
											<!-- PAGE CONTENT ENDS -->
										</div>
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
	<script>
		$('document').ready(function() {
			//$('#home').addClass('mm-active');
		});
	</script>
	<script>
		jQuery.validator.addMethod("notEqual", function(value, element, param) {
			return this.optional(element) || value != $(param).val();
		}, "Old and New Password can not be same");
		$(document).ready(function($) {
			$('#changepwd-form').validate({
				debug : true,
				errorElement : 'div',
				errorClass : 'col-sm-12 error-msg',
				focusInvalid : true,
				rules : {
					oldpwd : {
						required : true
					},
					newpwd : {
						required : true,
						minlength : 8,
						maxlength : 15,
						notEqual : "#oldpwd"
					},
					newcpwd : {
						equalTo : "#newpwd"
					}

				},
				messages : {

					newcpwd : {
						equalTo : "new and confirm password must be same"
					}

				},
				submitHandler : function(form) {
					form.submit();

				}

			});

		});
	</script>
</body>
</html>