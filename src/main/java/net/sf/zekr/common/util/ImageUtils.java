/*
 *               In the name of Allah
 * This file is part of The Zekr Project. Use is subject to
 * license terms.
 *
 * Author:         Auto-generated
 * Start Date:     2025
 */
package net.sf.zekr.common.util;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import net.sf.zekr.engine.log.Logger;

/**
 * Classe utilitaire pour charger les images depuis le classpath.
 *
 * @author Auto-generated
 */
public class ImageUtils {
	private static final Logger logger = Logger.getLogger(ImageUtils.class);

	/**
	 * Charge une image depuis le classpath au lieu du système de fichiers.
	 *
	 * @param display L'instance Display pour créer l'image
	 * @param resourcePath Le chemin de la ressource (ex: "image/icon/open-book16.png")
	 * @return L'image chargée, ou null si introuvable
	 */
	public static Image loadFromClasspath(Display display, String resourcePath) {
		if (display == null || resourcePath == null) {
			logger.error("Display ou resourcePath est null");
			return null;
		}

		// Nettoyer le chemin de la ressource
		String cleanPath = resourcePath;

		// Si c'est un chemin absolu Windows ou Unix, essayer d'extraire le chemin relatif
		if (cleanPath.contains(":\\") || cleanPath.startsWith("/")) {
			// Extraire la partie après "image/" ou autre répertoire de ressources
			if (cleanPath.contains("image")) {
				int index = cleanPath.indexOf("image");
				cleanPath = cleanPath.substring(index);
			} else if (cleanPath.contains("text")) {
				int index = cleanPath.indexOf("text");
				cleanPath = cleanPath.substring(index);
			} else if (cleanPath.contains("config")) {
				int index = cleanPath.indexOf("config");
				cleanPath = cleanPath.substring(index);
			}
		}

		// Convertir les backslashes en forward slashes pour le classpath
		cleanPath = cleanPath.replace('\\', '/');

		InputStream inputStream = null;
		try {
			inputStream = ImageUtils.class.getClassLoader().getResourceAsStream(cleanPath);
			if (inputStream != null) {
				Image image = new Image(display, inputStream);
				return image;
			} else {
				logger.error("Impossible de trouver la ressource: " + cleanPath);
				return null;
			}
		} catch (Exception e) {
			logger.error("Erreur lors du chargement de l'image: " + cleanPath, e);
			return null;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					logger.error("Erreur lors de la fermeture du flux d'entrée", e);
				}
			}
		}
	}
}

