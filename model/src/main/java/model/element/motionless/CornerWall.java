package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class CornerWall extends MotionlessElement {
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('0',"bone");
    
	public CornerWall() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
