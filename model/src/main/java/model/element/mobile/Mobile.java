package model.element.mobile;

import java.awt.Point;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;
import model.element.mobile.auto.Spell;
/**
 * 
 * @author Louis CHOCHOY, Thomas ISAAC, Valentin CASEN and Adrien LALISSE
 *
 */
public abstract class Mobile extends Element implements IMobile {
	
	private Point position;
	private boolean alive = true;
	private ILevel level;
	
	private int lastX = 0;
	private int lastY = 0;
	/**
	 * 
	 * @param sprite
	 * @param permeability
	 * @param level
	 */
	public Mobile(Sprite sprite, Permeability permeability, ILevel level) {
		this(sprite, permeability, level, 0, 0);
	}
	/**
	 * 
	 * @param sprite
	 * @param permeability
	 * @param level
	 * @param x
	 * @param y
	 */
	public Mobile(Sprite sprite, Permeability permeability, ILevel level, int x, int y) {
		super(sprite, permeability);
		this.level = level;
		this.position = new Point();
		this.getPosition().x = x;
		this.getPosition().y = y;
	}
	/**
	 * Moves the character up by decrementing Y.
	 */
	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
		this.lastY = -1;
		this.lastX = 0;
	}
	/**
	 * Moves the character to the left by decrementing X.
	 */
	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.lastX = -1;
		this.lastY = 0;
	}
	/**
	 * Moves the character up by incrementing Y.
	 */
	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.lastY = 1;
		this.lastX = 0;
	}
	/**
	 * Moves the character to the right by incrementing X.
	 */
	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.lastX = 1;
		this.lastY = 0;
	}
	/**
	 * Moves the character to the Up and the right by incrementing X and decrementing Y.
	 */
	@Override 
	public void moveUpRight() {
		this.setX(this.getX() + 1);
		this.setY(getY() - 1);
		this.lastX = 1;
		this.lastY = -1;
	}
	/**
	 * Moves the character to the Up and the left by decrementing X and Y.
	 */
	@Override
	public void moveUpLeft() {
		this.setX(this.getX() - 1);
		this.setY(getY() - 1);
		this.lastX = -1;
		this.lastY = -1;
	}
	/**
	 * Moves the character to the Up and the left by incrementing X and Y.
	 */
	@Override
	public void moveDownRight() {
		this.setX(this.getX() + 1);
		this.setY(getY() + 1);
		this.lastX = 1;
		this.lastY = 1;
	}
	/**
	 * Moves the character to the Up and the right by decrementing X and incrementing Y.
	 */
	@Override
	public void moveDownLeft() {
		this.setX(this.getX() - 1);
		this.setY(getY() + 1);
		this.lastX = -1;
		this.lastY = 1;
	}
	/**
	 * Indicates the character has moved for the update.
	 */
	public void setHasMoved() {
		this.level.setElementHasChanged();
	}
	/**
	 * Gets the X (horizontal) position.
	 * @return x
	 */
	@Override
	public int getX() {
		return this.getPosition().x;
	}
	/**
	 * Sets the X (horizontal) position.
	 * @param x
	 */
	public void setX(int x) {
		if (!this.isOnWall(x, this.getY())) {
			this.getPosition().x = x;
        }
	}
	/**
	 * Gets the Y (vertical) position.
	 * @return y
	 */
	@Override
	public int getY() {
		return this.getPosition().y;
	}
	/**
	 * Sets the Y (vertical) position.
	 * @param y
	 */
	public void setY(int y) {
		if (!this.isOnWall(this.getX(), y)) {
			this.getPosition().y = y;
        }
	}
	
	public void initX(int x) {
		this.getPosition().x = x;
	}
	
	public void initY(int y) {
		this.getPosition().y = y;
	}
	/**
	 * Is the character alive? (True/False)
	 * @return alive
	 */
	@Override
	public boolean isAlive() {
		return this.alive;
	}
	/**
	 * Is the character on a wall?
	 * 
	 * @param newX
	 * @param newY
	 * @return BLOCKING
	 */
	public boolean isOnWall(int newX, int newY) {
		return (this.getLevel().getOnTheLevelXY(newX, newY).getPermeability() == Permeability.BLOCKING);
	}
	/**
	 * Is the character on a monster?
	 * @return MONSTER
	 */
	@Override
	public boolean isHit(int newX, int newY) {
		return (this.getLevel().getOnTheLevelXY(newX, newY).getPermeability() == Permeability.MONSTER);
	}
	/**
	 * Gets the position
	 * @return position
	 */
	@Override
	public Point getPosition() {
		return this.position;
	}
	/**
	 * Creates on new spell on the position of the character.
	 */
	@Override
	public void shoot() {
		int x = this.getX() - lastX;
		int y = this.getY() - lastY;
		this.level.setSpellOnTheLevelXY(x, y, new Spell(this.getLevel(), x, y));
	}
	/**
	 * Sets the death of the character.
	 */
	public void die() {
		this.alive = false;
		this.setHasMoved();
	}
	/**
	 * Gets the level
	 * @return level
	 */
	protected ILevel getLevel() {
		return this.level;
	}

}