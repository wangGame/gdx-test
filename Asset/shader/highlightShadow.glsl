#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float exposure;
vec3 luminanceWeighting = vec3(0.3, 0.3, 0.3);

uniform float highlights;

void main() {
    vec4 source = v_color* texture2D(u_texture,v_textCoords);

    float shadows = 1.0;

    float luminance = dot(source.rgb, luminanceWeighting);
    float shadow = clamp((pow(luminance, 1.0/(shadows+1.0)) +
            (-0.76)*pow(luminance, 2.0/(shadows+1.0))) - luminance, 0.0, 1.0);
    float highlight = clamp((1.0 - (pow(1.0-luminance, 1.0/(2.0-highlights)) + (-0.8)*pow(1.0-luminance, 2.0/(2.0-highlights)))) - luminance, -1.0, 0.0);
 	vec3 result = vec3(0.0, 0.0, 0.0) + ((luminance + shadow + highlight) - 0.0) *
    ((source.rgb - vec3(0.0, 0.0, 0.0))/(luminance - 0.0));
    gl_FragColor = vec4(result.rgb, source.a);



}