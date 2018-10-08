package com.frappagames.libgdxtest.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.frappagames.libgdxtest.LibGDXTest;

public class MenuScreen extends AbstractScreen {
	private Texture img;
	private Stage stage;
	private LibGDXTest game;

	public MenuScreen(LibGDXTest game) {
		super(game.batch);

		this.game = game;
	}

	@Override
	public void init() {
		img = new Texture("libgdx.png");

		Skin skin;
		skin = new Skin( Gdx.files.internal("ui/skin.json"));

		TextButton btn = new TextButton("Translations", skin);
		btn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new TranslationsScreen(game));
			}
		});

		TextButton btn2 = new TextButton("Gamespark", skin);
		btn2.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new GamesparkScreen(game));
			}
		});

		TextButton btnExit = new TextButton("Quitter", skin);
		btnExit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});


		Table table = new Table();
		table.setFillParent(true);
		table.align(Align.top).padTop(200).row();
		table.add(btn).width(250).height(40).pad(5).row();
		table.add(btn2).width(250).height(40).pad(5).row();
		table.add().expand().row();
		table.add(btnExit).width(250).height(40).pad(30).row();

		stage = new Stage();
		stage.addActor(table);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	protected void update(float delta) {
		stage.act();
	}

	@Override
	public void draw(float delta) {
		batch.begin();
		batch.draw(img, Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() - 200);
		batch.end();

		stage.draw();
	}

	@Override
	public void dispose() {
		img.dispose();
	}
}
