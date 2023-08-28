#version 100

void main() {
    vec3 col1 = vec3(0.5,0.0,1.0);
    vec3 col2 = vec3(1.0,0.4,0.0);
    vec2 dir = normalize(vec2(1.0,1.0));
    float interpolationExp = 3.0;

    vec2 Rotate(vec2 v, float theta)
    {
        float s = sin(theta);
        float c = cos(theta);

        return vec2(v.x * c - v.y * s, v.x * s + v.y * c);
    }

    void mainImage( out vec4 fragColor, in vec2 fragCoord )
    {
        vec2 uv = fragCoord/iResolution.xy;
        col1 *= texture(iChannel0,uv).xyz;
        col2 *= texture(iChannel1,uv).xyz;

        dir = Rotate(dir,iTime*0.86);

        // Time varying pixel color
        float pos = float(sign(dir.y) == 1.0);
        float neg = 1.0 - pos;
        uv.y = (1.0-uv.y)*neg + uv.y*pos;

        pos = float(sign(dir.x) == 1.0);
        neg = 1.0 - pos;
        uv.x = (1.0-uv.x)*neg + uv.x*pos;

        vec3 col = mix(col1,col2, pow(length(uv*dir),interpolationExp));

        // Output to screen
        fragColor = vec4(col,1.0);
    }
}