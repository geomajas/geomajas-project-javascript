package org.geomajas.javascript.api.client.event;

import com.google.gwt.event.dom.client.MouseMoveEvent;
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
public class JsMarkerMovedEvent extends JsEvent<JsMarkerMovedHandler> implements Exportable {

	private JsImageWidget imageWidget;

	private MouseMoveEvent event;

	public JsMarkerMovedEvent(JsImageWidget imageWidget, MouseMoveEvent event) {
		this.imageWidget = imageWidget;
		this.event = event;
	}

	public JsImageWidget getImageWidget() {
		return imageWidget;
	}

	public MouseMoveEvent getSource() {
		return event;
	}

	@Override
	protected void dispatch(JsMarkerMovedHandler handler) {
		handler.onMarkerMoved(this);
	}

	@Override
	public Class<JsMarkerMovedHandler> getType() {
		return JsMarkerMovedHandler.class;
	}
}

