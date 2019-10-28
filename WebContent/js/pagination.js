/**
 * 分页方法实现
 */
function Pagination(){
	
	var currentPage=1,totalRows=0,pageSize=50,totalPages=0;
	
	var buildPage = function(id){
		
		var $page = $("#"+id);
		currentPage = $page.data("currentpage");
		totalRows = $page.data("totalrows");
		pageSize = $page.data("pagesize");
		formName = $page.data("form");
		
		if(totalRows%pageSize != 0){
			
			totalPages = parseInt(totalRows/pageSize)+1;
		}
		else{
			totalPages = parseInt(totalRows/pageSize);
		}		
		
	    var pageboot = "<div class=\"row-fluid\">\n";

	    if (totalPages == 0)
	      pageboot = pageboot + "<div class=\"span4\"><div class=\"dataTables_info\">第0页，总共0页</div></div>";
	    else {
	      pageboot = pageboot + "<div class=\"span4\"><div class=\"dataTables_info\">第" + currentPage + "页，总共" + totalPages + "页</div></div>";
	    }
	    
	    pageboot = pageboot + "<div class=\"span8\">\n总共" + totalRows + "条，每页<select name=\"pageSize\" id=\"pageSize\" onChange=\"document.getElementById('pageSize').value=this.value;submitProxy('no')\" class=\"input-mini\">" + 
	      "<option value=\"10\" " + isSelected(10) + ">10</option>" + 
	      "<option value=\"20\" " + isSelected(20) + ">20</option>" + 
	      "<option value=\"30\" " + isSelected(30) + ">30</option>" + 
	      "<option value=\"40\" " + isSelected(40) + ">40</option>" + 
	      "<option value=\"50\" " + isSelected(50) + ">50</option>" + 
	      "</select>条\n";

	    pageboot = pageboot + "<div class=\"dataTables_paginate paging_bootstrap pagination\" ><ul>";

	    pageboot = pageboot + "<li>" + outStringMethod(1) + "</li>" + 
	      "<li>" + outStringMethod(2) + "</li>" + 
	      showNumber_boot() + 
	      "<li>" + outStringMethod(3) + "</li>" + 
	      "<li>" + outStringMethod(4) + "</li>";

	    pageboot = pageboot + "</ul></div></div>";

	    pageboot = pageboot + "<input type=\"hidden\" value=\"" + pageSize + "\" id=\"pageSize\"/>\n" + 
	      "<input type=\"hidden\" value=\"" + totalRows + "\" id=\"totalRows\"/>\n" + 
	      "<input type=\"hidden\" value=\"" + totalPages + "\" id=\"totalPages\"/>\n" + 
	      "<input type=\"hidden\" id=\"currentPage1\" value=\"" + currentPage + "\"/>\n" + 
	      "<input type=\"hidden\" id=\"currentPage\" value=\"" + currentPage + "\"/>\n";

	    pageboot = pageboot + "</div>";
	    $("#"+id).html(pageboot);
	};
	
	var isSelected = function(i) {
		
	    if (pageSize == i) {
	      return "selected";
	    }
	    return "";
	};
	
	var outStringMethod = function(i) {
		switch (i)
	    {
	    case 1:
	      if (currentPage == 1) {
	        return "<span style='color:#999;'>首页</span>\n";
	      }
	      return "<a href=javascript:submitProxy('first')>首页</a>\n";
	    case 2:
	      if (currentPage == 1) {
	        return "<span style='color:#999;'>上一页</span>\n";
	      }
	      return "<a href=javascript:submitProxy('previous')>上一页</a>\n";
	    case 3:
	      if (currentPage == totalPages || totalPages <= 1) {
	        return "<span style='color:#999;'>下一页</span>\n";
	      }
	      return "<a href=javascript:submitProxy('next')>下一页</a>\n";
	    case 4:
	      if (currentPage == totalPages || totalPages <= 1) {
	        return "<span style='color:#999;'>尾页</span>\n";
	      }
	      return "<a href=javascript:submitProxy('last')>尾页</a>\n";
	    }

	    return "";
	};
	
	var showNumber_boot = function()
	{
	    var showNumber = "";
	    var num = 5;
	    if (totalPages <= num) {
	    	
	      for (var i = 1; i <= totalPages; ++i)
	      {
	        if (currentPage == i){
	        	showNumber = showNumber + "<li class=\"active\"><a href=\"#\" onclick=\"getPageNum(this)\" >" + i + "</a></li>";
	        }
	        else
	          showNumber = showNumber + "<li><a href=\"#\" onclick=\"getPageNum(this)\" >" + i + "</a></li>";
	      }
	    }
	    else
	    {
	      var leftnum = parseInt((num - 1) / 2);
	      var rightnum = parseInt((num - 1) / 2);

	      if (totalPages - currentPage < leftnum)
	      {
	        rightnum += leftnum - totalPages + currentPage;
	        leftnum -= leftnum - totalPages + currentPage;
	      }
	      if (currentPage < rightnum) {
	        leftnum = leftnum + rightnum - currentPage + 1;
	      }

	      for (var i = 0; i < rightnum; ++i) {
	        if (currentPage - rightnum + i > 0)
	          showNumber = showNumber + "<li><a href=\"#\" onclick=\"getPageNum(this)\">" + (currentPage - rightnum + i) + "</a></li>";
	      }
	      showNumber = showNumber + "<li class=\"active\" ><a href=\"#\" onclick=\"getPageNum(this)\" >" + currentPage + "</a></li>";
	      for (var j = 0; j < leftnum; ++j)
	      {
	        showNumber = showNumber + "<li><a href=\"#\" onclick=\"getPageNum(this)\">" + (currentPage + j + 1) + "</a></li>";
	      }
	    }
	    return showNumber;
	};
	
	this.init = function(id){
		
		buildPage(id);
	};
}

