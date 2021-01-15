<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->


<!-- Mirrored from radixtouch.in/templates/admin/smart/source/light/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 23 Dec 2020 17:52:14 GMT -->
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1" name="viewport" />
	<meta name="description" content="Responsive Admin Template" />
	<meta name="author" content="SmartUniversity" />
	<title>Moulay Ismail University | </title>
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet" type="text/css" />
	<!-- jquery -->
	<link href="assets/plugins/jquery-file-upload/blueimp-gallery/blueimp-gallery.min.css" rel="stylesheet"
		type="text/css" />
	<link href="assets/plugins/jquery-file-upload/css/jquery.fileupload.css" rel="stylesheet" type="text/css" />
	<link href="assets/plugins/jquery-file-upload/css/jquery.fileupload-ui.css" rel="stylesheet" type="text/css" />
	<!-- icons -->
	<link href="fonts/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
	<link href="fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="fonts/material-design-icons/material-icon.css" rel="stylesheet" type="text/css" />
	<!-- full calendar -->
	<link href="assets/plugins/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
	<!--bootstrap -->
	<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="assets/plugins/summernote/summernote.css" rel="stylesheet">
	<!-- data tables -->
	<link href="assets/plugins/datatables/plugins/bootstrap/dataTables.bootstrap4.min.css" rel="stylesheet"
		type="text/css" />
	<link href="assets/plugins/datatables/export/buttons.dataTables.min.css" rel="stylesheet" type="text/css" />
	<!-- Material Design Lite CSS -->
	<link rel="stylesheet" href="assets/plugins/material/material.min.css">
	<link rel="stylesheet" href="assets/css/material_style.css">
	<!-- inbox style -->
	<link href="assets/css/pages/inbox.min.css" rel="stylesheet" type="text/css" />
	<!-- Theme Styles -->
	<link href="assets/css/theme/light/theme_style.css" rel="stylesheet" id="rt_style_components" type="text/css" />
	<link href="assets/css/plugins.min.css" rel="stylesheet" type="text/css" />
	<link href="assets/css/theme/light/style.css" rel="stylesheet" type="text/css" />
	<link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />
	<link href="assets/css/theme/light/theme-color.css" rel="stylesheet" type="text/css" />
	<!-- favicon -->
	<link rel="shortcut icon" href="assets/favicon.ico" />
	<!-- dropzone -->
	<link href="assets/plugins/dropzone/dropzone.css" rel="stylesheet" media="screen">
	<!-- Date Time item CSS -->
	<link rel="stylesheet" href="assets/plugins/flatpicker/css/flatpickr.min.css" />
</head>
<!-- END HEAD -->

