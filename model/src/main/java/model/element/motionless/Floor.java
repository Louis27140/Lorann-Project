package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class Floor extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ',"floor");
    
	Floor() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
