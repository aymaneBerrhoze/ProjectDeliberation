<%@include file='Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="beans.Professeur" %>
<%@page import="dao.ImplProfessor" %>
<%@page import="dao.FiliereImpl" %>

<%
	String id = request.getParameter("id");
	ImplProfessor c = new ImplProfessor();
    FiliereImpl f = new FiliereImpl();
    Professeur cc = c.chercherProfesseur(Integer.parseInt(id));
	request.setAttribute("Departement", f.listeFiliere());
    request.setAttribute("Professeur", c.listeProfesseur());
    request.setAttribute("Module", c.listeProfesseurParModule(request.getParameter("fil")));
    
    request.setAttribute("id", id);
%>


<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Modifier Professeur</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index.jsp">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="#">Professeur</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li class="active">Modifier Professeur</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<div class="card-head">
									<header>Modifier un professeur</header>
									
								</div>
								<form method="post" action="updateProfesseur" onsubmit="return validate()">
								
								<div class="card-body row">
								<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="hidden" id="txtFirstName" value="${id }" name="id">
											<label class="mdl-textfield__label"></label>
										</div>
									</div>
								<div class="col-lg-12 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
											<input class="mdl-textfield__input" type="text" id="list2" value="${filiere }" onchange="window.location.href='ModulelistParFil1?fil='+this.value+'&id='+${id}"
												readonly tabIndex="-1">
											<label for="list2" class="pull-right margin-0">
												<i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
											</label>
											<label for="list2" class="mdl-textfield__label">Filiere</label>
											<ul data-mdl-for="list2" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
												<c:forEach items="${Departement}" var="d">
												<li class="mdl-menu__item" value="${d.getNomFiliere()}">${d.getNomFiliere()}</li>
												</c:forEach>
											</ul>
																					</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text" id="txtFirstName" value="<%= cc.getNomProf()%>" name="NomProf">
											<label class="mdl-textfield__label">Nom</label>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text" id="txtLasttName" value="<%= cc.getPrenomProf()%>" name="PrenomProf">
											<label class="mdl-textfield__label">Prenom</label>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="email" id="txtemail" value="<%= cc.getEmailP()%>" name="emailP">
											<label class="mdl-textfield__label">Email</label>
											<span class="mdl-textfield__error">Enter Valid Email Address!</span>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text" id="discipline" value="<%= cc.getDiscipline()%>" name="discipline">
											<label class="mdl-textfield__label">Discipline</label>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="password" id="txtPwd" value="<%= cc.getMdpP()%>" name="mdpP">
											<label class="mdl-textfield__label">Password</label>
										</div>
									</div>
									<!-- <div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="password" id="txtConfirmPwd">
											<label class="mdl-textfield__label">Confirm Password</label>
										</div>
									</div> -->
									<!-- <div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text" id="designation">
											<label class="mdl-textfield__label">Designation</label>
										</div>
									</div> -->
									
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
											<input class="mdl-textfield__input" type="text" id="sample2" value="<%= cc.getModule_enseigne()%>" name="module_enseigne"
												readonly tabIndex="-1">
											<label for="sample2" class="pull-right margin-0">
												<i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
											</label>
											<label for="sample2" class="mdl-textfield__label">Module Enseigné</label>
											<ul data-mdl-for="sample2"
												class="mdl-menu mdl-menu--bottom-left mdl-js-menu" >
												<c:forEach items="${Module}" var="m">
												<li class="mdl-menu__item" data-val="DE">${m.getLebelleModule()}</li>
												</c:forEach>
											</ul>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text"
												pattern="-?[0-9]*(\.[0-9]+)?" id="text5" value="<%= cc.getTelP()%>" name="telP">
											<label class="mdl-textfield__label" for="text5">Mobile Number</label>
											<span class="mdl-textfield__error">Number required!</span>
										</div>
									</div>
									<!-- <div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text" id="dateOfBirth">
											<label class="mdl-textfield__label">Birth Date</label>
										</div>
									</div> -->
									
									
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
			



<jsp:include page="Footer.jsp"/>