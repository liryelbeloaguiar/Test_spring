package com.belt.Test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belt.Test.model.TestModel;
import com.belt.Test.repository.TestRepository;

@Service
public class TestService {
    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<TestModel> create(TestModel testModel) {
        testRepository.save(testModel);
        return list();
    }

    public List<TestModel> list() {
        return testRepository.findAll();
    }

    public List<TestModel> update(TestModel testModel) {
        testRepository.save(testModel);
        return list();
    }

    public TestModel getById(Long id) {
        return testRepository.getById(id);
    }

    public List<TestModel> delete(Long id) {
        testRepository.deleteById(id);
        return list();
    }

}
