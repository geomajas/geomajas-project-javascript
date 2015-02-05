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
package org.geomajas.javascript.api.client.map;

import org.geomajas.annotation.Api;
import org.timepedia.exporter.client.ExportInstanceMethod;

/**
 * Exports {@link org.geomajas.gwt2.client.map.ViewPort}.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Api(allMethods = true)
public enum  JsRenderSpace {

	/**
	 * <p>
	 * World space describes a rendering space where all objects are expressed in the coordinate reference system of the
	 * map they are drawn in. As a result, all objects within world space move about with the view on the map.
	 * </p>
	 * <p>
	 * Let's say for example that a rectangle is rendered on a map with CRS lon-lat. The rectangle has origin (118,34)
	 * and width and height both equal to 1. Than this rectangle will cover the city of Los Angeles.
	 * </p>
	 */
	WORLD("world"),

	/**
	 * <p>
	 * Screen space describes a rendering space where all objects are expressed in pixels with the origin in the top
	 * left corner of the map. Objects rendered in screen will always occupy a fixed position on the map. They are
	 * immobile and are not affected by changes in the map view.
	 * </p>
	 */
	SCREEN("screen");

	private String jsValue;


	JsRenderSpace(String jsValue) {
		this.jsValue = jsValue;
	}

	/**
	 * Get the String representation, as can be referenced in javascript.
	 * @return
	 */
	public String getJsValue() {
		return jsValue;
	}

	/**
	 * Returns String representation of the {@link JsRenderSpace}.
	 * This string can be used in javascript files.
	 *
	 * @param jsRenderSpaceValue
	 * @return {@link JsRenderSpace} value linked to the String
	 */
	@ExportInstanceMethod
	public static JsRenderSpace getType(String jsRenderSpaceValue) {
		for (JsRenderSpace jsRenderSpace : JsRenderSpace.values()) {
			if (jsRenderSpace.getJsValue().equals(jsRenderSpaceValue)) {
				return jsRenderSpace;
			}
		}
		return null;
	}
}