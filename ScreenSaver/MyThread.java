import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (;;) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date now = new Date();
            System.out.println(dateFormat.format(now));

            BufferedImage image = null;
            try {
                image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            } catch (AWTException e) {
                e.printStackTrace();
            }
            try {
                ImageIO.write(image, "png", new File("/Users/user/Desktop/" + dateFormat.format(now) + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uploader uploader = new Uploader(dateFormat.format(now));
            uploader.start();
        }
    }
}