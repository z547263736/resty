package cn.dreampie.route.base;

import cn.dreampie.route.http.HttpRequest;
import cn.dreampie.route.http.HttpResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ice on 14-12-29.
 */
public abstract class Render {
  /**
   * Render to client
   */
  public abstract void render(HttpRequest request, HttpResponse response, Object out);

  public void write(HttpRequest request, HttpResponse response, String content) {
    PrintWriter writer = null;
    try {
      writer = response.getWriter();
      writer.print(content);
      writer.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      if (writer != null)
        writer.close();
      try {
        response.close();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    }
  }
}
