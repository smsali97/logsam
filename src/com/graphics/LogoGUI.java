package com.graphics;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LogoGUI extends Application {

    private static List<String[]> instructions;
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

        ListIterator<String[]> instrIterator = instructions.listIterator();
        while (instrIterator.hasNext()) {



            String[] i = instrIterator.next();
            String instruction = i[0];
            String variable = i[1];
            float value = Float.parseFloat(i[2]);

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
                String[] i2 = instrIterator.next();
                String instruction2 = i2[0];
                String variable2 = i2[1];
                float value2 = Float.parseFloat(i2[2]);

                double newPosY = currPosY;
                double newPosX = currPosX;

                switch ( variable) {
                    case "POSY":
                        switch ( instruction) {
                            case "ADD":
                                newPosY += value;
                                break;
                            case "SUB":
                                newPosY -= value;
                        }
                        break;
                    case "POSX":
                        switch ( instruction) {
                            case "ADD":
                                newPosX += value;
                                break;
                            case "SUB":
                                newPosX -= value;
                        }
                        break;
                }

                switch ( variable2 ) {
                    case "POSY":
                        switch ( instruction2) {
                            case "ADD":
                                newPosY += value2;
                                break;
                            case "SUB":
                                newPosY -= value2;
                        }
                        break;
                    case "POSX":
                        switch ( instruction2) {
                            case "ADD":
                                newPosX += value2;
                                break;
                            case "SUB":
                                newPosX -= value2;
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
