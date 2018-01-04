<#include "header.ftl">


		<!--banner-->
		
		<div id="banner-slider" class="flexslider">
		  <ul class="slides">
		 <@cms_headline_list_tag>
		  <#list tag_headline_list as tag_headline>
		    <li>
			    <div class="text-center" >
				    <a href="${tag_headline.url}" target="_blank">
				      <img src="${BASE_PATH}/${tag_headline.picture}" width="100%" class="" />
				    </a>   
			    </div>
		    </li>
		    </#list>
			</@cms_headline_list_tag>
			
		  </ul>
		</div>
		
		<!--banner-->
		
		<!--新闻和业绩-->
		<div class="news-and-performance width1200 pos-relative">
			<@cms_article_rec_type_tag recType=3 rows=1>
			<#list tag_article_rec_type_list as tag_article>
			<div class="fr nap-p width600 white">
				<p class="fs16"><b class="mr40 fs22 nap-bottom">${tag_article.title}</b>${tag_article.createTime?string("yyyy年MM月dd日")}</p>
				
				<p class="mt45 fs16"></p>
				<p class="fs14 lh25 mt20">${tag_article.summary}</p>
				<p class="fs14 mt25">
					<a href="<@cms_folder_url_tag folderId=tag_article.folderId/>" target="_blank" class="fr lh60 white">查看全部 &gt;</a>
					<a href="<@cms_article_url_tag articleId=tag_article.articleId/>" target="_blank" class="link-detaile dis-inblock text-center lh60 col46">了解详细</a>
				</p>
			</div>
			</#list>
			</@cms_article_rec_type_tag>
			<@cms_article_rec_type_tag recType=2 rows=1>
			<#list tag_article_rec_type_list as tag_article>
			<div class=" nap-n width600">
			<!--新闻-->
				<p class="fs16"><b class="mr40 fs22 nap-bottom">${tag_article.title}</b>${tag_article.createTime?string("yyyy年MM月dd日")}</p>
				
				<p class="mt45 fs16"></p>
				<p class="fs14 lh25 mt20">${tag_article.summary}</p>
				<p class="fs14 mt25">
					<a href="<@cms_folder_url_tag folderId=tag_article.folderId/>" target="_blank" class="fr lh60 col333">查看全部 &gt;</a>
					<a href="<@cms_article_url_tag articleId=tag_article.articleId/>" target="_blank" class="link-detaile dis-inblock text-center lh60 white">了解详细</a>
				</p>
			</div>
			</#list>
			</@cms_article_rec_type_tag>
		</div>
		<!--新闻和业绩-->
		<!--福建尚圭律师事务所-->
		<div class="text-center width1200">
			<@cms_folder_tag folderId= 39>
				<p class="mt100 fs40">${tag_folder.name}</p>
				${tag_folder.content}
			</@cms_folder_tag>
			<#include "point.ftl">
		</div>
		<!--福建尚圭律师事务所-->
		<!--广告部分-->
		<div class="advertisement-box width1200 flexslider pos-relative">
			<div id="advertisement-box">
				<ul class="slides">
					<@cms_article_rec_type_tag recType=1 rows=8>
					<#list tag_article_rec_type_list as tag_article>
					    <li>
					    	<div class="ad-bg pos-abs text-right">
					    		<img src="${BASE_PATH}/${tag_article.picture}"/>
					    	</div>
					    	<div class="advertisement pos-relative">
								<div class="ad1 pos-relative col333">
									<p class="fs16"><b>${tag_article.title}</b></p>
									<p class="mt25 fs14 lh25 mt25 col59">
									${tag_article.summary!}
									</p>
								</div>
							</div>
					    </li>
				    </#list>
				    </@cms_article_rec_type_tag>
				    

				 </ul>
			</div>
			<div id="advertisement-bg" class="pos-abs">
				<ul class="slides">
				    <li class="ad-bg1">
				    	
				    </li>
				    <li class="ad-bg2">
				    	
				    </li>
				    <li class="ad-bg3">
				    	
				    </li>
				 </ul>
			</div>
		</div>
		<!--广告部分-->
		<!--专业团队-->
		<div class="text-center">
			<p class="mt100 fs40">专业团队</p>
			<p class="fs16 mt25">著名法学院毕业、拥有扎实的法律知识和资深工作经验的专业人才</p>
			 <div  class="team-bxslider mt40">
				  <ul id="team">
				<@cms_article_list_tag folderId=8 p=p rows="8">
				<#list tag_article_list as tag_article>
			    <li>
			    	<div class=" text-center" >
			    		<a href="#team${tag_article_index}" class="dis-inblock team-item pos-relative" onclick="javascript:location.href='<@cms_article_url_tag articleId=tag_article.articleId/>'"><img src="${BASE_PATH}/${tag_article.picture}" width="100%" class="" />
			    			<div class="pos-abs team-mask text-center">
				    			<p class="fs24 mt100 lh50">${tag_article.title}</p>
				    			<p class="fs16">${tag_article.role}</p>
			    			</div>
			    		</a>
			    		
			    	</div>
			    </li>
			    </#list>			  
			  </ul>
			</div>
			<div class="clear"></div>
			<div class="teamates">
				<#list tag_article_list as tag_article>
				<div class="teamate text-center" id="team${tag_article_index}" <#if tag_article_index!=0>style="display: none;"</#if>>
					<p class="fs24 mt30 lh50">${tag_article.title}</p>
				    <p class="fs16">${tag_article.role}</p>
				    <p class="fs14 lh25 mt20 col89">
				    	${tag_article.summary}
				    </p>
				</div>
				</#list>
			    </@cms_article_list_tag>
			</div>
		</div>
		<!--专业团队-->
		<!-- /.row -->
		<#include "footer.ftl">