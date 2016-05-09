package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Use this class when there is a need for the sprite to be animated
 *
 * Created by Cliff on 5/3/2016.
 */
public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCountW;
//    private int frameCountH;
    private int frame;

    public Animation(TextureRegion region, int frameCountW, int frameCountH, float cycleTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCountW;
//        int frameHeight = region.getRegionHeight() / frameCountH;
        for (int i = 0; i < frameCountH; i++) {
            for(int j = 0; j < frameCountW; j++){
//                frames.add(new TextureRegion(region,i*frameWidth,0,j*frameWidth,region.getRegionHeight()));
                  frames.add(new TextureRegion(region,i*frameWidth,0,j*frameWidth,region.getRegionHeight()));
            }
        }
        this.frameCountW = frameCountW;
        maxFrameTime = cycleTime/frameCountW;
        frame = 0;
    }
    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime>maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCountW){
            frame = 0;
        }

    }
    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}

