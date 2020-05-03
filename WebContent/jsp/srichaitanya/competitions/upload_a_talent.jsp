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
<title>Upload A Talent | MySuperTalent</title>
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
									<i class="pe-7s-diamond text-success"> </i>
								</div>
								<div>
									Upload A Talent
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
										action="<%=request.getContextPath()%>/srichaitanya/user/submit-uat-competition"
										method="post" id="wiyt-form" enctype="multipart/form-data">
										
											<div class="position-relative form-group">
												<label for="exampleEmail11" class="">Summary of
													your Talent</label>
												<textarea id="description" name="description"
													class="form-control"></textarea>
											</div>
											<div class="position-relative form-group">
												<label for="exampleSelect" class="">Please select
													attachment type</label> <select name="entry_type" id="entry_type"
													class="form-control">
													<option value="" selected="selected" disabled="disabled">--Select
														Type--</option>
													<option value="text">Text</option>
													<option value="image">Image</option>
													<option value="video">Video</option>
												</select>
											</div>
											<div class="position-relative form-group">
												<label for="exampleSelectMulti" class="">Please
													Select the area</label> <select name="area" id="area"
													class="form-control">
													<option value="" selected="selected" disabled="disabled">--Select
														Type--</option>
													<option value="Music">Music</option>
													<option value="Dance">Dance</option>
													<option value="Jokes">Jokes</option>
													<option value="Speaking">Speaking</option>
													<option value="Robotics">Robotics</option>
												</select>
											</div>
											<%-- <c:choose>
											<c:when test="${fn:substring(type, 0, 8) == 'painting'}">
												<input type="hidden" name="entry_type" id="entry_type" value="image" />
											</c:when>
											<c:otherwise>
												<input type="hidden" name="entry_type" id="entry_type" value="video" />
											</c:otherwise>
										</c:choose> --%>
											<input type="hidden" name="user_category" value="1" />
											
											<div class="position-relative form-group" id="textContent" style="display: none;">
												<label for="exampleFile" class="">Enter Your ${type} here</label>
												<textarea id="content" name="content" class="form-control"
													style="overflow-y: scroll; word-wrap: break-word; resize: horizontal; height: 272px;"></textarea>
                                                  </div>
											<div class="position-relative form-group" id="attchment" style="display: none;">
												<label for="exampleFile" class="">Select Your Attachment</label>
												<input name="uat_attachment" id="uat_attachment" type="file" class="form-control-file" onchange="readURL(this)" />
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
	<script src="<%=request.getContextPath()%>/assets/summernote/summernote.js"></script>
	<script type="text/javascript">
		function readURL(input) {
			var image=input;
			var image_obj = $('#uat_attachment');
		
			if($('#entry_type').val() == null){
				alert("please select entry type first");
				image_obj.replaceWith(image_obj.val('').clone(true));
				return;
		}
		
		
		var entry=$('#entry_type').val();
		if(entry=='text')
			entry='word';
		
		if(!((image.files[0].type).indexOf(entry)>=0)){
			alert("please select "+entry+" file attachment ");
			image_obj.replaceWith(image_obj.val('').clone(true));
			return;
		}
	
		if ((image.files[0].type).indexOf('image')>=0){
			
		if((image.files[0].size / 1024).toFixed(0) > 2048) {
	
			alert("attachment must be less or equal to 2MB");
			image_obj.replaceWith(image_obj.val('').clone(true));
			return;
		}
		}else
			if ((image.files[0].type).indexOf('video')>=0 ){
				
				if((image.files[0].size / 1024).toFixed(0) > 25*1024) {
	
					alert("attachment must be less or equal to 25MB");
					image_obj.replaceWith(image_obj.val('').clone(true));
					return;
				}
			}
		}
		
		$('document').ready(function() {
			
			$('#uploadtalent').addClass('mm-active');
			
			$('#entry_type').change(function(){
				if($('#entry_type').val()=="text"){
					$('#attchment').hide();
					$('#textContent').show();
					 $("#content").attr('required', true);
					 $("#uat_attachment").attr('required', false);
				} else if($('#entry_type').val()=="image" || $('#entry_type').val()=="video") {
					$('#textContent').hide();
					$('#attchment').show();
					 $("#uat_attachment").attr('required', true);
					 $("#content").attr('required', false);
				}
			});
			
			
			$('textarea[class*=autosize]').autosize({
				//append : "\n"
			});
			$('textarea.limited').inputlimiter({
				remText : '%n character%s remaining...',
				limitText : 'max allowed : %n.'
			});
			jQuery.validator.addMethod("checkForInvalidData", function(value, element) { 
				value = value.replace(/\s+/g,"_");
				   
				return !/(\S)(\1{2,})/g.test(value);
				 
				}, "Invalid Description");
			$('#description').val($.trim($('#description').val()));
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
			
			$('#wiyt-form').validate({
				errorElement : 'div',
				errorClass : 'error-msg',
				
				focusInvalid : true,

				rules : {
					description :{
						required:true,
						minlength:15,
						checkForInvalidData:true
					},
					entry_type:{
						required:true
					},
					uat_attachment :{
						accept:"image/*,video/*,audio/*,application/*"
					},
					content :{
					},
					area:{
						required:true
					}

				},
				messages : {
					entry_summary : {
						required:"Please provide summary for your attachment.",
						minlength:"Please enter a valid length of description"
					},

					uat_attachment : {
						required:"Please choose your attachment.",
						accept:"Please select a image/video/word file"
					}
				},

				submitHandler : function(form) {
					
					$('#wiyt-form button[type=submit]').prop("disabled", "disabled");		
					form.submit();
				}

			});
		});
	</script>
</body>
</html>
