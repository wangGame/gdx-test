#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;

float smoothmathod(float a){
    a = a * a * a * (3 - 2 * a);
    return a * a * (3 - 2 * a);
}

void main() {
    vec4 textureColor = texture2D(u_texture,
                                  v_textCoords)*v_color;
    float a = v_textCoords.x;
    float ss = 1.0 - smoothmathod(a) - 0.01;
    float f = step(ss, v_textCoords.y) -
                step(ss+0.01, v_textCoords.y);
    gl_FragColor = vec4(f,f,f,textureColor.a);
}