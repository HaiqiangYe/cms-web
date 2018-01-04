							<@cms_folder_list_second_tag folderId= folder.folderId>
								<div class="clear"> </div>
								<ul class="service-list">
									<#list tag_folder_second_list as tag_folder>
										<li  class="fl">
											<a href="<@cms_folder_url_tag folderId=tag_folder.folderId/>" class="fs14 lh35 white <#if tag_folder.folderId==folder.folderId>active</#if>">${tag_folder.name}</a>
										</li>
									</#list>
								</ul>
							
							<div class="tabs-content min-height700">
								<div class="mt25 content1">
									<ul class="case-list mt25">
										<@cms_article_page_tag folderId=folder.folderId p=p rows="8">
											<#list tag_article_page.list as tag_article>
											<li>
												<p class="fs14 lh25 col46"><a href="<@cms_article_url_tag articleId=tag_article.articleId/>" style="color: #C21C1C;"><b>${tag_article.title}</b></a></p>
												<p class="fs14 lh20 col89">${tag_article.summary}</p>
											</li>
											</#list>
										</@cms_article_page_tag>
									</ul>
									<#if (tag_article_page.list?size gt 0)>
										<#include "page.ftl">
									</#if>
												
								</div>
							</div>
							</@cms_folder_list_second_tag>