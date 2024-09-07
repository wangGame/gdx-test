precision mediump float;
 
uniform sampler2D u_texture;
varying vec2 vTexCoord;
varying vec4 vColor;
vec3 rgb2hsl(vec3 c) {
    vec3 hsl;

    float minVal = min(c.r, min(c.g, c.b));
    float maxVal = max(c.r, max(c.g, c.b));
    float delta = maxVal - minVal;

    hsl.z = (maxVal + minVal) / 2.0;

    if (delta < 0.00001) {
        hsl.x = 0.0;
        hsl.y = 0.0;
    } else {
        if (hsl.z < 0.5) {
            hsl.y = delta / (maxVal + minVal);
        } else {
            hsl.y = delta / (2.0 - maxVal - minVal);
        }

        if (c.r == maxVal) {
            hsl.x = (c.g - c.b) / delta;
        } else if (c.g == maxVal) {
            hsl.x = 2.0 + (c.b - c.r) / delta;
        } else {
            hsl.x = 4.0 + (c.r - c.g) / delta;
        }

        hsl.x *= 60.0;
        if (hsl.x < 0.0) {
            hsl.x += 360.0;
        }
    }

    return hsl;
}

vec3 hsl2rgb(vec3 c) {
    float c_ = (1.0 - abs(2.0 * c.z - 1.0)) * c.y;
    float x = c_ * (1.0 - abs(mod(c.x / 60.0, 2.0) - 1.0));
    float m = c.z - c_ / 2.0;

    vec3 rgb;
    if (c.x < 60.0) {
        rgb = vec3(c_, x, 0.0);
    } else if (c.x < 120.0) {
        rgb = vec3(x, c_, 0.0);
    } else if (c.x < 180.0) {
        rgb = vec3(0.0, c_, x);
    } else if (c.x < 240.0) {
        rgb = vec3(0.0, x, c_);
    } else if (c.x < 300.0) {
        rgb = vec3(x, 0.0, c_);
    } else {
        rgb = vec3(c_, 0.0, x);
    }

    return rgb + m;
}

void main(){
    vec4 colortemp = vColor * texture2D(u_texture, vTexCoord);
    vec3 hsl = rgb2hsl(colortemp.rgb);
    hsl.z = clamp(hsl.z + 0.1, 0.0, 1.0);
    vec3 rgb = hsl2rgb(hsl);
    gl_FragColor = vec4(rgb.r,rgb.g,rgb.b,colortemp.a);
}

