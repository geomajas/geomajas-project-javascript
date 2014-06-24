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

package org.geomajas.javascript.api.client.map;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.event.JsFeatureDeselectedHandler;
import org.geomajas.javascript.api.client.event.JsFeatureSelectedHandler;
import org.geomajas.javascript.api.client.event.JsHandlerRegistration;
import org.geomajas.javascript.api.client.event.JsLayerAddedHandler;
import org.geomajas.javascript.api.client.event.JsLayerRemovedHandler;
import org.geomajas.javascript.api.client.event.JsMapInitializationHandler;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.map.MapEventBus}.
 *
 * @author David Debuck
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
public interface JsMapEventBus extends Exportable {

	/**
	 * Register a {@link JsLayerAddedHandler} to the eventbus.
	 *
	 * @param handler JsLayerAddedHandler
	 * @return JsHandlerRegistration
	 */
	JsHandlerRegistration addLayerAddedHandler(JsLayerAddedHandler handler);

	/**
	 * Register a {@link JsLayerAddedHandler} to the eventbus.
	 *
	 * @param handler JsLayerAddedHandler
	 * @return JsHandlerRegistration
	 */
	JsHandlerRegistration addLayerRemovedHandler(JsLayerRemovedHandler handler);

	/**
	 * Add a map initialization handler.
	 *
	 * @param handler the handler
	 * @return the handler registration
	 */
	JsHandlerRegistration addMapInitializationHandler(JsMapInitializationHandler handler);

	/**
	 * Add a feature selection handler.
	 *
	 * @param selectedHandler
	 * @param deselectedHandler
	 * @return JsHandlerRegistration
	 */
	JsHandlerRegistration addFeatureSelectionHandler(JsFeatureSelectedHandler selectedHandler,
													 JsFeatureDeselectedHandler deselectedHandler);

}