package com.example.demo123.controllers;

import com.example.demo123.enums.Type;
import com.example.demo123.models.ItemModel;
import com.example.demo123.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;															  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/autos")
public class AutosController {
	@Autowired		  
    ItemRepo itemRepo;

@PostMapping
    public String setData(@RequestParam int n1,
                          @RequestParam int n2,
                          @RequestParam int n3,
                          @RequestParam int n4,
                          Model model){
        List<ItemModel> list = (List<ItemModel>) itemRepo.findAllByType(Type.Car);
        list = list.stream().filter(c -> Integer.parseInt(c.getPrice())>= n1
        && Integer.parseInt(c.getPrice())<= n2
                && Integer.parseInt(c.getDisc())>= n3
                && Integer.parseInt(c.getDisc())<= n4) .collect(Collectors.toList());
        model.addAttribute("cars", list);

        return "autos";
    }
    @GetMapping
    public String getPage(Model model){

        List<ItemModel> list = (List<ItemModel>) itemRepo.findAllByType(Type.Car);
        

        model.addAttribute("cars", list);
        return "autos";
    }
}
