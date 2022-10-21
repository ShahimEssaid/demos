package com.essaid.demos.fhir.r4.demo.one;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.r4.model.CodeSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteCodeSystem {
  
  public static void main(String[] args) throws IOException {
    CodeSystem cs = new CodeSystem();
    cs.addConcept().setCode("hello");
  
    FhirContext context = new FhirContext(FhirVersionEnum.R4);
    IParser iParser = context.newJsonParser();
    iParser.setPrettyPrint(true);
    String s = iParser.encodeResourceToString(cs);
    System.out.println(s);
  
    Files.createDirectories(Path.of("target"));
    iParser.encodeResourceToWriter(cs, new FileWriter("target/cs.json"));
  }
}
