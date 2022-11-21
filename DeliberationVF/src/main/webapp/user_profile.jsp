<%@include file='Header.jsp'%>






<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Profil Utilisateur</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index-2.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="#">Utilisateur</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li class="active">Profil Utilisateur</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN PROFILE SIDEBAR -->
							<div class="profile-sidebar">
								<div class="card card-topline-aqua">
									<div class="card-body no-padding height-9">
										<div class="row">
											<div class="profile-userpic">
												<img src="data:image/jpeg;base64,${idUser.getEncodedPhoto() }"  class="doctor-pic" onerror="if (this.src != 'assets/boss-512.png') this.src = 'assets/boss-512.png';"
																				alt="">
											</div>
										</div>
										<div class="profile-usertitle">
											<div class="profile-usertitle-name"> ${idUser.getNomU()} ${idUser.getPrenomU()} </div>
											<div class="profile-usertitle-job"> ${idUser.getNatureUser() } </div>
										</div>
										<ul class="list-group list-group-unbordered">
											<li class="list-group-item">
												<b>Email</b> <a class="pull-right"> ${idUser.getEmailU() }</a>
											</li>
											
										</ul>
										<!-- END SIDEBAR USER TITLE -->
										<!-- SIDEBAR BUTTONS -->
										<div class="profile-userbuttons">
											
											<a href="mailto:${idUser.getEmailU()}" type="button"
												class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-circle btn-pink">Message</a>
										</div>
										<!-- END SIDEBAR BUTTONS -->
									</div>
								</div>
								
								
							</div>
							<!-- END BEGIN PROFILE SIDEBAR -->
							<!-- BEGIN PROFILE CONTENT -->
							<div class="profile-content">
								<div class="row">
									<div class="card">
										<div class="card-topline-aqua">
											<header></header>
										</div>
										<div class="white-box">
											<!-- Nav tabs -->
											<div class="p-rl-20">
												<ul class="nav customtab nav-tabs" role="tablist">
													<li class="nav-item"><a href="#tab1" class="nav-link active"
															data-toggle="tab">About Me</a></li>
													
												</ul>
											</div>
											<!-- Tab panes -->
											<div class="tab-content">
												<div class="tab-pane active fontawesome-demo" id="tab1">
													<div id="biography">
														<div class="row">
															<div class="col-md-6 col-6 b-r"> <strong>Nom Complet</strong>
																<br>
																<p class="text-muted">${idUser.getNomU()} ${idUser.getPrenomU()} </p>
															</div>
															
															<div class="col-md-6 col-6 b-r"> <strong>Email</strong>
																<br>
																<p class="text-muted"> ${idUser.getEmailU() }</p>
															</div>
															<div class="col-md-6 col-6"> <strong>Nature</strong>
																<br>
																<p class="text-muted">${idUser.getNatureUser() }</p>
															</div>
														</div>
														<hr>
														
														
														
														
																											</div>
												</div>
												
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- END PROFILE CONTENT -->
						</div>
					</div>
				</div>
				<!-- end page content -->
				
			</div>
			<!-- end page container -->







<jsp:include page="Footer.jsp"/>