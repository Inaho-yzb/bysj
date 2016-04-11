<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
				</li>
			<li class="dl-tab-item ks-hidden"><div class="dl-second-nav">
					<div class="dl-second-tree" id="J_7Tree"></div>
					<div class="dl-second-slib-con">
						<div class="dl-second-slib"></div>
					</div>
				</div>
				<div class="dl-inner-tab" id="J_7Tab"></div></li>
		</ul>
	</div>
	
	<div style="text-align: center;"></div>
	<script type="text/javascript" src="/js/jedate/jedate.js"></script>
<script type="text/javascript">
$(".time").on("click", function() {
var dateCell = "#" + $(this).attr('id');
jeDate({dateCell: dateCell, format: "YYYY-MM-DD",isTime:true})
});
</script>
</body>
</html>