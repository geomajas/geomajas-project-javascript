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
package org.geomajas.javascript.gwt2.impl.client.map.controller;

import org.geomajas.geometry.Bbox;
import org.geomajas.gwt2.client.controller.AbstractRectangleController;

/**
 * Controller that lets user draw a rectangle. A callback in the constructor allows to get the
 * {@link org.geomajas.javascript.api.client.spatial.JsBbox} rectangle.
 *
 * @author Jan Venstermans
 */
class RectangleControllerWrapper extends AbstractRectangleController {

	private JsRectangleControllerCallback callback;

	public void setCallback(JsRectangleControllerCallback callback) {
		this.callback = callback;
	}

	@Override
	public void execute(Bbox bbox) {
		if (callback != null) {
			callback.execute(new JsRectangleControllerCallback.JsBboxHolder(bbox));
		}
	}
}
