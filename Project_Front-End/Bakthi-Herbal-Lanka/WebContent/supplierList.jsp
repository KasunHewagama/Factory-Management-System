
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.itp.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.itp.util.CommonUtilities"%>
<%@page import="com.itp.model.Supplier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itp.services.SupplierServiceImpl"%>
<%@page import="com.itp.services.ISupplierServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier List</title>

  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,900" rel="stylesheet">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

    <!-- Bootstrap CDN and external CSS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="./css/dashBoardStyleSheet.css">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/table.css">

<style>
.has-search .form-control {
	padding-left: 2.375rem;
}

.has-search .form-control-feedback {
	position: absolute;
	z-index: 2;
	display: block;
	width: 2.375rem;
	height: 2.375rem;
	line-height: 2.375rem;
	text-align: center;
	pointer-events: none;
	color: #aaa;
}
</style>

</head>
<body>

  <div class="container-fluid">

        <nav class="navbar navbar-expand-md navbar-light bg-transparent shadow-sm bg-white rounded row nav-margin">
            <a class="navbar-brand logo" href="#">
                Bakthi Herbal Lanka
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link navbar-brand">
                            Home
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">
                            Features
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">
                            Staff
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">
                            Help
                        </a>
                    </li>
                   
                    <li class="nav-item avatar">
                        <a class="nav-link p-0" href="#">
                            <span>

                            </span>
                          
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small name">Administrator</span>
                            <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg" class="rounded-circle z-depth-0" alt="avatar image" height="45">
                        </a>
                    </li>
                </ul>
               
            </div>
        </nav>
    </div>

    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar" class="navbar-expand-md mb-5" style="margin-top: -40px">
            <div class="sidebar-header  row" style="width: 265px;">
               
                <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg" class="rounded-circle z-depth-0" alt="avatar image" height="65">
                <h5 class="mt-4 ml-3">Name</h5>
            </div>

            <ul class="list-unstyled components mb-2">
                <p>Dashboard</p>
              <!--   <li class="active">
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Home</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a href="#">Home 1</a>
                        </li>
                        <li>
                            <a href="#">Home 2</a>
                        </li>
                        <li>
                            <a href="#">Home 3</a>
                        </li>
                    </ul>
                </li> -->
                
                <li>
                    <a href="#">Profile</a>
                </li>
                
                 <li>
                    <a href="supplierList.jsp">Add Supplier</a>
                </li>
                
                  <li>
                    <a href="supplierList.jsp">Supplier List</a>
                </li>
                
                 <li>
                    <a href="rawMaterialList.jsp">Add Raw Material</a>
                </li>
                
                 <li>
                    <a href="rawMaterialList.jsp">Raw Material List</a>
                </li>
                
                <li>
                    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Reports</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                            <a href="#">Supplier Report</a>
                        </li>
                        <li>
                            <a href="#">Raw Material Report</a>
                        </li>
                       
                    </ul>
                </li>
                <li>
                    <a href="#">Settings</a>
                </li>
               
            </ul>


        </nav>

        <!-- Page Content  -->
        <div id="content">

            <nav class="navbar-expand-md mb-4 toggle-bar">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-info" style="background:#4628B8">
                        <i class="fas fa-align-left"></i>
                        <span>Dashboard</span>
                    </button>
                </div>
            </nav>



            <div class="container">

              <div class="row">
    <div class="col">
      <h4 style="text-align: left;">Supplier List Table</h4>
    </div>

    <div class="col-md-auto">

     <div class="form-group has-search">
		<span class="fa fa-search form-control-feedback"></span>
		<input type="text" id="search" name="search" onkeyup="Search()"
			class="form-control purple lighten-1" placeholder="Search">
	</div>

     

    </div>

    <div class="col col-lg-2">

      <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#exampleModal" style="background:#4628B8; color:white; width:150px; height:35px;">
          <i class="fas fa-plus"></i>
          <span>Add Supplier</span>
      </button>


    </div>
  </div>
</div>


