package kw.test.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tony.shader.ShaderUtills;

public class DesktopLauncher {


    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.x = 1000;
        config.y = 0;
        config.samples = 8;
        config.useHDPI = true;
        config.height = (int)(1280 );
        config.width = (int) (720);
        config.stencil = 8;
        new LwjglApplication(new ShaderUtills(), config);
    }
}