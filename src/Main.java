import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class Main {
    public static void main(String[] args) {

        // String fileName = "data/General-100/im_4.bmp";
        String fileName = "data/barbara_b_512_512.bmp";
        String prefix = "data/output/";
        String extension = ".jpg";

        try {
            File inFile = new File(fileName);

            Image inputImage = ImageIO.read(inFile);

            int[] quality = {10, 20, 60, 100};

            for (int i : quality) {
                String outFileName = prefix + "barbara-" + i + extension;

                File outputFile = new File(outFileName);
                outputFile.createNewFile(); // if file already exists will do nothing

                OutputStream outfile = new FileOutputStream(outputFile);

                JpegEncoder encoder = new JpegEncoder(inputImage, i, outfile);
                encoder.Compress();
                outfile.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
}
