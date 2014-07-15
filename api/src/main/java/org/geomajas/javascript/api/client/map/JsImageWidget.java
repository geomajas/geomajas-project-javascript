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
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt2.client.gfx.TransformableWidget;
import org.geomajas.javascript.api.client.event.JsImageWidgetDeselectedHandler;
import org.geomajas.javascript.api.client.event.JsImageWidgetSelectedHandler;
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
public interface JsImageWidget extends Exportable, TransformableWidget {

	/**
	 * Add a handler that reacts to the widget being selected.
	 *
	 * @param handler The handler.
	 */
	void addWidgetSelectedHandler(JsImageWidgetSelectedHandler handler);

	/**
	 * Add a handler that reacts to the widget being deselected.
	 *
	 * @param handler The handler.
	 */
	void addWidgetDeselectedHandler(JsImageWidgetDeselectedHandler handler);

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

}
