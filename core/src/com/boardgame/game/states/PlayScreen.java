package com.boardgame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.MyGdxGame;
import com.boardgame.game.sprites.TileMap;
import com.boardgame.game.states.GameStateManager;
import com.boardgame.game.states.State;

/**
 * Created by Cliff on 5/6/2016.
 */
public class PlayScreen extends State {

    private MainBoard mb;
   int x=0;
    int y=0;
    public PlayScreen(GameStateManager gsm){
        super(gsm);
        mb = new MainBoard(6 ,10);
        cam.setToOrtho(false, MyGdxGame.WIDTH/4, MyGdxGame.HEIGHT/2);

    }
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
           x++;
           cam.position.x +=10;
           cam.update();

        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        //for loop for main board tiles
        for(int i = 0; i < mb.getXSize(); i ++){
            for(int j = 0; j < mb.getYSize(); j++){
                sb.draw(mb.getSpaceAt(i,j).getTextures() ,i*74,j*74);
            }
        }
        sb.end();
        cam.update();
    }

    @Override
    public void dispose() {

    }
}