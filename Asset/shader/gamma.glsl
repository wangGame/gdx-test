#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float gamma;


void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);

    if(gamma >= 0.8){
        gamma = 0.8;
    }
    gamma = 1.0 - gamma;
    gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);
}