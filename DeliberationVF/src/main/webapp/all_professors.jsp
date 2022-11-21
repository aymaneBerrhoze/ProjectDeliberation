<%@include file='Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Liste Professeurs</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index.jsp">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="#">Professeurs</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li class="active">Liste Professeurs</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="tabbable-line">
								<!-- <ul class="nav nav-tabs">
                                    <li class="active">
                                        <a href="#tab1" data-toggle="tab"> List View </a>
                                    </li>
                                    <li>
                                        <a href="#tab2" data-toggle="tab"> Grid View </a>
                                    </li>
                                </ul> -->
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
												<div class="card card-box">
													<div class="card-head">
														<header>Tous les Professeurs</header>
														
														
													</div>
													<div class="card-body ">
														<div class="row">
															<div class="col-md-6 col-sm-6 col-6">
																<div class="btn-group">
																	<a href="AjouterProfList" id="addRow"
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
																	    <th>ID</th>
																		<th> Nom </th>
																		<th> Prenom </th>
																		<th> Discipline </th>
																		<th> Departement </th>
																		<th> Module enseigne </th>
																		<th> Email </th>
																		<th>Tel Prof</th>
																		<th> Action </th>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach items="${Professeur}" var="d">
																	<tr class="odd gradeX">
																		<td>${d.idProfesseur}</td>
																		<td>${d.getNomProf()}</td>
																		<td class="left">${d.getPrenomProf()}</td>
																		<td class="left">${d.getDiscipline()}</td>
																		<td class="left">${d.getDepartement_dattache()}</td>
																		<td class="left">${d.getModule_enseigne()}</td>
																		<td><a href="mailto:${d.getEmailP()}">
																				${d.getEmailP()}</a></td>
																		<td><a href="tel:${d.getTelP()}">
																				${d.getTelP()}</a></td>
																		<td>
																			<a href="editProfesseur?id=${d.idProfesseur}&filiere=${d.getDepartement_dattache()}"
																				class="btn btn-primary btn-xs">
																				<i class="fa fa-pencil"></i>
																			</a>
																			<a class="btn btn-danger btn-xs" href="supprimerProfesseur?idProfesseur=${d.idProfesseur}"  
                                                                               onclick="return confirm('Are you sure you want to delete this item?');">
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
											<c:forEach items="${Professeur}" var="d">
											<div class="col-md-4">
												<div class="card card-box">
													<div class="card-body no-padding ">
														<div class="doctor-profile">
															
															<div class="profile-usertitle">
																<div class="doctor-name">${d.getNomProf()} ${d.getPrenomProf()}</div>
																<div class="name-center"> ${d.getModule_enseigne()} </div>
															</div>
															
															<div>
															    <p><i class="fa fa-mail"></i><a
																		href="mailto:${d.getEmailP()}"> ${d.getEmailP()}</a></p>
																<p><i class="fa fa-phone"></i><a
																		href="tel:${d.getTelP()}"> ${d.getTelP()}</a></p>
															</div>
															<div class="profile-userbuttons">
																<a href="professor_profile.jsp"
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
			</div>
				
		<!-- end page container -->
			
<jsp:include page="Footer.jsp"/>