<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>true" %>
<!-- alerts -->
<div class="modal-body" style="padding:0px">
<div class="alert alert-{{data.mode}}" style="margin-bottom:0px">
    <button type="button" class="close" data-ng-click="close()">
            <span class="glyphicon glyphicon-remove-circle"></span>
        </button>
    <strong>{{data.boldTextTitle}}</strong> {{data.textAlert}}
</div>
</div>