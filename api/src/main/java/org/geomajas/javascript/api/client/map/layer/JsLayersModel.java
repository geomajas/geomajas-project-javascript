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
 * Exports {@link org.geomajas.gwt2.client.map.LayersModel}.
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

	/**
	 * Add a new layer to the layers model. The new layer will be added at the back of the list (where the back of the
	 * list is rendered on top).
	 *
	 * @param layer The layer to be added to the model.
	 * @return True or false, indicating success or not.
	 */
	boolean addLayer(JsLayer layer);

	/**
	 * Remove a layer from this layers model. This will also remove the layer from the map.
	 *
	 * @param id The layers unique identifier within this map.
	 * @return True or false, indicating success or not.
	 */
	boolean removeLayer(String id);

	/**
	 * Get the position of a certain layer in this map model.
	 *
	 * @param layer The layer to return the position for.
	 * @return Returns the position of the layer in the map. This position determines layer order. If the layer was not
	 * found, than -1 is returned.
	 */
	int getLayerPosition(JsLayer layer);

}