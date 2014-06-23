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
import org.geomajas.geometry.Bbox;
import org.geomajas.geometry.Coordinate;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.map.ViewPort}.
 *
 * @author Jan De Moerloose
 * @since 1.0.0
 */
@Api(allMethods = true)
public interface JsViewPort extends Exportable {

	/**
	 * Get the current center position expressed in world space.
	 *
	 * @return The current center position expressed in world space.
	 */
	Coordinate getPosition();

	/**
	 * Return the current resolution of the map.
	 */
	double getResolution();

	/**
	 * Return the currently visible bounds on the map. These bounds are expressed in the CRS of the map.
	 *
	 * @return Returns the maps bounding box.
	 */
	Bbox getBounds();

	/**
	 * Re-centers the map to a new position.
	 *
	 * @param coordinate
	 *            the new center position
	 */
	void applyPosition(Coordinate coordinate);

	/**
	 * Apply a new resolution level on the map. This value needs to be between the minimum and maximum allowed
	 * resolution, but is totally free otherwise. It will not be constrained to fixed resolutions.
	 *
	 * @param resolution The preferred new scale.
	 */
	void applyResolution(double resolution);

	/**
	 * <p>
	 * Change the view on the map by applying a bounding box (world coordinates!). Since the width/height ratio of the
	 * bounding box may differ from that of the map, the fit is "as good as possible".
	 * </p>
	 * <p>
	 * Also this function will almost certainly change the scale on the map, so if there have been resolutions defined,
	 * it will snap to them.
	 * </p>
	 *
	 * @param bounds
	 *            A bounding box in world coordinates that determines the view from now on.
	 */
	void applyBounds(Bbox bounds);

	/**
	 * Get the maximum zooming extent that is allowed on this view port. These bounds are determined by the map
	 * configuration.
	 *
	 * @return The maximum zooming extent that is allowed on this view port.
	 */
	Bbox getMaximumBounds();

	/**
	 *
	 * @return
	 */
	JsViewPortTransformationService getTransformationService();

}