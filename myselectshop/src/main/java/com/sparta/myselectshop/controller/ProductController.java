package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.security.UserDetailsImpl;
import com.sparta.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto,
                                            @AuthenticationPrincipal UserDetailsImpl userDetails){
        return productService.createProduct(productRequestDto,userDetails.getUser());
    }

    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){
        return productService.updateProduct(id,requestDto);
    }

    @GetMapping("/products")
    public Page<ProductResponseDto> getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                @RequestParam(name = "page") int page,
                                                @RequestParam(name = "size") int size,
                                                @RequestParam(name = "sortBy") String sortBy,
                                                @RequestParam(name = "isAsc") boolean isAsc){
        return productService.getProducts(userDetails.getUser(),
                page-1, size, sortBy, isAsc);
    }

    @PostMapping("/products/{productId}/folder")
    public void addProductFolder(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                 @PathVariable Long productId,
                                 @RequestParam Long folderId){
        productService.addFolder(productId,folderId,userDetails.getUser());
    }
}
