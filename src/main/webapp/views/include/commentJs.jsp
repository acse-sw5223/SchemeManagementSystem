<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript">
	$.validator.setDefaults({
	    submitHandler: function() {
	      var content = $("#commentContent").val();
	      var tableId = $("#tableId").val();
	      var tableName = $("#tableName").val();
	      var entity = {
	    		  commentContent:  content,
	    		  tableName:tableName,
	    		  tableId:tableId
	    		  
	      }
	      save(entity);
	    }
	});
	$(document).ready(function() {
		$("#submitForm").validate({
			rules : {
				commentContent: {
					required : true
				},
			},
			messages : {
				commentContent: {
					required : "评论内容必填"
				},
			}
		})
	});
	
	function save(entity) {
		$.ajax({
			type : 'post',
			async : false,
			url :"${adminPath}/userCommentInfo?method=add",
			data : JSON.stringify(entity),
			dataType : "json",
			contentType : "application/json",
			success : function(data) {
				if (data == '1') {
					alert("评论成功!");
				} else {
					alert("评论失败!");
				}
			}
		});
	}
	
</script>