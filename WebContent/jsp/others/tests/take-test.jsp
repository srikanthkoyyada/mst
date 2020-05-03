<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Quiz  | MySuperBrain.com</title>

<meta name="description"
	content="MySuperBrain.com is the first website that aims to encourage the all-round development in school students. MySuperBrain.com makes students more knoeledgeable and creative. MSB also provides the students an opportunity to showcase their amazing skills in multiple areas to people from around the world">
<meta name="keywords"
	content="MySuperBrain.com, mysuperbrain, all-rounder, education, overall development, IIM alumni, knowledge, creativity, recognition, students, school, children, Howard Gardner, multiple intelligences, quizzes, quizzes for kids, My">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/font-awesome.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />
<!-- fav icon -->
<link rel="icon" href="<%=request.getContextPath()%>/img/favicon.ico"
	type="image/x-icon">
<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/jquery-ui.custom.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/assets/css/jquery.gritter.css" />
<!--[if lte IE 9]>
			<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/ace-ie.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="<%=request.getContextPath() %>/assets/js/ace-extra.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="<%=request.getContextPath() %>/assets/js/html5shiv.js"></script>
		<script src="<%=request.getContextPath() %>/assets/js/respond.js"></script>
		<![endif]-->
<script src="<%=request.getContextPath()%>/js/analytics.js"></script>


<!--[if !IE]> -->
	

	<!-- <![endif]-->

	<!--[if IE]>
	<script src="../assets/js/jquery1x.js"></script>
<![endif]-->
	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath() %>/assets/js/jquery.mobile.custom.js'>"
							+ "<"+"/script>");
	</script>
	

<style type="text/css">
div.timer {
	border: 1px #666666 solid;
	width: 190px;
	height: 50px;
	line-height: 50px;
	font-size: 36px;
	text-align: center;
	float: right;
}

</style>

</head>
<body class="no-skin">
	<jsp:include page="/common/header.jsp"></jsp:include>
	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
		<jsp:include page="/common/menu.jsp"></jsp:include>
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<%=request.getContextPath() %>/">Home</a>
						</li>
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<%=request.getContextPath() %>/tests/all">Test Categories</a>
						</li>
						<li class="active">Test</li>
					</ul>
					<!-- /.breadcrumb -->
					<!-- /section:basics/content.searchbox -->
				</div>
				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<!-- #section:settings.box -->
					<div class="page-content-area">
					
						<div class="page-header">
							<h1>
								Quiz <small> <i
								class="ace-icon fa fa-angle-double-right"></i> Please read instructions carefully. Click on start test to begin your test
								</small>
							</h1>
						</div>
						<!-- /.page-header -->
						<div class="row">
							<div class="col-md-12">	
							<div class="row">	
							<div class="timer">
								<span class="hour">00</span>:<span class="minute">00</span>:<span
									class="second">00</span>
							</div>
							</div>
							<div id="quiz-instructions">
							<h4>Instructions:</h4>
							
								<ol>
									<li><p>This is a multiple choice quiz. There is only one
											right answer for every question. Think and answer. You get
											points for doing well.</p></li>
									<li><p>Attempt all the questions and click submit.</p></li>
									<li><p   style="color:#F79F81">There is a time limit for
											every quiz.If you fail to submit the quiz with in the given time
											, quiz will be submitted automatically.</p></li>
											<li><p   style="color:#F79F81 ">You can participate in a test any number of times to practice,but your first attempt points valid</p></li>
									<li><p>For each correct answer you will get 2 points</p>
										</li>
								<li><p>If all answers are correct, you will get 5 bonus points</p>
							</li>
							</ol>
							</div>
							<div align="center">
								<button type="button" class="btn btn-primary btn-lg" id="start-quiz">
								Start Test</button></div>
								<div align="center">
								<c:choose>
									<c:when test="${isTestTaken eq true }">
									<h4 class="alert-warning">You already taken this test.you can only practice this test.No points will be given. </h4>
									</c:when>
									<c:otherwise>
									<h4 class="alert-warning">This is your first attempt. </h4>
									</c:otherwise>
										</c:choose>
										<c:choose>
									<c:when test="${isUserCategory eq true }">
									<h4 class="alert-warning">You will get points if this is your first attempt. </h4>
									</c:when>
									<c:otherwise>
									<h4 class="alert-warning">You will not get any points as this test does not comes under your category </h4>
									</c:otherwise>
										</c:choose>
								</div>
								
								<h4 id="quiz-title">Quiz :
									${quiz.name}
								</h4>
								<hr>
								</div>
								<div class="col-md-10 col-md-offset-1">
								<c:choose>
								<c:when test="${quiz.description eq 'Sample Description' }">
								<p class="bolder" id="quiz-desc">Select the correct answer from the options given below.</p>
								</c:when>
								<c:otherwise>
								<p class="alert alert-warning bolder" id="quiz-desc">${quiz.description}</p>
								</c:otherwise>
								</c:choose>
								
								<form action="${pageContext.servletContext.contextPath}/user/submittest/${quiz.quiz_id}" method="post" id="quiz-form">
							<c:forEach items="${quizBuild}" var="qanda" varStatus="qitr">
								<div class="widget-box widget-color-green question-div" style="border-radius:7px; border: none;"  id="qid${qitr.index+1}">
								<!-- #section:custom/widget-box.options -->
								<div class="widget-header">
									<h3 class="widget-title bigger lighter">
										<span class="label label-xlg label-primary arrowed arrowed-right">
											${qitr.index+1}/${quiz.noq}
										</span>
										${qanda.key}?
									</h3>
							
							
								</div>
								<div class="widget-body">
							<div class="widget-main no-padding">
							<div class="panel panel-default">
								<%char K = 'A'; %>
								<c:forEach items="${qanda.value}" var="options" varStatus="aitr">
								
								<table
									class="table table-striped table-hover table-condensed">
				
								<tbody>
								<tr>
									<td>
									<div class="radio">
									<label> <input name="qno${qitr.index+1}"
											type="radio" class="ace" value=<%=K %>
											id="optionValue"> &nbsp;&nbsp;<span class="lbl">
												${options}
										</span>
									</label>
									</div>
									</td>
								</tr>
								</tbody>
										</table>
								<%K++; %>
								</c:forEach>
									
					
									
										</div>
									</div>
								</div>
							</div>
							
							</c:forEach>
								
									<input type="hidden" name="quiestionNo" value=1 id="questionNumber">
									<input type="hidden" name="completedTime" id="time-taken">
									<c:choose>
									<c:when test="${isTestTaken eq true }">
									<input type="hidden" name="isTestTaken" value="yes">	
									</c:when>
									<c:otherwise>
									<input type="hidden" name="isTestTaken" value="no">
									</c:otherwise>
										</c:choose>
									
									<c:choose>
									<c:when test="${isUserCategory eq true }">
									<input type="hidden" name="isUserCategory" value="yes">	
									</c:when>
									<c:otherwise>
									<input type="hidden" name="isUserCategory" value="no">	
									</c:otherwise>
										</c:choose>
									<div class="modal-footer text-muted" id="quiz-actions">
				
											&nbsp;
											<button type="button" class="btn btn-primary btn-md pull-left"
												id="previous-q">Previous Question</button>
											&nbsp;
											<button type="button" class="btn btn-success btn-md" id="finish">Finish
												Exam</button>
											&nbsp;
											<button type="button" class="btn btn-info btn-md pull-right"
												id="next-q">Next Question</button>
											
										</div>
								</form>
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.page-content-area -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div><!-- /.main-container -->

	<!-- basic scripts -->

	
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.js"></script>

	<!-- page specific plugin scripts -->

	<!-- [if lte IE 8]> -->
		  <script src="<%=request.getContextPath()%>/assets/js/excanvas.js"></script>
		<!-- [endif] -->
	
