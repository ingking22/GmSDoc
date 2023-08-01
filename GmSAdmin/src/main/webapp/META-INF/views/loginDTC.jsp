<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
	<meta name="author" content="AdminKit">
	<meta name="keywords" content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

<!-- 	<link rel="preconnect" href="https://fonts.gstatic.com"> -->
	<link rel="shortcut icon" href="/img/icons/icon-48x48.png" />

<!-- 	<link rel="canonical" href="https://demo-basic.adminkit.io/pages-sign-in.html" /> -->

	<title>문서반출 시스템 테스트 로그인</title>

	<link href="/css/app.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>
	<main class="d-flex w-100">
		<div class="container d-flex flex-column">
			<div class="row vh-100">
				<div class="col-sm-10 col-md-8 col-lg-6 col-xl-5 mx-auto d-table h-100">
					<div class="d-table-cell align-middle">

						<div class="text-center mt-4">
							<h1 class="h2">로그인</h1>
							<p class="lead">
							</p>
						</div>

						<div class="card">
							<div class="card-body">
								<div class="m-sm-3">
									<form id="loginForm" method="post" action="/loginSecurity">
										<div class="mb-3">
											<label class="form-label">아이디</label>
											<input class="form-control form-control-lg" type="loginid" name="loginid" placeholder="Enter your id" />
										</div>
										<div class="mb-3">
											<label class="form-label">비밀번호</label>
											<input class="form-control form-control-lg" type="password" name="password" placeholder="Enter your password" />
										</div>
										<div>
											<div class="form-check align-items-center">
												<input id="customControlInline" type="checkbox" class="form-check-input" value="remember-me" name="remember-me" checked>
												<label class="form-check-label text-small" for="customControlInline">저장합니다</label>
											</div>
										</div>
										<div class="d-grid gap-2 mt-3">
											<a onclick="submitLogin()" class="btn btn-lg btn-primary">로그인</a>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<script src="js/app.js"></script>

</body>

<script src='/js/jquery/jquery-3.7.0.min.js'></script>

<script type="text/javascript">

$(document).ready(function() {
	<c:if test="${param.error eq 'AccessFail'}">
		alert("아이디 또는 비밀번호를 확인하여 주시기 바랍니다.");
	</c:if>
});


function submitLogin() {
	document.getElementById("loginForm").submit();
}

</script>

</html>