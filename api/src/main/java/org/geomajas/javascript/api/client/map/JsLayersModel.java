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
package org.geomajas.javascript.api.client.map;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.layer.JsLayer;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

/**
 * JsLayersModel interface.
 *
 * @author David Debuck
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
public interface JsLayersModel extends Exportable {

	/**
	 * Get a single layer by its identifier.
	 *
	 * @param layerId unique identifier.
	 * @return JsLayer or null when the layer is not found.
	 */
	JsLayer getLayer(String layerId);

}