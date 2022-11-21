<%@include file='Header.jsp'%>
<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Dashboard</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index.jsp">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li class="active">Dashboard</li>
							</ol>
						</div>
					</div>
					<!-- start widget -->
					<div class="state-overview">
						<div class="row">
							<div class="col-xl-6 col-md-6 col-12">
								<div class="info-box bg-b-green">
									<span class="info-box-icon push-bottom"><i class="material-icons">business</i></span>
									<div class="info-box-content">
										<span class="info-box-text">Total Filieres :</span>
										<span class="info-box-number">${nbreFilieres } Filieres</span>
										<div class="progress">
											
										</div>
										<span class="progress-description">
											
										</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
							</div>
							<!-- /.col -->
							<div class="col-xl-6 col-md-6 col-12">
								<div class="info-box bg-b-yellow">
									<span class="info-box-icon push-bottom"><i class="material-icons">person</i></span>
									<div class="info-box-content">
										<span class="info-box-text">Total Professeurs :</span>
										<span class="info-box-number">${nbreProfesseurs } Professeurs</span>
										<div class="progress">
											
										</div>
										<span class="progress-description">
											
										</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
							</div>
							<!-- /.col -->
							<div class="col-xl-6 col-md-6 col-12">
								<div class="info-box bg-b-blue">
									<span class="info-box-icon push-bottom"><i class="material-icons">face</i></span>
									<div class="info-box-content">
										<span class="info-box-text">Total Utilisateurs :</span>
										<span class="info-box-number">${nbreUsers } Utilisateurs</span>
										<div class="progress">
										</div>
										<span class="progress-description">
										</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
							</div>
							<!-- /.col -->
							<div class="col-xl-6 col-md-6 col-12">
								<div class="info-box bg-b-blue">
									<span class="info-box-icon push-bottom"><i class="material-icons">school</i></span>
									<div class="info-box-content">
										<span class="info-box-text">Total Modules :</span>
										<span class="info-box-number">${nbreModules } Modules</span>
										<div class="progress">
										</div>
										<span class="progress-description">
										</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
							</div>
							
						</div>
					</div>
					<!-- end widget -->
					<br>
					<!-- start course list -->
					<c:if test="${natureUNV == admin}">
							
					<div class="row">
						<c:forEach items="${User}" var="u">
																
						<div class="col-lg-3 col-md-6 col-12 col-sm-6">
							<div class="blogThumb" >
								<div class="thumb-center"><img src="data:image/jpeg;base64,${u.getEncodedPhoto() }"  class="doctor-pic" onerror="if (this.src != 'assets/boss-512.png') this.src = 'assets/boss-512.png';"
																				alt=""></div>
								<div class="course-box">
									<h4>${u.getNomU()} ${u.getPrenomU()}</h4>
									<div class="text-muted"><span class="m-r-10">${u.getNatureUser()}</span>
										
									</div>
									<p><span><i class="fa fa-graduation-cap"></i> Email:
									 ${u.getEmailU()}</span></p>
									<a href="mailto:${u.getEmailU()}" type="button"
										class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-info">Message</a>
								</div>
							</div>
							
						</div>
						</c:forEach>
						
						
					</div>
					<!-- End course list -->
					</c:if>
					
					
				</div>
			</div>
			<!-- end page content -->
			
		
		<!-- end page container -->
		
		
<jsp:include page="Footer.jsp"/>