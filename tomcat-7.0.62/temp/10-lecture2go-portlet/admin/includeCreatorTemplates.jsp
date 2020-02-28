<!-- Template -->
<script type="text/x-jquery-tmpl" id="newCreator">
	<div id="nc<%="${counter}"%>">
		<aui:row>
			<aui:input type="hidden" name="gender"/>
			<aui:input name="jobTitle" type="text" helpMessage="job-title-help-text"/>
			<aui:input name="firstName" type="text"/>
			<aui:input name="middleName" type="text"/>
			<aui:input name="lastName" type="text"/>
			<a class="icon-large icon-remove" onclick="remb('<%="nc${counter}"%>');"></a>
		</aui:row>
		<aui:row>
			<aui:input name="affiliation" type="text" helpMessage="institution-of-creator-explanation"/>
			<aui:input name="orcidId" type="text" helpMessage="orcid-explanation"/>
			<aui:input name="creatorId" value="0" type="hidden"/>
		</aui:row>
		<br/>
	</div>
</script>

<!-- Template -->
<script type="text/x-jquery-tmpl" id="created">
   	<div id="<%="c${creatorId}"%>">
    	<%="${fullName}"%> &nbsp; <a class="icon-large icon-remove" onclick="remb('<%="c${creatorId}"%>');"></a>
		<aui:input type="hidden" name="gender"/>
		<input type="hidden" name="<portlet:namespace/>creatorId" value="<%="${creatorId}"%>"/>
		<input type="hidden" name="<portlet:namespace/>firstName" value="<%="${firstName}"%>"/>
		<input type="hidden" name="<portlet:namespace/>middleName" value="<%="${middleName}"%>"/>
		<input type="hidden" name="<portlet:namespace/>lastName" value="<%="${lastName}"%>"/>
		<input type="hidden" name="<portlet:namespace/>jobTitle" value="<%="${jobTitle}"%>"/>
		<input type="hidden" name="<portlet:namespace/>affiliation" value="<%="${affiliation}"%>"/>
		<input type="hidden" name="<portlet:namespace/>orcidId" value="<%="${orcidId}"%>"/>
		<input type="hidden" name="<portlet:namespace/>fullName" value="<%="${fullName}"%>"/>
	</div>
</script>