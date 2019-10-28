//绑定classe为thick的a标签
$(document).ready(function(){   
	newthickBox_init('a.thickbox,button.thickbox');

	$(".datetime").click(function(){
		WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});
	});
	
	$(".date").click(function(){
		WdatePicker();
	});
	$("select[id!='pageSize']").not('.noselect').select2();
	//绑定分页
	var page = new Pagination();
	page.init("pagediv");
	
	//单个删除提示
	$(".removebtn").click(function(){
		
		var url = $(this).data("url");
		layer.confirm('您确认删除吗？', {
		    btn: ['确认','取消'] //按钮
		}, function(){
			window.location.href=url;
		}, function(){
		    
		});
	});
	
	//菜单选中处理
	$("#nav-menu a").click(function(){

		var href = $(this).attr("href");
		if(href != "#"){
			$.cookie('nav-menu', $(this).attr("href"), { expires: 1, path: '/' });
		}
	});
	
	$("#nav-menu li").removeClass("active");
	
	if($.cookie('nav-menu') != null){
		
		var activehref = $.cookie('nav-menu');
		
		var a = $('a[href$="'+activehref+'"]:first');
		
		
		a.parents('li').each(function(index){
			if(index == 1){
				$(this).addClass("active open");
			}
			else{
				$(this).addClass("active");
			}
		});
	}
	
	//数据表排序处理
	$(".dataTable th").click(function(){

		if (typeof($(this).attr("class")) != "undefined") { 
			
			$("#sortingName").val($(this).data("value"));
			
			if($(this).attr("class") == "sorting" || $(this).attr("class") == "sorting_asc"){
				$("#sortingType").val("desc");
			}
			else{
				$("#sortingType").val("asc");
			}
			
			$(this).closest("form").submit();
		}
		else{
			$("#sortingName").val("");
			$("#sortingType").val("");
			$(this).closest("form").submit();
		}
	});
	
	$(".dataTable th").each(function(){

		var sortingName = $("#sortingName").val();
		var sortingType = $("#sortingType").val();
			
		if (typeof($(this).attr("class")) != "undefined" && sortingName == $(this).data("value")) { 
			
			$(this).attr("class","sorting_"+sortingType);
			return;
		}
		
	});

});

//------------------新版模态窗口--------------------------------
//初始化模态
function newthickBox_init(domChunk){
	
	//绑定单击事件
	$(domChunk).on("click",function(){

		//初始参数
		var height = $(window.top).height()*0.7;
		var width = $(window.top).width()*0.7;
		
	    var url = this.href || $(this).data("href");

	    //解析url获取参数
	    if(url.indexOf("?") != 0){
	    	var parStr = url.substring(url.indexOf("?")+1);
	    	var pars = parStr.split("&");
	
	    	for ( var i = 0; i < pars.length; i++) {
	
	    		var par = pars[i];
	    		//控制层宽
					if(par.split("=")[0] == "height"){
						height = par.split("=")[1];
					}
					//控制层高
					if(par.split("=")[0] == "width"){
						width = par.split("=")[1];
					}
				}
	    }
	    
	    layer.open({
	        type: 2,
	        title: false,
	        closeBtn: true,
	        shadeClose: false,
		    shade: 0.8,
	        area: [width+"px", height+"px"],
	        shift: 2,
	        content: [url], //iframe的url，no代表不显示滚动条
	        end: function(){ //此处用于演示
	            
	        }
	    });
	    
		this.blur();
		return false;
	});
}
//自定义移除模态方法
function tb_remove(){
	for(var i=0;i<10;i++){
		shadeNow = $('#xubox_shade'+i,window.top.document);
		layerNow = $('#xubox_layer'+i,window.top.document);
		shadeNow.remove();
		layerNow.remove();
	}
}

//自定义隐藏模态方法
function tb_close(index){
	
	var layerNow = $('#xubox_layer' + index,window.top.document), shadeNow = $('#xubox_shade' + index,window.top.document);
	//if(layerNow.attr('type') == this.type()[1]){
		layerNow.find('.xubox_close,.xubox_botton,.xubox_title,.xubox_border').remove();
		for(var i = 0 ; i < 3 ; i++){
			layerNow.find('.layer_pageContent').unwrap().hide();
		}
	//}else{
		$.browser.msie && layerNow.find('#xubox_iframe').remove();
		layerNow.remove();
	//}
	shadeNow.remove();
	try{
		ready.global.iE6 && this.reselect();
		ready.global.config[index].end();
		ready.global.times--;
		delete ready.global.config[index];
	}catch(e){}

}

//重置页面
function clearForm(formName) {
	
	var formObj = document.getElementById(formName);

	var formEl = formObj.elements;
	for (var i=0; i<formEl.length; i++){
		var element = formEl[i];
		if (element.type == 'submit') { continue; }
		if (element.type == 'reset') { continue; }
		if (element.type == 'button') { continue; }
		if (element.type == 'hidden') { continue; }
		if (element.type == 'text'&& element.id!='currentPage') { element.value = '';  }
		if (element.type == 'password') { element.value = ''; }
		if (element.type == 'textarea') { element.value = ''; }
		if (element.type == 'checkbox') { element.checked = false;  }
		if (element.type == 'select-multiple') { element.selectedIndex = 0; }
		if (element.type == 'select-one'&& element.id!='pageSize') { element.selectedIndex = 0; }
	}
	$("select[id!='pageSize']").val("-1").trigger("change");
} 

//------------------新版模态窗口end-----------------------------


