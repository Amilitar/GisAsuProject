<%--
  Created by IntelliJ IDEA.
  User: nikpodrivnik
  Date: 25/09/16
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="cp1251" %>
<%@ page language="java" contentType="text/html;charset=cp1251" %>
<div class="modal fade" id="saveEditDialog" tabindex="-1" role="dialog" aria-labelledby="saveEditLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="saveEditLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                <div class="contactContent">
                    <div class="input-group">
                        <div>Имя:</div>
                        <input type="text" class="form-control" id="contactName" placeholder="Введите имя контакта">
                    </div>
                    <div class="input-group">
                        <div>Фамилия:</div>
                        <input type="text" class="form-control" id="contactSecondName"
                               placeholder="Введите фамилию контакта">
                    </div>
                    <div class="input-group">
                        <div>Отчество:</div>
                        <input type="text" class="form-control" id="contactLastName"
                               placeholder="Введите отчество контакта">
                    </div>
                    <div>
                        <div>Город:</div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false" id="buttonCity">
                                Выбор города <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" id="citiesList">
                            </ul>
                        </div>
                    </div>

                    <div class="input-group">
                        <div>Адрес:</div>
                        <input type="text" class="form-control" id="contactAddress"
                               placeholder="Введите адрес контакта">
                    </div>
                </div>
                <div class="phoneContent">

                    <div>Номера телефонов</div>
                    <div id="phoneItems">

                    </div>
                    <div>
                        <a href="#" id="addNewPhoneNumber">Добавить</a>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Отменить</button>
                <button type="button" class="btn btn-primary" id="saveButton">Сохранить</button>
            </div>
        </div>
    </div>
</div>
