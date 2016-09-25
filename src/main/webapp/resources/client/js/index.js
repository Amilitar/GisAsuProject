$(document).ready(function () {
    getContacts();
    fillCitiesList();
    loadPhoneTypes();
    createAddNewButton();


    $("#addNewPhoneNumber").click(function () {
        $("#phoneItems").append(getPhoneHtml());
        $(".phoneTypeSelect").click(function () {
            setButtonPhoneTypeText($(this));
        });
    });

    $("#saveButton").click(function () {
        selectedContact.firstName = $("#contactName").val();
        selectedContact.secondName = $("#contactSecondName").val();
        selectedContact.middleName = $("#contactLastName").val();
        selectedContact.address = $("#contactAddress").val();

        var buttonCity = $("#buttonCity");
        var city = {};

        city.id = buttonCity.attr("idCity");
        city.name = buttonCity.text();
        selectedContact.city = city;
        selectedContact.phones = [];
        $(".phoneInput").each(function () {
            var sender = $(this).find(".form-control");
            var phone = {};
            phone.id = sender.attr("phoneId");
            phone.number = sender.val();
            phone.idContact = selectedContact.id;
            phone.isMain = sender.attr("isMain");
            var phoneType = {};
            phoneType.id = sender.attr("phoneTypeId");
            phoneType.name = sender.attr("phoneTypeName");
            phone.phoneType = phoneType;

            selectedContact.phones.push(phone);
        });

        saveContact(selectedContact);
        closeDialog();
        var changeContact = $("#contactItemListId" + selectedContact.id);
        changeContact.empty();
        changeContact.append(getContactHtmlItem(selectedContact));
        setBindings();
    });
});

var phoneTypes = "";
var phoneTypeList = [];

var globalContacts = [];
var selectedContact = {};

function createAddNewButton() {
    $(".createNewContact").click(function () {
        var contact = [];
        showAddDialog(contact);
    });
}

function saveContact(contact) {
    $.ajax({
        url: "/saveContact",
        data: encodeURIComponent(JSON.stringify(contact)),
        type: "POST",
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
            xhr.setRequestHeader("Content-Type", "application/json", "charset=cp1251");
        },
        success: function (smartphone) {
            alert("Сохранил2");
        }
    }).done(function () {
        alert("Сохранил");
    });
    if (selectedContact.id == 0){
        getContacts();
    }
}

function loadPhoneTypes() {
    $.ajax({
        dataType: "json",
        url: "/getPhoneTypes"
    }).done(function (data) {
        phoneTypeList = data;
        $.each(data, function (index, value) {
            phoneTypes += "<li><a href='#' class='phoneTypeSelect' idPhoneType='" + value.id + "'>" + value.name + "</a></li>";
        });
    });
}

function fillCitiesList() {
    var citiesList = "";
    var citiesListController = $("#citiesList");
    $.ajax({
        dataType: "json",
        url: "/getCities"
    }).done(function (data) {
        $.each(data, function (index, value) {
            citiesList += "<li><a href='#' class='citySelect' idCity='" + value.id + "'>" + value.name + "</a></li>";
        });
        citiesListController.empty();
        citiesListController.append(citiesList);

        $(".citySelect").click(function () {
            setButtonCityText($(this).text(), $(this).attr("idCity"));
        });
    });


}

function setButtonCityText(text, id) {
    var buttonCity = $("#buttonCity");
    buttonCity.attr("idCity", id);
    buttonCity.text(text);
    buttonCity.append("<span class='caret'></span>");
}

function setButtonPhoneTypeText(sender) {
    var buttonPhoneType = sender.parent().parent().parent().find(".phoneTypeSelectButton");
    var linkedElement = sender.parent().parent().parent().parent().find(".phoneInput").find(".form-control");
    var id = sender.attr("idPhoneType");
    var text = sender.text();
    buttonPhoneType.attr("idPhoneType", id);
    buttonPhoneType.text(text);
    buttonPhoneType.append("<span class='caret'></span>");

    linkedElement.attr("phoneTypeId", id);
    linkedElement.attr("phoneTypeName", text);
}

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

function getContactsByFilter(filterString) {
    $.ajax({
        dataType: "json",
        url: "/getContactsByFilter/" + filterString
    }).done(function (data) {
        createContactList(data);
    });
}

