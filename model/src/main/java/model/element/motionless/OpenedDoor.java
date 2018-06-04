package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class OpenedDoor extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('7', "gate_open");
    
	OpenedDoor() {
		super(SPRITE, Permeability.DOOR);
	}

}
