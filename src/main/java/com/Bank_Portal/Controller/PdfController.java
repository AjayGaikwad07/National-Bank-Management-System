package com.Bank_Portal.Controller;

import com.Bank_Portal.Entity.PdfDocument;
import com.Bank_Portal.Repository.PdfDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/pdf")
public class PdfController {
    @Autowired
    private PdfDocumentRepository pdfDocumentRepository;

    @GetMapping("/pdf1")
    public String listdocument(Model model){
        model.addAttribute("documents", pdfDocumentRepository.findAll());
        return "Pdf/list";

    }
    @GetMapping("/upload")
    public String uploadForm(){
        return "Pdf/upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file")MultipartFile file)throws IOException{
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.setFileName(file.getOriginalFilename());
        pdfDocument.setData(file.getBytes());
        pdfDocumentRepository.save(pdfDocument);
        return "redirect:/pdf/pdf1";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id){
        PdfDocument document = pdfDocumentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid document Id:" + id));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+document.getFileName())
                .body(document.getData());
    }

    @GetMapping("/view/{id}")
    public String viewPdf(@PathVariable Long id, Model model){
        PdfDocument document = pdfDocumentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid document Id:" + id));

        model.addAttribute("documentId", document.getId());
        return "pdf/viewer";
    }
}


