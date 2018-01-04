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
						<div class="width1200">
							<div class="mt30 content">
								<p>${folder.content}</p>
								
			
			
			<@cms_article_page_tag folderId=13 p=p rows="8">
				<!--律所活动-->
			<!--律所活动-->
				<!--律所活动列表-->
				<div class="activity-list">
					<!--第一行-->
					 <#list tag_article_page.list as tag_article>
					 <#if tag_article_index %2==0>
					<div class="activity-shadow">
						<div class="fl width600 describe col89">
							<p class="activity-title fs20 mt70 text-center col46"><b>${tag_article.title}</b></p>
							<p class="activity-time lh50 text-center">${tag_article.createTime?string("yyyy-MM-dd")}</p>
							<p class="activity-content">${tag_article.summary}</p>
							<p class="text-center">
								<a href="<@cms_article_url_tag articleId=tag_article.articleId/>" class="col46 dis-inblock activity-details">了解详情  →</a>
							</p>
							
						</div>
						<div class="fr width600">
							<img src="${BASE_PATH}/${tag_article.picture}"/>
						</div>
						<div class="clear"></div>
					</div>
					</#if>
					<#if tag_article_index %2==1>
					<!--第二行-->
					<div class="activity-shadow">
						<div class="fr width600 describe col89">
							<p class="activity-title fs20 mt70 text-center col46"><b>${tag_article.title}</b></p>
							<p class="activity-time lh50 text-center">${tag_article.createTime?string("yyyy-MM-dd")}</p>
							<p class="activity-content">${tag_article.summary}</p>
							<p class="text-center">
								<a href="<@cms_article_url_tag articleId=tag_article.articleId/>" class="col46 dis-inblock activity-details">了解详情  →</a>
							</p>
							
						</div>
						<div class="fl width600">
							<img src="${BASE_PATH}/${tag_article.picture}"/>
						</div>
						<div class="clear"></div>
					</div>
					</#if>
					</#list>
					
					
					<#include "page.ftl">
				</div>
				<!--律所活动列表-->
			</@cms_article_page_tag>
							</div>
						</div>
				</div>
			</div>
		
		
		
		
<#include "footer.ftl">