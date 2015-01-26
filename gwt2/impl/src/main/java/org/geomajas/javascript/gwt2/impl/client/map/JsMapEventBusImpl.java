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

package org.geomajas.javascript.gwt2.impl.client.map;

import com.google.web.bindery.event.shared.HandlerRegistration;
import org.geomajas.annotation.Api;
import org.geomajas.gwt2.client.event.FeatureDeselectedEvent;
import org.geomajas.gwt2.client.event.FeatureSelectedEvent;
import org.geomajas.gwt2.client.event.FeatureSelectionHandler;
import org.geomajas.gwt2.client.event.LayerAddedEvent;
import org.geomajas.gwt2.client.event.LayerRemovedEvent;
import org.geomajas.gwt2.client.event.MapCompositionHandler;
import org.geomajas.gwt2.client.event.MapInitializationEvent;
import org.geomajas.gwt2.client.event.MapInitializationHandler;
import org.geomajas.javascript.api.client.event.JsFeatureDeselectedEvent;
import org.geomajas.javascript.api.client.event.JsFeatureDeselectedHandler;
import org.geomajas.javascript.api.client.event.JsFeatureSelectedEvent;
import org.geomajas.javascript.api.client.event.JsFeatureSelectedHandler;
import org.geomajas.javascript.api.client.event.JsHandlerRegistration;
import org.geomajas.javascript.api.client.event.JsLayerAddedEvent;
import org.geomajas.javascript.api.client.event.JsLayerAddedHandler;
import org.geomajas.javascript.api.client.event.JsLayerRemovedEvent;
import org.geomajas.javascript.api.client.event.JsLayerRemovedHandler;
import org.geomajas.javascript.api.client.event.JsMapInitializationEvent;
import org.geomajas.javascript.api.client.event.JsMapInitializationHandler;
import org.geomajas.javascript.api.client.map.JsMapEventBus;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.geomajas.javascript.api.client.map.feature.JsFeature;
import org.geomajas.javascript.api.client.map.layer.JsFeaturesSupported;
import org.geomajas.javascript.gwt2.impl.client.JsGwtImpl;
import org.geomajas.javascript.gwt2.impl.client.map.feature.JsFeatureImpl;
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
	public JsHandlerRegistration addLayerAddedHandler(final JsLayerAddedHandler handler) {
		HandlerRegistration registration = ((JsMapPresenterImpl) mapPresenter).getMapPresenter().getEventBus()
				.addMapCompositionHandler(new MapCompositionHandler() {

					@Override
					public void onLayerRemoved(LayerRemovedEvent event) {
						// do nothing: is separate handler
					}

					@Override
					public void onLayerAdded(LayerAddedEvent event) {
						handler.onLayerAdded(new JsLayerAddedEvent(
								JsGwtImpl.getInstance().getJsLayerFactoryRegistry().createJsLayer(event.getLayer())));
					}
				});
		return new JsHandlerRegistration(new HandlerRegistration[] { registration });
	}

	@Override
	public JsHandlerRegistration addLayerRemovedHandler(final JsLayerRemovedHandler handler) {
		HandlerRegistration registration = ((JsMapPresenterImpl) mapPresenter).getMapPresenter().getEventBus()
				.addMapCompositionHandler(new MapCompositionHandler() {

					@Override
					public void onLayerRemoved(LayerRemovedEvent event) {
						handler.onLayerRemoved(new JsLayerRemovedEvent(
								JsGwtImpl.getInstance().getJsLayerFactoryRegistry().createJsLayer(event.getLayer())));
					}

					@Override
					public void onLayerAdded(LayerAddedEvent event) {
						// do nothing: is separate handler
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

	@Override
	public JsHandlerRegistration addFeatureSelectionHandler(final JsFeatureSelectedHandler selectedHandler,
															final JsFeatureDeselectedHandler deselectedHandler) {

		HandlerRegistration registration = ((JsMapPresenterImpl) mapPresenter).getMapPresenter().getEventBus()
				.addFeatureSelectionHandler(new FeatureSelectionHandler() {

					@Override
					public void onFeatureSelected(FeatureSelectedEvent event) {
						JsFeature feature = new JsFeatureImpl(event.getFeature(),
								(JsFeaturesSupported) mapPresenter.getLayersModel()
								.getLayer(event.getLayer().getId()));

						selectedHandler.onFeatureSelected(new JsFeatureSelectedEvent(
								feature
						));
					}

					@Override
					public void onFeatureDeselected(FeatureDeselectedEvent event) {
						JsFeature feature = new JsFeatureImpl(event.getFeature(),
								(JsFeaturesSupported) mapPresenter.getLayersModel()
								.getLayer(event.getLayer().getId()));

						deselectedHandler.onFeatureDeselected(new JsFeatureDeselectedEvent(
								feature
						));

					}

				});

		return new JsHandlerRegistration(new HandlerRegistration[] { registration });

	}
}