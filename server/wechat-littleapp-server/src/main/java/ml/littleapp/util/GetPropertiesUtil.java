package ml.littleapp.util;

import java.util.List;

public class GetPropertiesUtil {

	public static List<String> getIpSites() {
		String path = "src/main/resources/%s";
		String filePath = String.format(path, "crawler");
		String fileName = "ip.properties";
		String propertyName = "site";
		String defaultValue = "";

		List<String> propertyList = PropertiesUtil.getPropertyList(filePath, fileName, propertyName, defaultValue);
		return propertyList;
	}
}
