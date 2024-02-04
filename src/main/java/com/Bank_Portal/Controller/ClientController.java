package com.Bank_Portal.Controller;

import ch.qos.logback.core.model.Model;
import com.Bank_Portal.Entity.Image;
import com.Bank_Portal.Service.ImageServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ImageServiceImpl imageService;

    // display image
    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id")Long id) throws IOException, SQLException{
        Image image = imageService.viewById(id);
        byte[] imageBytes=null;
        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
//       .body(imageBytes);
    }

    // view All images
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        List<Image> imageList = imageService.viewAll();
        mv.addObject("imageList", imageList);
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView addImage(){
        return new ModelAndView("addimage");
    }

    // add image - post
    @PostMapping("/add")
    public String addImagePost(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Image image = new Image();
        image.setImage(blob);
        imageService.create(image);
        return "redirect:/";
    }
    @GetMapping("/deleteimage/{id}")
    public String deleteImage(@PathVariable("id")Long id){
        imageService.deleteImage(id);
        return "redirect:/";
    }
    @PutMapping("/updateimage/{id}")
    public String up(@PathVariable("id")Long id,MultipartFile file, @RequestParam("image")  SerialException SQLException, Model model) throws IOException, SQLException {
        Image image = imageService.viewById(id);
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        image.setImage(blob);
        imageService.create(image);
        return "redirect:/";
    }
}

