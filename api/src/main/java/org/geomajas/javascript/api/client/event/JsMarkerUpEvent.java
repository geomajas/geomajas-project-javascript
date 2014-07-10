package org.geomajas.javascript.api.client.event;

import com.google.gwt.event.dom.client.MouseUpEvent;
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

