package prog2.inlamning.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyboardHandler {
	private boolean isLeft;
	private boolean isRight;
	private boolean isUp;
	private boolean isDown;
	
	public boolean isLeft()
	{
		return isLeft;
	}
	
	public boolean isRight()
	{
		return isRight;
	}
	
	public boolean isUp()
	{
		return isUp;
	}
	
	public boolean isDown()
	{
		return isDown;
	}
	
	public void update()
	{
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			isRight = true;
		}
		else
		{
			isRight = false;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			isLeft = true;
		}
		else
		{
			isLeft = false;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			isUp = true;
		}
		else
		{
			isUp = false;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			isDown = true;
		}
		else
		{
			isDown = false;
		}
	}
}
