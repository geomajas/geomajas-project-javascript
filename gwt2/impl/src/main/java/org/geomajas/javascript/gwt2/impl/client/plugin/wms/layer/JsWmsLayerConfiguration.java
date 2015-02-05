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

package org.geomajas.javascript.gwt2.impl.client.plugin.wms.layer;

import org.geomajas.gwt2.plugin.wms.client.layer.WmsLayerConfiguration;
import org.geomajas.gwt2.plugin.wms.client.service.WmsService;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

/**
 * JsWmsLayerConfiguration class implementation.
 *
 * @author Dosi Bingov
 * @since 1.0.0
 */
@Export("WmsLayerConfiguration")
@ExportPackage("gm")
public class JsWmsLayerConfiguration implements Exportable {
	private WmsLayerConfiguration configuration;

	public JsWmsLayerConfiguration() {
		configuration = new WmsLayerConfiguration();
	}


	// ------------------------------------------------------------------------
	// Getters and setters:
	// ------------------------------------------------------------------------

	/**
	 * Get the WMS version used. Default value is '1.3.0'.
	 *
	 * @return The WMS version.
	 */
	public String getVersion() {
		return configuration.getVersion().toString();
	}

	/**
	 * Set the WMS version. Default value is '1.3.0'.
	 *
	 * @param version The WMS version.
	 */
	public void setVersion(String version) {
		if ("1.1.1".equals(version)) {
			configuration.setVersion(WmsService.WmsVersion.V1_1_1);
		}

		if (("1.3.0").equals(version)) {
			configuration.setVersion(WmsService.WmsVersion.V1_3_0);
		}
	}

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
	 * Get the layers parameter used in the GetMap requests.
	 *
	 * @return The GetMap layers parameter.
	 */
	public String getLayers() {
		return configuration.getLayers();
	}

	/**
	 * Set the layers parameter used in the GetMap requests.
	 *
	 * @param layers The GetMap layers parameter.
	 */
	public void setLayers(String layers) {
		configuration.setLayers(layers);
	}

	/**
	 * Get the minimum resolution for which this layer should be visible (maximum zoom in).
	 *
	 * @return the minimum resolution
	 */
	public double getMinimumResolution() {
		return configuration.getMinimumResolution();
	}

	/**
	 * Set the minimum resolution for which this layer should be visible (maximum zoom in).
	 *
	 * @param minimumResolution the minimum resolution
	 */
	public void setMinimumResolution(double minimumResolution) {
		configuration.setMinimumResolution(minimumResolution);
	}

	/**
	 * Get the maximum resolution for which this layer should be visible (maximum zoom out).
	 *
	 * @return the maximum resolution
	 */
	public double getMaximumResolution() {
		return configuration.getMaximumResolution();
	}

	/**
	 * Set the maximum resolution for which this layer should be visible (maximum zoom out).
	 *
	 * @param maximumResolution the maximum resolution
	 */
	public void setMaximumResolution(double maximumResolution) {
		configuration.setMaximumResolution(maximumResolution);
	}

	/**
	 * Get the GetMap image format. The default value is "image/png".
	 *
	 * @return The GetMap image format.
	 */
	public String getFormat() {
		return configuration.getFormat();
	}

	/**
	 * Set the GetMap image format. The default value is "image/png".
	 *
	 * @param format The GetMap image format.
	 */
	public void setFormat(String format) {
		configuration.setFormat(format);
	}

	/**
	 * Converts {@link JsWmsLayerConfiguration} to {@link WmsLayerConfiguration}.
	 *
	 * @return {@link WmsLayerConfiguration}
	 */
	@NoExport
	public WmsLayerConfiguration toGwt() {
		return configuration;
	}

}