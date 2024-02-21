const float sigma = 3.;
const float r = sigma * 2.;
const float invTwoSigmaSqr = 1. / (2. * sigma * sigma);

vec4 gaussBlur( sampler2D tex, vec2 uv, vec2 d, float lod )
{
    vec4 c = textureLod(tex, uv, lod);

    for (float i = 1.; i < r; ++i) c += (
        textureLod(tex, uv + d * i, lod) +
        textureLod(tex, uv - d * i, lod)
        ) * exp(- i * i * invTwoSigmaSqr);

    return c / c.a;
}
