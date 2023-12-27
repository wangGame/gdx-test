package kw.test.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libGdx.test.base.LibGdxTestMain;
import com.tony.shader.ShaderUtills;

import kw.test.file.Bean;
import kw.test.file.ReadFileConfig;

public class DesktopLauncher extends LibGdxTestMain {

    public void start(LibGdxTestMain test) {
        ReadFileConfig readFileConfig = new ReadFileConfig();
        Bean value = readFileConfig.getValue();
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = value.getName();
        config.x = 1000;
        config.stencil = 8;
        config.y = 0;
        config.height = 480;
        config.width = 324;
        Gdx.isJiami = true;
        new LwjglApplication(new ShaderUtills(), config);
    }

    public static void main(String[] args) {
        DesktopLauncher launcher = new DesktopLauncher();
        launcher.start();
    }
}