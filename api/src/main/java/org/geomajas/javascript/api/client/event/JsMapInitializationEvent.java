/*
 * This is part of Geomajas, a GIS framework, http://www.geomajas.org/.
 *
 * Copyright 2008-2015 Geosparc nv, http://www.geosparc.com/, Belgium.
 *
 * The program is available in open source according to the GNU Affero
 * General Public License. All contributions in this program are covered
 * by the Geomajas Contributors License Agreement. For full licensing
 * details, see LICENSE.txt in the project root.
 */

package org.geomajas.javascript.api.client.event;

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Exports {@link org.geomajas.gwt2.client.event.MapInitializationEvent}.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
@ExportPackage("gm.event")
public class JsMapInitializationEvent extends JsEvent<JsMapInitializationHandler> implements Exportable {

	private JsMapPresenter mapPresenter;

	/**
	 * Default constructor.
	 * @param mapPresenter
	 */
	public JsMapInitializationEvent(JsMapPresenter mapPresenter) {
		this.mapPresenter = mapPresenter;
	}

	@Override
	protected void dispatch(JsMapInitializationHandler handler) {
		handler.onMapInitialized(this);
	}

	@Override
	public Class<JsMapInitializationHandler> getType() {
		return JsMapInitializationHandler.class;
	}

	/**
	 * Get the {@link JsMapPresenter} of the initialized map.
	 * @return mapPresenter
	 */
	public JsMapPresenter getMapPresenter() {
		return mapPresenter;
	}
}