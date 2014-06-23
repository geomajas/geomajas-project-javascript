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

package org.geomajas.javascript.api.client.map.controller;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.HumanInputEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEvent;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.user.client.DOM;
import org.geomajas.annotation.Api;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt.client.controller.AbstractController;
import org.geomajas.gwt.client.controller.Controller;
import org.geomajas.gwt.client.map.RenderSpace;
import org.geomajas.javascript.api.client.map.JsExportableFunction;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

/**
 * General definition of a controller on the map. It defines a series of handlers to catch mouse/touch events, but also
 * has 2 extra handlers executed on activation and deactivation of this controller on the map.
 *
 * @author Pieter De Graef
 * @since 1.0.0
 */
@Api
@Export
@ExportPackage("gm.controller")
public class JsMapController implements Exportable {

	private JsMapPresenter map;

	private JsMouseMoveHandler mouseMoveHandler;

	private JsMouseOutHandler mouseOutHandler;

	private JsMouseOverHandler mouseOverHandler;

	private JsDownHandler downHandler;

	private JsUpHandler upHandler;

	private JsDragHandler dragHandler;

	private JsDoubleClickHandler doubleClickHandler;

	private JsExportableFunction activationHandler;

	private JsExportableFunction deactivationHandler;

	// ------------------------------------------------------------------------
	// Constructors:
	// ------------------------------------------------------------------------

	public JsMapController() {
	}

	public JsMapController(JsMapPresenter map, final Controller controller) {
		this.map = map;
		mouseMoveHandler = new JsMouseMoveHandler() {

			public void onMouseMove(MouseMoveEvent event) {
				controller.onMouseMove(event);
			}
		};
		mouseOutHandler = new JsMouseOutHandler() {

			public void onMouseOut(MouseOutEvent event) {
				controller.onMouseOut(event);
			}
		};
		mouseOverHandler = new JsMouseOverHandler() {

			public void onMouseOver(MouseOverEvent event) {
				controller.onMouseOver(event);
			}
		};
		downHandler = new JsDownHandler() {

			public void onDown(HumanInputEvent<?> event) {
				if (event instanceof MouseDownEvent) {
					controller.onMouseDown((MouseDownEvent) event);
				} else if (event instanceof TouchStartEvent) {
					controller.onTouchStart((TouchStartEvent) event);
				}
			}
		};
		upHandler = new JsUpHandler() {

			public void onUp(HumanInputEvent<?> event) {
				if (event instanceof MouseUpEvent) {
					controller.onMouseUp((MouseUpEvent) event);
				} else if (event instanceof TouchEndEvent) {
					controller.onTouchEnd((TouchEndEvent) event);
				}
			}
		};
		dragHandler = new JsDragHandler() {

			public void onDrag(HumanInputEvent<?> event) {
				if (controller instanceof AbstractController) {
					((AbstractController) controller).onDrag(event);
				}
			}
		};
		doubleClickHandler = new JsDoubleClickHandler() {

			public void onDoubleClick(DoubleClickEvent event) {
				controller.onDoubleClick(event);
			}
		};
	}

	// ------------------------------------------------------------------------
	// Registering mouse event handlers:
	// ------------------------------------------------------------------------

	public void setMouseMoveHandler(JsMouseMoveHandler mouseMoveHandler) {
		this.mouseMoveHandler = mouseMoveHandler;
	}

	public void setMouseOutHandler(JsMouseOutHandler mouseOutHandler) {
		this.mouseOutHandler = mouseOutHandler;
	}

	public void setMouseOverHandler(JsMouseOverHandler mouseOverHandler) {
		this.mouseOverHandler = mouseOverHandler;
	}

	public void setDownHandler(JsDownHandler downHandler) {
		this.downHandler = downHandler;
	}

	public void setUpHandler(JsUpHandler upHandler) {
		this.upHandler = upHandler;
	}

	public void setDragHandler(JsDragHandler dragHandler) {
		this.dragHandler = dragHandler;
	}

	public void setDoubleClickHandler(JsDoubleClickHandler doubleClickHandler) {
		this.doubleClickHandler = doubleClickHandler;
	}

	public void setActivationHandler(JsExportableFunction activationHandler) {
		this.activationHandler = activationHandler;
	}

	public void setDeactivationHandler(JsExportableFunction deactivationHandler) {
		this.deactivationHandler = deactivationHandler;
	}

	public Coordinate getLocation(HumanInputEvent<?> event, String renderSpace) {
		Element el = DOM.getElementById(map.getHtmlElementId()).getFirstChildElement();
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
		if ("world".equalsIgnoreCase(renderSpace)) {
			return map.getViewPort().getTransformationService().transform(location, RenderSpace.SCREEN,
					RenderSpace.WORLD);
			//return map.getViewPort().transform(location, "screen", renderSpace);
		}
		return location;
	}

	// ------------------------------------------------------------------------
	// Extra public methods:
	// ------------------------------------------------------------------------

	public JsMouseMoveHandler getMouseMoveHandler() {
		return mouseMoveHandler;
	}

	public JsMouseOutHandler getMouseOutHandler() {
		return mouseOutHandler;
	}

	public JsMouseOverHandler getMouseOverHandler() {
		return mouseOverHandler;
	}

	public JsDownHandler getDownHandler() {
		return downHandler;
	}

	public JsUpHandler getUpHandler() {
		return upHandler;
	}

	public JsDragHandler getDragHandler() {
		return dragHandler;
	}

	public JsDoubleClickHandler getDoubleClickHandler() {
		return doubleClickHandler;
	}

	public JsExportableFunction getActivationHandler() {
		return activationHandler;
	}

	public JsExportableFunction getDeactivationHandler() {
		return deactivationHandler;
	}

	@NoExport
	public JsMapPresenter getMap() {
		return map;
	}

	@NoExport
	public void setMap(JsMapPresenter map) {
		this.map = map;
	}
}