<#assign menu="articleLink">
<#assign submenu="articleLink_list">
<#include "/manage/head.ftl">
<style type="text/css">
.pagination {
    border-radius: 4px;
    display: inline-block;
    margin: 0;
    padding-left: 0;
}

.howto, .nonessential, #edit-slug-box, .form-input-tip, .subsubsub {
    color: #666666;
}

.subsubsub {
    float: left;
    font-size: 12px;
    list-style: none outside none;
    margin: 8px 0 5px;
    padding: 0;
}

.form-group{
	width:100%;
}

.count{
	position:absolute ;
	right:0px;
}

.arrticle_status{
	float:left;
}
</style>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">		
        	<!-- page start-->
            <section class="panel">
	                <header class="panel-heading">
		                <div class="row">
		                  <div class="col-lg-4">
						   </div>
						   <div class="col-lg-8">
								<a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/articleLink/add.htm">增加链接</a>
						   </div>
				</div>
			</header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
										<th>文章名称</th>
										<th>作者</th>
										<th>关联</th>
										<th>链接</th>
										<th>创建时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
               							<td>
               								<a href="${e.path!}">${e.title!}</a>
               							</td>
               							<td>${e.author!}</td>
               							<td>${e.articleId!}</td>
               							<td>${e.path!}</td>
                                    	<td>${e.createTime?string("yyyy-MM-dd")}</td>
                                    	
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${BASE_PATH}/manage/articleLink/update.htm?id=${e.id}" title="修改">
                  								编辑
                  							</a>
                  							 | 
                  							<a href="javascript:void(0);" class="js_article_delete" articleId="${e.id}" title="是否删除">
                  								删除
                  							</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                              <div style="height: 30px;">
                             	<div class="pagination">${pageVo.pageNumHtml} </div>
                              </div>
                           </div>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<script>
$(function(){
var pageNum = "${p}";
	$('.js_article_delete').click(function(){
		var articleId = $(this).attr('articleId');
		var status= "trash";
		bootbox.dialog({
			message : $(this).attr('title'),
			title : "提示",
			buttons : {
				"delete" : {
					label : "确定",
					className : "btn-success",
					callback : function() {
						$.post("${BASE_PATH}/manage/articleLink/delete.json", { "id": articleId},function(data){
								window.location.reload();
						}, "json");
					}
				},
				"cancel" : {
					label : "取消",
					className : "btn-primary",
					callback : function() {
						
					}
				}
			}
		});					
	});	
	$(".js_article_check").change(function(){
		$.post("${BASE_PATH}/manage/article/check.json", 
			{"articleId": $(this).attr("articleId"),check:$(this).val()},
			function(data){
				if(data.result){
					window.location.href="${BASE_PATH}/manage/article/list.htm?p="+pageNum;
				}else{
					bootbox.alert(data.msg,
	                function() {
	                    window.location.href="${BASE_PATH}/manage/article/list.htm?p="+pageNum;
	                });
				}
        },"json");  	
    });		
});
</script>
<#include "/manage/foot.ftl">
