
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note jsp Page</title>
    </head>
    <body>
        <h1>Note!!!</h1>
        <div>
            <form action="notes" method="post">
                <table style="width:100%">
                    <tr>
                        <th>Date Created</th>
                        <th>Title</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${notes}" var="note">
                    <tr>
                        <td>${note.datecreated}</td>
                        <td>${note.title}</td>
                        <td type="hidden" name="id" value="${note.noteid}"></td>
                        <td><input type="submit" name="button" value="edit"></td>
                    </tr>
                    </c:forEach>
                  
                </table>
            </form>
            <form action="notes" method="post">
                <h2>Add Note</h2>
               
                <input type="submit" name="action" value="Delete Note"><br><br>
                <input type="text" name="title" value=""><br>   
                    

                <input type="textbox" name="content" style="height:150px;font-size:20pt;" value="${ReadNote.contents}">
                <input type="hidden" name="action" value="add" />
                <input type="submit" value="add" />
            </form>
        </div>
        
       
    </body>
</html>
