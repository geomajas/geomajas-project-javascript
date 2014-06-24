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

import com.google.gwt.event.dom.client.HumanInputEvent;
import org.geomajas.annotation.Api;
import org.geomajas.geometry.Coordinate;
import org.geomajas.javascript.api.client.JsExportableFunction;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.geomajas.javascript.api.client.map.JsRenderSpace;
import org.geomajas.javascript.api.client.map.controller.JsDoubleClickHandler;
import org.geomajas.javascript.api.client.map.controller.JsDownHandler;
import org.geomajas.javascript.api.client.map.controller.JsDragHandler;
import org.geomajas.javascript.api.client.map.controller.JsMapController;
import org.geomajas.javascript.api.client.map.controller.JsMouseMoveHandler;
import org.geomajas.javascript.api.client.map.controller.JsMouseOutHandler;
import org.geomajas.javascript.api.client.map.controller.JsMouseOverHandler;
import org.geomajas.javascript.api.client.map.controller.JsUpHandler;
import org.geomajas.javascript.gwt2.impl.client.JsGwtImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

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

	// ------------------------------------------------------------------------
	// Registering mouse event handlers:
	// ------------------------------------------------------------------------

	@Override
	public void setMouseMoveHandler(JsMouseMoveHandler mouseMoveHandler) {
		this.mouseMoveHandler = mouseMoveHandler;
	}

	@Override
	public void setMouseOutHandler(JsMouseOutHandler mouseOutHandler) {
		this.mouseOutHandler = mouseOutHandler;
	}

	@Override
	public void setMouseOverHandler(JsMouseOverHandler mouseOverHandler) {
		this.mouseOverHandler = mouseOverHandler;
	}

	@Override
	public void setDownHandler(JsDownHandler downHandler) {
		this.downHandler = downHandler;
	}

	@Override
	public void setUpHandler(JsUpHandler upHandler) {
		this.upHandler = upHandler;
	}

	@Override
	public void setDragHandler(JsDragHandler dragHandler) {
		this.dragHandler = dragHandler;
	}

	@Override
	public void setDoubleClickHandler(JsDoubleClickHandler doubleClickHandler) {
		this.doubleClickHandler = doubleClickHandler;
	}

	@Override
	public void setActivationHandler(JsExportableFunction activationHandler) {
		this.activationHandler = activationHandler;
	}

	@Override
	public void setDeactivationHandler(JsExportableFunction deactivationHandler) {
		this.deactivationHandler = deactivationHandler;
	}

	// ------------------------------------------------------------------------
	// Extra public methods:
	// ------------------------------------------------------------------------

	@Override
	public JsMouseMoveHandler getMouseMoveHandler() {
		return mouseMoveHandler;
	}

	@Override
	public JsMouseOutHandler getMouseOutHandler() {
		return mouseOutHandler;
	}

	@Override
	public JsMouseOverHandler getMouseOverHandler() {
		return mouseOverHandler;
	}

	@Override
	public JsDownHandler getDownHandler() {
		return downHandler;
	}

	@Override
	public JsUpHandler getUpHandler() {
		return upHandler;
	}

	@Override
	public JsDragHandler getDragHandler() {
		return dragHandler;
	}

	@Override
	public JsDoubleClickHandler getDoubleClickHandler() {
		return doubleClickHandler;
	}

	@Override
	public JsExportableFunction getActivationHandler() {
		return activationHandler;
	}

	public JsExportableFunction getDeactivationHandler() {
		return deactivationHandler;
	}

	@Override
	public JsMapPresenter getMapPresenter() {
		return map;
	}

	@Override
	public void setMapPresenter(JsMapPresenter map) {
		this.map = map;
	}

	/**
	 * Default {#getLocation} call will consult the util method.
	 *
	 * @param event event containing location
	 * @param renderSpace space of witch to get the location coordinates
	 * @return coordinates of the location for the requested renderSpace.
	 */
	@Override
	public Coordinate getLocation(HumanInputEvent<?> event, String renderSpace) {
		return JsGwtImpl.getInstance().getJsGwtUtil().getLocation(map, event, JsRenderSpace.getType(renderSpace));
	}
}