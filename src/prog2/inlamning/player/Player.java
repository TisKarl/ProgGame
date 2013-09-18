package prog2.inlamning.player;

import prog2.inlamning.input.KeyboardHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private final int SPEED = 400;
	private Texture texture;
	private TextureRegion region;
	private Vector2 position;
	private KeyboardHandler inputs;
	
	public Player(float x, float y)
	{
		texture = new Texture(Gdx.files.internal("data/block.png"));
		region = new TextureRegion(texture, 0, 0, 50, 50);
		position = new Vector2(x,y);
		inputs = new KeyboardHandler();
	}
	
	public void render(SpriteBatch batch)
	{
		batch.draw(region, position.x, position.y);
	}
	
	public void update(float delta)
	{
		inputs.update();
		
		if(inputs.isLeft())
		{
			System.out.println("Left");
			position.x -= SPEED * delta;
		}
		
		if(inputs.isRight())
		{
			System.out.println("Right");
			position.x += SPEED * delta;
		}
		
		if(inputs.isUp())
		{
			System.out.println("Up");
			position.y += SPEED * delta;
		}
		
		if(inputs.isDown())
		{
			System.out.println("Down");
			position.y -= SPEED * delta;
		}
		
	}
}
