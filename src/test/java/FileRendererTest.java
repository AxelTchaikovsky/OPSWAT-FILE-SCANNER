import junit.framework.TestCase;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class FileRendererTest extends TestCase {

  private FileRenderer fileRenderer;
  public void setUp() throws Exception {
    super.setUp();
    fileRenderer = new FileRenderer();
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
  }

  public void testPrintResult() {
  }
}