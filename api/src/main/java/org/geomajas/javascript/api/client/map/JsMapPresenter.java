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
package org.geomajas.javascript.api.client.map;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.event.JsEventBus;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.map.MapPresenter}.
 *
 * @author Jan De Moerloose
 * @since 1.0.0
 */
@Api(allMethods = true)
public interface JsMapPresenter extends Exportable {

	/**
	 * Returns the {@link ViewPort} associated with this map. The view port regulates zooming and panning around the
	 * map, but also presents transformation methods for transforming vector objects between the different render
	 * spaces.
	 *
	 * @return Returns the view port.
	 */
	JsViewPort getViewPort();

	/**
	 * Returns the layers model for this presenter. This model is the central layer handler for the map, with methods
	 * for getting layers, moving them up and down, adding or removing layers, ..
	 *
	 * @return The layers model.
	 */
	JsLayersModel getLayersModel();

	/**
	 * Get the event bus that handles all event handlers and event firing for this map.
	 *
	 * @return The event bus that manages all event related to this map.
	 */
	JsEventBus getEventBus();

	/**
	 * Apply a new mouse cursor when hovering above the map.
	 *
	 * @param cursor
	 *            The new cursor to apply.
	 */
	void setCursor(String cursor);

}