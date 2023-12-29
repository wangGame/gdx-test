package kw.learn.gutils;

import com.badlogic.gdx.graphics.GL20;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/29 13:34
 */
public enum ShapeType {
    Point(GL20.GL_POINTS), Line(GL20.GL_LINES), Filled(GL20.GL_TRIANGLES);

    private final int glType;

    ShapeType (int glType) {
        this.glType = glType;
    }

    public int getGlType () {
        return glType;
    }
}