//построение списка контактов
function createContactList(contacts) {
    globalContacts = contacts;
    var result = "";
    $.each(contacts, function (index, contact) {
        result += "<div id='contactItemListId" + contact.id + "'>" + getContactHtmlItem(contact) + "</div>";
    });
    var resultGrid = $(".resultGrid").find("#accordion");
    resultGrid.empty();
    resultGrid.append(result);
    setBindings();
}

//получение первого или основного номера телефона
function getMainPhoneOrFirst(phones) {
    var mainPhoneNumber = phones[0] == undefined ? "Список номеров пуст" : phones[0].number;
    $.each(phones, function (index, phone) {
        if (phone.isMain == true) {
            mainPhoneNumber = phone.number;
        }
    });
    return mainPhoneNumber;
}

function getContactHtmlItem(contact) {
    var element = "   <div class='panel panel-default'> " +
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
function getContactBody(contact) {
    var address = contact.address == null ? "Не заполнен" : contact.address;

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
function preparePhonesHtml(phones) {
    var result = "";
    $.each(phones, function (index, phone) {
        result += "<div id='contactPhone" + phone.id + "'>" + phone.number + "(" + phone.phoneType.name + ") </div>"

    });
    return result;
}

//подключает все связки управления
function setBindings() {
    $(".removeContact").click(function () {
        var idContact = $(this).attr("idContact");
        $.ajax({
            url: "/deleteContact/" + idContact,
            type: "DELETE"
        }).done(function () {
            alert("Удален");
        });
    });
    $(".editContact").click(function () {
        showEditDialog(findContactById($(this).attr("idContact")));
    });
}

//диалог для создания нового контакта
function showAddDialog(contact) {
    clearDialog();
    $("#saveEditLabel").text("Создание нового контакта ");
    showDialog();
}

//диалог для редактирования контакта
function showEditDialog(contact) {
    clearDialog();
    setupDialog(contact);
    selectedContact = contact;
    $("#saveEditLabel").text("Редактирование " + contact.firstName + contact.secondName + contact.middleName);
    showDialog();

}

function showDialog() {
    $("#saveEditDialog").modal("show");
}

function closeDialog() {
    $("#saveEditDialog").modal("hide");
}

function setupDialog(contact) {
    $("#contactName").val(contact.firstName);
    $("#contactSecondName").val(contact.secondName);
    $("#contactLastName").val(contact.middleName);
    $("#contactAddress").val(contact.address);

    setButtonCityText(contact.city.name, contact.city.id);

    $("#phoneItems").append(preparePhonesForDialogHtml(contact.phones));
    $(".phoneTypeSelect").click(function () {
        setButtonPhoneTypeText($(this));
    });

}

//подготавливает внешний вид для номеров телефонов диалога
function preparePhonesForDialogHtml(phones) {
    var result = "";
    $.each(phones, function (index, phone) {
        result += getPhoneHtml(phone);

    });
    return result;
}

function getPhoneHtml(phone) {
    var id = phone == undefined ? "0" : phone.id;
    var isMain = phone == undefined ? "false" : phone.isMain;
    var number = phone == undefined ? "" : phone.number;
    var phoneTypeId = phone == undefined ? phoneTypeList[0].id : phone.phoneType.id;
    var phoneTypeName = phone == undefined ? phoneTypeList[0].name : phone.phoneType.name;

    return "<div>" +
        "<div class='input-group phoneInput'> " +
        "                            <input type='text' class='form-control' " +
        " phoneId='" + id + "' phoneTypeId='" + phoneTypeId +
        "' phoneTypeName='" + phoneTypeName + "' isMain='" + isMain + "' id='phoneNumberId" + id +
        "' placeholder='Введите номер контакта' value='" + number + "'> " +
        "                        </div> " +
        "                        <div class='btn-group'> " +
        "                            <button type='button' class='btn btn-default dropdown-toggle phoneTypeSelectButton' data-toggle='dropdown' " +
        "                                    aria-haspopup='true' aria-expanded='false'> " +
        "                                " + phoneTypeName + " <span class='caret'></span> " +
        "                            </button> " +
        "                            <ul class='dropdown-menu'> " + phoneTypes +
        "                            </ul> " +
        "                        </div> " +
        "</div>";

}

function clearDialog() {
    $("#contactName").val("");
    $("#contactSecondName").val("");
    $("#contactLastName").val("");
    $("#contactAddress").val("");

    setButtonCityText("Выбор города", null);

    $("#phoneItems").empty();
}

function findContactById(id) {
    var contact = [];
    $.each(globalContacts, function (index, value) {
        if (value.id == id) {
            contact = value;
        }
    })
    return contact;
}

