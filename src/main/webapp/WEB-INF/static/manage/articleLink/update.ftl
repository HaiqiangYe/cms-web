<#assign menu="articleLink">
<#assign submenu="update_articleLink">
<#include "/manage/head.ftl">
<!--main content start-->
<style type="text/css">

</style>
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="update_articleLink_form" class="form-horizontal" action="${BASE_PATH}/manage/articleLink/update.json"  autocomplete="off"  method="post">
			<fieldset>
		<div class="row">
			<input type="hidden" name="id" value="${articleLink.id}">
			<input type="hidden" name="type" value="">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						修改链接
					</header>
					<div class="panel-body">
	                      
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">标题</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="title"
                              	placeholder="标题" id="name" value="${articleLink.title}">
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">作者</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="author"
                              	placeholder="作者" id="name" value="${articleLink.author!}">
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">路径</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="path"
                              	placeholder="路径" id="name" value="${articleLink.path}">
                              </input>
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">关联</label>
                          <div class="col-sm-10">
                              <select class="form-control" name="articleId" style="font-size:15px;width: 300px;">
                              		<option value="0">专业著作</option>
                              		<#list articleAll as article>
			                        	<option value="${article.articleId}" <#if article.articleId==articleLink.articleId>selected</#if>>
			                        	${article.title}
			                        	</option>
			                        </#list>
	                            </select>			
                          </div>
                        </div> 
						                                            
						
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">发布时间</label>
                          <div class="col-sm-10">
                              <input type="text" data-link-format="yyyy-mm-dd" data-date-format="yyyy-MM-dd" style="font-size:15px;" class="js_create_time" name="createTime"
                              	placeholder="发布时间" id="createTime" value="${articleLink.createTime?string("yyyy-MM-dd")}" readonly>
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
		</fieldset>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
$(function(){
	$('#update_articleLink_form').ajaxForm({
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
