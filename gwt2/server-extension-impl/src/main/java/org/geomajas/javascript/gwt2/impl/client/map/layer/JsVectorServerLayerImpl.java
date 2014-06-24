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
package org.geomajas.javascript.gwt2.impl.client.map.layer;

import org.geomajas.gwt2.client.map.feature.Feature;
import org.geomajas.gwt2.client.map.layer.Layer;
import org.geomajas.gwt2.client.map.layer.VectorServerLayer;
import org.geomajas.javascript.api.client.map.feature.JsFeature;
import org.geomajas.javascript.client.map.layer.JsVectorServerLayer;
import org.geomajas.javascript.gwt2.impl.client.map.feature.JsFeatureImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;

import java.util.Collection;

/**
 * Exports {@link org.geomajas.gwt2.client.map.layer.VectorServerLayer}.
 *
 * @author Jan Venstermans
 */
@Export("VectorServerLayer")
@ExportPackage("gm.layer")
public class JsVectorServerLayerImpl extends JsLayerImpl implements JsVectorServerLayer {

	public JsVectorServerLayerImpl() {
	}

	public JsVectorServerLayerImpl(Layer layer) {
		super(layer);
	}

	@Override
	public String getServerLayerId() {
		return getLayerAsVectorServerLayer().getServerLayerId();
	}

	private VectorServerLayer getLayerAsVectorServerLayer() {
		return (VectorServerLayer) layer;
	}

	@Override
	public void setFilter(String filter) {
		getLayerAsVectorServerLayer().setFilter(filter);
	}

	@Override
	public String getFilter() {
		return getLayerAsVectorServerLayer().getFilter();
	}

	@Override
	public boolean isFeatureSelected(String featureId) {
		return getLayerAsVectorServerLayer().isFeatureSelected(featureId);
	}

	@Override
	public boolean selectFeature(JsFeature feature) {
		return getLayerAsVectorServerLayer().selectFeature((Feature) feature);
	}

	@Override
	public boolean deselectFeature(JsFeature feature) {
		return getLayerAsVectorServerLayer().deselectFeature((Feature) feature);
	}

	@Override
	public void clearSelectedFeatures() {
		getLayerAsVectorServerLayer().clearSelectedFeatures();
	}

	@Override
	public JsFeature[] getSelectedFeatures() {
		Collection<Feature> selection = getLayerAsVectorServerLayer().getSelectedFeatures();
		JsFeature[] features = new JsFeature[selection.size()];
		int count = 0;
		for (Feature feature : selection) {
			features[count] = new JsFeatureImpl(feature, this);
			count++;
		}
		return features;
	}
}