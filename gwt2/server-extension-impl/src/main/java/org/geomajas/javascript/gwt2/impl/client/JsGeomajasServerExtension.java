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

import org.geomajas.gwt2.client.GeomajasServerExtension;
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
	public static void initializeMap(JsMapPresenterImpl mapPresenter, String applicationId, String id) {
		GeomajasServerExtension.getInstance().initializeMap(mapPresenter.getMapPresenter(),
				applicationId, id);
	}
	
	@ExportStaticMethod("other")
	public static void other(String applicationId, String id) {
		System.out.println();
	}
}