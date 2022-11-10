package h2demo.controller;

import h2demo.model.ProductEntity;
import h2demo.service.FindProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {



    private final FindProductService findProductService;

    public ProductController(FindProductService findProductService) {
        this.findProductService = findProductService;
    }

    @GetMapping("/product")
    public Mono<ProductEntity> getStudent(@RequestParam("date") String date,
                                           @RequestParam("productId") Integer productId,
                                           @RequestParam("brandId") Integer brandId){
        return findProductService.findProductByParameters(brandId, productId, date);
    }
}
