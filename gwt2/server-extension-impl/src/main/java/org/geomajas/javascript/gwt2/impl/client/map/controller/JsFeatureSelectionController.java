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

import org.geomajas.gwt2.client.controller.FeatureSelectionController;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;

/**
 * @author Oliver May
 */
@Export("FeatureSelectionController")
@ExportPackage("gm.controller")

public class JsFeatureSelectionController extends JsMapControllerWrapperImpl {

	public JsFeatureSelectionController() {
		super(new FeatureSelectionController());
	}

	/**
	 * Create the selection controller and apply the selection type.
	 *
	 * @param selectionMethod the selection method to use
	 */
	public JsFeatureSelectionController(String selectionMethod) {
		this();
		setSelectionMethod(selectionMethod);
	}

	/**
	 * Set the selection method of the feature selection controller. See FeatureSelectionController.SelectionMethod.
	 *
	 * @param selectionMethod the selection method to use
	 */
	public void setSelectionMethod(String selectionMethod) {
		((FeatureSelectionController) getMapController()).setSelectionMethod(
				FeatureSelectionController.SelectionMethod.valueOf(selectionMethod));
	}
}
