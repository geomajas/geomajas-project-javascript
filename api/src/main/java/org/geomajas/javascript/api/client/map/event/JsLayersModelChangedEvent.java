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

package org.geomajas.javascript.api.client.map.event;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.JsLayersModel;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * This event is thrown when a new layer configuration has been loaded into the {@link JsLayersModel}.
 *
 * @author Pieter De Graef
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsLayersModelChangedEvent extends JsEvent<JsLayersModelChangedHandler> implements Exportable {

	private JsLayersModel layersModel;

	/**
	 * Constructor.
	 *
	 * @param layersModel layers model
	 */
	public JsLayersModelChangedEvent(JsLayersModel layersModel) {
		this.layersModel = layersModel;
	}

	@Override
	public Class<JsLayersModelChangedHandler> getType() {
		return JsLayersModelChangedHandler.class;
	}

	@Override
	protected void dispatch(JsLayersModelChangedHandler handler) {
		handler.onLayersModelChanged(this);
	}

	/**
	 * Get layers model which has changed.
	 *
	 * @return layers model
	 */
	public JsLayersModel getLayersModel() {
		return layersModel;
	}
}