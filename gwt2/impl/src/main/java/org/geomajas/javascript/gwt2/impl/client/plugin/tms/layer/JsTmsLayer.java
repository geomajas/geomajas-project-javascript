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

package org.geomajas.javascript.gwt2.impl.client.plugin.tms.layer;

import org.geomajas.geometry.Bbox;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsLayerImpl;
import org.geomajas.javascript.gwt2.impl.client.map.layer.tile.JsTileConfiguration;
import org.geomajas.gwt2.plugin.tms.client.TmsClient;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 *
 * Javascript exporter implementation of {@link org.geomajas.gwt2.plugin.tms.client.layer.TmsLayer}.
 *
 * @author Dosi Bingov
 *
 * @since 1.0.0
 */
@Export("TmsLayer")
@ExportPackage("gm")
public final class JsTmsLayer extends JsLayerImpl implements Exportable {

	private JsTmsLayer() {
		super();
	}

	@ExportConstructor
	public static JsTmsLayer constructor(String title, JsTmsLayerConfiguration layerConfig,
										 JsTileConfiguration tileConfig) {
		final JsTmsLayer jsTmsLayer = new JsTmsLayer();
		jsTmsLayer.construct(title, layerConfig, tileConfig);

		return jsTmsLayer;
	}

	private void construct(String title, JsTmsLayerConfiguration layerConfig,
						   JsTileConfiguration tileConfig) {

		this.layer = TmsClient.getInstance().createLayer(title, tileConfig.toGwt(), layerConfig.toGwt());
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
