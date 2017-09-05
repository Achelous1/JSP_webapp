<h1>추천 여행지</h1>
<div class="form-group" style="margin-top:50px; padding-left: 60%;">
	<select class="form-control" name="search_type" ng-model="search_type" style="width:150px; float:left; height: 30px;" placeholder="검색 유형">
	   <option style="font-size: 16px;" value="title" selected>제목 검색</option>
	   <option value="content">내용 검색</option>
   </select>
	
 <div class="input-group-btn">
	 <input class="form-control" type="text" name="searchStr" ng-model="searchStr" placeholder="검색할 문맥" style="width:250px; float:left; height:30px;">
	 <a id="searchBtn" href="#!/search.bctrl?page=index.html#!/reviews.bctrl&search_type={{ search_type }}&searchStr={{ searchStr }}" class="btn btn-info" style="height: 30px;">
		 <i class="glyphicon glyphicon-search"></i>
	 </a>
	 <a href="#!/boardWrite" class="btn btn-success" style="height:30px;">	<span class="glyphicon glyphicon-pencil"></span></a>
   </div>
</div>