import Frontend.GUI;

public class GUI_test {
    public static void main(String[] args) {
        try {
            GUI gui = GUI.getInstance();
            gui.useDefaultStartButton();
            gui.start();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}