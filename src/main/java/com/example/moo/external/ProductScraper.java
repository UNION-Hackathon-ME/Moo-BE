package com.example.moo.external;

import com.example.moo.domain.Review;
import com.example.moo.dto.ProductDetailResponse;
import com.example.moo.dto.ProductListResponse;
import com.example.moo.repository.ReviewRepository;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductScraper {
  private final ReviewRepository repository;

  public ProductScraper(ReviewRepository repository) {
    this.repository = repository;
  }

  public List<ProductListResponse> scrapeList(String keyword) throws IOException, ParseException {
    List<ProductListResponse> productListResponseList = new ArrayList<>();
    String url = "https://www.coupang.com/np/search?component=&q=" + URLEncoder.encode(keyword, "UTF-8");
    Document doc = Jsoup.connect(url).timeout(0)
        .cookie("a","b").get();

    Elements products = doc.select("li.search-product");

    for (Element product : products) {
      String productId = product.attr("data-product-id");
      String productImage = product.select("img.search-product-wrap img").attr("src");
      String productName = product.select("div.name").text();
      int price = Integer.parseInt(product.select("strong.price-value").text().replaceAll(",",""));
      double reviewScoreAvg = repository.selectReviewAvg(productId);

      ProductListResponse productListResponse = new ProductListResponse(productId, productImage, productName, price, reviewScoreAvg);
      productListResponseList.add(productListResponse);
    }

    return productListResponseList;
  }

  public ProductDetailResponse scrapeProduct(String productId) throws IOException, ParseException {
    String url = "http://www.coupang.com/vp/products/" + URLEncoder.encode(productId, "UTF-8");
    Document doc = Jsoup.connect(url).timeout(0)
        .cookie("a","b").get();

    Element product = doc.select("section.contents").first();

    String productImage = product.select("img.prod-image__detail").attr("src");
    String productName = product.select("h2.prod-buy-header__title").text();
    String mallName = doc.select("a.prod-sale-vendor-name").text();
    int price = Integer.parseInt(product.select("span.total-price strong").first().text().replaceAll(",","").replaceAll("원",""));
    List<String> productDetail = new ArrayList<>();

//    WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--headless").addArguments("--disable-gpu"));
//    driver.get(url);
//
//    List<WebElement> imageList = driver.findElements(By.cssSelector(".type-IMAGE_NO_SPACE"));
//
//    for (WebElement img : imageList) {
//      String link = img.findElement(By.cssSelector("img")).getAttribute("src");
//      productDetail.add(link);
//    }
//
//    driver.quit();


    double reviewScoreAvg = repository.selectReviewAvg(productId);

    List<Review> reviewList = repository.findReviews(productId);

    ProductDetailResponse productDetailResponse = new ProductDetailResponse(productId, productImage, mallName, productName, price, productDetail, reviewScoreAvg, reviewList);
    return productDetailResponse;
  }
}
