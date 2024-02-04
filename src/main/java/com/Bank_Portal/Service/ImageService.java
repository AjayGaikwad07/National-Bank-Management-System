package com.Bank_Portal.Service;

import com.Bank_Portal.Entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    void create(Image image);
    List<Image> viewAll();
    Image viewById(long id);
    void deleteImage(Long id);






}

