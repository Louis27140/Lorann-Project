package model.element.motionless;

import model.Permeability;
import model.Sprite;

public class OpenedGate extends MotionlessElement{

	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('6', "gate_open");
    
	OpenedGate() {
		super(SPRITE, Permeability.DOOR);
	}

}
