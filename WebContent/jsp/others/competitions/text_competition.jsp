<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${type} Competition | MySuperTalent</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="Build whatever layout you need with our Architect framework.">
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
									<i class="pe-7s-pen icon-gradient bg-mixed-hopes"> </i>
								</div>
								<div>
									${type} Competition
									<div class="page-title-subheading">All Fields are mandatory.</div>
								</div>
							</div>
						</div>
					</div>

					<div class="tab-content">
						<div class="tab-pane tabs-animation fade show active"
							id="tab-content-0" role="tabpanel">
							<div class="main-card mb-3 card">
								<div class="card-body">
									<!-- <h5 class="card-title">Grid Rows</h5> -->
									<c:choose>
										<c:when test="${submissions_exceeded eq true}">
											<div class="col-md-121">
												<div class="alert alert-danger fade show">
													You reached maximum number of submissions for this
														entry! Please click on competitions to proceed.
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<form class=""
												action="<%=request.getContextPath()%>/others/user/submit-text-competition"
												method="post" id="text-form" enctype="multipart/form-data">
												
													<div class="position-relative form-group">
														<label for="exampleEmail11" class="">Summary of
															your ${type }</label>
														<textarea class="form-control"
															id="summary" name="summary">
														</textarea>
													</div>
													<input type="hidden" name="entry_type" value="${type}" />
													<input type="hidden" name="comp_id" value="${competition.comp_id }" />
													<input type="hidden" name="category" value="${competition.comp_category }" />
													<input type="hidden" name="user_category" value="3" />
													<div class="position-relative form-group">
														<label for="exampleFile" class="">Enter Your ${type} here</label>
														<textarea id="content" name="content" class="form-control"
															style="overflow-y: scroll; word-wrap: break-word; resize: horizontal; height: 272px;"></textarea>
                                                    </div>
												
												<button type="submit" class="mt-2 btn btn-primary">Submit</button>
											</form>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="/common/footer.jsp"></jsp:include>
			</div>
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
	<script src="<%=request.getContextPath()%>/assets/summernote/summernote.js"></script>
    
	<script type="text/javascript">
		$('document').ready(function() {
			$('#competitions').addClass('mm-active');
			$('textarea[class*=autosize]').autosize({
				append : "\n"
			});
			$('textarea.limited').inputlimiter({
				remText : '%n character%s remaining...',
				limitText : 'max allowed : %n.'
			});
			jQuery.validator.addMethod("checkForInvalidData", function(value, element) { 
				value = value.replace(/\s+/g,"_");
				   
				return !/(\S)(\1{2,})/g.test(value);
				 
				}, "Invalid summary");
			$('#summary').val($.trim($('#summary').val()));
			$('[data-toggle=tooltip]').tooltip();
			$('#content').summernote({
		      	  height: 300,               // set editor height
		      	  placeholder: 'Start writing content here',
		      	toolbar: [
		      	       
		      	        ['style', ['bold', 'italic', 'underline', 'clear']],
		      	        ['fontsize', ['fontsize']],
		      	        ['color', ['color']],
		      	        ['para', ['ul', 'ol', 'paragraph']]
		      	      
		      	      ],
		      	  
		      	  theme: 'superhero' 
		      	});
			$('#text-form').validate({
				errorElement : 'div',
				errorClass : 'error-msg',
				focusInvalid : true,

				rules : {
					
					summary : {
						required:true,
						checkForInvalidData:true
					},
					content :{
						required:true,
					} 

				},
				messages : {
					
				},

				submitHandler : function(form) {
					if($('#content').val().length==0){
						alert("Please enter the content");
						return false;
					}
					$('#text-form button[type=submit]').prop("disabled", "disabled");		
					form.submit();
				}

			});
		});
	</script>
</body>
</html>
