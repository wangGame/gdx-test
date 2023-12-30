package kw.learn.gutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Disposable;

import kw.learn.interpolation.InterpolationShaderType;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/29 13:32
 */
public class ShapeShaderRenderer implements Disposable {
    private final ShaderModeRenderer2001 renderer;
    private boolean matrixDirty;
    private final Matrix4 projectionMatrix = new Matrix4();
    private final Matrix4 transformMatrix = new Matrix4();
    private final Matrix4 combinedMatrix = new Matrix4();
    private final Color color = new Color(1, 1, 1, 1);
    private ShapeType shapeType;

    public ShapeShaderRenderer () {
        this(5000);
    }

    public ShapeShaderRenderer (int maxVertices) {
        renderer = new ShaderModeRenderer2001(maxVertices, false, false, 0);
        projectionMatrix.setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        matrixDirty = true;
    }

    public void setColor (Color color) {
        this.color.set(color);
    }

    public Color getColor () {
        return color;
    }

    /** Sets the projection matrix to be used for rendering. Usually this will be set to {@link Camera#combined}.
     * @param matrix */
    public void setProjectionMatrix (Matrix4 matrix) {
        projectionMatrix.set(matrix);
        matrixDirty = true;
    }

    public void setTransformMatrix (Matrix4 matrix) {
        transformMatrix.set(matrix);
        matrixDirty = true;
    }

    public void begin () {
        begin(ShapeType.Filled);
    }

    public void begin (ShapeType type) {
        if (shapeType != null) throw new IllegalStateException("Call end() before beginning a new shape batch.");
        shapeType = type;
        if (matrixDirty) {
            combinedMatrix.set(projectionMatrix);
            Matrix4.mul(combinedMatrix.val, transformMatrix.val);
            matrixDirty = false;
        }
        renderer.begin(combinedMatrix, shapeType.getGlType());
    }

    public void set (ShapeType type) {
        if (shapeType == type) return;
        if (shapeType == null) throw new IllegalStateException("begin must be called first.");
        end();
        begin(type);
    }

    /** Draws a rectangle in the x/y plane using {@link ShapeType#Line} or {@link ShapeType#Filled}. */
    public void rect (float x, float y, float width, float height) {
        check(ShapeType.Line, ShapeType.Filled, 8);
        float colorBits = color.toFloatBits();
        if (shapeType == ShapeType.Line) {
            renderer.color(colorBits);
            renderer.vertex(x, y, 0);
            renderer.color(colorBits);
            renderer.vertex(x + width, y, 0);

            renderer.color(colorBits);
            renderer.vertex(x + width, y, 0);
            renderer.color(colorBits);
            renderer.vertex(x + width, y + height, 0);

            renderer.color(colorBits);
            renderer.vertex(x + width, y + height, 0);
            renderer.color(colorBits);
            renderer.vertex(x, y + height, 0);

            renderer.color(colorBits);
            renderer.vertex(x, y + height, 0);
            renderer.color(colorBits);
            renderer.vertex(x, y, 0);
        } else {
            renderer.color(colorBits);
            renderer.vertex(x, y, 0);
            renderer.color(colorBits);
            renderer.vertex(x + width, y, 0);
            renderer.color(colorBits);
            renderer.vertex(x + width, y + height, 0);

            renderer.color(colorBits);
            renderer.vertex(x + width, y + height, 0);
            renderer.color(colorBits);
            renderer.vertex(x, y + height, 0);
            renderer.color(colorBits);
            renderer.vertex(x, y, 0);
        }
    }

    /** @param other May be null. */
    private void check (ShapeType preferred, ShapeType other, int newVertices) {
        if (shapeType == null) throw new IllegalStateException("begin must be called first.");
        if (shapeType != preferred && shapeType != other) {
            // Shape type is not valid.
            end();
            begin(preferred);
        } else if (matrixDirty) {
            // Matrix has been changed.
            ShapeType type = shapeType;
            end();
            begin(type);
        } else if (renderer.getMaxVertices() - renderer.getNumVertices() < newVertices) {
            // Not enough space.
            ShapeType type = shapeType;
            end();
            begin(type);
        }
    }

    public void end () {
        renderer.end();
        shapeType = null;
    }

    public void dispose () {
        renderer.dispose();
    }

    public void setShaderType(InterpolationShaderType type) {
        renderer.setShaderType(type);
    }

    public void setUniform(String width, float width1) {
        renderer.setUnform(width,width1);
    }

    public void addUserArgs(float w,float h) {
        renderer.addUserArgs(new Runnable() {
            @Override
            public void run() {
                setUniform("width",w);
                setUniform("height",h);
                setUniform("offsetXY",100);
            }
        });
    }
}
