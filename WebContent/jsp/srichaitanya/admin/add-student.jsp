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
<title>Add Student | My Super Talent</title>
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
<link href="<%=request.getContextPath()%>/assets/summernote/summernote.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/main.cba69814a806ecc7945a.css"
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
									Add Student
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
											<c:if test="${param.success eq true}">
												<div class="alert alert-success">Student added
													successfully
													<p>Use Admission number as Username and Password in CAPITALS</p></div>

											</c:if>
											<c:if test="${param.success eq false}">
												<div class="alert alert-warning">There is a technical
													problem..! Try again later</div>

											</c:if>
											<form class="" method="post" action="<%=request.getContextPath()%>/srichaitanya/add-student"
												id="addstudent-form">
											<%-- <form class=""
												action="<%=request.getContextPath()%>/srichaitanya/add-student"
													method="post" id="addstudent-form" enctype="multipart/form-data"> --%>
												
													<div class="position-relative form-group">
														<label for="exampleName" class="">Name</label><input
															name="name" id="name" placeholder="Name here..."
															type="text" class="form-control"><%-- <form:errors path="name" /> --%>
														
													</div>
													<div class="position-relative form-group">
														<label for="exampleName" class="">Admission Number</label><input
															name="username" id="username"
															placeholder="User Name here..." type="text"
															class="form-control"><%-- <form:errors path="username" /> --%>
													</div>
													<div class="position-relative form-group">
														<label for="exampleEmail11" class="">Zone</label>
														<input type="text" class="form-control" name="school"
															id="school" /><%-- <form:errors path="school" /> --%>
													</div>
													<div class="position-relative form-group">
														<label for="exampleEmail11" class="">Class</label>
														<select name="standard" id="standard" class="form-control">
															<option value="">Select Class</option>
															<option value="1">1<sup>st</sup> Class</option>
															<option value="2">2<sup>nd</sup> Class</option>
															<option value="3">3<sup>rd</sup> Class</option>
															<option value="4">4<sup>th</sup> Class</option>
															<option value="5">5<sup>th</sup> Class</option>
															<option value="6">6<sup>th</sup> Class</option>
															<option value="7">7<sup>th</sup> Class</option>
															<option value="8">8<sup>th</sup> Class</option>
															<option value="9">9<sup>th</sup> Class</option>
														</select><%-- <form:errors path="standard" /> --%>
													</div>
													<div class="position-relative form-group">
														<label for="exampleFile" class="">City</label>
														<input type="text" class="form-control" name="city"
															id="city" /><%-- <form:errors path="city" /> --%>
                                                    </div>
                                                    <div class="position-relative form-group">
														<label for="exampleEmail11" class="">Branch</label>
														<input type="text" class="form-control"
															id="branch" name="branch" /><%-- <form:errors path="branch" /> --%>
													</div>
													<%-- <div class="position-relative form-group">
														<label for="exampleEmail11" class="">Zone</label>
														<input type="text" class="form-control"
															id="zone" name="zone" /><form:errors path="zone" />
													</div> --%>
													<div class="position-relative form-group">
														<label for="exampleEmail11" class="">State</label>
														<input type="text" class="form-control"
															id="state" name="state" /><%-- <form:errors path="state" /> --%>
													</div>
													
												
												<button type="submit" class="mt-2 btn btn-primary">Submit</button>
											</form>
										</div>
										<div class="col-md-3">
											
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

	<script type="text/javascript">
		$('document').ready(function() {
				$('[data-toggle=tooltip]').tooltip();

				$('#addstudent-form').validate({
					errorElement : 'div',
					errorClass : 'error-msg',
					focusInvalid : true,

					rules : {
						name : {
							required : true
						},
						username : {
							required : true
						},
						school : {
							required : true
						},
						city : {
							required : true
						},
						branch : {
							required : true
						},
						state : {
							required : true
						}

					},
					messages : {

					},

					submitHandler : function(form) {
						$('#addstudent-form button[type=submit]').prop("disabled", "disabled");
						form.submit();
					}

				});
			});
	</script>
</body>
</html>