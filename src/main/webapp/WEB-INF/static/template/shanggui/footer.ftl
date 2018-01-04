		<!--底部-->
		<footer class="footer">
			<div class="width1200">
				<div class="sg-contact fl width600 white">
					<p class="fs40"><b>${cms_title}</b></p>
					<p class="fs18 border-left mt40"><b>地址</b></p>
					<p class="mt20 fs14">${cms_address}</p>
					<p class="fs18 border-left mt30"><b>联系方式</b></p>
					<p class="mt20 fs14">联系热线：${cms_phone}</p>
					<p class="mt20 fs14">传真：${cms_fax}</p>
					<p class="mt20 fs14">邮箱：${cms_email}</p>
					<!--<p class="mt15">
						<a href="#" target="_blank">
							<img src="${TEMPLATE_BASE_PATH}/images/btn1.png" class="weibo"/>
						</a>&nbsp;&nbsp;
						<a href="#" target="_blank" class="qq">
							<img src="${TEMPLATE_BASE_PATH}/images/btn2.png" />
						</a>&nbsp;&nbsp;
						<a href="#" target="_blank" class="weixin">
							<img src="${TEMPLATE_BASE_PATH}/images/btn3.png"/>
						</a>
					</p>-->
				</div>
				<form id="fm">
				<div class="sg-message fr width600 white">
					<input type="text" name="email" id="email" value="" placeholder="手机号" class="fr fs14 lh45"/>
					<input type="text" name="name" id="name" value="" placeholder="姓名" class=" fs14 lh45"/>
					<p class="mt30"></p>
					<textarea name="content" id="content" rows="10" cols="26" class="fs14 message-content white text-left" placeholder="留言内容" style="resize: none;"></textarea>
					<!---->
					<input type="button" name="guestBtn" id="guestBtn" value="提交" class="sg-submit white fs14 lh60 mt30"/>
				</div>
				</form>
				<div class="clear"></div>
				
			</div>
			<div class="copyright white lh60 fs14 text-center mt50">
					${cms_version!} - ${cms_nbr!} - V0.0.1
			</div>
			<!--<div id="weixin-dialog" class="fs14" style="display: none;">
	
		    	<div class="lh25 "><b>关注微信<b></b></b></div><b><b>
		    	<div class="text-center mt5 "><img src="${TEMPLATE_BASE_PATH}/images/wx_yld_img.png"></div>
		    	<div class=" lh25">打开微信，用″扫一扫″关注官方微信</div>
		    	</b></b>
			</div>-->
		</footer>
		<!--底部-->
		
		<script src="${TEMPLATE_BASE_PATH}/js/jquery-1.8.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${TEMPLATE_BASE_PATH}/js/slider-8.01.js" type="text/javascript" charset="utf-8"></script>
		<script src="${TEMPLATE_BASE_PATH}/js/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${TEMPLATE_BASE_PATH}/js/bxslider.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			
			$(function(){

				$('#banner-slider').flexslider({
					animation: "slide",
					direction:"horizontal",
					easing:"swing",
					slideshow:true
				});
				$('#advertisement-box').flexslider({
					animation: "slide",
					direction:"horizontal",
					easing:"swing",
					slideshow:false
				});
				$('#team').bxSlider({
					slideWidth: 390, 
					auto: true,
					prevImage: '${TEMPLATE_BASE_PATH}/images/team_arr_left.png', 
				  	nextImage: '${TEMPLATE_BASE_PATH}/images/team_arr_right.png', 
					minSlides: 3,
					maxSlides: 3,
					slideMargin: 10,
					moveSlideQty: 1, 
					controls: true//隐藏左右按钮
				  });
				$('.weixin').click(function(e){
					e.preventDefault();console.log(123)
					layer.open({
						type: 1,
						title: false,
					    closeBtn: 0,
					    shadeClose: true,
					    skin: 'yourclass',
					    content: $('#weixin-dialog')
					});
				})
				$('#team').on('mouseenter','.team-item',function(e){
					e.preventDefault();
					var targetel = $(this).attr('href');
					$(targetel).show().siblings().hide();
					
				})
			});

		   $("#guestBtn").click(function () { //“登录”按钮单击事件
		   

            	if($("#name").attr("value")==""){
                   alert("留言失败：姓名不能为空");
			   		return ;
                }
    
            if($("#email").attr("value")==""){
                   alert("留言失败：手机不能为空");
			   		return ;
            }
            if($("#content").attr("value")==""){
                  alert("留言失败：留言内容不能为空");
			   		return ;
            }

                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "${BASE_PATH}/guestbook/add.json",
                    async : true,
                    data: $('#fm').serialize(),
                    success: function (data) { 
                    $('#fm')[0].reset();

                        if(data.result){
                        	alert("感谢您的留言!");
                        	return;
                        }else{
                        	alert("留言失败："+data.msg);
                        	return;
                        }
                    }

                });
		   
		   })
			$(function(){
				// 点击微信弹出二维码
				$('.weixin').click(function(e){
					e.preventDefault();
					layer.open({
						type: 1,
						title: false,
					    closeBtn: 0,
					    shadeClose: true,
					    skin: 'yourclass',
					    content: $('#weixin-dialog')
					});
				})
				// tab 功能
				$('.nav-list').on('click','a',function(e){
					var targetel = $(this).attr('href');
					if(targetel.indexOf("#") == -1){return;}
					$(this).parent().addClass('active').siblings().removeClass('active');
					
					e.preventDefault();
					$(targetel).show().siblings().hide();
				})
			});
		</script>
		<script type="text/javascript">		
			$("#searchBtn").click(function () { //“登录”按钮单击事件
				if($("#key").attr("value")==""){
                   alert("搜索内容不能为空！");
			   		return ;
                }
                document.charset='utf-8';
                document.getElementById("fsearch").submit();  
			});
		</script>
</body>
</html>