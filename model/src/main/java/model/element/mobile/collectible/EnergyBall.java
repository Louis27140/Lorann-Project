package model.element.mobile.collectible;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public class EnergyBall extends Mobile {

	private static Sprite ballSprite = new Sprite('B', "crystal_ball");
	private static Sprite collected = new Sprite('B', "floor");
	
	public EnergyBall(int x, int y, ILevel level) throws IOException {
		super(ballSprite, Permeability.COLLECTIBLE, level, x, y);
		collected.loadImage();
	}

	@Override
	public void doNothing() {}
	
	public int collect() {
		if(this.isAlive()) {
			this.die();
		}
		return 0;
	}
	
	@Override
	public void die() {
		super.die();
		this.setSprite(collected);
	}

}
