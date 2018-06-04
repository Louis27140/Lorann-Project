package model;

import java.awt.Point;

import showboard.IPawn;

public interface IMobile extends IElement, IPawn{
	
	void moveUp();
	void moveLeft();
	void moveDown();
	void moveRight();
	void doNothing();
	int getX();
	int getY();
	boolean isAlive();
	boolean isHit(int newX, int newY);
	/*boolean isOnDoor(int newX, int newY);
	boolean isOnKey(int newX, int newY);
	boolean isOnWall(int newX, int newY);
	boolean isOnPurse(int newX, int newY);*/
	Point getPosition();
	void shoot();
	int collect();

}
