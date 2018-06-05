package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	/** The image. */
    private Image   image;

    /** The image name. */
    private String  imageName;

    /** The is image loaded. */
    private boolean imageLoaded;
    
    /** The console image. */
    private char consoleImage;

    /**
     * Instantiates a new sprite.
     *
     * @param character
     *            the character
     * @param imageName
     *            the image name
     */
    public Sprite(final char character, final String imageName) {
    	this.setConsoleImage(character);
        this.setImageName(imageName);
    }

    /**
     * Instantiates a new sprite.
     *
     * @param character
     *            the character
     */
    public Sprite(final char character) {
        this(character, "noimage.jpg");
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    public final Image getImage() {
        return this.image;
    }

    /**
     * Loads image.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException {
    	String path = System.getProperty("user.dir") + "\\images\\" + this.getImageName() + ".png";

    	try {
    		this.setImage(ImageIO.read(new File(path)));
    	}
    	catch(Exception e){
    		path = System.getProperty("user.dir") + "\\images\\floor.png";
    		this.setImage(ImageIO.read(new File(path)));
    	}
        
    }

    /**
     * Sets the image.
     *
     * @param image
     *            the new image
     */
    private void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Gets the image name.
     *
     * @return the imageName
     */
    public final String getImageName() {
        return this.imageName;
    }

    /**
     * Sets the image name.
     *
     * @param imageName
     *            the imageName to set
     */
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    /**
     * Checks if is image loaded.
     *
     * @return true, if is image loaded
     */
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    /**
     * Sets the image loaded.
     *
     * @param isImageLoaded
     *            the new image loaded
     */
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }

    /**
     * Get the console image.
     *
     * @return consoleImage
     */
	public char getConsoleImage() {
		return this.consoleImage;
	}

	/**
     * Sets the console image.
     *
     * @param consoleImage
     */
	public void setConsoleImage(char consoleImage) {
		this.consoleImage = consoleImage;
	}
}
