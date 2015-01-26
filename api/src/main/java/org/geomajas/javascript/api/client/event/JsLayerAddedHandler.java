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

package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.annotation.UserImplemented;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.Exportable;

/**
 * Handler for catching event that indicate a layer configuration has been loaded into
 * and added to the {@link org.geomajas.plugin.jsapi.map.LayersModel}.
 * Extends part of {@link org.geomajas.gwt2.client.event.MapCompositionHandler}.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Export
@ExportClosure
@Api(allMethods = true)
@UserImplemented
public interface JsLayerAddedHandler extends JsHandler, Exportable {

	/**
	 * Called when a new layer has been added to the map model.
	 *
	 * @param event
	 *            The event.
	 */
	void onLayerAdded(JsLayerAddedEvent event);
}