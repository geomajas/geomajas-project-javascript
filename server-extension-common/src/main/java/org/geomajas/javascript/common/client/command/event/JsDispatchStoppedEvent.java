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

package org.geomajas.javascript.common.client.command.event;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.event.JsEvent;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * This event is thrown when the command dispatcher stops dispatching - when the response has returned.
 *
 * @author Pieter De Graef
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsDispatchStoppedEvent extends JsEvent<JsDispatchStoppedHandler> implements Exportable {

	/** No-arguments constructor. */
	public JsDispatchStoppedEvent() {
	}

	@Override
	protected void dispatch(JsDispatchStoppedHandler handler) {
		handler.onDispatchStopped(this);
	}

	@Override
	public Class<JsDispatchStoppedHandler> getType() {
		return JsDispatchStoppedHandler.class;
	}
}