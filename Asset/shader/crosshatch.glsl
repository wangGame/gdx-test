#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
const vec3 W = vec3(0.2125,0.7154,0.0721);

void main() {

    float crossHatchSpacing = 0.03;
    float lineWidth = 0.003;

//    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    float luminance = dot(texture2D(u_texture, v_textCoords).rgb, W);
     vec4 colorToDisplay = vec4(1.0, 1.0, 1.0, 1.0);
    if (luminance < 1.00) {
        if (mod(v_textCoords.x + v_textCoords.y, crossHatchSpacing) <= lineWidth) {
            colorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);
        }
    }
    if (luminance < 0.75) {
        if (mod(v_textCoords.x - v_textCoords.y, crossHatchSpacing) <= lineWidth) {
            colorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);
        }
    }
    if (luminance < 0.50) {
        if (mod(v_textCoords.x + v_textCoords.y - (crossHatchSpacing / 2.0), crossHatchSpacing) <= lineWidth) {
            colorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);
        }
    }
    if (luminance < 0.3) {
        if (mod(v_textCoords.x - v_textCoords.y - (crossHatchSpacing / 2.0), crossHatchSpacing) <= lineWidth) {
            colorToDisplay = vec4(0.0, 0.0, 0.0, 1.0);
        }
    }
    gl_FragColor = colorToDisplay;
}
