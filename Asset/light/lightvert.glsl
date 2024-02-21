attribute vec4 a_position;
uniform mat4 u_projModelView;
varying vec2 v_tex;

void main() {
    gl_Position = u_projModelView * a_position;
    v_tex = a_position.xy;
    gl_PointSize = 1.0;
}