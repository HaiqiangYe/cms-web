<#include "header.ftl">


		<!--一级广告-->
		<#include "ad-folder.ftl">
		<!--主体内容-->
		<!-- 一级tab -->
			<div class="navigater">
				<div class="width1200">
					<div class="fl fs18 mt20 nav-title border-left">
						<b>${firstFolder.name}</b>
					</div>
					<ul class="fr nav-list fs14">
						<#list firstFolderPathList as tag_folder>
							<li class="dis-inblock  ml30 <#if tag_folder.folderId==secondFolder.folderId>active</#if>">
								<a href="<@cms_folder_url_tag folderId=tag_folder.folderId/>">${tag_folder.name}</a>
							</li>
						</#list>
					</ul>
				</div>
			</div>
			<div class="width1200">
				<!--来自后台编辑标题-->
				<#include "route-folder.ftl">
				<div class="tabs-content">

					<!--团队精英-->
				<div class="mt30">
					<div class="fl mr30">
						<img src="${BASE_PATH}/${article.picture}"/>
					</div>
					<div class="fl">
						<p class="fs24  lh50">${article.title}</p>
					    <p class="fs16">${article.role}</p>
					    <p class="fs14 lh25 mt10 col89">
					    	${article.summary}
					    </p>
						
					</div>
					<div class="clear"></div>
					<!--代表案例-->
					<div class="mt40">
						<p class="fs18 red"><b>代表案例</b></p>
						<p>${article.content}</p>
					</div>
					<!--代表案例-->
					<!--文章专栏-->
					<div class="mt70">
						<p class=" fs18 red"><b>文章专栏</b></p>						
						<ul class=" fs14 lh25 col89">
						<@cms_article_link_list_tag articleId=article.articleId>
							<#list tag_articlelink_list as articlelink>
							<li class="mt30">
								<b class="sqrt-blolck"></b>
								<a href="${articlelink.path}" target="_blank" class="underline">${articlelink.title}</a>
							</li>
							</#list>
						</@cms_article_link_list_tag>
						</ul>
					</div>
					<!--文章专栏-->
				</div>
				<!--团队精英-->
				</div>
			</div>
		<div class="mt30"></div>
		
		
		
<#include "footer.ftl">