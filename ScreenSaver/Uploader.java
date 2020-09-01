import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

public class Uploader  extends Thread{
    String date;
    public Uploader(String now) {
        this.date = now;
    }

    @Override
    public void run() {
        String ACCESS_TOKEN = "-lz697awI5AAAAAAAAAAAaCZGAnVlxkdwHlY9DxWEGM8YZX8-6rv-PMy2_meLeER";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        try (InputStream in = new FileInputStream("/Users/user/Desktop/" + date + ".png")) {
            FileMetadata metadata = client.files().uploadBuilder("/" + date + ".png")
                    .uploadAndFinish(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
