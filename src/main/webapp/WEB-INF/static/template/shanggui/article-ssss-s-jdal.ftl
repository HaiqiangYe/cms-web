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
											<a href="<@cms_folder_url_tag folderId=tag_folder.folderId/>" class="fs14 lh35 white <#if tag_folder.folderId==threeFolder.folderId>active</#if>">${tag_folder.name}</a>
										</li>
									</#list>
								</ul>
							<div class="clear"> </div>
							<div class="tabs-content min-height700">
								<div class="mt25 content">
								<div class="clear"> </div>
									<!--活动详情-->
									<div class="activity-detail-box">
										<p class="activity-details-title text-center fs20"><b>${article.title}</b></p>
										<p class="text-center col89 fs12 mt15">
											发布时间：<span class="activity-details-time red mr30">${article.updateTime?datetime}</span>
											发布者：<span class="activity-details-author red mr30">本站</span>
											浏览量：<span class="activity-details-visits red">${article.viewCount}</span>
										</p>
										<div class="mt25 activity-details-line"></div>
										<div class="activity-details-content mt25 col89 fs14 ptop-20 lh25">
											<p>
											${article.content}
											</p>
											
										</div>
										<#include "page-article.ftl">
									</div>
												
								</div>
							</div>
							</div>
						</div>
				</div>
			</div>
		
		
		
		
<#include "footer.ftl">