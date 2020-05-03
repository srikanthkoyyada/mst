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
			<div class="app-main__outer">
				<div class="app-main__inner">
					<div class="app-page-title">
						<div class="page-title-wrapper">
							<div class="page-title-heading">
								<div class="page-title-icon">
									<c:if test="${fn:substring(type, 0, 5) == 'music'}">
										<i class="pe-7s-music text-success"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 5) == 'dance'}">
										<i class="fa fa-child icon-gradient bg-warm-flame"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 8) == 'speaking'}">
										<i class="pe-7s-micro text-success"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 7) == 'cooking'}">
										<i class="pe-7s-junk icon-gradient bg-warm-flame"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 6) == 'sports'}">
										<i class="pe-7s-target text-success"> </i>
									</c:if>
									<c:if test="${fn:substring(type, 0, 8) == 'painting'}">
										<i class="pe-7s-paint text-success"> </i>
									</c:if>
								</div>
								<div style="font-variant-caps: all-petite-caps;">
									${type} Competition by ${competition.comp_by }
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
									<form class=""
										action="<%=request.getContextPath()%>/college/user/submit-mst-competition"
										method="post" id="mst-form" enctype="multipart/form-data">
										<div class="position-relative form-group">
											<label for="exampleEmail11" class="">Summary of
												your Talent</label>
											<textarea id="entry_summary" name="entry_summary"
												class="form-control"></textarea>
										</div>
										<input type="hidden" name="submission_type" value="${type}" />
										<input type="hidden" name="comp_id" value="${competition.comp_id }" />
										<input type="hidden" name="category" value="${competition.comp_category }" />
										<input type="hidden" name="user_category" value="2" />
										<c:choose>
											<c:when test="${fn:substring(type, 0, 8) == 'painting'}">
												<input type="hidden" name="entry_type" id="entry_type" value="image" />
											</c:when>
											<c:otherwise>
												<input type="hidden" name="entry_type" id="entry_type" value="video" />
											</c:otherwise>
										</c:choose>
										<div class="position-relative form-group">
											<label for="exampleFile" class="">Select Your ${type} Attachment</label>
											<input name="mst_video" id="mst_video" type="file" class="form-control-file" onchange="readURL(this)" />
                                                     <small class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>
                                                 </div>
										
										<button type="submit" class="mt-2 btn btn-primary">Submit</button>
									</form>
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
    
	<script type="text/javascript">

		function readURL(input) {

			var image=input;
			var image_obj = $('#mst_video');
			
			var entry=$('#entry_type').val();
			if(entry=='text')
				entry='word';
			
			if(!((image.files[0].type).indexOf(entry)>=0)){
				alert("please select "+entry+" file attachment ");
				image_obj.replaceWith(image_obj.val('').clone(true));
				return;
			}
		
			if ((image.files[0].type).indexOf('image')>=0 || (image.files[0].type).indexOf('word')>=0){
				
				if((image.files[0].size / 1024).toFixed(0) > 2048) {
					
					alert("attachment must be less or equal to 2MB");
					image_obj.replaceWith(image_obj.val('').clone(true));
					return;
				}
			} else if ((image.files[0].type).indexOf('video')>=0 ){
						
				if((image.files[0].size / 1024).toFixed(0) > 25*1024) {
	
					alert("attachment must be less or equal to 25MB");
					image_obj.replaceWith(image_obj.val('').clone(true));
					return;
				}
			}
		}
		
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
			
			$('#entry_summary').val($.trim($('#entry_summary').val()));
			
			$('#mst-form').validate({
				errorElement : 'div',
				errorClass : 'error-msg',
				focusInvalid : true,
				rules : {
					entry_summary :{
						required:true,
						minlength:15,
						checkForInvalidData:true
					},
					mst_video :{
						required:true,
						accept:"image/*,video/*,audio/*,application/*"
					} 
				},
				messages : {
					entry_summary : {
						required:"Please provide summary for your dance.",
						minlength:"Please enter a valid length of description"
					},
					mst_video : {
						required:"Please choose your file.",
						accept:"Please select a valid file"
					}
				},
				submitHandler : function(form) {
					$('#mst-form button[type=submit]').prop("disabled", "disabled");		
					form.submit();
				}
			});
		});
	</script>
</body>
</html>
