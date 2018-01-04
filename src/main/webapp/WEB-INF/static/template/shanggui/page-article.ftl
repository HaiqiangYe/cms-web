
								<div class="mt25 activity-details-line"></div>
								<div class="mt30 lh50 fs16 text-center">
									<#if prevArticle??>
									<a class="fl article-turn" href="<@cms_article_url_tag articleId=prevArticle.articleId/>">上一篇</a>
									</#if>
									<#if nextArticle??>
									<a class="fr article-turn" href="<@cms_article_url_tag articleId=nextArticle.articleId/>">下一篇</a>
									</#if>
									<a class="text-center red" href="<@cms_folder_url_tag folderId=currentFolder.folderId/>"><b>返回列表</b></a>
								</div>
							