package model;

import java.awt.Point;
import java.util.Observable;

public interface ILevel {
	
	int getWidth();
	int getHeight();
	IElement getOnTheLevelXY(int x, int y);
	void setOnTheLevelXY(int x, int y, IElement element);
	boolean setSpellOnTheLevelXY(int x, int y, IElement spell);
	Observable getObservable();
	void setElementHasChanged();
	Point getCharacterPosition();
	IMobile[] getPurses();
	IMobile[] getMonsters();
	IMobile getEnergyBall();
	IMobile getDoor();
	

}
