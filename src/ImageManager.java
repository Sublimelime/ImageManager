
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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
        ArrayList<String> lines;
        try {
            lines = (ArrayList<String>) Files.readAllLines(Paths.get("ImageList.txt"));
        } catch (IOException exception) {
            System.out.println("Failed to open file for reading.");
            exception.printStackTrace();
            return false;
        }

        for (String line : lines) {
            //System.out.println("Line read: " + line);
            String[] vars = line.split("[,]");
            switch (vars[0]) {
                case "single": //single,key,fileName.extension
                    images.put(vars[1], ImageTools.load(vars[2]));
                    break;
                case "SNbL": //SNbL,number columns,key,fileName.extension
                    for (int i = 0; i < Integer.parseInt(vars[1]); i++) {
                        BufferedImage temp = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
                        BufferedImage loaded = ImageTools.load(vars[3]);
                        temp.getGraphics().drawImage(loaded.getSubimage(i * 100, 0, 100, 100), 0, 0, null);

                        images.put(vars[2] + i, temp);
                    }
                    break;
                case "SSN": //SSN,number columns,keys,fileName.extension
                    for (int i = 0; i < Integer.parseInt(vars[1]); i++) {
                        BufferedImage temp = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
                        BufferedImage loaded = ImageTools.load(vars[vars.length - 1]);
                        temp.getGraphics().drawImage(loaded.getSubimage(i * 100, 0, 100, 100), 0, 0, null);

                        images.put(vars[i + 2], temp);
                    }

                    break;
                case "GNbL":  //GNbL,number columns,number rows,key,fileName.extension
                    break;
                case "GSN": //GSN,number columns,number rows, column,keys,fileName.extension
                    break;
                default:
                    System.out.println("Bad line, cannot recognize type " + vars[1]);
            }
        }
        return false;
    }

    /**
     * Retrieves an image from the TreeMap via a key.
     *
     * @param key Gets an image from this key in the TreeMap
     * @return The gotten image.
     */
    public BufferedImage getImage(String key) {
        return images.get(key);
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
        return images.remove(key);
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