<br/>
  <div class="table-wrapper-scroll-y my-custom-scrollbar" style="height: 600px;">
          <table id="dtBasicExample" class="table table-striped table-bordered table-sm" width="100%">
                <thead>
                    <tr class="p-3 mb-2 bg-success text-white">
                        <th scope="col">Supplier ID</th>
                        <th scope="col">Supplier Name</th>
                        <th scope="col">Tel No.</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Product ID</th>
                        <th scope="col">edit</th>
                        <th scope="col">delete</th>
                    </tr>
                </thead>
		
                <tbody>
                
                 <%
            		ISupplierServices iSupplierServices = new SupplierServiceImpl();
					ArrayList<Supplier> arrayList = iSupplierServices.getSuppliers();
			
					for(Supplier supplier : arrayList){
				%>
			
                    <tr id="<%=supplier.getSupplierID()%>">
                    	<td data-target="idS"><%=supplier.getSupplierID() %></td>
                        <td data-target="nameS"><%=supplier.getSupplierName() %></td>
                        <td data-target="telS"><%=supplier.getContactNo() %></td>
                        <td data-target="emailS"><%=supplier.getEmail() %></td>
                        <td data-target="addressS"><%=supplier.getAddress() %></td>
						<td data-target="pidS"><%=supplier.getProductId() %></td>
						
		
					
						
					<!-- 	<input type="hidden" id ="getsupplierid"> -->
						
						<td> <a data-toggal="modal" data-role="update" data-id="<%=supplier.getSupplierID() %>" class="btn btn-success" href="#updateModal"><i class="fas fa-pen-square" style="font-size:15px;"></i></a> </td>
						
						<td> <a data-toggle="modal" data-id="<%=supplier.getSupplierID() %>" class="deletemodal btn btn-danger" href="#deleteModal"><i class="far fa-trash-alt"></i></a></td>
						
                    </tr>
                     <% } %> 
                </tbody>

                 <tfoot>
                  <tr class="p-3 mb-2 bg-success text-white">
                      <th scope="col">Supplier ID</th>
                      <th scope="col">Supplier Name</th>
                      <th scope="col">Tel No.</th>
                      <th scope="col">Email</th>
                      <th scope="col">Address</th>
                      <th scope="col">Product ID</th>
                      <th scope="col">edit</th>
                      <th scope="col">delete</th>
                  </tr>
                </tfoot> 
                
            </table>
            </div>

</div>
</div>
               

            <!-- Modal -->
            <div class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"  aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                <div class="modal-content" style=" background-color: #fefefe;">
                  
                  <div class="modal-header">
                    <h3 class="modal-title">Add Supplier</h3> 
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  
                  <div class="modal-body">

                    <form action="AddSupplierServlet" method="POST" id = "supplierRegistration" style="height:130%; width:100%;">
                    
                     <div class="form-group">
                     
                      <!--   To get auto increment supplier ID to the supplier registration form -->
                     <%
                     ISupplierServices iSupServices = new SupplierServiceImpl();
                     String sID = CommonUtilities.generateSupplierID(iSupServices.getSupplierIDs());
                     %>
                       <label>Supplier ID</label>
                       <input type="text" value="<%=sID %>" class="form-control" name="supplierID" Readonly>
                    </div>
                    
                    <div class="form-group">
                        <label for="validation1">Supplier Name</label>
                        <input type="text" class="form-control" name="supName" id="validation1" placeholder="Supplier Name" required>
                        <div class="invalid-feedback">
                            Please provide a supplier name.
                        </div>
                    </div>       

						<div class="form-group">
						<label>Raw Material ID</label> 
						<select id="inputProID" name="proId" class="form-control">
						
						<!-- to get the raw material IDs in the database to the drop down -->
                        <%Connection connection = DBConnection.getDBConnection();
						  Statement statement = connection.createStatement();
						  ResultSet resultSet = statement.executeQuery("SELECT rID FROM raw_material");	  
							%>
                            <option selected="" value="Default">Choose...</option>
                            <%while(resultSet.next()){ %>
                            <option><%=resultSet.getString(1) %></option>
                          	<%} %>
                            
						</select>
					</div>
					
					
                    <div class="form-group">
                        <label for="validation4">Contact Number</label>
                        <input type="text" class="form-control" name="telNo" id="validation4" placeholder="Contact Number" required>
                            <div class="invalid-feedback">
                                Please provide a contact number.
                            </div>

                    </div>

                    <div class="form-group">
                        <label for="validation5">Email</label>
                        <input type="text" class="form-control" name="email" id="validation5" placeholder="Email" required>
                        <div class="invalid-feedback">
                            Please provide a valid email.
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="validation6">Address</label>
                        <input type="text" class="form-control" name="address" id="validation6" placeholder="Address" required>
                        <div class="invalid-feedback">
                            Please provide a valid Address.
                        </div>
                    </div>

             

                  
                  <div class="modal-footer">
                  
                    <input class="btn btn-primary" type="submit" value="Confirm">
                  
                  </div>
                     </form>
                     </div>
                </div>
              </div>
            </div>
            <!-- Modal End -->
            
   	          <!-- Update Modal -->
            <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalCenterTitle"  aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                <div class="modal-content" style=" background-color: #fefefe;">
                  
                  <div class="modal-header">
                    <h4 class="modal-title">Edit Supplier Details</h4> 
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  
                  <div class="modal-body">

                    <form action="UpdateSupplierServlet" method="POST" id = "supplierUpadte" >
                    
                    <div class="form-group">
                        <label for="validation1">Supplier Name</label>
                        <input type="text" class="form-control" name="supName" id="sName" placeholder="Supplier Name" required>
                        <div class="invalid-feedback">
                            Please provide a supplier name.
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="validation2">Raw Material ID</label>
                        <input type="text" class="form-control" name="proId" id="pId" placeholder="Product Name" required>
                        <div class="invalid-feedback">
                            Please provide a product ID.
                        </div>
                    </div>

    

                    <div class="form-group">
                        <label for="validation4">Contact Number</label>
                        <input type="text" class="form-control" name="telNo" id="sTelNo" placeholder="Contact Number" required>
                            <div class="invalid-feedback">
                                Please provide a contact number.
                            </div>

                    </div>

                    <div class="form-group">
                        <label for="validation5">Email</label>
                        <input type="text" class="form-control" name="email" id="sEmail" placeholder="Email" required>
                        <div class="invalid-feedback">
                            Please provide a valid email.
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="validation6">Address</label>
                        <input type="text" class="form-control" name="address" id="sAddress" placeholder="Address" required>
                        <div class="invalid-feedback">
                            Please provide a valid Address.
                        </div>
                    </div>   
                  
                  <div class="modal-footer">
                  
                  <div class="float-left">
						<button type="button" class="btn btn-danger pull-left" data-dismiss="modal">Close</button>
					</div>
					
					<input type="hidden" id="sID" name="SupID">
					
					<div class="float-right">
						<input type="hidden" id="deleteSup" name="deleteText">
						 <button id="updateServlet" class="btn btn-warning" >Confirm</button>
					</div>
                  
                 
                  </div>
                     </form>
                     </div>
                </div>
              </div>
            </div> 
            <!-- Update Modal End -->
          
			<!--DELETE Modal -->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteModalLabel">Confirmation
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
					<form action="DeleteSupplierServlet" method="POST">
					<div class="float-right">
						<input type="hidden" id="deleteSup" name="deleteText">
						 <button id="deleteServlet" class="btn btn-danger" >Confirm</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Delete Modal End -->

            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

            <script type="text/javascript">
                $(document).ready(function() {
                    $('#sidebarCollapse').on('click', function() {
                        $('#sidebar').toggleClass('active');
                    });
                });
            </script>

            <script>
                $(document).ready(function () {
                  $('#dtBasicExample').DataTable();
                  $('.dataTables_length').addClass('bs-select');
                });
            </script>

            <script>
                // Example starter JavaScript for disabling form submissions if there are invalid fields
                (function() {
                    'use strict';
                    window.addEventListener('load', function() {
                        // Fetch all the forms we want to apply custom Bootstrap validation styles to
                        var forms = document.getElementsByClassName('needs-validation');
                        // Loop over them and prevent submission
                        var validation = Array.prototype.filter.call(forms, function(form) {
                            form.addEventListener('submit', function(event) {
                                if (form.checkValidity() === false) {
                                    event.preventDefault();
                                    event.stopPropagation();
                                }
                                form.classList.add('was-validated');
                            }, false);
                        });
                    }, false);
                })();
            </script>


