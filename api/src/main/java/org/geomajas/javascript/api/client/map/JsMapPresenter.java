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
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.map.MapPresenter}.
 * 
 * @author Jan De Moerloose
 * @since 1.0.0
 */
@Api(allMethods = true)
public interface JsMapPresenter extends Exportable {

	/**
	 * Returns the {@link ViewPort} associated with this map. The view port regulates zooming and panning around the
	 * map, but also presents transformation methods for transforming vector objects between the different render
	 * spaces.
	 * 
	 * @return Returns the view port.
	 */
	JsViewPort getViewPort();

}