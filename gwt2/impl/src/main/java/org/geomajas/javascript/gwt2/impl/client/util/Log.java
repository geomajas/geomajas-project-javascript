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

package org.geomajas.javascript.gwt2.impl.client.util;


/**
 * Logging in javascript.
 *
 * @author Dosi Bingov
 */
public final class Log {
	private Log() {
	}

	/**
	 * Javascript console logging.
	 *
	 * @param message
	 */
	public static native void log(String message)  /*-{
		if (@org.geomajas.javascript.gwt2.impl.client.util.Log::isConsoleAvailable()) {
			console.log(message);
		}
	}-*/;

	/**
	 * Log error in Javascript console.
	 *
	 * @param message
	 */
	public static native void error(String message)  /*-{
		if (@org.geomajas.javascript.gwt2.impl.client.util.Log::isConsoleAvailable()) {
			console.error(message);
		}
	}-*/;


	/**
	 * Check if console is available before logging for older browsers as IE7
	 *
	 * @return if window.console is available in DOM
	 */
	private static native boolean isConsoleAvailable()	/*-{
		if (window.console && window.console.log && window.console.error) {
			// console is available
			return true;
		}

		return false;
	}-*/;

}