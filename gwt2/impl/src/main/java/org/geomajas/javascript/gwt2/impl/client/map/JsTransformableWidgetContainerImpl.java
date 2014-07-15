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
import org.geomajas.gwt2.client.gfx.TransformableWidgetContainer;
import org.geomajas.javascript.api.client.map.JsMarker;
import org.geomajas.javascript.api.client.map.JsTransformableWidget;
import org.geomajas.javascript.api.client.map.JsTransformableWidgetContainer;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;

/**
 * Implementation of the {@link org.geomajas.javascript.api.client.map.JsTransformableWidgetContainer}.
 * This is a wrapper of the {@link org.geomajas.gwt2.client.gfx.TransformableWidgetContainer}.
 *
 * @author Youri Flement
 */
@Export("TransformableWidgetContainer")
@ExportPackage("gm")
public class JsTransformableWidgetContainerImpl implements JsTransformableWidgetContainer, Exportable {

	protected TransformableWidgetContainer transformableWidgetContainer;

	public JsTransformableWidgetContainerImpl() {
	}

	public JsTransformableWidgetContainerImpl(TransformableWidgetContainer container) {
		this.transformableWidgetContainer = container;
	}

	@Override
	public boolean removeWidget(JsTransformableWidget widget) {
		return transformableWidgetContainer.remove(widget.toTransformableWidget());
	}

	@Override
	public void add(JsTransformableWidget child) {
		transformableWidgetContainer.add(child.toTransformableWidget());
	}

	@Override
	public JsTransformableWidget getChild(int index) {
		return new JsTransformableWidgetImpl(transformableWidgetContainer.getChild(index));
	}

	@Override
	public Widget asWidget() {
		return transformableWidgetContainer.asWidget();
	}

	@Override
	public void setTranslation(double deltaX, double deltaY) {
		transformableWidgetContainer.setTranslation(deltaX, deltaY);
	}

	@Override
	public void setScale(double scaleX, double scaleY) {
		transformableWidgetContainer.setScale(scaleX, scaleY);
	}

	@Override
	public void setFixedSize(boolean fixedSize) {
		transformableWidgetContainer.setFixedSize(fixedSize);
	}

	@Override
	public boolean isFixedSize() {
		return transformableWidgetContainer.isFixedSize();
	}

	@Override
	public TransformableWidget toTransformableWidget() {
		return transformableWidgetContainer;
	}

	@Override
	public void insert(JsTransformableWidget child, int beforeIndex) {
		transformableWidgetContainer.insert(child.toTransformableWidget(), beforeIndex);
	}

	@Override
	public boolean remove(JsTransformableWidget child) {
		return transformableWidgetContainer.remove(child.toTransformableWidget());
	}

	@Override
	public int indexOf(JsTransformableWidget child) {
		return transformableWidgetContainer.indexOf(child.toTransformableWidget());
	}

	@Override
	public void bringToFront(JsTransformableWidget child) {
		transformableWidgetContainer.bringToFront(child.toTransformableWidget());
	}

	@Override
	public void clear() {
		transformableWidgetContainer.clear();
	}

	@Override
	public int getChildCount() {
		return transformableWidgetContainer.getChildCount();
	}

	@Override
	public void addMarker(JsMarker widget) {
		transformableWidgetContainer.add(widget);
	}

}
