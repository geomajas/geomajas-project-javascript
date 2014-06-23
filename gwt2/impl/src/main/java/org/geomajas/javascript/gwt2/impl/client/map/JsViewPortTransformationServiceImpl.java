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

import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt2.client.map.ViewPortTransformationService;
import org.geomajas.javascript.api.client.map.JsRenderSpace;
import org.geomajas.javascript.api.client.map.JsViewPortTransformationService;
import org.geomajas.javascript.gwt2.impl.client.JsGwtImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.map.ViewPortTransformationService}.
 *
 * @author Jan Venstermans
 */
@Export("ViewPortTransformationService")
@ExportPackage("gm")
public class JsViewPortTransformationServiceImpl implements JsViewPortTransformationService, Exportable {

	private ViewPortTransformationService viewPortTransformationService;

	public JsViewPortTransformationServiceImpl() {
	}

	public JsViewPortTransformationServiceImpl(ViewPortTransformationService viewPortTransformationService) {
		this.viewPortTransformationService = viewPortTransformationService;
	}

	@Override
	public Coordinate transform(Coordinate coordinate, JsRenderSpace from, JsRenderSpace to) {
		return viewPortTransformationService.transform(coordinate,
				JsGwtImpl.getInstance().getJsGwtUtil().toRenderSpace(from),
				JsGwtImpl.getInstance().getJsGwtUtil().toRenderSpace(to));
	}
}