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

import org.geomajas.gwt2.client.map.layer.Layer;
import org.geomajas.gwt2.client.map.layer.VectorServerLayer;
import org.geomajas.javascript.api.client.map.layer.JsVectorServerLayer;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;

/**
 * Exports {@link org.geomajas.gwt2.client.map.layer.VectorServerLayer}.
 *
 * @author Jan Venstermans
 */
@Export("VectorServerLayer")
@ExportPackage("gm.layer")
public class JsVectorServerLayerImpl extends JsLayerImpl implements JsVectorServerLayer {

	public JsVectorServerLayerImpl() {
	}

	public JsVectorServerLayerImpl(Layer layer) {
		super(layer);
	}

	@Override
	public String getServerLayerId() {
		return getLayerAsVectorServerLayer().getServerLayerId();
	}

	private VectorServerLayer getLayerAsVectorServerLayer() {
		return (VectorServerLayer) layer;
	}
}