package model.element.mobile.auto;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class Monster_2 extends Monster{
	
	private static Sprite sprite = new Sprite('9', "monster_2");
	
	public boolean goingRight = true;

	public Monster_2(ILevel level, int x, int y) {
		super(sprite, level, x, y);
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
	}

	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move() {
		if(this.goingRight) {
			if(!this.goRight()) {
				this.goLeft();
				goingRight = false;
			}
		}
		else {
			if(!this.goLeft()) {
				this.goRight();
				goingRight = true;
			}
		}
	}
	
	public boolean goRight() {
		if(this.getLevel().getOnTheLevelXY(this.getX() + 1, this.getY()).getPermeability() != Permeability.BLOCKING) {
			this.moveRight();
			return true;
		}
		return false;
			
	}
	
	public boolean goLeft() {
		if(this.getLevel().getOnTheLevelXY(this.getX() - 1, this.getY()).getPermeability() != Permeability.BLOCKING) {
			this.moveLeft();
			return true;
		}
		return false;
	}

}
