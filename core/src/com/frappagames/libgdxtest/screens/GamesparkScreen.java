package com.frappagames.libgdxtest.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.I18NBundle;
import com.frappagames.libgdxtest.LibGDXTest;
import com.frappagames.libgdxtest.utils.LibGdxPlatform;
import com.gamesparks.sdk.GS;
import com.gamesparks.sdk.GSEventConsumer;

public class GamesparkScreen extends AbstractScreen {
	private static final String GS_KEY = "b354983VSwxA";
	private static final String GS_SECRET = "VVqM31YLm1MmwjWhbdL5DkfYLcifpq20";

	private LibGDXTest game;
	private Stage stage;
	private GS gs;

	GamesparkScreen(LibGDXTest game) {
		super(game.batch);

		this.game = game;
	}

	@Override
	protected void init() {
		gs = new GS(GS_KEY, GS_SECRET, null, false, false, new LibGdxPlatform());
		gs.setOnAvailable(new GSEventConsumer<Boolean>() {
			@Override
			public void onEvent(Boolean available) {
				if(available) {
					// Game Sparks Available!
					System.out.println("Game Sparks Available!");
				} else {
					// Game Sparks Not Available!
					System.out.println("Game Sparks Not Available!");
				}
			}
		});
		gs.start();

		Skin skin;
		skin = new Skin( Gdx.files.internal("ui/skin.json"));

		TextButton btnReturn = new TextButton("Retour", skin);
		btnReturn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new MenuScreen(game));
			}
		});


		Table table = new Table();
		table.setFillParent(true);
		table.align(Align.bottom).row();
		table.add().expand().row();
		table.add(btnReturn).width(250).height(40).pad(5, 0, 30, 0).row();

		stage = new Stage();
		stage.addActor(table);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	protected void update(float delta) {
		stage.act();
	}

	@Override
	protected void draw(float delta) {
		stage.draw();
	}
	/**
	 * Called when this screen should release all resources.
	 */
	@Override
	public void dispose() {
		super.dispose();

		gs.stop();
	}
}
