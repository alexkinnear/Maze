
import javafx.animation.TranslateTransition;
import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;



import java.util.Scanner;

public class maze extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Pane pane = new Pane();

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a Maze: (1, 2, 3, 4)");
        int choice = scan.nextInt();

        Image image = getImage(choice);
        ImageView maze = getMaze(choice);
        pane.getChildren().addAll(maze);

        Rectangle r = getRectangle(choice);
        r.setFill(Color.RED);
        pane.getChildren().add(r);

        Scene scene = new Scene(pane, 800, 800);

        move(scene, r);

        stage.setScene(scene);
        stage.show();
    }

    private Image getImage(int choice) {
        switch (choice) {
            case 1: return new Image("File:img/Maze_1.jpg");
            case 2: return new Image("File:img/Maze_2.jpg");
            case 3: return new Image("File:img/Maze_3.jpg");
            default: return new Image("File:img/Maze_4.png");
        }
    }

    private ImageView getMaze(int choice) {
        Image Maze_1 = new Image("File:img/Maze_1.jpg");
        ImageView maze1 = new ImageView(Maze_1);
        maze1.setFitWidth(700);
        maze1.setFitHeight(700);
        maze1.setX(50);
        maze1.setY(50);

        Image Maze_2 = new Image("File:img/Maze_2.jpg");
        ImageView maze2 = new ImageView(Maze_2);
        maze2.setFitWidth(700);
        maze2.setFitHeight(700);
        maze2.setX(50);
        maze2.setY(50);

        Image Maze_3 = new Image("File:img/Maze_3.jpg");
        ImageView maze3 = new ImageView(Maze_3);
        maze3.setFitWidth(700);
        maze3.setFitHeight(700);
        maze3.setX(50);
        maze3.setY(50);

        Image Maze_4 = new Image("File:img/Maze_4.png");
        ImageView maze4 = new ImageView(Maze_4);
        maze4.setFitWidth(700);
        maze4.setFitHeight(700);
        maze4.setX(50);
        maze4.setY(50);

        switch (choice) {
            case 1: return maze1;
            case 2: return maze2;
            case 3: return maze3;
            default: return maze4;
        }
    }

    private Rectangle getRectangle(int choice) {
        switch(choice) {
            case 1: return new Rectangle(350, 30, 20, 20);
            case 2: return new Rectangle(120, 147, 10, 10);
            case 3: return new Rectangle(65, 697, 10, 10);
            default: return new Rectangle(60, 185, 20, 20);
        }
    }




    private void move(Scene scene, Rectangle r) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.LEFT)) {
                TranslateTransition translate = new TranslateTransition();
                translate.setByX(-10);
                translate.setDuration(Duration.seconds(0.05));
                translate.setNode(r);
                translate.play();
            }
            if (e.getCode().equals(KeyCode.RIGHT)) {
                TranslateTransition translate = new TranslateTransition();
                translate.setByX(10);
                translate.setDuration(Duration.seconds(0.05));
                translate.setNode(r);
                translate.play();
            }
            if (e.getCode().equals(KeyCode.UP)) {
                TranslateTransition translate = new TranslateTransition();
                translate.setByY(-10);
                translate.setDuration(Duration.seconds(0.05));
                translate.setNode(r);
                translate.play();
            }
            if (e.getCode().equals(KeyCode.DOWN)) {
                TranslateTransition translate = new TranslateTransition();
                translate.setByY(10);
                translate.setDuration(Duration.seconds(0.05));
                translate.setNode(r);
                translate.play();
            }
        });
    }

}




