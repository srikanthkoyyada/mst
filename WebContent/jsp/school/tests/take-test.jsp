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
<title>Tests | My Super Talent</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="Know about what you can get at MySuperTalent.com">
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
<body>
	<div
		class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<jsp:include page="/common/schoolheader.jsp"></jsp:include>
		<!-- Theme settings removed from here -->
		<div class="app-main">
			<jsp:include page="/common/schoolmenu.jsp"></jsp:include>
			<div class="app-main__outer">
				<div class="app-main__inner">
					<div class="app-page-title">
						<div class="page-title-wrapper">
							<div class="page-title-heading">
								<div class="page-title-icon">
									<i class="pe-7s-news-paper icon-gradient bg-mean-fruit"> </i>
								</div>
								<div>
									Tests
									<div class="page-title-subheading">Please read instructions carefully. Click on start test to begin your test.</div>
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
								
								<form action="${pageContext.servletContext.contextPath}/school/user/submittest/${quiz.quiz_id}" method="post" id="quiz-form">
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
	<script src="<%=request.getContextPath()%>/js/countdowntime.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/jquery.inputlimiter.1.3.1.js"></script>
	<script src="<%=request.getContextPath()%>/assets/jquery.autosize.js"></script>
	<script src="<%=request.getContextPath()%>/assets/jquery.validate.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/additional-methods.js"></script>
	<script src="<%=request.getContextPath()%>/assets/bootbox.js"></script>

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
				var result=confirm("Are you sure? You want to finish the Quiz");//, function(result) {
				 if(result==true){
				 $('#questionNumber').val(1);
				$('#quiz-form').submit();
				 }else{
				 return true;
				 }


				//}); 
			} else {
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
				
				alert("Quiz time is over click ok to submit");
				
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