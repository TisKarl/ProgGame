package prog2.inlamning.game;

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

public class Game implements ApplicationListener {
	private SpriteBatch batch;
	private Texture texture;
	private TextureRegion region;
	
	private Player player;
	
	private int x;
	private int y;
	
	@Override
	public void create() {		
		batch = new SpriteBatch();
		player = new Player(10,10);
		//texture = new Texture(Gdx.files.internal("data/block.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//region = new TextureRegion(texture, 0, 0, 50, 50);
		
		//x = 10;
		//y = 40;
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		player.update(Gdx.graphics.getDeltaTime());
		batch.begin();
		player.render(batch);
		//batch.draw(region, x, y);
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
