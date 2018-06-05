package model;

import java.awt.Point;
import java.util.Observable;

public interface ILevel {
	

	int getWidth();
	int getHeight();
	/**
	 * 
	 * @param x
	 * @param y
	 */
	IElement getOnTheLevelXY(int x, int y);
	/**
	 * 
	 * @param x
	 * @param y
	 * @param element
	 */
	void setOnTheLevelXY(int x, int y, IElement element);
	/**
	 * 
	 * @param x
	 * @param y
	 * @param spell
	 */
	boolean setSpellOnTheLevelXY(int x, int y, IElement spell);
	/**
	 * Gets the observables
	 * 
	 * @return observable
	 */
	Observable getObservable();
	void setElementHasChanged();
	Point getCharacterPosition();
	IMobile[] getPurses();
	IMobile[] getMonsters();
	IMobile getEnergyBall();
	IMobile getDoor();
	

}
