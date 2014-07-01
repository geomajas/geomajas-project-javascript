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
package org.geomajas.javascript.gwt2.impl.client.map.layer.tile;

import org.geomajas.annotation.Api;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt2.client.map.layer.tile.TileConfiguration;
import org.geomajas.javascript.gwt2.impl.client.map.JsViewPortImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Javascript exportable implementation of a {@link org.geomajas.gwt2.client.map.layer.tile.TileConfiguration}.
 *
 * @author Dosi Bignov
 * @since 1.0.0
 */
@Export("TileConfiguration")
@ExportPackage("gm.layer")
@Api(allMethods = true)
public final class JsTileConfiguration implements Exportable {
	private TileConfiguration configuration;

	private JsTileConfiguration() {
	}

	/**
	 * Create a new instance using, specifying all values.
	 *
	 * @param tileWidth  The width in pixels for image tiles.
	 * @param tileHeight The height in pixels for image tiles.
	 * @param tileOrigin The position in world space where tile (0,0) begins.
	 * @param viewPort   The ViewPort from which to take over the list of resolutions. Better make sure the map has
	 *                   already been initialized before calling this method. Otherwise the ViewPort won't have any
	 *                   resolutions.
	 */
	@ExportConstructor
	public static JsTileConfiguration constructor(int tileWidth, int tileHeight, Coordinate tileOrigin,
												JsViewPortImpl viewPort) {
		final JsTileConfiguration jsTileConfiguration = new JsTileConfiguration();
		jsTileConfiguration.construct(tileWidth, tileHeight, tileOrigin, viewPort);

		return  jsTileConfiguration;
	}

	private void construct(int tileWidth, int tileHeight, Coordinate tileOrigin, JsViewPortImpl viewPort) {
		configuration = new TileConfiguration(tileWidth, tileHeight, tileOrigin, viewPort.toGwt());
	}

	/**
	 * Coverts {@link JsTileConfiguration} to {@link TileConfiguration}.
	 *
	 * @return {@link TileConfiguration}
	 */
	public TileConfiguration toGwt() {
		return configuration;
	}
}