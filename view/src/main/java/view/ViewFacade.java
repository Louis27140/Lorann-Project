package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.lang.model.element.VariableElement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;

import showboard.BoardFrame;
import model.IElement;
import model.ILevel;
import model.IMobile;
import model.Sprite;


/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * 
 * @author Louis CHOCHOY, Thomas ISAAC, Valentin CASEN and Adrien LALISSE
 * @version 1.0
 */
public class ViewFacade implements IView, KeyListener, Runnable {
	
	/** The Level. */
	private ILevel level;
	
	/** The character. */
	private IMobile myCharacter;
	
	/** The order performer. */
	private IOrderPerformer orderPerformer;
	
	/** The Constant squareSize. */
    private static final int squareSize = 32;

    /** The Constant fullView. */
    private Rectangle fullView;
    
    /** The purses. */
    private IMobile[] purses;
    
    /** The monsters. */
    private IMobile[] monsters;
    
    /** The energy ball. */
    private IMobile energyBall;
    
    /** The door. */
    private IMobile door;

	/**
     * Instantiates a new view facade.
     * 
     * @param level
     * @param myCharacter
     * @param purses
     * @param monsters
     * @param energyBall
     * @param door
     * @throws IOException
     */
    public ViewFacade(ILevel level, IMobile myCharacter, IMobile[] purses, IMobile[] monsters, IMobile energyBall, IMobile door) throws IOException {
        this.setLevel(level);
        this.setMyCharacter(myCharacter);
        this.getMyCharacter().getSprite().loadImage();
        this.setFullView(new Rectangle(0, 0, this.getLevel().getWidth(), this.getLevel().getHeight()));
        SwingUtilities.invokeLater(this);
        
        this.purses = purses;
        this.monsters = monsters;
        this.energyBall = energyBall;
        this.door = door;
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null , message);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void run() {
		BoardFrame boardFrame = new BoardFrame("Lorann", false);
		boardFrame.setDimension(new Dimension(this.getLevel().getWidth(), this.getLevel().getHeight()));
        boardFrame.setDisplayFrame(this.fullView);
        boardFrame.setSize(this.fullView.width * squareSize - 32, this.fullView.height * squareSize);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        //boardFrame.setFocusTraversalKeysEnabled(false);
		
		for (int x = 0; x < this.getLevel().getWidth(); x++) {
            for (int y = 0; y < this.getLevel().getHeight(); y++) {
                boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
            }
        }
		
		boardFrame.addPawn(this.getMyCharacter());
		
		// IPawn sprites loading
		
		for(IMobile purse : purses) {
			try {
				purse.getSprite().loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			boardFrame.addPawn(purse);
		}
		
		for(IMobile monster : monsters) {
			try {
				monster.getSprite().loadImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			boardFrame.addPawn(monster);
		}
		
		try {
			this.energyBall.getSprite().loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.door.getSprite().loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boardFrame.addPawn(this.energyBall);
		
		boardFrame.addPawn(this.door);
        
		boardFrame.addPawn(this.getMyCharacter());


        this.getLevel().getObservable().addObserver(boardFrame.getObserver());

        boardFrame.setVisible(true);
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		//NOP
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		this.getOrderPerformer().performOrder(keyEvent);
	}

	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		//NOP
	}

	/**
     * Gets the Level.
     * 
     * @return level
     */

	public ILevel getLevel() {
		return this.level;
	}

	/**
     * Set the Level.
     * 
     * @param level
	 * @throws IOException 
     */

	public void setLevel(ILevel level) throws IOException {
		this.level = level;
		int y = 0;
		int x = 0;
		for (y = 0; y < this.getLevel().getHeight(); y++) {
			for (x = 0; x < this.getLevel().getWidth(); x++) {
				this.getLevel().getOnTheLevelXY(x,y).getSprite().loadImage();
			}
		}
	}

	/**
     * Gets the Character.
     * @return myCharacter
     */
	public IMobile getMyCharacter() {
		return this.myCharacter;
	}

	/**
     * Sets the Character.
     * @param myCharacter
     */
	public void setMyCharacter(IMobile myCharacter) {
		this.myCharacter = myCharacter;
	}

	/**
     * Gets the OrderPerformer.
     * @return orderPerformer
     */
	public IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
     * Sets the OrderPerformer.
     * @param orderPerformer
     */
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/**
     * Gets the full view.
     * @return fullView
     */
	public Rectangle getFullView() {
		return this.fullView;
	}

	/**
     * Sets the full view.
     * @param fullView
     */
	public void setFullView(Rectangle fullView) {
		this.fullView = fullView;
	}
}
