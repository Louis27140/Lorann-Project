package test;

import java.awt.Image;
import java.awt.Point;

import model.IMobile;
import model.Permeability;
import model.Sprite;

public class MobileMock implements IMobile {

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHit(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOnDoor(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOnKey(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOnWall(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOnPurse(int newX, int newY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}

}