var totalRows=null;
var currentPage=null;
var totalPages=null;
var startRow=null;
var pageSize=null;
var endRow=null;
var formName=null;
function pageCheckNumber(str){
	if(str==null||str==''){
		return false;
	}
	var Number = "0123456789";
	for (var i = 0; i < str.length;i++)
	{
		var c = str.charAt(i);
		if (Number.indexOf(c) == -1) return false;
	}
	return true;
}
function getPageNum(obj){
	document.getElementById("currentPage").value = obj.innerHTML;
	submitProxy('gotoPage');
}
function submitProxy(pagerMethod){
	if(pagerMethod=="gotoPage"){
		var _currentPage=document.getElementById("currentPage").value;
		currentPage=_currentPage;
		var _totalPages=document.getElementById("totalPages").value;
		if(pageCheckNumber(_currentPage)){
			if(parseInt(_currentPage)>parseInt(_totalPages)||parseInt(_currentPage)<=0){
				alert("没有该页！");
				return ;
			}
		}else{
			alert("请输入正整数！");
			return ;
		}
	}else{
		currentPage=document.getElementById("currentPage1").value;
	}

	totalRows=document.getElementById("totalRows").value;
	totalPages=document.getElementById("totalPages").value;
	pageSize=document.getElementById("pageSize").value;
	var submitForm=document.getElementById(formName);//////////////formname
	counterStart(pagerMethod);
	var page_totalRows=document.createElement("input");
	page_totalRows.setAttribute("type","hidden");
	page_totalRows.setAttribute("name","totalRows");
	page_totalRows.setAttribute("id","totalRows");
	page_totalRows.setAttribute("value",totalRows);
	var page_totalPages=document.createElement("input");
	page_totalPages.setAttribute("type","hidden");
	page_totalPages.setAttribute("name","totalPages");
	page_totalPages.setAttribute("id","totalPages");
	page_totalPages.setAttribute("value",totalPages);
	var page_startRow=document.createElement("input");
	page_startRow.setAttribute("type","hidden");
	page_startRow.setAttribute("name","startRow");
	page_startRow.setAttribute("id","startRow");
	page_startRow.setAttribute("value",startRow);
	var page_endRow=document.createElement("input");
	page_endRow.setAttribute("type","hidden");
	page_endRow.setAttribute("name","endRow");
	page_endRow.setAttribute("id","endRow");
	page_endRow.setAttribute("value",endRow);
	var page_currentPage=document.createElement("input");
	page_currentPage.setAttribute("type","hidden");
	page_currentPage.setAttribute("name","currentPage");
	page_currentPage.setAttribute("id","currentPage");
	page_currentPage.setAttribute("value",currentPage);
	var page_pageSize=document.createElement("input");
	page_pageSize.setAttribute("type","hidden");
	page_pageSize.setAttribute("name","pageSize");
	page_pageSize.setAttribute("id","pageSize");
	page_pageSize.setAttribute("value",pageSize);
	submitForm.appendChild(page_totalRows);
	submitForm.appendChild(page_totalPages);
	submitForm.appendChild(page_startRow);
	submitForm.appendChild(page_endRow);
	submitForm.appendChild(page_currentPage);
	submitForm.appendChild(page_pageSize);
	$(submitForm).submit();
}
function first() {
	currentPage = 1;
	startRow = (currentPage - 1) * pageSize;
	endRow = pageSize;
}
function previous() {
if (currentPage <= 1) {
	currentPage = 1;
	startRow = 0;
    return;
}
currentPage--;
startRow = (currentPage - 1) * pageSize;
endRow = pageSize;
}
function next() {
	if (parseInt(currentPage) < parseInt(totalPages)) {
    currentPage++;
	}else{
		currentPage=totalPages;
	}
	startRow = (currentPage - 1) * pageSize;
	endRow = pageSize;
}

function last() {
	currentPage = totalPages;
	startRow = (currentPage - 1) * pageSize;
	endRow = pageSize;
}
function no() {
	currentPage=1;
	startRow = (currentPage - 1) * pageSize;
	endRow = pageSize;
}
function gotoPage(number) {
	startRow = (currentPage - 1) * pageSize;
	endRow = pageSize;
}
function counterStart(pagerMethod){
	if (pagerMethod != null) {
		if (pagerMethod=="first") {
			first();
		} else if (pagerMethod=="previous") {
			previous();
		} else if (pagerMethod=="next") {
		next();
		} else if (pagerMethod=="last") {
			last();
		}else if (pagerMethod=="no") {
			no();
		}else if (pagerMethod=="gotoPage"){
			gotoPage();
		}
	}else{
		first();
	}
};

