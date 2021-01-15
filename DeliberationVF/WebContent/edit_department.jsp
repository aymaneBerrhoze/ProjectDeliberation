<%@include file='Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="beans.Filiere" %>
<%@page import="dao.FiliereImpl" %>
<%@page import="dao.UserImpl" %>

<%
	String id = request.getParameter("id");
    FiliereImpl c = new FiliereImpl();
    UserImpl u = new UserImpl();
    Filiere cc = c.chercherFiliere(Integer.parseInt(id));
    request.setAttribute("RespoF", u.listeUserRespoF());
%>




<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Modifier Filiere</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index-2.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="#">Filiere</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li class="active">Modifier Filiere</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<div class="card-head">
									<header>Modifier une filiere</header>
									
								</div>
								<form action="updateFiliere" method="post">
								<div class="card-body row">
								<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="hidden" id="txtFirstName" value="<%= cc.getIdFiliere()%>" name="id" >
											<label class="mdl-textfield__label"></label>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text" id="txtDepName" value="<%= cc.getNomFiliere()%>" name="NomFiliere">
											<label class="mdl-textfield__label">Nom Filiere</label>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
											<input class="mdl-textfield__input" type="text" id="list2" value="<%= cc.getResponsablefiliere()%>" name="responsablefiliere" readonly
												tabIndex="-1">
											<label for="list2" class="pull-right margin-0">
												<i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
											</label>
											<label for="list2" class="mdl-textfield__label">Responsable Filiere</label>
											<ul data-mdl-for="list2" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
											<c:forEach items="${RespoF}" var="r">
												<li class="mdl-menu__item" data-val="DE">${r.getNomU()} ${r.getPrenomU()}</li>
												</c:forEach>
											</ul>
										</div>
									</div>
									<div class="col-lg-12 p-t-20 text-center">
										<button type="submit"
											class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink" value="${id}">Submit</button>
										<button type="button"
											class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-default">Cancel</button>
									</div>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end page content -->
			










<jsp:include page="Footer.jsp"/>