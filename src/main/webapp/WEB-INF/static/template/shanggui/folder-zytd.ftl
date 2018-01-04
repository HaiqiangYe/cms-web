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
											<@cms_article_page_tag folderId=folder.folderId p=p rows="8">
											<!--团队精英-->
												<ul class="team-elite mt50">
												
									                <#list tag_article_page.list as tag_article>
													<li style="padding: 25px 0;height: 245px;border-bottom: 1px dashed #B2B2B2;overflow: hidden;">
														<div class="fl mr30">
															<img src="${BASE_PATH}/${tag_article.picture}"/>
														</div>
														<div class="fl">
															<p class="fs24  lh50">${tag_article.title}</p>
														    <p class="fs16">${tag_article.role}</p>
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
							</div>
						</div>
				</div>
			</div>
		
		
		
		
<#include "footer.ftl">