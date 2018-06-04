package model.element.mobile.auto;

import model.ILevel;
import model.Permeability;
import model.Sprite;
import model.element.mobile.Mobile;

public class Spell extends Mobile{

	private static Sprite first_sprite;
	private static Sprite second_sprite;
	private static Sprite third_sprite;
	private static Sprite fourth_sprite;
	private static Sprite fifth_sprite;
	
	public Spell(ILevel level, int x, int y) {
		super(first_sprite, Permeability.SPELL, level, x, y);
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

}
