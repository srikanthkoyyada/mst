<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>MySuperTalent | Showcase your amazing talents to the world
</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no"
    />
    <meta name="description" content="Platform for everyone to showcase their talents">

    <!-- Disable tap highlight on IE -->
    <meta name="msapplication-tap-highlight" content="no">

<link href="<%=request.getContextPath() %>/assets/main.cba69814a806ecc7945a.css" rel="stylesheet"></head>

<body>
<div class="app-container app-theme-white body-tabs-shadow">
        <div class="app-container">
            <div class="h-100 d-none d-sm-block">
                <div class="h-100 no-gutters row">
                    <div class="d-none d-lg-block col-lg-6 col-xs-6">
                        <div class="slider-light">
                            <div class="slick-slider">
                                <div>
                                    <div class="position-relative h-100 d-flex justify-content-center align-items-center bg-plum-plate" tabindex="-1">
                                        <div class="slide-img-bg" style="background-image: url('<%=request.getContextPath() %>/img/kids.png');"></div>
                                        <div class="slider-content"><h3>School</h3>
                                            <p>No doubt about it.</p><p>You're one talented kid. Keep doing what you're doing. You're hands down amazing!</p>
                                        	<a href="<%=request.getContextPath() %>/school" class="btn btn-warning">PROCEED</a>
                                        </div>    
                                    </div>
                                </div>
                             </div>
                         </div>
                    </div>
                    <%-- <div class="d-none d-lg-block col-lg-4 col-xs-4">
                        <div class="slider-light">
                            <div class="slick-slider">
                                <div>
                                    <div class="position-relative h-100 d-flex justify-content-center align-items-center bg-premium-dark" tabindex="-1">
                                        <div class="slide-img-bg" style="background-image: url('<%=request.getContextPath() %>/img/college.mp4');"></div>
                                        <div class="slider-content"><h3>College</h3>
                                            <p>No doubt about it.</p><p>You're one talented person. Keep doing what you're doing. You're hands down amazing!</p>
                                        	<a href="<%=request.getContextPath() %>/college" class="btn btn-warning">PROCEED</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> --%>
                    <div class="d-none d-lg-block col-lg-6 col-xs-6">
                        <div class="slider-light">
                            <div class="slick-slider">
                                <div>
                                    <div class="position-relative h-100 d-flex justify-content-center align-items-center bg-sunny-morning" tabindex="-1">
                                        <div class="slide-img-bg" style="background-image: url('<%=request.getContextPath() %>/assets/images/originals/citydark.jpg');"></div>
                                        <div class="slider-content"><h3>Others</h3>
                                            <p>No doubt about it.</p><p>You're one talented person. Keep doing what you're doing. You're hands down amazing!</p>
                                        	<a href="<%=request.getContextPath() %>/others" class="btn btn-warning">PROCEED</a>    
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- <div class="h-100 d-flex bg-white justify-content-center align-items-center col-md-12 col-lg-8">
                        <div class="mx-auto app-login-box col-sm-12 col-md-10 col-lg-9">
                            <div class="app-logo"></div>
                            <h4 class="mb-0">
                                <span class="d-block">Welcome back,</span>
                                <span>Please sign in to your account.</span></h4>
                            <h6 class="mt-3">No account? <a href="javascript:void(0);" class="text-primary">Sign up now</a></h6>
                            <div class="divider row"></div>
                            <div>
                                <form class="">
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="position-relative form-group"><label for="exampleEmail" class="">Email</label><input name="email" id="exampleEmail" placeholder="Email here..." type="email" class="form-control"></div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="position-relative form-group"><label for="examplePassword" class="">Password</label><input name="password" id="examplePassword" placeholder="Password here..." type="password"
                                                                                                                                                   class="form-control"></div>
                                        </div>
                                    </div>
                                    <div class="position-relative form-check"><input name="check" id="exampleCheck" type="checkbox" class="form-check-input"><label for="exampleCheck" class="form-check-label">Keep me logged in</label></div>
                                    <div class="divider row"></div>
                                    <div class="d-flex align-items-center">
                                        <div class="ml-auto"><a href="javascript:void(0);" class="btn-lg btn btn-link">Recover Password</a>
                                            <button class="btn btn-primary btn-lg">Login to Dashboard</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div> -->
                </div>
            </div>
            <div class="h-100 d-block d-sm-none">
            	<div class="divider"></div>
                <a class="col-sm-12 mb-2 mr-2 btn-icon-vertical btn-square btn btn-success"
                	href="<%=request.getContextPath() %>/school"><i class="fa fa-school fa-2x btn-icon-wrapper"> </i>SCHOOL</a>
            	<div class="divider"></div>
                <a class="col-sm-12 mb-2 mr-2 btn-icon-vertical btn-square btn btn-warning"
                	href="<%=request.getContextPath() %>/college"><i class="fa fa-university fa-2x btn-icon-wrapper"> </i>COLLEGE</a>
            	<div class="divider"></div>
                <a class="col-sm-12 mb-2 mr-2 btn-icon-vertical btn-square btn btn-danger"
                	href="<%=request.getContextPath() %>/others"><i class="fa fa-users fa-2x btn-icon-wrapper"> </i>OTHERS</a>
            </div>
        </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/assets/scripts/main.cba69814a806ecc7945a.js"></script></body>
</html>
