import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class FileRenderer implements FileRendererInterface {
  @Override
  public String getHash(String path) throws NoSuchAlgorithmException, IOException {
    String md5;
    //Use MD5 algorithm
    MessageDigest md5Digest = MessageDigest.getInstance("MD5");
    try (InputStream is = Files.newInputStream(Paths.get(path))) {
      md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
    }
    return md5.toUpperCase(Locale.ROOT);
  }

  @Override
  public Response hashLookUp(String hash) {
    return null;
  }

  @Override
  public void printResult(Response response) {

  }
}
