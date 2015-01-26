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

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.HumanInputEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchStartEvent;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt.client.controller.AbstractController;
import org.geomajas.gwt.client.controller.Controller;
import org.geomajas.gwt2.client.controller.MapController;
import org.geomajas.javascript.api.client.JsExportableFunction;
import org.geomajas.javascript.api.client.map.JsRenderSpace;
import org.geomajas.javascript.api.client.map.controller.JsDoubleClickHandler;
import org.geomajas.javascript.api.client.map.controller.JsDownHandler;
import org.geomajas.javascript.api.client.map.controller.JsDragHandler;
import org.geomajas.javascript.api.client.map.controller.JsMouseMoveHandler;
import org.geomajas.javascript.api.client.map.controller.JsMouseOutHandler;
import org.geomajas.javascript.api.client.map.controller.JsMouseOverHandler;
import org.geomajas.javascript.api.client.map.controller.JsMouseWheelHandler;
import org.geomajas.javascript.api.client.map.controller.JsUpHandler;
import org.geomajas.javascript.gwt2.impl.client.JsGwtImpl;
import org.geomajas.javascript.gwt2.impl.client.map.JsMapPresenterImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

//import org.geomajas.javascript.api.client.map.layer.JsExportableFunction;

/**
 * Extension of {@link JsMapControllerImpl} for wrapping a {@link MapController}.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Export
@ExportPackage("gm.controller")
public class JsMapControllerWrapperImpl extends JsMapControllerImpl implements Exportable {

	private MapController mapController;


	// ------------------------------------------------------------------------
	// Constructors:
	// ------------------------------------------------------------------------

	/* default constructor necessary for exporter */
	public JsMapControllerWrapperImpl() {
	}

	public JsMapControllerWrapperImpl(final MapController mapController) {
		if (mapController != null) {
			this.mapController = mapController;
			rewireMouseHandlers();
		}
	}

	/**
	 * Rewire the mouse handlers of the {@link org.geomajas.javascript.api.client.map.controller.JsMapController}
	 * to the wrapped {@link org.geomajas.gwt.client.controller.Controller}.
	 */
	private void rewireMouseHandlers() {
		setMouseMoveHandler(new JsMouseMoveHandler() {

			public void onMouseMove(MouseMoveEvent event) {
				mapController.onMouseMove(event);
			}
		});
		setMouseOutHandler(new JsMouseOutHandler() {

			public void onMouseOut(MouseOutEvent event) {
				mapController.onMouseOut(event);
			}
		});
		setMouseOverHandler(new JsMouseOverHandler() {

			public void onMouseOver(MouseOverEvent event) {
				mapController.onMouseOver(event);
			}
		});
		setMouseWheelHandler(new JsMouseWheelHandler() {
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				mapController.onMouseWheel(event);
			}
		});
		setDownHandler(new JsDownHandler() {

			public void onDown(HumanInputEvent<?> event) {
				if (event instanceof MouseDownEvent) {
					mapController.onMouseDown((MouseDownEvent) event);
				} else if (event instanceof TouchStartEvent) {
					mapController.onTouchStart((TouchStartEvent) event);
				}
			}
		});
		setUpHandler(new JsUpHandler() {

			public void onUp(HumanInputEvent<?> event) {
				if (event instanceof MouseUpEvent) {
					mapController.onMouseUp((MouseUpEvent) event);
				} else if (event instanceof TouchEndEvent) {
					mapController.onTouchEnd((TouchEndEvent) event);
				}
			}
		});
		setDragHandler(new JsDragHandler() {

			public void onDrag(HumanInputEvent<?> event) {
				if (mapController instanceof AbstractController) {
					((AbstractController) mapController).onDrag(event);
				}
			}
		});
		setDoubleClickHandler(new JsDoubleClickHandler() {

			public void onDoubleClick(DoubleClickEvent event) {
				mapController.onDoubleClick(event);
			}
		});
		setActivationHandler(new JsExportableFunction() {
			@Override
			public void execute() {
				mapController.onActivate(((JsMapPresenterImpl) getMapPresenter()).getMapPresenter());
			}
		});
		setDeactivationHandler(new JsExportableFunction() {
			@Override
			public void execute() {
				mapController.onDeactivate(((JsMapPresenterImpl) getMapPresenter()).getMapPresenter());
			}
		});
	}

	@Override
	public Coordinate getLocation(HumanInputEvent<?> event, String renderSpace) {
		JsRenderSpace jsRenderSpace = JsRenderSpace.valueOf(renderSpace);
		if (mapController != null) {
			return mapController.getLocation(event,
					JsGwtImpl.getInstance().getJsGwtUtil().toRenderSpace(jsRenderSpace));
		}
		return super.getLocation(event, renderSpace);
	}

	@NoExport
	public Controller getMapController() {
		return mapController;
	}

}