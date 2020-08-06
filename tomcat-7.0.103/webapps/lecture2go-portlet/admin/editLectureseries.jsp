<%@include file="/init.jsp"%>

<%
	String actionURL = "";
	String lName = "";
	String lNumber = "";
	String lLanguage = "";
	Long categoryId = new Long(0);
	Long lSemester = new Long(0);
	String lShortDesc = "";
	String lInstructors = "";
	String lPassword = "";
	String lLongDesc = "";
	Long producerId = new Long(0);
	Long institutionId = new Long(0);
	Integer videoSort = new Integer(0);
	Boolean isSortVideosASC = false;
	
	Long lId=new Long(0);
	Lectureseries reqLectureseries = new LectureseriesImpl();
	try{ 
		reqLectureseries = (Lectureseries)request.getAttribute("reqLectureseries");
		lId=reqLectureseries.getLectureseriesId();
		lName=reqLectureseries.getName();
		lNumber=reqLectureseries.getNumber();
		lLanguage=reqLectureseries.getLanguage();
		categoryId=reqLectureseries.getCategoryId();
		lSemester=reqLectureseries.getTermId();
		lShortDesc=reqLectureseries.getShortDesc();
		lPassword=reqLectureseries.getPassword();
		lLongDesc=reqLectureseries.getLongDesc();
		videoSort=reqLectureseries.getVideoSort();
		if(videoSort == 1)
		{
			isSortVideosASC=true;
		}
	}catch(NullPointerException npe){}
	
	try{
		institutionId = InstitutionLocalServiceUtil.getByLectureseriesId(lId, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS).iterator().next().getInstitutionId();
	}catch(Exception npe){}

	Map<String,String> institutions = new LinkedHashMap<String, String>();
	List<Producer> producers = new ArrayList<Producer>();

	if(permissionAdmin){
		institutions = InstitutionLocalServiceUtil.getAllSortedAsTree(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		producers = ProducerLocalServiceUtil.getAllProducers(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
		permissionCoordinator = false;
		permissionProducer = false;
	}
	
	if(permissionCoordinator){
		Coordinator c = CoordinatorLocalServiceUtil.getCoordinator(remoteUser.getUserId());
		if(institutionId==0)institutionId = c.getInstitutionId();
		institutions = InstitutionLocalServiceUtil.getByParentIdMap(c.getInstitutionId());
		producers = ProducerLocalServiceUtil.getProducersByInstitutionId(c.getInstitutionId());
	}

	if(permissionProducer){
		Producer p = ProducerLocalServiceUtil.getProdUcer(remoteUser.getUserId());
		producerId = p.getProducerId();
		//
		Institution i = InstitutionLocalServiceUtil.getById(p.getInstitutionId());
		if(institutionId==0)institutionId = p.getInstitutionId();
		//
		institutions = InstitutionLocalServiceUtil.getByParentIdMap(p.getInstitutionId());
	}
	
	Locale[] languages = LanguageUtil.getAvailableLocales();
	String[] availableLanguageIds = LocaleUtil.toLanguageIds(languages);
	String languageId="";

	List<Long> pIds = new ArrayList<Long>();
	try{
		pIds = ProducerLocalServiceUtil.getAllProducerIds(lId);
	}catch (NullPointerException e){}

	List<Creator> creators = new ArrayList<Creator>();
	try{
		creators = CreatorLocalServiceUtil.getCreators(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	}catch (NullPointerException e){}
	
	JSONArray allCreatorsJSON = new JSONArray();
	for (Creator creator: creators) {
		JSONObject c = new JSONObject();
		try {
			c.put("id", creator.getCreatorId());
			c.put("value", creator.getFullName());
			c.put("label", creator.getFullName());
			allCreatorsJSON.put(c);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	List<Term> semesters = new ArrayList<Term>(); 
	try{
		semesters = TermLocalServiceUtil.getAllSemesters();
	}catch(Exception e){}
	 
	List<Category> categories = new ArrayList<Category>();
	try{
		categories = CategoryLocalServiceUtil.getAllCategories(com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
	}catch(Exception e){}
	
	String backURL = "";
	try{
		backURL = request.getAttribute("backURL").toString();
	}catch(Exception e){
		%>
			<portlet:renderURL var="back"><portlet:param name="jspPage" value="/admin/lectureSeriesList.jsp" /></portlet:renderURL>
		<%
		backURL=back.toString();
	}
%>

<portlet:actionURL name="editLectureseries" var="editURL">
	<portlet:param name="lectureseriesId" value='<%=""+lId%>' />
	<portlet:param name="backURL" value='<%=backURL%>' />
</portlet:actionURL>

<portlet:actionURL name="addLectureseries" var="addURL">
	<portlet:param name="lectureseriesId" value='<%=""+lId%>' />
	<portlet:param name="backURL" value='<%=backURL%>' />
</portlet:actionURL>

<%
	if(lId >0) {actionURL=editURL.toString();}
	else {actionURL = addURL.toString();}

	boolean readOnly = false;
	try{if (permissionProducer && reqLectureseries.getApproved()==1){ readOnly=true;}}catch(Exception e){}
%>
<div class="noresponsive">
<aui:form action="<%=actionURL%>" commandName="model">
	<aui:fieldset column="true" label='<%=lName%>'>
		<aui:layout>
			<div id="metadata-upload">
			<%if(readOnly){%>
				<aui:input name="number" label="lectureseries-number" required="false" helpMessage="number-help-text" value="<%=lNumber %>" readonly="<%=readOnly%>"/>
			<%}else{%>
				<aui:input name="number" label="lectureseries-number" required="false" helpMessage="number-help-text" value="<%=lNumber %>"/>
			<%}%>
			
			<%if(readOnly){%>
				<aui:input name="name" label="lectureseries-title" required="true" value="<%=lName%>" readonly="<%=readOnly%>"/>
			<%}else{%>
				<aui:input name="name" label="lectureseries-title" required="true" value="<%=lName%>"/>
			<%}%>

			<%if(!readOnly){%>
				<aui:select size="1" name="categoryId" label="category" required="true">
					<aui:option value=""><liferay-ui:message key="select-category"/></aui:option>
					<%for (int i = 0; i < categories.size(); i++) {
						if (categoryId==categories.get(i).getCategoryId()) {%>
							<aui:option value='<%=categories.get(i).getCategoryId()%>' selected="true"><%=categories.get(i).getName()%></aui:option>
						<%} else {%>
							<aui:option value='<%=categories.get(i).getCategoryId()%>'><%=categories.get(i).getName()%></aui:option>
						<%}
					}%>
				</aui:select>
			<%}else{%>
				<aui:input name="cat" label="category" required="true" value="<%=CategoryLocalServiceUtil.getById(categoryId).getName()%>" readonly="<%=readOnly%>"/>
				<aui:input type="hidden" name="categoryId" value="<%=categoryId%>"/>
			<%}%>
			
			<%if(!readOnly){%>
				<aui:select size="1" name="institutionId" label="institution" required="true">
					<aui:option value=""><liferay-ui:message key="select-institution"/></aui:option>
					<%for (Map.Entry<String, String> f : institutions.entrySet()) {
					boolean dis=true; 
					if(f.getValue().startsWith("----") || permissionCoordinator || permissionProducer)dis=false;
					if(f.getKey().equals(institutionId.toString())){
						%><aui:option value='<%=f.getKey()%>' selected="true" disabled="<%=dis%>"><%=f.getValue()%></aui:option>
					<%}else{%><aui:option value='<%=f.getKey()%>' disabled="<%=dis%>"><%=f.getValue()%></aui:option><%}	
					}%>
				</aui:select>
			
				<div class="facilCont">
					<%
					List<Institution> fs = new ArrayList<Institution>();
					try{
						fs = InstitutionLocalServiceUtil.getByLectureseriesId(lId, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
						for(int i=0;i<fs.size();i++){
							Institution f = fs.get(i);
							%>
							<div id='<%=f.getInstitutionId()%>'> 
								<%=f.getName()+"&nbsp;&nbsp;&nbsp;" %> 
								<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("<%=f.getInstitutionId()%>").remove(); resetInstitution();'></a>
								<aui:input type="hidden" name="institutions" id="institutions" value="<%=f.getInstitutionId()%>"/>
							</div>
							<%
						}					
					}catch(Exception e){}
					%>				
				</div>
			<%}else{ %>
				<aui:input type="hidden" name="institutions" id="institutions" value="<%=institutionId%>"/>
				<aui:input type="hidden" name="institutionId" id="institutionId" value="<%=institutionId%>"/>
			<%}%>
			
			<%if(!permissionProducer){%>	
				<aui:select size="1" name="producerId" label="producer" required="true" helpMessage="please-add-at-lest-one-producer">
					<aui:option value=""><liferay-ui:message key="select-producer"/></aui:option>
					<%for (int i = 0; i < producers.size(); i++) {
						Long z = new Long(0);
						if(pIds.size()>0) z = new Long(pIds.get(0)+"");
						if(producers.get(i).getProducerId()==new Long(z+"")){
							%><aui:option value='<%=producers.get(i).getProducerId()%>' selected="true"><%=producers.get(i).getLastName() + ", " + producers.get(i).getFirstName()%></aui:option><%
						}else{
							%><aui:option value='<%=producers.get(i).getProducerId()%>'><%=producers.get(i).getLastName() + ", " + producers.get(i).getFirstName()%></aui:option><%
						}
					}%>	
				</aui:select>
	
				<div class="prodCont">
					<%
					try{
						for(int i=0;i<pIds.size();i++){
							Producer p = ProducerLocalServiceUtil.getProdUcer(new Long(pIds.get(i)+""));
							%>
							<div id='<%=p.getProducerId()%>'> 
								<%=p.getLastName() +", "+p.getFirstName()+"&nbsp;&nbsp;&nbsp;" %> 
								<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("<%=p.getProducerId()%>").remove(); resetProducer();'></a>
								<aui:input type="hidden" name="producers" id="producers" value="<%=p.getProducerId()%>"/>
							</div>
							<%
						}
					}catch(Exception e){}%>				
				</div>	
			<%}else{%>
				<aui:input type="hidden" name="producers" id="producers" value="<%=producerId%>"/>
				<aui:input type="hidden" name="producerId" id="producerId" value="<%=producerId%>"/>
			<%}%>
			<%if(readOnly){%> 
				<%if(TermLocalServiceUtil.getById(lSemester).getPrefix().isEmpty() && TermLocalServiceUtil.getById(lSemester).getPrefix().isEmpty()){%>
					<aui:input name="term" label="term" required="true" value='<%=LanguageUtil.get(pageContext, "no-term")%>' readonly="<%=readOnly%>"/>
				<%}else{%>
				<aui:input name="term" label="term" required="true" value='<%=TermLocalServiceUtil.getById(lSemester).getPrefix()+" "+TermLocalServiceUtil.getById(lSemester).getYear()%>' readonly="<%=readOnly%>"/>
				<%}%>
				<aui:input type="hidden" name="semesterId" value="<%=lSemester%>"/>
			<%}else{%>
				<aui:select id="allSemesters" size="1" name="semesterId" label="semester" required="true">
					<%for (int i = 0; i < semesters.size(); i++) {
						if (lSemester==semesters.get(i).getTermId()) {%>
							<aui:option value='<%=semesters.get(i).getTermId()%>' selected="true"><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
						<%} else {%>
							<aui:option value='<%=semesters.get(i).getTermId()%>'><%=semesters.get(i).getPrefix()+"&nbsp;"+semesters.get(i).getYear()%></aui:option>
						<%}
					}%>
				</aui:select>
			<%}%>
			
			<%if(!readOnly){%>
				<!-- do not show creators yet! 
				<aui:input id="creator" name="creator" label="creators" required="false" />
				<div id="creators"></div>
				-->
			<%}%>
			
			<aui:input name="password" label="password" helpMessage="password-help-text" value="<%=lPassword%>"/>

			<aui:select id="videosort" size="1" name="videoSort" label="sortvideo">
				<aui:option value="1" selected="<%=isSortVideosASC%>" label="sortvideoAsc"></aui:option>		
				<aui:option value="0" selected="<%=!isSortVideosASC%>" label="sortvideoDesc"></aui:option>		
			</aui:select>
			
			<%if(!readOnly){%>
				<aui:field-wrapper label="description">
				    <liferay-ui:input-editor name="longDesc" toolbarSet="simple" initMethod="initEditor" cssClass="ta"/>
				    <script type="text/javascript">
				        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(lLongDesc) %>";}
				    </script>
				</aui:field-wrapper>
			<%}else{%>
				<%if(lLongDesc.trim().length()>0){%><aui:input type="textarea" name="longDesc" value="<%=lLongDesc%>" label="description" readonly="true"/><%}%>
			<%}%>
			<aui:button-row>
				<aui:button type="submit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
				<aui:button type="cancel" value="cancel" name="cancel"/>
			</aui:button-row>
			</div>
		</aui:layout>
	</aui:fieldset>
</aui:form>
</div>

<liferay-portlet:resourceURL id="getJSONCreator" var="getJSONCreatorURL" />
<liferay-portlet:resourceURL id="updateCreators" var="updateCreatorsURL" />

<script>
var c = 0;
/* these variables are set here but used in the external autocomplete-creator.js file, be sure to include this js AFTER the jsp is rendered*/
var allCreatorsInJQueryAutocompleteFormat = <%= allCreatorsJSON.toString()%>;
var getJSONCreatorURL = "<%=getJSONCreatorURL%>";
var namespace = "<portlet:namespace/>";
<%
String assignedCreators ="";
try{
	assignedCreators = CreatorLocalServiceUtil.getJSONCreatorsByLectureseriesId(reqLectureseries.getLectureseriesId()).toString();
}catch(Exception e){}
%>
var assignedCreators = "";
<c:if test="<%=assignedCreators.isEmpty()%>">assignedCreators = <%=assignedCreators%> </c:if>

function remb(c){
	$("#"+c).remove();
}
$(function () {
	autocompleteCreator($("#<portlet:namespace/>creator"));
});

$('#<portlet:namespace></portlet:namespace>cancel').click(function(){
	   window.location.href="<%=backURL.toString()%>";
});

AUI().use('aui-node',
  
function(A) {
	// Select the node(s) using a css selector string
    var contProduc = A.one('.prodCont');
    var contFacil = A.one('.facilCont');
    var producerId = A.one('#<portlet:namespace/>producerId');
    var crId = A.one('#<portlet:namespace/>crId');
    var institutionId = A.one('#<portlet:namespace/>institutionId');
    var newSemester = A.one('#<portlet:namespace/>newSemester');
    var allSemesters = A.one('#<portlet:namespace/>allSemesters');
    
    producerId.on(
      	'change',
      	function(A) {
  			if(producerId.get('value')>0){
  	   	 		var n = producerId.get(producerId.get('selectedIndex')).get('value');
  	    		var t = producerId.get(producerId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
  	  			contProduc.append("<div id='"+n+"'> "+t+" <a class='icon-large icon-remove' style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove(); resetProducer();'></a><input id='<portlet:namespace></portlet:namespace>producers' name='<portlet:namespace></portlet:namespace>producers' value='"+n+"' type='hidden'/></div>");
  			}
      	}
    );

    institutionId.on(
      	'change',
      	function(A) {
  			if(institutionId.get('value')>0){
  	   	 		var n = institutionId.get(institutionId.get('selectedIndex')).get('value');
  	    		var t = institutionId.get(institutionId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
  	    		contFacil.append("<div id='"+n+"'> "+t+" <a class='icon-large icon-remove' style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove(); resetInstitution();'></a><input id='<portlet:namespace></portlet:namespace>institutions' name='<portlet:namespace></portlet:namespace>institutions' value='"+n+"' type='hidden'/></div>");
  			}
      	}
    );
    
  }
);

function updateCreatorOnServer(jsonArray) {
	//set parameter to server for update 
	$.ajax({
		  type: "POST",
		  url: "<%=updateCreatorsURL%>",
		  dataType: 'json',
		  data: {
		 	   	<portlet:namespace/>creator: JSON.stringify(jsonArray)
		  },
		  global: false,
		  async:false,
		  success: function(data) {
		    //remove all creators 
		    $( "#creators" ).empty();
		    //and show new creators list
		    showCreatorsList(data);    
		  }
	})
}

function resetInstitution(){
	var l = $(".facilCont div").length;
    if(l==0){
    	$('#<portlet:namespace/>institutionId').prop('selectedIndex',0);
    }
}


function resetProducer(){
	var l = $(".prodCont div").length;
    if(l==0){
    	$('#<portlet:namespace/>producerId').prop('selectedIndex',0);
    }
}


function resetCreator(){
	var l = $(".creators div").length;
    if(l==0){
    	$('#<portlet:namespace/>crId').prop('selectedIndex',0);
    }
}

</script>

<%@include file="includeCreatorTemplates.jsp" %>