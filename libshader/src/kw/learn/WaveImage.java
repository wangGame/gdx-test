package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * @Auther jian xian si qi
 * @Date 2023/6/27 14:21
 */
public class WaveImage extends Image {
    private ShaderProgram program;

    public WaveImage(Texture texture){
        super(texture);
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("bend/txt.vert"),
                    Gdx.files.internal("bend/txt.frag"));
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }

    /*vec2 bend( vec2 uv, float angle )
{
    const float BLOCK_HEIGHT = 1.;
    const float BLOCK_WIDTH = .5;

    float bendSign = angle < 0. ? -1. : 1.;
    float bendRadius = BLOCK_HEIGHT / abs( angle );

    vec2 p = uv * vec2( bendSign, 1. ) + vec2( bendRadius, 0. );

    return vec2( ( length( p ) - bendRadius ) / BLOCK_WIDTH * bendSign + .5, atan( p.y, p.x ) / abs( angle ) );
}

void mainImage( out vec4 fragColor, in vec2 fragCoord )
{
    vec2 uv = (fragCoord*2.-iResolution.xy)/iResolution.y;
    uv.y += .5;

    float bendAngle = sin( iTime * 3. + .0001 ) * 2.;

    vec2 textureUV = bend( uv, bendAngle );
    float textureUVIsValid = textureUV.x >= 0. && textureUV.x < 1. && textureUV.y >= 0. && textureUV.y < 1. ? 1. : 0.;

    vec3 col = vec3( sin(textureUV*3.1415*10.), .5 ) * textureUVIsValid;

    // Output to screen
    fragColor = vec4(col,1.0);
}*/
}
