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
package org.geomajas.javascript.gwt2.impl.client.service;

import org.geomajas.gwt2.client.GeomajasServerExtension;
import org.geomajas.javascript.api.client.service.JsEndPointService;
import org.geomajas.javascript.gwt2.impl.client.JsGeomajasServerExtensionImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;

/**
 * Exports {@link org.geomajas.gwt2.client.service.EndPointService}.
 *
 * @author David Debuck
 */
@Export("EndPointService")
@ExportPackage("gm.service")
public class JsEndPointServiceImpl implements JsEndPointService {

	private GeomajasServerExtension geomajasServerExtension;

	public JsEndPointServiceImpl() {
	}

	public JsEndPointServiceImpl(JsGeomajasServerExtensionImpl geomajasServerExtension) {
		this.geomajasServerExtension = GeomajasServerExtension.getInstance();
	}

	@Override
	public String getCommandServiceUrl() {
		return geomajasServerExtension.getEndPointService().getCommandServiceUrl();
	}

	@Override
	public void setCommandServiceUrl(String commandServiceUrl) {
		geomajasServerExtension.getEndPointService().setCommandServiceUrl(commandServiceUrl);
	}

	@Override
	public String getLegendServiceUrl() {
		return geomajasServerExtension.getEndPointService().getLegendServiceUrl();
	}

	@Override
	public void setLegendServiceUrl(String legendServiceUrl) {
		geomajasServerExtension.getEndPointService().setLegendServiceUrl(legendServiceUrl);
	}

	@Override
	public String getDispatcherUrl() {
		return geomajasServerExtension.getEndPointService().getDispatcherUrl();
	}

	@Override
	public void setDispatcherUrl(String dispatcherUrl) {
		geomajasServerExtension.getEndPointService().setDispatcherUrl(dispatcherUrl);
	}

}