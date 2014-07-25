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

package org.geomajas.javascript.gwt2.impl.client.plugin.tms.layer;

import org.geomajas.gwt2.plugin.tms.client.layer.TmsLayerConfiguration;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

/**
 * Exportable JavaScript implementation of {@link org.geomajas.gwt2.plugin.tms.client.layer.TmsLayerConfiguration}.
 *
 * @author Dosi Bingov
 * @since 1.0.0
 */
@Export("TmsLayerConfiguration")
@ExportPackage("gm")
public class JsTmsLayerConfiguration implements Exportable {
	private TmsLayerConfiguration configuration;

	public JsTmsLayerConfiguration() {
		configuration = new TmsLayerConfiguration();
	}

	// ------------------------------------------------------------------------
	// Getters and setters:
	// ------------------------------------------------------------------------
	/**
	 * Get the base URL to the WMS service. This URL should not contain any WMS parameters.
	 *
	 * @return The base URL to the WMS service.
	 */
	public String getBaseUrl() {
		return configuration.getBaseUrl();
	}

	/**
	 * Set the base URL to the WMS service. This URL should not contain any WMS parameters.
	 *
	 * @param baseUrl The base URL to the WMS service.
	 */
	public void setBaseUrl(String baseUrl) {
		configuration.setBaseUrl(baseUrl);
	}

	/**
	 * Get the file extension used when fetching tiles.
	 *
	 * @return The file extension.
	 */
	public String getFileExtension() {
		return configuration.getFileExtension();
	}

	/**
	 * Set the file extension used when fetching tiles. If the file extension does not start with a '.', this method
	 * will add it.
	 *
	 * @param fileExtension The file extension.
	 */
	public void setFileExtension(String fileExtension) {
		configuration.setFileExtension(fileExtension);
	}

	/**
	 * Converts {@link org.geomajas.javascript.gwt2.impl.client.plugin.tms.layer.JsTmsLayerConfiguration} to
	 * {@link TmsLayerConfiguration}.
	 *
	 * @return {@link org.geomajas.gwt2.plugin.wms.client.layer.WmsLayerConfiguration}
	 */
	@NoExport
	public TmsLayerConfiguration toGwt() {
		return configuration;
	}

}