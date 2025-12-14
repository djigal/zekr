/*
 *               In the name of Allah
 * This file is part of The Zekr Project. Use is subject to
 * license terms.
 *
 * Author:         Mohsen Saboorian
 * Start Date:     Jan 29, 2007
 */
package net.sf.zekr.engine.template;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.apache.velocity.util.ExtProperties;

/**
 * A loader for templates stored on the file system.
 *
 * @author Mohsen Saboorian
 */
public class ZekrFileResourceLoader extends ResourceLoader {
	@Override
	public void init(ExtProperties configuration) {
		// do nothing
	}

	public synchronized InputStream getResourceStream(String templateName) throws ResourceNotFoundException {
		InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(new File(templateName).getAbsolutePath()));
		} catch (FileNotFoundException e) {
			// do nothing!
		}
		if (is != null) // if no exception occurred
			return is;

		throw new ResourceNotFoundException("Resource not found: " + templateName);
	}

	/**
	 * Get a Reader for the given template name with specified encoding.
	 * Required by Velocity 2.x ResourceLoader interface.
	 *
	 * @param name the template name
	 * @param encoding the encoding to use
	 * @return a Reader for the template
	 * @throws ResourceNotFoundException if template not found
	 */
	@Override
	public Reader getResourceReader(String name, String encoding) throws ResourceNotFoundException {
		InputStream is = getResourceStream(name);
		try {
			return new BufferedReader(new InputStreamReader(is, encoding));
		} catch (UnsupportedEncodingException e) {
			throw new ResourceNotFoundException("Unsupported encoding: " + encoding, e);
		}
	}

	@Override
	public boolean isSourceModified(Resource resource) {
		return false;
	}

	@Override
	public long getLastModified(Resource resource) {
		File file = new File(resource.getName());
		return file.canRead() ? file.lastModified() : 0;
	}
}
