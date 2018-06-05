package model.element.mobile;

import java.io.IOException;
import java.util.ArrayList;

import model.ILevel;
import model.IMobile;
import model.Permeability;
import model.Sprite;

public class Lorann extends Mobile{
	
	private static Sprite lorann_b = new Sprite('3', "lorann_b");
	private static Sprite lorann_bl = new Sprite('3' ,"lorann_bl");
	private static Sprite lorann_br = new Sprite('3' ,"lorann_br");
	private static Sprite lorann_l = new Sprite('3' ,"lorann_l");
	private static Sprite lorann_r = new Sprite('3' ,"lorann_r");
	private static Sprite lorann_u = new Sprite('3' ,"lorann_u");
	private static Sprite lorann_ul = new Sprite('3' ,"lorann_ul");
	private static Sprite lorann_ur = new Sprite('3' ,"lorann_ur");
	
	private ArrayList<IMobile> purses;
	private ArrayList<IMobile> monsters;
	private IMobile energyBall;
	private IMobile door;
	
	private int score = 0;
	private boolean hasTheKey = false;
	
	private boolean won = false;
	
	private static Sprite[] sprites;
	
	public Lorann(int x, int y, ILevel level) throws IOException {
		super(lorann_r, Permeability.BLOCKING, level);
		
		sprites = new Sprite[8];
		
		lorann_b.loadImage();
		lorann_bl.loadImage();
		lorann_br.loadImage();
		lorann_l.loadImage();
		lorann_u.loadImage();
		lorann_ul.loadImage();
		lorann_ur.loadImage();
		
		sprites[0] = lorann_r;
		sprites[1] = lorann_br;
		sprites[2] = lorann_b;
		sprites[3] = lorann_bl;
		sprites[4] = lorann_l;
		sprites[5] = lorann_ul;
		sprites[6] = lorann_u;
		sprites[7] = lorann_ur;
		
		this.initX(x);
		this.initY(y);
		
		this.purses = new ArrayList<>();
		this.monsters = new ArrayList<>();
	}

	@Override
	public void doNothing() {
		
		if(isHit(this.getX(), this.getY())) {this.die();}
		
		int index = 0;
		for(int i = 0; i < sprites.length; i++) {
			if(sprites[i] == this.getSprite()) {
				index = i;
			}
		}
		
		if(index < 7)
			this.setSprite(sprites[index + 1]);
		else
			this.setSprite(sprites[0]);
		
		this.setHasMoved();
	}
	
	public void specialCase(int x, int y) {
		if(isHit(this.getX(), this.getY())) {this.die();}
		else if(this.isOnKey(x, this.getY())) {}
		else if(this.isOnDoor(x, this.getY())) {}
		else if(this.isHit(x, this.getY())) {}
		else if(this.isOnPurse(x, this.getY())) {}
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
		specialCase(this.getX(), this.getY());
		this.setSprite(lorann_bl);
	}
	
	@Override
	public void moveRight() {
		super.moveRight();
		specialCase(this.getX(), this.getY());
		this.setSprite(lorann_ur);
	}
	
	@Override
	public void moveUp() {
		super.moveUp();
		specialCase(this.getX(), this.getY());
		this.setSprite(lorann_ul);
	}
	
	@Override
	public void moveDown() {
		super.moveDown();
		specialCase(this.getX(), this.getY());
		this.setSprite(lorann_br);
	}
	
	public boolean isOnPurse(int newX, int newY) {
		for(IMobile purse : purses) {
			if(purse.getX() == newX && purse.getY() == newY) {
				score += purse.collect();
				System.out.println("Score : " + score);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isOnKey(int newX, int newY) {
		if(energyBall.getX() == newX && energyBall.getY() == newY) {
			energyBall.collect();
			hasTheKey = true;
			door.collect();
			System.out.println("Key found");
			return true;
		}
		
		return false;
	}
	
	public boolean isOnDoor(int newX, int newY) {
		if(door.getX() == newX && door.getY() == newY) {
			if(hasTheKey) {
				this.won = true;
				
			}else {
				this.die();
			}
			return true;
		}
		
		return false;
	}
	
	public void addPurse(IMobile purse) {
		purses.add(purse);
	}
	
	public void addEnergyBall(IMobile energyBall) {
		this.energyBall = energyBall;
	}
	
	public void addMonster(IMobile monster) {
		this.monsters.add(monster);
	}
	
	public void addDoor(IMobile door) {
		this.door = door;
	}

	@Override
	public int collect() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean hasWon() {
		return this.won;
	}
	
	@Override
	public boolean isHit(int newX, int newY) {
		for(IMobile monster : this.monsters) {
			if(monster.getX() == newX && monster.getY() == newY) {
				return true;
			}
		}
		return false;
	}

}
