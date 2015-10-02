<%@include file="common/Head.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<LINK REL="SHORTCUT ICON" HREF="images/target.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>DevPos List</title>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<p class="h1">Post DevPos.</p> 
	<button type="button" class="btn btn-link"> Post API</button>
	<div class="row" id="api_dev" data-showflag="0" style="display:none;">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-4">
			<textarea class="form-control" id="posData" rows="15" cols="80"></textarea><br>
			<div class="text-center"><button class="btn btn-default" id="postBtn">Post</button></div>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-8">
			
			<dl >
				<dt>Post URL:</dt>
				<dd><pre>http://123.57.73.135/safety/postPos</pre></dd>
				<dt>Parameter key:</dt>
				<dd><pre>devData</pre></dd>
				<dt>Parameter value:</dt>
				<dd><pre><fmt:message key="devPosList.json" bundle="${labelBundle}"/></pre></dd>
				<dt>Parameter value(batch):</dt>
				<dd><pre><fmt:message key="devPosList.jsons" bundle="${labelBundle}"/></pre></dd>
				<dt>Notes:</dt>
				<dd><code><fmt:message key="devPosList.memo" bundle="${labelBundle}"/></code></dd>
				
			</dl>
			<div class="btn-group" role="group" aria-label="...">
				  <button type="button" class="btn btn-success" data-cdsn="10000"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Minute</button>
				  <button type="button" class="btn btn-info" data-cdsn="01000"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Hour</button>
				  <button type="button" class="btn btn-primary" data-cdsn="00100"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Day</button>
				  <button type="button" class="btn btn-warning" data-cdsn="00010"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Month</button>
				  <button type="button" class="btn btn-danger" data-cdsn="00001"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Year</button>
			</div>	
		</div>
		
		
	</div>
	
	<div class="row">
		<p>&nbsp;</p>
	</div>
	
	
	<c:if test="${totalCnt gt 0}">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-left">
			<form class="form-inline" action="queryPos" method="post">
			  <div class="form-group">
			    <label class="sr-only" for="devId">Device ID</label>
			    <div class="input-group">
			      <div class="input-group-addon">Input</div>
			      <input type="text" class="form-control" id="devId" name="devId" placeholder="Device ID" value="<c:out value="${devId }" />">
			      <input type="hidden" name="currentPage" value="1">
			      <div id="queryBtn" class="input-group-addon btn">Query</div>
			    </div>
			  </div>
			  
			</form>
		</div>
		
		<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 text-right">
			<h4>Total:<c:out value="${totalCnt }" />	
			(<c:out value="${(currentPage-1)*15+1 }" />~
			<c:choose>
				<c:when test="${totalCnt gt currentPage*15 }">
					<c:out value="${currentPage*15 }" />
				</c:when>
				<c:otherwise>
					<c:out value="${totalCnt }" />
				</c:otherwise>
			</c:choose>
			)</h4>
		</div>
	</div>
	</c:if>
	
	<div class="row">
		
		<div class="col-xs-12 col-md-12">	
			<nav>
			  <ul class="pager">
			  <c:if test="${currentPage gt 1}">
			    <li class="previous">
			    		<a href="#" data-page="<c:out value="${currentPage-1 }"/>" onclick="pageQuery(this)"><span aria-hidden="true">&larr;</span> Previous</a>
			    	</li>
			  </c:if>
			  
			   <c:if test="${currentPage*15 lt totalCnt}"> 		
			    <li class="next">
			    		<a href="#" data-page="<c:out value="${currentPage+1 }"/>" onclick="pageQuery(this)">Next <span aria-hidden="true">&rarr;</span></a>
			    	</li>
			    	</c:if>
			  </ul>		  
			</nav>
		</div>
	</div>
	
	<div class="row">	
		<div class="col-xs-12 col-md-12">
		<c:if test="${devPosList ne null}">
			 <table class="table table-striped">
			 	<tr>
			 		<td>Device ID</td>
			 		<td>Longitude</td>
			 		<td>Latitude</td>
			 		<td>Speed(km/h)</td>
			 		<td>Bearing</td>
			 		<td>Country Name</td>
			 		<td>Location</td>
			 		<td>Address</td>
			 		<td>GPS DTM</td>
			 		<td>Post DTM</td>
			 	</tr>
			 	<c:forEach var="devpos" items="${devPosList}">
			 	<tr class="warning">
			 		<td><c:out value="${devpos.devId }" /></td>
			 		<td><c:out value="${devpos.lon }" /></td>
			 		<td><c:out value="${devpos.lat }" /></td>
			 		<td><c:out value="${devpos.spd*3.6 }" /></td>
			 		<td><c:out value="${devpos.bear }" /></td>
			 		<td><c:out value="${devpos.cn }" /></td>
			 		<td><c:out value="${devpos.loc }" /></td>
			 		<td><c:out value="${devpos.addr }" /></td>
			 		<td><c:out value="${devpos.dtm }" /></td>
			 		<c:choose>
				 		<c:when test="${devpos.regDate ne null}">
				 			<td><c:out value="${devpos.idDate }" /></td>
				 		</c:when>
				 		<c:otherwise>
				 			<td><c:out value="${devpos.idDate }" /></td>
				 		</c:otherwise>
			 		</c:choose>
			 	</tr>
			 	</c:forEach>
			 </table>
			 </c:if>
		</div>
	</div>
	你好
	<div class="row">
		<div class="col-xs-12 col-md-12">	
			<nav>
			  <ul class="pager">
			  <c:if test="${currentPage gt 1}">
			    <li class="previous">
			    		<a href="#" data-page="<c:out value="${currentPage-1 }"/>" onclick="pageQuery(this)"><span aria-hidden="true">&larr;</span> Previous</a>
			    	</li>
			  </c:if>
			  
			   <c:if test="${currentPage*15 lt totalCnt}"> 		
			    <li class="next">
			    		<a href="#" data-page="<c:out value="${currentPage+1 }"/>" onclick="pageQuery(this)">Next <span aria-hidden="true">&rarr;</span></a>
			    	</li>
			    	</c:if>
			  </ul>		  
			</nav>
		</div>
	</div>
	
