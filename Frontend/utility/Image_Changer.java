package Frontend.utility;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Image_Changer {
    ImageIcon resizePic_L;
    ImageIcon resizePic_R;

    /**
    * Resizes the left anime's image
    *
    * @param path_L The path to the left anime's picture
    */
    public void setImage_L(String path_L) {
        Image get_pic_L = new ImageIcon(path_L).getImage();
        Image resize_L = get_pic_L.getScaledInstance(195, 277, Image.SCALE_DEFAULT);
        resizePic_L = new ImageIcon(resize_L);
    }

    /**
    * Resizes the right anime's image
    *
    * @param path_R The path to the right anime's picture
    */
    public void setImage_R(String path_R) {
        Image get_pic_R = new ImageIcon(path_R).getImage();
        Image resize_R = get_pic_R.getScaledInstance(195, 277, Image.SCALE_DEFAULT);
        resizePic_R = new ImageIcon(resize_R);
    }

    /**
    * Returns the left anime's image
    *
    * @return ImageIcon
    */
    public ImageIcon getImage_L() {
        return resizePic_L;
    }

    /**
    * Returns the right anime's image
    *
    * @return ImageIcon
    */
    public ImageIcon getImage_R() {
        return resizePic_R;
    }
}
