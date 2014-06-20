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
package org.geomajas.javascript.client.map.layer;

import junit.framework.Assert;
import org.geomajas.gwt2.client.map.layer.VectorServerLayer;
import org.geomajas.javascript.api.client.map.layer.JsLayer;
import org.geomajas.javascript.gwt2.impl.client.JsGwtImpl;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsLayerFactoryRegistryImpl;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsLayerImpl;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsVectorServerLayerFactoryImpl;
import org.geomajas.javascript.gwt2.impl.client.map.layer.JsVectorServerLayerImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;

public class JsVectorServerLayerFactoryTest {

	@Mock
	private VectorServerLayer vectorServerLayer;

	@Before
	public void registerFactory() {
		MockitoAnnotations.initMocks(this);
		JsGwtImpl.getInstance().getJsLayerFactoryRegistry().registerJsLayerFactory(new JsVectorServerLayerFactoryImpl());
	}

	@Test
	public void vectorServerLayerFactoryRegisteredCreatesCorrectJsLayerTest() {
		JsLayer layer = JsGwtImpl.getInstance().getJsLayerFactoryRegistry().createJsLayer(vectorServerLayer);

		Assert.assertTrue(layer instanceof JsVectorServerLayerImpl);
	}

	@Test
	public void vectorServerLayerFactoryNotRegisteredTest() {
		// undo the before action
		JsGwtImpl.getInstance().setJsLayerFactoryRegistry(new JsLayerFactoryRegistryImpl());

		JsLayer layer = JsGwtImpl.getInstance().getJsLayerFactoryRegistry().createJsLayer(vectorServerLayer);

		Assert.assertFalse(layer instanceof JsVectorServerLayerImpl);
		Assert.assertTrue(layer instanceof JsLayerImpl);
	}
}