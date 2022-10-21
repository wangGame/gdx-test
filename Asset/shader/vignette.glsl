#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
//uniform vec2 vignetteCenter;
//uniform vec3 vignetteColor;
//uniform  float vignetteStart;
//uniform  float vignetteEnd;

void main() {
    float vignetteStart = 0.2;
    float vignetteEnd = 0.4;

    if (v_textCoords.x > 0.5) {
        vec2 vignetteCenter = vec2(0.5,0.5);
        vec3 vignetteColor = vec3(0.0,1.0,1.0);
        vec3 rgb = texture2D(u_texture, v_textCoords).rgb;
        float d = distance(v_textCoords, vec2(vignetteCenter.x,
                                                   vignetteCenter.y));
        float percent = smoothstep(vignetteStart, vignetteEnd, d);
        gl_FragColor = vec4(mix(rgb.x, vignetteColor.x, percent),
                            mix(rgb.y, vignetteColor.y, percent),
                            mix(rgb.z, vignetteColor.z, percent), 1.0);
    } else {

        vec4 source = v_color * texture2D(u_texture, v_textCoords);
        float d = distance(v_textCoords, vec2(0.5, 0.5));
        source *= (1-smoothstep(vignetteStart, vignetteEnd, d));
        gl_FragColor = vec4(vec3(source), 1.0);
    }
}