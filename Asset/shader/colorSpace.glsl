#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform  float intensity;
void main() {
    vec2 sampleDivisor = vec2(1.0 / 200.0, 1.0 / 320.0);
    vec2 samplePos = v_textCoords - mod(v_textCoords, sampleDivisor);
    vec4 color = v_color* texture2D(u_texture,v_textCoords);
    vec4 colorCyan = vec4(85.0 / 255.0, 1.0, 1.0, 1.0);
    vec4 colorMagenta = vec4(1.0, 85.0 / 255.0, 1.0, 1.0);
    vec4 colorWhite = vec4(1.0, 1.0, 1.0, 1.0);
    vec4 colorBlack = vec4(0.0, 0.0, 0.0, 1.0);
    
    vec4 endColor;
    float blackDistance = distance(color, colorBlack);
    float whiteDistance = distance(color, colorWhite);
    float magentaDistance = distance(color, colorMagenta);
    float cyanDistance = distance(color, colorCyan);
    
    vec4 finalColor;
    
    float colorDistance = min(magentaDistance, cyanDistance);
    colorDistance = min(colorDistance, whiteDistance);
    colorDistance = min(colorDistance, blackDistance); 
    
    if (colorDistance == blackDistance) {
        finalColor = colorBlack;
    } else if (colorDistance == whiteDistance) {
        finalColor = colorWhite;
    } else if (colorDistance == cyanDistance) {
        finalColor = colorCyan;
    } else {
        finalColor = colorMagenta;
    }
    
    gl_FragColor = finalColor;
}
