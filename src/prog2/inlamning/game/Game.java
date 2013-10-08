package prog2.inlamning.game;

import prog2.inlamning.base.GameObject;
import prog2.inlamning.enemies.Enemy;
import prog2.inlamning.player.Player;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Game implements ApplicationListener {
	private SpriteBatch batch;

	
	private Player player;
	
	private static Array<GameObject> gameObjects;
	
	public static Array<GameObject> getGameObjects()
	{
		return gameObjects;
	}
	
	@Override
	public void create() {		
		batch = new SpriteBatch();
		player = new Player(10,10);
		//texture = new Texture(Gdx.files.internal("data/block.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//region = new TextureRegion(texture, 0, 0, 50, 50);
		
		gameObjects = new Array<GameObject>();
		gameObjects.add(player);
		gameObjects.add(new Enemy(90,90));
		//x = 10;
		//y = 40;
	}

	@Override
	public void dispose() {
		batch.dispose();
	
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//player.update(Gdx.graphics.getDeltaTime());
		
		for(int i = 0;i<gameObjects.size;i++)
		{
			gameObjects.get(i).update(Gdx.graphics.getDeltaTime());
		}
		
		batch.begin();
		//player.render(batch);
		//batch.draw(region, x, y);
		for(GameObject go : gameObjects)
		{
		go.render(batch);	
		}
		batch.end();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
		{
			Gdx.app.exit();
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
