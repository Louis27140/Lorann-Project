package model.element.motionless;

public abstract class MotionlessElementFactory {
	
	private static final CornerWall     cornerwall     = new CornerWall();
	
	private static final Floor          floor          = new Floor();
	
	private static final HorizontalWall horizontalwall = new HorizontalWall();
	
	private static final OpenedGate     openeddoor     = new OpenedGate();
	
	private static final VerticalWall   verticalwall   = new VerticalWall();
	
	private static MotionlessElement[] motionlessElements = {
			cornerwall,
			floor,
			horizontalwall,
			openeddoor,
			verticalwall
	};
	
	/**
	 * Creates the cornerwall.
	 * @return cornerwall
	 */
	public static MotionlessElement createCornerWall() {
		return cornerwall;
	}
	
	/**
	 * Creates the floor.
	 * @return floor
	 */
	public static MotionlessElement createFloor() {
		return floor;
	}
	
	/**
	 * Creates the horizontal wall.
	 * @return horizontalwall
	 */
	public static MotionlessElement createHorizontalWall() {
		return horizontalwall;
	}
	
	/**
	 * Creates the opened door.
	 * @return openeddoor
	 */
	public static MotionlessElement createOpenedDoor() {
		return openeddoor;
	}
	
	/**
	 * Creates the vertical wall.
	 * @return verticalwall
	 */
	public static MotionlessElement createVerticalWall() {
		return verticalwall;
	}
	
	/**
     * Gets the right MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return floor
     * 		the floor from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return floor;
    }
}
