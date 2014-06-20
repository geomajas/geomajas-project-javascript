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
import org.geomajas.javascript.api.client.map.layer.JsLayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of {@link JsLayerFactoryRegistry}.
 *
 * @author Jan Venstermans
 */
public class JsLayerFactoryRegistryImpl implements JsLayerFactoryRegistry {

	private List<JsLayerFactory> factoryRegistry = new ArrayList<JsLayerFactory>();

	private JsLayerFactory defaultJsLayerFactory = new DefaultJsLayerFactory();

	@Override
	public void registerJsLayerFactory(JsLayerFactory factory) {
		factoryRegistry.add(factory);
	}

	@Override
	public JsLayer createJsLayer(Layer layer) {
		List<JsLayerFactory> matchingFactories = new ArrayList<JsLayerFactory>();
		for (JsLayerFactory factory : factoryRegistry) {
			if (factory.supports(layer)) {
				matchingFactories.add(factory);
			}
		}
		if (matchingFactories.size() == 1) {
			return matchingFactories.get(0).createJsLayer(layer);
		}
		// TODO: what to do with multiple matches?
		// default fallback
		return defaultJsLayerFactory.createJsLayer(layer);
	}

}