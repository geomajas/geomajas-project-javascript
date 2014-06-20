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

package org.geomajas.javascript.common.client.map.spatial;

import org.geomajas.geometry.Bbox;
import org.geomajas.javascript.api.client.spatial.JsBboxService;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Service that defines all possible operations on bounding boxes.
 *
 * @author Pieter De Graef
 */
@Export("BboxService")
@ExportPackage("gm.spatial")
public class JsBboxServiceImpl implements JsBboxService, Exportable {

	public JsBboxServiceImpl() {
	}

	/**
	 * Calculate the union of two bounding boxes.
	 *
	 * @param one
	 *            The first bounding box.
	 * @param two
	 *            The second bounding box.
	 * @return The union of the two given bounding boxes.
	 */
	public Bbox union(Bbox one, Bbox two) {
		return org.geomajas.geometry.service.BboxService.union(one, two);
	}
}