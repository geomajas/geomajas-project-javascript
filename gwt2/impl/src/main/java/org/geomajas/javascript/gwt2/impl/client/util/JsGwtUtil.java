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

	Coordinate getLocation(JsMapPresenter mapPresenter, HumanInputEvent<?> event, JsRenderSpace renderSpace);

	RenderSpace toRenderSpace(JsRenderSpace renderSpace);
}
