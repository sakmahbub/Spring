package com.mahbub.webmvccroud.controller;


import com.mahbub.webmvccroud.entity.ImageOptimizer;
import com.mahbub.webmvccroud.entity.Student;
import com.mahbub.webmvccroud.repository.RoleRipo;
import com.mahbub.webmvccroud.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


@Controller
public class HomeController {

    private static String UPLOADER_FOLDER = "src/main/resources/static/images/";
    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private StudentRepo repo;

    @Autowired
    private RoleRipo roleRipo;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "index";

    }

    @GetMapping("/add")
    public String showForm(Student student, Model model) {
        model.addAttribute("roleListHome", this.roleRipo.findAll());
        return "add";
    }

    @PostMapping("/add")
    public String doSave(@Valid Student student, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleListHome", this.roleRipo.findAll());
            return "add";

        }
        student.setRegiDate(new Date());

        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADER_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            student.setFileName("new-" + file.getOriginalFilename());
            student.setFileSize(file.getSize());
            // user.setFile(file.getBytes());
            student.setFilePath("images/" + "new-" + file.getOriginalFilename());
            student.setFileExtension(file.getContentType());
            //////////////////////For Image Upload end/////////////////////
            this.repo.save(student);
            model.addAttribute("student", new Student());
            model.addAttribute("successMsg", "Congratulations! You are old enough to sign up for this site.");
            imageOptimizer.optimizeImage(UPLOADER_FOLDER, file, 0.3f, 100, 100);

            model.addAttribute("roleListHome", this.roleRipo.findAll());

        } catch (Exception e) {
            e.printStackTrace();
        }


//            this.repo.save(student);
//            model.addAttribute("student", new Student());
//            model.addAttribute("msgg", "Congratulations! Data save sucessfully");
        return "redirect:/";
    }





    @GetMapping(value = "/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("roleListHome", this.roleRipo.findAll());
        model.addAttribute("student", this.repo.getOne(id));
        return "edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid Student student, BindingResult bindingResult, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) {
        Student student1 = this.repo.getOne(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("roleListHome", this.roleRipo.findAll());
            return "edit";

        }
        student.setRegiDate(student1.getRegiDate());
        try {
            //////////////////////For Image Upload start /////////////////////
            if(file.getOriginalFilename().length() > 0) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADER_FOLDER + file.getOriginalFilename());

                Files.write(path, bytes);
                student.setFileName("new-" + file.getOriginalFilename());
                student.setFileSize(file.getSize());
                // user.setFile(file.getBytes());
                student.setFilePath("images/" + "new-" + file.getOriginalFilename());
                student.setFileExtension(file.getContentType());
                //////////////////////For Image Upload end/////////////////////
            }else {
               student.setFileName(student1.getFileName());
               student.setFilePath(student1.getFilePath());
               student.setFileSize(student1.getFileSize());
               student.setFileExtension(student1.getFileExtension());

            }

            this.repo.save(student);
            model.addAttribute("student", new Student());
            model.addAttribute("successMsg", "Congratulations! You are old enough to sign up for this site.");
            if(file.getOriginalFilename().length() > 0) {
                imageOptimizer.optimizeImage(UPLOADER_FOLDER, file, 0.3f, 100, 100);
            }
            model.addAttribute("roleListHome", this.roleRipo.findAll());


        } catch (Exception e) {
            e.printStackTrace();
        }


//            this.repo.save(student);
//            model.addAttribute("student", new Student());
//            model.addAttribute("msgg", "Congratulations! Data save sucessfully");
        return "redirect:/";
    }


}
