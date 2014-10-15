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

package org.geomajas.javascript.gwt2.impl.client.plugin.osm.layer;

import org.geomajas.geometry.Bbox;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsLayerImpl;
import org.geomajas.javascript.gwt2.impl.client.map.layer.tile.JsTileConfiguration;
import org.geomajas.gwt2.plugin.tilebasedlayer.client.TileBasedLayerClient;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 *
 * Javascript exporter implementation of {@link org.geomajas.gwt2.plugin.tilebasedlayer.client.layer.OsmLayer}.
 *
 * @author Jens Mortier
 *
 * @since 1.0.0
 */
@Export("OsmLayer")
@ExportPackage("gm")
public final class JsOsmLayer extends JsLayerImpl implements Exportable {

	private JsOsmLayer() {
		super();
	}

	@ExportConstructor
	public static JsOsmLayer constructor(String title, JsTileConfiguration tileConfig,
										 String url) {
		final JsOsmLayer jsOsmLayer = new JsOsmLayer();
		jsOsmLayer.construct(title, tileConfig, url);

		return jsOsmLayer;
	}

	private void construct(String title, JsTileConfiguration tileConfig,
						   String url) {
		this.layer = TileBasedLayerClient.getInstance().createOsmLayer(title, tileConfig.toGwt(), url);
	}

	/**
	 * Set the maximum bounds. The bounds is defined in the map CRS. For tile-based layers, only tiles within the
	 * maximum bounds will be fetched. To avoid rounding errors, the center of the tile may be used for checking the
	 * condition.
	 *
	 * @param maxBounds The maximum bounds
	 */
	public void setMaxBounds(Bbox maxBounds) {
		this.layer.setMaxBounds(maxBounds);
	}

}
