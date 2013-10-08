package prog2.inlamning.player;

import prog2.inlamning.base.GameObject;
import prog2.inlamning.game.Game;
import prog2.inlamning.input.KeyboardHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameObject{

	private KeyboardHandler inputs;
	
	public Player(float x, float y)
	{
		
		super(10,10,32,32);
		inputs = new KeyboardHandler();
	}
	
	public void setTexture()
	{
		texture = new Texture(Gdx.files.internal("data/block.png"));
	}
	
	public void update(float delta)
	{
		inputs.update();
		
		oldPosition.x = position.x;
		oldPosition.y = position.y;
		
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
		
		collisionTest();
		
	}

	
}
