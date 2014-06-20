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

import com.google.web.bindery.event.shared.HandlerRegistration;
import org.geomajas.annotation.Api;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;


/**
 * Registration for a singular handler. This registration allows the handler to be unregistered (a.k.a removed) again.
 *
 * @author Pieter De Graef
 * @since 1.0.0
 */
@Export
@ExportPackage("gm.event")
@Api(allMethods = true)
public class JsHandlerRegistration implements Exportable {

	private HandlerRegistration[] handlerRegistration;

	/**
	 * Constructor.
	 *
	 * @param handlerRegistration handler registration
	 */
	public JsHandlerRegistration(HandlerRegistration[] handlerRegistration) {
		this.handlerRegistration = handlerRegistration;
	}

	/**
	 * Removes the handler associated with this registration object. This only works if the handler is still attached to
	 * the event source...so don't call this twice.
	 */
	public void removeHandler() {
		for (int i = 0; i < handlerRegistration.length; i++) {
			handlerRegistration[i].removeHandler();
		}
	}
}