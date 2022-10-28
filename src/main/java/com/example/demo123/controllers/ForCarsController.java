package com.example.demo123.controllers;

import com.example.demo123.models.ItemModel;
import com.example.demo123.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.example.demo123.enums.Type.ForCars;

@Controller
@RequestMapping("/forCars")
public class ForCarsController {
    @Autowired
    ItemRepo itemRepo;

    @GetMapping
    public String getPage(Model model){
        List<ItemModel> list = (List<ItemModel>) itemRepo.findAllByType(ForCars);

        model.addAttribute("cars", list);
        return "forCars";
    }
}
