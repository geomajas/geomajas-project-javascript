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

package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.layer.JsLayer;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * This event is thrown when a layer configuration has been removed from
 * the {@link org.geomajas.javascript.api.client.map.layer.JsLayersModel}.
 * Exports {@link org.geomajas.gwt2.client.event.LayerRemovedEvent}.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsLayerRemovedEvent extends JsEvent<JsLayerRemovedHandler> implements Exportable {

	private JsLayer removedLayer;

	/**
	 * Default constructor.
	 *
	 * @param removedLayer
	 */
	public JsLayerRemovedEvent(JsLayer removedLayer) {
		this.removedLayer = removedLayer;
	}

	/**
	 * Get layer that has been removed from the layersModel.
	 *
	 * @return removed layer
	 */
	public JsLayer getRemovedLayer() {
		return removedLayer;
	}

	@Override
	protected void dispatch(JsLayerRemovedHandler handler) {
		handler.onLayerRemoved(this);
	}

	@Override
	public Class<JsLayerRemovedHandler> getType() {
		return JsLayerRemovedHandler.class;
	}
}