<#assign config_v="20170903044">
<!DOCTYPE html>
<html lang="en">

<head>
		<meta charset="UTF-8">
		<meta name="Keywords" content=""/>
		<meta name="Description" content="${cms_seo_description}"/>
		<link rel="stylesheet" type="text/css" href="${TEMPLATE_BASE_PATH}/css/style.css"/>
		<link rel="stylesheet" type="text/css" href="${TEMPLATE_BASE_PATH}/css/box.css"/>
		<link rel="stylesheet" type="text/css" href="${TEMPLATE_BASE_PATH}/css/bxslider.css"/>
		<title>${cms_seo_title}</title>
	</head>
<body>



		<header>
			<div class="welcom fs14 lh40">
				<div class="width1200">
					<p class="fl ">您好，<span class="red">福建尚圭律师事务所</span>欢迎您！</p>
					<form id="fsearch" action = "${BASE_PATH}/folder/search.htm" method="get" accept-charset="utf-8">
						<a href="javascript:return search();" id="searchBtn"><span class="top-search fr ml15"></span></a>
						<input type="text" name="key" id="key" value="${key!}" class="fr search-box mt5 lh25"/>
						
					</form>
				</div>
			</div>
			<div class="nav-bar width1200">
				<ul class="fr mt50">
				<@cms_folder_list_tag folderId= 0>
				<!--target="_blank"-->
					<li class="dis-inblock ml45 fs16 "><a href="${BASE_PATH}"  class="<#if g_folderId==0>red</#if> dis-inblock">首页</a></li>
					<#list tag_folder_list as tag_folder>
						<li class="dis-inblock ml45 fs16"><a href="<@cms_folder_url_tag folderId=tag_folder.folderId/>"  class="<#if g_folderId==tag_folder.folderId>red</#if> dis-inblock">${tag_folder.name}</a></li>
					</#list>
				</@cms_folder_list_tag>
				</ul>

			</div>
		</header>
