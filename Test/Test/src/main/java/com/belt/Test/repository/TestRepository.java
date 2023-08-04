package com.belt.Test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belt.Test.model.TestModel;

public interface TestRepository extends JpaRepository<TestModel, Long> {

}
