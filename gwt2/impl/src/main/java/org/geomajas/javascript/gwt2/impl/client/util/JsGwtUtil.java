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

package org.geomajas.javascript.gwt2.impl.client.util;

import com.google.gwt.event.dom.client.HumanInputEvent;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt.client.map.RenderSpace;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.geomajas.javascript.api.client.map.JsRenderSpace;

/**
 * Util interface for Javascript Gwt2 implementation.
 *
 * @author Jan Venstermans
 */
public interface JsGwtUtil {

	/**
	 * Returns the coordinate of a location in a {@link com.google.gwt.event.dom.client.HumanInputEvent},
	 * transformed to the requested {@link org.geomajas.javascript.api.client.map.JsRenderSpace}.
	 *
	 * @param mapPresenter the map's presenter
	 * @param event
	 * @param renderSpace requested render space
	 * @return location coordinates in the requested render space
	 */
	Coordinate getLocation(JsMapPresenter mapPresenter, HumanInputEvent<?> event, JsRenderSpace renderSpace);

	RenderSpace toRenderSpace(JsRenderSpace renderSpace);
}
