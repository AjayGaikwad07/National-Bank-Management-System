package com.Bank_Portal.Service;




import com.Bank_Portal.Entity.Image;
import com.Bank_Portal.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void create(Image image) {
        imageRepository.save(image);
    }

    @Override
    public List<Image> viewAll() {
        return(List<Image>) imageRepository.findAll();
    }

    @Override
    public Image viewById(long id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public void deleteImage(@PathVariable("id") Long id) {
        imageRepository.deleteById(id);
    }


}

