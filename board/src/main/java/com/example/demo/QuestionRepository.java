package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA리파지토리 인터페이스
//  - JPA가 제공하는 인터페이스중 하나
//  - CRUD(Create Read Update Delete) 작업을 처리하는 메서드들이 이미 내장

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
