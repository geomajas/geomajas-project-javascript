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
package org.geomajas.javascript.gwt2.impl.client.map;

import java.util.ArrayList;
import java.util.List;

import org.geomajas.geometry.Bbox;
import org.geomajas.gwt2.client.map.MapConfiguration;
import org.geomajas.gwt2.client.map.MapConfiguration.CrsType;
import org.geomajas.gwt2.client.map.MapConfigurationImpl;
import org.geomajas.javascript.api.client.map.JsMapConfiguration;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

/**
 * Exports {@link org.geomajas.gwt2.client.map.MapConfiguration}.
 * 
 * @author Jan De Moerloose
 */
@Export("MapConfiguration")
@ExportPackage("gm")
public class JsMapConfigurationImpl implements JsMapConfiguration, Exportable {

	private MapConfiguration mapConfiguration;

	public JsMapConfigurationImpl() {
		mapConfiguration = new MapConfigurationImpl();
	}

	@Override
	public Bbox getMaxBounds() {
		return mapConfiguration.getMaxBounds();
	}

	@Override
	public void setMaxBounds(Bbox maxBounds) {
		mapConfiguration.setMaxBounds(maxBounds);
	}

	@Override
	public String getCrs() {
		return mapConfiguration.getCrs();
	}

	@Override
	public void setCrs(String crs, String crsType) {
		mapConfiguration.setCrs(crs, CrsType.valueOf(crsType));
	}

	@Override
	public void setCrs(String crs, double unitLength) {
		mapConfiguration.setCrs(crs, unitLength);
	}

	@Override
	public double[] getResolutions() {
		double[] resolutions = new double[mapConfiguration.getResolutions().size()];
		int i = 0;
		for (double d : mapConfiguration.getResolutions()) {
			resolutions[i++] = d;
		}
		return resolutions;
	}

	@Override
	public void setResolutions(double[] resolutions) {
		List<Double> l = new ArrayList<Double>();
		for (int i = 0; i < resolutions.length; i++) {
			l.add(resolutions[i]);
		}
		mapConfiguration.setResolutions(l);
	}

	@Override
	public double getMinimumResolution() {
		return mapConfiguration.getMinimumResolution();
	}

	@Override
	public void setMinimumResolution(double minimumResolution) {
		mapConfiguration.setMinimumResolution(minimumResolution);
	}

	@Override
	public void setInitBounds(Bbox initBounds) {
		mapConfiguration.setHintValue(MapConfiguration.INITIAL_BOUNDS, initBounds);
	}

	@NoExport
	public MapConfiguration toGwt() {
		return (MapConfiguration) mapConfiguration;
	}
}