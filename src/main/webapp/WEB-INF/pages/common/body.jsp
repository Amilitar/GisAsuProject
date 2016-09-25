<%--
  Created by IntelliJ IDEA.
  User: nikpodrivnik
  Date: 25/09/16
  Time: 00:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="cp1251"%>
<%@ page language="java" contentType="text/html;charset=cp1251"%>
<div>
    <div class="searchbar">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Введите ФИО или номер телефона">
        </div>
        <button type="submit" class="btn btn-default">Найти</button>
    </div>

    <div class="resultGrid">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Collapsible Group Item #1
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body">

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>