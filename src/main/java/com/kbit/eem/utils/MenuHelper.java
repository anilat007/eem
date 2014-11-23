package com.kbit.eem.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MenuHelper {
	static Logger logger = Logger.getLogger(MenuHelper.class);

	public static List<ListMenuItem> getListMenu(String filePath) {
		List<ListMenuItem> menu = new ArrayList<ListMenuItem>();
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;

		try {
			builder = builderFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(new FileInputStream(filePath));
			xmlDoc.getDocumentElement().normalize();

			Element rootElement = xmlDoc.getDocumentElement();
			String rootPath = rootElement.getAttribute("rootPath");
			String i18idRoot = rootElement.getAttribute("i18idRoot");
			NodeList links = rootElement.getElementsByTagName("link");

			for (int i = 0; i < links.getLength(); i++) {
				Node node = links.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					String path = node.getAttributes().getNamedItem("path").getNodeValue();
					String name = node.getAttributes().getNamedItem("i18id").getNodeValue();
					menu.add(new ListMenuItem(i18idRoot + "." + name, "#" + path, rootPath + path));
				}
			}
		} catch (Exception e) {
			Helper.logError(logger, e);
			e.printStackTrace();
		}
		return menu;
	}
}
