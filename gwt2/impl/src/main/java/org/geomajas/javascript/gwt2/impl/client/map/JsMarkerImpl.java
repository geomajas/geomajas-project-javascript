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

package org.geomajas.javascript.gwt2.impl.client.map;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import org.geomajas.geometry.Coordinate;
import org.geomajas.gwt2.client.gfx.AbstractTransformableWidget;
import org.geomajas.javascript.api.client.event.JsMarkerDeselectedEvent;
import org.geomajas.javascript.api.client.event.JsMarkerDeselectedHandler;
import org.geomajas.javascript.api.client.event.JsMarkerSelectedEvent;
import org.geomajas.javascript.api.client.event.JsMarkerSelectedHandler;
import org.geomajas.javascript.api.client.map.JsMarker;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportOverlay;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Implementation of a {@link org.geomajas.javascript.api.client.map.JsMarker}.
 *
 * @author Youri Flement
 * @author Dosi Bingov
 */
@Export("Marker")
@ExportPackage("gm")
public class JsMarkerImpl extends AbstractTransformableWidget
		implements JsMarker, Exportable, ExportOverlay<JsMarkerImpl>, MouseDownHandler,
		MouseUpHandler {

	private int anchorX;

	private int anchorY;

	private Collection<JsMarkerSelectedHandler> selectedHandlers;

	private Collection<JsMarkerDeselectedHandler> deselectedHandlers;

	protected JsMarkerImpl(IsWidget panel, int anchorX, int anchorY) {
		super(panel, 0, 0);
		this.anchorX = anchorX;
		this.anchorY = anchorY;
		asWidget().getElement().getStyle().setPosition(Position.ABSOLUTE);

		selectedHandlers = new ArrayList<JsMarkerSelectedHandler>();
		deselectedHandlers = new ArrayList<JsMarkerDeselectedHandler>();

		// Add handlers to the widget that will fire events when the widget is clicked or released:
		asWidget().addDomHandler(this, MouseDownEvent.getType());
		asWidget().addDomHandler(this, MouseUpEvent.getType());
	}

	/**
	 * Create a new transformable marker widget.
	 *
	 * @param element dom element object.
	 * @param anchorX The x-coordinate of the anchor of the marker.
	 * @param anchorY The y-coordinate of the anchor of the marker.
	 * @return A new marker widget.
	 */
	@ExportConstructor
	public static JsMarkerImpl constructor(Element element, int anchorX, int anchorY) {
		JsMarkerImpl marker = new JsMarkerImpl(new HTMLPanel(element.getString()), anchorX, anchorY);
		return marker;
	}

	/**
	 * Create a new transformable image widget.
	 *
	 * @param url     The URL to the image.
	 * @param coordinate The x-coordinate and the y-coordinate of the marker.
	 * @param anchorX The x-coordinate of the anchor of the marker.
	 * @param anchorY The y-coordinate of the anchor of the marker.
	 * @return A new marker widget.
	 */
	@ExportConstructor
	public static JsMarkerImpl constructor(String url, Coordinate coordinate, int anchorX, int anchorY) {
		JsMarkerImpl marker = new JsMarkerImpl(new Image(url), anchorX, anchorY);
		marker.setCoordinate(coordinate);
		return marker;
	}


	@Override
	public void addWidgetSelectedHandler(JsMarkerSelectedHandler handler) {
		selectedHandlers.add(handler);
	}

	@Override
	public void addWidgetDeselectedHandler(JsMarkerDeselectedHandler handler) {
		deselectedHandlers.add(handler);
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
	public void select() {
		// Notify the handlers:
		for (JsMarkerSelectedHandler handler : selectedHandlers) {
			handler.onWidgetSelected(new JsMarkerSelectedEvent(this));
		}
	}

	@Override
	public void deselect() {
		// Notify handlers:
		for (JsMarkerDeselectedHandler handler : deselectedHandlers) {
			handler.onWidgetDeselected(new JsMarkerDeselectedEvent(this));
		}
	}

	@Override
	public Element getElement() {
		return asWidget().getElement();
	}

	@Override
	public void setScreenPosition(double left, double top) {
		asWidget().getElement().getStyle().setLeft(left - anchorX, Unit.PX);
		asWidget().getElement().getStyle().setTop(top - anchorY, Unit.PX);
	}

	@Override
	public void onMouseDown(MouseDownEvent event) {
		// Put the widget to the bottom so the (possible) mouse move events are not lost on a 'higher' widget:
		DOM.appendChild(asWidget().getParent().getElement(), asWidget().getElement());
		select();
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		deselect();
		event.preventDefault();
	}

}
