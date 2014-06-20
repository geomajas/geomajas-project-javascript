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

package org.geomajas.javascript.gwt2.impl.client.map;

import com.google.web.bindery.event.shared.HandlerRegistration;
import org.geomajas.annotation.Api;
import org.geomajas.gwt2.client.event.LayerAddedEvent;
import org.geomajas.gwt2.client.event.LayerRemovedEvent;
import org.geomajas.gwt2.client.event.MapCompositionHandler;
import org.geomajas.gwt2.client.event.MapInitializationEvent;
import org.geomajas.gwt2.client.event.MapInitializationHandler;
import org.geomajas.javascript.api.client.event.JsMapInitializationEvent;
import org.geomajas.javascript.api.client.event.JsMapInitializationHandler;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.geomajas.javascript.api.client.map.JsMapEventBus;
import org.geomajas.javascript.api.client.event.JsHandlerRegistration;
import org.geomajas.javascript.api.client.event.JsLayersModelChangedEvent;
import org.geomajas.javascript.api.client.event.JsLayersModelChangedHandler;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Central event bus for handler registration and event firing.
 * Default implementation of {@link JsMapEventBus}.
 *
 * @author Pieter De Graef
 * @since 1.0.0
 */
@Export("JsMapEventBus")
@ExportPackage("gm.event")
@Api(allMethods = true)
public class JsMapEventBusImpl implements JsMapEventBus, Exportable {

	private JsMapPresenter mapPresenter;

	/** No-args constructor for GWT. */
	public JsMapEventBusImpl() {
	}

	/**
	 * Construct event bus for specific map.
	 * @param mapPresenter JsMapPresenter
	 */
	public JsMapEventBusImpl(JsMapPresenter mapPresenter) {
		this.mapPresenter = mapPresenter;
	}

	@Override
	public JsHandlerRegistration addLayersModelChangedHandler(final JsLayersModelChangedHandler handler) {
		HandlerRegistration registration = ((JsMapPresenterImpl) mapPresenter).getMapPresenter().getEventBus()
				.addMapCompositionHandler(new MapCompositionHandler() {

					@Override
					public void onLayerRemoved(LayerRemovedEvent event) {
						handler.onLayersModelChanged(new JsLayersModelChangedEvent(mapPresenter.getLayersModel()));
					}

					@Override
					public void onLayerAdded(LayerAddedEvent event) {
						handler.onLayersModelChanged(new JsLayersModelChangedEvent(mapPresenter.getLayersModel()));
					}
				});
		return new JsHandlerRegistration(new HandlerRegistration[] { registration });
	}

	@Override
	public JsHandlerRegistration addMapInitializationHandler(final JsMapInitializationHandler handler) {
		HandlerRegistration registration = ((JsMapPresenterImpl) mapPresenter).getMapPresenter().getEventBus().
				addMapInitializationHandler(new MapInitializationHandler() {
					@Override
					public void onMapInitialized(MapInitializationEvent event) {
						handler.onMapInitialized(new JsMapInitializationEvent(mapPresenter));
					}
				});
		return new JsHandlerRegistration(new HandlerRegistration[] { registration });
	}
}