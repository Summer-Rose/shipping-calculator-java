import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class App {
    public static void main(String[] args) {
      String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cost", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      int length = Integer.parseInt(request.queryParams("length"));
      int width = Integer.parseInt(request.queryParams("width"));
      int height = Integer.parseInt(request.queryParams("height"));
      int distance = Integer.parseInt(request.queryParams("distance"));
      int speed = Integer.parseInt(request.queryParams("speed"));
      String giftWrap = request.queryParams("gift-wrap");

      ShippingCalculator myShippingCalculator = new ShippingCalculator(length, width, height);
      model.put("getCost", myShippingCalculator.getCost(speed, distance));
      model.put("myShippingCalculator", myShippingCalculator);
      model.put("speed", speed);
      model.put("getSurfaceArea", myShippingCalculator.getSurfaceArea());
      model.put("getGiftWrapCost", myShippingCalculator.getGiftWrapCost());
      model.put("giftWrap", giftWrap);

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
