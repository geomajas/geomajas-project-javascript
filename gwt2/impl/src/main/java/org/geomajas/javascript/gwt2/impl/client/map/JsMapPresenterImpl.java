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

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.HumanInputEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import org.geomajas.gwt2.client.GeomajasImpl;
import org.geomajas.gwt2.client.controller.AbstractMapController;
import org.geomajas.gwt2.client.controller.MapController;
import org.geomajas.gwt2.client.map.MapPresenter;
import org.geomajas.javascript.api.client.map.JsContainerManager;
import org.geomajas.javascript.api.client.map.JsMapEventBus;
import org.geomajas.javascript.api.client.map.JsMapPresenter;
import org.geomajas.javascript.api.client.map.JsViewPort;
import org.geomajas.javascript.api.client.map.controller.JsMapController;
import org.geomajas.javascript.api.client.map.layer.JsLayersModel;
import org.geomajas.javascript.gwt2.impl.client.map.controller.JsMapControllerWrapperImpl;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsLayersModelImpl;
import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportPackage;
import org.timepedia.exporter.client.Exportable;
import org.timepedia.exporter.client.NoExport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Exports {@link org.geomajas.gwt2.client.map.MapPresenter}.
 *
 * @author Jan De Moerloose
 */
@Export("Map")
@ExportPackage("gm")
public final class JsMapPresenterImpl implements JsMapPresenter, Exportable {

	private MapPresenter mapPresenter;

	private JsViewPort viewPort;

	private HTMLPanel parent;

	private IsWidget mapAsWidget;

	private JsLayersModel layersModel;

	private JsMapEventBus eventBus;

	private JsContainerManager containerManager;

	// Constructor is private
	private JsMapPresenterImpl() {
	}

	/**
	 * Create a facade for a {@link MapPresenter}, available trough JavaScript.
	 *
	 * @param elementId the DOM element ID onto which to attach the map.
	 * @param mapConfiguration map configuration see {@link JsMapConfigurationImpl}.
	 */
	@ExportConstructor
	public static JsMapPresenterImpl constructor(String elementId, JsMapConfigurationImpl mapConfiguration) {
		JsMapPresenterImpl jsMapPresenter =  new JsMapPresenterImpl();
		jsMapPresenter.construct(elementId, mapConfiguration);
		return jsMapPresenter;
	}

	/**
	 * Create a facade for a {@link MapPresenter}, available trough JavaScript.
	 *
	 * @param elementId the DOM element ID onto which to attach the map.
	 */
	@ExportConstructor
	public static JsMapPresenterImpl constructor(String elementId) {
		JsMapPresenterImpl jsMapPresenter =  new JsMapPresenterImpl();
		jsMapPresenter.construct(elementId);
		return jsMapPresenter;
	}

	// ------------------------------------------------------------------------
	// Map implementation:
	// ------------------------------------------------------------------------

	private void construct(String elementId) {
		mapPresenter = GeomajasImpl.getInstance().createMapPresenter();
		setParentHtmlElementId(elementId);
		initialize();
		mapPresenter.setSize(getParentWidth(), getParentHeight());
	}

	private void construct(String elementId, JsMapConfigurationImpl mapConfiguration) {
		setParentHtmlElementId(elementId);
		mapPresenter = GeomajasImpl.getInstance().createMapPresenter(mapConfiguration.toGwt(),
				getParentWidth(), getParentHeight());
		initialize();
	}

	private void initialize() {
		addMapToParent();
		eventBus = new JsMapEventBusImpl(this);
		viewPort = new JsViewPortImpl(mapPresenter.getViewPort());
		layersModel = new JsLayersModelImpl(mapPresenter.getLayersModel());
		containerManager = new JsContainerManagerImpl(mapPresenter.getContainerManager());
	}

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
	public JsMapEventBus getEventBus() {
		return eventBus;
	}

	@Override
	public JsContainerManager getContainerManager() {
		return containerManager;
	}

	@Override
	public void setCursor(String cursor) {
		mapPresenter.setCursor(cursor);
	}

	@Override
	public String getParentHtmlElementId() {
		try {
			return parent.getElement().getId();
		} catch (Exception ex) {
			// when there is no parent yet.
			return null;
		}
	}

	@Override
	public void setSize(int width, int height) {
		mapPresenter.setSize(width, height);
	}

	public IsWidget getMapAsWidget() {
		return mapAsWidget;
	}

	//-----------------------------------------------
	// JsMapController as main map controller
	//-----------------------------------------------

