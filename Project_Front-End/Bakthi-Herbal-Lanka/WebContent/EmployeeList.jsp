<!DOCTYPE html>
<%@page import="com.itp.util.CommonUtilities"%>
<%@page import="com.itp.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itp.services.EmployeeServiceImpl"%>
<%@page import="com.itp.services.IEmployeeServices"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,900"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab|Work+Sans&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">

<!-- Bootstrap CDN and external CSS -->
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/Employee_List.css">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/header.css">
<script src="./js/Registration.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Dashboard</title>
</head>

<body>

	<section id=nav-bar>
		<div class="container-fluid">

			<nav
				class="navbar navbar-expand-md navbar-light bg-transparent shadow-sm bg-white rounded row nav-margin">
				<a class="navbar-brand logo" href="#"> Bakthi Herbal Lanka </a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link navbar-brand">
								Home </a></li>
						<li class="nav-item"><a class="nav-link"> Features </a></li>
						<li class="nav-item"><a class="nav-link"> Staff </a></li>
						<li class="nav-item"><a class="nav-link"> Help </a></li>
						<!-- <h6 class="pt-3 ml-auto" style="font-size: 0.9rem;">User Name</h5> -->
						<li class="nav-item avatar"><a class="nav-link p-0" href="#">
								<span> </span> <!-- <div class="topbar-divider d-none d-sm-block"></div> -->
								<span class="mr-2 d-none d-lg-inline text-gray-600 small name">Administrator</span>
								<img
								src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg"
								class="rounded-circle z-depth-0" alt="avatar image" height="45">
						</a></li>
					</ul>
					<!-- <div class="nav-item avatar">
                            <a class="nav-link p-0" href="#">
                                    <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg" class="rounded-circle z-depth-0"
                                      alt="avatar image" height="45">
                                  </a>
                    </div> -->
				</div>
			</nav>
		</div>
	</section>
	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar" class="navbar-expand-md mb-5 navbar-position"
			style="margin-top: -40px">
			<div class="sidebar-header  row" style="width: 265px;">
				<!-- <h3>Bootstrap Sidebar</h3> -->
				<img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg"
					class="rounded-circle z-depth-0" alt="avatar image" height="65">
				<h5 class="mt-4 ml-3">Name</h5>
			</div>
			<hr class="sidebar-hr my-0">
			<ul class="list-unstyled components">
				<i class="fas fa-fw fa-tachometer-alt"></i>
				<span>Dashboard</span>
				<hr class="sidebar-hr" style="margin-top: 1.2rem;">
				<li><a href="#homeSubmenu" data-toggle="collapse"
					aria-expanded="false">Profile</a></li>
				<li class="active"><a href="EmployeeList.jsp">Employee List</a>
				</li>
				<li><a href="#pageSubmenu" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle">Reports</a></li>
				<li><a href="LoginCreds.jsp">Login Authentication</a></li>
				<li><a href="Leave_List.jsp">Leaves</a></li>
				<li><a href="#">Settings</a></li>
			</ul>
			<!-- <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div> -->

		</nav>

		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar-expand-md mb-4 toggle-bar">
				<div class="container-fluid">

					<button type="button" id="sidebarCollapse" class="btn btn-info">
						<i class="fas fa-bars"></i>
					</button>


				</div>
			</nav>


			<div class="container">

				<div class="row">
					<div class="col">
						<!-- <h4 style="text-align: left;">Employee List Table</h4> -->
					</div>

					<div class="col-md-auto">

						<div class="input-group md-form form-sm form-2 pl-0">
							<input class="form-control my-0 py-1 purple-border" type="text"
								placeholder="Search" aria-label="Search" style="width: 300px;">
							<div class="input-group-append">
								<button class="btn btn-search input-group-text purple lighten-1"
									id="basic-text1"
									style="background: #4628B8; height: 39px; margin-left: 2px;">
									<i class="fas fa-search text-white" aria-hidden="true"></i></span>
							</div>
						</div>

					</div>

					<div class="col col-md-1">
						<button class="btn btn add-btn" type="button" data-toggle="modal"
							data-target="#exampleModal"
							style="background: #4628B8; color: white; width: 120px; height: 39px;">
							<i class="fas fa-plus"></i> <span>Add New</span>
						</button>
					</div>
				</div>
			</div>



			<div class="table-wrapper-scroll-y my-custom-scrollbar"
				style="margin-top: 40px; height: 500px; width: 1270px;">
				<table id="tableResp"
					class="table table-bordered table-striped mb-0 table-lg"
					style="font-size: 14px;">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">Employee ID</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Email</th>
							<th scope="col">Contact No</th>
							<th scope="col">Address</th>
							<th scope="col">Unit</th>
							<th scope="col">Designation</th>
							<th scope="col">Type</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>

						<%
							IEmployeeServices iEmployeeServices = new EmployeeServiceImpl();
							ArrayList<Employee> emplList = iEmployeeServices.getEmployees();

							for (Employee employee : emplList) {
						%>
						<tr id="<%=employee.getEmployeeID()%>">

							<td data-target="img"><img class="table-img"
								style="border-radius: 70px;width: 55px;"
								src="images/imagefiles/<%=employee.getImg()%>"></td>
							<td data-target="eid"><%=employee.getEmployeeID() %></td>
							<td data-target="fnameK"><%=employee.getFname()%></td>
							<td data-id="lname"><%=employee.getLname()%></td>
							<td data-target="gender"><%=employee.getGender()%></td>
							<td data-target="email"><%=employee.getEmail()%></td>
							<td data-target="contactNo"><%=employee.getContactNo()%></td>
							<td data-target="address"><%=employee.getAddress()%></td>
							<td data-target="unit"><%=employee.getUnit()%></td>
							<td data-target="desig"><%=employee.getDesignation()%></td>
							<td data-target="type"><%=employee.getType()%></td>

							<input type="hidden" id="getemployeeid">
							<%-- <td><button class="btn btn-success" data-id="<%=employee.getEmployeeID()%>" data-role="update"
									data-target="#updateModal" data-toggle="modal">Update</button></td> --%>
							<!-- <td><button type="button" onclick="passdataToModal()" class="btn btn-danger" data-toggle="modal"
										data-target="#deleteModal">
										<i class="far fa-trash-alt"></i>
									</button></td> -->
							<td> <a href="#" data-role="update" data-id="<%=employee.getEmployeeID()%>" class="btn btn-success" >Update</a></td>
									
							<td> <a data-toggle="modal" data-id="<%=employee.getEmployeeID()%>" class="deletemodal btn btn-danger" href="#deleteModal"><i class="far fa-trash-alt"></i></a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>

			</div>
		</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmation
						Alert!!!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Are you sure to delete this record?</p>
				</div>
				<div class="modal-footer">
					<div class="float-left">
						<button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
					</div>
					<form action="DeleteEmployeeServlet" method="POST">
					<div class="float-right">
						<input type="hidden" id="deleteEmp" name="deleteText">
						 <button id="deleteServlet" class="btn btn-danger" >Confirm</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>

<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog update-modal" role="document">
		<div class="modal-content "
				style="width: 650px; margin-bottom: 30px;">
				<div class="modal-header">
					<h4 class="title col-md-6">Update</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<form method="POST" action="UpdateEmployeeServlet"
							enctype="multipart/form-data">
							<div class="custom-file col-md-4 center"
										style="margin-left: 200px;">


										<img id="blah" src="./images/avatar.png" alt="your image"
											style="width: 100px; height: 100px; border-radius: 70px;">
										<input type="file" id="imgInp" name="image">



									</div>
									<div class="col-md-10" style="margin-left:50px;">
										<label>First Name</label>
										<input type="text" class="form-control" id="fname" name="fName" >
									</div>
									<div class="col-md-10" style="margin-left:50px;">
										<label>Last Name</label>
										<input type="text" class="form-control" id="lname" name="lName" >
									</div>
									<div class="col-md-10" style="margin-left:50px;">
										<label>Email</label>
										<input type="email" class="form-control" id="email" name="eMail" >
									</div>
									<div class="col-md-10" style="margin-left:50px;">
										<label>Contact No</label>
										<input type="text" class="form-control" id="contactno" name="contactNo" >
									</div>
									<div class="col-md-10" style="margin-left:50px;">
										<label for="inputContact">Address</label> 
										<input type="text" class="form-control" name="address" id="inputAddress">
									</div>
									<div class="col-md-10" style="margin-left:50px;">
										<label>Unit</label> <select id="inputUnit" name="unit"
												class="form-control">
												<option selected="" value="Default">Choose...</option>
												<option>Production</option>
												<option>Management</option>
												<option>Distribution</option>
											</select>
									</div>
										<div class="col-md-10" style="margin-left:50px;">
										<label>Designation</label> <select id="inputDesig2"
												onchange="changeType();" class="form-control"
												name="designation">
												<option selected value="Default">Choose...</option>
												<option>Worker</option>
												<option>Manager</option>
												<option>Marketing Agent</option>
											</select>
									</div>
									
									<div class="col-md-10" style="margin-left:50px;">
										<label>Employee Type</label> <select id="inputType2"
												onchange="changeDesig();" class="form-control"
												name="empType">
												<option selected value="Default">Choose...</option>
												<option>Full-Time</option>
												<option>Part-Time</option>

											</select>
									</div>
									<div style="margin-left:65px; margin-top:20px;width:550px;padding-bottom:10px;">
									<button id="update" class="btn btn-success col-md-10">Update</button>
									</div>
						</form>
					</div>

				</div>

			</div>
		</div>
	</div>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true"
		style="background-color: rgba(0, 0, 0, 0.5);">
		<div class="modal-dialog registration-modal" role="document">
			<div class="modal-content"
				style="width: 1200px; margin-bottom: 30px;">
				<div class="modal-header">
					<h4 class="title col-md-6">Employee Registration</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<form id="registerForm" method="POST" action="AddEmployeeServlet"
							enctype="multipart/form-data">
							<div class="form pl-3 pr-3">
								<div class="row">

									<%
										IEmployeeServices empService = new EmployeeServiceImpl();
										String eid = CommonUtilities.generateEmployeeID(empService.getEmployeeIDs());
									%>
									<div class="form-group col-md-3"
										style="margin-left: 20px; margin-top: 50px;">
										<label>Employee ID</label> <input type="text"
											class="form-control" id="inputEmail4"
											placeholder="Employee ID" value="<%=eid%>" disabled>

										<input type="hidden" name="empID" value="<%=eid%>" />
									</div>
									<div class="custom-file col-md-4 ml-auto"
										style="margin-left: 60px;">


										<img id="blah" src="./images/avatar.png" alt="your image"
											style="width: 100px; height: 100px; border-radius: 70px;">
										<input type="file" id="imgInp" name="image">



									</div>
								</div>
								<div class="form pl-3 pr-3">
									<div class="row">
										<div class="form-group col-md-6">
											<label for="inputEmail4">First Name</label> <input
												type="text" class="form-control" id="inputEmail4"
												placeholder="First Name" name="fname">
										</div>
										<div class="form-group col-md-6">
											<label>Unit</label> <select id="inputUnit" name="unit"
												class="form-control">
												<option selected="" value="Default">Choose...</option>
												<option>Production</option>
												<option>Management</option>
												<option>Distribution</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-6">
											<label for="inputEmail4">Last Name</label> <input type="text"
												class="form-control" name="lname" id="inputEmail4"
												placeholder="Last Name">
										</div>
										<div class="form-group col-md-6">
											<label>Designation</label> <select id="inputDesig"
												onchange="changeType();" class="form-control"
												name="designation">
												<option selected value="Default">Choose...</option>
												<option>Worker</option>
												<option>Manager</option>
												<option>Marketing Agent</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-6">
											<label>Gender</label> <select id="inputState"
												class="form-control" name="gender">
												<option class="dropdown-item" selected value="Default">Choose...</option>
												<option class="dropdown-item">Male</option>
												<option class="dropdown-item">Female</option>

											</select>
										</div>
										<div class="form-group col-md-6">
											<label>Employee Type</label> <select id="inputType"
												onchange="changeDesig();" class="form-control"
												name="empType">
												<option selected value="Default">Choose...</option>
												<option>Full-Time</option>
												<option>Part-Time</option>

											</select>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-6">
											<label for="inputEmail4">Email</label> <input type="email"
												class="form-control" name="email" id="inputEmail4"
												placeholder="Email">
										</div>
										<div class="form-group col-md-6">
											<label for="inputUsername">Username</label> <input
												type="text" class="form-control" name="username"
												id="inputUsername" placeholder="Username">
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-6">
											<label for="inputContact">Contact</label> <input type="text"
												class="form-control" name="contact" id="inputContact"
												placeholder="Contact">
										</div>
										<div class="form-group col-md-6">
											<label for="inputPwrd">Create Password</label> <input
												type="password" class="form-control" name="createPwrd"
												id="inputPwrd" placeholder="Password">
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-6">
											<label for="inputContact">Address</label> <input type="text"
												class="form-control" name="address" id="inputContact"
												placeholder="Address">
										</div>
										<div class="form-group col-md-6">
											<label for="confirmPwrd">Confirm Password</label> <input
												type="password" class="form-control" name="confirmPwrd"
												id="confirmPwrd" placeholder="Confirm Password">
										</div>
									</div>

									<input type="button" class="btn btn-danger"
										style="width: 120px;" data-dismiss="modal" value="Cancel">
									<div class="float-right">
										<button class="btn btn-primary mr-auto" style="width: 120px;">Confirm</button>
									</div>
								</div>
						</form>
					</div>

				</div>

			</div>
		</div>
	</div>








	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="./js/jquery-3.4.1.min.js"></script>
	<script src="./js/jquery.freezeheader.js"></script>
	<script>
		$('table').freezeheader({
			height : "300px"
		})
	</script>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');

			});
		});
	</script>



	<script>
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#blah').attr('src', e.target.result);
				}

				reader.readAsDataURL(input.files[0]);
			}
		}

		$("#imgInp").change(function() {
			readURL(this);
		});
	</script>

	


	<script>

		$(document).on("click", ".deletemodal", function () {
		     var empid = $(this).data('id');
		     $(".modal-footer #deleteEmp").val( empid );
		   
		})
	</script>
		
<script>
$(document).ready(function(){
	
		$(document).on('click', 'a[data-role=update]', function () {
		    var id = $(this).data('id'); 
			var fstname = $('#' + id).children('td[data-taget=fnameK]').text();
		    var lastname = $(lname).data('id');
		   
		    
		    $('.modal-body #fname').val(fstname);
		     $('#updateModal').modal('toggle');
		})
});
	</script>
	
</body>

</html>