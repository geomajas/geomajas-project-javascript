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

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.HumanInputEvent;
import com.google.gwt.event.dom.client.MouseEvent;
import com.google.gwt.event.dom.client.TouchEvent;
import com.google.gwt.user.client.DOM;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt.client.map.RenderSpace;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.geomajas.javascript.api.client.map.JsRenderSpace;

/**
 * Default implementation of {@link JsGwtUtil}.
 *
 * @author Jan Venstermans
 */
public final class JsGwtUtilImpl implements JsGwtUtil {

	private static JsGwtUtil instance = new JsGwtUtilImpl();

	private JsGwtUtilImpl() {
	}

	public static JsGwtUtil getInstance() {
		return instance;
	}

	/**
	 * Returns the {@link org.geomajas.geometry.Coordinate} of a
	 * {@link com.google.gwt.event.dom.client.HumanInputEvent}.
	 * @param mapPresenter
	 * @param event
	 * @param renderSpace
	 * @return
	 */
	@Override
	public Coordinate getLocation(JsMapPresenter mapPresenter, HumanInputEvent<?> event, JsRenderSpace renderSpace) {
		Element el = DOM.getElementById(mapPresenter.getHtmlElementId()).getFirstChildElement();
		Coordinate location = null;
		if (event instanceof MouseEvent) {
			MouseEvent<?> mEvent = (MouseEvent<?>) event;
			event.setRelativeElement(el);
			location = new Coordinate(mEvent.getX(), mEvent.getY());
		} else if (event instanceof TouchEvent) {
			TouchEvent<?> tEvent = (TouchEvent<?>) event;
			if (tEvent.getTouches().length() > 0) {
				location = new Coordinate(tEvent.getTouches().get(0).getRelativeX(el), tEvent.getTouches().get(0)
						.getRelativeY(el));
			}
		}
		if (location == null) {
			location = new Coordinate(event.getNativeEvent().getClientX(), event.getNativeEvent().getClientY());
		}
		if (JsRenderSpace.WORLD.equals(renderSpace)) {
			return mapPresenter.getViewPort().getTransformationService().
					transform(location, JsRenderSpace.SCREEN, renderSpace);
		}
		return location;
	}

	@Override
	public RenderSpace toRenderSpace(JsRenderSpace renderSpace) {
		switch (renderSpace) {
			case SCREEN:
				return RenderSpace.SCREEN;
			case WORLD:
				return RenderSpace.WORLD;
		}
		return null;
	}
}