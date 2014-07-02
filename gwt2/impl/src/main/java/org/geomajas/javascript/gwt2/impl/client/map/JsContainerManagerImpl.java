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

package org.geomajas.javascript.gwt2.impl.client.map;

import org.geomajas.gwt2.client.map.ContainerManager;
import org.geomajas.javascript.api.client.map.JsContainerManager;
import org.geomajas.javascript.api.client.map.JsTransformableWidgetContainer;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Implementation of the {@link org.geomajas.javascript.api.client.map.JsContainerManager}. This is
 * a simple wrapper of the {@link org.geomajas.gwt2.client.map.ContainerManager}.
 *
 * @author Youri Flement
 */
@Export("ContainerManager")
@ExportPackage("gm")
public class JsContainerManagerImpl implements JsContainerManager, Exportable {

	private ContainerManager manager;

	public JsContainerManagerImpl() {
	}

	public JsContainerManagerImpl(ContainerManager manager) {
		this.manager = manager;
	}

	@Override
	public JsTransformableWidgetContainer addWorldWidgetContainer() {
		return new JsTransformableWidgetContainerImpl(manager.addWorldWidgetContainer());
	}

}
