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

package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.feature.JsFeature;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * This event is thrown when a feature has been selected.
 *
 * @author Pieter De Graef
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsFeatureSelectedEvent extends JsEvent<JsFeatureSelectedHandler> implements Exportable {

	private JsFeature feature;

	/**
	 * Constructor.
	 *
	 * @param feature selected event
	 */
	public JsFeatureSelectedEvent(JsFeature feature) {
		this.feature = feature;
	}

	@Override
	public Class<JsFeatureSelectedHandler> getType() {
		return JsFeatureSelectedHandler.class;
	}

	@Override
	protected void dispatch(JsFeatureSelectedHandler handler) {
		handler.onFeatureSelected(this);
	}

	/**
	 * Get selected feature.
	 *
	 * @return selected feature
	 */
	public JsFeature getFeature() {
		return feature;
	}
}