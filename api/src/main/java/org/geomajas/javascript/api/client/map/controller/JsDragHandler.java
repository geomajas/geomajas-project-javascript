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

package org.geomajas.javascript.api.client.map.controller;

import com.google.gwt.event.dom.client.HumanInputEvent;
import org.geomajas.annotation.Api;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.Exportable;

/**
 * JavaScript exportable handler for catching drag events (move while first mouse button is down, or touch move).
 *
 * @author Pieter De Graef
 * @since 1.0.0
 */
@Export
@ExportClosure
@Api(allMethods = true)
public interface JsDragHandler extends Exportable {

	/**
	 * Executed when a drag event occurred.
	 *
	 * @param event
	 *            The drag event.
	 */
	void onDrag(HumanInputEvent<?> event);
}