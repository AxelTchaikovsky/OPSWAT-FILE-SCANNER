import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Objects;

public class FileRenderer implements FileRendererInterface {
  private String apiKey;

  FileRenderer() {
  }

  FileRenderer(String apiKey) {
    this.apiKey = apiKey;
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Invalid operands.");
      return;
    }
    if (!Objects.equals(args[0], "upload_file")) {
      System.out.println("Invalid operand.");
      return;
    }
    File file = new File(args[1]);
    if (!file.exists()) {
      System.out.println("File doesn't exist.");
      return;
    }
    /*
     * Put your api key here:
     */
    var apiKey = "7748d6f208c2fd42db1f6045e07e2b7b";
    var path = args[1];
    FileRenderer fileRenderer = new FileRenderer(apiKey);
    try {
      var hash = fileRenderer.getHash(path);
      var response = fileRenderer.hashLookUp(hash);
      fileRenderer.printResult(response, path);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public String getHash(String path) throws NoSuchAlgorithmException, IOException {
    String md5;
    try (InputStream is = Files.newInputStream(Paths.get(path))) {
      md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
    }
    return md5.toUpperCase(Locale.ROOT);
  }

  @Override
  public Response hashLookUp(String hash) throws IOException {
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://api.metadefender.com/v4/hash/" + hash)
            .get()
            .addHeader("apikey", apiKey)
            .build();

    return client.newCall(request).execute();
  }

  @Override
  public void printResult(Response response, String path) throws IOException {
    File file = new File(path);
    byte[] fileContent = Files.readAllBytes(file.toPath());
    if (response.code() == 404) {
      System.out.println("[ Upload file for scan... ]");
      OkHttpClient client = new OkHttpClient();

      Request newRequest = new Request.Builder()
              .url("https://api.metadefender.com/v4/file")
              .post(RequestBody.create(fileContent))
              .addHeader("apikey", apiKey)
              .addHeader("Content-Type", "application/octet-stream")
              .addHeader("filename", path)
              .build();
      Response newResponse = client.newCall(newRequest).execute();
      JSONObject json = new JSONObject(newResponse.body().string());
      String dataId = json.getString("data_id");
      System.out.println("[ dataId: " + dataId + " ]");

      int progress = 0;
      JSONObject jsonObject = null;
      while (progress < 100) {
        newRequest = new Request.Builder()
                .url("https://api.metadefender.com/v4/file/" + dataId)
                .get()
                .addHeader("apikey", apiKey)
                .build();

        newResponse = client.newCall(newRequest).execute();
        jsonObject = new JSONObject(newResponse.body().string());
        progress = jsonObject.getJSONObject("scan_results").getInt("progress_percentage");
      }
      printHelper(jsonObject);
    } else if (response.code() == 200) {
      JSONObject json = new JSONObject(response.body().string());
      printHelper(json);
    } else {
      System.out.println("HTTP errors: " + response.code());
    }
  }

  /**
   * Print scan message to standard out.
   *
   * @param json Json object fetched from server.
   */
  public void printHelper(JSONObject json) {
    System.out.println("filename: " + json.getJSONObject("file_info").getString("display_name"));
    System.out.println("overall status: " + json.getJSONObject("scan_results").getString("scan_all_result_a"));
    var scanDetails = json.getJSONObject("scan_results").getJSONObject("scan_details");
    var keys = scanDetails.keys();
    while (keys.hasNext()) {
      String key = keys.next();
      JSONObject item = scanDetails.getJSONObject(key);
      String engine = item.keys().toString();
      System.out.println("engine: " + engine);
      if (Objects.equals(item.getString("threat_found"), "")) {
        System.out.println("threat_found: Clean");
      } else {
        System.out.println("threat_found: " + item.getString("threat_found"));
      }
      System.out.println("def_time: " + item.getString("def_time"));
      System.out.println("scan_result: " + item.getInt("scan_result_i"));
    }
  }
}
