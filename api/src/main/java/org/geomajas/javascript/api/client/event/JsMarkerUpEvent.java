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

import com.google.gwt.event.dom.client.MouseUpEvent;
import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.JsImageWidget;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 *
 * @author Youri Flement
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsMarkerUpEvent extends JsEvent<JsMarkerUpHandler> implements Exportable {

	private JsImageWidget imageWidget;

	private MouseUpEvent event;

	public JsMarkerUpEvent(JsImageWidget imageWidget, MouseUpEvent event) {
		this.imageWidget = imageWidget;
		this.event = event;
	}

	public JsImageWidget getImageWidget() {
		return imageWidget;
	}

	public MouseUpEvent getSource() {
		return event;
	}

	@Override
	protected void dispatch(JsMarkerUpHandler handler) {
		handler.onMarkerUp(this);
	}

	@Override
	public Class<JsMarkerUpHandler> getType() {
		return JsMarkerUpHandler.class;
	}
}

