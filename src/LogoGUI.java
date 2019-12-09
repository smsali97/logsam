import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class LogoGUI extends Application {

    private static List<String[]> instructions;
    private HashMap<String, Integer> addresses = new HashMap<>();
    private static final int APP_WIDTH = 600;
    private static final int APP_HEIGHT = 600;

    private double xRadius = 300;
    private double yRadius = 300;

    private double currPosX = 0;
    private double currPosY = 0;
    private double theta = 0;

    Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        canvas = new Canvas(APP_WIDTH, APP_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, APP_WIDTH, APP_HEIGHT);
        this.draw();


        Pane pane = new Pane(canvas);


        primaryStage.setTitle("Logo Application");
        primaryStage.setWidth(APP_WIDTH);
        primaryStage.setHeight(APP_HEIGHT);

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void startGUI(List<String[] > instructions) {
        LogoGUI.instructions = instructions;
        Application.launch();

    }


    public void draw() throws FileNotFoundException {

        GraphicsContext gc  = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.WHITE);

        int ctr = 0;

        ListIterator<String[]> instrIterator = instructions.listIterator();
        for (; ctr < instructions.size(); ctr++) {
            String[] i = instructions.get(ctr);
            String instruction, variable;
            float value;
            instruction = i[0];

            if (instruction.equals("CLEAR")) {
                Color temp = (Color) gc.getFill();
                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,APP_WIDTH,APP_HEIGHT);
                continue;
            }

            variable = i[1];

            if (instruction.equals("LOOP")) {
                String loopVar = variable;
                addresses.put(loopVar,ctr-1);
                int loopCtr = MyLogsamVisitor.symbolTable.get(loopVar);
                MyLogsamVisitor.symbolTable.put(loopVar, loopCtr + 1);
                continue;
            }

            if ( instruction.equals("CJ")) {
                int checkValue = Integer.parseInt(variable.split(" ")[1]);
                String gotoAddress = i[2].split(" ")[1];

                int loopCtr = MyLogsamVisitor.symbolTable.get(gotoAddress);
                if ( loopCtr < checkValue) ctr = addresses.get(gotoAddress);
                continue;
            }

            else if (instruction.equals("SWITCH")) {
                switch ( variable) {
                    case "BLACK":
                        gc.setStroke(Color.BLACK);
                        break;
                    case "GREEN":
                        gc.setStroke(Color.GREEN);
                        break;
                    case "BLUE":
                        gc.setStroke(Color.BLUE);
                        break;
                    case "RED":
                        gc.setStroke(Color.RED);
                        break;
                    case "PURPLE":
                        gc.setStroke(Color.PURPLE);
                        break;
                    case "YELLOW":
                        gc.setStroke(Color.YELLOW);
                        break;
                    case "WHITE":
                        gc.setStroke(Color.WHITE);
                        break;
                    case "TRANSPARENT":
                        gc.setStroke(Color.TRANSPARENT);
                        break;
                    default:
                        break;
                }
                continue;
            }

            value = Float.parseFloat(i[2]);

            // read in pairs
                if  (variable.equals("THETA") ) {
                    switch ( instruction) {
                        case "ADD":
                            theta += value % 360;
                            break;
                        case "SUB":
                            theta -= value % 360;
                            break;
                    }
                }
                else if ( (variable.equals("POSX") || variable.equals("POSY") ) && instrIterator.hasNext()) {

                    double cosTheta, sinTheta;
                    cosTheta = Math.cos(Math.toRadians(theta));
                    sinTheta = Math.sin(Math.toRadians(theta));


                String[] i2 = instructions.get(++ctr);
                String instruction2 = i2[0];
                String variable2 = i2[1];
                float value2 = Float.parseFloat(i2[2]);

                double newPosY = currPosY;
                double newPosX = currPosX;

                switch ( variable) {
                    case "POSY":
                        switch ( instruction) {
                            case "ADD":
                                newPosY += value * cosTheta;
                                break;
                            case "SUB":
                                newPosY -= value * cosTheta;
                        }
                        break;
                    case "POSX":
                        switch ( instruction) {
                            case "ADD":
                                newPosX += value * sinTheta ;
                                break;
                            case "SUB":
                                newPosX -= value * sinTheta;
                        }
                        break;
                }

                switch ( variable2 ) {
                    case "POSY":
                        switch ( instruction2) {
                            case "ADD":
                                newPosY += value2 * cosTheta;
                                break;
                            case "SUB":
                                newPosY -= value2 * cosTheta;
                        }
                        break;
                    case "POSX":
                        switch ( instruction2) {
                            case "ADD":
                                newPosX += value2 * sinTheta;
                                break;
                            case "SUB":
                                newPosX -= value2 * sinTheta;
                        }
                        break;
                }


                gc.strokeLine(cartesianXtoScreen(currPosX),cartesianYtoScreen(currPosY)
                ,cartesianXtoScreen(newPosX),cartesianYtoScreen(newPosY));

                currPosX = newPosX; currPosY = newPosY;
            }

        }

        Image img = new Image(new FileInputStream("turtle.png"));
        ImageView iv = new ImageView(img);
        iv.setRotate(theta);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = iv.snapshot(params, null);
        gc.drawImage(rotatedImage, cartesianXtoScreen(currPosX) - img.getWidth()/2,cartesianYtoScreen(currPosY) - img.getHeight()/2);


    }

    private double cartesianXtoScreen(double xp) {
        return (xp + xRadius) * APP_WIDTH / (2*xRadius);
    }

    private double cartesianYtoScreen(double yp) {
        return (yp - yRadius) * - APP_HEIGHT / (2*yRadius);
    }

}
