<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.msb.constants.MsbConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Competitions | MySuperTalent</title>
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
									<i class="pe-7s-target icon-gradient bg-mean-fruit"> </i>
								</div>
								<div>
									${param.type } Competition
									<!-- <div class="page-title-subheading">This is an example
										dashboard created using build-in elements and components.</div> -->
								</div>
							</div>

						</div>
					</div>
					<div class="row">
						<div class="col-md-9">
							<c:if test="${not empty competitionList }">
							<div class="main-card mb-3 card">
								<div class="card-body">
									<h5 class="card-title">Choose your standard</h5>
									<div class="mb-3">
										<div role="group" class="btn-group-sm nav btn-group">
											<a data-toggle="tab" href="#tab-eg12-0" style="margin-bottom: 10px;"
												class="btn-pill pl-3 btn btn-warning active">Junior Genius (Grades 1-3)</a> 
											<a style="margin-bottom: 10px;"
												data-toggle="tab" href="#tab-eg12-1" class="btn btn-info">Prime Prodigy(Grades 4-6)</a>
											<a data-toggle="tab" href="#tab-eg12-2" style="margin-bottom: 10px;"
												class="btn-pill pr-3  btn btn-danger">Talented Teens (Grades 7-9)</a>
											<a style="margin-bottom: 10px;" data-toggle="tab" href="#tab-eg12-3"
												class="btn-pill pr-3  btn btn-success">Super Seniors (Grades 10-12)</a>
										</div>
									</div>
									<div class="tab-content">
										<div class="tab-pane show active" id="tab-eg12-0" role="tabpanel">
										<c:forEach items="${competitionList}" var="competition">
											<c:if
												test="${competition.user_category eq MsbConstants.KIDS_SEGMENT }">
												<c:if test="${not empty competitionList }">
												<c:if test="${fn:substring(competition.comp_by, 0, 2) == 'SC'}">
													<table class="table" id="blog">
														<thead style="display: none;">
															<tr>
																<th></th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td>
																	<div class="main-card mb-3 card">
																		<div class="card-header">${competition_type} : <b> ${competition.topic }</b></div>
																		<div class="card-body">
																			<c:choose>
																			<c:when test="${not empty competition.description }">
																				<p class="mb-0">${competition.description }</p>
																			</c:when>
																			<c:otherwise>
																				<p class="mb-0">This is a ${competition_type }
																					competition organised by ${competition.comp_by }</p>
																			</c:otherwise>
																		</c:choose>
																		</div>
																		<div class="d-block text-right card-footer">
																		<c:choose>
																			<c:when test="${fn:substring(competition_type, 0, 7) == 'writing'}">
																				<a class="btn btn-success btn-lg"
																					href="<%=request.getContextPath() %>/srichaitanya/user/${competition_type}/text_competition/${competition.comp_id }">Participate</a>
																			</c:when>
																			<c:otherwise>
																				<a class="btn btn-success btn-lg"
																				href="<%=request.getContextPath() %>/srichaitanya/user/${competition_type}/competition/${competition.comp_id }">Participate</a>
																			</c:otherwise>
																		</c:choose>
																			
																		</div>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
													</c:if>
												</c:if>
											</c:if>
										</c:forEach>
										</div>
										<div class="tab-pane" id="tab-eg12-1" role="tabpanel">
										<c:forEach items="${competitionList}" var="competition">
											<c:if
												test="${competition.user_category eq MsbConstants.JUNIOR_SEGMENT }">
												<c:if test="${not empty competitionList }">
													<c:if test="${fn:substring(competition.comp_by, 0, 2) == 'SC'}">
													<table class="table" id="blog">
														<thead style="display: none;">
															<tr>
																<th></th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td>
																	<div class="main-card mb-3 card">
																		<div class="card-header">${competition_type} : <b> ${competition.topic }</b></div>
																		<div class="card-body">
																		<c:choose>
																			<c:when test="${not empty competition.description }">
																				<p class="mb-0">${competition.description }</p>
																			</c:when>
																			<c:otherwise>
																				<p class="mb-0">This is a ${competition_type }
																					competition organised by ${competition.comp_by }</p>
																			</c:otherwise>
																		</c:choose>
																		</div>
																		<div class="d-block text-right card-footer">
																			<c:choose>
																			<c:when test="${fn:substring(competition_type, 0, 7) == 'writing'}">
																				<a class="btn btn-success btn-lg"
																					href="<%=request.getContextPath() %>/srichaitanya/user/${competition_type}/text_competition/${competition.comp_id }">Participate</a>
																			</c:when>
																			<c:otherwise>
																				<a class="btn btn-success btn-lg"
																				href="<%=request.getContextPath() %>/srichaitanya/user/${competition_type}/competition/${competition.comp_id }">Participate</a>
																			</c:otherwise>
																		</c:choose>
																		</div>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
													</c:if>
												</c:if>
											</c:if>
										</c:forEach>
										</div>
										<div class="tab-pane" id="tab-eg12-2" role="tabpanel">
										<c:forEach items="${competitionList}" var="competition">
											<c:if
												test="${competition.user_category eq MsbConstants.SENIOR_SEGMENT}">
												<c:if test="${not empty competitionList }">
												<c:if test="${fn:substring(competition.comp_by, 0, 2) == 'SC'}">
													<table class="table" id="blog">
														<thead style="display: none;">
															<tr>
																<th></th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td>
																	<div class="main-card mb-3 card">
																		<div class="card-header">${competition_type} : <b> ${competition.topic }</b></div>
																		<div class="card-body">
																			<c:choose>
																			<c:when test="${not empty competition.description }">
																				<p class="mb-0">${competition.description }</p>
																			</c:when>
																			<c:otherwise>
																				<p class="mb-0">This is a ${competition_type }
																					competition organised by ${competition.comp_by }</p>
																			</c:otherwise>
																		</c:choose>
																		</div>
																		<div class="d-block text-right card-footer">
																			<c:choose>
																			<c:when test="${fn:substring(competition_type, 0, 7) == 'writing'}">
																				<a class="btn btn-success btn-lg"
																					href="<%=request.getContextPath() %>/srichaitanya/user/${competition_type}/text_competition/${competition.comp_id }">Participate</a>
																			</c:when>
																			<c:otherwise>
																				<a class="btn btn-success btn-lg"
																				href="<%=request.getContextPath() %>/srichaitanya/user/${competition_type}/competition/${competition.comp_id }">Participate</a>
																			</c:otherwise>
																		</c:choose>
																		</div>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
													</c:if>
												</c:if>
											</c:if>
										</c:forEach>
										</div>
										<div class="tab-pane" id="tab-eg12-3" role="tabpanel">
										<c:forEach items="${competitionList}" var="competition">
											<c:if
												test="${competition.user_category eq MsbConstants.SUPER_SENIOR_SEGMENT}">
												<c:if test="${not empty competitionList }">
												<c:if test="${fn:substring(competition.comp_by, 0, 2) == 'SC'}">
													<table class="table" id="blog">
														<thead style="display: none;">
															<tr>
																<th></th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td>
																	<div class="main-card mb-3 card">
																		<div class="card-header">${competition_type} : <b> ${competition.topic }</b></div>
																		<div class="card-body">
																			<c:choose>
																			<c:when test="${not empty competition.description }">
																				<p class="mb-0">${competition.description }</p>
																			</c:when>
																			<c:otherwise>
																				<p class="mb-0">This is a ${competition_type }
																					competition organised by ${competition.comp_by }</p>
																			</c:otherwise>
																		</c:choose>
																		</div>
																		<div class="d-block text-right card-footer">
																			<c:choose>
																			<c:when test="${fn:substring(competition_type, 0, 7) == 'writing'}">
																				<a class="btn btn-success btn-lg"
																					href="<%=request.getContextPath() %>/srichaitanya/user/${competition_type}/text_competition/${competition.comp_id }">Participate</a>
																			</c:when>
																			<c:otherwise>
																				<a class="btn btn-success btn-lg"
																				href="<%=request.getContextPath() %>/srichaitanya/user/${competition_type}/competition/${competition.comp_id }">Participate</a>
																			</c:otherwise>
																		</c:choose>
																		</div>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
													</c:if>
												</c:if>
											</c:if>
										</c:forEach>
										</div>
									</div>
								</div>
							</div>
							</c:if>
							<c:if test="${empty competitionList }">
								<h4>There are no active competitions for ${param.cat }.</h4>
							</c:if>
						</div>
						<div class="col-md-3"></div>
					</div>
				</div>
				<jsp:include page="/common/footer.jsp"></jsp:include>
			</div>
			<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
		</div>
	</div>
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
	<script
		src="<%=request.getContextPath()%>/assets/jquery.inputlimiter.1.3.1.js"></script>
	<script src="<%=request.getContextPath()%>/assets/jquery.autosize.js"></script>
	<script src="<%=request.getContextPath()%>/assets/jquery.validate.js"></script>
	<script
		src="<%=request.getContextPath()%>/assets/additional-methods.js"></script>
	<script src="<%=request.getContextPath()%>/assets/bootbox.js"></script>
	<script>
		$('document').ready(function() {
			$('#competitions').addClass('mm-active');
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