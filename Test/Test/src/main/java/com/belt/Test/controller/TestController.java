package com.belt.Test.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.belt.Test.model.TestModel;
import com.belt.Test.service.TestService;

import jakarta.validation.Valid;

@Controller
public class TestController {
    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/index")
    public String listar(Model model) {
        List<TestModel> tests1 = testService.list();
        model.addAttribute("tests", tests1);
        return "index";
    }

    @RequestMapping("/cadastro")
    public String getFormCadastro(Model model) {
        TestModel tests0 = new TestModel();
        model.addAttribute("tests0", tests0);
        return "cadastro";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvar(@ModelAttribute @Valid TestModel testModel, Errors errors) {
        if (errors.hasErrors()) {
            // mensagem falando do erro
            return "redirect:/cadastro";
        } else {
            testService.create(testModel);
            return "redirect:/index";
        }
    }

    @RequestMapping("/deletar/{id}")
    public String doDelete(@PathVariable(name = "id") Long id) {
        testService.delete(id);
        return "redirect:/index";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView getFormEdicao(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edicao");
        TestModel testModel = testService.getById(id);
        modelAndView.addObject("tests0", testModel);
        return modelAndView;
    }

}
