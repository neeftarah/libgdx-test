package com.frappagames.libgdxtest.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frappagames.libgdxtest.LibGDXTest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1024;
		config.height = 768;
		config.title = "Test de LibGDX";

		// Activation d'OpenGL 3
		config.useGL30 = true;

		// Définition des icônes
		config.addIcon("icon/icon128.png", Files.FileType.Internal);
		config.addIcon("icon/icon32.png", Files.FileType.Internal);
		config.addIcon("icon/icon16.png", Files.FileType.Internal);

		new LwjglApplication(new LibGDXTest(), config);
	}
}
