package model;

/**
 * <h1>The Interface IModel.</h1>
 *
 * 
 * @author Louis CHOCHOY, Thomas ISAAC, Valentin CASEN and Adrien LALISSE
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
