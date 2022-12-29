package kw.test.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tony.rider.RiderGame;
import com.tony.rider.Three.Animation3DTest;
import com.tony.rider.screen.ShaderBlurTest;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "tony Rider Game";
        config.width = 360;
        config.height = 640;
        config.x = 100;
        config.y = 100;

//        new LwjglApplication(new ShaderBlurTest(), config);
        new LwjglApplication(new RiderGame(), config);

    }
}