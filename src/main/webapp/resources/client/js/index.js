$(document).ready(function () {

    getContacts();


});

function getContacts() {
    $.ajax({
        dataType: "json",
        url: "/getContacts",
        data: []
    }).done(function (data) {
        var result = "";
        $.each(data, function (index, contact) {

            var contactBody = "<div>" +
                "<div class='adressShortInfo'>" +
                "<div>Город: " + contact.city.name + "</div>" +
                "<div>Адрес: " + contact.address + "</div>" +
                "</div>" +
                "<div class='phones'>" +
                "</div>" +
            "</div>";

            var element = "     <div class='panel panel-default'> " +
                "         <div class='panel-heading' role='tab' id='headingContact" + contact.id + "'> " +
                "             <h4 class='panel-title contactTitle'> " +
                "                 <a role='button' data-toggle='collapse' data-parent='#accordion' href='#collapseContact" +
                contact.id + "' aria-expanded='true' aria-controls='collapseContact" + contact.id + "'> " +
                "                     ФИО:  " + contact.firstName + " " + contact.secondName + " " + contact.middleName +
                " ()" +
                "                 </a> " +
                "             </h4> " +
                "<div class='contactControl'>" +
                "<div class='glyphicon glyphicon-pencil editContact' idContact='" + contact.id + "'></div>" +
                " <div class='glyphicon glyphicon-remove removeContact' idContact='" + contact.id + "'></div>" +
                "</div>" +
                "         </div> " +
                "         <div id='collapseContact" + contact.id +
                "' class='panel-collapse collapse in' role='tabpanel' aria-labelledby='headingContact" + contact.id + "'> " +
                "             <div class='panel-body'> " +
                contactBody +
                "             </div> " +
                "         </div> " +
                "     </div> ";

            result += element;
        });
        var resultGrid = $(".resultGrid").find("#accordion");
        resultGrid.empty();
        resultGrid.append(result);
        setBindings();
    });
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

    });
}

