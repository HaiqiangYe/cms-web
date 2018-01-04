
			
			
			<@cms_article_page_tag folderId=8 p=p rows="8">
				<!--团队精英-->
					<ul class="team-elite mt50">
					
		                <#list tag_article_page.list as tag_article>
						<li style="padding: 25px 0;height: 245px;border-bottom: 1px dashed #B2B2B2;overflow: hidden;">
							<div class="fl mr30">
								<img src="${BASE_PATH}/${tag_article.picture}"/>
							</div>
							<div class="fl">
								<p class="fs24  lh50">${tag_article.title}</p>
							    <p class="fs16">高级合伙人</p>
							    <p class="fs14 lh25 mt10 col89">
							    	${tag_article.summary}
							    </p>
							    
							    <p class="">
									<a href="<@cms_article_url_tag articleId=tag_article.articleId/>" class="col46 dis-inblock activity-details">了解详情  →</a>
								</p>
							</div>
							<div class="clear"></div>
						</li>
						</#list>
	               	
				</ul>
			<!--团队精英-->
			<#include "page.ftl">
			</@cms_article_page_tag>