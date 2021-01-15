<%@include file='Header.jsp'%>
<%@page import="beans.User" %>
<%@page import="dao.UserImpl" %>

<%
	String id = request.getParameter("id");
    
    UserImpl c = new UserImpl();
	User cc = c.chercherUser(Integer.parseInt(id));
	request.setAttribute("id", id);
%>


<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Modifier Utilisateur</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
										href="index.jsp">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="#">Utilisateur</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li class="active">Modifier Utilsateur</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<div class="card-head">
									<header>Modifier un utilisateur</header>
									
								</div>
								<form action="updateUser" method="post" enctype="multipart/form-data">
								<div class="card-body row">
								   <div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="hidden" id="txtFirstName" value="${id }" name="id">
											<label class="mdl-textfield__label"></label>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text" id="txtFirstName" value="<%= cc.getNomU()%>" name="nomU">
											<label class="mdl-textfield__label">Nom</label>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text" id="txtLasttName" name="prenomU" value="<%= cc.getPrenomU()%>">
											<label class="mdl-textfield__label">Prenom</label>
										</div>
									</div>
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="email" id="txtemail" value="<%= cc.getEmailU()%>" name="emailU">
											<label class="mdl-textfield__label">Email</label>
											<span class="mdl-textfield__error">Enter Valid Email Address!</span>
										</div>
									</div>
									
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="password" id="txtPwd" value="<%= cc.getMdpU()%>" name="mdpU">
											<label class="mdl-textfield__label">Password</label>
										</div>
									</div>
									
									
									<div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
											<input class="mdl-textfield__input" type="text" id="list2" value="<%= cc.getNatureUser()%>" name="natureUser" readonly
												tabIndex="-1">
											<label for="list2" class="pull-right margin-0">
												<i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
											</label>
											<label for="list2" class="mdl-textfield__label">Nature</label>
											<ul data-mdl-for="list2" class="mdl-menu mdl-menu--bottom-left mdl-js-menu" >
												<li class="mdl-menu__item" data-val="DE">Administrateur</li>
												<li class="mdl-menu__item" data-val="BY">Responsable de la filiere</li>
												<li class="mdl-menu__item" data-val="BY">Responsable de module</li>
												<li class="mdl-menu__item" data-val="BY">Professeur</li>
											</ul>
										</div>
									</div>
									
									<!-- <div class="col-lg-6 p-t-20">
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
											<input class="mdl-textfield__input" type="text"
												pattern="-?[0-9]*(\.[0-9]+)?" id="text5">
											<label class="mdl-textfield__label" for="text5">Mobile Number</label>
											<span class="mdl-textfield__error">Number required!</span>
										</div>
									</div> -->
									
									
									<div class="col-lg-12 p-t-20">
										
										<div class="col-md-12">
											<img src="data:image/jpeg;base64,<%= cc.getEncodedPhoto()%>" onerror="if (this.src != 'assets/boss-512.png') this.src = 'assets/boss-512.png';"
																				alt="" width="100" height="100">
											<label class="control-label col-md-5">Modifier image : </label>	
											<input type="file"  name="imageU"  width="100" height="100">
										</div>
									</div>
					
									<div class="col-lg-12 p-t-20 text-center">
										<button type="submit"
											class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink" value="${id}">Submit</button>
										<a href="listeUser" type="button"
											class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-default">Cancel</a>
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





<jsp:include page="Footer.jsp"/>