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

package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.JsMarker;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Event that is thrown when a widget is deselected.
 *
 * @author Youri Flement
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsMarkerDeselectedEvent extends JsEvent<JsMarkerDeselectedHandler> implements Exportable {

	private JsMarker marker;

	/**
	 * Create a new event for a widget that was deselected.
	 *
	 * @param marker The widget that was deselected.
	 */
	public JsMarkerDeselectedEvent(JsMarker marker) {
		this.marker = marker;
	}

	/**
	 * Get the widget that was deselected.
	 *
	 * @return The widget.
	 */
	public JsMarker getMarker() {
		return marker;
	}

	@Override
	protected void dispatch(JsMarkerDeselectedHandler handler) {
		handler.onWidgetDeselected(this);
	}

	@Override
	public Class<JsMarkerDeselectedHandler> getType() {
		return JsMarkerDeselectedHandler.class;
	}
}

