#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float contrast;
vec3 W = vec3(0.2125, 0.7154, 0.0721);

void main() {
    vec4 textureColor = v_color*texture2D(u_texture,v_textCoords);
    float luminance = dot(textureColor.rgb, W);
    float a = luminance;
    a = a * (5.0 - 2.7 * contrast);
    gl_FragColor = vec4(vec3(a),1);
}
