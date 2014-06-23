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

import org.geomajas.geometry.Bbox;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt2.client.map.ViewPort;
import org.geomajas.javascript.api.client.map.JsViewPort;
import org.geomajas.javascript.api.client.map.JsViewPortTransformationService;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.map.ViewPort}.
 *
 * @author Jan De Moerloose
 */
@Export("ViewPort")
@ExportPackage("gm")
public class JsViewPortImpl implements JsViewPort, Exportable {

	private ViewPort viewPort;

	public JsViewPortImpl() {
	}

	/**
	 * Create a new ViewPort.
	 *
	 * @param viewPort The ViewPort behind a map in the GWT face.
	 */
	public JsViewPortImpl(ViewPort viewPort) {
		this.viewPort = viewPort;
	}

	@Override
	public void applyPosition(Coordinate coordinate) {
		viewPort.applyPosition(coordinate);
	}

	@Override
	public Coordinate getPosition() {
		return viewPort.getPosition();
	}

	@Override
	public double getResolution() {
		return viewPort.getResolution();
	}

	@Override
	public Bbox getBounds() {
		return viewPort.getBounds();
	}

	@Override
	public void applyResolution(double resolution) {
		viewPort.applyResolution(resolution);
	}

	@Override
	public void applyBounds(Bbox bounds) {
		viewPort.applyBounds(bounds);
	}

	@Override
	public Bbox getMaximumBounds() {
		return viewPort.getMaximumBounds();
	}

	@Override
	public JsViewPortTransformationService getTransformationService() {
		return new JsViewPortTransformationServiceImpl(viewPort.getTransformationService());
	}


}