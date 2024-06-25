/* BlurFragmentShader.glsl */
precision mediump float;
 
uniform sampler2D u_texture;
varying vec2 vTexCoord;
varying vec4 vColor;
uniform float num1;
uniform float num2;
uniform float num3;
uniform float num4;
uniform float num5;
uniform float num6;
uniform float numx ;



void main(){
    vec3 W = vec3(num1, num2, num3);
    vec4 colortemp = vColor * texture2D(u_texture, vTexCoord);



    float avg = dot(colortemp.rgb, W);

    if(numx== 0){
        gl_FragColor = vec4(avg,avg,avg,colortemp.a);
    }else{

        vec3 startV3 = vec3(107.0,106.0,95.0);
        vec3 middleV3 = vec3(181.0,181.0,167.0);
        vec3 endV3 = vec3(237.0,237.0,221.0);
        float split = 0.53;
        float split1 = 1.0 - split;

        if(avg <= split){
           float R = avg / (split) * ((-startV3.x + middleV3.x) / 255.0) + (startV3.x / 255.0);
           float G = avg / (split) * ((-startV3.y + middleV3.y) / 255.0) + (startV3.y / 255.0);
           float B = avg / (split) * ((-startV3.z + middleV3.z ) / 255.0) + (startV3.z / 255.0);
           gl_FragColor = vec4(R,G,B,colortemp.a);
        }else{
           float R = (avg-split) / split1 * ((endV3.x - middleV3.x) / 255.0) + (middleV3.x / 255.0);
           float G = (avg-split) / split1 * ((endV3.y - middleV3.y) / 255.0) + (middleV3.y / 255.0);
           float B = (avg-split) / split1 * ((endV3.z - middleV3.z ) / 255.0) + (middleV3.z / 255.0);
           gl_FragColor = vec4(R,G,B,colortemp.a);
        }
    }
}

