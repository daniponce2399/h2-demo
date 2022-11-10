package h2demo.controller;


import h2demo.model.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.security.Timestamp;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @Test
    public void obtainSearchProductsTest1(){
        var response = productController.getStudent("2020-06-14T10.00.00",35455, 1);
        ProductEntity result = response.block();

        assertThat(result).isNotNull();
        assertThat(result.getBrandId()).isEqualTo(1);
        assertThat(result.getProductId()).isEqualTo(35455);
        assertThat(result.getPriceList()).isEqualTo(1);
        assertThat(result.getPrice()).isEqualTo(35.50);
        assertThat(result.getStartDate()).isEqualTo("2020-06-14T00:00:00");
        assertThat(result.getEndDate()).isEqualTo("2020-12-31T23:59:59");
    }

    @Test
    public void obtainSearchProductsTest2(){
        var response = productController.getStudent("2020-06-14T16.00.00",35455, 1);
        ProductEntity result = response.block();

        assertThat(result).isNotNull();
        assertThat(result.getBrandId()).isEqualTo(1);
        assertThat(result.getProductId()).isEqualTo(35455);
        assertThat(result.getPriceList()).isEqualTo(2);
        assertThat(result.getPrice()).isEqualTo(25.45);
        assertThat(result.getStartDate()).isEqualTo("2020-06-14T15:00:00");
        assertThat(result.getEndDate()).isEqualTo("2020-06-14T18:30:00");
    }

    @Test
    public void obtainSearchProductsTest3(){
        var response = productController.getStudent("2020-06-14T21.00.00",35455, 1);
        ProductEntity result = response.block();

        assertThat(result).isNotNull();
        assertThat(result.getBrandId()).isEqualTo(1);
        assertThat(result.getProductId()).isEqualTo(35455);
        assertThat(result.getPriceList()).isEqualTo(1);
        assertThat(result.getPrice()).isEqualTo(35.50);
        assertThat(result.getStartDate()).isEqualTo("2020-06-14T00:00:00");
        assertThat(result.getEndDate()).isEqualTo("2020-12-31T23:59:59");
    }

    @Test
    public void obtainSearchProductsTest4(){
        var response = productController.getStudent("2020-06-15T10.00.00",35455, 1);
        ProductEntity result = response.block();
        assertThat(result).isNotNull();
        assertThat(result.getBrandId()).isEqualTo(1);
        assertThat(result.getProductId()).isEqualTo(35455);
        assertThat(result.getPriceList()).isEqualTo(3);
        assertThat(result.getPrice()).isEqualTo(30.50);
        assertThat(result.getStartDate()).isEqualTo("2020-06-15T00:00:00");
        assertThat(result.getEndDate()).isEqualTo("2020-06-15T11:00:00");
    }

    @Test
    public void obtainSearchProductsTest5(){
        var response = productController.getStudent("2020-06-16T21.00.00",35455, 1);
        ProductEntity result = response.block();

        assertThat(result).isNotNull();
        assertThat(result.getBrandId()).isEqualTo(1);
        assertThat(result.getProductId()).isEqualTo(35455);
        assertThat(result.getPriceList()).isEqualTo(4);
        assertThat(result.getPrice()).isEqualTo(38.95);
        assertThat(result.getStartDate()).isEqualTo("2020-06-15T16:00:00");
        assertThat(result.getEndDate()).isEqualTo("2020-12-31T23:59:59");
    }
}