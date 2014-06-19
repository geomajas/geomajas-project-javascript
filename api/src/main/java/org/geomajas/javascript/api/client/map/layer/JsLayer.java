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
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

/**
 * JsLayer interface.
 *
 * @author David Debuck
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
public interface JsLayer extends Exportable {

	/**
	 * Get the layers unique identifier.
	 *
	 * @return the unique identifier for the layer.
	 */
	String getId();

	/**
	 * Return this layer's server ID. Multiple client side layer (connected with a map) can point to a single data
	 * source on the back-end. This returns the actual layer name as used on the server.
	 *
	 * @return id of the server layer
	 */
	String getServerLayerId();

}