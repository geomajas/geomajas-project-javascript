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
package org.geomajas.javascript.gwt2.impl.client.map.layer;

import org.geomajas.gwt2.client.map.layer.Layer;
import org.geomajas.javascript.api.client.map.layer.JsLayer;

/**
 * Default factory for creating {@link org.geomajas.javascript.api.client.map.layer.JsLayer} instances.
 *
 * @author Jan Venstermans
 */
public class DefaultJsLayerFactory implements  JsLayerFactory<Layer, JsLayer> {

	@Override
	public boolean supports(Layer layer) {
		return true;
	}

	@Override
	public JsLayer createJsLayer(Layer layer) {
		return new JsLayerImpl(layer);
	}
}