<script>
		$(document).ready(

		function() {
			$(document).on('click', 'a[data-role=delete]', function() {

				var id = $(this).data('id');
				var sid = $('#' + id).children('td[data-target=sid]').text();

				$('#deleteSup').val(sid);

			})
		});

		$('#deleteServlet').click(function() {

			var id = $('#deleteSup').val();

			$.ajax({
				url : 'DeleteSupplierServlet',
				method : 'post',
				data : {
					id : id,
				},
				success : function(response) {

					$('#' + id).children('td[data-target=sid]').text(id);
				}
			});

		});
	</script>
	
		<script>

		$(document).on("click", ".deletemodal", function () {
		     var supid = $(this).data('id');
		     $(".modal-footer #deleteSup").val( supid );
		     // As pointed out in comments, 
		     // it is unnecessary to have to manually call the modal.
		     // $('#addBookDialog').modal('show');
		})
	</script>
	
		<script>

		$(document).on("click", ".deletemodal", function () {
		     var supid = $(this).data('id');
		     $(".modal-footer #deleteSup").val( supid );
		   
		})
	</script>

<!-- Update Modal -->
<script>
$(document).ready(function(){

    $(document).on('click','a[data-role=update]',function(){
  	 
        var id  = $(this).data('id');
        var supName  = $('#'+id).children('td[data-target=nameS]').text();
		var contact = $('#'+id).children('td[data-target=telS]').text();
		var email = $('#'+id).children('td[data-target=emailS]').text();
		var address = $('#'+id).children('td[data-target=addressS]').text();
		var productID = $('#'+id).children('td[data-target=pidS]').text();
		var supplierID = $('#'+id).children('td[data-target=idS]').text();
		
		$('#sID').val(supplierID); 
        $('#sName').val(supName);
        $('#sTelNo').val(contact);
        $('#sEmail').val(email); 
        $('#sAddress').val(address);
        $('#pId').val(productID);
        
        $('#updateModal').modal('toggle');
  	  
    })
});
</script>

<!-- Search function -->
	<script>
		function Search() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("search");
			filter = input.value.toUpperCase();
			table = document.getElementById("dtBasicExample");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[0];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>

</body>
</html>