</div>


<script>
$(document).ready(function(){
	
	$("#api_dev").hide();
	
	$(".btn-link").click(function(){
		var flag = $("#api_dev").attr("data-showflag");
		if(flag == "0"){
			$("#api_dev").show();
			$("#api_dev").attr("data-showflag","1");
		}else{
			$("#api_dev").hide();
			$("#api_dev").attr("data-showflag","0");
		}
		
	});
	
    $("#postBtn").click(function(){
    		var posDatas = $.trim($("#posData").val());
    		if(posDatas != ""){
    			$.ajax({url:"postPos",
    				type:"post",
    				data:{devData:posDatas},
    				dataType:"text",
    				success:function(result){
    					alert("Post Success,Post count is "+result+"!");
    					window.location.href = "queryPos";
    				},
    				error:function(result){
    					alert("There are some exceptions on the server.");
    				}
    			});
    		}
    });
    
    $(".btn-group").delegate("button","click",function(){
    		if(confirm("Deleting Records.Are you sure?")){
    			var cdsnStr = $(this).attr("data-cdsn");
	    	    	$.ajax({url:"removePos",
	    				type:"post",
	    				data:{cdsn:cdsnStr},
	    				dataType:"text",
	    				success:function(result){
	    					alert("Remove Success,Remove count is "+result+"!");
	    					window.location.href = "queryPos";
	    				},
	    				error:function(result){
	    					alert("There are some exceptions on the server.");
	    				}
	    			});
    		}
    });
    
    $("#queryBtn").click(function(){
    		var form = $("form")[0];
    		form.submit();
    });
    
});

var pageQuery = function(obj){
	var form = $("form")[0];
	form.currentPage.value = obj.getAttribute("data-page");
	form.submit();
};

</script>

</body>
</html>