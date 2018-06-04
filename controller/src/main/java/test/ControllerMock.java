package test;

import controller.IOrderPerformer;
import model.IModel;
import view.IView;

import java.awt.event.KeyEvent;

import controller.IController;

public class ControllerMock implements IController, IOrderPerformer{

	 /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    /** The order. */
    private KeyEvent stackOrder;
    

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
	public ControllerMock(final IView view, final IModel model) {
	        super();
	        this.view = view;
	        this.model = model;
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
	     * Stock the order.
	     *
	     * @return the model
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
	     * Set the order.
	     *
	     * @return the model
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


		@Override
		public void start() {
			// TODO Auto-generated method stub
			
		}
	}


