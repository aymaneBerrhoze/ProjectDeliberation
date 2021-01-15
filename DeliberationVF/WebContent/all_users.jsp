<%@include file='Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Liste Utilisateurs</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index-2.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="#">Utilisateur</a>&nbsp;<i
										class="fa fa-angle-right"></i>
								</li>
								<li class="active">Liste Utilisateurs</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="tabbable-line">
								<ul class="nav customtab nav-tabs" role="tablist">
									<li class="nav-item"><a href="#tab1" class="nav-link active" data-toggle="tab">List
											View</a></li>
									<li class="nav-item"><a href="#tab2" class="nav-link" data-toggle="tab">Grid
											View</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active fontawesome-demo" id="tab1">
										<div class="row">
											<div class="col-md-12">
												<div class="card card-topline-red">
													<div class="card-head">
														<header>Tous les utilisateurs</header>
														
													</div>
													<div class="card-body ">
														<div class="row">
															<div class="col-md-6 col-sm-6 col-6">
																<div class="btn-group">
																	<a href="listeAjouterUser" id="addRow"
																		class="btn btn-info">
																		Add New <i class="fa fa-plus"></i>
																	</a>
																</div>
															</div>
															
														</div>
														<div class="table-scrollable">
															<table
																class="table table-striped table-bordered table-hover table-checkable order-column valign-middle"
																id="exportTable">
																<thead>
																	<tr>
																		<th></th>
																		<th> Nom </th>
																		<th> Prenom </th>
																		<th> Email </th>
																		<th> Nature </th>
																		<th> <strong style="color: #F6323E"> ${msg }</strong> </th>
																	</tr>
																</thead>
																<tbody>
																<c:forEach items="${User}" var="u">
																	<tr class="odd gradeX">
																		<td class="patient-img">
																			<img src="data:image/jpeg;base64,${u.getEncodedPhoto() }" onerror="if (this.src != 'assets/boss-512.png') this.src = 'assets/boss-512.png';"
																				alt="">
																		</td>
																		<td>${u.getNomU()}</td>
																		<td class="center">${u.getPrenomU()}</td>
																		
																		<td><a href="mailto:${u.getEmailU()}">
																				${u.getEmailU()} </a></td>
																		<td class="center">${u.getNatureUser()}</td>
																		<td>
																			<a href="editUser?id=${u.idUser}"
																				class="btn btn-primary btn-xs">
																				<i class="fa fa-pencil"></i>
																			</a>
																			<a href="supprimerUser?idUser=${u.idUser}"  
                                                                               onclick="return confirm('Are you sure you want to delete this item?');"
																				class="btn btn-danger btn-xs">
																				<i class="fa fa-trash-o "></i>
																			</a>
																		</td>
																	</tr>
																	</c:forEach>
																	
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane" id="tab2">
										<div class="row">
											<c:forEach items="${User}" var="u">
											<div class="col-md-4">
												<div class="card card-topline-aqua">
													<div class="card-body no-padding ">
														<div class="doctor-profile">
															
																<img src="data:image/jpeg;base64,${u.getEncodedPhoto() }"  class="doctor-pic" onerror="if (this.src != 'assets/boss-512.png') this.src = 'assets/boss-512.png';"
																				alt="">
															<div class="profile-usertitle">
																<div class="doctor-name">${u.getNomU()} ${u.getPrenomU()}</div>
																<div class="name-center"> ${u.getNatureUser()} </div>
															</div>
															
															<div>
																<p><i class="fa fa-mail"></i><a
																		href="mailto:${u.getEmailU()}"> ${u.getEmailU()}</a></p>
															</div>
															<div class="profile-userbuttons">
																<a href="afficherUser?idUser=${u.idUser}"
																	class="btn btn-circle deepPink-bgcolor btn-sm">Read
																	More</a>
															</div>
														</div>
													</div>
												</div>
											</div>
											</c:forEach>
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end page content -->
			
			
		</div>
		<!-- end page container -->







<jsp:include page="Footer.jsp"/>