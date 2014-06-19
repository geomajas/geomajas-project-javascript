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
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.map.MapConfiguration}.
 * 
 * @author Jan De Moerloose
 * @since 1.0.0
 */
@Api(allMethods = true)
public interface JsMapConfiguration extends Exportable {
	
	/**
	 * Convenience method that returns the maximum bounds/extent of this map.
	 *
	 * @return the maximum bounds
	 */
	Bbox getMaxBounds();

	/**
	 * Convenience method that sets the maximum bounds/extent of this map.  Do not change this value once the map has
	 * been initialized.
	 *
	 * @param maxBounds the maximum bounds
	 */
	void setMaxBounds(Bbox maxBounds);

	/**
	 * Convenience method that gets the coordinate reference system of this map (SRS notation).
	 *
	 * @return the CRS (SRS notation)
	 */
	String getCrs();

	/**
	 * Convenience method that sets the coordinate reference system of this map (SRS notation).  Do not change this
	 * value once the map has been initialized.
	 *
	 * @param crs     the CRS (SRS notation)
	 * @param crsType The type of CRS. Use this method if the units of the CRS are expressed in either meters or
	 *                degrees. Otherwise use the {@link #setCrs(String, double)} method.
	 */
	void setCrs(String crs, String crsType);

	/**
	 * Convenience method that sets the coordinate reference system of this map (SRS notation).  Do not change this
	 * value once the map has been initialized.
	 *
	 * @param crs        the CRS (SRS notation)
	 * @param unitLength The length of a single unit of this map in actual meters. This is an approximate value in the
	 *                   horizontal direction and in the initial center of the map. If the units of your CRS are
	 *                   expressed in either meters or degrees, you can use the convenience method {@link
	 *                   #setCrs(String, CrsType)}.
	 */
	void setCrs(String crs, double unitLength);

	/**
	 * Convenience method that returns the list of resolutions (inverse scale values) allowed by this map. This
	 * determines the predefined scale levels at which this map will be shown. If this list is non-empty, the map will
	 * not adjust to arbitrary scale levels but will instead snap to one of the scale levels defined in this list when
	 * zooming.
	 *
	 * @return a list of resolutions (unit/pixel or pure number if relative)
	 */
	double[] getResolutions();

	/**
	 * Convenience method that sets the list of resolutions (inverse scale values) allowed by this map. This determines
	 * the predefined scale levels at which this map will be shown. If this list is non-empty, the map will not adjust
	 * to arbitrary scale levels but will instead snap to one of the scale levels defined in this list when zooming. Do
	 * not change this value once the map has been initialized.
	 *
	 * @param resolutions a list of resolutions (unit/pixel)
	 */
	void setResolutions(double[] resolutions);

	/**
	 * Convenience method that returns the minimum resolution (maximum zoom in) of this map. This value is only required
	 * if no list of resolutions is specified.
	 *
	 * @return the minimum resolution (unit/pixel)
	 */
	double getMinimumResolution();

	/**
	 * Convenience method that sets the  minimum resolution (maximum zoom in) of this map. This value is only required
	 * if no resolutions are specified. Do not change this value once the map has been initialized.
	 *
	 * @param minimumResolution The minimum resolution (unit/pixel).
	 */
	void setMinimumResolution(double minimumResolution);
}