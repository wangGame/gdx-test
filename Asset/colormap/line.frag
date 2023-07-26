#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;
uniform float v;
uniform float v1;
uniform float u;
uniform float u1;

void main() {
    vec4 pic = v_color * texture2D(u_texture, v_textCoords);
    // 红色
    vec3 color1 = vec3(1.0f, 0.0f, 0.0f);
    // 蓝色
    vec3 color2 = vec3(0.0f, 0.0f, 1.0f);
    // 插值因子，取0.5表示取两者之间的中间色
    float t = (pic.r + pic.g + pic.b)/3.0f;
    // 计算过渡颜色
    vec3 interpolatedColor = mix(color1, color2, t);

    gl_FragColor=vec4(interpolatedColor.rgb,pic.a);

}