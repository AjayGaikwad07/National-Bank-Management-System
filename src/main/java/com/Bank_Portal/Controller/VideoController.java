package com.Bank_Portal.Controller;

import com.Bank_Portal.Entity.Video;
import com.Bank_Portal.Service.VideoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Controller
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/upload")
    public String showUploadForm() {
        return "video_temp/uploadForm";
    }

    @PostMapping("/upload")
    public String handleFileUpload(HttpServletRequest request,@RequestParam("title") String title,
                                   @RequestParam("id")Long id,Model model,@RequestParam("file") MultipartFile file) throws IOException, SQLException {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Video video = new Video();
        video.setTitle(title);
        video.setFile(blob);
        video.setId(id);
        videoService.saveVideo(video);
        return "redirect:/videos/view";
    }

    @GetMapping("/view")
    public String showAllVideos(Model model) {
        model.addAttribute("videos", videoService.getAllVideos());
        return "video_temp/videoList";
    }

    @GetMapping("/videos/delete/{id}")
    public String deleteVideo(@PathVariable Long id){
        Video video= new Video();
        videoService.deleteVideo(id);
        return "redirect:/videos/view";
    }


}


