package com.example.xmlmanipulatorapi.xpath.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.File;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "xpathDocument")
public class Xpath {

    private File file;

}
