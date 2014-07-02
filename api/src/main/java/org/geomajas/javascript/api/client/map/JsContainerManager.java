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
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

/**
 * Exportable for {@link org.geomajas.gwt2.client.map.ContainerManager}.
 *
 * @author Youri Flement
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
public interface JsContainerManager extends Exportable {

	/**
	 * Create a new container in world space to which one can add transformable widgets and return it. Note that all
	 * objects drawn into such a container should be expressed in world coordinates (the CRS of the map). These objects
	 * will also be automatically redrawn when the view port on the map changes.
	 * New containers are automatically drawn on top of all other containers - that includes both world and screen
	 * containers and vector object containers.
	 *
	 * @return Returns the world widget container.
	 */
	JsTransformableWidgetContainer addWorldWidgetContainer();

}
