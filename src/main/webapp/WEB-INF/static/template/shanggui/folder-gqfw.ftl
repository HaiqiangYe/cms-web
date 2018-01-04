<#include "header.ftl">
<style type="text/css">
.case-list li{padding: 20px 0 20px 87px;border-bottom: 1px dashed #c9c9c9;background: url(${TEMPLATE_BASE_PATH}/images/classic_case1.jpg) no-repeat left center;}
.case-list li:hover {background: url(${TEMPLATE_BASE_PATH}/images/classic_case2.jpg)no-repeat left center;}
.case-list li a:hover{color: #C21C1C;}
.service-list li>a{padding: 10px 30px;background: #898989;margin-right: 1px;}
.service-list li>a.active{background: #C21C1C;}
</style>
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
								<div class="clear"> </div>
								<ul class="service-list">
									<#list secondFolderPathList as tag_folder>
										<li  class="fl">
											<a href="<@cms_folder_url_tag folderId=tag_folder.folderId/>" class="fs14 lh35 white <#if tag_folder.folderId==folder.folderId>active</#if>">${tag_folder.name}</a>
										</li>
									</#list>
								</ul>
							<div class="clear"> </div>
							<div class="tabs-content min-height700">
								<div class="mt30 content">
									<p>${folder.content}</p>
								</div>
							</div>
							</div>
						</div>
				</div>
			</div>
		
		
		
		
<#include "footer.ftl">