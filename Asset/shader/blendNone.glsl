#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;

void main() {
    vec4 c2 = v_color* texture2D(u_texture,v_textCoords);
    vec4 c1 = v_color* texture2D(u_texture1,v_textCoords);
    vec4 outputColor;
    outputColor.r = c1.r + c2.r * c2.a * (1.0 - c1.a);
    outputColor.g = c1.g + c2.g * c2.a * (1.0 - c1.a);
    outputColor.b = c1.b + c2.b * c2.a * (1.0 - c1.a);
    outputColor.a = c1.a + c2.a * (1.0 - c1.a);
    gl_FragColor = outputColor;
}
