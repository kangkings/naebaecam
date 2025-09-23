package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByUser(User user, Pageable pageable);

    //모든 기준은 해당 Repository에 지정한 엔티티기준
    //findAll -> Product전부 조회
    //By -> where
    //User -> Product 엔티티에 연관관계 맺어진 User 엔티티와 비교 (넘겨받은 User와 일치하는 Product만 조회)
    //And -> And
    //ProductFolderList -> Product 엔티티 내부에 productFolderList와 비교
    //_ -> 해당 연관관계 내부로 한번 더 들어감
    //FolderId ->연관된 엔티티 내부의 특정 필드
    List<Product> findAllByUserAndProductFolderList_FolderId(User user, Long folderId, Pageable pageable);
}
