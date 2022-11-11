package h2demo.service.impl;

import h2demo.model.ProductEntity;
import h2demo.reporsitory.ProductRepository;
import h2demo.service.FindProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class FindProductServiceImpl implements FindProductService {

    private final ProductRepository productRepository;

    public FindProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Mono<ProductEntity> findProductByParameters(Integer brandId, Integer productId, String date){
        return Mono.just(productRepository.findByBrandIdAndProductIdAndDate(brandId,productId,date))
                .doOnNext(productEntity -> {
                    productEntity.setStartDate(productEntity.getStartDate().replace(" ", "T"));
                    productEntity.setEndDate(productEntity.getEndDate().replace(" ", "T"));
                })
                .onErrorResume(e ->{
                    log.error("Error trying to find details from productId ({})", productId, e);
                    return Mono.error(new RuntimeException("Error500"));
                });
    }
}
