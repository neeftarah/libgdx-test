package com.frappagames.libgdxtest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frappagames.libgdxtest.screens.MenuScreen;

public class LibGDXTest extends Game {
	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
