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
package org.geomajas.javascript.gwt2.impl.client;

import com.google.gwt.event.shared.HandlerRegistration;
import org.geomajas.gwt.client.command.GwtCommandDispatcher;
import org.geomajas.gwt.client.command.event.DispatchStartedEvent;
import org.geomajas.gwt.client.command.event.DispatchStoppedEvent;
import org.geomajas.gwt2.client.GeomajasServerExtension;
import org.geomajas.javascript.api.client.map.event.DispatchStoppedHandler;
import org.geomajas.javascript.api.client.map.event.JsHandlerRegistration;
import org.geomajas.javascript.gwt2.impl.client.exporter.map.JsMapPresenterImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.ExportStaticMethod;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link GeomajasServerExtension}.
 *
 * @author Jan De Moerloose
 */
@Export("ServerExtension")
@ExportPackage("gm")
public final class JsGeomajasServerExtension implements Exportable {

	private JsGeomajasServerExtension() {
	}

	/**
	 * Initialize this map with the given server ids.
	 *
	 * @param mapPresenter the map.
	 * @param applicationId the application id.
	 * @param mapId the map id.
	 */
	@ExportStaticMethod("initializeMap")
	public static void initializeMap(JsMapPresenterImpl mapPresenter, String applicationId, String mapId) {
		GeomajasServerExtension.getInstance().initializeMap(mapPresenter.getMapPresenter(),
				applicationId, mapId);
	}

	/**
	 * Add a handler that is called whenever the client starts communicating with the back-end.
	 *
	 * @param handler
	 *            The actual handler (closure).
	 * @return The registration for the handler. Using this object the handler can be removed again.
	 */
	@ExportStaticMethod("addDispatchStartedHandler")
	public static JsHandlerRegistration addDispatchStartedHandler(final org.geomajas.javascript.api.client.map.event
			.DispatchStartedHandler handler) {
		HandlerRegistration registration = GwtCommandDispatcher.getInstance().addDispatchStartedHandler(
				new org.geomajas.gwt.client.command.event.DispatchStartedHandler() {

					public void onDispatchStarted(DispatchStartedEvent event) {
						handler.onDispatchStarted(new org.geomajas.javascript.api.client.map.event.DispatchStartedEvent());
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
	public static JsHandlerRegistration addDispatchStoppedHandler(final DispatchStoppedHandler handler) {
		HandlerRegistration registration = GwtCommandDispatcher.getInstance().addDispatchStoppedHandler(
				new org.geomajas.gwt.client.command.event.DispatchStoppedHandler() {

					public void onDispatchStopped(DispatchStoppedEvent event) {
						handler.onDispatchStopped(new org.geomajas.javascript.api.client.map.event.DispatchStoppedEvent());
					}
				});
		return new JsHandlerRegistration(new HandlerRegistration[] { registration });
	}

}