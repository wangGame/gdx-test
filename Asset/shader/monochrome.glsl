#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float intensity;

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);
    vec3 filterColor = vec3(0.6f, 0.45f, 0.3f);
//    " 	lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n" +
    float luminance = dot(textureColor.rgb, luminanceWeighting);
    vec4 desat = vec4(vec3(luminance), 1.0);
    vec4 outputColor = vec4(
        (desat.r < 0.5 ? (2.0 * desat.r * filterColor.r) : (1.0 - 2.0 * (1.0 - desat.r) * (1.0 - filterColor.r))),
        (desat.g < 0.5 ? (2.0 * desat.g * filterColor.g) : (1.0 - 2.0 * (1.0 - desat.g) * (1.0 - filterColor.g))),
        (desat.b < 0.5 ? (2.0 * desat.b * filterColor.b) : (1.0 - 2.0 * (1.0 - desat.b) * (1.0 - filterColor.b))),
        1.0);
    gl_FragColor = vec4( mix(textureColor.rgb, outputColor.rgb, abs(6*sin(intensity))), textureColor.a);

//    gl_FragColor = textureColor;
}


