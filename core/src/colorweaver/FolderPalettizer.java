package colorweaver;

import colorweaver.tools.StringKit;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Created by Tommy Ettinger on 1/21/2018.
 */
public class FolderPalettizer extends ApplicationAdapter {


    private int[] PALETTE;
//    private final double[][] lab15 = CIELABConverter.makeLAB15();
//    private final PaletteReducer.ColorMetric cm = new PaletteReducer.ColorMetric(){
//        @Override
//        public double difference(int color1, int color2) {
//            if(((color1 ^ color2) & 0x80) == 0x80) return Double.POSITIVE_INFINITY;
//            return difference(color1 >>> 24, color1 >>> 16 & 0xFF, color1 >>> 8 & 0xFF, color2 >>> 24, color2 >>> 16 & 0xFF, color2 >>> 8 & 0xFF);
//        }
//
//        @Override
//        public double difference(int color1, int r2, int g2, int b2) {
//            if((color1 & 0x80) == 0) return Double.POSITIVE_INFINITY;
//            return difference(color1 >>> 24, color1 >>> 16 & 0xFF, color1 >>> 8 & 0xFF, r2, g2, b2);
//        }
//
//        @Override
//        public double difference(int r1, int g1, int b1, int r2, int g2, int b2) {
//            int indexA = (r1 << 7 & 0x7C00) | (g1 << 2 & 0x3E0) | (b1 >>> 3),
//                indexB = (r2 << 7 & 0x7C00) | (g2 << 2 & 0x3E0) | (b2 >>> 3);
//            final double
//                L = lab15[0][indexA] - lab15[0][indexB],
//                A = lab15[1][indexA] - lab15[1][indexB],
//                B = lab15[2][indexA] - lab15[2][indexB];
//            return L * L * 11.0 + A * A * 1.6 + B * B;
//        }
//    };
    public void loadPalette(String name) {
        try {
            String text = Gdx.files.local("hex/" + name + ".hex").readString();
            int start = 0, end = 6, len = text.length();
            int gap = (text.charAt(7) == '\n') ? 8 : 7;
            int sz = ((len + 2) / gap);
            PALETTE = new int[sz + 1];
            for (int i = 1; i <= sz; i++) {
                PALETTE[i] = StringKit.intFromHex(text, start, end) << 8 | 0xFF;
                start += gap;
                end += gap;
            }
        } catch (GdxRuntimeException e) {
            e.printStackTrace();
        }
    }

