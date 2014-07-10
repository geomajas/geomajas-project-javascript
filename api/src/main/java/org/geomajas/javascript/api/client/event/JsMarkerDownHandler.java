package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.annotation.UserImplemented;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportClosure;
import org.timepedia.exporter.client.Exportable;

/**
 * Author: Youri Flement
 * Date: 10/07/14
 * Time: 08:49
 */
@Export
@ExportClosure
@Api(allMethods = true)
@UserImplemented
public interface JsMarkerDownHandler extends JsHandler, Exportable {

	void onMarkerDown(JsMarkerDownEvent jsMarkerEvent);

}
