<%@include file='Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="beans.Module" %>
<%@page import="dao.ModuleImpl" %>
<%@page import="dao.FiliereImpl" %>
<%@page import="dao.ImplSemestre" %>
<%@page import="beans.Module" %>

<%
	String id = request.getParameter("id");
    ModuleImpl c = new ModuleImpl();
    ImplSemestre s = new ImplSemestre();
    FiliereImpl f = new FiliereImpl();
	Module cc = c.chercherModule(Integer.parseInt(id));
	request.setAttribute("semestre",s.chercherSemestre(cc.getIdSemestre()).getLibelleSemestre());
    request.setAttribute("Professeur", c.listeModule());
    request.setAttribute("filiere", f.listeFiliere());
%>
<!-- start page content -->
<div class="page-content-wrapper">
	<div class="page-content">
		<div class="page-bar">
			<div class="page-title-breadcrumb">
				<div class=" pull-left">
					<div class="page-title">Modifier module</div>
				</div>
				<ol class="breadcrumb page-breadcrumb pull-right">
					<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
						href="index-2.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
					</li>
					<li><a class="parent-item" href="#">module</a>&nbsp;<i
						class="fa fa-angle-right"></i></li>
					<li class="active">Modifier module</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="card-box">
					<div class="card-head">
						<header>Modifier module</header>
						
					</div>
					<form action="updateModule" method="post">
						<div class="card-body row">
<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="hidden" id="txtFirstName" value="<%= cc.getIdModule()%>" name="id">
											<label class="mdl-textfield__label"></label>
										</div>
									</div>
							<div class="col-lg-12 p-t-20">
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
									<input class="mdl-textfield__input" type="text" value="<%= cc.getFiliere()%>" name="filiere" id="list2"
										
										readonly> <label for="list2"
										class="pull-right margin-0"> <i
										class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
									</label> <label for="list2" class="mdl-textfield__label">Departement</label>
									<ul data-mdl-for="list2"
										class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
										<c:forEach items="${filiere}" var="d">
											<li class="mdl-menu__item" value="${d.getNomFiliere()}">${d.getNomFiliere()}</li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="col-lg-6 p-t-20">
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
									<input class="mdl-textfield__input" value="<%= cc.getLebelleModule()%>" type="text"
										name="LebelleModule" id="txtAuther"> <label
										class="mdl-textfield__label">Module</label>
								</div>
							</div>
							
							<div class="col-lg-6 p-t-20">
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
									<input class="mdl-textfield__input" type="text" value="${semestre }" id="sample2"
										name="semestre" readonly tabIndex="-1"> <label
										for="sample2" class="pull-right margin-0"> <i
										class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
									</label> <label for="sample2" class="mdl-textfield__label">Semestre</label>
									<ul data-mdl-for="sample2"
										class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
										<c:forEach var="i" begin="1" end="6">
											<li class="mdl-menu__item" data-val="DE">S${i}</li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="col-lg-12 p-t-20 text-center">
								<button type="submit"
									class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink">Submit</button>
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


<!-- end page container -->





<jsp:include page="Footer.jsp" />