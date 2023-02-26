#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;


float linear(float a){
    return a;
}

void main() {
    vec4 textureColor = texture2D(u_texture,
                                  v_textCoords)*v_color;
    float a = v_textCoords.x;


    //    float ss = powmathod(a,pww);
    float ss = 1.0 - linear(a) - 0.01;


    float f = step(ss, v_textCoords.y) -
    step(ss+0.01, v_textCoords.y);
    gl_FragColor = vec4(f,f,f,textureColor.a);
}