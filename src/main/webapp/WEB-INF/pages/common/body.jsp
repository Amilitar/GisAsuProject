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
            <input type="text" class="form-control" placeholder="������� ��� ��� ����� ��������">
        </div>
        <div class="searchButton">
            <button type="submit" class="btn btn-default ">�����</button>
        </div>

    </div>

    <div class="resultGrid">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">


        </div>
    </div>
</div>

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
                        <div>���:</div>
                        <input type="text" class="form-control" placeholder="������� ��� ��������">
                    </div>
                    <div class="input-group">
                        <div>�������:</div>
                        <input type="text" class="form-control" placeholder="������� ������� ��������">
                    </div>
                    <div class="input-group">
                        <div>��������:</div>
                        <input type="text" class="form-control" placeholder="������� �������� ��������">
                    </div>
                    <div>
                        <div>�����:</div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                ����� ������ <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="input-group">
                        <div>�����:</div>
                        <input type="text" class="form-control" placeholder="������� ����� ��������">
                    </div>
                </div>
                <div class="phoneContent">
                    <div class="input-group">
                        <div>��������:</div>
                        <input type="text" class="form-control" placeholder="������� �������� ��������">
                    </div>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            ����� ������ <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </div>
                    <div>
                        <a href="#">��������</a>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">��������</button>
                <button type="button" class="btn btn-primary">���������</button>
            </div>
        </div>
    </div>
</div>