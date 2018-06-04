package model.element.mobile.collectible;

import java.io.IOException;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public class Door extends Mobile {

	private static Sprite opened = new Sprite('D', "gate_open");
	private static Sprite closed = new Sprite('S', "gate_closed");
	
	public Door(int x, int y, ILevel level) throws IOException {
		super(closed, Permeability.COLLECTIBLE, level, x, y);
		opened.loadImage();
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub

	}
	
	public int collect() {
		if(this.isAlive()) {
			this.die();
		}
		return 0;
	}
	
	@Override
	public void die() {
		super.die();
		this.setSprite(opened);
	}

}
