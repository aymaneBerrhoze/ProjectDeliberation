<%@include file='Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">List Modules</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index-2.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="#">Module</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li class="active">List Modules </li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-xl-12">
							<div class="card-box">
								<div class="card-head">
									<header>Tous les Modules</header>
									
								</div>
								<div class="card-body ">
									<div class="row">
										<div class="col-md-6 col-sm-6 col-6">
											<div class="btn-group">
												<a href="listeAjouterModule" id="addRow" class="btn btn-info">
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
													<th>Id</th>
													<th>LebelleModule</th>
													<th>Filiere</th>
													<th>Semestre</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${Modules}" var="d">
																	
												<tr class="odd">
													<td>${d.getIdModule()}</td>
													<td>${d.getLebelleModule()}</td>
													<td>${d.getFiliere()}</td>
													<td>${d.getSemestre()}</td>
													<td>
													<a href="edit_module.jsp?action=editModule&id=${d.idModule}"
																				class="btn btn-primary btn-xs">
																				<i class="fa fa-pencil"></i>
																			</a>
													<a class="btn btn-danger btn-xs" href="supprimerModule?idModule=${d.idModule}"  
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
			</div>
			<!-- end page content -->
			
		<!-- end page container -->





<jsp:include page="Footer.jsp"/>