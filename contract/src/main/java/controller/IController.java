package controller;

import java.io.IOException;
import java.sql.SQLException;

/**
 * <h1>The Interface IController.</h1>
 * 
 * 
 * @author Louis CHOCHOY, Thomas ISAAC, Valentin CASEN and Adrien LALISSE
 * @version 1.0
 */
public interface IController {
	
    /**
     * The start method
     *
     * @throws InterruptedException 
     * @throws IOException 
     * @throws SQLException 
     */
	
	void start() throws SQLException, InterruptedException, IOException;
	
	/**
     * Gets the order performer.
     *
     * @return the order performer
     */
	
	IOrderPerformer getOrderPerformer();

}
