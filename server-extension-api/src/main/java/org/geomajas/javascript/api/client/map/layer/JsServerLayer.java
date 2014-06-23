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

package org.geomajas.javascript.api.client.map.layer;

import org.geomajas.annotation.Api;
import org.geomajas.configuration.client.ClientLayerInfo;

/**
 * The basic definition of a server-side layer within the GWT client. This is the base interface for all layers that
 * have been defined in the backend Spring configuration.
 *
 * @param <T>
 *            layer info type, {@link org.geomajas.configuration.client.ClientLayerInfo}
 *
 * @author Pieter De Graef
 * @since 2.0.0
 */
@Api(allMethods = true)
public interface JsServerLayer<T extends ClientLayerInfo> extends JsLayer {

	/**
	 * Return this layer's server ID. Multiple client side layer (connected with a map) can point to a single data
	 * source on the back-end. This returns the actual layer name as used on the server.
	 *
	 * @return id of the server layer
	 */
	String getServerLayerId();

	/**
	 * Return the info for this layer.
	 *
	 * @return the configuration object.
	 */
	T getLayerInfo();
}