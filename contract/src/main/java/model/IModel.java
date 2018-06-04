package model;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {
    
    ILevel getLevel();
    
    IMobile getMyCharacter();
    
	IMobile[] getPurses();
	
	IMobile[] getMonsters();

	IMobile getEnergyBall();
	
	IMobile getDoor();
	
	void setLevelID(int levelID);
	
	int getLevelID();
	
	boolean hasCharacterWon();
}
