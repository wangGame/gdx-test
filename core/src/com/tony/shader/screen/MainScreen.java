package com.tony.shader.screen;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.BaseGame;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.screen.BaseScreen;
import com.tony.shader.group.ItemGroup;


public class MainScreen extends BaseScreen {
    public MainScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        ScrollPane scrollPane = new ScrollPane(
                new Table(){{
                    for (int i = 0; i < 100; i++) {
                        add(new ItemGroup("demo01"));
                        row();
                    }
                    pack();
                    setPosition(Constant.GAMEWIDTH/2.0f,Constant.GAMEHIGHT/2.0f,Align.center);
                }}
        );
        addActor(scrollPane);
        scrollPane.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);

//        renderer = new ShapeRenderer();
//        LightGroup lightGroup = new LightGroup();
//        addActor(lightGroup);

//        OutLight outLight = new OutLight();
//        addActor(outLight);

//        Image image1 = new Image(Asset.getAsset().getTexture("test.png"));
//        addActor(image1);
//        image1.setOrigin(Align.center);

//        stage.addAction(Actions.delay(0.4f,Actions.run(()->{
//            Gdx.app.postRunnable(()->{
//                Pixmap pixmap = ScreenUtils.getFrameBufferPixmap(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//                try {
//                    PixmapIO.writePNG(Gdx.files.local("screenshot.png"), pixmap);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
////                Image image = new Image(new Texture(pixmap));
////                addActor(image);
//                run();
//            });
//
//        })));




//
//        Image bg = new Image(Asset.getAsset().getTexture("white_bg.png"));
//        bg.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
//        addActor(bg);
//        bg.setColor(Color.valueOf("#b9920c"));
//        bg.setPosition(Constant.GAMEWIDTH/2.0f,Constant.GAMEHIGHT/2.0f,Align.center);
//        ScrollPane pane = new ScrollPane(new Table(){{
//            int index= 0;
//            int length = GroupManager.imageShaderItems.length;
//            for (int i = 0; i < length; i++) {
//                ItemBean itemBean = GroupManager.imageShaderItems[length-1-i];
//                index ++;
//                add(new ItemGroup(itemBean.getName(),itemBean.getIndex())).pad(20);
//                if (index % 2 == 0) {
//                    row();
//                }
//            }
//            pack();
//            align(Align.top);
//        }}){
//            @Override
//            public void setRectangle(float startX, float startY) {
//                super.setRectangle(startX, startY);
//            }
//        };
//        addActor(pane);
//        pane.setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT);
//        ExpGroup expGroup = new ExpGroup();
//        addActor(expGroup);

//        ShaderGroup group = new ShaderGroup();
//        group.setPosition(Constant.GAMEWIDTH/2.0f,Constant.GAMEHIGHT/2.0f,Align.center);
//        stage.addActor(group);

//        LinearGroup group = new LinearGroup();
//        stage.addActor(group);


//        ScrollPane pane = new ScrollPane(new Table(){{
//            int index= 0;
//            int length = GroupManager.InterpolationShaderItems.length;
//            for (int i = 0; i < length; i++) {
//                ItemBean itemBean = GroupManager.InterpolationShaderItems[length-1-i];
//                index ++;
//                add(new ItemGroup(itemBean.getName(),itemBean.getIndex(),1)).pad(20);
//                if (index % 2 == 0) {
//                    row();
//                }
//            }
//            pack();
//            align(Align.top);
//        }}){
//            @Override
//            public void setRectangle(float startX, float startY) {
//                super.setRectangle(startX, startY);
//            }
//        };
//        addActor(pane);
//        pane.setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT);


//        Pow2InInverseGroup1 group = new Pow2InInverseGroup1();
//        addActor(group);
//        group.setPosition(100,100);

//        DrawLightShaderGroup group = new DrawLightShaderGroup();
//        addActor(group);

//        ¸ßË¹Ä£ºý
//        BlurDemo blurDemo = new BlurDemo();
//        addActor(blurDemo);

//        ¹þ¹þ¾µ
//        HaHaJingDemo demo = new HaHaJingDemo();
//        addActor(demo);

//        »³¾É
//        HuaiJiuDemo huaiJiuDemo = new HuaiJiuDemo();
//        addActor(huaiJiuDemo);

//        light
//        RgbHsl rgbHsl = new RgbHsl();
//        addActor(rgbHsl);

//        NomalMix mix = new NomalMix();
//        addActor(mix);

    }

