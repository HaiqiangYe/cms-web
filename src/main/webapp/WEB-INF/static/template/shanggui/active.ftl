
			
			
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
					
					
					<div class="pages fs12 col46 lh30 text-center">
						<a class="pages-border" href="#">上一页</a>
						<a class="pages-border" href="#">1</a>
						<a class="pages-border active">2</a>
						<a class="pages-border" href="#">3</a>
						<span>· · ·</span>
						<a class="pages-border" href="#">10</a>
						<a class="pages-border" href="#">下一页</a>
						&nbsp;共<span class="page-num">8</span>页，到第&nbsp;
						<input type="text" maxlength="4" class="pages-border">&nbsp;</input>
						页&nbsp;
						<a class="pages-border" href="#">确定</a>
						
					</div>
				</div>
				<!--律所活动列表-->
			</@cms_article_page_tag>