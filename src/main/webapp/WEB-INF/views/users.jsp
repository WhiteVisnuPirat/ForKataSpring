<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management</title>
    <style>
        table { border-collapse: collapse; width: 100%; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f2f2f2; font-weight: bold; }
        .form-container { margin: 20px 0; padding: 20px; border: 1px solid #ddd; background-color: #f9f9f9; }
        input[type="text"], input[type="email"], input[type="number"] {
            padding: 8px; margin: 5px 0; width: 200px;
        }
        button { padding: 8px 15px; margin: 5px; cursor: pointer; }
        .actions { white-space: nowrap; }
    </style>
</head>
<body>
<h1>User Management System</h1>

<!-- Форма для добавления/редактирования -->
<div class="form-container">
    <h2>${user == null ? 'Add New User' : 'Edit User'}</h2>
    <form method="post" action="${pageContext.request.contextPath}/${user == null ? 'addUser' : 'updateUser'}">
        <c:if test="${user != null}">
            <input type="hidden" name="id" value="${user.id}">
        </c:if>

        <div>
            <label>First Name:</label><br>
            <input type="text" name="firstName" value="${user.firstName}" required>
        </div>

        <div>
            <label>Last Name:</label><br>
            <input type="text" name="lastName" value="${user.lastName}" required>
        </div>

        <div>
            <label>Email:</label><br>
            <input type="email" name="email" value="${user.email}" required>
        </div>

        <div>
            <label>Age:</label><br>
            <input type="number" name="age" value="${user.age}" min="1" required>
        </div>

        <div>
            <button type="submit">${user == null ? 'Add User' : 'Update User'}</button>
            <c:if test="${user != null}">
                <a href="${pageContext.request.contextPath}/users" style="margin-left: 10px;">Cancel Edit</a>
            </c:if>
        </div>
    </form>
</div>

<!-- Таблица пользователей -->
<h2>Users List</h2>
<c:if test="${not empty users}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.age}</td>
                <td class="actions">
                    <form method="get" action="${pageContext.request.contextPath}/editUser" style="display:inline;">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit">Edit</button>
                    </form>
                    <form method="post" action="${pageContext.request.contextPath}/deleteUser" style="display:inline;">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit" onclick="return confirm('Are you sure you want to delete this user?')">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${empty users}">
    <p>No users found. Please add some users.</p>
</c:if>
</body>
</html>