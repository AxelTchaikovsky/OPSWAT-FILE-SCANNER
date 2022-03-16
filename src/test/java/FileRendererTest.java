import junit.framework.TestCase;
import okhttp3.Response;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FileRendererTest extends TestCase {

  private FileRenderer fileRenderer;
  public void setUp() throws Exception {
    super.setUp();
    fileRenderer = new FileRenderer("7748d6f208c2fd42db1f6045e07e2b7b");
  }

  public void testGetHash() {
    try {
      var md5 = fileRenderer.getHash(
              "/Users/adam/Documents/OADir/OPSWAT-FILE-SCANNER/samplefile.txt");
      System.out.println(md5);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void testHashLookUp() {
    String hash = "9259C79B371ABA8737462DC56AADC93C";
    try {
      Response response = fileRenderer.hashLookUp(hash);
      System.out.println(response.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void testPrintResult() {
    String hash = "9259C79B371ABA8737462DC56AADC93C";
    try {
      Response response = fileRenderer.hashLookUp(hash);
      System.out.println(response.toString());
      fileRenderer.printResult(response, "/Users/adam/Documents/OADir/OPSWAT-FILE-SCANNER/samplefile.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}