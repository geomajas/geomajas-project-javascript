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

package org.geomajas.javascript.api.client.map;

import com.google.gwt.user.client.ui.Widget;
import org.geomajas.annotation.Api;
import org.geomajas.gwt2.client.gfx.TransformableWidget;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

/**
 * Exportable for the {@link org.geomajas.gwt2.client.gfx.TransformableWidget}.
 *
 * @author Youri Flement
 * @since 1.0.0
 */
@Api(allMethods = true)
@Export
public interface JsTransformableWidget extends Exportable {

	/**
	 * Returns the {@link Widget} aspect.
	 */
	Widget asWidget();

	/**
	 * Translate this vector object over the specified distance in the x and y direction (negative axis). This
	 * translation will stay into effect until this method gets called again.
	 *
	 * @param deltaX
	 *            distance in x direction
	 * @param deltaY
	 *            distance in y direction
	 */
	void setTranslation(double deltaX, double deltaY);

	/**
	 * Scale this vector object with the specified factors in the x and y direction.
	 *
	 * @param scaleX
	 *            scale factor in the x-direction
	 * @param scaleY
	 *            scale factor in the y-direction
	 */
	void setScale(double scaleX, double scaleY);

	/**
	 * Activating the fixed size state will make sure that this object will retain it's size while being scaled. The
	 * scale will still influence the object position though.
	 *
	 * @param fixedSize
	 *            If true, objects will receive a fixed size. In this case, the size should be expressed in pixels. If
	 *            false, the this object will resize according to the scale value.
	 */
	void setFixedSize(boolean fixedSize);

	/**
	 * Has the fixed size state been activated or not?
	 *
	 * @return Is this object keeping a fixed size?
	 */
	boolean isFixedSize();

	/**
	 * Transform the widget to a {@link TransformableWidget}.
	 * @return The javascript transformable widget as a regular transformable widget.
	 */
	@NoExport
	TransformableWidget toTransformableWidget();

}
