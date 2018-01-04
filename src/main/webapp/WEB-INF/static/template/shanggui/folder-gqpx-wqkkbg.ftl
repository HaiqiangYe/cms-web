<#include "header.ftl">
<style type="text/css">
.service-list li>a{padding: 10px 30px;background: #898989;margin-right: 1px;}
.service-list li>a.active{background: #C21C1C;}
.case-list li{padding: 20px 0 20px 87px;border-bottom: 1px dashed #c9c9c9;background: url(${TEMPLATE_BASE_PATH}/images/classic_case1.jpg) no-repeat left center;}
.case-list li:hover {background: url(${TEMPLATE_BASE_PATH}/images/classic_case2.jpg)no-repeat left center;}
.case-list li a:hover{color: #C21C1C;}
.width1110{width: 1110px;}
/**/
.hori-tab{border-bottom: 2px solid #EAEAEA;}
.hori-tab li{display: inline-block;padding :15px 0px 15px 10px;margin-bottom: -2px;border-bottom: 2px solid transparent;}
.hori-tab li.active{border-bottom: 2px solid #C21C1C;}
.hori-tab li.active a{color: #C21C1C;}
.hori-tab li>a{padding-right: 10px;border-right: 2px solid #CCCCCC;font-size: 16px;line-height: 16px;font-weight: bold;}
.report-list li{padding: 20px 0;border-bottom: 1px dashed #c9c9c9;}
.report-list li:hover .report-date{background: #C21C1C;}
.report-list li a:hover{color: #C21C1C;}
.report-list li dl{line-height:34px;}
.report-date{width: 67px; height: 67px;background: #c3c2c0;}
.bold{font-weight: bold;}
.text-center{ text-align:center;}
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
						<@cms_article_page_tag folderId=folder.folderId p=p rows="8">
						<#if tag_article_page.list?size gt 0>
							<ul class="report-list mt5">
								<#list tag_article_page.list as tag_article>
								<li>
									<dl class="white fl text-center report-date bold">
										<dt class="fs30">${tag_article.createTime?string("dd")}</dt>
										<dd class="fs14">${tag_article.createTime?string("yyyy-MM")}</dd>
									</dl>
									<div class="fl width1110 ml20">
										<p class="fs14 lh25 col46"><a href="<@cms_article_url_tag articleId=tag_article.articleId/>"><b>${tag_article.title}</b></a></p>
										<p class="fs14 lh20 col89">${tag_article.summary}</p>
									</div>
									<div class="clear"></div>
								</li>
								</#list>
							</ul>
							<#include "page.ftl">
						</#if>
						</@cms_article_page_tag>
						
						
						
				</div>
			</div>
		
		
		
		
<#include "footer.ftl">