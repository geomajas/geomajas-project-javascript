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
package org.geomajas.javascript.gwt2.impl.client.map.layer;

import org.geomajas.annotation.Api;
import org.geomajas.gwt2.client.map.layer.Layer;
import org.geomajas.gwt2.client.map.layer.LayersModel;
import org.geomajas.javascript.api.client.map.layer.JsLayer;
import org.geomajas.javascript.api.client.map.layer.JsLayersModel;
import org.geomajas.javascript.gwt2.impl.client.JsGwtImpl;
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
public class JsLayersModelImpl implements JsLayersModel, Exportable {

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
		return createJsLayer(layersModel.getLayer(layerId));
	}

	@Override
	public int getLayerCount() {
		return layersModel.getLayerCount();
	}

	@Override
	public JsLayer getLayerAtIndex(int index) {
		return createJsLayer(layersModel.getLayer(index));
	}

	@Override
	public boolean addLayer(JsLayer layer) {
		return layersModel.addLayer(((JsLayerImpl) layer).asLayer());
	}

	@Override
	public boolean removeLayer(String id) {
		return layersModel.removeLayer(id);
	}

	@Override
	public int getLayerPosition(JsLayer layer) {
		return layersModel.getLayerPosition(((JsLayerImpl) layer).asLayer());
	}

	/**
	 * Factory method for creating the correct {@link JsLayer} instances.
	 * @param layer layer
	 * @return jsLayer created based on the layer
	 */
	private JsLayer createJsLayer(Layer layer) {
		return JsGwtImpl.getInstance().getJsLayerFactoryRegistry().createJsLayer(layer);
	}

}