﻿$(document).ready(function () {
    getContacts();
});

//Список всех контактов
function getContacts() {
    $.ajax({
        dataType: "json",
        url: "/getContacts",
        data: []
    }).done(function (data) {
        createContactList(data);
    });
}

function getContactsByFilter(filterString){
        $.ajax({
            dataType: "json",
            url: "/getContactsByFilter/" + filterString
        }).done(function (data) {
            createContactList(data);
        });
}

//построение списка контактов
function createContactList(contacts){
    var result = "";
    $.each(contacts, function (index, contact) {
        result += getContactHtmlItem(contact);
    });
    var resultGrid = $(".resultGrid").find("#accordion");
    resultGrid.empty();
    resultGrid.append(result);
    setBindings();
}

//получение первого или основного номера телефона
function getMainPhoneOrFirst(phones){
    var mainPhoneNumber = phones[0] == undefined ? "Список номеров пуст" : phones[0].number;
    $.each(phones, function (index, phone) {
        if (phone.isMain == true){
            mainPhoneNumber = phone.number;
        }
    });
    return mainPhoneNumber;
}

function getContactHtmlItem(contact){
    var element = "     <div class='panel panel-default'> " +
        "         <div class='panel-heading' role='tab' id='headingContact" + contact.id + "'> " +
        "             <h4 class='panel-title contactTitle'> " +
        "                 <a role='button' data-toggle='collapse' data-parent='#accordion' href='#collapseContact" +
        contact.id + "' aria-expanded='false' aria-controls='collapseContact" + contact.id + "'> " +
        "                     ФИО:  " + contact.firstName + " " + contact.secondName + " " + contact.middleName +
        " (" + getMainPhoneOrFirst(contact.phones) + ")" +
        "                 </a> " +
        "             </h4> " +
        "<div class='contactControl'>" +
        "<div class='glyphicon glyphicon-pencil editContact' idContact='" + contact.id + "'></div>" +
        " <div class='glyphicon glyphicon-remove removeContact' idContact='" + contact.id + "'></div>" +
        "</div>" +
        "         </div> " +
        "         <div id='collapseContact" + contact.id +
        "' class='panel-collapse collapse' role='tabpanel' aria-labelledby='headingContact" + contact.id + "'> " +
        "             <div class='panel-body'> " +
        getContactBody(contact) +
        "             </div> " +
        "         </div> " +
        "     </div> ";

    return element;
}

//подготовка тела контакта
function getContactBody(contact){
    var address= contact.address == null ? "Не заполнен": contact.address;

    var contactBody = "<div>" +
        "<div class='adressShortInfo'>" +
        "<div>Город: " + contact.city.name + "</div>" +
        "<div>Адрес: " + address + "</div>" +
        "</div>" +
        "<div class='phones'>" +
        preparePhonesHtml(contact.phones) +
        "</div>" +
        "</div>";
    return contactBody;
}

//подготавливает внешний вид для номеров телефонов
function preparePhonesHtml(phones){
    var result = "";
    $.each(phones, function (index, phone) {
        result += "<div id='contactPhone" + phone.id + "'>" + phone.number + "(" + phone.phoneType.name + ") </div>"

    });
    return result;
}

//подключает все связки управления
function setBindings(){
    $(".removeContact").click(function(){
        var idContact = $(this).attr("idContact");
        $.ajax({
            url: "/deleteContact/" + idContact,
            type: "DELETE"
        }).done(function () {
            alert("Удален");
        });
    });
    $(".editContact").click(function(){
        $("#saveEditDialog").modal("show");
    });
}

