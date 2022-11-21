<%@include file='Header.jsp'%>



<!-- start page content -->
<div class="page-content-wrapper">
	<div class="page-content">
		<div class="page-bar">
			<div class="page-title-breadcrumb">
				<div class=" pull-left">
					<div class="page-title">Ajouter Utilisateur</div>
				</div>
				<ol class="breadcrumb page-breadcrumb pull-right">
					<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
						href="index.jsp">Home</a>&nbsp;<i class="fa fa-angle-right"></i></li>
					<li><a class="parent-item" href="#">Utilisateur</a>&nbsp;<i
						class="fa fa-angle-right"></i></li>
					<li class="active">Ajouter Utilisateur</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="card-box">
					<div class="card-head">
						<header>Ajouter un utilisateur</header>
						
					</div>
					<!-- Href submit -->
					<script type="text/javascript">
						function submitFormWithValue(val) {
							document.getElementById('nomU').value = val;
							document.forms["fetch"].submit();
						}
					</script>
					<!-- fetch form -->
					<form id="fetch" name="fetch" action="fetchProf" method="post">
						<div class="col-lg-6 p-t-20">
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Entrez le nom de l'utilisateur à ajouter s'il existe "
										name="nomU" required> <span class="input-group-btn">
										<a href="javascript:submitFormWithValue('foo')"
										class="btn submit"> <i class="icon-magnifier"></i>
									</a>
									</span>
									<strong style="color: #F6323E"> ${err} </strong>
								</div>
							</div>
						</div>
					</form>
					
					<form action="ajouterUser" method="Post"
						enctype="multipart/form-data">
						<div class="card-body row">
							<div class="col-lg-6 p-t-20">
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
									<input class="mdl-textfield__input" type="text"
										id="txtFirstName" name="nomU" value="${user.nomU}" required> <label
										class="mdl-textfield__label">Nom</label>
								</div>
							</div>
							<div class="col-lg-6 p-t-20">
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
									<input class="mdl-textfield__input" type="text"
										id="txtLasttName" name="prenomU" value="${user.prenomU}" required> <label
										class="mdl-textfield__label">Prenom</label>
								</div>
							</div>
							<div class="col-lg-6 p-t-20">
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
									<input class="mdl-textfield__input" type="email" id="txtemail"
										name="emailU" value="${user.emailU}" required> <label
										class="mdl-textfield__label">Email</label> <span
										class="mdl-textfield__error">Enter Valid Email Address!</span>
								</div>
							</div>

							<div class="col-lg-6 p-t-20">
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
									<input class="mdl-textfield__input" value="${user.mdpU}" type="password" id="txtPwd"
										name="mdpU" required> <label
										class="mdl-textfield__label">Password</label>
								</div>
							</div>


							<div class="col-lg-6 p-t-20">
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height txt-full-width">
									<input class="mdl-textfield__input" type="text" id="list2"
										value="" name="natureUser" readonly tabIndex="-1" required>
									<label for="list2" class="pull-right margin-0"> <i
										class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
									</label> <label for="list2" class="mdl-textfield__label">Nature</label>
									<ul data-mdl-for="list2"
										class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
										<li class="mdl-menu__item" data-val="DE">Administrateur</li>
										<li class="mdl-menu__item" data-val="BY">Responsable de la filiere</li>
										<li class="mdl-menu__item" data-val="BY">Responsable de module</li>
										<li class="mdl-menu__item" data-val="BY">Professeur</li>
									</ul>
								</div>
							</div>



							<div class="col-lg-12 p-t-20">
								<label class="control-label col-md-3">Upload Photo </label>
								<div class="col-md-12">
									<input type="file" name="imageU" class="id_dropzone"
										class="dropzone">
								</div>
							</div>

							<div class="col-lg-12 p-t-20 text-center">
								<button type="submit"
									class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink">Submit</button>
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






<jsp:include page="Footer.jsp" />