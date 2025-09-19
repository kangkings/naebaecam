package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {

    //By생략가능
    List<Memo> findAllByOrderByModifiedAtDesc();
    List<Memo> findAllByUsername(String username);

    List<Memo> findAllByContentsContainingOrderByModifiedAtDesc(String keyword);
}
