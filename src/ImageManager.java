
import java.awt.image.BufferedImage;
import java.util.Set;
import java.util.TreeMap;

public class ImageManager {

    private final TreeMap<String, BufferedImage> images;

    public ImageManager() {
        images = new TreeMap<>();
    }

    /**
     * Loads all the images in the file, with load type set by file syntax
     *
     * @param fileName File with names of images and type of load
     * @return success of load
     */
    public boolean loadImages(String fileName) {
        return false;
    }

    /**
     * Retrieves an image from the TreeMap via a key.
     *
     * @param key Gets an image from this key in the TreeMap
     * @return The gotten image.
     */
    public BufferedImage getImage(String key) {
        return null;
    }

    /**
     * Loads an image to a specified point in the TreeMap using the provided key.
     *
     * @param key Key to store the loaded image at.
     * @param file File to read from.
     * @return The loaded image.
     */
    public BufferedImage loadImage(String key, String file) {
        return null;
    }

    /**
     * Receives a key and removes the key and its image from the map
     *
     * @param key Key to remove
     * @return Returns the removed image.
     */
    public BufferedImage removeImage(String key) {
        return null;
    }

    /**
     * Empties the map.
     */
    public void clear() {
        images.clear();
    }

    /**
     *
     * @return Returns a set of all the keys in the map
     */
    public Set<String> getKeys() {
        return images.keySet();
    }
}
