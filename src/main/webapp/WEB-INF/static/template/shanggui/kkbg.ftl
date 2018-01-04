<@cms_article_page_tag folderId=tag_folder.folderId p=p rows="8">
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
			<div class="clear"></div><#if tag_folder.folderId==folder.folderId>active</#if>
		</li>
		</#list>
	</ul>
	<#include "page.ftl">
</#if>
</@cms_article_page_tag>