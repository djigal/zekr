/*
 *               In the name of Allah
 * This file is part of The Zekr Project. Use is subject to
 * license terms.
 *
 * Author:         Mohsen Saboorian
 * Start Date:     Aug 4, 2005
 */
package net.sf.zekr.common.config;

import java.io.InputStreamReader;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.io.FileHandler;
import org.apache.commons.lang.StringUtils;

/**
 * This class is used to handle dynamic resource bundles which use <i>Velocity</i> as the template engine.
 * 
 * @author Mohsen Saboorian
 */
public class ResourceManager {
	private static ResourceManager thisInstance;
	private static PropertiesConfiguration resource;

	private ResourceManager() {
		try {
			resource = new PropertiesConfiguration();
			FileHandler handler = new FileHandler(resource);
			handler.setEncoding("utf-8");
			handler.load(new InputStreamReader(new VelocityInputStream("resource-path.properties"), "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized ResourceManager getInstance() {
		if (thisInstance == null)
			return (thisInstance = new ResourceManager());
		return thisInstance;
	}

	public String getString(String key) {
		return getString(key, (String) null);
	}

	/**
	 * @param key
	 *           key to find in resource
	 * @param value
	 *           value to be returned if key not found
	 * @return related entry in the resource file, or value if key not found.
	 */
	public String getString(String key, String value) {
		String ret = resource.getString(key);
		return ret == null ? value : ret;
	}

	public String[] getStrings(String key) {
		String[] values = resource.getStringArray(key);
		// Commons Configuration2 doesn't automatically split comma-separated values
		// If we got a single value with commas, split it manually for backward compatibility
		if (values.length == 1 && values[0] != null && values[0].contains(",")) {
			String[] split = values[0].split("\\s*,\\s*");
			return split;
		}
		return values;
	}

	public String getString(String key, Object[] strArray) {
		String val = getString(key);
		for (int i = 0; i < strArray.length; i++) {
			val = StringUtils.replace(val, "{" + (i + 1) + "}", strArray[i].toString());
		}
		return val;
	}
}
