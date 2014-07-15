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

import com.google.gwt.user.client.ui.Widget;
import org.geomajas.gwt2.client.gfx.TransformableWidget;
import org.geomajas.javascript.api.client.map.JsTransformableWidget;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Implementation of a {@link JsTransformableWidget}. This class delegates everything to the underlying
 * {@link TransformableWidget}.
 *
 * @author Youri Flement
 */
@Export("TransformableWidget")
@ExportPackage("gm")
public class JsTransformableWidgetImpl implements JsTransformableWidget, Exportable {

	private TransformableWidget widget;

	public JsTransformableWidgetImpl() {
	}

	public JsTransformableWidgetImpl(TransformableWidget widget) {
		this.widget = widget;
	}

	@Override
	public Widget asWidget() {
		return widget.asWidget();
	}

	@Override
	public void setTranslation(double deltaX, double deltaY) {
		widget.setTranslation(deltaX, deltaY);
	}

	@Override
	public void setScale(double scaleX, double scaleY) {
		widget.setScale(scaleX, scaleY);
	}

	@Override
	public void setFixedSize(boolean fixedSize) {
		widget.setFixedSize(fixedSize);
	}

	@Override
	public boolean isFixedSize() {
		return widget.isFixedSize();
	}

	@Override
	public TransformableWidget toTransformableWidget() {
		return widget;
	}

}
