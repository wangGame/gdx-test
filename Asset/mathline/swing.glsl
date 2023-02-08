#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;

float smoothmathod(float a){
    float scale = 1.5f;
    if (a <= 0.5f) {
        a *= 2;
        return a * a * ((scale + 1) * a - scale) / 2;
    }
    a--;
    a *= 2;
    return a * a * ((scale + 1) * a + scale) / 2 + 1;
}

void main() {
    v_textCoords.y = v_textCoords.y * 1.2 - 0.1f;
    vec4 textureColor = texture2D(u_texture,
                                  v_textCoords)*v_color;
    float a = v_textCoords.x;
    float ss = 1.0-smoothmathod(a)-0.005;
    float f = step(ss, v_textCoords.y) -
    step(ss+0.01, v_textCoords.y);
    gl_FragColor = vec4(f,f,f,textureColor.a);
}