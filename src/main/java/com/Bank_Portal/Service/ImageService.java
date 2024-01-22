package com.Bank_Portal.Service;

package com.ImageProject.Service;

import com.ImageProject.Entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    void create(Image image);
    List<Image> viewAll();
    Image viewById(long id);
    void deleteImage(Long id);






}

