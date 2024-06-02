package com.workintech.spring_store.document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "category_log")
public class CategoryLog {
    @Id
    private String id;
    private Long categoryId;
    private String message;
    private Instant creationTime;
}