<script src="<%=request.getContextPath()%>/js/countdowntime.js"></script>
	<!-- ace scripts -->
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/elements.aside.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/ace/ace.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.sidebar.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.sidebar-scroll-1.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/js/ace/ace.submenu-hover.js"></script>
		
		<script
		src="<%=request.getContextPath()%>/assets/js/bootbox.js"></script>

	<script type="text/javascript">
		$('document').ready(function(){
			$('[data-toggle=tooltip]').tooltip();
			$('#start-quiz').click(function(){
				$('#quiz-guide').html('<small>Use Next and Previous Question buttons to answer the questions and click on Finish Exam to complete.</small> ');
				$(this).hide();
				$('#quiz-instructions').hide();
				$('#quiz-title').show();
				$('#quiz-desc').show();
				$('#quiz-actions').show();
				$('#qid1').show();
				timer.start();
			});
			$('#finish').click(function() {
				if($('#questionNumber').val()<${quiz.noq}){
				bootbox.confirm("Are you sure? You want to finish the Quiz", function(result) {
				 if(result){
				 $('#questionNumber').val(1);
				$('#quiz-form').submit();
				 }else{
				 return true;
				 }


				}); } else {
				$('#questionNumber').val(1);
				$('#quiz-form').submit();
				}
				});
		});
	</script>
	<script type="text/javascript">
var timer;
	$('document').ready(function(){
		
		$('.question-div').hide();
		$('#quiz-title').hide();
		$('#quiz-desc').hide();
		$('#quiz-actions').hide();
		$('#previous-q').hide();
		
		$('#next-q').click(function() {
				$('.question-div').hide();
				$('#questionNumber').val(parseInt($('#questionNumber').val()) + 1);
				$('#qid'+ parseInt($('#questionNumber').val())).show();
				$('#previous-q').show();
				
				if(parseInt($('#questionNumber').val())==parseInt(${quiz.noq})){
					$('#next-q').hide();
				} 
		});
		$('#previous-q').click(function() {
			$('.question-div').hide();
			$('#questionNumber').val(parseInt($('#questionNumber').val()) - 1);
			$('#qid'+ parseInt($('#questionNumber').val())).show();
			$('#next-q').show();
			if(parseInt($('#questionNumber').val())==1){
				$('#previous-q').hide();
			}
		});
		
		 timer = new _timer(function(time) {
			if (time == 0) {
				timer.stop();
				$('#time-taken').val($('.timer').text());
				
				bootbox.alert("Quiz time is over click ok to submit");
				
				$('#quiz-form').submit();
			}
		});
		
		timer.reset(parseInt(${quiz.duration})*60);
		timer.mode(0);
		//timer.start(); 
		$('#quiz-form').submit(function(){
			$('#time-taken').val($.trim($('.timer').text()));
			
			return true;
		});				
	});
	</script>
	
</body>
</html>