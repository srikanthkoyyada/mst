<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.msb.constants.MsbConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${type } Talents uploaded by Sri Chaitanya Students on MySuperTalent Entries | MySuperTalent</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="Watch these amazing ${type } talents of the students of Sri Chaitanya Schools. Watch the videos, share them and encourage young talents. Singing & Music Instruments">
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

<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

<link href="<%=request.getContextPath()%>/assets/main.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/assets/main.cba69814a806ecc7945a.css"
	rel="stylesheet">
<style>
/* .btn:focus, .btn:active, button:focus, button:active {
  outline: none !important;
  box-shadow: none !important;
}

#image-gallery .modal-footer{
  display: block;
}

.thumb{
  margin-top: 15px;
  margin-bottom: 15px;
} */
.modal-backdrop.show, .show.blockOverlay {
    opacity: 0 !important;
}
.videosize {
    /*position:absolute;*/
    z-index:-1;
    top:0;
    left:0;
    width:100%; 
    height:100%;
}
</style>
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
									<i class="pe-7s-look icon-gradient bg-mean-fruit"> </i>
								</div>
								<div style="text-transform: capitalize">
									${type } Entries
									<!-- <div class="page-title-subheading">This is an example
										dashboard created using build-in elements and components.</div> -->
								</div>
							</div>

						</div>
					</div>
					<div class="row">
						<div class="col-md-12 d-none d-sm-block">
							<c:if test="${not empty entries }">
								<c:forEach items="${entries}" var="entry">
									<c:choose>
										<c:when test="${fn:substring(type, 0, 8) == 'painting'}">
											<a class="thumbnail img-responsive" href="<%=request.getContextPath() %>/srichaitanya/view/mst_competition/${entry.id}"
												target="_blank" data-toggle="modal"
								            	data-image="<%=request.getContextPath() %>/user_images/Comp_Sub/MST/${entry.submission_file_name}">
												<img class="col-md-3"
													src="<%=request.getContextPath() %>/user_images/Comp_Sub/MST/${entry.submission_file_name}">
											</a>
										</c:when>
										<c:otherwise>
											<a class="thumbnail img-responsive" href="<%=request.getContextPath() %>/srichaitanya/view/mst_competition/${entry.id}"
												target="_blank" data-toggle="modal"
								            	data-image="<%=request.getContextPath() %>/user_images/Comp_Sub/MST/${entry.submission_file_name}">
								            	
											<video preload="metadata" class="col-md-3">
											  <source src="<%=request.getContextPath() %>/user_images/Comp_Sub/MST/${entry.submission_file_name}" type="video/mp4">
											</video></a>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
							<c:if test="${empty entries }">
								<h4>There are no entries uploaded for ${type } competition.</h4>
							</c:if>
						</div>
						<div class="col-md-12 d-block d-sm-none">
							<c:if test="${not empty entries }">
								<c:forEach items="${entries}" var="entry">
									<c:choose>
										<c:when test="${fn:substring(type, 0, 8) == 'painting'}">
											<div class="thumbnail img-responsive"> 
												<img class="col-md-3"
													src="<%=request.getContextPath() %>/user_images/Comp_Sub/MST/${entry.submission_file_name}" />
											</div>
										</c:when>
										<c:otherwise>
											<div class="thumbnail img-responsive">
											<video preload="metadata" class="col-md-3" controls>
											  <source src="<%=request.getContextPath() %>/user_images/Comp_Sub/MST/${entry.submission_file_name}" type="video/mp4">
											</video></div>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
						</div>
					</div>
				</div>
				<jsp:include page="/common/footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${fn:substring(type, 0, 8) == 'painting'}">
			<div class="modal fade bd-example-modal-lg" id="image-gallery" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			    <div class="modal-dialog modal-lg">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h5 class="modal-title" id="exampleModalLongTitle" style="text-transform: capitalize">${type } Entry</h5>
			                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			                    <span aria-hidden="true">&times;</span>
			                </button>
			            </div>
			            <div class="modal-body" align="center" style="height: 450px; overflow-y: auto;">
			                <img id=image-gallery-image src="" />
			                <!-- <img id="image-gallery-image" class="" src=""> -->
			            </div>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			            </div>
			        </div>
			    </div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="modal fade bd-example-modal-lg" id="image-gallery" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			    <div class="modal-dialog modal-lg">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h5 class="modal-title" id="exampleModalLongTitle" style="text-transform: capitalize">${type } Entry</h5>
			                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			                    <span aria-hidden="true">&times;</span>
			                </button>
			            </div>
			            <div class="modal-body" align="center" style="height: 450px; overflow-y: auto;">
			                <video id=image-gallery-image class="videosize embed-responsive-item" controls>
						        <source src="" type="video/mp4" />
						    </video>
			                <!-- <img id="image-gallery-image" class="" src=""> -->
			            </div>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			            </div>
			        </div>
			    </div>
			</div>
		</c:otherwise>
	</c:choose>
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

	<script>
		$('document').ready(function() {
			$('#entries').addClass('mm-active');
		});
		
		$(document).ready(function(){

		    loadGallery(true, 'a.thumbnail');

		    //This function disables buttons when needed
		    function disableButtons(counter_max, counter_current){
		        $('#show-previous-image, #show-next-image').show();
		        if(counter_max == counter_current){
		            $('#show-next-image').hide();
		        } else if (counter_current == 1){
		            $('#show-previous-image').hide();
		        }
		    }

		    /**
		     *
		     * @param setIDs        Sets IDs when DOM is loaded. If using a PHP counter, set to false.
		     * @param setClickAttr  Sets the attribute for the click handler.
		     */

		    function loadGallery(setIDs, setClickAttr){
		        var current_image,
		            selector,
		            counter = 0;

		        $('#show-next-image, #show-previous-image').click(function(){
		            if($(this).attr('id') == 'show-previous-image'){
		                current_image--;
		            } else {
		                current_image++;
		            }

		            selector = $('[data-image-id="' + current_image + '"]');
		            updateGallery(selector);
		        });

		        function updateGallery(selector) {
		            var $sel = selector;
		            current_image = $sel.data('image-id');
		            $('#image-gallery-caption').text($sel.data('caption'));
		            $('#image-gallery-title').text($sel.data('title'));
		            $('#image-gallery-image').attr('src', $sel.data('image'));
		            disableButtons(counter, $sel.data('image-id'));
		        }

		        if(setIDs == true){
		            $('[data-image-id]').each(function(){
		                counter++;
		                $(this).attr('data-image-id',counter);
		            });
		        }
		        $(setClickAttr).on('click',function(){
		            updateGallery($(this));
		        });
		    }
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