<%@include file='Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Liste Filiere</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index.jsp">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="#">Filiere</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li class="active">Liste Filiere</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-xl-12">
							<div class="card-box">
								<div class="card-head">
									<header>Toutes les Filieres</header>
									
								</div>
								<div class="card-body ">
									<div class="row">
										<div class="col-md-6 col-sm-6 col-6">
											<div class="btn-group">
												<a href="ListRespoFil" id="addRow" class="btn btn-info">
													Add New  <i class="fa fa-plus"></i>
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
													<th>#</th>
													<th>Nom Filiere</th>
													<th>Responsable Filiere </th>
													
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
											    <c:forEach items="${Filiere}" var="f">				
												<tr class="odd">
													<td>${f.idFiliere}</td>
													<td>${f.getNomFiliere()}</td>
													<td>${f.getResponsablefiliere()}</td>
													
													<td><a href="edit_department.jsp?action=editFiliere&id=${f.idFiliere}" class="" data-toggle="tooltip"
															title="Edit">
															<i class="fa fa-check"></i></a> <a href="supprimerFiliere?idFiliere=${f.idFiliere}"  
                                                                               onclick="return confirm('Are you sure you want to delete this item?');"
															class="text-inverse" title="Delete" data-toggle="tooltip">
															<i class="fa fa-trash"></i></a>
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