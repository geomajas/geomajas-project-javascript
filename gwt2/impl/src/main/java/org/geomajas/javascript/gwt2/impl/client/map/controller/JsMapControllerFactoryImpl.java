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
import org.geomajas.gwt2.client.controller.MapController;
import org.geomajas.gwt2.client.controller.NavigationController;
import org.geomajas.gwt2.client.controller.ZoomToRectangleController;
import org.geomajas.javascript.api.client.map.controller.JsMapController;
import org.geomajas.javascript.gwt2.impl.client.map.JsMapPresenterImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.ExportStaticMethod;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.GeomajasServerExtension}.
 *
 * @author Jan De Moerloose
 */
@Export("MapControllerFactory")
@ExportPackage("gm")
public final class JsMapControllerFactoryImpl implements Exportable {

	/**
	 * Enum for the id of the controllers. The String id is the reference from javascript.
	 */
	private enum ControllerKey {
		NAVIGATION("navigation"),
		ZOOM_TO_RECTANGLE("zoomToRectangle"),
		FEATURE_SELECTION_DRAG("featureSelectionDrag"),
		FEATURE_SELECTION_SINGLE("featureSelectionSingle");

		private String keyString;

		private ControllerKey(String keyString) {
			this.keyString = keyString;
		}

		public String getKeyString() {
			return keyString;
		}
	}

	private JsMapControllerFactoryImpl() {
	}


	/**
	 * Create a known controller for the map. Different implementations may 'know' different controllers, so it's best
	 * to check with the implementing class.
	 *
	 * @param map
	 *            The onto which the controller should be applied.
	 * @param controllerId
	 *            The unique ID for the map controller (implementation specific).
	 * @return The map controller, or null if it could not be found.
	 */
	@ExportStaticMethod("createMapController")
	public static JsMapController createMapController(JsMapPresenterImpl map, String controllerId) {
		ControllerKey controllerKey = null;
		// convert controllerId to ControllerKey
		for (ControllerKey key : ControllerKey.values()) {
			if (key.getKeyString().equals(controllerId)) {
				controllerKey = key;
			}
		}
		MapController controller = null;
		if (controllerKey != null) {
			switch (controllerKey) {
				case NAVIGATION:
					controller = new NavigationController();
					break;
				case ZOOM_TO_RECTANGLE:
					controller = new ZoomToRectangleController();
					break;
				case FEATURE_SELECTION_DRAG:
					controller = new FeatureSelectionController(
							FeatureSelectionController.SelectionMethod.CLICK_AND_DRAG);
					break;
				case FEATURE_SELECTION_SINGLE:
					controller = new FeatureSelectionController(
							FeatureSelectionController.SelectionMethod.SINGLE_SELECTION);
					break;
			}
			/* These GWT controllers have no counterpart (yet) in GWT2:
			} else if (ToolId.TOOL_MEASURE_DISTANCE_MODE.equalsIgnoreCase(id)) {
			return createMapController(map, new MeasureDistanceController(mapWidget));
			} else if (ToolId.TOOL_FEATURE_INFO.equalsIgnoreCase(id)) {
			return createMapController(map, new FeatureInfoController(mapWidget, 3));
			} else if (ToolId.TOOL_EDIT.equalsIgnoreCase(id)) {
			return createMapController(map, new ParentEditController(mapWidget));
			}
			*/
		}
		if (controller != null) {
			return new JsMapControllerImpl(map, controller);
		}
		return null;
	}
}