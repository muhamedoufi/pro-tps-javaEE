<%@page  import="models.Person" %>
<%@page  import="models.PersonBeans" %>
<%@page  import="java.util.Iterator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Formulaire choix modules </title>
		<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" />
		<link type="text/css" rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap4.min.css"/>
		
		
		<link type="text/css" rel="stylesheet" href="staticfile/style.css" />
	</head>
	<body>
	
	<% 
		        	PersonBeans persons ;
		        	if(request.getAttribute("model") != null ){
		        		persons = (PersonBeans) request.getAttribute("model");
		        	}else{
		        		persons = new PersonBeans();
		        	}
		        %>
		<fieldset>
 			<legend>Inscription</legend>
	
			<form method="post" action="Inscription">
			
				<h1> Vous pouvez vous insicrir via ce formulaire : </h1>
				<br/><br/>
				<div class="dr">
					<div>
						<label>Addresse email : </label>
						<input type="text" name="address" value="" size="20" maxlength="60"/>
					</div>
					<br/>
					<div>
						<label>Mot de pass : </label>
						<input type="text" name="mot_de_pass" value="" size="20" maxlength="20"/>
					</div>
					<br/>
					<div>
						<label> Confirmation du mot de pass : </label>
						<input type="text" name="confirm_mot_de_pass" value="" size="20" maxlength="20"/>
					</div>
					<br/>
					<div>
						<label>Nom d'utilisateur : </label>
						<input type="text" name="nom" value=""  size="20" maxlength="20"/>
					</div>
					<br/><br/><br/>
					<div>
						<input type="submit" value="Inscription" class="sansLabel"/>
					</div>
				</div>
			</form>
			<br>
			<hr>
			
			<table id="example" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		                <th>Id</th>
		                <th>Nom</th>
		                <th>Adress</th>
		                <th>Password</th>
		            </tr>
		        </thead>
		        
		        <% 
		        	Iterator<Person> list = persons.getListe().iterator();
		        	int index = 0;
		        	while(list.hasNext()){
		        		Person p = list.next();
		        	
		        %>
		        <tbody>
		            <tr>
		                <td><%=index%></td>
		                <td><%= p.getNom() %></td>
		                <td><%= p.getAdress() %></td>
		                <td><%= p.getPassword() %></td>
		                
		            </tr>
		        </tbody>
		        <%
		         index++;
		        	}
		        %>
		    
		    </table>
		</fieldset>
		
	</body>
</html>