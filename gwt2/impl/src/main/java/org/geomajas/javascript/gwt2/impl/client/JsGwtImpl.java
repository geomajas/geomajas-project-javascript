/*
 * This is part of Geomajas, a GIS framework, http://www.geomajas.org/.
 *
 * Copyright 2008-2014 Geosparc nv, http://www.geosparc.com/, Belgium.
 *
 * The program is available in open source according to the GNU Affero
 * General Public License. All contributions in this program are covered
 * by the Geomajas Contributors License Agreement. For full licensing
 * details, see LICENSE.txt in the project root.
 */

package org.geomajas.javascript.gwt2.impl.client;

import org.geomajas.javascript.gwt2.impl.client.map.layer.JsLayerFactoryRegistry;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsLayerFactoryRegistryImpl;
import org.geomajas.javascript.gwt2.impl.client.util.JsGwtUtil;
import org.geomajas.javascript.gwt2.impl.client.util.JsGwtUtilImpl;

/**
 * Start class for Javascript Gwt2 implementation.
 *
 * @author Jan Venstermans
 */
public final class JsGwtImpl {

	private static JsGwtImpl instance = new JsGwtImpl();

	private JsLayerFactoryRegistry jsLayerFactoryRegistry;
	private JsGwtUtil jsGwtUtil;

	private JsGwtImpl() {
	}

	public static JsGwtImpl getInstance() {
		return instance;
	}

	public JsLayerFactoryRegistry getJsLayerFactoryRegistry() {
		if (jsLayerFactoryRegistry == null) {
			jsLayerFactoryRegistry = new JsLayerFactoryRegistryImpl();
		}
		return jsLayerFactoryRegistry;
	}

	public void setJsLayerFactoryRegistry(JsLayerFactoryRegistry jsLayerFactoryRegistry) {
		this.jsLayerFactoryRegistry = jsLayerFactoryRegistry;
	}

	public JsGwtUtil getJsGwtUtil() {
		if (jsGwtUtil == null) {
			jsGwtUtil = JsGwtUtilImpl.getInstance();
		}
		return jsGwtUtil;
	}

	public void setJsGwtUtil(JsGwtUtil jsGwtUtil) {
		this.jsGwtUtil = jsGwtUtil;
	}
}