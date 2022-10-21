#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;


        
void main() {
    vec3 colorToReplace = vec3(0.0,1.0,0.0);
    float thresholdSensitivity = 0.4;
    float smoothing = 0.1;

    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 textureColor2 = v_color* texture2D(u_texture1,v_textCoords);

    float maskY = 0.2989 * colorToReplace.r + 0.5866 * colorToReplace.g + 0.1145 * colorToReplace.b;
    float maskCr = 0.7132 * (colorToReplace.r - maskY);
    float maskCb = 0.5647 * (colorToReplace.b - maskY);
    
    float Y = 0.2989 * textureColor.r + 0.5866 * textureColor.g + 0.1145 * textureColor.b;
    float Cr = 0.7132 * (textureColor.r - Y);
    float Cb = 0.5647 * (textureColor.b - Y);
    
    float blendValue = 1.0 - smoothstep(thresholdSensitivity, thresholdSensitivity + smoothing, distance(vec2(Cr, Cb), vec2(maskCr, maskCb)));
    gl_FragColor = mix(textureColor, textureColor2, blendValue);

}
