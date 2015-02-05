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

package org.geomajas.javascript.api.client.map.feature;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Call-back object for asynchronous methods that deal with an array of features.
 *
 * @author Oliver May
 */
@Export
@ExportClosure
public interface JsFeatureArrayCallback extends Exportable {

	void execute(JsFeatureArrayHolder featureArrayHolder);

	/**
	 * Wrapper around a feature array, because the GWT exporter doesn't know how to handle arrays in a closure.
	 *
	 * @author Pieter De Graef
	 */
	@Export
	@ExportPackage("gm.feature")
	public class JsFeatureArrayHolder implements Exportable {

		private JsFeature[] features;

		public JsFeatureArrayHolder() {
		}

		public JsFeatureArrayHolder(JsFeature[] features) {
			this.features = features;
		}

		public JsFeature[] getFeatures() {
			return features;
		}

		public void setFeatures(JsFeature[] features) {
			this.features = features;
		}
	}
}