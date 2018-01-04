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
									<p>${folder.content}</p>		
								</div>
							</div>
							</@cms_folder_list_second_tag>