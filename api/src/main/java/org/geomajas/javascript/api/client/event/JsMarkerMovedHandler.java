package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.annotation.UserImplemented;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.Exportable;

/**
 * Author: Youri Flement
 * Date: 10/07/14
 * Time: 08:52
 */
@Export
@ExportClosure
@Api(allMethods = true)
@UserImplemented
public interface JsMarkerMovedHandler extends JsHandler, Exportable {

	void onMarkerMoved(JsMarkerMovedEvent jsMarkerEvent);

}