<body
	class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white white-sidebar-color logo-indigo">
	<div class="page-wrapper">
	<% if(session.getAttribute("NomUser")==null){ 
        response.sendRedirect("login.jsp");} 
   	 %>
		<!-- start header -->
		<div class="page-header navbar navbar-fixed-top">
			<div class="page-header-inner ">
				<!-- logo start -->
				<div class="page-logo">
					<a href="Home">
						<span class="logo-icon material-icons fa-rotate-45">school</span>
						<span class="logo-default">UMI</span> </a>
				</div>
				<!-- logo end -->
				<ul class="nav navbar-nav navbar-left in">
					<li><a href="#" class="menu-toggler sidebar-toggler"><i class="icon-menu"></i></a></li>
				</ul>
				
				<!-- start mobile menu -->
				<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span></span>
				</a>
				<!-- end mobile menu -->
				<!-- start header menu -->
				<div class="top-menu">
					<ul class="nav navbar-nav pull-right">
						<li><a href="javascript:;" class="fullscreen-btn"><i class="fa fa-arrows-alt"></i></a></li>
						<!-- start language menu -->
						
						<!-- end language menu -->
						<!-- start notification dropdown -->
						<li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
							<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
								data-close-others="true">
								<i class="fa fa-bell-o"></i>
								<span class="badge headerBadgeColor1"> 6 </span>
							</a>
							<ul class="dropdown-menu">
								<li class="external">
									<h3><span class="bold">Notifications</span></h3>
									<span class="notification-label purple-bgcolor">New 6</span>
								</li>
								<li>
									<ul class="dropdown-menu-list small-slimscroll-style" data-handle-color="#637283">
										<li>
											<a href="javascript:;">
												<span class="time">just now</span>
												<span class="details">
													<span class="notification-icon circle deepPink-bgcolor"><i
															class="fa fa-check"></i></span>
													Congratulations!. </span>
											</a>
										</li>
										
										
										
										
										
									</ul>
									<div class="dropdown-menu-footer">
										<a href="javascript:void(0)"> All notifications </a>
									</div>
								</li>
							</ul>
						</li>
						<!-- end notification dropdown -->
						<!-- start message dropdown -->
						<li class="dropdown dropdown-extended dropdown-inbox" id="header_inbox_bar">
							<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
								data-close-others="true">
								<i class="fa fa-envelope-o"></i>
								<span class="badge headerBadgeColor2"> 2 </span>
							</a>
							<ul class="dropdown-menu">
								<li class="external">
									<h3><span class="bold">Messages</span></h3>
									<span class="notification-label cyan-bgcolor">New 2</span>
								</li>
								<li>
									<ul class="dropdown-menu-list small-slimscroll-style" data-handle-color="#637283">
										<li>
											<a href="#">
												<span class="photo">
													<img src="assets/img/prof/prof2.jpg" class="img-circle" alt="">
												</span>
												<span class="subject">
													<span class="from"> Sarah Smith </span>
													<span class="time">Just Now </span>
												</span>
												<span class="message"> Jatin I found you on LinkedIn... </span>
											</a>
										</li>
										
										
										
										
									</ul>
									<div class="dropdown-menu-footer">
										<a href="#"> All Messages </a>
									</div>
								</li>
							</ul>
						</li>
						<!-- end message dropdown -->
						<!-- start manage user dropdown -->
						<li class="dropdown dropdown-user">
							<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
								data-close-others="true">
								<img src="data:image/jpeg;base64,${photo }"  class="doctor-pic" onerror="if (this.src != 'assets/boss-512.png') this.src = 'assets/boss-512.png';"
																				alt="">
								<span class="username username-hide-on-mobile"> ${NomUser} </span>
								<i class="fa fa-angle-down"></i>
							</a>
							<ul class="dropdown-menu dropdown-menu-default">
								<li>
									
										<i class="icon-user"></i> ${natureU}
								</li>
								
								
								<li class="divider"> </li>
								
								<li>
									<a href="logout">
										<i class="icon-logout"></i> Log Out </a>
								</li>
							</ul>
						</li>
						<!-- end manage user dropdown -->
						
					</ul>
				</div>
			</div>
		</div>
		<!-- end header -->
		<!-- start color quick setting -->
		<div class="settingSidebar">
			<a href="javascript:void(0)" class="settingPanelToggle"> <i class="fa fa-spin fa-cog"></i>
			</a>
			<div class="settingSidebar-body ps-container ps-theme-default">
				<div class=" fade show active">
					<div class="setting-panel-header">Setting Panel
					</div>
					<div class="quick-setting slimscroll-style">
						<ul id="themecolors">
							<li>
								<p class="sidebarSettingTitle">Sidebar Color</p>
							</li>
							<li class="complete">
								<div class="theme-color sidebar-theme">
									<a href="#" data-theme="white"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="dark"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="blue"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="indigo"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="cyan"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="green"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="red"><span class="head"></span><span
											class="cont"></span></a>
								</div>
							</li>
							<li>
								<p class="sidebarSettingTitle">Header Brand color</p>
							</li>
							<li class="theme-option">
								<div class="theme-color logo-theme">
									<a href="#" data-theme="logo-white"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="logo-dark"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="logo-blue"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="logo-indigo"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="logo-cyan"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="logo-green"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="logo-red"><span class="head"></span><span
											class="cont"></span></a>
								</div>
							</li>
							<li>
								<p class="sidebarSettingTitle">Header color</p>
							</li>
							<li class="theme-option">
								<div class="theme-color header-theme">
									<a href="#" data-theme="header-white"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="header-dark"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="header-blue"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="header-indigo"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="header-cyan"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="header-green"><span class="head"></span><span
											class="cont"></span></a>
									<a href="#" data-theme="header-red"><span class="head"></span><span
											class="cont"></span></a>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- end color quick setting -->
		<!-- start page container -->
		<div class="page-container">
			<!-- start sidebar menu -->
			<div class="sidebar-container">
				<div class="sidemenu-container navbar-collapse collapse fixed-menu">
					<div id="remove-scroll" class="left-sidemenu">
						<ul class="sidemenu  page-header-fixed slimscroll-style" data-keep-expanded="false"
							data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
							<li class="sidebar-toggler-wrapper hide">
								<div class="sidebar-toggler">
									<span></span>
								</div>
							</li>
							<li class="sidebar-user-panel">
								<div class="user-panel">
									<div class="pull-left image">
										<img src="data:image/jpeg;base64,${photo }"  class="doctor-pic" onerror="if (this.src != 'assets/boss-512.png') this.src = 'assets/boss-512.png';"
																				alt="">
									</div>
									<div class="pull-left info">
										<p>  ${NomUser} ${PrenomUser} </p>
										<a href="#"><i class="fa fa-circle user-online"></i><span class="txtOnline">
												${natureU}</span></a>
									</div>
								</div>
							</li>
							<c:set var="admin" value="Administrateur" />
			                <c:set var="prof" value="Professeur" />
			                <c:set var="respoF" value="Responsabledelafiliere" />
			                <c:set var="respoM" value="Responsabledemodule"></c:set>
							
							
							<c:if test="${natureUNV == admin}">
							
							<li class="nav-item ${Home }">
								<a href="Home" class="nav-link nav-toggle">
									<i class="material-icons">dashboard</i>
									<span class="title">Dashboard</span>
									<span class="selected"></span>
								</a>
								
							</li>
							<li class="nav-item ${FilieresOpen} ${AllFilieres} ${AjouterFiliere}">
								<a href="#" class="nav-link nav-toggle"> <i class="material-icons">business</i>
									<span class="title">Filiere</span> <span class="arrow ${FilieresOpen} "></span>
								</a>
								<ul class="sub-menu">
									<li class="nav-item ${AllFilieres}">
										<a href="listeFiliere" class="nav-link "> <span class="title">Tous les Filieres</span>
										</a>
									</li>
									<li class="nav-item ${AjouterFiliere}">
										<a href="ListRespoFil" class="nav-link "> <span class="title">Ajouter une Filiere</span>
										</a>
									</li>
									
								</ul>
							</li>
							
							<li class="nav-item ${ModulesOpen} ${AllModules} ${AjouterModule}">
								<a href="#" class="nav-link nav-toggle"> <i class="material-icons">school</i>
									<span class="title">Module</span> <span class="arrow ${ModulesOpen}"></span>
								</a>
								<ul class="sub-menu">
									<li class="nav-item ${AllModules}">
										<a href="listeModules" class="nav-link "> <span class="title">Tous les Modules
												</span>
										</a>
									</li>
									<li class="nav-item ${AjouterModule}">
										<a href="listeAjouterModule" class="nav-link "> <span class="title">Ajouter un Module
												</span>
										</a>
									</li>
									
									
								</ul>
							</li>
							
							
							<li class="nav-item ${ProfessorsOpen} ${AllProfessors} ${AjouterProfessor}">
								<a href="#" class="nav-link nav-toggle"> <i class="material-icons">person</i>
									<span class="title">Professeurs</span> <span class="arrow  ${ProfessorsOpen}"></span>
								</a>
								<ul class="sub-menu">
									<li class="nav-item ${AllProfessors}">
										<a href="listeProfesseur" class="nav-link "> <span class="title">Tous les Professeurs</span>
										</a>
									</li>
									<li class="nav-item ${AjouterProfessor}">
										<a href="AjouterProfList" class="nav-link "> <span class="title">Ajouter un Professeur</span>
										</a>
									</li>
									
								</ul>
							</li>
							
							
							<li class="nav-item ${UsersOpen} ${AllUsers} ${AjouterUser}">
								<a href="#" class="nav-link nav-toggle"> <i class="material-icons">face</i>
									<span class="title">Utilisateur</span> <span class="arrow ${UsersOpen}"></span>
								</a>
								<ul class="sub-menu">
									<li class="nav-item ${AllUsers}">
										<a href="listeUser" class="nav-link "> <span class="title">Tous les Utilisateurs</span>
										</a>
									</li>
									<li class="nav-item ${AjouterUser}">
										<a href="listeAjouterUser" class="nav-link "> <span class="title">Ajouter un Utilisateur</span>
										</a>
									</li>
									
								</ul>
							</li>
							
							<li class="nav-item ${StudentsOpen} ${Allstudents}">
								<a href="#" class="nav-link nav-toggle"><i class="material-icons">group</i>
									<span class="title">Etudiants</span><span class="arrow ${StudentsOpen}"></span></a>
								<ul class="sub-menu">
									<li class="nav-item ${Allstudents }">
										<a href="#" class="nav-link "> <span class="title">Tous les Etudiants</span>
										</a>
									</li>
									<li class="nav-item">
										<a href="#" class="nav-link "> <span class="title">Ajouter un Etudiant</span>
										</a>
									</li>
									
									
									
								</ul>
							</li>
							
							
							
							
							
							</c:if>
							
							
							
							
							
							
							<c:if test="${natureUNV == respoF}">
							<li class="nav-item ${Home }">
								<a href="Home" class="nav-link nav-toggle">
									<i class="material-icons">dashboard</i>
									<span class="title">Dashboard</span>
									<span class="selected"></span>
								</a>
								
							</li>
							
							
							<li class="nav-item ">
								<a href="#" class="nav-link nav-toggle"><i class="material-icons">description</i>
									<span class="title">Inscription Pedagogique</span><span class="arrow "></span></a>
								<ul class="sub-menu">
									<li class="nav-item ">
										<a href="#" class="nav-link "> <span class="title">Liste des inscriptions</span>
										</a>
									</li>
									<li class="nav-item">
										<a href="#" class="nav-link "> <span class="title">Ajouter Inscription</span>
										</a>
									</li>
									
									
									
								</ul>
							</li>
							
							<li class="nav-item ">
								<a href="#" class="nav-link nav-toggle"><i class="material-icons">group</i>
									<span class="title">Notes des etudiants</span><span class="arrow "></span></a>
								<ul class="sub-menu">
									<li class="nav-item ">
										<a href="#" class="nav-link "> <span class="title">Importer les notes</span>
										</a>
									</li>
									<li class="nav-item">
										<a href="#" class="nav-link "> <span class="title">Modifier les notes</span>
										</a>
									</li>
									
									
									
									
								</ul>
							</li>
							
							<li class="nav-item ">
								<a href="#" class="nav-link nav-toggle"><i class="material-icons">list</i>
									<span class="title">Etat de deliberation</span><span class="arrow "></span></a>
								<ul class="sub-menu">
									<li class="nav-item ">
										<a href="#" class="nav-link "> <span class="title">Imprimer</span>
										</a>
									</li>
									
								</ul>
							</li>
							
							</c:if>
							
							
							
							
							
							
							
							
							<c:if test="${natureUNV == prof}">
							
							<li class="nav-item ${Home }">
								<a href="Home" class="nav-link nav-toggle">
									<i class="material-icons">dashboard</i>
									<span class="title">Dashboard</span>
									<span class="selected"></span>
								</a>
								
							</li>
							
							<li class="nav-item ">
								<a href="#" class="nav-link nav-toggle"><i class="material-icons">group</i>
									<span class="title">Notes du Module</span><span class="arrow "></span></a>
								<ul class="sub-menu">
									<li class="nav-item ">
										<a href="#" class="nav-link "> <span class="title">Importer les notes</span>
										</a>
									</li>
									<li class="nav-item">
										<a href="#" class="nav-link "> <span class="title">Imprimer les notes</span>
										</a>
									</li>
									
									
									
									
								</ul>
							</li>
							</c:if>
							
							
							
							
							
							
							
							
							
							
							
							<c:if test="${natureUNV == respoM}">
							
							<li class="nav-item ${Home }">
								<a href="Home" class="nav-link nav-toggle">
									<i class="material-icons">dashboard</i>
									<span class="title">Dashboard</span>
									<span class="selected"></span>
								</a>
								
							</li>
							
							<li class="nav-item ">
								<a href="#" class="nav-link nav-toggle"><i class="material-icons">group</i>
									<span class="title">Notes du Module</span><span class="arrow "></span></a>
								<ul class="sub-menu">
									<li class="nav-item ">
										<a href="#" class="nav-link "> <span class="title">Importer les notes</span>
										</a>
									</li>
									<li class="nav-item">
										<a href="#" class="nav-link "> <span class="title">Imprimer les notes</span>
										</a>
									</li>
									
									
									
									
								</ul>
							</li>
							</c:if>
							
							
							
						</ul>
						</div>
						</div>	
								
					</div>
				</div>
			</div>
			<!-- end sidebar menu -->
			
			