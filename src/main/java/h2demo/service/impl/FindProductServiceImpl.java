package h2demo.service.impl;

import h2demo.model.ProductEntity;
import h2demo.reporsitory.ProductRepository;
import h2demo.service.FindProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@Slf4j
public class FindProductServiceImpl implements FindProductService {

    private final ProductRepository productRepository;

    public FindProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Mono<ProductEntity> findProductByParameters(Integer brandId, Integer productId, String date){
        try {
        return Optional.ofNullable(this.productRepository.findByBrandIdAndProductIdAndDate(brandId,productId,date))
                .map(productEntity -> {
                    productEntity.setStartDate(productEntity.getStartDate().replace(" ", "T"));
                    productEntity.setEndDate(productEntity.getEndDate().replace(" ", "T"));
                    return Mono.just(productEntity);
                }).orElse(Mono.just(new ProductEntity()));
        }catch (Exception e) {
            return Mono.error(e);
        }
    }
}
