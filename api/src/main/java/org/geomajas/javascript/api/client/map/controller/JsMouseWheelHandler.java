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

package org.geomajas.javascript.api.client.map.controller;

import com.google.gwt.event.dom.client.MouseWheelEvent;
import org.geomajas.annotation.Api;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.Exportable;

/**
 * JavaScript exportable handler for catching mouse wheel events.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Export
@ExportClosure
@Api(allMethods = true)
public interface JsMouseWheelHandler extends Exportable {

	/**
	 * Executed when a mouse wheel event occurred.
	 *
	 * @param event
	 *            The mouse wheel event.
	 */
	void onMouseWheel(MouseWheelEvent event);
}