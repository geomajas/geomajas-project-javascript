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

import com.google.web.bindery.event.shared.Event;
import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.JsImageWidget;
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
public class JsImageWidgetDeselectedEvent extends JsEvent<JsImageWidgetDeselectedHandler> implements Exportable {

	private JsImageWidget imageWidget;

	private Event<?> source;

	/**
	 * Create a new event for a widget that was deselected.
	 *
	 * @param imageWidget The widget that was deselected.
	 * @param source The source event that caused the deselection.
	 */
	public JsImageWidgetDeselectedEvent(JsImageWidget imageWidget, Event<?> source) {
		this.imageWidget = imageWidget;
		this.source = source;
	}

	/**
	 * Get the widget that was deselected.
	 *
	 * @return The widget.
	 */
	public JsImageWidget getImageWidget() {
		return imageWidget;
	}

	/**
	 * Get the root event that caused the deselection.
	 *
	 * @return The event.
	 */
	public Event<?> getSource() {
		return source;
	}

	@Override
	protected void dispatch(JsImageWidgetDeselectedHandler handler) {
		handler.onWidgetDeselected(this);
	}

	@Override
	public Class<JsImageWidgetDeselectedHandler> getType() {
		return JsImageWidgetDeselectedHandler.class;
	}
}

