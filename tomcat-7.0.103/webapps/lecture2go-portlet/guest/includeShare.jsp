<div id="metadata">
	<p class="smallitalic"><liferay-ui:message key="embed-conditions"/></p>
	<form name="embedForm" id="embedForm">
		<!-- embed start -->
			<div class="sharetile">
				<p class="tileheading"><liferay-ui:message key="links"/></p>
				<div id="urls">
					<ul>
						<li>
							<aui:input name="embed_code3" label="video-url" helpMessage="about-video-url" required="false" id="embed_code3" readonly="true" value="${video.url}" onclick="document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_embed_code3.focus();document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_embed_code3.select();"/>
						</li>
						<li>
							<aui:input name="embed_code" label="embed-iframe" helpMessage="about-iframe-embed" required="false" id="embed_code" readonly="true" value="${video.embedIframe}" onclick="document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_embed_code.focus();document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_embed_code.select();"/>
						</li>
						<c:if test="${video.downloadLink==1}">
							<li>
								<aui:input name="embed_code1" label="embed-html5" helpMessage="about-html5-embed" required="false" id="embed_code1" readonly="true" value="${video.embedHtml5}" onclick="document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_embed_code1.focus();document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_embed_code1.select();"/>							
							</li>
						</c:if>
						<c:if test="${video.lectureseriesId>0}">
							<li>
								<aui:input name="embed_code2" label="lecture-series-url" helpMessage="about-lecture-series-url" required="false" id="embed_code2" readonly="true" value="${video.lectureseriesUrl}" onclick="document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_embed_code2.focus();document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_embed_code2.select();"/>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		<!-- embed end -->
		
		<!-- citation2go allowed -->
		<c:if test="${video.citation2go==1}">
				<div class="sharetile">
					<p class="tileheading"><liferay-ui:message key="citation2go"/></p>
					<div id="c2g-generate">
						<ul>
							<li>
								<aui:input name="timeStart" label="citation-start" required="false" id="timeStart" readonly="true" helpMessage="about-time-start"/>
							</li>
							<li>
								<aui:input name="timeEnd" label="citation-end" required="false" id="timeEnd" readonly="true" helpMessage="about-time-end"/>
							</li>
							<li>
							<li>
								<aui:input name="citation" label="citation2go-link" required="false" id="citation" readonly="true"  helpMessage="about-citation" onclick="document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_citation.focus(); document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_citation.select();"/>
							</li>
							<li>
								<aui:input name="citationiframe" label="embed-iframe" required="false" id="citationiframe" readonly="true"  helpMessage="about-citation-iframe" onclick="document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_citationiframe.focus(); document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_citationiframe.select();"/>
							</li>
						</ul>
					</div>
				</div>
		</c:if>
		<!-- citation2go allowed end-->		
		
		<!-- Facebook Twitter Google+ -->
		<div class="sharetile">
			<p class="tileheading"><liferay-ui:message key="social-media"/></p>
			<div id="socialshareprivacy"></div>
		</div>
		<!-- Facebook Twitter Google+ Ende -->
	</form>
		
	<script type="text/javascript">
		$('#socialshareprivacy').socialSharePrivacy({
			services : {
				gplus : {
					status : 'on'
				}
			}
		});
	</script>
	
	<%@ include file="/guest/includeQR.jsp" %>
</div>