package Frontend.main_game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import Frontend.utility.LineBreaker;

public class Game_Part {
    public Game_Part(JPanel main_game_page, JPanel main_page, CardLayout page) {
        // * Create a button
        // ! Create a getPicture() here for left and right then change the ImageIcon or
        // ! just change the JButton

        //// * set panel (button for image)
        // large width*height (550x780)
        // medium (390x554)
        // small (110x156)

        Image get_pic_L = new ImageIcon("Frontend/src/Main_Game/Example_photo.jpg").getImage();
        Image get_pic_R = new ImageIcon("Frontend/src/Main_Game/Example_photo.jpg").getImage();

        Image resize_L = get_pic_L.getScaledInstance(195, 277, Image.SCALE_DEFAULT);
        Image resize_R = get_pic_R.getScaledInstance(195, 277, Image.SCALE_DEFAULT);

        ImageIcon resizePic_L = new ImageIcon(resize_L);
        ImageIcon resizePic_R = new ImageIcon(resize_R);

        JButton button_L = new JButton(resizePic_L);
        JButton button_R = new JButton(resizePic_R);

        button_L.setBounds(120, 80, 195, 277);
        button_R.setBounds(435, 80, 195, 277);

        button_L.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left Button was clicked.");
            }
        });
        button_R.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Right Button was clicked.");
            }
        });

        main_game_page.add(button_L);
        main_game_page.add(button_R);

        //// * Anime title
        String anime_L = "Naruto: Shippuden"; // ? get from Tae
        String anime_R = "wrapping check 12345 67890a sdfa df d s ad fwe asdf asd"; // ? get from Tae

        anime_L = LineBreaker.breaker(anime_L, 25);
        anime_R = LineBreaker.breaker(anime_R, 25);

        JPanel aniPanel_L = new JPanel();
        aniPanel_L.setBounds(100, 350, 235, 100);
        JPanel aniPanel_R = new JPanel();
        aniPanel_R.setBounds(415, 350, 235, 100);

        JLabel aniL_text = new JLabel(
                "<html><p{text-alignment: center;} style=\"font-size:12px\">" + anime_L + "</p></html>");
        aniPanel_L.add(aniL_text);
        JLabel aniR_text = new JLabel(
                "<html><p{text-alignment: center;} style=\"font-size:12px\">" + anime_R + "</p></html>");
        aniPanel_R.add(aniR_text);

        main_game_page.add(aniPanel_L);
        main_game_page.add(aniPanel_R);

    }
}

// JButton example_button = new JButton(new AbstractAction(){
// @Override
// public void actionPerformed(final ActionEvent e){
// Text.setText(""+System.currentTimeMillis());
// }
// });

// setImage or setImageIcon
