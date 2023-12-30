package kw.learn.gutils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;

import kw.learn.interpolation.InterpolationShaderType;
import kw.learn.interpolation.ShaderProgramUtils;

/**
 * @Auther jian xian si qi
 * @Date 2023/6/28 15:19
 */
public class ShaderModeRenderer2001 extends BaseImmediateModeRenderer {
    private int primitiveType;
    private int vertexIdx;
    private final int maxVertices;
    private int numVertices;
    private final Mesh mesh;
    private ShaderProgram shader;
    private final int vertexSize;
    private final int colorOffset;
    private final Matrix4 projModelView = new Matrix4();
    private final float[] vertices;

    public ShaderModeRenderer2001(int maxVertices, boolean hasNormals, boolean hasColors, int numTexCoords) {
        this(maxVertices,createDefaultShader(hasNormals, hasColors, numTexCoords));
    }

    public ShaderModeRenderer2001(int maxVertices, ShaderProgram shader) {
        this.maxVertices = maxVertices;
        this.shader = shader;
        VertexAttribute[] attribs = buildVertexAttributes();
        mesh = new Mesh(false, maxVertices, 0, attribs);
        vertices = new float[maxVertices * (mesh.getVertexAttributes().vertexSize / 4)];
        vertexSize = mesh.getVertexAttributes().vertexSize / 4;
        colorOffset = mesh.getVertexAttribute(VertexAttributes.Usage.ColorPacked) != null ? mesh.getVertexAttribute(VertexAttributes.Usage.ColorPacked).offset / 4 : 0;
    }

    private VertexAttribute[] buildVertexAttributes () {
        Array<VertexAttribute> attribs = new Array<VertexAttribute>();
        attribs.add(new VertexAttribute(VertexAttributes.Usage.Position, 3, ShaderProgram.POSITION_ATTRIBUTE));
        attribs.add(new VertexAttribute(VertexAttributes.Usage.TextureCoordinates, 2, "a_texCoord"));
        VertexAttribute[] array = new VertexAttribute[attribs.size];
        for (int i = 0; i < attribs.size; i++) {
            array[i] = attribs.get(i);
        }
        return array;
    }

    public void begin (Matrix4 projModelView, int primitiveType) {
        this.projModelView.set(projModelView);
        this.primitiveType = primitiveType;
    }

    public void color (Color color) {
        vertices[vertexIdx + colorOffset] = color.toFloatBits();
    }

    public void color (float r, float g, float b, float a) {
        vertices[vertexIdx + colorOffset] = Color.toFloatBits(r, g, b, a);
    }

    public void color (float colorBits) {
        vertices[vertexIdx + colorOffset] = colorBits;
    }

    public void vertex (float x, float y, float z) {
        final int idx = vertexIdx;
        vertices[idx] = x;
        vertices[idx + 1] = y;
        vertices[idx + 2] = z;

        texCoord(x,y);
        vertexIdx += vertexSize;
        numVertices++;
    }

    public void flush () {
        if (numVertices == 0) return;
        shader.begin();
        shader.setUniformMatrix("u_projModelView", projModelView);
        if (addUserArgs!=null) {
            addUserArgs.run();
        }
        mesh.setVertices(vertices, 0, vertexIdx);
        mesh.render(shader, primitiveType);
        shader.end();
        vertexIdx = 0;
        numVertices = 0;
    }

    private Runnable addUserArgs;
    public void addUserArgs(Runnable runnable) {
        this.addUserArgs = runnable;
    }

    public void end () {
        flush();
    }

    public int getNumVertices () {
        return numVertices;
    }

    @Override
    public int getMaxVertices () {
        return maxVertices;
    }

    public void dispose () {
        mesh.dispose();
    }

    @Override
    public void setShaderType(InterpolationShaderType type) {
        shader = ShaderProgramUtils.getInstance().createShaderProgram(type);
    }

    @Override
    public void setUnform(String width, float width1) {
        shader.setUniformf(width,width1);
    }

    static private String createVertexShader (boolean hasNormals, boolean hasColors, int numTexCoords) {
        //attribute vec4 a_position;
        String shader = "attribute vec4 " + ShaderProgram.POSITION_ATTRIBUTE+";\n";
        //uniform mat4 u_projModelView
        shader += "uniform mat4 u_projModelView;\n";
        //      void main()
        shader += "void main() { \n" +
                "   gl_Position = u_projModelView * " + ShaderProgram.POSITION_ATTRIBUTE + ";\n";
        shader += "   gl_PointSize = 1.0;\n";
        shader += "}\n";
        return shader;
    }

    static private String createFragmentShader () {
        String shader = "#ifdef GL_ES\n" + "precision mediump float;\n" + "#endif\n";
        shader += "void main() {\n" + "   gl_FragColor = " +  "vec4(1, 1, 1, 1)";
        shader += ";\n}";
        return shader;
    }

    static public ShaderProgram createDefaultShader (boolean hasNormals, boolean hasColors, int numTexCoords) {
        String vertexShader = createVertexShader(hasNormals, hasColors, numTexCoords);
        String fragmentShader = createFragmentShader();
        ShaderProgram program = new ShaderProgram(vertexShader, fragmentShader);
        return program;
    }
}