package javafx_rivera_juan_8;

import java.io.File;
import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFx_Rivera_Juan_8 extends Application {

    boolean playingGame = true;

    String ver = "1.06E";

    final int HEIGHT = 675;
    final int WIDTH = 1100;

    ArrayList<Enemy> enemiez = new ArrayList<Enemy>();
    ArrayList<Asteroid> asteroidz = new ArrayList<Asteroid>();

    Pane root = new Pane();
    Pane rootGame = new Pane();
    Pane rootWin = new Pane();

    Scene scene = new Scene(root, WIDTH, HEIGHT);

    Media mediaMenu = new Media(new File("src/Resources/Sky_Fortress.mp3").toURI().toString());
    MediaPlayer playerMenu = new MediaPlayer(mediaMenu);

    Media mediaGame = new Media(new File("src/Resources/Milky_Ways_Redux.mp3").toURI().toString());
    MediaPlayer playerGame = new MediaPlayer(mediaGame);

    Media mediaEnd = new Media(new File("src/Resources/Detious_Telluric_Original_Mix.mp3").toURI().toString());
    MediaPlayer playerEnd = new MediaPlayer(mediaEnd);

    Media mediaShoot = new Media(new File("src/Resources/littlerobotsoundfactory_shoot-01.mp3").toURI().toString());
    MediaPlayer shootSound = new MediaPlayer(mediaShoot);

    Media mediaHit = new Media(new File("src/Resources/littlerobotsoundfactory_hit-03.mp3").toURI().toString());
    MediaPlayer hitSound = new MediaPlayer(mediaHit);

    Media mediaExplode = new Media(new File("src/Resources/littlerobotsoundfactory_explosion-03.mp3").toURI().toString());
    MediaPlayer explodeSound = new MediaPlayer(mediaExplode);

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Game!");
        primaryStage.setScene(scene);

        new Opener();

        primaryStage.show();
    }

    class Game {

        int i = 0;

        boolean finishedFirst = true; // false

        public String[] text = new String[48];
        public String[] characters = new String[7];

        public Game() {

            if (!this.finishedFirst) {

                this.firstScene();
                this.finishedFirst = true;
            } else if (this.finishedFirst || playingGame) {

                this.gamePlay();
            }
        }

        public void firstScene() {

            characters[0] = "Warrant Officer Ai:";
            characters[1] = "Commander Hana:";
            characters[2] = "Warrant Officer Kichi:";
            characters[3] = "Unknown...";
            characters[4] = "Ren"; // Imouto
            characters[5] = "Aoi"; // Special Person

            // 1st Scene
            text[0] = "Commander! The enemy have breached our first line of defenses!";
            text[1] = "Team Alpha is down! No responders!";
            text[2] = "They are now heading Westward towards the first pillar!";
            text[3] = "WHAT! Send Team Bravo and Team Epsilon out there!";
            text[4] = "Tell them to stop what ever is out there!";
            text[5] = "Whatever the cost is...";
            text[6] = "Have you identifyed the object yet?";
            text[7] = "We are working on that Commander!";
            text[8] = "Notify me at once when you've identifyed that thing.";
            text[9] = "**Ugh, What does he want now at a time like this?!**";
            text[10] = "Commander, Where are you going?";
            text[11] = "Ai, You're in charge!";
            text[12] = "YES MA'AM!";
            // 2nd Scene
            text[13] = "You Called?";
            text[14] = "Yes...";
            text[15] = "When do you plan on bringing an end to Phase 1?";
            text[16] = "Soon.";
            text[17] = "I hope to see progress within your plan.";
            text[18] = "Don't you worry, Everything so far is coming along nicely.";
            text[19] = "So if that's all, I got some things to do.";
            text[20] = "Please alert me when you develop something to help us\nwin this war.";
            text[21] = "Remember, this is a matter of if we get to live on after\nthis war or not.";
            text[22] = "Yes I know.";
            text[23] = "I'll be back if I find anything.";
            // 3rd Scene
            text[24] = "Do you have the Mech ready for deployment?";
            text[25] = "Yes Ma'am! Right over Here!";
            // 4th Scene
            text[26] = "Launching in 10";
            text[27] = "Launching in 9";
            text[28] = "Launching in 8";
            text[29] = "Launching in 7";
            text[30] = "Launching in 8";
            text[31] = "Launching in 6";
            text[32] = "Launching in 5";
            text[33] = "Launching in 4";
            text[34] = "Launching in 3";
            text[35] = "Launching in 2";
            text[36] = "Launching in 1";
            text[37] = "LAUNCHING!";
            // 5th Scene
            text[38] = "Naegi~~? Oh Naegi~~~?";
            text[39] = "NAEGI!!!!!";
            text[40] = "AAAAAAAAAAAAAAAAAAAAA Ow!";
            text[41] = "That hurt.";
            text[42] = "WHAT!";
            text[43] = "Time for school!";
            text[44] = "Come on hurry, We are already almost late!";
            text[45] = "~Stare~";
            text[46] = "Ok Fine.";

//			text[n] = "Remember to put your Space Suit on, It's not safe without it\noutside";
//			text[n] = "Yeah, Yeah";
//			text[n] = "Here I got it for you.";
//			text[n] = "Thank you.";
            Image is = new Image("file:src/Resources/concept_art_engineroom.jpg");
            Image is1 = new Image(
                    "file:src/Resources/d6mobmw-f771de3b-70b5-4ea0-b770-6398dbc3f376.jpg");
//			Image is2 = new Image("file:///C:/Users/Jr234/eclipse-workspace/VisualNovel/src/Resources/anime_bedroom.jpg");

            ImageView img = new ImageView(is);
            img.setFitWidth(1100);
            img.setFitHeight(675);

            Rectangle fadeRect = new Rectangle(WIDTH, HEIGHT);
            fadeRect.setFill(Color.BLACK);

            Rectangle alarm = new Rectangle(WIDTH, HEIGHT);
            alarm.setFill(Color.RED);
            alarm.setOpacity(0);

            FadeTransition fadeout = new FadeTransition(Duration.seconds(1), fadeRect);
            fadeout.setFromValue(1);
            fadeout.setToValue(0);
            fadeout.play();

            FadeTransition alarmfade = new FadeTransition(Duration.seconds(1), alarm);
            alarmfade.setFromValue(0);
            alarmfade.setToValue(0.3);
            alarmfade.setCycleCount(Animation.INDEFINITE);
            alarmfade.setAutoReverse(true);
            alarmfade.play();

            Rectangle dialougeBox = new Rectangle(900, 250);
            dialougeBox.setStroke(Color.WHITE);
            dialougeBox.setStrokeWidth(0.5);
            dialougeBox.setTranslateX(100);
            dialougeBox.setTranslateY(395);
            dialougeBox.setOpacity(0.4);
            dialougeBox.setArcWidth(30.0);
            dialougeBox.setArcHeight(30.0);

            Text dialouge = new Text(text[0]);
            dialouge.setFill(Color.WHITE);
            dialouge.setStroke(Color.BLACK);
            dialouge.setStrokeWidth(0.3);
            dialouge.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 27));
            dialouge.setTranslateX(170);
            dialouge.setTranslateY(510);

            Text names = new Text(characters[0]);
            names.setFill(Color.WHITE);
            names.setStroke(Color.BLACK);
            names.setStrokeWidth(0.3);
            names.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 25));
            names.setTranslateX(165);
            names.setTranslateY(450);

            Text enterText = new Text("Press Enter");
            enterText.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 20));
            enterText.setTranslateX(875);
            enterText.setTranslateY(625);
            enterText.setOpacity(0);
            enterText.setFill(Color.WHITE);
            enterText.setStroke(Color.BLACK);
            enterText.setStrokeWidth(0.5);

            FadeTransition fadeinout = new FadeTransition(Duration.seconds(1.25), enterText);
            fadeinout.setFromValue(0);
            fadeinout.setToValue(0.85);
            fadeinout.setCycleCount(Animation.INDEFINITE);
            fadeinout.setAutoReverse(true);
            fadeinout.play();

            EventHandler<KeyEvent> enter = new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent e) {
                    if (e.getCode() == KeyCode.ENTER) {

                        i++;
                        System.out.println(i);

                        dialouge.setText(text[i]);

                        if (i == 3) {

                            names.setText(characters[1]);
                        }

                        if (i == 7) {

                            names.setText(characters[2]);
                        }

                        if (i == 8) {

                            names.setText(characters[1]);
                        }

                        if (i == 9) {

                            dialouge.setFill(Color.LIGHTGREY);
                        }

                        if (i == 10) {

                            dialouge.setFill(Color.WHITE);
                            names.setText(characters[0]);
                        }

                        if (i == 11) {

                            names.setText(characters[1]);
                        }

                        if (i == 12) {

                            names.setText(characters[0]);
                        }

                        if (i == 13) {

                            FadeTransition fadein = new FadeTransition(Duration.seconds(1), fadeRect);
                            fadein.setFromValue(0);
                            fadein.setToValue(1);
                            fadein.play();

                            FadeTransition fadeout1 = new FadeTransition(Duration.seconds(2.5), fadeRect);
                            fadeout1.setFromValue(1);
                            fadeout1.setToValue(0);
                            fadeout1.play();

                            img.setImage(is1);
                            names.setText(characters[1]);

                            rootGame.getChildren().remove(alarm);
                        }

                        if (i == 14) {

                            names.setText(characters[3]);
                        }

                        if (i == 16) {

                            names.setText(characters[1]);
                        }

                        if (i == 17) {

                            names.setText(characters[3]);
                        }

                        if (i == 18) {

                            names.setText(characters[1]);
                        }

                        if (i == 19) {

                            names.setText(characters[3]);
                        }

                        if (i == 22) {

                            names.setText(characters[1]);
                        }

                        if (i == 24) {

                            FadeTransition fadeout = new FadeTransition(Duration.seconds(1), fadeRect);
                            fadeout.setFromValue(0);
                            fadeout.setToValue(1);
                            fadeout.setOnFinished(evt -> {
                                gamePlay();
                                i = 0;
                                rootGame.getChildren().removeAll(img, dialougeBox, dialouge, enterText, names,
                                        fadeRect);
                            });
                            fadeout.play();
                        }
                    }
                }
            };

            // Remove everything from the event handler and just put i++, try and put
            // everything else on the outside of
            // The event handler to stop inputs from coming in precisely at i == 13 and i ==
            // 24.
            scene.setOnKeyPressed(enter);

            rootGame.getChildren().addAll(img, dialougeBox, dialouge, enterText, names, alarm, fadeRect);
        }

        public void gamePlay() {

            Image img = new Image("file:src/Resources/94410ad08b9abc64c1ab6d215c1a4449a5a0ef9c.jpg");
            ImageView bgImg = new ImageView(img);
            bgImg.setFitHeight(1460);
            bgImg.setFitWidth(2300);
            bgImg.setTranslateX(-285);
            bgImg.setTranslateY(-395);

            playerGame.setCycleCount(MediaPlayer.INDEFINITE);

            Rectangle fadeRectGame = new Rectangle(WIDTH / 2, HEIGHT);
            fadeRectGame.setFill(Color.BLACK);

            Rectangle fadeRect1Game = new Rectangle((WIDTH / 2) + 1, HEIGHT);
            fadeRect1Game.setFill(Color.BLACK);
            fadeRect1Game.setTranslateX(550);

            Rectangle deathRectGame = new Rectangle(WIDTH, HEIGHT);
            deathRectGame.setFill(Color.BLACK);
            deathRectGame.setOpacity(0);

            Player CoolCat = new Player(100, 325);
            CoolCat.setFill(Color.BLUE);

            for (int i = 0; i < 7; i++) {

                enemiez.add(new Enemy(1110, Math.random() * 675));
            }

            for (int i = 0; i < 4; i++) {

                asteroidz.add(new Asteroid(1110, Math.random() * 675));
            }

//			DeathScreenItem itemRestart = new DeathScreenItem("Restart");
//			itemRestart.setTranslateX(500);
//			itemRestart.setTranslateY(350);
//			itemRestart.setOpacity(0);
            DeathScreenItem itemExit = new DeathScreenItem("Exit");
            itemExit.setTranslateX(530);
            itemExit.setTranslateY(425);
            itemExit.setOpacity(0);

            Text deathTextGame = new Text("You Died");
            deathTextGame.setFill(Color.TOMATO);
            deathTextGame.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 75));
            deathTextGame.setTranslateX(400);
            deathTextGame.setTranslateY(150);
            deathTextGame.setOpacity(0);

            Text reload = new Text("Reloading");
            reload.setFont(Font.font("Tw Cen MT Condensed", FontWeight.NORMAL, 35));
            reload.setFill(Color.GREY);
            reload.setX(65);
            reload.setY(660);
            reload.setOpacity(0.5);

            Rectangle hudBarTop = new Rectangle(270, 0, 550, 30);
            hudBarTop.setFill(Color.BLACK);
            hudBarTop.setStrokeWidth(1.5);
            hudBarTop.setStroke(Color.WHITE);
            hudBarTop.setOpacity(0.75);

            Rectangle hudBarTop1 = new Rectangle(240, -10, 30, 30);
            hudBarTop1.setFill(Color.BLACK);
            hudBarTop1.setStrokeWidth(1.5);
            hudBarTop1.setStroke(Color.WHITE);
            hudBarTop1.setOpacity(0.75);

            Rectangle hudBarTop2 = new Rectangle(820, -10, 30, 30);
            hudBarTop2.setFill(Color.BLACK);
            hudBarTop2.setStrokeWidth(1.5);
            hudBarTop2.setStroke(Color.WHITE);
            hudBarTop2.setOpacity(0.75);

            Rectangle hudBarTop3 = new Rectangle(-10, -10, 50, 50);
            hudBarTop3.setFill(Color.BLACK);
            hudBarTop3.setStrokeWidth(1.5);
            hudBarTop3.setStroke(Color.WHITE);
            hudBarTop3.setOpacity(0.75);

            Rectangle hudBarTop4 = new Rectangle(1060, -10, 50, 50);
            hudBarTop4.setFill(Color.BLACK);
            hudBarTop4.setStrokeWidth(1.5);
            hudBarTop4.setStroke(Color.WHITE);
            hudBarTop4.setOpacity(0.75);

            Rectangle hudBarTop5 = new Rectangle(-10, 40, 25, 25);
            hudBarTop5.setFill(Color.BLACK);
            hudBarTop5.setStrokeWidth(1.5);
            hudBarTop5.setStroke(Color.WHITE);
            hudBarTop5.setOpacity(0.75);

            Rectangle hudBarTop6 = new Rectangle(1085, 40, 25, 25);
            hudBarTop6.setFill(Color.BLACK);
            hudBarTop6.setStrokeWidth(1.5);
            hudBarTop6.setStroke(Color.WHITE);
            hudBarTop6.setOpacity(0.75);

            Rectangle hudBarBottom = new Rectangle(270, 645, 550, 45);
            hudBarBottom.setFill(Color.BLACK);
            hudBarBottom.setStrokeWidth(1.5);
            hudBarBottom.setStroke(Color.WHITE);
            hudBarBottom.setOpacity(0.75);

            Rectangle hudBarBottom1 = new Rectangle(240, 655, 30, 40);
            hudBarBottom1.setFill(Color.BLACK);
            hudBarBottom1.setStrokeWidth(1.5);
            hudBarBottom1.setStroke(Color.WHITE);
            hudBarBottom1.setOpacity(0.75);

            Rectangle hudBarBottom2 = new Rectangle(820, 655, 30, 40);
            hudBarBottom2.setFill(Color.BLACK);
            hudBarBottom2.setStrokeWidth(1.5);
            hudBarBottom2.setStroke(Color.WHITE);
            hudBarBottom2.setOpacity(0.75);

            Rectangle hudBarBottom3 = new Rectangle(-10, 635, 50, 60);
            hudBarBottom3.setFill(Color.BLACK);
            hudBarBottom3.setStrokeWidth(1.5);
            hudBarBottom3.setStroke(Color.WHITE);
            hudBarBottom3.setOpacity(0.75);

            Rectangle hudBarBottom4 = new Rectangle(1060, 635, 50, 60);
            hudBarBottom4.setFill(Color.BLACK);
            hudBarBottom4.setStrokeWidth(1.5);
            hudBarBottom4.setStroke(Color.WHITE);
            hudBarBottom4.setOpacity(0.75);

            Rectangle hudBarBottom5 = new Rectangle(-10, 610, 25, 25);
            hudBarBottom5.setFill(Color.BLACK);
            hudBarBottom5.setStrokeWidth(1.5);
            hudBarBottom5.setStroke(Color.WHITE);
            hudBarBottom5.setOpacity(0.75);

            Rectangle hudBarBottom6 = new Rectangle(1085, 610, 25, 25);
            hudBarBottom6.setFill(Color.BLACK);
            hudBarBottom6.setStrokeWidth(1.5);
            hudBarBottom6.setStroke(Color.WHITE);
            hudBarBottom6.setOpacity(0.75);

            Rectangle bigBullet1 = new Rectangle(870, 645, 170, 20);
            bigBullet1.setFill(Color.LAWNGREEN);
            bigBullet1.setStrokeWidth(1);
            bigBullet1.setStroke(Color.LAWNGREEN);
            bigBullet1.setOpacity(0.5);

            Rectangle bullet1 = new Rectangle(50, 5, 20, 30);
            bullet1.setFill(Color.LAWNGREEN);
            bullet1.setStrokeWidth(1);
            bullet1.setStroke(Color.LAWNGREEN);
            bullet1.setOpacity(0.5);

            Rectangle bullet2 = new Rectangle(80, 5, 20, 30);
            bullet2.setFill(Color.LAWNGREEN);
            bullet2.setStrokeWidth(1);
            bullet2.setStroke(Color.LAWNGREEN);
            bullet2.setOpacity(0.5);

            Rectangle bullet3 = new Rectangle(110, 5, 20, 30);
            bullet3.setFill(Color.LAWNGREEN);
            bullet3.setStrokeWidth(1);
            bullet3.setStroke(Color.LAWNGREEN);
            bullet3.setOpacity(0.5);

            Rectangle bullet4 = new Rectangle(140, 5, 20, 30);
            bullet4.setFill(Color.LAWNGREEN);
            bullet4.setStrokeWidth(1);
            bullet4.setStroke(Color.LAWNGREEN);
            bullet4.setOpacity(0.5);

            Rectangle bullet5 = new Rectangle(170, 5, 20, 30);
            bullet5.setFill(Color.LAWNGREEN);
            bullet5.setStrokeWidth(1);
            bullet5.setStroke(Color.LAWNGREEN);
            bullet5.setOpacity(0.5);

            Rectangle bullet6 = new Rectangle(200, 5, 20, 30);
            bullet6.setFill(Color.LAWNGREEN);
            bullet6.setStrokeWidth(1);
            bullet6.setStroke(Color.LAWNGREEN);
            bullet6.setOpacity(0.5);

            Rectangle bullet7 = new Rectangle(860, 5, 20, 30);
            bullet7.setFill(Color.LAWNGREEN);
            bullet7.setStrokeWidth(1);
            bullet7.setStroke(Color.LAWNGREEN);
            bullet7.setOpacity(0.5);

            Rectangle bullet8 = new Rectangle(890, 5, 20, 30);
            bullet8.setFill(Color.LAWNGREEN);
            bullet8.setStrokeWidth(1);
            bullet8.setStroke(Color.LAWNGREEN);
            bullet8.setOpacity(0.5);

            Rectangle bullet9 = new Rectangle(920, 5, 20, 30);
            bullet9.setFill(Color.LAWNGREEN);
            bullet9.setStrokeWidth(1);
            bullet9.setStroke(Color.LAWNGREEN);
            bullet9.setOpacity(0.5);

            Rectangle bullet10 = new Rectangle(950, 5, 20, 30);
            bullet10.setFill(Color.LAWNGREEN);
            bullet10.setStrokeWidth(1);
            bullet10.setStroke(Color.LAWNGREEN);
            bullet10.setOpacity(0.5);

            Rectangle bullet11 = new Rectangle(980, 5, 20, 30);
            bullet11.setFill(Color.LAWNGREEN);
            bullet11.setStrokeWidth(1);
            bullet11.setStroke(Color.LAWNGREEN);
            bullet11.setOpacity(0.5);

            Rectangle bullet12 = new Rectangle(1010, 5, 20, 30);
            bullet12.setFill(Color.LAWNGREEN);
            bullet12.setStrokeWidth(1);
            bullet12.setStroke(Color.LAWNGREEN);
            bullet12.setOpacity(0.5);

            Rectangle visor = new Rectangle(WIDTH, HEIGHT);
            visor.setFill(Color.BLACK);
            visor.setOpacity(.95);

            FadeTransition fadeinout = new FadeTransition(Duration.seconds(.3), reload);
            fadeinout.setFromValue(1);
            fadeinout.setToValue(0.25);
            fadeinout.setCycleCount(10);
            fadeinout.setAutoReverse(true);
            fadeinout.setOnFinished(evt -> {

                reload.setFill(Color.GREY);
                reload.setOpacity(0.5);
            });

            AnimationTimer hudMoveLeft = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    hudBarTop.setTranslateX(-10);
                    hudBarTop1.setTranslateX(-10);
                    hudBarTop2.setTranslateX(-10);
                    hudBarTop3.setTranslateX(-10);
                    hudBarTop4.setTranslateX(-10);
                    hudBarTop5.setTranslateX(-10);
                    hudBarTop6.setTranslateX(-10);
                    hudBarBottom.setTranslateX(-10);
                    hudBarBottom1.setTranslateX(-10);
                    hudBarBottom2.setTranslateX(-10);
                    hudBarBottom3.setTranslateX(-10);
                    hudBarBottom4.setTranslateX(-10);
                    hudBarBottom5.setTranslateX(-10);
                    hudBarBottom6.setTranslateX(-10);

                    bullet1.setTranslateX(-10);
                    bullet2.setTranslateX(-10);
                    bullet3.setTranslateX(-10);
                    bullet4.setTranslateX(-10);
                    bullet5.setTranslateX(-10);
                    bullet6.setTranslateX(-10);
                    bullet7.setTranslateX(-10);
                    bullet8.setTranslateX(-10);
                    bullet9.setTranslateX(-10);
                    bullet10.setTranslateX(-10);
                    bullet11.setTranslateX(-10);
                    bullet12.setTranslateX(-10);

                    bigBullet1.setTranslateX(-10);

                    reload.setTranslateX(-10);

                    TranslateTransition tt = new TranslateTransition(Duration.seconds(.25), hudBarTop);
                    tt.setFromX(-10);
                    tt.setToX(0);
                    tt.setOnFinished(evt -> {
                        stop();
                    });
                    tt.play();
                    TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.25), hudBarTop1);
                    tt1.setFromX(-10);
                    tt1.setToX(0);
                    tt1.play();
                    TranslateTransition tt2 = new TranslateTransition(Duration.seconds(.25), hudBarTop2);
                    tt2.setFromX(-10);
                    tt2.setToX(0);
                    tt2.play();
                    TranslateTransition tt3 = new TranslateTransition(Duration.seconds(.25), hudBarTop3);
                    tt3.setFromX(-10);
                    tt3.setToX(0);
                    tt3.play();
                    TranslateTransition tt4 = new TranslateTransition(Duration.seconds(.25), hudBarTop4);
                    tt4.setFromX(-10);
                    tt4.setToX(0);
                    tt4.play();
                    TranslateTransition tt5 = new TranslateTransition(Duration.seconds(.25), hudBarTop5);
                    tt5.setFromX(-10);
                    tt5.setToX(0);
                    tt5.play();
                    TranslateTransition tt6 = new TranslateTransition(Duration.seconds(.25), hudBarTop6);
                    tt6.setFromX(-10);
                    tt6.setToX(0);
                    tt6.play();
                    TranslateTransition tt7a = new TranslateTransition(Duration.seconds(.25), bullet1);
                    tt7a.setFromX(-10);
                    tt7a.setToX(0);
                    tt7a.play();
                    TranslateTransition tt7b = new TranslateTransition(Duration.seconds(.25), bullet2);
                    tt7b.setFromX(-10);
                    tt7b.setToX(0);
                    tt7b.play();
                    TranslateTransition tt7c = new TranslateTransition(Duration.seconds(.25), bullet3);
                    tt7c.setFromX(-10);
                    tt7c.setToX(0);
                    tt7c.play();
                    TranslateTransition tt7d = new TranslateTransition(Duration.seconds(.25), bullet4);
                    tt7d.setFromX(-10);
                    tt7d.setToX(0);
                    tt7d.play();
                    TranslateTransition tt7e = new TranslateTransition(Duration.seconds(.25), bullet5);
                    tt7e.setFromX(-10);
                    tt7e.setToX(0);
                    tt7e.play();
                    TranslateTransition tt7f = new TranslateTransition(Duration.seconds(.25), bullet6);
                    tt7f.setFromX(-10);
                    tt7f.setToX(0);
                    tt7f.play();
                    TranslateTransition tt7g = new TranslateTransition(Duration.seconds(.25), bullet7);
                    tt7g.setFromX(-10);
                    tt7g.setToX(0);
                    tt7g.play();
                    TranslateTransition tt7h = new TranslateTransition(Duration.seconds(.25), bullet8);
                    tt7h.setFromX(-10);
                    tt7h.setToX(0);
                    tt7h.play();
                    TranslateTransition tt7i = new TranslateTransition(Duration.seconds(.25), bullet9);
                    tt7i.setFromX(-10);
                    tt7i.setToX(0);
                    tt7i.play();
                    TranslateTransition tt7j = new TranslateTransition(Duration.seconds(.25), bullet10);
                    tt7j.setFromX(-10);
                    tt7j.setToX(0);
                    tt7j.play();
                    TranslateTransition tt7k = new TranslateTransition(Duration.seconds(.25), bullet11);
                    tt7k.setFromX(-10);
                    tt7k.setToX(0);
                    tt7k.play();
                    TranslateTransition tt7l = new TranslateTransition(Duration.seconds(.25), bullet12);
                    tt7l.setFromX(-10);
                    tt7l.setToX(0);
                    tt7l.play();
                    TranslateTransition tt8 = new TranslateTransition(Duration.seconds(.25), bigBullet1);
                    tt8.setFromX(-10);
                    tt8.setToX(0);
                    tt8.play();
                    TranslateTransition tt9 = new TranslateTransition(Duration.seconds(.25), reload);
                    tt9.setFromX(-10);
                    tt9.setToX(0);
                    tt9.play();

                    TranslateTransition tt10 = new TranslateTransition(Duration.seconds(.25), hudBarBottom);
                    tt10.setFromX(-10);
                    tt10.setToX(0);
                    tt10.setOnFinished(evt -> {
                        stop();
                    });
                    tt10.play();
                    TranslateTransition tt11 = new TranslateTransition(Duration.seconds(.25), hudBarBottom1);
                    tt11.setFromX(-10);
                    tt11.setToX(0);
                    tt11.play();
                    TranslateTransition tt12 = new TranslateTransition(Duration.seconds(.25), hudBarBottom2);
                    tt12.setFromX(-10);
                    tt12.setToX(0);
                    tt12.play();
                    TranslateTransition tt13 = new TranslateTransition(Duration.seconds(.25), hudBarBottom3);
                    tt13.setFromX(-10);
                    tt13.setToX(0);
                    tt13.play();
                    TranslateTransition tt14 = new TranslateTransition(Duration.seconds(.25), hudBarBottom4);
                    tt14.setFromX(-10);
                    tt14.setToX(0);
                    tt14.play();
                    TranslateTransition tt15 = new TranslateTransition(Duration.seconds(.25), hudBarBottom5);
                    tt15.setFromX(-10);
                    tt15.setToX(0);
                    tt15.play();
                    TranslateTransition tt16 = new TranslateTransition(Duration.seconds(.25), hudBarBottom6);
                    tt16.setFromX(-10);
                    tt16.setToX(0);
                    tt16.play();
                }
            };

            AnimationTimer hudMoveRight = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    hudBarTop.setTranslateX(10);
                    hudBarTop1.setTranslateX(10);
                    hudBarTop2.setTranslateX(10);
                    hudBarTop3.setTranslateX(10);
                    hudBarTop4.setTranslateX(10);
                    hudBarTop5.setTranslateX(10);
                    hudBarTop6.setTranslateX(10);
                    hudBarBottom.setTranslateX(10);
                    hudBarBottom1.setTranslateX(10);
                    hudBarBottom2.setTranslateX(10);
                    hudBarBottom3.setTranslateX(10);
                    hudBarBottom4.setTranslateX(10);
                    hudBarBottom5.setTranslateX(10);
                    hudBarBottom6.setTranslateX(10);

                    bullet1.setTranslateX(10);
                    bullet2.setTranslateX(10);
                    bullet3.setTranslateX(10);
                    bullet4.setTranslateX(10);
                    bullet5.setTranslateX(10);
                    bullet6.setTranslateX(10);
                    bullet7.setTranslateX(10);
                    bullet8.setTranslateX(10);
                    bullet9.setTranslateX(10);
                    bullet10.setTranslateX(10);
                    bullet11.setTranslateX(10);
                    bullet12.setTranslateX(10);

                    bigBullet1.setTranslateX(10);

                    reload.setTranslateX(10);

                    TranslateTransition tt = new TranslateTransition(Duration.seconds(.25), hudBarTop);
                    tt.setFromX(10);
                    tt.setToX(0);
                    tt.setOnFinished(evt -> {
                        stop();
                    });
                    tt.play();
                    TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.25), hudBarTop1);
                    tt1.setFromX(10);
                    tt1.setToX(0);
                    tt1.play();
                    TranslateTransition tt2 = new TranslateTransition(Duration.seconds(.25), hudBarTop2);
                    tt2.setFromX(10);
                    tt2.setToX(0);
                    tt2.play();
                    TranslateTransition tt3 = new TranslateTransition(Duration.seconds(.25), hudBarTop3);
                    tt3.setFromX(10);
                    tt3.setToX(0);
                    tt3.play();
                    TranslateTransition tt4 = new TranslateTransition(Duration.seconds(.25), hudBarTop4);
                    tt4.setFromX(10);
                    tt4.setToX(0);
                    tt4.play();
                    TranslateTransition tt5 = new TranslateTransition(Duration.seconds(.25), hudBarTop5);
                    tt5.setFromX(10);
                    tt5.setToX(0);
                    tt5.play();
                    TranslateTransition tt6 = new TranslateTransition(Duration.seconds(.25), hudBarTop6);
                    tt6.setFromX(10);
                    tt6.setToX(0);
                    tt6.play();
                    TranslateTransition tt7a = new TranslateTransition(Duration.seconds(.25), bullet1);
                    tt7a.setFromX(10);
                    tt7a.setToX(0);
                    tt7a.play();
                    TranslateTransition tt7b = new TranslateTransition(Duration.seconds(.25), bullet2);
                    tt7b.setFromX(10);
                    tt7b.setToX(0);
                    tt7b.play();
                    TranslateTransition tt7c = new TranslateTransition(Duration.seconds(.25), bullet3);
                    tt7c.setFromX(10);
                    tt7c.setToX(0);
                    tt7c.play();
                    TranslateTransition tt7d = new TranslateTransition(Duration.seconds(.25), bullet4);
                    tt7d.setFromX(10);
                    tt7d.setToX(0);
                    tt7d.play();
                    TranslateTransition tt7e = new TranslateTransition(Duration.seconds(.25), bullet5);
                    tt7e.setFromX(10);
                    tt7e.setToX(0);
                    tt7e.play();
                    TranslateTransition tt7f = new TranslateTransition(Duration.seconds(.25), bullet6);
                    tt7f.setFromX(10);
                    tt7f.setToX(0);
                    tt7f.play();
                    TranslateTransition tt7g = new TranslateTransition(Duration.seconds(.25), bullet7);
                    tt7g.setFromX(10);
                    tt7g.setToX(0);
                    tt7g.play();
                    TranslateTransition tt7h = new TranslateTransition(Duration.seconds(.25), bullet8);
                    tt7h.setFromX(10);
                    tt7h.setToX(0);
                    tt7h.play();
                    TranslateTransition tt7i = new TranslateTransition(Duration.seconds(.25), bullet9);
                    tt7i.setFromX(10);
                    tt7i.setToX(0);
                    tt7i.play();
                    TranslateTransition tt7j = new TranslateTransition(Duration.seconds(.25), bullet10);
                    tt7j.setFromX(10);
                    tt7j.setToX(0);
                    tt7j.play();
                    TranslateTransition tt7k = new TranslateTransition(Duration.seconds(.25), bullet11);
                    tt7k.setFromX(10);
                    tt7k.setToX(0);
                    tt7k.play();
                    TranslateTransition tt7l = new TranslateTransition(Duration.seconds(.25), bullet12);
                    tt7l.setFromX(10);
                    tt7l.setToX(0);
                    tt7l.play();
                    TranslateTransition tt8 = new TranslateTransition(Duration.seconds(.25), bigBullet1);
                    tt8.setFromX(10);
                    tt8.setToX(0);
                    tt8.play();
                    TranslateTransition tt9 = new TranslateTransition(Duration.seconds(.25), reload);
                    tt9.setFromX(10);
                    tt9.setToX(0);
                    tt9.play();

                    TranslateTransition tt10 = new TranslateTransition(Duration.seconds(.25), hudBarBottom);
                    tt10.setFromX(10);
                    tt10.setToX(0);
                    tt10.play();
                    TranslateTransition tt11 = new TranslateTransition(Duration.seconds(.25), hudBarBottom1);
                    tt11.setFromX(10);
                    tt11.setToX(0);
                    tt11.play();
                    TranslateTransition tt12 = new TranslateTransition(Duration.seconds(.25), hudBarBottom2);
                    tt12.setFromX(10);
                    tt12.setToX(0);
                    tt12.play();
                    TranslateTransition tt13 = new TranslateTransition(Duration.seconds(.25), hudBarBottom3);
                    tt13.setFromX(10);
                    tt13.setToX(0);
                    tt13.play();
                    TranslateTransition tt14 = new TranslateTransition(Duration.seconds(.25), hudBarBottom4);
                    tt14.setFromX(10);
                    tt14.setToX(0);
                    tt14.play();
                    TranslateTransition tt15 = new TranslateTransition(Duration.seconds(.25), hudBarBottom5);
                    tt15.setFromX(10);
                    tt15.setToX(0);
                    tt15.play();
                    TranslateTransition tt16 = new TranslateTransition(Duration.seconds(.25), hudBarBottom6);
                    tt16.setFromX(10);
                    tt16.setToX(0);
                    tt16.play();
                }
            };

            AnimationTimer hudMoveUp = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    hudBarTop.setTranslateY(-10);
                    hudBarTop1.setTranslateY(-10);
                    hudBarTop2.setTranslateY(-10);
                    hudBarTop3.setTranslateY(-10);
                    hudBarTop4.setTranslateY(-10);
                    hudBarTop5.setTranslateY(-10);
                    hudBarTop6.setTranslateY(-10);
                    hudBarBottom.setTranslateY(-10);
                    hudBarBottom1.setTranslateY(-10);
                    hudBarBottom2.setTranslateY(-10);
                    hudBarBottom3.setTranslateY(-10);
                    hudBarBottom4.setTranslateY(-10);
                    hudBarBottom5.setTranslateY(-10);
                    hudBarBottom6.setTranslateY(-10);

                    bullet1.setTranslateY(-10);
                    bullet2.setTranslateY(-10);
                    bullet3.setTranslateY(-10);
                    bullet4.setTranslateY(-10);
                    bullet5.setTranslateY(-10);
                    bullet6.setTranslateY(-10);
                    bullet7.setTranslateY(-10);
                    bullet8.setTranslateY(-10);
                    bullet9.setTranslateY(-10);
                    bullet10.setTranslateY(-10);
                    bullet11.setTranslateY(-10);
                    bullet12.setTranslateY(-10);

                    bigBullet1.setTranslateY(-10);

                    reload.setTranslateY(-10);

                    TranslateTransition tt = new TranslateTransition(Duration.seconds(.25), hudBarTop);
                    tt.setFromY(-10);
                    tt.setToY(0);
                    tt.setOnFinished(evt -> {
                        stop();
                    });
                    tt.play();
                    TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.25), hudBarTop1);
                    tt1.setFromY(-10);
                    tt1.setToY(0);
                    tt1.play();
                    TranslateTransition tt2 = new TranslateTransition(Duration.seconds(.25), hudBarTop2);
                    tt2.setFromY(-10);
                    tt2.setToY(0);
                    tt2.play();
                    TranslateTransition tt3 = new TranslateTransition(Duration.seconds(.25), hudBarTop3);
                    tt3.setFromY(-10);
                    tt3.setToY(0);
                    tt3.play();
                    TranslateTransition tt4 = new TranslateTransition(Duration.seconds(.25), hudBarTop4);
                    tt4.setFromY(-10);
                    tt4.setToY(0);
                    tt4.play();
                    TranslateTransition tt5 = new TranslateTransition(Duration.seconds(.25), hudBarTop5);
                    tt5.setFromY(-10);
                    tt5.setToY(0);
                    tt5.play();
                    TranslateTransition tt6 = new TranslateTransition(Duration.seconds(.25), hudBarTop6);
                    tt6.setFromY(-10);
                    tt6.setToY(0);
                    tt6.play();
                    TranslateTransition tt7a = new TranslateTransition(Duration.seconds(.25), bullet1);
                    tt7a.setFromY(-10);
                    tt7a.setToY(0);
                    tt7a.play();
                    TranslateTransition tt7b = new TranslateTransition(Duration.seconds(.25), bullet2);
                    tt7b.setFromY(-10);
                    tt7b.setToY(0);
                    tt7b.play();
                    TranslateTransition tt7c = new TranslateTransition(Duration.seconds(.25), bullet3);
                    tt7c.setFromY(-10);
                    tt7c.setToY(0);
                    tt7c.play();
                    TranslateTransition tt7d = new TranslateTransition(Duration.seconds(.25), bullet4);
                    tt7d.setFromY(-10);
                    tt7d.setToY(0);
                    tt7d.play();
                    TranslateTransition tt7e = new TranslateTransition(Duration.seconds(.25), bullet5);
                    tt7e.setFromY(-10);
                    tt7e.setToY(0);
                    tt7e.play();
                    TranslateTransition tt7f = new TranslateTransition(Duration.seconds(.25), bullet6);
                    tt7f.setFromY(-10);
                    tt7f.setToY(0);
                    tt7f.play();
                    TranslateTransition tt7g = new TranslateTransition(Duration.seconds(.25), bullet7);
                    tt7g.setFromY(-10);
                    tt7g.setToY(0);
                    tt7g.play();
                    TranslateTransition tt7h = new TranslateTransition(Duration.seconds(.25), bullet8);
                    tt7h.setFromY(-10);
                    tt7h.setToY(0);
                    tt7h.play();
                    TranslateTransition tt7i = new TranslateTransition(Duration.seconds(.25), bullet9);
                    tt7i.setFromY(-10);
                    tt7i.setToY(0);
                    tt7i.play();
                    TranslateTransition tt7j = new TranslateTransition(Duration.seconds(.25), bullet10);
                    tt7j.setFromY(-10);
                    tt7j.setToY(0);
                    tt7j.play();
                    TranslateTransition tt7k = new TranslateTransition(Duration.seconds(.25), bullet11);
                    tt7k.setFromY(-10);
                    tt7k.setToY(0);
                    tt7k.play();
                    TranslateTransition tt7l = new TranslateTransition(Duration.seconds(.25), bullet12);
                    tt7l.setFromY(-10);
                    tt7l.setToY(0);
                    tt7l.play();
                    TranslateTransition tt8 = new TranslateTransition(Duration.seconds(.25), bigBullet1);
                    tt8.setFromY(-10);
                    tt8.setToY(0);
                    tt8.play();
                    TranslateTransition tt9 = new TranslateTransition(Duration.seconds(.25), reload);
                    tt9.setFromY(-10);
                    tt9.setToY(0);
                    tt9.play();

                    TranslateTransition tt10 = new TranslateTransition(Duration.seconds(.25), hudBarBottom);
                    tt10.setFromY(-10);
                    tt10.setToY(0);
                    tt10.setOnFinished(evt -> {
                        stop();
                    });
                    tt10.play();
                    TranslateTransition tt11 = new TranslateTransition(Duration.seconds(.25), hudBarBottom1);
                    tt11.setFromY(-10);
                    tt11.setToY(0);
                    tt11.play();
                    TranslateTransition tt12 = new TranslateTransition(Duration.seconds(.25), hudBarBottom2);
                    tt12.setFromY(-10);
                    tt12.setToY(0);
                    tt12.play();
                    TranslateTransition tt13 = new TranslateTransition(Duration.seconds(.25), hudBarBottom3);
                    tt13.setFromY(-10);
                    tt13.setToY(0);
                    tt13.play();
                    TranslateTransition tt14 = new TranslateTransition(Duration.seconds(.25), hudBarBottom4);
                    tt14.setFromY(-10);
                    tt14.setToY(0);
                    tt14.play();
                    TranslateTransition tt15 = new TranslateTransition(Duration.seconds(.25), hudBarBottom5);
                    tt15.setFromY(-10);
                    tt15.setToY(0);
                    tt15.play();
                    TranslateTransition tt16 = new TranslateTransition(Duration.seconds(.25), hudBarBottom6);
                    tt16.setFromY(-10);
                    tt16.setToY(0);
                    tt16.play();
                }
            };

            AnimationTimer hudMoveDown = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    hudBarTop.setTranslateY(10);
                    hudBarTop1.setTranslateY(10);
                    hudBarTop2.setTranslateY(10);
                    hudBarTop3.setTranslateY(10);
                    hudBarTop4.setTranslateY(10);
                    hudBarTop5.setTranslateY(10);
                    hudBarTop6.setTranslateY(10);
                    hudBarBottom.setTranslateY(10);
                    hudBarBottom1.setTranslateY(10);
                    hudBarBottom2.setTranslateY(10);
                    hudBarBottom3.setTranslateY(10);
                    hudBarBottom4.setTranslateY(10);
                    hudBarBottom5.setTranslateY(10);
                    hudBarBottom6.setTranslateY(10);

                    bullet1.setTranslateY(10);
                    bullet2.setTranslateY(10);
                    bullet3.setTranslateY(10);
                    bullet4.setTranslateY(10);
                    bullet5.setTranslateY(10);
                    bullet6.setTranslateY(10);
                    bullet7.setTranslateY(10);
                    bullet8.setTranslateY(10);
                    bullet9.setTranslateY(10);
                    bullet10.setTranslateY(10);
                    bullet11.setTranslateY(10);
                    bullet12.setTranslateY(10);

                    bigBullet1.setTranslateY(10);

                    reload.setTranslateY(10);

                    TranslateTransition tt = new TranslateTransition(Duration.seconds(.25), hudBarTop);
                    tt.setFromY(10);
                    tt.setToY(0);
                    tt.setOnFinished(evt -> {
                        stop();
                    });
                    tt.play();
                    TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.25), hudBarTop1);
                    tt1.setFromY(10);
                    tt1.setToY(0);
                    tt1.play();
                    TranslateTransition tt2 = new TranslateTransition(Duration.seconds(.25), hudBarTop2);
                    tt2.setFromY(10);
                    tt2.setToY(0);
                    tt2.play();
                    TranslateTransition tt3 = new TranslateTransition(Duration.seconds(.25), hudBarTop3);
                    tt3.setFromY(10);
                    tt3.setToY(0);
                    tt3.play();
                    TranslateTransition tt4 = new TranslateTransition(Duration.seconds(.25), hudBarTop4);
                    tt4.setFromY(10);
                    tt4.setToY(0);
                    tt4.play();
                    TranslateTransition tt5 = new TranslateTransition(Duration.seconds(.25), hudBarTop5);
                    tt5.setFromY(10);
                    tt5.setToY(0);
                    tt5.play();
                    TranslateTransition tt6 = new TranslateTransition(Duration.seconds(.25), hudBarTop6);
                    tt6.setFromY(10);
                    tt6.setToY(0);
                    tt6.play();
                    TranslateTransition tt7a = new TranslateTransition(Duration.seconds(.25), bullet1);
                    tt7a.setFromY(10);
                    tt7a.setToY(0);
                    tt7a.play();
                    TranslateTransition tt7b = new TranslateTransition(Duration.seconds(.25), bullet2);
                    tt7b.setFromY(10);
                    tt7b.setToY(0);
                    tt7b.play();
                    TranslateTransition tt7c = new TranslateTransition(Duration.seconds(.25), bullet3);
                    tt7c.setFromY(10);
                    tt7c.setToY(0);
                    tt7c.play();
                    TranslateTransition tt7d = new TranslateTransition(Duration.seconds(.25), bullet4);
                    tt7d.setFromY(10);
                    tt7d.setToY(0);
                    tt7d.play();
                    TranslateTransition tt7e = new TranslateTransition(Duration.seconds(.25), bullet5);
                    tt7e.setFromY(10);
                    tt7e.setToY(0);
                    tt7e.play();
                    TranslateTransition tt7f = new TranslateTransition(Duration.seconds(.25), bullet6);
                    tt7f.setFromY(10);
                    tt7f.setToY(0);
                    tt7f.play();
                    TranslateTransition tt7g = new TranslateTransition(Duration.seconds(.25), bullet7);
                    tt7g.setFromY(10);
                    tt7g.setToY(0);
                    tt7g.play();
                    TranslateTransition tt7h = new TranslateTransition(Duration.seconds(.25), bullet8);
                    tt7h.setFromY(10);
                    tt7h.setToY(0);
                    tt7h.play();
                    TranslateTransition tt7i = new TranslateTransition(Duration.seconds(.25), bullet9);
                    tt7i.setFromY(10);
                    tt7i.setToY(0);
                    tt7i.play();
                    TranslateTransition tt7j = new TranslateTransition(Duration.seconds(.25), bullet10);
                    tt7j.setFromY(10);
                    tt7j.setToY(0);
                    tt7j.play();
                    TranslateTransition tt7k = new TranslateTransition(Duration.seconds(.25), bullet11);
                    tt7k.setFromY(10);
                    tt7k.setToY(0);
                    tt7k.play();
                    TranslateTransition tt7l = new TranslateTransition(Duration.seconds(.25), bullet12);
                    tt7l.setFromY(10);
                    tt7l.setToY(0);
                    tt7l.play();
                    TranslateTransition tt8 = new TranslateTransition(Duration.seconds(.25), bigBullet1);
                    tt8.setFromY(10);
                    tt8.setToY(0);
                    tt8.play();
                    TranslateTransition tt9 = new TranslateTransition(Duration.seconds(.25), reload);
                    tt9.setFromY(10);
                    tt9.setToY(0);
                    tt9.play();

                    TranslateTransition tt10 = new TranslateTransition(Duration.seconds(.25), hudBarBottom);
                    tt10.setFromY(10);
                    tt10.setToY(0);
                    tt10.play();
                    TranslateTransition tt11 = new TranslateTransition(Duration.seconds(.25), hudBarBottom1);
                    tt11.setFromY(10);
                    tt11.setToY(0);
                    tt11.play();
                    TranslateTransition tt12 = new TranslateTransition(Duration.seconds(.25), hudBarBottom2);
                    tt12.setFromY(10);
                    tt12.setToY(0);
                    tt12.play();
                    TranslateTransition tt13 = new TranslateTransition(Duration.seconds(.25), hudBarBottom3);
                    tt13.setFromY(10);
                    tt13.setToY(0);
                    tt13.play();
                    TranslateTransition tt14 = new TranslateTransition(Duration.seconds(.25), hudBarBottom4);
                    tt14.setFromY(10);
                    tt14.setToY(0);
                    tt14.play();
                    TranslateTransition tt15 = new TranslateTransition(Duration.seconds(.25), hudBarBottom5);
                    tt15.setFromY(10);
                    tt15.setToY(0);
                    tt15.play();
                    TranslateTransition tt16 = new TranslateTransition(Duration.seconds(.25), hudBarBottom6);
                    tt16.setFromY(10);
                    tt16.setToY(0);
                    tt16.play();
                }
            };

            AnimationTimer MoveAsteroid = new AnimationTimer() {

                @Override
                public void handle(long arg0) {

                    for (Asteroid a : asteroidz) {

                        a.move();
                    }
                }
            };

            AnimationTimer MoveEnemy = new AnimationTimer() {

                @Override
                public void handle(long arg0) {

                    for (Enemy e : enemiez) {

                        e.chase(CoolCat);
                    }
                }
            };

            AnimationTimer moveBGR = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    if (CoolCat.isMovingRight = true) {
                        bgImg.setX(bgImg.getX() - 0.5);
                    }
                }
            };

            AnimationTimer moveBGL = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    if (CoolCat.isMovingLeft = true) {
                        bgImg.setX(bgImg.getX() + 0.5);
                    }
                }
            };

            AnimationTimer moveBGU = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    if (CoolCat.isMovingUp = true) {
                        bgImg.setY(bgImg.getY() - 0.35);
                    }
                }
            };

            AnimationTimer moveBGD = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    if (CoolCat.isMovingDown = true) {
                        bgImg.setY(bgImg.getY() + 0.35);
                    }
                }
            };

            EventHandler<KeyEvent> pressedKey = new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent e) {

                    if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {

                        moveBGL.start();
                        CoolCat.moveLeft();

                        if (CoolCat.getX() == 0) {

                            moveBGL.stop();
                        }

                    } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {

                        moveBGR.start();
                        CoolCat.moveRight();

                        if (CoolCat.getX() == 1055) {

                            moveBGR.stop();
                        }

                    } else if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {

                        moveBGU.start();
                        CoolCat.moveUp();

                        if (CoolCat.getY() == 0) {

                            moveBGU.stop();
                        }

                    } else if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {

                        moveBGD.start();
                        CoolCat.moveDown();

                        if (CoolCat.getY() == 615) {

                            moveBGD.stop();
                        }

                    } else if (e.getCode() == KeyCode.ESCAPE) {

                        System.exit(0);
                    } else if (e.getCode() == KeyCode.SPACE) {

                        if (!CoolCat.pReloading && CoolCat.ammo != 0) {
                            CoolCat.shooting();
                            CoolCat.ammo--;

                            if (CoolCat.ammo == 11) {

                                bullet1.setFill(null);
                            }

                            if (CoolCat.ammo == 10) {

                                bullet2.setFill(null);
                            }

                            if (CoolCat.ammo == 9) {

                                bullet3.setFill(null);
                            }

                            if (CoolCat.ammo == 8) {

                                bullet4.setFill(null);
                            }

                            if (CoolCat.ammo == 7) {

                                bullet5.setFill(null);
                            }

                            if (CoolCat.ammo == 6) {

                                bullet6.setFill(null);
                            }

                            if (CoolCat.ammo == 5) {

                                bullet7.setFill(null);
                            }

                            if (CoolCat.ammo == 4) {

                                bullet8.setFill(null);
                            }

                            if (CoolCat.ammo == 3) {

                                bullet9.setFill(null);
                            }

                            if (CoolCat.ammo == 2) {

                                bullet10.setFill(null);
                            }

                            if (CoolCat.ammo == 1) {

                                bullet11.setFill(null);
                            }

                            if (CoolCat.ammo == 0) {

                                bullet12.setFill(null);
                            }
                        }

                        if (CoolCat.pReloading) {

                            reload.setFill(Color.RED);

                            fadeinout.play();
                        }

                    } else if (e.getCode() == KeyCode.SHIFT || e.getCode() == KeyCode.CONTROL) {

                        CoolCat.explode();
                        bigBullet1.setFill(null);
                    }
                }
            };

            EventHandler<KeyEvent> releasedKey = new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent e) {

                    if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT) {

                        CoolCat.noMove();
                        hudMoveLeft.start();
                        moveBGL.stop();
                    } else if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT) {

                        CoolCat.noMove();
                        hudMoveRight.start();
                        moveBGR.stop();
                    } else if (e.getCode() == KeyCode.W || e.getCode() == KeyCode.UP) {

                        CoolCat.noMove();
                        hudMoveUp.start();
                        moveBGU.stop();
                    } else if (e.getCode() == KeyCode.S || e.getCode() == KeyCode.DOWN) {

                        CoolCat.noMove();
                        hudMoveDown.start();
                        moveBGD.stop();
                    }
                }
            };

            TranslateTransition tt = new TranslateTransition(Duration.seconds(1.5), fadeRectGame);
            tt.setFromX(0);
            tt.setToX(-575);
            tt.setOnFinished(evt -> {

                Text poText = new Text("Power On");
                poText.setFill(Color.RED);
                poText.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 190));
                poText.setTranslateX(115);
                poText.setTranslateY(350);
                rootGame.getChildren().add(poText);

                FadeTransition fadeinoutText = new FadeTransition(Duration.seconds(.5), poText);
                fadeinoutText.setFromValue(1);
                fadeinoutText.setToValue(0.1);
                fadeinoutText.setCycleCount(4);
                fadeinoutText.setAutoReverse(true);
                fadeinoutText.setOnFinished(evt1 -> {

                    rootGame.getChildren().remove(poText);

                    visor.setFill(Color.WHITE);
                    visor.setOpacity(1);

                    scene.setOnKeyPressed(pressedKey);
                    scene.setOnKeyReleased(releasedKey);

                    FadeTransition ft = new FadeTransition(Duration.seconds(1), visor);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt2 -> {

                        playerGame.play();

                        MoveEnemy.start();
                        MoveAsteroid.start();

                        rootGame.getChildren().remove(visor);
                    });
                    ft.play();
                });
                fadeinoutText.play();
            });
            tt.play();

            TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1.5), fadeRect1Game);
            tt2.setFromX(WIDTH / 2);
            tt2.setToX(1175);
            tt2.play();

            AnimationTimer intersections = new AnimationTimer() {
                @Override
                public void handle(long time) {

                    if (CoolCat.pShooting) {
                        CoolCat.bulletMove();
                    }

                    CoolCat.checkBoundsEnemy(enemiez);
                    CoolCat.checkBoundsAstroids(asteroidz);

                    if (CoolCat.health == 0) {

                        FadeTransition dft = new FadeTransition(Duration.seconds(0.5), deathRectGame);
                        dft.setFromValue(0);
                        dft.setToValue(0.7);
                        dft.setOnFinished(evt -> {

                            FadeTransition dftt = new FadeTransition(Duration.seconds(0.25), deathTextGame);
                            dftt.setFromValue(0);
                            dftt.setToValue(1);
                            dftt.setOnFinished(evt1 -> {

//								FadeTransition dfti1 = new FadeTransition(Duration.seconds(0.75), itemRestart);
//								dfti1.setFromValue(0);
//								dfti1.setToValue(1);
//								dfti1.play();
                                FadeTransition dfti2 = new FadeTransition(Duration.seconds(0.75), itemExit);
                                dfti2.setFromValue(0);
                                dfti2.setToValue(1);
                                dfti2.play();
                            });
                            dftt.play();
                        });
                        dft.play();

//						itemRestart.setOnMouseClicked(event -> {
//
//							TranslateTransition tt = new TranslateTransition(Duration.seconds(1.1), fadeRectGame);
//							tt.setFromX(-575);
//							tt.setToX(0);
//							tt.play();
//
//							TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1.1), fadeRect1Game);
//							tt2.setFromX(1175);
//							tt2.setToX(WIDTH / 2);
//							tt2.setOnFinished(evt -> {
//
//								new Game();
//							});
//							tt2.play();
//						});
                        itemExit.setOnMouseClicked(event -> {

                            TranslateTransition tt = new TranslateTransition(Duration.seconds(1.1), fadeRectGame);
                            tt.setFromX(-575);
                            tt.setToX(0);
                            tt.play();

                            TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1.1), fadeRect1Game);
                            tt2.setFromX(1175);
                            tt2.setToX(WIDTH / 2);
                            tt2.setOnFinished(evt -> {

                                System.exit(0);
                            });
                            tt2.play();
                        });

                        scene.setOnKeyPressed(null);
                        scene.setOnKeyReleased(null);

                        CoolCat.noMove();

                        stop();
                        MoveEnemy.stop();
                        moveBGU.stop();
                        moveBGD.stop();
                        moveBGL.stop();
                        moveBGR.stop();

                        rootGame.getChildren().removeAll(CoolCat.shoot);
                    }

                    if (CoolCat.killed >= 7) {

                        TranslateTransition tt = new TranslateTransition(Duration.seconds(1.1), fadeRectGame);
                        tt.setFromX(-575);
                        tt.setToX(0);
                        tt.play();

                        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1.1), fadeRect1Game);
                        tt2.setFromX(1175);
                        tt2.setToX((WIDTH / 2) - 1);
                        tt2.setOnFinished(evt -> {

                            playerGame.stop();

                            endCredits();
                            scene.setRoot(rootWin);
                            rootGame.getChildren().clear();
                        });
                        tt2.play();

                        scene.setOnKeyPressed(null);
                        scene.setOnKeyReleased(null);

                        CoolCat.noMove();

                        stop();
                        MoveEnemy.stop();
                        moveBGU.stop();
                        moveBGD.stop();
                        moveBGL.stop();
                        moveBGR.stop();

                        rootGame.getChildren().removeAll(CoolCat, CoolCat.img, CoolCat.shoot);

                        for (Enemy e : enemiez) {
                            rootGame.getChildren().removeAll(e, e.img);
                        }

                        for (Asteroid a : asteroidz) {

                            rootGame.getChildren().removeAll(a, a.img);
                        }
                    }
                }
            };
            intersections.start();

            rootGame.getChildren().addAll(bgImg, CoolCat.img);

            for (Enemy e : enemiez) {
                rootGame.getChildren().add(e.img);
            }

            for (Asteroid a : asteroidz) {

                rootGame.getChildren().add(a.img);
            }

            rootGame.getChildren().addAll(visor, hudBarTop, hudBarTop1, hudBarTop2, hudBarTop3, hudBarTop4, hudBarTop5,
                    hudBarTop6, hudBarBottom, hudBarBottom1, hudBarBottom2, hudBarBottom3, hudBarBottom4, hudBarBottom5,
                    hudBarBottom6, bigBullet1, bullet1, bullet2, bullet3, bullet4, bullet5, bullet6, bullet7, bullet8,
                    bullet9, bullet10, bullet11, bullet12, reload, deathRectGame, itemExit, deathTextGame, fadeRectGame,
                    fadeRect1Game);
        }

        public void endCredits() {

            playerEnd.setCycleCount(MediaPlayer.INDEFINITE);
            playerEnd.play();

            Rectangle bg = new Rectangle(WIDTH, HEIGHT);
            bg.setFill(Color.BLACK);

            Rectangle fadeRect = new Rectangle(WIDTH, HEIGHT);
            fadeRect.setFill(Color.BLACK);
            fadeRect.setOpacity(0);

            Text text = new Text("Press any key");
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 35));
            text.setFill(Color.DIMGREY);
            text.setTranslateX(10);
            text.setTranslateY(410);
            text.setOpacity(0);

            String endText = "Visual\n" + "\n" + "Made with ScannerChanSystems\n" + "Game by Juan Rivera\n"
                    + "\n" + "\n" + "Script:\n" + "Juan Rivera\n" + "\n" + "\n" + "Design:\n" + "Juan Rivera\n" + "\n"
                    + "\n" + "Artwork:\n" + "Found on google.com\n" + "\n" + "\n" + "Music:\n" + "Sky Fortress\n"
                    + "By Waterflame\n" + "\n" + "Milky Way Redux\n" + "By Bossfight\n" + "\n" + "Telluric\n"
                    + "By Detious\n" + "\n" + "\n" + "Special Thanks To:\n" + "Dr. Don Davis\n" + "\n" + "\n" + "\n"
                    + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Thanks For Playing";

            Text eTL = new Text(endText);
            eTL.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 45));
            eTL.setFill(Color.DIMGREY);
            eTL.setTranslateX(10);
            eTL.setTranslateY(715);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(22), eTL); // 18
            tt.setFromY(715);
            tt.setToY(-2080);
            tt.setOnFinished(evt -> {

                FadeTransition ft = new FadeTransition(Duration.seconds(1), text);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.setOnFinished(evt1 -> {

                    scene.addEventFilter(KeyEvent.ANY, keyEvent -> {

                        FadeTransition ft1 = new FadeTransition(Duration.seconds(1.5), fadeRect);
                        ft1.setFromValue(0);
                        ft1.setToValue(1);
                        ft1.setOnFinished(evt2 -> {

                            System.exit(0);
                        });
                        ft1.play();
                    });
                });
                ft.play();
            });
            tt.play();

            rootWin.getChildren().addAll(bg, text, eTL, fadeRect);
        }
    }

    class Opener {

        public Opener() {

            Image is = new Image("file:src/Resources/b12.gif");

            ImageView img = new ImageView(is);
            img.setFitWidth(125);
            img.setFitHeight(125);
            img.setTranslateX(850);
            img.setTranslateY(255);
            img.setOpacity(0);

            Bloom bloom = new Bloom();
            bloom.setThreshold(0.1);

            Rectangle rect = new Rectangle(WIDTH, HEIGHT);
            rect.setFill(Color.BLACK);

            Text text = new Text("Made with ScannerChanSystems");
            text.setFill(Color.WHITE);
            text.setEffect(bloom);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 45));
            text.setTranslateX(130);
            text.setTranslateY(335);
            text.setOpacity(0);

            FadeTransition fadein = new FadeTransition(Duration.seconds(1.5), text);
            fadein.setFromValue(0);
            fadein.setToValue(1);
            fadein.setCycleCount(2);
            fadein.setAutoReverse(true);
            fadein.setOnFinished(evt -> {

                text.setText("Game by Juan Rivera");
                text.setTranslateX(325);

                FadeTransition fadein1 = new FadeTransition(Duration.seconds(1.5), text);
                fadein1.setFromValue(0);
                fadein1.setToValue(1);
                fadein1.setCycleCount(2);
                fadein1.setAutoReverse(true);
                fadein1.setOnFinished(evt1 -> {

                    new Menu();

                    root.getChildren().removeAll(rect, img, text);
                });
                fadein1.play();
            });
            fadein.play();

            FadeTransition fadein1 = new FadeTransition(Duration.seconds(1.5), img);
            fadein1.setFromValue(0);
            fadein1.setToValue(1);
            fadein1.setCycleCount(2);
            fadein1.setAutoReverse(true);
            fadein1.play();

            root.getChildren().addAll(rect, img, text);
        }
    }

    class Menu {

        public Menu() {

            playerMenu.setCycleCount(MediaPlayer.INDEFINITE);
            playerMenu.play();

            Image is = new Image("file:src/Resources/giphy_1.gif");

            ImageView img = new ImageView(is);
            img.setFitWidth(1100);
            img.setFitHeight(675);

            Text version = new Text("Ver. " + ver);
            version.setFill(Color.WHITE);
            version.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 20));
            version.setStroke(Color.BLACK);
            version.setStrokeWidth(0.5);
            version.setTranslateX(1000);
            version.setTranslateY(650);

            Text tryit = new Text("Recomended!");
            tryit.setFill(Color.WHITE);
            tryit.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 20));
            tryit.setTranslateX(40);
            tryit.setTranslateY(615);
            tryit.setRotate(25);
            tryit.setOpacity(0);

            Rectangle fadeRect = new Rectangle(WIDTH, HEIGHT);
            fadeRect.setFill(Color.BLACK);

            FadeTransition fadeout = new FadeTransition(Duration.seconds(1.5), fadeRect);
            fadeout.setFromValue(1);
            fadeout.setToValue(0);
            fadeout.setOnFinished(evt -> {

                root.getChildren().remove(fadeRect);
            });
            fadeout.play();

            Rectangle bg = new Rectangle(375, 675);
            bg.setFill(Color.WHITE);
            bg.setOpacity(0.1);
            bg.setTranslateX(1100);

            Rectangle hbdr = new Rectangle(50, 20);
            hbdr.setFill(null);
            hbdr.setStroke(Color.WHITE);
            hbdr.setStrokeWidth(2);
            hbdr.setTranslateX(10);
            hbdr.setTranslateY(650);
            hbdr.setOpacity(0);

            Title title = new Title("V I S U A L");
            title.setTranslateY(45);

