package model;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.dao.LorannDAO;
import model.element.Element;
import model.element.mobile.auto.FirstMonster;
import model.element.mobile.collectible.Door;
import model.element.mobile.collectible.EnergyBall;
import model.element.mobile.collectible.Purse;
import model.element.motionless.MotionlessElementFactory;

public class Level extends Observable implements ILevel {
	
	private final int width = 20;
	private final int height = 12;
	
	private IElement[][] onTheLevel;
	
	private Point characterPosition;
	
	private ArrayList<IMobile> purses;
	
	private ArrayList<IMobile> monsters;
	
	private IMobile energyBall;
	
	private IMobile door;
	
	public Level(int level) {
		super();
		purses = new ArrayList<>();
		monsters = new ArrayList<>();
		
		try {
			this.loadLevel(level);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public IElement getOnTheLevelXY(int x, int y) {
		return onTheLevel[x][y];
	}
	
	@Override
	public void setOnTheLevelXY(int x, int y, IElement element) {
		this.onTheLevel[x][y] = element;
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	@Override
	public void setElementHasChanged() {
		this.setChanged();
		this.notifyObservers();

	}
	
	private void loadLevel(int level) throws SQLException, IOException {
		String levelText = LorannDAO.chooseLevel(level);
		this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
		String[] levelArray = levelText.split(",");
		
		for(int y = 0; y < 12; y++) {
			for(int x = 0; x < 20; x++) {
				switch(levelArray[y].toCharArray()[x]) {
					case 'L':
						this.setCharacterPosition(new Point(x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'A':
						this.purses.add(new Purse(x, y, this));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'B':
						this.energyBall = new EnergyBall(x, y, this);
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'S':
						this.door = new Door(x, y, this);
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'M':
						this.monsters.add(new FirstMonster(this, x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					default: 
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.getFromFileSymbol(levelArray[y].toCharArray()[x]));
						break;
				}
			}
		}
		
	}

	@Override
	public boolean setSpellOnTheLevelXY(int x, int y, IElement spell) {
		if(this.getOnTheLevelXY(x, y).getPermeability() == Permeability.PENETRABLE) {
			this.onTheLevel[x][y] = spell;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Point getCharacterPosition() {
		return this.characterPosition;
	}
	
	private void setCharacterPosition(Point position) {
		this.characterPosition = position;
	}
	
	public IMobile[] getPurses() {
		IMobile[] result = new IMobile[this.purses.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = purses.get(i);
		}
		return result;
	}
	
	public IMobile[] getMonsters() {
		IMobile[] result = new IMobile[this.monsters.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = monsters.get(i);
		}
		return result;
	}
	
	public IMobile getEnergyBall() {
		return energyBall;
	}
	
	public IMobile getDoor() {
		return door;
	}
	
	

}
