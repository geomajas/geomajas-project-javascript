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

import org.geomajas.configuration.client.ClientLayerInfo;
import org.geomajas.gwt2.client.map.MapEventBus;
import org.geomajas.gwt2.client.map.ViewPort;
import org.geomajas.gwt2.client.map.layer.AbstractLayer;

/**
 * Abstraction of the basic layer interface. Specific layer implementations should use this as a base.
 *
 * @param <T>
 *            The layer meta-data. Some extension of {@link org.geomajas.configuration.client.ClientLayerInfo}.
 * @author Pieter De Graef
 */
public abstract class JsAbstractServerLayer<T extends ClientLayerInfo> extends AbstractLayer {

	protected T layerInfo;

	// ------------------------------------------------------------------------
	// Constructors:
	// ------------------------------------------------------------------------

	/**
	 * Create a new layer that belongs to the given map model, using the given meta-data.
	 *
	 * @param layerInfo
	 *            The layer configuration from which to create the layer.
	 * @param viewPort
	 *            The view port of the map.
	 * @param eventBus
	 *            The map centric event bus.
	 */
	public JsAbstractServerLayer(T layerInfo, ViewPort viewPort, MapEventBus eventBus) {
		super(layerInfo.getId());

		this.layerInfo = layerInfo;
		this.markedAsVisible = layerInfo.isVisible();
		this.title = layerInfo.getLabel();

		setViewPort(viewPort);
		setEventBus(eventBus);

		//eventBus.addViewPortChangedHandler(new AbstractLayer.LayerScaleVisibilityHandler());
	}

	// ------------------------------------------------------------------------
	// Layer implementation:
	// ------------------------------------------------------------------------

	public String getServerLayerId() {
		return layerInfo.getServerLayerId();
	}

	public T getLayerInfo() {
		return layerInfo;
	}

	@Override
	public boolean isShowing() {
		if (markedAsVisible) {
			double maxResolution = 1 / layerInfo.getMinimumScale().getPixelPerUnit();
			double minResolution = 1 / layerInfo.getMaximumScale().getPixelPerUnit();
			if (viewPort.getResolution() >= minResolution && viewPort.getResolution() <= maxResolution) {
				return true;
			}
		}
		return false;
	}
}