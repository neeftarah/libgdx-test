package com.frappagames.libgdxtest.screens;

import com.badlogic.gdx.Game;
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

import java.util.Locale;

public class TranslationsScreen extends AbstractScreen {
	private LibGDXTest game;
	private Stage stage;

	private Label label1, label2, label3;
	I18NBundle translations;

	TranslationsScreen(LibGDXTest game) {
		super(game.batch);

		this.game = game;
	}

	@Override
	protected void init() {
		Skin skin;
		skin = new Skin( Gdx.files.internal("ui/skin.json"));

		TextButton btnFR = new TextButton("FR", skin);
		btnFR.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Set to FR");
				refreshText("fr");
			}
		});
		TextButton btnEN = new TextButton("EN", skin);
		btnEN.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Set to EN");
				refreshText("en");
			}
		});

		TextButton btnReturn = new TextButton("Retour", skin);
		btnReturn.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new MenuScreen(game));
			}
		});

		FileHandle baseFileHandle = Gdx.files.internal("translations/translations");
		translations = I18NBundle.createBundle(baseFileHandle);

		label1 = new Label(translations.get("hello"), skin);
		label1.setColor(Color.BLACK);
		label2 = new Label(translations.get("bye"), skin);
		label2.setColor(Color.BLACK);
		label3 = new Label(translations.format("languages", 2), skin);
		label3.setColor(Color.BLACK);

		Table table = new Table();
		table.setFillParent(true);
		table.align(Align.bottom).row();
		table.add(btnFR).width(250).height(40).pad(30, 0, 5, 0).row();
		table.add(btnEN).width(250).height(40).pad(5, 0, 5, 0).row();
		table.add().expand().row();
		table.add(label1).pad(5).row();
		table.add(label2).pad(5).row();
		table.add(label3).pad(5).row();
		table.add().expand().row();
		table.add(btnReturn).width(250).height(40).pad(5, 0, 30, 0).row();

		stage = new Stage();
		stage.addActor(table);

		Gdx.input.setInputProcessor(stage);
	}

	private void refreshText(String language) {
		FileHandle baseFileHandle = Gdx.files.internal("translations/translations");
		Locale locale = new Locale(language);
		translations = I18NBundle.createBundle(baseFileHandle, locale);

		label1.setText(translations.get("hello"));
		label2.setText(translations.get("bye"));
		label3.setText(translations.format("languages", 2));
	}

	@Override
	protected void update(float delta) {
		stage.act();
	}

	@Override
	protected void draw(float delta) {
		stage.draw();
	}
}
