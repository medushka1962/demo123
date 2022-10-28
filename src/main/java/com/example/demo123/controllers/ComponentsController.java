package com.example.demo123.controllers;

import com.example.demo123.enums.Type;
import com.example.demo123.models.ItemModel;
import com.example.demo123.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/components")
public class ComponentsController {
    @Autowired
    ItemRepo itemRepo;

    @GetMapping
    public String getPage(Model model){
        List<ItemModel> list = (List<ItemModel>) itemRepo.findAllByType(Type.Components);

        model.addAttribute("cars", list);
        return "components";
    }


}
