package com.codingblocks.jeteater.scene;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by sridhar123 on 30/9/17.
 */

public class HUD {

    public Stage stage;
    int life=3;
    int time=100;
    int score=0;
    private StretchViewport viewport;
    private OrthographicCamera hudCamera;

    Label.LabelStyle style =new Label.LabelStyle(new BitmapFont(), Color.WHITE);

    Label scoreVal = new Label("0",style);
    Label lifeVal = new Label("3 - 3",style);
    Label timeVal = new Label("100",style);


    public HUD() {
        stage = new Stage();
        hudCamera=new OrthographicCamera(stage.getWidth(),stage.getHeight());
        viewport = new StretchViewport(stage.getWidth(),stage.getHeight(),hudCamera);

        Table table=  new Table();

        Label scoreTitle = new Label("Score",style);
        Label lifeTitle = new Label("Life",style);
        Label timeTitle = new Label("Time",style);

        table.setFillParent(true);

        table.top();
        table.add(scoreTitle).expandX();
        table.add(lifeTitle).expandX();
        table.add(timeTitle).expandX();

        table.row();
        table.add(scoreVal).expandX();
        table.add(lifeVal).expandX();
        table.add(timeVal).expandX();

        stage.addActor(table);
    }

    public void addScore(int i) {
        score  =score +10;
        scoreVal.setText(java.lang.String.format("%d",score));
    }

    public void kill() {
        life=life-1;
        lifeVal.setText(java.lang.String.format("%d - 3",life));
    }

    public void timer(){
        time=time-1;
        timeVal.setText(java.lang.String.format("%d",time));
    }
}