//    public void run(){
//        Pixmap pixmap = new Pixmap(Gdx.files.internal("screenshot.png"));
//        Image im = new Image(new Texture(pixmap));
//        addActor(im);
//        im.addAction(Actions.forever(
//                Actions.sequence(
//                Actions.fadeOut(6),
//                Actions.fadeIn(6)
//                )));
//        int width = pixmap.getWidth();
//        int height = pixmap.getHeight();
//        int MIN_RADIUS = 20;
//        int MAX_RADIUS = 21;
//        int[][][] accumulator = new int[width][height][MAX_RADIUS - MIN_RADIUS + 1];
//        ByteBuffer pixels = pixmap.getPixels();
//
////        for (int i = 0; i < 360; i++) {
////            Image image = new Image(Asset.getAsset().getTexture("white_bg.png"));
////            addActor(image);
////            image.setSize(1,1);
////            image.setColor(Color.RED);
////            image.setPosition((float) (180+MAX_RADIUS*Math.cos(i)), (float) (380+MAX_RADIUS*Math.sin(i)),Align.center);
////        }
//
//
////        for (int i = 0; i < height; i++) {
////            for (int i1 = 0; i1 < width; i1++) {
////                int pixel = pixmap.getPixel(i, i1);
////                float r = (pixel >> 24 & 0xFF) / 255f;
////                float g = (pixel >> 16 & 0xFF) / 255f;
////                float b = (pixel >> 8 & 0xFF) / 255f;
////
////
////                if (r==0&&g==0&&b==0) {
////                    Image image = new Image(Asset.getAsset().getTexture("white_bg.png"));
////                    addActor(image);
////                    image.setColor(Color.BLACK);
////                    image.setPosition(i,i1);
////                }
////
////            }
////        }
//        for (int y = 0; y <height; y++) {
//            for (int x = 0; x < width; x++) {
//                int pixel = pixmap.getPixel(x, height-y-1);
//                float r = (pixel >> 24 & 0xFF) / 255f;
//                float g = (pixel >> 16 & 0xFF) / 255f;
//                float b = (pixel >> 8 & 0xFF) / 255f;
//
//
//                if (r==0&&g==0&&b==0) {
//                    // Edge pixel
//                    for (int rad = MIN_RADIUS; rad <= MAX_RADIUS; rad++) {
//                        for (int theta = 0; theta < 360; theta+=1) {
//                            int a = (int)(x - rad * Math.cos(Math.toRadians(theta)));
//                            int b1 = (int)(y - rad * Math.sin(Math.toRadians(theta)));
//                            if (a >= 0 && a < width-2 && b1 >= 0 && b1 < height-2) {
//                                accumulator[a][b1][rad - MIN_RADIUS]++;
////                                if (accumulator[a][b1][rad - MIN_RADIUS]==1) {
////                                    Image image = new Image(Asset.getAsset().getTexture("white_bg.png"));
////                                    addActor(image);
////                                    image.setSize(1, 1);
////                                    image.setPosition(x, y, Align.center);
////                                    image.setColor(Color.BLACK);
////                                    image.getColor().a = 0.2f;
////                                }
//                            }
//                        }
//                    }
//                    // Edge pixel
////                                    Image image = new Image(Asset.getAsset().getTexture("white_bg.png"));
////                                    addActor(image);
////                                    image.setPosition(y, x, Align.center);
////                                    image.setColor(Color.BLACK);
////                                    image.setSize(1, 1);
////                                    image.getColor().a = 0.2f;
//                }else {
//
////                    System.out.println("------out-------");
//                }
//            }
//        }
//
//
//
////
//        for (int y = 0; y < height-4; y++) {
//            for (int x = 0; x < width-4; x++) {
//                for (int r = MIN_RADIUS; r <= MAX_RADIUS; r++) {
//                    if (accumulator[x][y][r - MIN_RADIUS] >= 360) {
////                        System.out.println(accumulator[x][y][r - MIN_RADIUS]);
////                        System.out.println("---------------");
//                        Image image = new Image(Asset.getAsset().getTexture("white_bg.png"));
//                        addActor(image);
//                        image.setSize(1,1);
//                        image.setPosition(x,y,Align.center);
//                        image.setColor(Color.BLACK);
//                        Bean bean = new Bean();
//                        bean.x = x;
//                        bean.y = y;
//                        bean.radius = MAX_RADIUS;
//                        array.add(bean);
//
////                        image.setDebug(true);
////                        System.out.println(accumulator[x][y][r - MIN_RADIUS]);
//                    }
//                    }
////              }
//            }
//        }
//
////        Pixmap pixmap1 = new Pixmap(Gdx.files.internal("cirtest2.png"));
////        Image image = new Image(new Texture(pixmap1));
////        addActor(image);
//    }

//    private Array<Bean> array = new Array<>();
    @Override
    public void render(float delta) {
        super.render(delta);

//        renderer.begin(ShapeRenderer.ShapeType.Line);
//        renderer.setColor(Color.RED);

//        for (Bean bean : array) {
//            renderer.circle(bean.x,bean.y,bean.radius);
//        }

//        renderer.end();
    }

//    class Bean{
//        private float x;
//        private float y;
//        private float radius;
//    }
}
