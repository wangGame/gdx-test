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

    float thresholdResult = step(threshold, luminance);
    if(thresholdResult <=0.0){
        gl_FragColor = textureColor;
    }else{
        discard;
    }
}