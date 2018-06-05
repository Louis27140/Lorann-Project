package model;

import java.io.IOException;
import java.sql.SQLException;
import model.element.mobile.MyCharacter;
import model.element.mobile.auto.FirstMonster;
import model.element.mobile.collectible.Door;
import model.element.mobile.collectible.EnergyBall;
import model.element.mobile.collectible.Purse;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @author Louis CHOCHOY, Thomas ISAAC, Valentin CASEN and Adrien LALISSE
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	
	private int LevelID;
	
	private ILevel level;
	private IMobile character;
	private IMobile[] purses;
	private IMobile[] monsters;
	private IMobile energyBall;
	private IMobile door;
	
    /**
     * Instantiates a new model facade.
     * @throws SQLException 
     * @throws IOException 
     */
    public ModelFacade(int level) throws SQLException, IOException {
        super();
        this.setLevel(new Level(level));
        this.setCharacter(new MyCharacter((int)this.level.getCharacterPosition().getX(), (int)this.level.getCharacterPosition().getY(), this.level));

        purses = new IMobile[this.getLevel().getPurses().length];
        monsters = new IMobile[this.getLevel().getMonsters().length];
        
        for(int i = 0; i < purses.length; i++) {
        	purses[i] = this.getLevel().getPurses()[i];
        	((MyCharacter)this.getMyCharacter()).addPurse(purses[i]);
        }
        
        
        for(int i = 0; i < monsters.length; i++) {
        	switch(this.getLevel().getMonsters()[i].getSprite().getConsoleImage()) {
	        	case '4':
	        		monsters[i] = this.getLevel().getMonsters()[i];
	            	((MyCharacter)this.getMyCharacter()).addMonster(monsters[i]);
	        		break;
	        	case '9':
	        		monsters[i] = this.getLevel().getMonsters()[i];
	            	((MyCharacter)this.getMyCharacter()).addMonster(monsters[i]);
	        		break;
	        	case 'A':
	        		monsters[i] = this.getLevel().getMonsters()[i];
	            	((MyCharacter)this.getMyCharacter()).addMonster(monsters[i]);
	        		break;
	        	case 'B':
	        		monsters[i] = this.getLevel().getMonsters()[i];
	            	((MyCharacter)this.getMyCharacter()).addMonster(monsters[i]);
	        		break;
        	}
        }
        
        energyBall = this.getLevel().getEnergyBall();
        ((MyCharacter)this.getMyCharacter()).addEnergyBall(energyBall);
        
        door = this.getLevel().getDoor();
        ((MyCharacter)this.getMyCharacter()).addDoor(door);
    }
    
	@Override
	public ILevel getLevel() {
		return this.level;
	}

	@Override
	public IMobile getMyCharacter() {
		return this.character;
	}
	
	private void setLevel(ILevel level) {
		this.level = level;
	}

	private void setCharacter(IMobile character) {
		this.character = character;
	}

	public IMobile[] getPurses() {
		return purses;
	}

	public void setPurses(IMobile[] purses) {
		this.purses = purses;
	}

	public IMobile[] getMonsters() {
		return monsters;
	}

	public void setMonsters(IMobile[] monsters) {
		this.monsters = monsters;
	}

	public IMobile getEnergyBall() {
		return this.energyBall;
	}
	
	public IMobile getDoor() {
		return this.door;
	}

	@Override
	public boolean hasCharacterWon() {
		return ((MyCharacter)this.getMyCharacter()).hasWon();
	}

	public int getLevelID() {
		return LevelID;
	}

	public void setLevelID(int levelID) {
		this.LevelID = levelID;
	}
	
}
