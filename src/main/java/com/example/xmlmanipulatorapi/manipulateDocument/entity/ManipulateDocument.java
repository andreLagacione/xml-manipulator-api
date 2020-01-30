package com.example.xmlmanipulatorapi.manipulateDocument.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "editedDocument")
public class ManipulateDocument {

    private String editedDocument;

}
