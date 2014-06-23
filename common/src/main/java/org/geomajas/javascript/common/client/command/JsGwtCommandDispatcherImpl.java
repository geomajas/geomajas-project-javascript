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
package org.geomajas.javascript.common.client.command;

import com.google.gwt.event.shared.HandlerRegistration;
import org.geomajas.gwt.client.command.GwtCommandDispatcher;
import org.geomajas.gwt.client.command.event.DispatchStartedEvent;
import org.geomajas.gwt.client.command.event.DispatchStartedHandler;
import org.geomajas.gwt.client.command.event.DispatchStoppedEvent;
import org.geomajas.gwt.client.command.event.DispatchStoppedHandler;
import org.geomajas.javascript.api.client.event.JsHandlerRegistration;
import org.geomajas.javascript.api.client.spatial.JsBboxService;
import org.geomajas.javascript.api.client.spatial.JsGeometryService;
import org.geomajas.javascript.common.client.command.event.JsDispatchStartedEvent;
import org.geomajas.javascript.common.client.command.event.JsDispatchStartedHandler;
import org.geomajas.javascript.common.client.command.event.JsDispatchStoppedEvent;
import org.geomajas.javascript.common.client.command.event.JsDispatchStoppedHandler;
import org.geomajas.javascript.common.client.map.spatial.JsBboxServiceImpl;
import org.geomajas.javascript.common.client.map.spatial.JsGeometryServiceImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.ExportStaticMethod;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link GwtCommandDispatcher}.
 *
 * @author Jan De Moerloose
 */
@Export("GwtCommandDispatcher")
@ExportPackage("gm")
public final class JsGwtCommandDispatcherImpl implements Exportable {

	private JsGwtCommandDispatcherImpl() {
	}

	/**
	 * Add a handler that is called whenever the client starts communicating with the back-end.
	 *
	 * @param handler
	 *            The actual handler (closure).
	 * @return The registration for the handler. Using this object the handler can be removed again.
	 */
	@ExportStaticMethod("addDispatchStartedHandler")
	public static JsHandlerRegistration addDispatchStartedHandler(final JsDispatchStartedHandler handler) {
		HandlerRegistration registration = GwtCommandDispatcher.getInstance().addDispatchStartedHandler(
				new DispatchStartedHandler() {

					public void onDispatchStarted(DispatchStartedEvent event) {
						handler.onDispatchStarted(new JsDispatchStartedEvent());
					}
				});
		return new JsHandlerRegistration(new HandlerRegistration[] { registration });
	}

	/**
	 * Add a handler that is called whenever the client stops communicating with the back-end.
	 *
	 * @param handler
	 *            The actual handler (closure).
	 * @return The registration for the handler. Using this object the handler can be removed again.
	 */
	@ExportStaticMethod("addDispatchStoppedHandler")
	public static JsHandlerRegistration addDispatchStoppedHandler(final JsDispatchStoppedHandler handler) {
		HandlerRegistration registration = GwtCommandDispatcher.getInstance().addDispatchStoppedHandler(
				new DispatchStoppedHandler() {

					public void onDispatchStopped(DispatchStoppedEvent event) {
						handler.onDispatchStopped(new JsDispatchStoppedEvent());
					}
				});
		return new JsHandlerRegistration(new HandlerRegistration[] { registration });
	}

	/**
	 * Get a service for geometry manipulation.
	 *
	 * @return A service for geometry manipulation.
	 */
	@ExportStaticMethod("getGeometryService")
	public static JsGeometryService getGeometryService() {
		return new JsGeometryServiceImpl();
	}

	/**
	 * Get a service for bounding box manipulation.
	 *
	 * @return A service for bounding box manipulation.
	 */
	@ExportStaticMethod("getBboxService")
	public static JsBboxService getBboxService() {
		return new JsBboxServiceImpl();
	}
}