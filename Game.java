package com.rockbite.bootcamp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Game extends ApplicationAdapter {

	private SpriteBatch batch;

	private ShapeRenderer shapeRenderer;
	private Color[] colorPalette;

	ArrayList<Ball> balls = new ArrayList<>();
	Random random = new Random();

	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		batch = new SpriteBatch();
		colorPalette = new Color[6];

		colorPalette[0] = new Color(113/255f, 78/255f, 179/255f, 1); // Royal Purple
		colorPalette[1] = new Color(82/255f, 134/255f, 218/255f, 1); // United Nations Blue
		colorPalette[2] = new Color(109/255f, 187/255f, 91/255f, 1); // Mantis
		colorPalette[3] = new Color(235/255f, 224/255f, 81/255f, 1); // Minion Yellow
		colorPalette[4] = new Color(249/255f, 141/255f, 82/255f, 1); // Royal Orange
		colorPalette[5] = new Color(225/255f, 78/255f, 101/255f, 1); // Paradise Pink


		for (int i = 0; i < 20; i++) {
			balls.add(new Ball(
					random.nextInt(Gdx.graphics.getWidth()),
					random.nextInt(Gdx.graphics.getHeight()),
					random.nextInt(8),
					random.nextInt(8),
					random.nextInt(15),
					random.nextInt(90),
					colorPalette[random.nextInt(6)]
			));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).update();
			shapeRenderer.setColor(balls.get(i).getColor());
			balls.get(i).draw(shapeRenderer);
		}
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
	}
}
