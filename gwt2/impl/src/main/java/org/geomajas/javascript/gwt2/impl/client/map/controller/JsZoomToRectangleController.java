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
package org.geomajas.javascript.gwt2.impl.client.map.controller;

import org.geomajas.gwt2.client.controller.ZoomToRectangleController;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;

/**
 * Controller that adds zoom to recrangle control to the map.
 *
 * @author Oliver May
 */
@Export("ZoomToRectangleController")
@ExportPackage("gm.controller")
public class JsZoomToRectangleController extends JsMapControllerWrapperImpl {

	public JsZoomToRectangleController() {
		super(new ZoomToRectangleController());
	}

}
