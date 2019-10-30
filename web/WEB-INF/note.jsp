<%-- 
    Document   : note
    Created on : Oct 26, 2019, 7:37:05 PM
    Author     : 784564
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Note!!!</h1>
        <div>
            <form action="login" method="post">
                <table style="width:100%">
  <tr>
    <th>Date Created</th>
    <th>Title</th>
    <th></th>
  </tr>
  
  <tr>
    <td>Jill</td>
    <td>Smith</td>
    <td><input type="submit" name="button" value="Edit"></td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>Jackson</td>
    <td><input type="submit" name="button" value="Edit"></td>
  </tr>
</table>
                <h2>Edit Note</h2>
           
            <input type="submit" name="action" value="Delete Note"><br><br>
            <input type="text" name="title" value="${ReadNote.title}"><br>
            
            <input type="textbox" name="content" style="height:150px;font-size:20pt;" value="${ReadNote.contents}">
            <input type="hidden" name="action" value="add" />
            <input type="submit" value="add" />
            </form>
        </div>
            <a href="">After the user clicks edit</a>
            ${msg}
    </body>
</html>