//			Title jtitle = new Title("�ｿｽr  �ｿｽV  �ｿｽ�ｿｽ  �ｿｽA  �ｿｽ�ｿｽ");
//			jtitle.setTranslateY(45);
            MenuItem itemStart = new MenuItem("NEW GAME");
            itemStart.setTranslateX(1100);
            itemStart.setTranslateY(175);
            itemStart.setOpacity(0);

            MenuItemDark contBtn = new MenuItemDark("CONTINUE");
            contBtn.setTranslateX(1100);
            contBtn.setTranslateY(250);
            contBtn.setOpacity(0);

            MenuItemDark itemOptions = new MenuItemDark("OPTIONS");
            itemOptions.setTranslateX(1100);
            itemOptions.setTranslateY(325);
            itemOptions.setOpacity(0);

            MenuItem itemExit = new MenuItem("EXIT");
            itemExit.setTranslateX(1100);
            itemExit.setTranslateY(400);
            itemExit.setOpacity(0);

            HelpButton helpBtn = new HelpButton("HELP");
            helpBtn.setTranslateX(10);
            helpBtn.setTranslateY(650);
            helpBtn.setOpacity(0);

            Rectangle fullScrn = new Rectangle(WIDTH, HEIGHT);
            fullScrn.setFill(Color.BLACK);
            fullScrn.setVisible(false);

            FadeTransition ft = new FadeTransition(Duration.seconds(.75), title);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setOnFinished(evt -> {
                FadeTransition ft1 = new FadeTransition(Duration.seconds(.3), itemStart);
                ft1.setFromValue(0);
                ft1.setToValue(1);
                ft1.setOnFinished(evt1 -> {
                    FadeTransition ft2 = new FadeTransition(Duration.seconds(.3), contBtn);
                    ft2.setFromValue(0);
                    ft2.setToValue(1);
                    ft2.setOnFinished(evt2 -> {
                        FadeTransition ft3 = new FadeTransition(Duration.seconds(.3), itemOptions);
                        ft3.setFromValue(0);
                        ft3.setToValue(1);
                        ft3.setOnFinished(evt3 -> {
                            FadeTransition ft4 = new FadeTransition(Duration.seconds(.3), itemExit);
                            ft4.setFromValue(0);
                            ft4.setToValue(1);
                            ft4.play();
                        });
                        ft3.play();
                    });
                    ft2.play();
                });
                ft1.play();
            });
            ft.play();

            TranslateTransition tt5 = new TranslateTransition(Duration.seconds(1), bg);
            tt5.setFromX(1100);
            tt5.setToX(725);
            tt5.play();

            TranslateTransition tt = new TranslateTransition(Duration.seconds(1), title);
            tt.setFromX(-100);
            tt.setToX(110);
            tt.setOnFinished(evt -> {
                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.3), itemStart);
                tt1.setFromX(1100);
                tt1.setToX(815);
                tt1.setOnFinished(evt1 -> {
                    TranslateTransition tt2 = new TranslateTransition(Duration.seconds(.3), contBtn);
                    tt2.setFromX(1100);
                    tt2.setToX(815);
                    tt2.setOnFinished(evt2 -> {
                        TranslateTransition tt3 = new TranslateTransition(Duration.seconds(.3), itemOptions);
                        tt3.setFromX(1100);
                        tt3.setToX(815);
                        tt3.setOnFinished(evt3 -> {
                            TranslateTransition tt4 = new TranslateTransition(Duration.seconds(.3), itemExit);
                            tt4.setFromX(1100);
                            tt4.setToX(815);
                            tt4.setOnFinished(evt4 -> {
                                FadeTransition ft5 = new FadeTransition(Duration.seconds(.3), helpBtn);
                                ft5.setFromValue(0);
                                ft5.setToValue(1);
                                ft5.play();

                                FadeTransition it = new FadeTransition(Duration.seconds(1), tryit);
                                it.setFromValue(0);
                                it.setToValue(1);
                                it.setAutoReverse(true);
                                it.setCycleCount(Animation.INDEFINITE);
                                it.play();

                                FadeTransition ft6 = new FadeTransition(Duration.seconds(.3), hbdr);
                                ft6.setFromValue(0);
                                ft6.setToValue(1);
                                ft6.play();
                            });
                            tt4.play();
                        });
                        tt3.play();
                    });
                    tt2.play();
                });
                tt1.play();
            });
            tt.play();

            itemExit.setOnMouseClicked(event -> {

                fullScrn.setFill(Color.WHITE);

                FadeTransition ft7 = new FadeTransition(Duration.seconds(1.5), fullScrn);
                ft7.setFromValue(0);
                ft7.setToValue(1);
                fullScrn.setVisible(true);
                ft7.setOnFinished(evt4 -> {
                    System.exit(0);
                });
                ft7.play();
            });

            itemOptions.setOnMouseClicked(
                    event -> System.out.println("Not yet supported in this version of the game! Ver. " + ver));

            helpBtn.setOnMouseClicked(event -> {

                FadeTransition ft15 = new FadeTransition(Duration.seconds(.5), bg);
                ft15.setFromValue(0.1);
                ft15.setToValue(0);
                ft15.play();

                FadeTransition ft7 = new FadeTransition(Duration.seconds(.5), title);
                ft7.setFromValue(1);
                ft7.setToValue(0);
                ft7.play();

                FadeTransition ft8 = new FadeTransition(Duration.seconds(.5), itemStart);
                ft8.setFromValue(1);
                ft8.setToValue(0);
                ft8.play();

                FadeTransition ft9 = new FadeTransition(Duration.seconds(.5), contBtn);
                ft9.setFromValue(1);
                ft9.setToValue(0);
                ft9.play();

                FadeTransition ft10 = new FadeTransition(Duration.seconds(.5), itemOptions);
                ft10.setFromValue(1);
                ft10.setToValue(0);
                ft10.play();

                FadeTransition ft11 = new FadeTransition(Duration.seconds(.5), itemExit);
                ft11.setFromValue(1);
                ft11.setToValue(0);
                ft11.play();

                FadeTransition ft12 = new FadeTransition(Duration.seconds(.5), helpBtn);
                ft12.setFromValue(1);
                ft12.setToValue(0);
                ft12.play();

                FadeTransition ft13 = new FadeTransition(Duration.seconds(.5), tryit);
                ft13.setFromValue(1);
                ft13.setToValue(0);
                ft13.setOnFinished(evt -> tryit.setVisible(false));
                ft13.play();

                FadeTransition ft14 = new FadeTransition(Duration.seconds(.5), hbdr);
                ft14.setFromValue(1);
                ft14.setToValue(0);
                ft14.setOnFinished(evt1 -> {

                    Text help = new Text("Controls:");
                    help.setFill(Color.WHITE);
                    help.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 60));
                    help.setTranslateX(450);
                    help.setTranslateY(90);
                    help.setOpacity(0);

                    String hlpText
                            = "1) Use WASD or Arrow Keys to move\n"
                            + "\n"
                            + "2) Press Space to shoot\n"
                            + "\n"
                            + "3) Press Shift or Ctrl to Explode\n"
                            + "\n"
                            + "4) Don't die";

                    Text hTL = new Text(hlpText);
                    hTL.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 35));
                    hTL.setFill(Color.WHITE);
                    hTL.setTranslateX(270);
                    hTL.setTranslateY(200);
                    hTL.setOpacity(0);

                    MenuItemBack itemBack = new MenuItemBack("Back");
                    itemBack.setTranslateX(15);
                    itemBack.setTranslateY(20);
                    itemBack.setOpacity(0);

                    FadeTransition ft16 = new FadeTransition(Duration.seconds(.5), help);
                    ft16.setFromValue(0);
                    ft16.setToValue(1);
                    ft16.setOnFinished(evt -> root.getChildren().removeAll(bg, tryit, title, itemStart, itemOptions, itemExit, contBtn,
                            helpBtn, hbdr, fullScrn));
                    ft16.play();

                    FadeTransition ft17 = new FadeTransition(Duration.seconds(.5), hTL);
                    ft17.setFromValue(0);
                    ft17.setToValue(1);
                    ft17.play();

                    FadeTransition ft18 = new FadeTransition(Duration.seconds(.5), itemBack);
                    ft18.setFromValue(0);
                    ft18.setToValue(1);
                    ft18.play();

                    root.getChildren().addAll(help, hTL, itemBack);

                    itemBack.setOnMouseClicked(event1 -> {

                        FadeTransition ft161 = new FadeTransition(Duration.seconds(.5), help);
                        ft161.setFromValue(1);
                        ft161.setToValue(0);
                        ft161.setOnFinished(evt -> root.getChildren().removeAll(help, hTL, itemBack));
                        ft161.play();

                        FadeTransition ft171 = new FadeTransition(Duration.seconds(.5), hTL);
                        ft171.setFromValue(1);
                        ft171.setToValue(0);
                        ft171.play();

                        FadeTransition ft181 = new FadeTransition(Duration.seconds(.5), itemBack);
                        ft181.setFromValue(1);
                        ft181.setToValue(0);
                        ft181.setOnFinished(evt100 -> {

                            FadeTransition ft151 = new FadeTransition(Duration.seconds(.5), bg);
                            ft151.setFromValue(0);
                            ft151.setToValue(0.1);
                            ft151.play();

                            FadeTransition ft71 = new FadeTransition(Duration.seconds(.5), title);
                            ft71.setFromValue(0);
                            ft71.setToValue(1);
                            ft71.play();

                            FadeTransition ft81 = new FadeTransition(Duration.seconds(.5), itemStart);
                            ft81.setFromValue(0);
                            ft81.setToValue(1);
                            ft81.play();

                            FadeTransition ft91 = new FadeTransition(Duration.seconds(.5), contBtn);
                            ft91.setFromValue(0);
                            ft91.setToValue(1);
                            ft91.play();

                            FadeTransition ft101 = new FadeTransition(Duration.seconds(.5), itemOptions);
                            ft101.setFromValue(0);
                            ft101.setToValue(1);
                            ft101.play();

                            FadeTransition ft111 = new FadeTransition(Duration.seconds(.5), itemExit);
                            ft111.setFromValue(0);
                            ft111.setToValue(1);
                            ft111.play();

                            FadeTransition ft121 = new FadeTransition(Duration.seconds(.5), helpBtn);
                            ft121.setFromValue(0);
                            ft121.setToValue(1);
                            ft121.play();

                            FadeTransition ft131 = new FadeTransition(Duration.seconds(.5), tryit);
                            ft131.setFromValue(0);
                            ft131.setToValue(1);
                            ft131.setOnFinished(evt -> tryit.setVisible(true));
                            ft131.play();

                            FadeTransition ft141 = new FadeTransition(Duration.seconds(.5), hbdr);
                            ft141.setFromValue(0);
                            ft141.setToValue(1);
                            ft141.play();
                        });
                        ft181.play();

                        root.getChildren().addAll(bg, tryit, title, itemStart, itemOptions, itemExit, contBtn,
                                helpBtn, hbdr, fullScrn);
                    });
                });
                ft14.play();
            });

            contBtn.setOnMouseClicked(
                    event -> System.out.println("Not yet supported in this version of the game! Ver. " + ver));

            itemStart.setOnMouseClicked(event -> {

                FadeTransition ft8 = new FadeTransition(Duration.seconds(2.5), fullScrn);
                ft8.setFromValue(0);
                ft8.setToValue(1);
                fullScrn.setVisible(true);

                ft8.setOnFinished(evt5 -> {
                    playerMenu.stop();
                    new TimeScreen();
                    root.getChildren().removeAll(img, bg, tryit, title, itemStart, itemOptions, itemExit, contBtn,
                            helpBtn, hbdr, version, fullScrn, fadeRect);
                });
                ft8.play();

                TranslateTransition tt11 = new TranslateTransition(Duration.seconds(2), bg);
                tt11.setFromX(725);
                tt11.setToX(1100);
                tt11.play();

                TranslateTransition tt6 = new TranslateTransition(Duration.seconds(2), title);
                tt6.setFromX(110);
                tt6.setToX(-510);
                tt6.play();

                TranslateTransition tt7 = new TranslateTransition(Duration.seconds(2), itemExit);
                tt7.setFromX(815);
                tt7.setToX(1100);
                tt7.play();

                TranslateTransition tt8 = new TranslateTransition(Duration.seconds(2), itemOptions);
                tt8.setFromX(815);
                tt8.setToX(1100);
                tt8.play();

                TranslateTransition tt9 = new TranslateTransition(Duration.seconds(2), contBtn);
                tt9.setFromX(828);
                tt9.setToX(1100);
                tt9.play();

                TranslateTransition tt10 = new TranslateTransition(Duration.seconds(2), itemStart);
                tt10.setFromX(815);
                tt10.setToX(1100);
                tt10.play();

                TranslateTransition tt12 = new TranslateTransition(Duration.seconds(2), helpBtn);
                tt12.setFromX(10);
                tt12.setToX(-100);
                tt12.play();

                TranslateTransition tt14 = new TranslateTransition(Duration.seconds(2), tryit);
                tt14.setFromX(10);
                tt14.setToX(-100);
                tt14.play();

                TranslateTransition tt13 = new TranslateTransition(Duration.seconds(2), hbdr);
                tt13.setFromX(10);
                tt13.setToX(-100);
                tt13.play();
            });
            root.getChildren().addAll(img, bg, tryit, title, itemStart, itemOptions, itemExit, contBtn, helpBtn, hbdr,
                    version, fullScrn, fadeRect);
        }
    }

    class TimeScreen {

        int chapter = 0;

        public String[] datez = new String[10];
        public String[] locationz = new String[10];
        public String[] warz = new String[10];

        public TimeScreen() {

            datez[0] = "2010";

            locationz[0] = "New Earth";

            warz[0] = "Attack of the Something";

            Rectangle rect = new Rectangle(1100, 675);
            rect.setFill(Color.BLACK);

            Text date = new Text(datez[0]);
            date.setFill(Color.BLACK);
            date.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 30));
            date.setTranslateX(520);
            date.setTranslateY(295);
            date.setOpacity(0);

            Text location = new Text(locationz[0]);
            location.setFill(Color.BLACK);
            location.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 30));
            location.setTranslateX(484);
            location.setTranslateY(335);
            location.setOpacity(0);

            Text war = new Text(warz[0]);
            war.setFill(Color.BLACK);
            war.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 30));
            war.setTranslateX(395);
            war.setTranslateY(380);
            war.setOpacity(0);

            FadeTransition fadein = new FadeTransition(Duration.seconds(1), date);
            fadein.setFromValue(0);
            fadein.setToValue(1);
            date.setFill(Color.WHITE);
            fadein.setOnFinished(evt -> {

                FadeTransition fadein1 = new FadeTransition(Duration.seconds(1), location);
                fadein1.setFromValue(0);
                fadein1.setToValue(1);
                location.setFill(Color.WHITE);
                fadein1.setOnFinished(evt1 -> {

                    FadeTransition fadein2 = new FadeTransition(Duration.seconds(1), war);
                    fadein2.setFromValue(0);
                    fadein2.setToValue(1);
                    war.setFill(Color.WHITE);
                    fadein2.setOnFinished(evt2 -> {

                        FadeTransition fadeout1 = new FadeTransition(Duration.seconds(.75), date);
                        fadeout1.setFromValue(1);
                        fadeout1.setToValue(0);
                        fadeout1.setOnFinished(evt3 -> {

                            FadeTransition fadeout2 = new FadeTransition(Duration.seconds(.75), location);
                            fadeout2.setFromValue(1);
                            fadeout2.setToValue(0);
                            fadeout2.setOnFinished(evt4 -> {

                                FadeTransition fadeout3 = new FadeTransition(Duration.seconds(.75), war);
                                fadeout3.setFromValue(1);
                                fadeout3.setToValue(0);
                                fadeout3.setOnFinished(evt5 -> {

                                    scene.setRoot(rootGame);
                                    new Game();
                                    root.getChildren().clear();

                                    root.getChildren().removeAll(rect, date, location, war);
                                });
                                fadeout3.play();
                            });
                            fadeout2.play();
                        });
                        fadeout1.play();
                    });
                    fadein2.play();
                });
                fadein1.play();
            });
            fadein.play();
            root.getChildren().addAll(rect, date, location, war);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    class Player extends Rectangle {

        boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight = false;
        boolean setRight = true;
        boolean setLeft = false;
        boolean collisionDetected, collisionDetectedShoot = false;
        boolean isDead = false;
        boolean pShooting, pReloading = false;
        boolean detonated = false;

        int health = 10;
        int killed = 0;
        int ammo = 12;

        Rectangle shoot = new Rectangle(20, 5);
        Rectangle timerHit = new Rectangle(-100, -100, 20, 5);
        Rectangle timerHit1 = new Rectangle(-100, -100, 20, 5);
        Rectangle timerExplode = new Rectangle(-100, -100, 20, 5);
        Circle boom = new Circle(15);

        Image pic1 = new Image("file:src/Resources/sprites1_air_right.gif");
        Image pic2 = new Image("file:src/Resources/sprites1_air_left.gif");
        Image up1 = new Image("file:src/Resources/sprites1_up_right.gif");
        Image up2 = new Image("file:src/Resources/sprites1_up_left.gif");
        Image down1 = new Image("file:src/Resources/sprites1_down_right.gif");
        Image down2 = new Image("file:src/Resources/sprites1_down_left.gif");
        Image right = new Image("file:src/Resources/sprites1_right.gif");
        Image left = new Image("file:src/Resources/sprites1_left.gif");

        ImageView img = new ImageView(this.pic1);

        public Player(double x, double y) {

            super(x, y, 45, 60);

            this.shoot.setArcWidth(10.0);
            this.shoot.setArcHeight(30.0);
            this.shoot.setFill(Color.ALICEBLUE);
            this.shoot.setStroke(Color.TOMATO);
            this.shoot.setStrokeWidth(1.5);
            this.shoot.setX(this.getX() + 28);
            this.shoot.setY(this.getY() + 8);

            this.boom.setCenterX(this.getX() + 22);
            this.boom.setCenterY(this.getY() + 25);
            this.boom.setFill(Color.LIGHTBLUE);
            this.boom.setStroke(Color.TEAL);
            this.boom.setStrokeWidth(4);

            this.img.setFitWidth(75);
            this.img.setFitHeight(83);
            this.img.setX(x - 15);
            this.img.setY(y - 12);

            this.setArcWidth(30.0);
            this.setArcHeight(30.0);
        }

        private void moveUp() {

            if (this.setRight) {
                this.img.setImage(this.up1);
            } else {
                this.img.setImage(this.up2);
            }

            if (this.getY() > 0) {
                this.setY(this.getY() - 5);

                if (!this.detonated) {
                    this.boom.setTranslateY(this.getY() - 325);
                }
            } else {
                this.setDown();
            }

            this.img.setX(this.getX() - 15);
            this.img.setY(this.getY() - 12);
        }

        private void moveDown() {

            if (this.setRight) {
                this.img.setImage(this.down1);
            } else {
                this.img.setImage(this.down2);
            }

            if (this.getY() < 615) {
                this.setY(this.getY() + 5);

                if (!this.detonated) {
                    this.boom.setTranslateY(this.getY() - 325);
                }
            } else {
                this.setUp();
            }
            this.img.setX(this.getX() - 15);
            this.img.setY(this.getY() - 12);
        }

        private void moveLeft() {

            this.img.setImage(this.left);

            this.setLeft = true;
            this.setRight = false;

            if (this.getX() > 0) {
                this.setX(this.getX() - 5);

                if (!this.detonated) {
                    this.boom.setTranslateX(this.getX() - 100);
                }
            } else {
                this.setRight();
            }
            this.img.setX(this.getX() - 15);
            this.img.setY(this.getY() - 12);
        }

        private void moveRight() {

            this.img.setImage(this.right);

            this.setLeft = false;
            this.setRight = true;

            if (this.getX() < 1055) {
                this.setX(this.getX() + 5);

                if (!this.detonated) {
                    this.boom.setTranslateX(this.getX() - 100);
                }
            } else {
                this.setLeft();
            }
            this.img.setX(this.getX() - 15);
            this.img.setY(this.getY() - 12);
        }

        private void noMove() {

            if (this.setRight) {
                this.img.setImage(this.pic1);
            } else {
                this.img.setImage(this.pic2);
            }

            this.isMovingUp = false;
            this.isMovingDown = false;
            this.isMovingLeft = false;
            this.isMovingRight = false;
        }

        private void setUp() {

            this.isMovingUp = true;
            this.isMovingDown = false;
            this.isMovingLeft = false;
            this.isMovingRight = false;
        }

        private void setDown() {

            this.isMovingUp = false;
            this.isMovingDown = true;
            this.isMovingLeft = false;
            this.isMovingRight = false;
        }

        private void setLeft() {

            this.isMovingUp = false;
            this.isMovingDown = false;
            this.isMovingLeft = true;
            this.isMovingRight = false;
        }

        private void setRight() {

            this.isMovingUp = false;
            this.isMovingDown = false;
            this.isMovingLeft = false;
            this.isMovingRight = true;
        }

        private void explode() {

            if (!detonated) {

                explodeSound.play();

                this.boom.setRadius(100);

                FadeTransition ft1 = new FadeTransition(Duration.seconds(.9), this.timerExplode);
                ft1.setFromValue(1);
                ft1.setToValue(0);
                ft1.setOnFinished(evt -> {

                    explodeSound.stop();
                });
                ft1.play();

                FadeTransition ft = new FadeTransition(Duration.seconds(1), this.boom);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(evt -> {

                    this.detonated = true;
                    this.boom.setRadius(10);
                    rootGame.getChildren().remove(this.boom);
                });
                ft.play();

                rootGame.getChildren().add(this.boom);
            }
        }

        private void bulletMove() {

            if (this.setRight) {
                this.shoot.setX(this.shoot.getX() + 15);
            } else if (this.setLeft) {
                this.shoot.setX(this.shoot.getX() - 15);
            }
        }

        private void shooting() {

            shootSound.play();

            this.pShooting = true;
            this.pReloading = true;

            if (setRight) {
                this.shoot.setX(this.getX() + 28);
                this.shoot.setY(this.getY() + 8);
            } else {
                this.shoot.setX(this.getX() - 5);
                this.shoot.setY(this.getY() + 8);
            }

            FadeTransition ft = new FadeTransition(Duration.seconds(1), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> {

                shootSound.stop();
                this.pShooting = false;
                rootGame.getChildren().remove(this.shoot);
            });
            ft.play();

            RotateTransition rt = new RotateTransition(Duration.seconds(3), this);
            rt.setFromAngle(0);
            rt.setToAngle(360);
            rt.setOnFinished(evt -> {

                this.pReloading = false;
            });
            rt.play();

            rootGame.getChildren().add(this.shoot);
        }

        private void checkBoundsAstroids(ArrayList<Asteroid> asteroidz) {

            for (Asteroid a : asteroidz) {

                if (this.getBoundsInParent().intersects(a.getBoundsInParent())) {
                    this.collisionDetected = true;
                    this.isDead = true;

                    asteroidz.remove(a);
                    rootGame.getChildren().removeAll(a, a.img);
                }
            }

            if (isDead) {
                this.health = 0;
                rootGame.getChildren().removeAll(this, this.img);
            }
        }

        private void checkBoundsEnemy(ArrayList<Enemy> enemies) {

            for (Enemy e : enemies) {

                if (this.getBoundsInParent().intersects(e.getBoundsInParent())) {
                    this.collisionDetected = true;
                    this.isDead = true;

                } else if (this.shoot.getBoundsInParent().intersects(e.getBoundsInParent())) {
                    hitSound.play();
                    this.collisionDetectedShoot = true;
                    this.killed++;

                    FadeTransition ft = new FadeTransition(Duration.seconds(.2), this.timerHit);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt -> {

                        hitSound.stop();
                    });
                    ft.play();

                    enemies.remove(e);
                    rootGame.getChildren().removeAll(e, e.img);
                } else if (this.boom.getBoundsInParent().intersects(e.getBoundsInParent())) {
                    hitSound.play();
                    this.killed++;

                    FadeTransition ft = new FadeTransition(Duration.seconds(.2), this.timerHit1);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt -> {

                        hitSound.stop();
                    });
                    ft.play();

                    enemies.remove(e);
                    rootGame.getChildren().removeAll(e, e.img);
                }
            }

            if (isDead) {
                this.health = 0;
                rootGame.getChildren().removeAll(this, this.img);
            }
        }
    }

    class Enemy extends Rectangle {

        boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight;

        Image i = new Image("file:src/Resources/Enemy.gif");
        ImageView img = new ImageView(this.i);

        double randX = Math.random() * 2;
        double randY = Math.random();

        public Enemy(double x, double y) {

            super(x, y, 30, 30);

            this.img.setFitWidth(95);
            this.img.setFitHeight(95);
            this.img.setX(x - 25);
            this.img.setY(y - 30);
        }

        private void moveUp() {

            if (this.getY() > 0) {
                this.setY(this.getY() - this.randY);
            } else {
                this.setDown();
            }

            this.img.setX(this.getX() - 25);
            this.img.setY(this.getY() - 30);
        }

        private void moveDown() {

            if (this.getY() < 645) {
                this.setY(this.getY() + this.randY);
            } else {
                this.setUp();
            }

            this.img.setX(this.getX() - 25);
            this.img.setY(this.getY() - 30);
        }

        private void moveLeft() {

            if (this.getX() > 0) {
                this.setX(this.getX() - this.randX);
            } else {
                this.setRight();
            }

            this.img.setX(this.getX() - 25);
            this.img.setY(this.getY() - 30);
        }

        private void moveRight() {

            if (this.getX() < 1070) {
                this.setX(this.getX() + this.randX);
            } else {
                this.setLeft();
            }

            this.img.setX(this.getX() - 25);
            this.img.setY(this.getY() - 30);
        }

        private void chase(Player p) {

            if (p.getX() < this.getX()) {

                this.moveLeft();
            }

            if (p.getX() > this.getX()) {

                this.moveRight();
            }

            if (p.getY() < this.getY() && (this.getX() - 100) < p.getX()
                    || p.getY() < this.getY() && (this.getX() + 100) < p.getX()) {

                this.moveUp();
            }

            if (p.getY() > this.getY() && (this.getX() - 100) < p.getX()
                    || p.getY() > this.getY() && (this.getX() + 100) < p.getX()) {

                this.moveDown();
            }
        }

        private void setUp() {

            this.isMovingUp = true;
            this.isMovingDown = false;
            this.isMovingLeft = false;
            this.isMovingRight = false;
        }

        private void setDown() {

            this.isMovingUp = false;
            this.isMovingDown = true;
            this.isMovingLeft = false;
            isMovingRight = false;
        }

        private void setLeft() {

            this.isMovingUp = false;
            this.isMovingDown = false;
            this.isMovingLeft = true;
            this.isMovingRight = false;
        }

        private void setRight() {

            this.isMovingUp = false;
            this.isMovingDown = false;
            this.isMovingLeft = false;
            this.isMovingRight = true;
        }
    }

    class Asteroid extends Rectangle {

        Image i = new Image("file:src/Resources/Asteroid-PNG-Transparent.png");
        ImageView img = new ImageView(this.i);

        double rand = Math.random() * 10;

        public Asteroid(double x, double y) {

            super(x, y, 35, 35);

            this.img.setFitWidth(47); // 95
            this.img.setFitHeight(49); // 95
            this.img.setX(x - 7);
            this.img.setY(y - 7);
        }

        public void move() {

            this.setX(this.getX() - this.rand);
            this.img.setX(this.getX() - 7);

            if (this.getX() < 0) {

                this.setY(Math.random() * 675);
                this.img.setY(this.getY() - 10);

                this.setX(1110);
                this.img.setX(this.getX() - 7);

            }
        }
    }

    class Title extends StackPane {

        public Title(String name) {

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 85));

            setAlignment(Pos.CENTER);
            getChildren().addAll(text);
        }
    }

    class MenuItem extends StackPane {

        public MenuItem(String name) {

            Rectangle rect = new Rectangle(225, 2);
            rect.setStroke(Color.GREY);
            rect.setFill(Color.WHITE);
            rect.setStrokeWidth(1);
            rect.setTranslateY(20);
            rect.setOpacity(0);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 40));

            Glow glow = new Glow();
            glow.setLevel(1);

            setAlignment(Pos.CENTER);
            getChildren().addAll(text, rect);

            setOnMouseEntered(event -> {

                text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 45));
                text.setEffect(glow);

                rect.setWidth(245);
                rect.setEffect(glow);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(.15), text);
                tt.getFromX();
                tt.setToX(-25);
                tt.getFromY();
                tt.setToY(-5);
                tt.play();

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.15), rect);
                tt1.getFromX();
                tt1.setToX(-25);
                tt1.play();

                FadeTransition ft = new FadeTransition(Duration.seconds(.09), rect);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
            });

            setOnMouseExited(event -> {

                text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 40));
                text.setEffect(null);

                rect.setWidth(225);
                rect.setEffect(null);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(.15), text);
                tt.getFromX();
                tt.setToX(0);
                tt.getFromY();
                tt.setToY(0);
                tt.play();

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.15), rect);
                tt1.getFromX();
                tt1.setToX(0);
                tt1.play();

                FadeTransition ft = new FadeTransition(Duration.seconds(.15), rect);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
            });

            setOnMousePressed(event -> {

                text.setFill(Color.DARKRED);
            });

            setOnMouseReleased(event -> {

                text.setFill(Color.WHITE);
            });
        }
    }

    class MenuItemBack extends StackPane {

        public MenuItemBack(String name) {

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 40));

            Glow glow = new Glow();
            glow.setLevel(1);

            setAlignment(Pos.CENTER);
            getChildren().add(text);

            setOnMouseEntered(event -> {

                text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 45));
                text.setEffect(glow);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(.15), text);
                tt.getFromX();
                tt.setToX(-10);
                tt.getFromY();
                tt.setToY(-5);
                tt.play();
            });

            setOnMouseExited(event -> {

                text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 40));
                text.setEffect(null);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(.15), text);
                tt.getFromX();
                tt.setToX(0);
                tt.getFromY();
                tt.setToY(0);
                tt.play();
            });

            setOnMousePressed(event -> {

                text.setFill(Color.DARKRED);
            });

            setOnMouseReleased(event -> {

                text.setFill(Color.WHITE);
            });
        }
    }

    class MenuItemDark extends StackPane {

        public MenuItemDark(String name) {

            Rectangle rect = new Rectangle(225, 2);
            rect.setStroke(Color.GREY);
            rect.setFill(Color.WHITE);
            rect.setStrokeWidth(1);
            rect.setTranslateY(20);
            rect.setOpacity(0);

            Text text = new Text(name);
            text.setFill(Color.GREY);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 40));

            Glow glow = new Glow();
            glow.setLevel(0.5);

            getChildren().addAll(text, rect);

            setOnMouseEntered(event -> {

                text.setFill(Color.DARKGREY);
                text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 45));
                text.setEffect(glow);

                rect.setWidth(245);
                rect.setEffect(glow);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(.15), text);
                tt.getFromX();
                tt.setToX(-25);
                tt.getFromY();
                tt.setToY(-5);
                tt.play();

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.15), rect);
                tt1.getFromX();
                tt1.setToX(-25);
                tt1.play();

                FadeTransition ft = new FadeTransition(Duration.seconds(.15), rect);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
            });

            setOnMouseExited(event -> {

                text.setFill(Color.GREY);
                text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 40));
                text.setEffect(null);

                rect.setWidth(225);
                rect.setEffect(null);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(.15), text);
                tt.getFromX();
                tt.setToX(0);
                tt.getFromY();
                tt.setToY(0);
                tt.play();

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.15), rect);
                tt1.getFromX();
                tt1.setToX(0);
                tt1.play();

                FadeTransition ft = new FadeTransition(Duration.seconds(.15), rect);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();
            });
        }
    }

    class HelpButton extends StackPane {

        public HelpButton(String name) {

            Rectangle bg = new Rectangle(50, 20);
            bg.setFill(Color.WHITE);
            bg.setOpacity(0.2);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 12));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {

                text.setFill(Color.DARKGREY);
            });

            setOnMouseExited(event -> {

                text.setFill(Color.WHITE);
            });

            setOnMousePressed(event -> {

                bg.setFill(Color.PINK);
            });

            setOnMouseReleased(event -> {

                bg.setFill(Color.WHITE);
            });
        }
    }

    class DeathScreenItem extends StackPane {

        public DeathScreenItem(String name) {

            Rectangle rect = new Rectangle(7, 7);
            rect.setStroke(Color.GREY);
            rect.setFill(Color.WHITE);
            rect.setStrokeWidth(1);
            rect.setTranslateX(-90);
            rect.setOpacity(0);

            Rectangle rect1 = new Rectangle(7, 7);
            rect1.setStroke(Color.GREY);
            rect1.setFill(Color.WHITE);
            rect1.setStrokeWidth(1);
            rect1.setTranslateX(90);
            rect1.setOpacity(0);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 40));

            Glow glow = new Glow();
            glow.setLevel(1);

            setAlignment(Pos.CENTER);
            getChildren().addAll(text, rect, rect1);

            setOnMouseEntered(event -> {

                text.setEffect(glow);

                rect.setEffect(glow);
                rect1.setEffect(glow);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.15), text);
                tt1.getFromY();
                tt1.setToY(-5);
                tt1.play();

                FadeTransition ft = new FadeTransition(Duration.seconds(.09), rect);
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();

                FadeTransition ft1 = new FadeTransition(Duration.seconds(.09), rect1);
                ft1.setFromValue(0);
                ft1.setToValue(1);
                ft1.play();
            });

            setOnMouseExited(event -> {

                text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 40));
                text.setEffect(null);

                rect.setEffect(null);
                rect1.setEffect(null);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(.15), text);
                tt1.getFromY();
                tt1.setToY(0);
                tt1.play();

                FadeTransition ft = new FadeTransition(Duration.seconds(.15), rect);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.play();

                FadeTransition ft1 = new FadeTransition(Duration.seconds(.15), rect1);
                ft1.setFromValue(1);
                ft1.setToValue(0);
                ft1.play();
            });

            setOnMousePressed(event -> {

                text.setFill(Color.DARKRED);
            });

            setOnMouseReleased(event -> {

                text.setFill(Color.WHITE);
            });
        }
    }
}
