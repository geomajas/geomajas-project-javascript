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
package org.geomajas.javascript.gwt2.impl.client.exporter.map.layer;

import org.geomajas.gwt2.client.map.layer.Layer;
import org.geomajas.javascript.api.client.map.layer.JsLayer;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * JsLayer interface implementation.
 *
 * @author David Debuck
 * @since 1.0.0
 */
@Export("Layer")
@ExportPackage("gm.layer")
public class JsLayerImpl implements JsLayer, Exportable {

	protected Layer layer;

	public JsLayerImpl() {
	}

	/**
	 * Create a new layer.
	 *
	 * @param layer
	 */
	public JsLayerImpl(Layer layer) {
		this.layer = layer;
	}

	@Override
	public String getId() {
		return layer.getId();
	}

	@Override
	public String getServerLayerId() {
		return layer.getId();
	}

	@Override
	public String getTitle() {
		return layer.getTitle();
	}

	@Override
	public void setMarkedAsVisible(boolean markedAsVisible) {
		layer.setMarkedAsVisible(markedAsVisible);
	}

	@Override
	public boolean isMarkedAsVisible() {
		return layer.isMarkedAsVisible();
	}

}