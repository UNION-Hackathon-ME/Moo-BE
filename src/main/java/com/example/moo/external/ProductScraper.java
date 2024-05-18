package com.example.moo.external;

import com.example.moo.domain.Product;
import com.example.moo.domain.Review;
import com.example.moo.dto.ProductDetailResponse;
import com.example.moo.dto.ProductListResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

  public List<ProductListResponse> scrapeList(String keyword) throws IOException, ParseException {
    List<ProductListResponse> productListResponseList = new ArrayList<>();
    String url = "https://www.coupang.com/np/search?component=&q=" + URLEncoder.encode(keyword, "UTF-8");
    Document doc = Jsoup.connect(url).timeout(0)
        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36")
        .cookie("a","b").get();

    Elements products = doc.select("li.search-product");

    for (Element product : products) {
      String productId = product.attr("data-product-id");
      String productImage = product.select("img.search-product-wrap img").attr("src");
      String productName = product.select("div.name").text();
      int price = Integer.parseInt(product.select("strong.price-value").text().replaceAll(",",""));

      ProductListResponse productListResponse = new ProductListResponse(productId, productImage, productName, price, 3.5);
      productListResponseList.add(productListResponse);
    }

    return productListResponseList;
  }

  public ProductDetailResponse scrapeProduct(String productId) throws IOException, ParseException {

//    jsoup
//    https://www.coupang.com/vp/products/여기에productId

    String url = "https://www.coupang.com/vp/products/" + productId;
    Document doc = Jsoup.connect(url).timeout(0)
        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36")
        .cookie("a","b").get();

    Element product = doc.select("section.contents").first();

    String productImage = product.select("img.prod-image__detail").attr("src");
    String productName = product.select("h2.prod-buy-header__title").text();
    String mallName = product.select("a.prod-sale-vendor-name").text();
    int price = Integer.parseInt(product.select("span.total-price strong").first().text().replaceAll(",","").replaceAll("원",""));
    List<String> productDetail = new ArrayList<>();

    Elements imageList = product.select(".subType-IMAGE");
    for (Element image : imageList) {
      System.out.println(image.toString());

      productDetail.add(image.select("img").attr("src"));
    }
    double reviewScoreAvg = 3.5;
    List<Review> reviewList = new ArrayList<>();

    reviewList.add(new Review(3.5, "맛있어요"));

    ProductDetailResponse productDetailResponse = new ProductDetailResponse(productId, productImage, productName, mallName, price, productDetail, reviewScoreAvg, reviewList);
    return productDetailResponse;
  }
}
