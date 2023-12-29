package kw.learn.gutils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer;
import com.badlogic.gdx.math.Matrix4;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/29 13:20
 */
public abstract class BaseImmediateModeRenderer implements ImmediateModeRenderer {

    @Override
    public void begin(Matrix4 matrix4, int i) {

    }

    @Override
    public void flush() {

    }

    @Override
    public void color(Color color) {

    }

    @Override
    public void color(float v, float v1, float v2, float v3) {

    }

    @Override
    public void color(float v) {

    }

    @Override
    public void texCoord(float v, float v1) {

    }

    @Override
    public void normal(float v, float v1, float v2) {

    }

    @Override
    public void vertex(float v, float v1, float v2) {

    }

    @Override
    public void end() {

    }

    @Override
    public int getNumVertices() {
        return 0;
    }

    @Override
    public int getMaxVertices() {
        return 0;
    }

    @Override
    public void dispose() {

    }
}