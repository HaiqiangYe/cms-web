<#include "header.ftl">

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
									<div class="baidumap">
										<div class="fl mt50 lh25 fs16 contact-us">
											<p class="bold lh60 fs30">${cms_title}</p>
											<p >地址:${cms_address}</p>
											<p>联系热线：${cms_phone}</p>
											<p>传真：${cms_fax}</p>
											<p>邮箱：${cms_email}</p>
										</div>
										<div id="allmap" class="fr"></div>
									</div>
							</div>
						</div>
				</div>
			</div>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=RdG7yusbikqdcHMfPe1yR3YkS0xMh35y"></script>
		<script type="text/javascript">
			var map = new BMap.Map("allmap",{minZoom:4,maxZoom:18});// 创建Map实例,设置地图允许的最小/大级别
			var point = new BMap.Point(118.16798605,24.53553061);// 初始化地图,设置中心点坐标和地图级别
			map.centerAndZoom(point, 18);
			map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
			map.setCurrentCity("厦门");  // 设置地图显示的城市
			map.enableScrollWheelZoom(true);//开启鼠标滚轮缩放
			//创建图标
//			var myIcon = new BMap.Icon("images/resizeApi.png", new BMap.Size(27,43));
			var marker = new BMap.Marker(point);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			
			//118.16798605,24.53553061
		</script>			
		
		
<#include "footer.ftl">