
package test;

import model.ILevel;
import model.IMobile;
import model.IModel;

public final class ModelMock implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelMock() {
        super();
    }


	@Override
	public ILevel getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMobile getMyCharacter() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IMobile[] getPurses() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IMobile[] getMonsters() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IMobile getEnergyBall() {
		// TODO Auto-generated method stub
		return null;
	}
}
