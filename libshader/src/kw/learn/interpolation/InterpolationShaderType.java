package kw.learn.interpolation;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/30 12:02
 */
public enum InterpolationShaderType {
    EXPOSE(0),
    POW2INVERTSE(1),
    LINEAR(2),
    SMOOTH(3),
    LIGHT(4);
    private int index;

    private InterpolationShaderType(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }
}
