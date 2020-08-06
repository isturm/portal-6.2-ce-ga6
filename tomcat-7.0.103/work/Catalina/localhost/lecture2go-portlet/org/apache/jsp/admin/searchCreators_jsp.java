/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.103
 * Generated at: 2020-07-03 08:34:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Collections;
import java.util.Locale;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Date;
import java.util.ListIterator;
import java.util.TreeMap;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;
import de.uhh.l2g.plugins.util.HTMLFilter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.PwdGenerator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchEntry;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.User;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.util.portlet.PortletRequestUtil;
import com.liferay.portlet.PortletURLUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.GetterUtil;
import org.apache.jasper.JasperException;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.scripting.config.LangNamespaceUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.portlet.bind.PortletRequestUtils;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import de.uhh.l2g.plugins.admin.AdminInstitutionManagement;
import de.uhh.l2g.plugins.admin.AdminStreamerManagement;
import de.uhh.l2g.plugins.admin.AdminUserManagement;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Producer_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.SegmentLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.NoSuchMetadataException;
import de.uhh.l2g.plugins.model.impl.HostImpl;
import de.uhh.l2g.plugins.model.Video_Category;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Segment;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Producer_Lectureseries;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.impl.ProducerImpl;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.Lectureseries_Institution;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.util.Lecture2GoRoleChecker;
import de.uhh.l2g.plugins.util.Security;
import de.uhh.l2g.plugins.util.VideoProcessorManager;
import de.uhh.l2g.plugins.search.VideoSearchContainer;
import de.uhh.l2g.plugins.search.VideoDisplayTerms;
import de.uhh.l2g.plugins.search.VideoSearchHelper;
import de.uhh.l2g.plugins.search.UserSearchContainer;
import de.uhh.l2g.plugins.search.UserDisplayTerms;
import de.uhh.l2g.plugins.search.UserSearchHelper;
import de.uhh.l2g.plugins.search.CreatorSearchContainer;
import de.uhh.l2g.plugins.search.CreatorDisplayTerms;
import de.uhh.l2g.plugins.search.CreatorSearchHelper;
import de.uhh.l2g.plugins.search.CreatorSearchContainer;
import de.uhh.l2g.plugins.search.CreatorDisplayTerms;

public final class searchCreators_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

