package h2demo.service;


import h2demo.model.ProductEntity;
import reactor.core.publisher.Mono;

public interface FindProductService {

    Mono<ProductEntity> findProductByParameters(Integer brandId, Integer productId, String date);
}
