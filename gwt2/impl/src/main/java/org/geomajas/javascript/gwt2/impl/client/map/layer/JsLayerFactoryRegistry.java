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
 * Registry for {@link JsLayerFactory} objects. Method {#createJsLayer} enables to create a {@link JsLayer}
 * based on the registered facotries.
 *
 * @author Jan Venstermans
 */
public interface JsLayerFactoryRegistry {

	/**
	 * Registers a {@link JsLayerFactory}. This is linked to a specific {@link Layer} class.
	 *
	 * @param factory
	 */
	void registerJsLayerFactory(JsLayerFactory factory);

	/**
	 * Factory method for creating correct {@link org.geomajas.javascript.api.client.map.layer.JsLayer} instance,
	 * based on the registered factories.
	 *
	 * @param layer
	 * @return
	 */
	JsLayer createJsLayer(Layer layer);

}