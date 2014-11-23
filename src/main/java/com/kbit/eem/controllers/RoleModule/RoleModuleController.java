package com.kbit.eem.controllers.RoleModule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kbit.eem.constants.ActionPaths;
import com.kbit.eem.constants.SessionVar;
import com.kbit.eem.constants.ViewNames;
import com.kbit.eem.controllers.BaseController;
import com.kbit.eem.models.ui.RoleModule.GroupModel;
import com.kbit.eem.models.ui.RoleModule.RoleModuleHelper;
import com.kbit.eem.models.ui.RoleModule.RoleModuleModel;
import com.kbit.eem.service.usermanagement.UserService;
import com.kbit.eem.utils.Convert;

@Controller
public class RoleModuleController extends BaseController {
	Logger logger = Logger.getLogger(RoleModuleController.class);
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = ActionPaths.RoleModule.ROLE_MODULE, method = RequestMethod.GET)
	public ModelAndView RoleModule(HttpServletRequest request,
			@RequestParam(value = "g", required = false) String groupId)
			throws Exception {
		try {
			String username = request.getUserPrincipal().getName();
			HttpSession session = request.getSession();
			List<RoleModuleModel> model = getRoleModules(session, username);
			if (groupId != null) {
				RoleModuleModel currModule = null;
				GroupModel currGroup = null;
				int gid = 0;

				if (Convert.CanConverToInt(groupId)) {
					gid = Integer.parseInt(groupId);
					// Check for module accessibility
					if (gid != 0) {
						Iterator<RoleModuleModel> modulesIterator = model
								.iterator();
						while (modulesIterator.hasNext()) {
							RoleModuleModel module = modulesIterator.next();
							GroupModel group = module.getGroup(gid);
							if (group != null) {
								currModule = module;
								currGroup = group;
								break;
							}
						}
						if ((currModule != null && currGroup != null && currGroup
								.getId() == gid)) {
							String groupPath = "/" + currGroup.getViewName();

							session.setAttribute(SessionVar.CURR_ROLE_MODULE,
									currModule);
							session.setAttribute(SessionVar.CURR_GROUP,
									currGroup);
							return new ModelAndView(getRedirectView(groupPath));
						}
					}
				}
			}
			return new ModelAndView(ViewNames.RoleModule.ROLE_MODULE_HOME,
					"model", model);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	private ArrayList<RoleModuleModel> getRoleModules(HttpSession session,
			String username) throws Exception {
		ArrayList<RoleModuleModel> modules = null;
		if (session != null) {
			modules = (ArrayList<RoleModuleModel>) session
					.getAttribute(SessionVar.ROLE_MODULES);
		}
		if (modules == null) {
			int[] subModuleIds = userService.getRoleSubModules(username);
			String path = "C:\\KBIT\\Workspace\\SprintApi\\eem\\src\\main\\resources\\SubModuleList.xml";
			modules = RoleModuleHelper.getModules(subModuleIds, path);
			session.setAttribute(SessionVar.ROLE_MODULES, modules);
		}
		return modules;
	}
}