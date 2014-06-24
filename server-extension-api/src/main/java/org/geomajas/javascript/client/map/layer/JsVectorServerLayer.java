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

import org.geomajas.annotation.Api;
import org.geomajas.javascript.api.client.map.layer.JsFeaturesSupported;

/**
 * Exports {@link org.geomajas.gwt2.client.map.layer.VectorServerLayer}.
 *
 * @author Jan Venstermans
 * @since 1.0.0
 */
@Api
public interface JsVectorServerLayer extends JsServerLayer, JsFeaturesSupported {

}