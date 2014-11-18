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
package org.geomajas.javascript.gwt2.impl.client.map.controller;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;

/**
 * Controller that alows user to draw a rectangle on the map.
 * This results in a {@link org.geomajas.javascript.api.client.spatial.JsBbox}, that will be passed to
 * a {@link JsRectangleControllerCallback}.
 *
 * @author Jan Venstermans
 */
@Export("RectangleController")
@ExportPackage("gm.controller")
public class JsRectangleController extends JsMapControllerWrapperImpl {

	public JsRectangleController() {
		super(new RectangleControllerWrapper());
	}

	/**
	 * Callback that will be passed to {@link RectangleControllerWrapper}.
	 * @param callback
	 */
	public void setCallback(JsRectangleControllerCallback callback) {
		((RectangleControllerWrapper) getMapController()).setCallback(callback);
	}
}