    public void create() {
        final String targetDir = "output_images/";
        FileHandle[] hexes = Gdx.files.local("hex/").list(".hex");
        System.out.println(
                "Add any art you have the rights to (optimally public domain or self-made) to input_images/");
        System.out.println(
                "When you run this from a .jar file next to the folder input_images/, it will write to output_images");
        FileHandle[] samples =
                Gdx.files.local("input_images/").list(new FileFilter() {
            @Override
            public boolean accept (File pathname) {
                return !pathname.isDirectory();
            }
        });
        PaletteReducer reducer = new PaletteReducer();
//        int i = 0;
        for(FileHandle hex : hexes) {
//        FileHandle hex = Gdx.files.local("palettes/hex/"+HexGenerator.NAME+".hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/websafe-216.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/bw-2.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/db-iso-22.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/azurestar-32.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/manos-64.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/hyper-8.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/tzi-24.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/ziggurat-63.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/dawnvinja-63.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/betts-63.hex");{
//        FileHandle hex = Gdx.files.local("palettes/hex/tater-255.hex");{

//            if(i++ > 12) break;

            String name = hex.nameWithoutExtension().toLowerCase(), suffix = "_" + name;
            System.out.println(name);
//            if(name.compareToIgnoreCase("nameOfPaletteThatFailed") < 0) continue;
            loadPalette(name);
            if(PALETTE.length > 40)
                continue;
            Gdx.files.local(targetDir).mkdirs();
//            Gdx.files.local(targetDir + name).mkdirs();
            PNG8 png8 = new PNG8();
            png8.setCompression(7);
            png8.setFlipY(false);
//            reducer.exact(PALETTE, PaletteReducer.iptGoodMetric);
            reducer.exact(PALETTE, PaletteReducer.oklabCarefulMetric);
            png8.palette = reducer;
            try {
                for(FileHandle sample : samples) {
                    Pixmap pm, sam = new Pixmap(sample);
                    pm = new Pixmap(sam.getWidth(), sam.getHeight(), sam.getFormat());
                    reducer.setDitherStrength(1f);
                    String subname = targetDir + "/" + sample.nameWithoutExtension();
//                    String subname = targetDir + name + "/" + sample.nameWithoutExtension();
////lousy but important
                    pm.drawPixmap(sam, 0, 0);
                    pm = reducer.reduceSolid(pm);
                    png8.writePrecisely(Gdx.files.local(subname + "_Solid" + suffix + ".png"), pm, PALETTE, false, 0);

                    reducer.setDitherStrength(1.25f);
                    drawPart(pm, sam, reducer, png8, subname, suffix);

//                    reducer.setDitherStrength(0.5f);
//                    subname = targetDir + name + "/" + sample.nameWithoutExtension() + "_half";
//
//                    drawPart(pm, sam, reducer, png8, subname, suffix);
//
//                    reducer.setDitherStrength(1.5f);
//                    subname = targetDir + name + "/" + sample.nameWithoutExtension() + "_bonus";
//
//                    drawPart(pm, sam, reducer, png8, subname, suffix);
//
//                    reducer.setDitherStrength(2f);
//                    subname = targetDir + name + "/" + sample.nameWithoutExtension() + "_heavy";
//
//                    drawPart(pm, sam, reducer, png8, subname, suffix);
//
//                    reducer.setDitherStrength(0.25f);
//                    subname = targetDir + name + "/" + sample.nameWithoutExtension() + "_quarter";
//
//                    drawPart(pm, sam, reducer, png8, subname, suffix);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Gdx.app.exit();
    }

    private void drawPart(Pixmap pm, Pixmap sam, PaletteReducer reducer, PNG8 png8, String subname, String suffix) throws IOException {
//////hot rat-infested garbage
//        pm.drawPixmap(sam, 0, 0);
//        pm = reducer.reduceGarbage(pm);
//        png8.writePrecisely(Gdx.files.local(subname + ".png"), pm, PALETTE, false, 0);
//////pretty bad
//        pm.drawPixmap(sam, 0, 0);
//        pm = reducer.reduceChaoticNoise(pm);
//        png8.writePrecisely(Gdx.files.local(subname + "_Chaotic" + suffix + ".png"), pm, PALETTE, false, 0);
//////ok
        pm.drawPixmap(sam, 0, 0);
        pm = reducer.reduceIGN(pm);
        png8.writePrecisely(Gdx.files.local(subname + "_IGN" + suffix + ".png"), pm, PALETTE, false, 0);
////good enough
//        pm.drawPixmap(sam, 0, 0);
//        pm = reducer.reduceSierraLite(pm);
//        png8.writePrecisely(Gdx.files.local(subname + "_SierraLite" + suffix + ".png"), pm, PALETTE, false, 0);
//////rather good
        pm.drawPixmap(sam, 0, 0);
        pm = reducer.reduceFloydSteinberg(pm);
        png8.writePrecisely(Gdx.files.local(subname + "_FloydSteinberg" + suffix + ".png"), pm, PALETTE, false, 0);
//////ok
        pm.drawPixmap(sam, 0, 0);
        pm = reducer.reduceTrueBlue3(pm);
        png8.writePrecisely(Gdx.files.local(subname + "_BlueNewer" + suffix + ".png"), pm, PALETTE, false, 0);
//////great
//        pm.drawPixmap(sam, 0, 0);
//        pm = reducer.reduceBluish(pm);
//        png8.writePrecisely(Gdx.files.local(subname + "_Neuter" + suffix + ".png"), pm, PALETTE, false, 0);
//////very good
//        pm.drawPixmap(sam, 0, 0);
//        pm = reducer.reduceScatter(pm);
//        png8.writePrecisely(Gdx.files.local(subname + "_Scatter" + suffix + ".png"), pm, PALETTE, false, 0);
//////YAY YIPPEE WOO NO BANDING
        pm.drawPixmap(sam, 0, 0);
        pm = reducer.reduceNeue(pm);
        png8.writePrecisely(Gdx.files.local(subname + "_Neue" + suffix + ".png"), pm, PALETTE, false, 0);
//////incredible
        pm.drawPixmap(sam, 0, 0);
        pm = reducer.reduceKnoll(pm);
        png8.writePrecisely(Gdx.files.local(subname + "_Knoll_G" + suffix + ".png"), pm, PALETTE, false, 0);
//////great
//        pm.drawPixmap(sam, 0, 0);
//        pm = reducer.reduceKnollRoberts(pm);
//        png8.writePrecisely(Gdx.files.local(subname + "_KR_G" + suffix + ".png"), pm, PALETTE, false, 0);
//////quite good
//        pm.drawPixmap(sam, 0, 0);
//        pm = reducer.reduceKnollBlue(pm);
//        png8.writePrecisely(Gdx.files.local(subname + "_KB" + suffix + ".png"), pm, PALETTE, false, 0);
//////???
//        pm.drawPixmap(sam, 0, 0);
//        pm = reducer.reducePlexus(pm);
//        png8.writePrecisely(Gdx.files.local(subname + "_Plexus" + suffix + ".png"), pm, PALETTE, false, 0);
    }
}
