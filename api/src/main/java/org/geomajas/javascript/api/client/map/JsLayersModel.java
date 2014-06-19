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
 * @see  org.geomajas.gwt2.client.map.layer.LayersModel
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

	/**
	 * Return the total number of layers within this map.
	 *
	 * @return The layer count.
	 */
	int getLayerCount();

	/**
	 * Return the layer at a certain index. If the index can't be found, null is returned.
	 * In {@link org.geomajas.gwt2.client.map.layer.LayersModel}, this method is called getLayer(int index).
	 *
	 * @param index The specified index.
	 * @return Returns the layer, or null if the index can't be found.
	 */
	JsLayer getLayerAtIndex(int index);

}