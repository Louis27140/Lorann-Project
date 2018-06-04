package model.element.mobile.auto;

import model.ILevel;
import model.IMonster;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public abstract class Monster extends Mobile implements IMonster{

	public Monster(Sprite sprite, ILevel level, int x, int y) {
		super(sprite, Permeability.MONSTER, level, x, y);
	}
	
	public boolean isHit() {
		if(this.getLevel().getOnTheLevelXY(this.getX(), this.getY()) instanceof Spell) {
			return true;
		}
		return false;
	}
	
	public abstract void move();

}
