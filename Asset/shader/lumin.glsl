#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

uniform float threshold;
const vec3 W = vec3(0.2125, 0.7154, 0.0721);
void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    float luminance = dot(textureColor.rgb, W);

    float thresholdResult = step(sin(threshold+0.1), luminance);
    if(thresholdResult <=0.1){
        gl_FragColor = textureColor;
    }else{
        gl_FragColor = vec4(vec3(thresholdResult), 0);
    }
}