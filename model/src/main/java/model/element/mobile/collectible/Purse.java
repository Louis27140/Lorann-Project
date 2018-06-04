package model.element.mobile.collectible;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public class Purse extends Mobile {

	private static Sprite purseSprite = new Sprite('A', "purse");
	private static Sprite collected = new Sprite('A', "floor");
	
	private static int points = 10;
	
	public Purse(int x, int y, ILevel level) throws IOException {
		super(purseSprite, Permeability.COLLECTIBLE, level, x, y);
		collected.loadImage();
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub

	}
	
	public int collect() {
		if(this.isAlive()) {
			this.die();
			return points;
		}
		return 0;
	}
	
	@Override
	public void die() {
		super.die();
		this.setSprite(collected);
	}

}
