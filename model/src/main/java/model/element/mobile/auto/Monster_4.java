package model.element.mobile.auto;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class Monster_4 extends Monster{
private static Sprite sprite = new Sprite('B', "monster_4");
	
	public boolean goingUpLeft = true;

	public Monster_4(ILevel level, int x, int y) {
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
		if(this.goingUpLeft) {
			if(!this.goUpLeft()) {
				this.goDownRight();
				goingUpLeft = false;
			}
		}
		else {
			if(!this.goDownRight()) {
				this.goUpLeft();
				goingUpLeft = true;
			}
		}
	}
	
	public boolean goUpLeft() {
		if(this.getLevel().getOnTheLevelXY(this.getX() - 1, this.getY() - 1).getPermeability() != Permeability.BLOCKING) {
			this.moveUpLeft();
			return true;
		}
		return false;
			
	}
	
	public boolean goDownRight() {
		if(this.getLevel().getOnTheLevelXY(this.getX() + 1, this.getY() + 1).getPermeability() != Permeability.BLOCKING) {
			this.moveDownRight();
			return true;
		}
		return false;
		}
}
