<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.msb.dao.SchoolUserDAOImpl"%>
<%@page import="com.msb.model.SchoolUser" %>
<style>
.hide {
	display: none;
}
</style>
<link rel="icon" href="<%=request.getContextPath()%>/img/myfavicon.ico"
	type="image/x-icon">
<div class="app-header header-shadow">
	<div class="app-header__logo">
		<!-- <div class="logo-src"></div> -->
		<img src="<%=request.getContextPath() %>/assets/images/logo-inverse.png" />
		<!-- <h2 style="font-weight: 600; font-family: Brush Script MT; color: #4471f1;">MySuperTalent</h2> -->
		<!-- <span style="font-family: MV Boli; color: #ff2300;">Sri Chaitanya</span> -->
		<div class="header__pane ml-auto">
			<div class="d-block d-lg-none">
				<button type="button"
					class="hamburger close-sidebar-btn hamburger--elastic"
					data-class="closed-sidebar">
					<span class="hamburger-box"> <span class="hamburger-inner"></span>
					</span>
				</button>
			</div>
		</div>
	</div>
	<div class="app-header__mobile-menu">
		<div>
			<button type="button"
				class="hamburger hamburger--elastic mobile-toggle-nav">
				<span class="hamburger-box"> <span class="hamburger-inner"></span>
				</span>
			</button>
		</div>
	</div>
	<div class="app-header__menu">
		<span>
			<c:if test="${empty SchoolStudent}">
				<a href="<%=request.getContextPath()%>/srichaitanya/login" class="btn btn-warning">
					<!-- <i class="fa fa-key fa-w-16 fa-2x" style="line-height: 1.2em;"></i> -->
					LOGIN
				</a></c:if>
			<c:if test="${not empty SchoolStudent}">
				<button type="button"
					class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
					<span class="btn-icon-wrapper"> <i
						class="fa fa-ellipsis-v fa-w-6"></i>
					</span>
				</button>
			</c:if>
		</span>
	</div>
	<div class="app-header__content">
		<div class="app-header-left">
		<img src="<%=request.getContextPath() %>/img/images.png" />
			<ul class="header-menu nav" style="/* padding-left: 100px; */ TEXT-TRANSFORM: UPPERCASE;">
				<li class="nav-item"><a href="<%=request.getContextPath()%>/srichaitanya/guidelines"
					class="nav-link"> <i class="nav-link-icon pe-7s-news-paper">
					</i> Guidelines
				</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/srichaitanya/competitions"
					class="nav-link"> <i class="nav-link-icon pe-7s-target"></i>
						Competitions
				</a></li>
				<li class="nav-item"><a href="<%=request.getContextPath()%>/srichaitanya/viewentries"
					class="nav-link"> <i class="nav-link-icon pe-7s-look"></i>
						Entries
				</a></li>
				<c:if test="${not empty SchoolStudent}">
				<li class="nav-item"><a href="<%=request.getContextPath()%>/srichaitanya/entries/${SchoolStudent.username}"
					class="nav-link"> <i class="nav-link-icon pe-7s-diamond"></i>
						My Talents
				</a></li>
				</c:if>
				<c:if test="${empty SchoolStudent}">
				<li>
				<a href="<%=request.getContextPath()%>/srichaitanya/login" class="btn btn-warning">
					<!-- <i class="fa fa-key fa-w-16 fa-2x" style="line-height: 1.2em;"></i> -->
					LOGIN
				</a></li>
				<%-- 
				<a href="<%=request.getContextPath()%>/srichaitanya/register">
					<i class="fa fa-user-plus fa-3x icon-gradient bg-amy-crisp btn-icon-wrapper mb-2"></i>
				</a> --%>
			</c:if>
			</ul>
		</div>
		<div class="app-header-right">
			<%-- <div class="header-dots">
				<div class="dropdown">
					<button type="button" data-toggle="dropdown"
						class="p-0 mr-2 btn btn-link">
						<span class="icon-wrapper icon-wrapper-alt rounded-circle">
							<span class="icon-wrapper-bg bg-focus"></span> <i
							class="fa fa-users-cog opacity-8"></i>
						</span>
					</button>
					<div tabindex="-1" role="menu" aria-hidden="true"
						class="rm-pointers dropdown-menu dropdown-menu-right">
						<div class="dropdown-menu-header">
							<div class="dropdown-menu-header-inner pt-4 pb-4 bg-focus">
								<div class="menu-header-image opacity-05"
									style="background-image: url('<%=request.getContextPath()%>/assets/images/dropdown-header/city2.jpg');"></div>
								<div class="menu-header-content text-center text-white">
									<h6 class="menu-header-subtitle mt-0">Switch User</h6>
								</div>
							</div>
						</div>
						<h6 tabindex="-1" class="dropdown-header">Choose Below</h6>
						<a href="<%=request.getContextPath() %>/school" class="dropdown-item">
							<i class="fa fa-school icon-gradient bg-tempting-azure fa fa-2x"></i>&nbsp;&nbsp;&nbsp; SCHOOL
						</a>
						<a href="<%=request.getContextPath() %>/college" class="dropdown-item">
							<i class="fa fa-university icon-gradient bg-sunny-morning fa fa-3x"></i>&nbsp;&nbsp;&nbsp; COLLEGE
						</a>
						<a href="<%=request.getContextPath() %>/others" class="dropdown-item">
							<i class="fa fa-users icon-gradient bg-love-kiss fa fa-2x"></i>&nbsp;&nbsp;&nbsp; OTHER
						</a>
					</div>
				</div>
			</div> --%>
			<c:if test="${not empty SchoolStudent}">
				<div class="header-btn-lg pr-0">
					<div class="widget-content p-0">
						<div class="widget-content-wrapper">
							<div class="widget-content-left">
								<div class="btn-group">
									<a data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false" class="p-0 btn"> <img width="42"
										class="rounded-circle"
										src="<%=request.getContextPath()%>/resources/DisplaySchoolUserProfileImage"
										alt=""> <i class="fa fa-angle-down ml-2 opacity-8"></i>
									</a>
									<div tabindex="-1" role="menu" aria-hidden="true"
										class="rm-pointers dropdown-menu-lg dropdown-menu dropdown-menu-right"
										x-placement="bottom-end"
										style="position: absolute; transform: translate3d(-297px, 63px, 0px); top: 0px; left: 0px; will-change: transform;">
										<div class="dropdown-menu-header">
											<div class="dropdown-menu-header-inner bg-info">
												<div class="menu-header-image opacity-2"
													style="background-image: url('<%=request.getContextPath()%>/assets/images/dropdown-header/city3.jpg');"></div>
												<div class="menu-header-content text-left">
													<div class="widget-content p-0">
														<div class="widget-content-wrapper">
															<div class="widget-content-left mr-3">
																<img width="42" class="rounded-circle"
																	src="<%=request.getContextPath()%>/resources/DisplaySchoolUserProfileImage"
																	alt="">
															</div>
															<div class="widget-content-left">
																<div class="widget-heading">${SchoolStudent.username}</div>
																<!-- <div class="widget-subheading opacity-8">A short profile description
                                                                </div> -->
															</div>
															<div class="widget-content-right mr-2">
																<a href="<%=request.getContextPath()%>/srichaitanya/logout"
																	class="btn-pill btn-shadow btn-shine btn btn-focus">Logout
																</a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="scroll-area-xs" style="height: 150px;">
											<div class="scrollbar-container ps ps--active-y">
												<ul class="nav flex-column">
													<li class="nav-item-header nav-item">Activity</li>
													<li class="nav-item"><a href="javascript:void(0);"
														class="nav-link">Points
															<div class="ml-auto badge badge-pill badge-info">${SchoolStudent.points }
															</div>
													</a></li>
													<li class="nav-item"><a href="<%=request.getContextPath() %>/srichaitanya/user/changepwd" class="nav-link">Change
															Password </a></li>
													<li class="nav-item"><a href="<%=request.getContextPath() %>/srichaitanya/user/premium" class="nav-link">Premium </a></li>
													<li class="nav-item-header nav-item">My Account</li>
												</ul>
												<div class="ps__rail-x" style="left: 0px; bottom: 0px;">
													<div class="ps__thumb-x" tabindex="0"
														style="left: 0px; width: 0px;"></div>
												</div>
												<div class="ps__rail-y"
													style="top: 0px; right: 0px; height: 150px;">
													<div class="ps__thumb-y" tabindex="0"
														style="top: 0px; height: 89px;"></div>
												</div>
											</div>
										</div>
										<ul class="nav flex-column">
											<li class="nav-item-divider mb-0 nav-item"></li>
										</ul>
										<div class="grid-menu grid-menu-2col">
											<div class="no-gutters row">
												<div class="col-sm-6">
													<a
														class="btn-icon-vertical btn-transition btn-transition-alt pt-2 pb-2 btn btn-outline-warning"
														href="<%=request.getContextPath()%>/srichaitanya/user/profile">
														<i
														class="pe-7s-user icon-gradient bg-amy-crisp btn-icon-wrapper mb-2"></i>
														Profile
													</a>
												</div>
												<div class="col-sm-6">
													<a
														class="btn-icon-vertical btn-transition btn-transition-alt pt-2 pb-2 btn btn-outline-danger"
														href="<%=request.getContextPath() %>/srichaitanya/entries/${SchoolStudent.username}"> <i
														class="pe-7s-ticket icon-gradient bg-love-kiss btn-icon-wrapper mb-2"></i>
														<b>Entries</b>
													</a>
												</div>
											</div>
										</div>
										<!-- <ul class="nav flex-column">
											<li class="nav-item-divider nav-item"></li>
											<li class="nav-item-btn text-center nav-item">
												<button class="btn-wide btn btn-primary btn-sm">
													Open Messages</button>
											</li>
										</ul> -->
									</div>
								</div>
							</div>
							<div class="widget-content-left  ml-3 header-user-info">
								<div class="widget-heading">${SchoolStudent.username}</div>
								<!-- <div class="widget-subheading">VP People Manager</div> -->
							</div>
							<div class="widget-content-right header-user-info ml-3">
								<button type="button"
									class="btn-shadow p-1 btn btn-primary btn-sm show-toastr-example">
									<i class="fa text-white fa-calendar pr-1 pl-1"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			
		</div>
	</div>
</div>
<c:if test="${not empty SchoolStudent }">
	<c:if test="${SchoolStudent.getPremium() eq 0 }">
		<form>
			<input type="hidden" name="premium" id="premium" value="${SchoolStudent.getPremium() }" />
		</form>
		<button type="button" class="btn mr-2 mb-2 btn-primary hide" data-toggle="modal" data-target="#exampleModal"
			id="clickForPremium">Basic Modal
	  	</button>
	</c:if>
</c:if>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">UPGRADE TO PREMIUM</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p class="mb-0">Get premium account to avail all the benifits.</p>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary" href="<%=request.getContextPath() %>/srichaitanya/user/premium">Get Premium</a>
            </div>
        </div>
    </div>
</div>
<style>
.fixed-sidebar .app-main .app-main__outer {
	padding-left: 0px !important;
}
</style>