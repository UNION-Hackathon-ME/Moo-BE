package com.example.moo.external;

import com.example.moo.domain.Product;
import com.example.moo.domain.Review;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductScraper {
  @Value("${extern.naver.client-ID}")
  String client_id;
  @Value("${extern.naver.client-Secret}")
  String client_secret;

  public ProductScraper() {
  }

  public List<Product> scrapeList(String keyword) throws IOException, ParseException {
//    String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");
//    String apiURL = "https://openapi.naver.com/v1/search/shop.json?query="+encodedKeyword+"&display=100";
//    URL url = new URL(apiURL);
//
//    HttpURLConnection con = (HttpURLConnection) url.openConnection();
//    con.setRequestMethod("GET");
//    con.setRequestProperty("X-Naver-Client-Id", client_id);
//    con.setRequestProperty("X-Naver-Client-Secret", client_secret);
//    con.setRequestProperty("Referer", "");
//
//    int responseCode = con.getResponseCode();
//    BufferedReader br;
//    if (responseCode == 200) {
//      br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//    } else {
//      br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//    }
//    String inputLine;
//    StringBuffer response = new StringBuffer();
//    while ((inputLine = br.readLine()) != null) {
//      response.append(inputLine);
//    }
//    br.close();
//
//    JSONParser jsonParser = new JSONParser();
//    JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
//    JSONArray jsonArray = (JSONArray) jsonObject.get("items");
    List<Product> productList = new ArrayList<>();
//
//    for (int i = 0; i < jsonArray.size(); i++) {
//      JSONObject obj = (JSONObject) jsonArray.get(i);
//      Product product = new Product(
//          (String) obj.get("productId"),
//          (String) obj.get("title"),
//          (String) obj.get("image"),
//          (String) obj.get("mallName"),
//          (String) obj.get("link"),
//          Integer.parseInt((String) obj.get("lprice"))
//      );
//
//      List<String> informationList = new ArrayList<>();
////      Document document = Jsoup.connect((String) obj.get("link")).get();
//      Document document = Jsoup.connect("https://smartstore.naver.com/daranul/products/5164040518?NaPm=ct%3Dlwbzw5z4%7Cci%3Dfcd2e124cb67af7f77a0271e1b2dcc9f6173039a%7Ctr%3Dsls%7Csn%3D1256601%7Chk%3Def0f99efd21a0c1c5712f9d7ee4d3672753f11f3").get();
//      Elements informationElements = document.select("div.se-text-paragraph.se-text-paragraph-align-center img");
//      for (Element img : informationElements) {
//        informationList.add(img.attr("src"));
//      }
//
//      String mallImage = document.getElementsByClass("_1irdI5QNOR").first().attr("src");
//
//      double reviewNum = Double.parseDouble(document.select("strong._2pgHN-ntx6").first().text());
//
//      product.setMallImage(mallImage);
//      product.setReviewNum(reviewNum);
//
//      productList.add(product);
//    }
    List<String> productDetail = new ArrayList<>();
    List<Review> reviewList = new ArrayList<>();
    productDetail.add("https://proxy-smartstore.naver.net/img/c3RvcmUuaW1nMTEuY28ua3IvNjQ2MTgwOTkvZDA5NDE2MTMtMDg0My00ZGJhLWFlMDctOGQwMmUwYmEzZTY3XzE2MDI3MzczOTkxMzEuanBn?token=f60a032a3d576090e90cc8f2cf5219ee");
    reviewList.add(new Review(3.5, "맛있어요"));

    productList.add(new Product(
        "234723894",
        "제품명1",
        "https://shopping-phinf.pstatic.net/main_4718437/47184375491.jpg",
        "스토어명1",
        "https://shop-phinf.pstatic.net/20210223_138/1614090059782Ww71b_JPEG/15225902490708902_316447724.jpg?type=m120",
        "https://search.shopping.naver.com/gate.nhn?id=47520043571",
        44000,
        productDetail,
        3.5,
        reviewList));

    productList.add(new Product(
        "2347238943",
        "제품명2",
        "https://shopping-phinf.pstatic.net/main_4718437/47184375491.jpg",
        "스토어명2",
        "https://shop-phinf.pstatic.net/20210223_138/1614090059782Ww71b_JPEG/15225902490708902_316447724.jpg?type=m120",
        "https://search.shopping.naver.com/gate.nhn?id=47520043571",
        44300,
        productDetail,
        3.1,
        reviewList));

    return productList;
  }

  public Product scrapeProduct(String productId) throws IOException, ParseException {
    List<String> productDetail = new ArrayList<>();
    List<Review> reviewList = new ArrayList<>();
    productDetail.add("https://proxy-smartstore.naver.net/img/c3RvcmUuaW1nMTEuY28ua3IvNjQ2MTgwOTkvZDA5NDE2MTMtMDg0My00ZGJhLWFlMDctOGQwMmUwYmEzZTY3XzE2MDI3MzczOTkxMzEuanBn?token=f60a032a3d576090e90cc8f2cf5219ee");
    reviewList.add(new Review(3.5, "맛있어요"));

    return new Product(
        "234723894",
        "제품명1",
        "https://shopping-phinf.pstatic.net/main_4718437/47184375491.jpg",
        "스토어명1",
        "https://shop-phinf.pstatic.net/20210223_138/1614090059782Ww71b_JPEG/15225902490708902_316447724.jpg?type=m120",
        "https://search.shopping.naver.com/gate.nhn?id=47520043571",
        44000,
        productDetail,
        3.5,
        reviewList);
  }
}
