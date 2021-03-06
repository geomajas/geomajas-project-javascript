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
package org.geomajas.javascript.api.client.spatial;

import org.geomajas.annotation.Api;
import org.geomajas.geometry.Coordinate;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportOverlay;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.geometry.Coordinate}.
 * 
 * @author Jan De Moerloose
 * @since 1.0.0
 */
@Export("Coordinate")
@ExportPackage("gm")
@Api
public class JsCoordinate implements ExportOverlay<Coordinate>, Exportable {

	/**
	 * Constructor.
	 *
	 * @param x x
	 * @param y y
	 * @return coordinate
	 */
	@ExportConstructor
	public static Coordinate constructor(double x, double y) {
		return new Coordinate(x, y);
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public boolean equals(Object other) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	/**
	 * Get distance with other coordinate.
	 *
	 * @param c other coordinate
	 * @return distance
	 */
	public double distance(Coordinate c) {
		return 0;
	}

	/**
	 * Get x.
	 *
	 * @return x
	 */
	public double getX() {
		return 0;
	}

	/**
	 * Get y.
	 *
	 * @return y
	 */
	public double getY() {
		return 0;
	}

	/**
	 * Set x.
	 *
	 * @param x x
	 */
	public void setX(double x) {
	}

	/**
	 * Set y.
	 *
	 * @param y y
	 */
	public void setY(double y) {
	}
}