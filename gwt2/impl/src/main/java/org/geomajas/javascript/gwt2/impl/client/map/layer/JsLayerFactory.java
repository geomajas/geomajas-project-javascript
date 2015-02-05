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
 * Factory for creating {@link org.geomajas.javascript.api.client.map.layer.JsLayer} instances,
 * based on a specific {@link Layer} type.
 *
 * @param <S> type of {@link Layer} that is supported by the factory
 * @param <T> type of {@link JsLayer} that will be created by the factory
 * @author Jan Venstermans
 */
public interface JsLayerFactory<S extends Layer, T extends JsLayer> {

	boolean supports(Layer layer);

	T createJsLayer(S layer);

}