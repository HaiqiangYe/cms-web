	<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>ccc</h4>
					<p>
						fff					</p>
				</div>
				<div class="sidebar-module sidebar-module-inset">
					<h4><a href="<@cms_folder_url_tag folderId=1/>">adfa</a></h4>
					<ol class="list-unstyled">
						<@cms_folder_list_tag folderId= 1>
		                		<#list tag_folder_list as tag_folder>
						<li><a href="<@cms_folder_url_tag folderId=tag_folder.folderId/>">${tag_folder.name}</a><li>
						</#list>
	               				</@cms_folder_list_tag>
					</ol>
				</div>
				<div class="sidebar-module sidebar-module-inset">
					<h4>rrrr</h4>
					<ol class="list-unstyled">
						<li><a href="${BASE_PATH}/admin/login.htm">cdcd</a><li>
					</ol>
				</div>
				<div class="sidebar-module">
					 <a target="_balnk" rel="nofollow" href="http://s.click.taobao.com/t?e=m%3D2%26s%3DIBpia%2BLo0tEcQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAjrHDnuydt9DjEirhkXBrn3taZwnSL6Nwn5Xa4s7Qs0aQZoJJOKTMC8aPrINdm0lpOdn1BbglxZYxUhy8exlzcq9AmARIwX9K%2BnbtOD3UdznPV1H2z0iQv9NkKVMHClW0QbMqOpFMIvnvjQXzzpXdTHGJe8N%2FwNpGw%3D%3D">
	 					<img style="" src="${TEMPLATE_BASE_PATH}/images/aliyun.jpg?v=${config_v}">
	 				</a>
				</div>
			</div>