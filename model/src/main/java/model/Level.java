package model;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.dao.LorannDAO;
import model.element.Element;

import model.element.mobile.auto.Monster_1;
import model.element.mobile.auto.Monster_4;
import model.element.mobile.auto.Monster_2;
import model.element.mobile.auto.Monster_3;

<<<<<<< HEAD
import model.element.mobile.collectible.Gate;
import model.element.mobile.collectible.CrystalEnergy;
=======
import model.element.mobile.collectible.Door;
import model.element.mobile.collectible.EnergyBall;
>>>>>>> master
import model.element.mobile.collectible.Purse;
import model.element.motionless.MotionlessElementFactory;
/**
 * <h1>The Level Class</h1>
 * 
 * 
 * @author Louis CHOCHOY, Thomas ISAAC, Valentin CASEN and Adrien LALISSE
 *
 */
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
	
	/**
	 * Gets the width.
	 * 
	 * @return the width
	 */
	@Override
	public int getWidth() {
		return this.width;
	}

	/**
	 * Gets the Height.
	 * @return the height
	 */
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
	/**
	 * <h1>The loadLevel method.</h1>
	 * 
	 * This method reads the levelText and processes it to generate the maps.
	 * <p>
	 * 
	 * The algorithm consists in two imbricate "for" loops browsing the height and width. 
	 * <br> Inside is a "switch" condition calling the creation of the right item depending on the text input.
	 * 
	 * @param level
	 * @throws SQLException
	 * @throws IOException
	 */
	private void loadLevel(int level) throws SQLException, IOException {
		String levelText = LorannDAO.chooseLevel(level);
		this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
		String[] levelArray = levelText.split("\n");
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				switch(levelArray[y].toCharArray()[x]) {
					case '3':
						this.setCharacterPosition(new Point(x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case '5':
						this.purses.add(new Purse(x, y, this));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case '8':
						this.energyBall = new CrystalEnergy(x, y, this);
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case '9':
						this.monsters.add(new Monster_2(this, x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case '6':
						this.door = new Gate(x, y, this);
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case '4':
						this.monsters.add(new Monster_1(this, x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'A':
						this.monsters.add(new Monster_3(this, x, y));
						this.setOnTheLevelXY(x, y, MotionlessElementFactory.createFloor());
						break;
					case 'B':
						this.monsters.add(new Monster_4(this, x, y));
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
	/**
	 * Gets the character position
	 * @return getCharacterPosition
	 */
	public Point getCharacterPosition() {
		return this.characterPosition;
	}
	/**
	 * Sets the character position
	 * @param position
	 */
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
