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

package org.geomajas.javascript.gwt2.impl.client.map.controller;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.HumanInputEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchStartEvent;
import org.geomajas.annotation.Api;
import org.geomajas.gwt.client.controller.AbstractController;
import org.geomajas.gwt.client.controller.Controller;
import org.geomajas.gwt2.client.controller.MapController;
import org.geomajas.javascript.api.client.JsExportableFunction;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.geomajas.javascript.api.client.map.controller.JsDoubleClickHandler;
import org.geomajas.javascript.api.client.map.controller.JsDownHandler;
import org.geomajas.javascript.api.client.map.controller.JsDragHandler;
import org.geomajas.javascript.api.client.map.controller.JsMapController;
import org.geomajas.javascript.api.client.map.controller.JsMouseMoveHandler;
import org.geomajas.javascript.api.client.map.controller.JsMouseOutHandler;
import org.geomajas.javascript.api.client.map.controller.JsMouseOverHandler;
import org.geomajas.javascript.api.client.map.controller.JsUpHandler;
import org.geomajas.javascript.gwt2.impl.client.map.JsMapPresenterImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

//import org.geomajas.javascript.api.client.map.layer.JsExportableFunction;

/**
 * General definition of a controller on the map. It defines a series of handlers to catch mouse/touch events, but also
 * has 2 extra handlers executed on activation and deactivation of this controller on the map.
 *
 * @author Pieter De Graef
 * @since 1.0.0
 */
@Api
@Export("MapController")
@ExportPackage("gm.controller")
public class JsMapControllerImpl implements JsMapController, Exportable {

	private MapController mapController;

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

	public JsMapControllerImpl() {
	}

	public JsMapControllerImpl(JsMapPresenter map, final MapController mapController) {
		this.map = map;
		this.mapController = mapController;
		rewireMouseHandlers();
	}

	/**
	 * Rewire the mouse handlers of the {@link org.geomajas.javascript.api.client.map.controller.JsMapController}
	 * to the wrapped {@link Controller}.
	 */
	private void rewireMouseHandlers() {
		mouseMoveHandler = new JsMouseMoveHandler() {

			public void onMouseMove(MouseMoveEvent event) {
				mapController.onMouseMove(event);
			}
		};
		mouseOutHandler = new JsMouseOutHandler() {

			public void onMouseOut(MouseOutEvent event) {
				mapController.onMouseOut(event);
			}
		};
		mouseOverHandler = new JsMouseOverHandler() {

			public void onMouseOver(MouseOverEvent event) {
				mapController.onMouseOver(event);
			}
		};
		downHandler = new JsDownHandler() {

			public void onDown(HumanInputEvent<?> event) {
				if (event instanceof MouseDownEvent) {
					mapController.onMouseDown((MouseDownEvent) event);
				} else if (event instanceof TouchStartEvent) {
					mapController.onTouchStart((TouchStartEvent) event);
				}
			}
		};
		upHandler = new JsUpHandler() {

			public void onUp(HumanInputEvent<?> event) {
				if (event instanceof MouseUpEvent) {
					mapController.onMouseUp((MouseUpEvent) event);
				} else if (event instanceof TouchEndEvent) {
					mapController.onTouchEnd((TouchEndEvent) event);
				}
			}
		};
		dragHandler = new JsDragHandler() {

			public void onDrag(HumanInputEvent<?> event) {
				if (mapController instanceof AbstractController) {
					((AbstractController) mapController).onDrag(event);
				}
			}
		};
		doubleClickHandler = new JsDoubleClickHandler() {

			public void onDoubleClick(DoubleClickEvent event) {
				mapController.onDoubleClick(event);
			}
		};
		setActivationHandler(new JsExportableFunction() {
			@Override
			public void execute() {
				mapController.onActivate(((JsMapPresenterImpl) map).getMapPresenter());
			}
		});
		setDeactivationHandler(new JsExportableFunction() {
			@Override
			public void execute() {
				mapController.onDeactivate(((JsMapPresenterImpl) map).getMapPresenter());
			}
		});
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

	@Override
	public JsMapPresenter getMap() {
		return map;
	}

	@Override
	public void setMap(JsMapPresenter map) {
		this.map = map;
	}

	@NoExport
	public JsMapPresenter getMapPresenter() {
		return map;
	}

	@NoExport
	public void setMapPresenter(JsMapPresenter map) {
		this.map = map;
	}

	@NoExport
	public Controller getMapController() {
		return mapController;
	}
}