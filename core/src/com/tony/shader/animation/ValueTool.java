package com.tony.shader.animation;

import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;

/**
 * @Auther jian xian si qi
 * @Date 2023/8/23 16:15
 */

public class ValueTool extends TemporalAction {
    private float start;
    private float end;
    private float value;
    public void setStart(float start) {
        this.start = start;
    }

    public void setEnd(float end) {
        this.end = end;
    }

    @Override
    protected void update(float v) {
        float v1 = end - start;
        value = v1 * v;
        if (end>start){
            if (value < start) {
                value = start;
            }
        }else {
            if (value > start) {
                value = start;
            }
        }
    }

    public float getValue() {
        return value;
    }
}
