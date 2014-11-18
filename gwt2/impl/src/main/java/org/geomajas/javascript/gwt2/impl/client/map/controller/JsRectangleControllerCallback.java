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

package org.geomajas.javascript.gwt2.impl.client.map.controller;

import org.geomajas.geometry.Bbox;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Call-back object for
 * {@link org.geomajas.javascript.gwt2.impl.client.map.controller.JsRectangleController}.
 *
 * @author Jan Venstermans
 */
@Export
@ExportClosure
public interface JsRectangleControllerCallback extends Exportable {

	void execute(JsBboxHolder bbox);

	/**
	 * Wrapper around a {@link Bbox}.
	 *
	 * @author Jan Venstermans
	 */
	@Export
	@ExportPackage("gm.feature")
	public class JsBboxHolder implements Exportable {

		private Bbox bbox;

		public JsBboxHolder() {
		}

		public JsBboxHolder(Bbox bbox) {
			this.bbox = bbox;
		}

		public Bbox getBbox() {
			return bbox;
		}

		public void setBbox(Bbox bbox) {
			this.bbox = bbox;
		}
	}
}