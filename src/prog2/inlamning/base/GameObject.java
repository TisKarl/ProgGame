package prog2.inlamning.base;

import prog2.inlamning.game.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public abstract class GameObject implements Disposable{
	protected Vector2 position;
	protected Vector2 oldPosition;
	public final int SPEED = 400;
	protected Texture texture;
	private TextureRegion currentRegion;
	protected int width;
	protected int height;
	protected Rectangle collisionArea;
	
	
	public GameObject(float x, float y, int width, int height)
	{
		position = new Vector2(x,y);
		oldPosition = new Vector2(position);
		setTexture();
		currentRegion = new TextureRegion(texture,0f,0f,width,height);
		this.width = width;
		this.height = height;
		collisionArea = new Rectangle(position.x, position.y, width, height);
	}
	public abstract void setTexture();
	public abstract void update(float delta);
	
	public void render(SpriteBatch batch)
	{
		batch.draw(currentRegion,position.x,position.y,width,height);
		
	}
	
	@Override
	public void dispose()
	{
		texture.dispose();
	}
	
	public Rectangle getCollisionArea()
	{
		collisionArea.x = position.x;
		collisionArea.y = position.y;
		return collisionArea;
	}
	
	protected void collisionTest() {
		for (GameObject go : Game.getGameObjects()) {
			
			if(go != this)
			{
				if(this.getCollisionArea().overlaps(go.getCollisionArea()))
				{
					handleCollision(go.getCollisionArea());
				}
			}
			
			
		}
		
	}

	private void handleCollision(Rectangle col) {
		float temp = position.x;
		collisionArea.x = oldPosition.x;
		//just x
		if(collisionArea.overlaps(col) == false){
			position.x = oldPosition.x;
			return ;
		}
		collisionArea.x = temp;
		temp = position.y;
		collisionArea.y = oldPosition.y;
		//just y
		if(collisionArea.overlaps(col) == false){
			position.y = oldPosition.y;
			return ;
		}
		//both x and y
		collisionArea.x = oldPosition.y;
		position.x = oldPosition.x;
		position.y = oldPosition.y;
		if(collisionArea.overlaps(col))
		{
			System.out.println("ERROR! collision");
		}
		

		
	}
	
}
