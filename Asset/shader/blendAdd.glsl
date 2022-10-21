#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;

//叠加
void main() {
    vec4 base = v_color* texture2D(u_texture, v_textCoords);
    vec4 overlay = v_color* texture2D(u_texture1, v_textCoords);


    float r;
    if (overlay.r * base.a + base.r * overlay.a >= overlay.a * base.a) {
        r = overlay.a * base.a + overlay.r * (1.0 - base.a) + base.r * (1.0 - overlay.a);
    } else {
        r = overlay.r + base.r;
    }

    float g;
    if (overlay.g * base.a + base.g * overlay.a >= overlay.a * base.a) {
        g = overlay.a * base.a + overlay.g * (1.0 - base.a) + base.g * (1.0 - overlay.a);
    } else {
        g = overlay.g + base.g;
    }

    float b;
    if (overlay.b * base.a + base.b * overlay.a >= overlay.a * base.a) {
        b = overlay.a * base.a + overlay.b * (1.0 - base.a) + base.b * (1.0 - overlay.a);
    } else {
        b = overlay.b + base.b;
    }

    float a = overlay.a + base.a - overlay.a * base.a;

    gl_FragColor = vec4(r, g, b, a);
}
