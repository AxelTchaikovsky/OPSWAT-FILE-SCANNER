import okhttp3.Response;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface FileRendererInterface {
  /**
   * Get hash of designated path.
   *
   * @param path path to file
   * @return MD5 hash string
   * @throws NoSuchAlgorithmException
   * @throws IOException
   */
  String getHash(String path) throws NoSuchAlgorithmException, IOException;

  /**
   * Look up hash in server, see if file is in cache.
   *
   * @param hash MD5 hash string
   * @return Server response
   * @throws IOException
   */
  Response hashLookUp(String hash) throws IOException;

  /**
   * Print result for different responses in stipulated format.
   *
   * @param response Server response
   * @param path     path to file
   * @throws IOException
   */
  void printResult(Response response, String path) throws IOException;
}
