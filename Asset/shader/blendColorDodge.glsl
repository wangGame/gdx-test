#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;

void main() {
    vec4 base = v_color* texture2D(u_texture,v_textCoords);
    vec4 overlay = v_color* texture2D(u_texture1,v_textCoords);
    vec3 baseOverlayAlphaProduct = vec3(overlay.a * base.a);
    vec3 rightHandProduct = overlay.rgb * (1.0 - base.a) + base.rgb * (1.0 - overlay.a);
    vec3 firstBlendColor = baseOverlayAlphaProduct + rightHandProduct;
    vec3 overlayRGB = clamp((overlay.rgb / clamp(overlay.a, 0.01, 1.0)) * step(0.0, overlay.a), 0.0, 0.99);
    vec3 secondBlendColor = (base.rgb * overlay.a) / (1.0 - overlayRGB) + rightHandProduct;
    vec3 colorChoice = step((overlay.rgb * base.a + base.rgb * overlay.a), baseOverlayAlphaProduct);
    gl_FragColor = vec4(mix(firstBlendColor, secondBlendColor, colorChoice), 1.0);
}