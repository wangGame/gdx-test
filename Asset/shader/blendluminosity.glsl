#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;


float lum(vec3 c) {
    return dot(c, vec3(0.3, 0.59, 0.11));
}

vec3 clipcolor(vec3 c) {
    float l = lum(c);
    float n = min(min(c.r, c.g), c.b);
    float x = max(max(c.r, c.g), c.b);
    
    if (n < 0.0) {
        c.r = l + ((c.r - l) * l) / (l - n);
        c.g = l + ((c.g - l) * l) / (l - n);
        c.b = l + ((c.b - l) * l) / (l - n);
    }
    if (x > 1.0) {
        c.r = l + ((c.r - l) * (1.0 - l)) / (x - l);
        c.g = l + ((c.g - l) * (1.0 - l)) / (x - l);
        c.b = l + ((c.b - l) * (1.0 - l)) / (x - l);
    }
    
    return c;
}

vec3 setlum(vec3 c, float l) {
    float d = l - lum(c);
    c = c + vec3(d);
    return clipcolor(c);
}

void main() {
    vec4 baseColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 overlayColor = v_color* texture2D(u_texture1,v_textCoords);
    gl_FragColor = vec4(baseColor.rgb * (1.0 - overlayColor.a) + 
    setlum(baseColor.rgb, lum(overlayColor.rgb)) * overlayColor.a, baseColor.a);
}
