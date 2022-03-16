import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface FileRendererInterface {
    String getHash(String path) throws NoSuchAlgorithmException, IOException;
    Response hashLookUp(String hash);
    void printResult(Response response);
}
