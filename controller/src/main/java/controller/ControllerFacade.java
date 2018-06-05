package controller;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import model.IMobile;
import model.IModel;
import model.IMonster;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * 
 * @author Louis CHOCHOY, Thomas ISAAC, Valentin CASEN and Adrien LALISSE
 * @version 1.0
 */
public class ControllerFacade implements IController, IOrderPerformer {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    /** The order. */
    private KeyEvent stackOrder;
    
    /** The speed of refresh. */
    private static int speed = 150;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     * @throws InterruptedException 
     */
    public void start() throws SQLException, InterruptedException, IOException {
        while(this.getModel().getMyCharacter().isAlive()) {
        	Thread.sleep(speed);
        	
        	for(IMobile monster : this.getModel().getMonsters()) {
        		((IMonster)monster).move();
        	}
        	
        	if(this.getStackOrder() != null) {
        		switch(this.getStackOrder().getKeyCode()) {
        		case KeyEvent.VK_RIGHT:
        			this.getModel().getMyCharacter().moveRight();
        			break;
        		case KeyEvent.VK_LEFT:
        			this.getModel().getMyCharacter().moveLeft();
        			break;
        		case KeyEvent.VK_UP:
        			this.getModel().getMyCharacter().moveUp();
        			break;
        		case KeyEvent.VK_DOWN:
        			this.getModel().getMyCharacter().moveDown();
        			break;
        		case KeyEvent.VK_SPACE:
        			this.getModel().getMyCharacter().shoot();
        			break;
        		case KeyEvent.VK_SHIFT:
        			this.getModel().getMyCharacter().moveUpLeft();
        			break;
        		case KeyEvent.VK_NUMPAD1:
        			this.getModel().getMyCharacter().moveUpRight();
        			break;
        		case KeyEvent.VK_CONTROL:
        			this.getModel().getMyCharacter().moveDownLeft();
        			break;
        		case KeyEvent.VK_NUMPAD0:
        			this.getModel().getMyCharacter().moveDownRight();
        			break;
        		default:
        			this.getModel().getMyCharacter().doNothing();
        			break;
        		}
        		this.stackOrder = null;
        	}
        	else {
        		this.getModel().getMyCharacter().doNothing();
        	}
        	
        }
        if(this.getModel().hasCharacterWon())
        	this.getView().displayMessage("Level " + model.getLevelID() + " Finished");   
        else 
        	this.getView().displayMessage("Game Over");
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    
    /**
     * Performs the order.
     *
     *@param userOrder
     */
    public void performOrder(KeyEvent userOrder) {
    	this.setStackOrder(userOrder);
    }

    /**
     * Gets the order.
     *
     * @return the model
     */
	public KeyEvent getStackOrder() {
		return stackOrder;
	}

	/**
     * Sets the stack order.
     *
     * @param stackOrder
     */
	public void setStackOrder(KeyEvent stackOrder) {
		this.stackOrder = stackOrder;
	}
	
	/**
     * Gets the Order performer.
     *
     * @return the model
     */
	public IOrderPerformer getOrderPerformer() {
		return this;
	}
}
