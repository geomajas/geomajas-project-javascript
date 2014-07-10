package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.JsImageWidget;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Author: Youri Flement
 * Date: 10/07/14
 * Time: 08:42
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsMarkerDownEvent extends JsEvent<JsMarkerDownHandler> implements Exportable {

	private JsImageWidget imageWidget;

	public JsMarkerDownEvent(JsImageWidget imageWidget) {
		this.imageWidget = imageWidget;
	}

	public JsImageWidget getImageWidget() {
		return imageWidget;
	}

	@Override
	protected void dispatch(JsMarkerDownHandler handler) {
		handler.onMarkerDown(this);
	}

	@Override
	public Class<JsMarkerDownHandler> getType() {
		return JsMarkerDownHandler.class;
	}
}
