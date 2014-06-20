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
 * Exports {@link org.geomajas.gwt2.client.map.Layer}.
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

	/**
	 * Return the layer's title. The difference between the ID and the title, is that the ID is used behind the screens,
	 * while the title is the visible name to the user.
	 *
	 * @return
	 */
	String getTitle();

	/**
	 * Mark this layer as visible or invisible. This may toggle the visibility flag, but does not guarantee that the
	 * layer be visible. This is because other factors might intrude upon the layer visibility, such as the minimum and
	 * maximum scales between which a layer can be visible.
	 *
	 * @param markedAsVisible
	 *            Should the layer be marked as visible or invisible?
	 */
	void setMarkedAsVisible(boolean markedAsVisible);

	/**
	 * Has the layer been marked as visible?
	 *
	 * @return True or false.
	 */
	boolean isMarkedAsVisible();

	/** Refresh this layer on the map. This method will completely erase the current contents and redraw. */
	void refresh();

	/**
	 * Apply a new opacity on the entire layer. Changing the opacity on a layer does NOT fire a layer style changed
	 * event.
	 *
	 * @param opacity
	 *            The new opacity value. Must be a value between 0 and 1, where 0 means invisible and 1 is totally
	 *            visible.
	 */
	void setOpacity(double opacity);

	/**
	 * Get the current opacity value for this layer. Must be a value between 0 and 1, where 0 means invisible and 1 is
	 * totally visible.
	 *
	 * @return The current opacity value for this layer.
	 */
	double getOpacity();
}