<#assign menu="articleLink">
<#assign submenu="add_articleLink">
<#include "/manage/head.ftl">
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="add_articleLink_form" class="form-horizontal" action="${BASE_PATH}/manage/articleLink/add.json"  method="post" autocomplete="off">
		<div class="row">
			<input type="hidden" name="id">
			<input type="hidden" name="type">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						增加文章
					</header>
					<div class="panel-body">
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">文章标题</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="title"
                              	placeholder="文章标题" id="title" >
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">作者</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="author"
                              	placeholder="作者" id="author" >
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">地址</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="path"
                              	placeholder="地址" id="path" >
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">所属</label>
                          <div class="col-sm-10">
                              <select class="form-control" name="articleId" style="font-size:15px;width: 300px;">
                              		<option value="0">专业著作</option>
			                   		<#list articleAll as article>
			                        	<option value="${article.articleId}" <#if article.articleId==articleId>selected</#if>>
			                        	${article.title}
			                        	</option>
			                        </#list>							
	                            </select>			
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">发布时间</label>
                          <div class="col-sm-10">
                              <input type="text" data-link-format="yyyy-MM-dd" data-date-format="yyyy-MM-dd" style="font-size:15px;width: 200px;" class="js_create_time" name="createTime"
                              	placeholder="发布时间" id="createTime" value="${.now?string("yyyy-MM-dd")}">
                              </input>
                          </div>
                        </div> 
                        <div class="form-group">
                      	  <div class="col-lg-offset-2 col-lg-10">
                          <button class="btn btn-shadow btn-primary" type="submit">发布</button>
                          </div>
                      </div>
					</div>
				</section>
			</div>
		</div>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
$(function(){
	$('#add_articleLink_form').ajaxForm({
		dataType : 'json',
		success : function(data) {
			if (data.result) {
				bootbox.alert("保存成功，将刷新页面", function() {
					window.location.reload();
				});
			}else{
				showErrors($('#add_articleLink_form'),data.errors);
			}
		}
	});
    
    $('.js_create_time').datetimepicker({
        language:  'zh-CN',
        format: "yyyy-mm-dd",
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });	
});
</script>
<#include "/manage/foot.ftl">