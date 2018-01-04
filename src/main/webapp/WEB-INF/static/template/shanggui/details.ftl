
				<!-- 案例详情-->
				<div class="activity-detail-box ">
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
					<div class=" activity-details-line"></div>
					<div class="mt30 lh50 fs16 text-center">
						<a class="fl article-turn" href="#">上一篇</a>
						<a class="fr article-turn" href="#">下一篇</a>
						<a class="text-center red" href="#"><b>返回列表</b></a>
					</div>
				</div>