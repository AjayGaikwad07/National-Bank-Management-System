package com.Bank_Portal.Repository;


import com.Bank_Portal.Entity.PdfDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfDocumentRepository extends JpaRepository<PdfDocument, Long> {

}
