#ifdef GL_ES
precision mediump float;
#endif

//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;

// 贝塞尔曲线函数
vec2 cubicBezier(vec2 t, vec2 p0, vec2 p1, vec2 p2, vec2 p3) {
    vec2 u = 1.0 - t;
    vec2 tt = t * t;
    vec2 uu = u * u;
    vec2 uuu = uu * u;
    vec2 ttt = tt * t;

    vec2 p = uuu * p0;
    p += 3.0 * uu * t * p1;
    p += 3.0 * u * tt * p2;
    p += ttt * p3;

    return p;
}

void main() {
//    vec2 controlPoint1 = vec2(0.8,0.1+time);
//    vec2 controlPoint2 = vec2(0.5,0.4);
    // 使用贝塞尔曲线计算变形后的纹理坐标
//    vec2 deformedUV = cubicBezier(v_textCoords, vec2(0.0), controlPoint1, controlPoint2, vec2(100.0));

    // 在变形后的纹理坐标处采样纹理
    vec4 bottomColor = v_color * texture2D(u_texture, v_textCoords);
    gl_FragColor = vec4(1.0f,1.0f,1.0f,bottomColor.a);
}