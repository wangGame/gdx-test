#define ITER 132
#define SIZE 16.0
#ifdef GL_ES
#define LOWP lowp
   precision mediump float;
#else
#define LOWP
#endif
varying LOWP vec4 vColor;
varying vec2 vTexCoord;
uniform sampler2D u_texture;
uniform float time;

#define PI 3.14159265

float weight(float t, float log2radius, float gamma)
{
    return exp(-gamma*pow(log2radius-t,2.));
}

vec4 sample_blured(vec2 uv, float radius, float gamma)
{
    vec4 pix = vec4(0.);
    float norm = 0.;
    //weighted integration over mipmap levels
    for(float i = 0.; i < 10.; i += 0.5)
    {
        float k = weight(i, log2(radius), gamma);
        pix += k*texture(u_texture, uv, i);
        norm += k;
    }
    //nomalize, and a bit of brigtness hacking
    return pix*pow(norm,-0.95);
}

void main()
{
  // Normalized pixel coordinates (from 0 to 1)
     vec2 uv = vTexCoord;

     float blur_radius =1.+ 50.*(0.5*sin(time*1+0.000*uv.x) + 0.5);
     // Output to screen
     gl_FragColor = sample_blured(uv, blur_radius, 0.5);

}