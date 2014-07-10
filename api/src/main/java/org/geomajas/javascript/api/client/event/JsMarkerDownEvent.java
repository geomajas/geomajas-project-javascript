package org.geomajas.javascript.api.client.event;

import com.google.gwt.event.dom.client.MouseDownEvent;
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

	private MouseDownEvent source;

	public JsMarkerDownEvent(JsImageWidget imageWidget, MouseDownEvent source) {
		this.imageWidget = imageWidget;
		this.source = source;
	}

	public JsImageWidget getImageWidget() {
		return imageWidget;
	}

	public MouseDownEvent getSource() {
		return source;
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
