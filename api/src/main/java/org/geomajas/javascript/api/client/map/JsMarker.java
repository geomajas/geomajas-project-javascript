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

import com.google.gwt.dom.client.Element;
import org.geomajas.annotation.Api;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt2.client.gfx.TransformableWidget;
import org.geomajas.javascript.api.client.event.JsMarkerDeselectedHandler;
import org.geomajas.javascript.api.client.event.JsMarkerSelectedHandler;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

/**
 * Interface for a transformable image widget.
 *
 * @author Youri Flement
 * @since 1.0.0
 */
@Export
@Api(allMethods = true)
public interface JsMarker extends Exportable, TransformableWidget {

	/**
	 * Add a handler that reacts to the widget being selected.
	 *
	 * @param handler The handler.
	 */
	void addWidgetSelectedHandler(JsMarkerSelectedHandler handler);

	/**
	 * Add a handler that reacts to the widget being deselected.
	 *
	 * @param handler The handler.
	 */
	void addWidgetDeselectedHandler(JsMarkerDeselectedHandler handler);

	/**
	 * Set the world coordinate of the widget.
	 *
	 * @param coordinate The new world coordinate.
	 */
	void setCoordinate(Coordinate coordinate);

	/**
	 * Get the world coordinate of the widget.
	 *
	 * @return The world coordinate.
	 */
	Coordinate getCoordinate();

	/**
	 * Select cause all on selected handlers to be called.
	 *
	 */
	void select();

	/**
	 * Select cause all on unselected handlers to be called.
	 */
	void deselect();

	/**
	 * Get dom element of the marker widget.
	 *
	 * @return {@link com.google.gwt.dom.client.Element}
	 */
	Element getElement();

}
