package model.element.mobile.auto;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class Monster_3 extends Monster {
private static Sprite sprite = new Sprite('A', "monster_3");
	
	public boolean goingUpRight = true;

	public Monster_3(ILevel level, int x, int y) {
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
		if(this.goingUpRight) {
			if(!this.goUpRight()) {
				this.goDownLeft();
				goingUpRight = false;
			}
		}
		else {
			if(!this.goDownLeft()) {
				this.goUpRight();
				goingUpRight = true;
			}
		}
	}
	
	public boolean goUpRight() {
		if(this.getLevel().getOnTheLevelXY(this.getX() + 1, this.getY() - 1).getPermeability() != Permeability.BLOCKING) {
			this.moveUpRight();
			return true;
		}
		return false;
			
	}
	
	public boolean goDownLeft() {
		if(this.getLevel().getOnTheLevelXY(this.getX() - 1, this.getY() + 1).getPermeability() != Permeability.BLOCKING) {
			this.moveDownLeft();
			return true;
		}
		return false;
	}
}
