/*
 * This is part of Geomajas, a GIS framework, http://www.geomajas.org/.
 *
 * Copyright 2008-2015 Geosparc nv, http://www.geosparc.com/, Belgium.
 *
 * The program is available in open source according to the GNU Affero
 * General Public License. All contributions in this program are covered
 * by the Geomajas Contributors License Agreement. For full licensing
 * details, see LICENSE.txt in the project root.
 */
package org.geomajas.javascript.gwt2.impl.client;

import com.google.gwt.core.client.EntryPoint;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsVectorServerLayerFactoryImpl;

/**
 * GWT entry point for the general JavaScript API.
 * 
 * @author Pieter De Graef
 */
public class JavascriptServerExtensionsEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		JsGwtImpl.getInstance().getJsLayerFactoryRegistry().
				registerJsLayerFactory(new JsVectorServerLayerFactoryImpl());
	}
}