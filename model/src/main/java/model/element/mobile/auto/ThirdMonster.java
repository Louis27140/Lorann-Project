package model.element.mobile.auto;

import model.ILevel;
import model.Permeability;
import model.Sprite;

public class ThirdMonster extends Monster {
private static Sprite sprite = new Sprite('A', "monster_3");
	
	public boolean goingUp = true;

	public ThirdMonster(ILevel level, int x, int y) {
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
		if(this.goingUp) {
			if(!this.goUp()) {
				this.goDown();
				goingUp = false;
			}
		}
		else {
			if(!this.goDown()) {
				this.goUp();
				goingUp = true;
			}
		}
	}
	
	public boolean goUp() {
		if(this.getLevel().getOnTheLevelXY(this.getX(), this.getY() - 1).getPermeability() != Permeability.BLOCKING) {
			this.moveUp();
			return true;
		}
		return false;
			
	}
	
	public boolean goDown() {
		if(this.getLevel().getOnTheLevelXY(this.getX(), this.getY() + 1).getPermeability() != Permeability.BLOCKING) {
			this.moveDown();
			return true;
		}
		return false;
	}
}
