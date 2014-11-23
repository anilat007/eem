package com.kbit.eem.models.ui.RoleModule;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class RoleModuleHelper {
	static Logger logger = Logger.getLogger(RoleModuleHelper.class);

	public static SubModuleMapModel getSubModuleMap(int[] subModuleIds,
			String filePath) throws Exception {
		SubModuleMapModel subModuleMap = new SubModuleMapModel();
		Class<?> clazz = subModuleMap.getClass();
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		try {

			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(new FileInputStream(filePath));
			xmlDoc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();

			for (int i = 0, len = subModuleIds.length; i < len; i++) {
				int subModuleId = subModuleIds[i];
				String expression = "/moduleData/submodules/submodule[@id='%d']";

				Node nodeSubModule = (Node) xPath.compile(
						String.format(expression, subModuleId)).evaluate(
						xmlDoc, XPathConstants.NODE);

				String propertyPath = nodeSubModule.getAttributes()
						.getNamedItem("propertyPath").getNodeValue();

				Field field = clazz.getDeclaredField(propertyPath);
				field.setAccessible(true);
				field.set(subModuleMap, true);
			}
			return subModuleMap;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public static ArrayList<RoleModuleModel> getModules(int[] subModuleIds,
			String filePath) throws Exception {
		HashMap<Integer, RoleModuleModel> mapModules = new HashMap<Integer, RoleModuleModel>();
		HashMap<Integer, GroupModel> mapGroups = new HashMap<Integer, GroupModel>();
		ArrayList<RoleModuleModel> modules = new ArrayList<RoleModuleModel>();

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;

		try {

			builder = builderFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(new FileInputStream(filePath));
			xmlDoc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();

			for (int i = 0, len = subModuleIds.length; i < len; i++) {
				int subModuleId = subModuleIds[i];
				String expression = "/moduleData/submodules/submodule[@id='%d']";

				Node nodeSubModule = (Node) xPath.compile(
						String.format(expression, subModuleId)).evaluate(
						xmlDoc, XPathConstants.NODE);

				// Scan and set module
				int moduleId = Integer.parseInt(nodeSubModule.getAttributes()
						.getNamedItem("moduleId").getNodeValue());
				Integer intModuleId = new Integer(moduleId);
				RoleModuleModel module = mapModules.get(intModuleId);
				if (module == null) {
					expression = "/moduleData/modules/module[@id='%d']";
					Node nodeModule = (Node) xPath.compile(
							String.format(expression, moduleId)).evaluate(
							xmlDoc, XPathConstants.NODE);

					String moduelName = nodeModule.getAttributes()
							.getNamedItem("name").getNodeValue();
					String moduelImageName = nodeModule.getAttributes()
							.getNamedItem("image").getNodeValue();
					module = new RoleModuleModel(moduleId, moduelName,
							moduelImageName, new ArrayList<GroupModel>());
					mapModules.put(intModuleId, module);
					modules.add(module);
				}

				// Scan and set group
				int groupId = Integer.parseInt(nodeSubModule.getAttributes()
						.getNamedItem("groupId").getNodeValue());
				Integer intGroupId = new Integer(groupId);
				GroupModel group = mapGroups.get(intGroupId);
				if (group == null) {
					expression = "/moduleData/groups/group[@id='%d']";
					Node nodeGroup = (Node) xPath.compile(
							String.format(expression, groupId)).evaluate(
							xmlDoc, XPathConstants.NODE);

					String groupName = nodeGroup.getAttributes()
							.getNamedItem("name").getNodeValue();
					String groupViewName = nodeGroup.getAttributes()
							.getNamedItem("viewName").getNodeValue();

					group = new GroupModel(groupId, groupName, moduleId);
					group.setViewName(groupViewName);
					mapGroups.put(intGroupId, group);
					module.addGroup(group);
				}
			}
			return modules;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw ex;
		}
	}
}
