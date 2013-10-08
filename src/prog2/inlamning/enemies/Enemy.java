package prog2.inlamning.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import prog2.inlamning.base.GameObject;

public class Enemy extends GameObject {

	public Enemy(float x, float y)
	{
		super(x,y,32,32);
	}
	
	@Override
	public void setTexture() {
		texture = new Texture(Gdx.files.internal("data/block.png"));
	}

	@Override
	public void update(float delta) {
		
		
		collisionTest();

	}

}
