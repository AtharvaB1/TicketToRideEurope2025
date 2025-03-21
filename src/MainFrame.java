//import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    
    //holds each panel as a variable, will be used to change screens in methods 
    private static JFrame frame;
    private static MenuPanel menu;
    private static PlayerChoicePanel choice;
    private static GamePanel game;
    private static EndPanel end;
    public static void main(String[] args) {

        //default settings for the frame
        frame = new JFrame("Ticket to Ride Europe");
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        frame.setExtendedState(6);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        //instantiates the menu screen
        menu = new MenuPanel();
        frame.add(menu);

        frame.setVisible(true);
    }

    //switches from the menu to the player choice screen
    public static void selectPlayers(){
        choice = new PlayerChoicePanel();
        frame.remove(menu);
        menu = null;
        frame.add(choice);
        frame.revalidate();
    }

    //changes screen from player choice screen to the game
    public static void startGame(int p){
        game = new GamePanel();
        frame.remove(choice);
        choice = null;
        frame.add(game);
        frame.revalidate();
    }

    //changes screen from game screen to the end screen
    public static void endGame(int p){
        end = new EndPanel();
        frame.remove(game);
        game = null;
        frame.add(end);
        frame.revalidate();
    }

    //changes screen from end screen back to the choice screen
    public static void restartGame(int p){
        choice = new PlayerChoicePanel();
        frame.remove(end);
        end = null;
        frame.add(choice);
        frame.revalidate();
    }
}
