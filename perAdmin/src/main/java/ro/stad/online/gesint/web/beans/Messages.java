/**
 * @author STAD
 */
package ro.per.online.web.beans;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author STAD
 *
 */
public class Messages {
	private static final String BUNDLE_NAME = "ro.per.online.web.beans.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		}
		catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
