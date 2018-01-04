<#include "header.ftl">
<script src="${TEMPLATE_BASE_PATH}/js/jquery-1.8.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
            $(function(){
                toRed("${key!}");
            });
             
            function toRed(content){
                var bodyHtml = $("#searchContent").html();
                var x = bodyHtml.replace(new RegExp(content,"gm"),"<span class='fs16 red'>"+content+"</span>")
                $("#searchContent").html(x);
            }
        </script>
			<div class="width1200" id="classic-case">
			<p class="title lh50 mt30">
				关键字“<span class="fs16 red">${key!}</span>”的搜索结果共<span class="fs18 red bold">${pageVo.count!}</span>个，具体如下:
			</p>
			<@cms_folder_list_tag folderId= 0>
				<div class="mt20 content">
				<!--
					<ul class="service-list">
					<#list tag_folder_list as tag_folder>
						<li class="fl">
							<a href="<@cms_folder_search_url_tag folderId=tag_folder.folderId key=key/>" class="fs14 lh35 white <#if g_folderId==tag_folder.folderId>active</#if>">${tag_folder.name}</a>
						</li>
						</#list>
					</ul>
					
					<div class="clear"> </div>
					-->
						<ul class="search-list mt25" id="searchContent">
							<#list pageVo.list as tag_article>
							<li>
								<p class="fs14 lh25 col46 bold"><a href="<@cms_article_url_tag articleId=tag_article.articleId/>">${tag_article.title}</a></p>
								<p class="fs14 lh20 col89">${tag_article.summary}</p>
							</li>
							</#list>
							
						</ul>
						${pageVo.pageNumHtml!}
					</div>
			</@cms_folder_list_tag>




</div>
<!-- /.row -->
<#include "footer.ftl">