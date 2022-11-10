#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;
uniform sampler2D u_texture2;


void main() {

    vec4 finalV = v_color * texture2D(u_texture, v_textCoords);



    vec2 uv = v_textCoords;
    vec2 iResolution = vec2(382.0,510.0);

        vec4 pixel00 = texture(u_texture, uv.xy + (vec2(0, 0)/ iResolution.xy));
        vec4 pixeln1n1 = texture(u_texture, uv.xy + (vec2(-1, -1)/ iResolution.xy));
        vec4 pixeln10 = texture(u_texture, uv.xy + (vec2(-1, 0)/ iResolution.xy));
        vec4 pixeln11 = texture(u_texture, uv.xy + (vec2(-1, 1)/ iResolution.xy));
        vec4 pixel0n1 = texture(u_texture, uv.xy + (vec2(0, -1)/ iResolution.xy));
        vec4 pixel01 = texture(u_texture, uv.xy + (vec2(0, 1)/ iResolution.xy));
        vec4 pixel1n1 = texture(u_texture, uv.xy + (vec2(1, -1)/ iResolution.xy));
        vec4 pixel10 = texture(u_texture, uv.xy + (vec2(1, 0)/ iResolution.xy));
        vec4 pixel11 = texture(u_texture, uv.xy + (vec2(1, 1)/ iResolution.xy));
        // (-1,-1)  (-1,0)  (-1,1)
        // (0, -1)  (0, 0)  (0, 1)
        // (1, -1)  (1, 0)  (1, 1)
        vec3 Gx =  (((pixel00.xyz * vec3(0)) + (pixel01.xyz * vec3(-2)) + (pixel0n1.xyz * vec3(2)) + (pixel11.xyz * vec3(-1)) + (pixel10.xyz * vec3(0))
        + (pixel1n1.xyz * vec3(1)) + (pixeln10.xyz * vec3(0)) + (pixeln11.xyz * vec3(-1)) + (pixeln1n1.xyz * vec3(1))));
        vec3 Gy =  (((pixel00.xyz * vec3(0)) + (pixel01.xyz * vec3(0)) + (pixel0n1.xyz * vec3(0)) + (pixel11.xyz * vec3(-1)) + (pixel10.xyz * vec3(-2))
        + (pixel1n1.xyz * vec3(-1)) + (pixeln10.xyz * vec3(2)) + (pixeln11.xyz * vec3(1)) + (pixeln1n1.xyz * vec3(1))));
        vec3 Gx2 = vec3(pow(Gx.x, 3.0), pow(Gx.y, 3.0),pow(Gx.z, 3.0));
        vec3 Gy2 = vec3(pow(Gy.x, 3.0), pow(Gy.y, 3.0),pow(Gy.z, 3.0));
        vec3 tot = Gx2 + Gy2;
        vec3 G = vec3(sqrt(tot.x), sqrt(tot.y), sqrt(tot.z));
    /*vec3 sum = ((pixel00 + pixeln1n1 + pixeln10 + pixeln11 + pixel0n1 
                + pixel01 + pixel1n1 + pixel10 + pixel11).xyz) / vec3(9);*/ //Box Blur
    /* vec3 sum = (((pixel00.xyz * vec3(8)) + (pixel01.xyz * vec3(-1)) + (pixel0n1.xyz * vec3(-1)) + (pixel11.xyz * vec3(-1)) + (pixel10.xyz * vec3(-1)) 
                + (pixel1n1.xyz * vec3(-1)) + (pixeln10.xyz * vec3(-1)) + (pixeln11.xyz * vec3(-1)) + (pixeln1n1.xyz * vec3(-1))));*/
    float xx = (G.r+G.g+G.b) / 3.0;
    if(xx>0.3){
        gl_FragColor = finalV;
    }else{
        gl_FragColor = vec4(1,1,1, 0);
    }
    //fragColor = vec4(sum.x * uv.x * abs(sin(iTime)), sum.y * uv.y * abs(cos(iTime+10.0)), sum.z, 1);
        //fragColor = pixel00;
}