	@Override
	public void setMapController(JsMapController controller) {
		if (controller != null) {
			controller.setMapPresenter(this);
			mapPresenter.setMapController(new JsController(controller));
		} else {
			mapPresenter.setMapController(null);
		}
	}

	@Override
	public JsMapController getMapController() {
		MapController controller = mapPresenter.getMapController();
		return new JsMapControllerWrapperImpl(controller);
	}

	//-----------------------------------------------
	// JsMapController as listener
	//-----------------------------------------------

	@Override
	public boolean addMapListener(JsMapController mapListener) {
		if (mapListener != null) {
			mapListener.setMapPresenter(this);
			return mapPresenter.addMapListener(new JsController(mapListener));
		}
		return false;
	}

	@Override
	public boolean removeMapListener(JsMapController mapListener) {
		if (mapListener != null) {
			for (JsController jsController : getJsControllerMapListeners()) {
				if (mapListener.equals(jsController.getWrappedJsMapController())) {
					return mapPresenter.removeMapListener(jsController);
				}
			}
		}
		return false;
	}

	@Override
	public JsMapController[] getMapListeners() {
		List<JsMapController> jsMapControllerList = new ArrayList<JsMapController>();
		for (JsController jsController : getJsControllerMapListeners()) {
			jsMapControllerList.add(jsController.getWrappedJsMapController());
		}
		return jsMapControllerList.toArray(new JsMapController[jsMapControllerList.size()]);
	}

	// ------------------------------------------------------------------------
	// Other public methods:
	// ------------------------------------------------------------------------

	@NoExport
	public MapPresenter getMapPresenter() {
		return (MapPresenter) mapPresenter;
	}

	public void setParentHtmlElementId(String elementId) {
		parent = HTMLPanel.wrap(Document.get().getElementById(elementId));
	}

	public void addMapToParent() {
		int i = parent.getWidgetCount();
		parent.add(mapPresenter);
		mapAsWidget = parent.getWidget(i);
	}

	protected int getParentWidth() {
		return parent.getElement().getClientWidth();
	}

	protected int getParentHeight() {
		return parent.getElement().getClientHeight();
	}

	protected Collection<JsController> getJsControllerMapListeners() {
		List<JsController> jsControllerList = new ArrayList<JsController>();
		for (MapController mapController : mapPresenter.getMapListeners()) {
			if (mapController instanceof JsController) {
				jsControllerList.add(((JsController) mapController));
			}
		}
		return jsControllerList;
	}

	/**
	 * JavaScript to GWT controller wrapper.
	 *
	 * @author Pieter De Graef
	 */
	private class JsController extends AbstractMapController {

		private JsMapController mapController;

		public JsController(JsMapController mapController) {
			super(false);
			this.mapController = mapController;
		}

		public void onActivate(MapPresenter presenter) {
			if (mapController.getActivationHandler() != null) {
				mapController.getActivationHandler().execute();
			}
		}

		public void onDeactivate(MapPresenter presenter) {
			if (mapController.getDeactivationHandler() != null) {
				mapController.getDeactivationHandler().execute();
			}
		}

		public void onMouseMove(MouseMoveEvent event) {
			if (mapController.getMouseMoveHandler() != null) {
				mapController.getMouseMoveHandler().onMouseMove(event);
			}
		}

		public void onMouseOver(MouseOverEvent event) {
			if (mapController.getMouseOverHandler() != null) {
				mapController.getMouseOverHandler().onMouseOver(event);
			}
		}

		public void onMouseOut(MouseOutEvent event) {
			if (mapController.getMouseOutHandler() != null) {
				mapController.getMouseOutHandler().onMouseOut(event);
			}
		}

		public void onDown(HumanInputEvent<?> event) {
			if (mapController.getDownHandler() != null) {
				mapController.getDownHandler().onDown(event);
			}
		}

		public void onUp(HumanInputEvent<?> event) {
			if (mapController.getUpHandler() != null) {
				mapController.getUpHandler().onUp(event);
			}
		}

		public void onDrag(HumanInputEvent<?> event) {
			if (mapController.getDragHandler() != null) {
				mapController.getDragHandler().onDrag(event);
			}
		}

		public void onDoubleClick(DoubleClickEvent event) {
			if (mapController.getDoubleClickHandler() != null) {
				mapController.getDoubleClickHandler().onDoubleClick(event);
			}
		}

		public JsMapController getWrappedJsMapController() {
			return mapController;
		}
	}


}