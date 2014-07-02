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

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Image;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt2.client.gfx.AbstractTransformableWidget;
import org.geomajas.javascript.api.client.map.JsImageWidget;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportOverlay;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Implementation of a {@link JsImageWidget}.
 *
 * @author Youri Flement
 */
@Export("ImageWidget")
@ExportPackage("gm")
public class JsImageWidgetImpl extends AbstractTransformableWidget
		implements JsImageWidget, Exportable, ExportOverlay<JsImageWidgetImpl> {

	private int anchorX;

	private int anchorY;

	public JsImageWidgetImpl() {
		this("", 0, 0);
	}

	public JsImageWidgetImpl(String url, int anchorX, int anchorY) {
		super(new Image(url), 0, 0);
		this.anchorX = anchorX;
		this.anchorY = anchorY;
		asWidget().getElement().getStyle().setPosition(Position.ABSOLUTE);
	}

	/**
	 * Create a new transformable image widget.
	 *
	 * @param url The URL to the image.
	 * @param x The x-coordinate of the image.
	 * @param y The y-coordinate of the image.
	 * @param anchorX The x-coordinate of the anchor of the image.
	 * @param anchorY The y-coordinate of the anchor of the image.
	 * @return A new image widget.
	 */
	@ExportConstructor
	public static JsImageWidgetImpl constructor(String url, double x, double y, int anchorX, int anchorY) {
		JsImageWidgetImpl imageWidget = new JsImageWidgetImpl(url, anchorX, anchorY);
		imageWidget.setCoordinate(new Coordinate(x, y));
		return imageWidget;
	}

	@Override
	public void setCoordinate(Coordinate coordinate) {
		setWorldPosition(coordinate);
	}

	@Override
	public Coordinate getCoordinate() {
		return getWorldPosition();
	}

	@Override
	public void setScreenPosition(double left, double top) {
		asWidget().getElement().getStyle().setLeft(left - anchorX, Unit.PX);
		asWidget().getElement().getStyle().setTop(top - anchorY, Unit.PX);
	}
}
