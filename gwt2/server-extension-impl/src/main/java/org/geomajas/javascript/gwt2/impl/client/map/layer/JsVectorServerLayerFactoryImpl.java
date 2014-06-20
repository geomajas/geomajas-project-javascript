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
import org.geomajas.javascript.client.map.layer.JsVectorServerLayer;

/**
 * Factory for creating a {@link org.geomajas.javascript.client.map.layer.JsVectorServerLayer}
 * from a {@link VectorServerLayer}.
 *
 * @author Jan Venstermans
 */
public class JsVectorServerLayerFactoryImpl implements JsLayerFactory<VectorServerLayer, JsVectorServerLayer> {

	@Override
	public boolean supports(Layer layer) {
		return layer instanceof VectorServerLayer;
	}

	@Override
	public JsVectorServerLayer createJsLayer(VectorServerLayer layer) {
		return new JsVectorServerLayerImpl(layer);
	}
}