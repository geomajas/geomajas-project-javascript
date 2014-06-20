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
import org.geomajas.javascript.api.client.event.JsMapInitializationHandler;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;
import org.geomajas.javascript.api.client.event.JsHandlerRegistration;
import org.geomajas.javascript.api.client.event.JsLayersModelChangedHandler;

/**
 * Exports {@link org.geomajas.gwt2.client.map.MapEventBus}.
 *
 * @author David Debuck
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
public interface JsMapEventBus extends Exportable {

	/**
	 * Register a handler to the eventbus.
	 *
	 * @param handler JsLayersModelChangedHandle
	 * @return JsHandlerRegistration
	 */
	JsHandlerRegistration addLayersModelChangedHandler(JsLayersModelChangedHandler handler);

	/**
	 * Add a map initialization handler.
	 *
	 * @param handler the handler
	 * @return the handler registration
	 */
	JsHandlerRegistration addMapInitializationHandler(JsMapInitializationHandler handler);

}