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
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.map.ViewPortTransformationService}.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Api(allMethods = true)
public interface JsViewPortTransformationService extends Exportable {

	/**
	 * Transform the given coordinate from a certain rendering space to another.
	 *
	 * @param coordinate
	 *            The coordinate to transform. The X and Y ordinates are expected to be expressed in the 'from'
	 *            rendering space.
	 * @param from
	 *            The rendering space that expresses the X and Y ordinates of the given coordinate.
	 * @param to
	 *            The rendering space where to the coordinate should be transformed.
	 * @return The transformed coordinate.
	 */
	Coordinate transform(Coordinate coordinate, JsRenderSpace from, JsRenderSpace to);

}