com.liferay.portal.kernel.dao.search.SearchContainer<User> searchContainer = null;
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(8);
    _jspx_dependants.put("/WEB-INF/tld/liferay-portlet.tld", Long.valueOf(1593695681000L));
    _jspx_dependants.put("/init.jsp", Long.valueOf(1593695680000L));
    _jspx_dependants.put("/WEB-INF/tld/liferay-portlet-ext.tld", Long.valueOf(1593695681000L));
    _jspx_dependants.put("/WEB-INF/tld/liferay-theme.tld", Long.valueOf(1593695681000L));
    _jspx_dependants.put("/WEB-INF/tld/liferay-util.tld", Long.valueOf(1593695681000L));
    _jspx_dependants.put("/WEB-INF/tld/aui.tld", Long.valueOf(1593695681000L));
    _jspx_dependants.put("/WEB-INF/tld/liferay-ui.tld", Long.valueOf(1593695681000L));
    _jspx_dependants.put("/WEB-INF/tld/liferay-security.tld", Long.valueOf(1593695681000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fliferay_002dtheme_005fdefineObjects_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fliferay_002dui_005fsearch_002dtoggle_0026_005fid_005fdisplayTerms_005fbuttonLabel;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fliferay_002dtheme_005fdefineObjects_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fliferay_002dui_005fsearch_002dtoggle_0026_005fid_005fdisplayTerms_005fbuttonLabel = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody.release();
    _005fjspx_005ftagPool_005fliferay_002dtheme_005fdefineObjects_005fnobody.release();
    _005fjspx_005ftagPool_005fliferay_002dui_005fsearch_002dtoggle_0026_005fid_005fdisplayTerms_005fbuttonLabel.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      //  portlet:defineObjects
      com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_005fdefineObjects_005f0 = (com.liferay.taglib.portlet.DefineObjectsTag) _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
      _jspx_th_portlet_005fdefineObjects_005f0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_005fdefineObjects_005f0.setParent(null);
      int _jspx_eval_portlet_005fdefineObjects_005f0 = _jspx_th_portlet_005fdefineObjects_005f0.doStartTag();
      if (_jspx_th_portlet_005fdefineObjects_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody.reuse(_jspx_th_portlet_005fdefineObjects_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fportlet_005fdefineObjects_005fnobody.reuse(_jspx_th_portlet_005fdefineObjects_005f0);
      javax.portlet.ActionRequest actionRequest = null;
      javax.portlet.ActionResponse actionResponse = null;
      javax.portlet.EventRequest eventRequest = null;
      javax.portlet.EventResponse eventResponse = null;
      com.liferay.portal.kernel.portlet.LiferayPortletRequest liferayPortletRequest = null;
      com.liferay.portal.kernel.portlet.LiferayPortletResponse liferayPortletResponse = null;
      javax.portlet.PortletConfig portletConfig = null;
      java.lang.String portletName = null;
      javax.portlet.PortletPreferences portletPreferences = null;
      java.util.Map portletPreferencesValues = null;
      javax.portlet.PortletSession portletSession = null;
      java.util.Map portletSessionScope = null;
      javax.portlet.RenderRequest renderRequest = null;
      javax.portlet.RenderResponse renderResponse = null;
      javax.portlet.ResourceRequest resourceRequest = null;
      javax.portlet.ResourceResponse resourceResponse = null;
      com.liferay.portal.kernel.util.SearchContainerReference searchContainerReference = null;
      actionRequest = (javax.portlet.ActionRequest) _jspx_page_context.findAttribute("actionRequest");
      actionResponse = (javax.portlet.ActionResponse) _jspx_page_context.findAttribute("actionResponse");
      eventRequest = (javax.portlet.EventRequest) _jspx_page_context.findAttribute("eventRequest");
      eventResponse = (javax.portlet.EventResponse) _jspx_page_context.findAttribute("eventResponse");
      liferayPortletRequest = (com.liferay.portal.kernel.portlet.LiferayPortletRequest) _jspx_page_context.findAttribute("liferayPortletRequest");
      liferayPortletResponse = (com.liferay.portal.kernel.portlet.LiferayPortletResponse) _jspx_page_context.findAttribute("liferayPortletResponse");
      portletConfig = (javax.portlet.PortletConfig) _jspx_page_context.findAttribute("portletConfig");
      portletName = (java.lang.String) _jspx_page_context.findAttribute("portletName");
      portletPreferences = (javax.portlet.PortletPreferences) _jspx_page_context.findAttribute("portletPreferences");
      portletPreferencesValues = (java.util.Map) _jspx_page_context.findAttribute("portletPreferencesValues");
      portletSession = (javax.portlet.PortletSession) _jspx_page_context.findAttribute("portletSession");
      portletSessionScope = (java.util.Map) _jspx_page_context.findAttribute("portletSessionScope");
      renderRequest = (javax.portlet.RenderRequest) _jspx_page_context.findAttribute("renderRequest");
      renderResponse = (javax.portlet.RenderResponse) _jspx_page_context.findAttribute("renderResponse");
      resourceRequest = (javax.portlet.ResourceRequest) _jspx_page_context.findAttribute("resourceRequest");
      resourceResponse = (javax.portlet.ResourceResponse) _jspx_page_context.findAttribute("resourceResponse");
      searchContainerReference = (com.liferay.portal.kernel.util.SearchContainerReference) _jspx_page_context.findAttribute("searchContainerReference");
      out.write('\n');
      //  liferay-theme:defineObjects
      com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay_002dtheme_005fdefineObjects_005f0 = (com.liferay.taglib.theme.DefineObjectsTag) _005fjspx_005ftagPool_005fliferay_002dtheme_005fdefineObjects_005fnobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
      _jspx_th_liferay_002dtheme_005fdefineObjects_005f0.setPageContext(_jspx_page_context);
      _jspx_th_liferay_002dtheme_005fdefineObjects_005f0.setParent(null);
      int _jspx_eval_liferay_002dtheme_005fdefineObjects_005f0 = _jspx_th_liferay_002dtheme_005fdefineObjects_005f0.doStartTag();
      if (_jspx_th_liferay_002dtheme_005fdefineObjects_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fliferay_002dtheme_005fdefineObjects_005fnobody.reuse(_jspx_th_liferay_002dtheme_005fdefineObjects_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fliferay_002dtheme_005fdefineObjects_005fnobody.reuse(_jspx_th_liferay_002dtheme_005fdefineObjects_005f0);
      com.liferay.portal.theme.ThemeDisplay themeDisplay = null;
      com.liferay.portal.model.Company company = null;
      com.liferay.portal.model.Account account = null;
      com.liferay.portal.model.User user = null;
      com.liferay.portal.model.User realUser = null;
      com.liferay.portal.model.Contact contact = null;
      com.liferay.portal.model.Layout layout = null;
      java.util.List layouts = null;
      java.lang.Long plid = null;
      com.liferay.portal.model.LayoutTypePortlet layoutTypePortlet = null;
      java.lang.Long scopeGroupId = null;
      com.liferay.portal.security.permission.PermissionChecker permissionChecker = null;
      java.util.Locale locale = null;
      java.util.TimeZone timeZone = null;
      com.liferay.portal.model.Theme theme = null;
      com.liferay.portal.model.ColorScheme colorScheme = null;
      com.liferay.portal.theme.PortletDisplay portletDisplay = null;
      java.lang.Long portletGroupId = null;
      themeDisplay = (com.liferay.portal.theme.ThemeDisplay) _jspx_page_context.findAttribute("themeDisplay");
      company = (com.liferay.portal.model.Company) _jspx_page_context.findAttribute("company");
      account = (com.liferay.portal.model.Account) _jspx_page_context.findAttribute("account");
      user = (com.liferay.portal.model.User) _jspx_page_context.findAttribute("user");
      realUser = (com.liferay.portal.model.User) _jspx_page_context.findAttribute("realUser");
      contact = (com.liferay.portal.model.Contact) _jspx_page_context.findAttribute("contact");
      layout = (com.liferay.portal.model.Layout) _jspx_page_context.findAttribute("layout");
      layouts = (java.util.List) _jspx_page_context.findAttribute("layouts");
      plid = (java.lang.Long) _jspx_page_context.findAttribute("plid");
      layoutTypePortlet = (com.liferay.portal.model.LayoutTypePortlet) _jspx_page_context.findAttribute("layoutTypePortlet");
      scopeGroupId = (java.lang.Long) _jspx_page_context.findAttribute("scopeGroupId");
      permissionChecker = (com.liferay.portal.security.permission.PermissionChecker) _jspx_page_context.findAttribute("permissionChecker");
      locale = (java.util.Locale) _jspx_page_context.findAttribute("locale");
      timeZone = (java.util.TimeZone) _jspx_page_context.findAttribute("timeZone");
      theme = (com.liferay.portal.model.Theme) _jspx_page_context.findAttribute("theme");
      colorScheme = (com.liferay.portal.model.ColorScheme) _jspx_page_context.findAttribute("colorScheme");
      portletDisplay = (com.liferay.portal.theme.PortletDisplay) _jspx_page_context.findAttribute("portletDisplay");
      portletGroupId = (java.lang.Long) _jspx_page_context.findAttribute("portletGroupId");
      out.write('\n');
      out.write('\n');

	//check lecture2go user permissions
	User remoteUser = UserLocalServiceUtil.createUser(0);
	//l2go administrator is logged in
	boolean permissionAdmin = false;
	//l2go coordinator is logged in
	boolean permissionCoordinator = false;
	//l2go producer is logged in
	boolean permissionProducer = false;
	//l2go student is logged in
	boolean permissionStudent = false;
	//l2go producerPending is logged in
	boolean permissionProducerPending = false;

	try{
		Lecture2GoRoleChecker rcheck = new Lecture2GoRoleChecker();
		remoteUser = UserLocalServiceUtil.getUser(new Long (request.getRemoteUser()));
		permissionAdmin = rcheck.isL2gAdmin(remoteUser);
		permissionCoordinator = rcheck.isCoordinator(remoteUser);
		permissionProducer = rcheck.isProducer(remoteUser);
		permissionStudent = rcheck.isStudent(remoteUser);
		permissionProducerPending = rcheck.isProducerPending(remoteUser);
		if(permissionAdmin){
			permissionCoordinator=false;
			permissionProducer=false;
			permissionStudent=false;
		}else{
			if(permissionCoordinator){
				permissionProducer=false;
				permissionStudent=false;		
			}else{
				if(permissionProducer){
					permissionStudent=false;
				}
			}
		}
		PortletPreferences prefs = renderRequest.getPreferences();	
	}catch(Exception e){
		//
	}

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

	CreatorSearchContainer searchContainer = (CreatorSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	CreatorDisplayTerms displayTerms = (CreatorDisplayTerms)searchContainer.getDisplayTerms();
	String title = LanguageUtil.get(pageContext, "search-creators");

      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("<!--\n");
      out.write("\t#toggle_id_creator_searchtoggleAdvanced {\n");
      out.write("\t    display: none;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.form-search .input-append .advanced-search .search-query {\n");
      out.write("\t    padding-left: 10px;\n");
      out.write("\t    width: 160px;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.taglib-search-toggle {\n");
      out.write("\t    margin-top: -17px;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.advanced-search > button.btn {\n");
      out.write("\t    visibility: hidden;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t#toggle_id_creator_searchkeywords {\n");
      out.write("\t    border-radius: 0;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t#modifiedSearch {\n");
      out.write("\t    float: right;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.lfr-search-container {\n");
      out.write("\t    margin-top: 0;\n");
      out.write("\t    overflow: auto;\n");
      out.write("\t    float: left;\n");
      out.write("\t    width: 100%;\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t.advanced-search {\n");
      out.write("\t    width: 187px;\n");
      out.write("\t    padding: 0 !important;\n");
      out.write("\t    margin: 0 !important;\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t.add-link {\n");
      out.write("\t    position: relative;\n");
      out.write("\t    float: left;\n");
      out.write("\t    margin-top: 8px;\n");
      out.write("\t}\t\n");
      out.write("\t\n");
      out.write("\t.alert.alert-info {\n");
      out.write("\t    margin-top: 0px;\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("    .aui .alert {\n");
      out.write("        border-width: 0;\n");
      out.write("    }\n");
      out.write("\t\n");
      out.write("-->\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function (){\n");
      out.write("\t\tvar t = \"");
      out.print(title);
      out.write("\";\n");
      out.write("\t\t$(\"#toggle_id_creator_searchkeywords\").attr(\"placeholder\", t);\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("\n");
      //  liferay-ui:search-toggle
      com.liferay.taglib.ui.SearchToggleTag _jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0 = (com.liferay.taglib.ui.SearchToggleTag) _005fjspx_005ftagPool_005fliferay_002dui_005fsearch_002dtoggle_0026_005fid_005fdisplayTerms_005fbuttonLabel.get(com.liferay.taglib.ui.SearchToggleTag.class);
      _jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0.setPageContext(_jspx_page_context);
      _jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0.setParent(null);
      // /admin/searchCreators.jsp(76,0) name = buttonLabel type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0.setButtonLabel("");
      // /admin/searchCreators.jsp(76,0) name = displayTerms type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0.setDisplayTerms( displayTerms );
      // /admin/searchCreators.jsp(76,0) name = id type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0.setId("toggle_id_creator_search");
      int _jspx_eval_liferay_002dui_005fsearch_002dtoggle_005f0 = _jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0.doStartTag();
      if (_jspx_eval_liferay_002dui_005fsearch_002dtoggle_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\n');
      }
      if (_jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fliferay_002dui_005fsearch_002dtoggle_0026_005fid_005fdisplayTerms_005fbuttonLabel.reuse(_jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fliferay_002dui_005fsearch_002dtoggle_0026_005fid_005fdisplayTerms_005fbuttonLabel.reuse(_jspx_th_liferay_002dui_005fsearch_002dtoggle_005f0);
      out.write('\n');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
