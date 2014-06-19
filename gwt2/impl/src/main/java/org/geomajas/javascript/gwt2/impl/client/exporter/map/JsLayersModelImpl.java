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
package org.geomajas.javascript.gwt2.impl.client.exporter.map;

import org.geomajas.annotation.Api;
import org.geomajas.gwt2.client.map.layer.Layer;
import org.geomajas.gwt2.client.map.layer.LayersModel;
import org.geomajas.javascript.api.client.map.JsLayersModel;
import org.geomajas.javascript.api.client.map.layer.JsLayer;
import org.geomajas.javascript.gwt2.impl.client.exporter.map.layer.JsLayerImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * JsLayersModel interface implementation.
 *
 * @author David Debuck
 * @since 1.0.0
 */
@Export("LayersModel")
@ExportPackage("gm")
public class JsLayersModelImpl implements Exportable, JsLayersModel {

	private LayersModel layersModel;

	public JsLayersModelImpl() {
	}

	/**
	 * Construct the wrapper based on the given mapModel.
	 *
	 * @param layersModel the mapModel to wrap.
	 */
	@Api
	public JsLayersModelImpl(LayersModel layersModel) {
		this.layersModel = layersModel;
	}

	/**
	 * Get a single layer by its identifier.
	 *
	 * @param layerId The layers unique identifier within this map.
	 * @return Returns the layer, or null if it could not be found.
	 */
	public JsLayer getLayer(String layerId) {
		Layer layer = layersModel.getLayer(layerId);
/*		if (layer instanceof FeaturesSupported) {
			return new VectorLayer((FeaturesSupported) layer);
		}*/
		return new JsLayerImpl(layer);
	}

	@Override
	public int getLayerCount() {
		return layersModel.getLayerCount();
	}

	@Override
	public JsLayer getLayerAtIndex(int index) {
		return new JsLayerImpl(layersModel.getLayer(index));
	}

}