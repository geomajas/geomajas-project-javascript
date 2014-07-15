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

package org.geomajas.javascript.gwt2.impl.client.plugin.wms.layer;

import org.geomajas.geometry.Bbox;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsLayerImpl;
import org.geomajas.javascript.gwt2.impl.client.map.layer.tile.JsTileConfiguration;
import org.geomajas.plugin.wms.client.WmsClient;
import org.geomajas.plugin.wms.client.capabilities.WmsLayerInfo;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * <p> Base client-side WMS layer definition. Note that a WMS service can use either a raster data set or a vector data
 * set, we too make that distinction here. This layer definition does not support interaction with the WMS service. If
 * you need support for features or a GetFeatureInfo request, have a look at the <code>FeaturesSupportedWmsLayer</code>.
 * </p>
 *
 * @author Dosi Bingov
 *
 * @since 1.0.0
 */
@Export("WmsLayer")
@ExportPackage("gm")
public final class JsWmsLayerImpl extends JsLayerImpl implements Exportable {

	private JsWmsLayerImpl() {
		super();
	}

	@ExportConstructor
	public static JsWmsLayerImpl constructor(String title, String crs, JsWmsLayerConfiguration layerConfig,
											 JsTileConfiguration tileConfig) {
		final JsWmsLayerImpl jsWmsLayer = new JsWmsLayerImpl();
		jsWmsLayer.construct(title, crs, layerConfig, tileConfig, null);

		return  jsWmsLayer;
	}

	/**
	 * Private construct function for {@link JsWmsLayerImpl} object.
	 * @param title
	 * @param layerConfig
	 * @param tileConfig
	 */
	private void construct(String title, String crs, JsWmsLayerConfiguration layerConfig,
						   JsTileConfiguration tileConfig, WmsLayerInfo layerInfo) {

		layer = WmsClient.getInstance().createLayer(title, crs, tileConfig.toGwt(), layerConfig.toGwt(), layerInfo);
	}

	/**
	 * Set the maximum bounds. The bounds is defined in the map CRS. For tile-based layers, only tiles within the
	 * maximum bounds will be fetched. To avoid rounding errors, the center of the tile may be used for checking the
	 * condition.
	 *
	 * @param maxBounds The maximum bounds
	 * @since 2.1.0
	 */
	public void setMaxBounds(Bbox maxBounds) {
		layer.setMaxBounds(maxBounds);
	}

}
