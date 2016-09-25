<%--
  Created by IntelliJ IDEA.
  User: nikpodrivnik
  Date: 25/09/16
  Time: 00:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="cp1251" %>
<%@ page language="java" contentType="text/html;charset=cp1251" %>
<div>
    <div class="searchbar">
        <div class="form-group searchText">
            <input type="text" id="searchTextInput" class="form-control" placeholder="Введите ФИО или номер телефона и нажмите ENTER">
        </div>
        <div class="searchButton">
            <button class="btn btn-default createNewContact">Создать</button>
        </div>

    </div>

    <div class="resultGrid">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">


        </div>
    </div>
</div>

<jsp:include page="saveEditDialog.jsp"/>