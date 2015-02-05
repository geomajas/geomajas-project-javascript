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

package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.layer.JsLayer;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * This event is thrown when a new layer configuration has been loaded into the
 * {@link org.geomajas.javascript.api.client.map.layer.JsLayersModel}.
 * Exports {@link org.geomajas.gwt2.client.event.LayerAddedEvent}.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsLayerAddedEvent extends JsEvent<JsLayerAddedHandler> implements Exportable {

	private JsLayer addedLayer;

	/**
	 * Default constructor.
	 *
	 * @param addedLayer layer that has been added to the layersModel
	 */
	public JsLayerAddedEvent(JsLayer addedLayer) {
		this.addedLayer = addedLayer;
	}

	/**
	 * Get the layer that has been added to the layersModel.
	 *
	 * @return layers model
	 */
	public JsLayer getAddedLayer() {
		return addedLayer;
	}

	@Override
	protected void dispatch(JsLayerAddedHandler handler) {
		handler.onLayerAdded(this);
	}

	@Override
	public Class<JsLayerAddedHandler> getType() {
		return JsLayerAddedHandler.class;
	}
}