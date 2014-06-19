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
package org.geomajas.javascript.gwt2.impl.client.exporter.map;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.geomajas.annotation.Api;
import org.geomajas.gwt2.client.GeomajasImpl;
import org.geomajas.gwt2.client.map.MapConfiguration;
import org.geomajas.gwt2.client.map.MapPresenter;
import org.geomajas.javascript.api.client.map.JsLayersModel;
import org.geomajas.javascript.api.client.map.JsMapConfiguration;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.geomajas.javascript.api.client.map.JsViewPort;
import org.geomajas.javascript.api.client.map.event.JsEventBus;
import org.geomajas.javascript.gwt2.impl.client.exporter.map.event.JsEventBusImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

/**
 * Exports {@link org.geomajas.gwt2.client.map.MapPresenter}.
 *
 * @author Jan De Moerloose
 */
@Export("Map")
@ExportPackage("gm")
public class JsMapPresenterImpl implements JsMapPresenter, Exportable {

	private MapPresenter mapPresenter;

	private JsViewPort viewPort;

	private HTMLPanel parent;

	private JsLayersModel layersModel;

	private JsEventBus eventBus;

	/**
	 * No-arguments constructor. If this is removed, we get errors from the GWT exporter...
	 */
	public JsMapPresenterImpl() {
	}

	/**
	 * Create a facade for a {@link MapPresenter}, available trough JavaScript. Use this constructor if you want to
	 * fetch a server configuration.
	 *
	 * @param elementId the DOM element ID onto which to attach the map.
	 */
	@Api
	public JsMapPresenterImpl(String elementId) {
		createParent(elementId);
		mapPresenter = GeomajasImpl.getInstance().createMapPresenter();
		eventBus = new JsEventBusImpl(this);
		viewPort = new JsViewPortImpl(mapPresenter.getViewPort());
		layersModel = new JsLayersModelImpl(mapPresenter.getLayersModel());
		mapPresenter.setSize(getParentWidth(), getParentHeight());
		parent.add(mapPresenter);
	}

	/**
	 * Create a facade for a {@link MapPresenter}, available trough JavaScript.
	 *
	 * @param elementId the DOM element ID onto which to attach the map.
	 * @param configuration the configuration.
	 */
	@Api
	public JsMapPresenterImpl(String elementId, JsMapConfiguration configuration) {
		createParent(elementId);
		MapConfiguration mapConfiguration = ((JsMapConfigurationImpl) configuration).getMapConfiguration();
		this.mapPresenter = GeomajasImpl.getInstance().createMapPresenter(mapConfiguration, getParentWidth(),
				getParentHeight());
		viewPort = new JsViewPortImpl(mapPresenter.getViewPort());
	}

	// ------------------------------------------------------------------------
	// Map implementation:
	// ------------------------------------------------------------------------

	/**
	 * Returns the view port associated with this map. The view port regulates zooming and panning around the
	 * map, but also presents transformation methods for transforming vector objects between the different render
	 * spaces.
	 *
	 * @return Returns the view port.
	 */
	public JsViewPort getViewPort() {
		return viewPort;
	}

	@Override
	public JsLayersModel getLayersModel() {
		return layersModel;
	}

	@Override
	public JsEventBus getEventBus() {
		return eventBus;
	}

	@Override
	public void setCursor(String cursor) {
		mapPresenter.setCursor(cursor);
	}

	// ------------------------------------------------------------------------
	// Other public methods:
	// ------------------------------------------------------------------------

	@NoExport
	public MapPresenter getMapPresenter() {
		return (MapPresenter) mapPresenter;
	}

	protected void createParent(String elementId) {
		parent = HTMLPanel.wrap(Document.get().getElementById(elementId));
	}

	protected int getParentWidth() {
		return parent.getElement().getClientWidth();
	}

	protected int getParentHeight() {
		return parent.getElement().getClientWidth();
	}


}