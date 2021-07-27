package com.eycads.utils;

import ch.keybridge.json.JsonbUtility;
import com.eycads.model.EscFad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class EscFadJsonConversion {

  public EscFad jsonStringToEscFad(String json){
    return new JsonbUtility().unmarshal(json, EscFad.class);
  }

  public void jsonStringToValidJsonFile(String json, File file){
    EscFad form = jsonStringToEscFad(json);
    String jsonString = new JsonbUtility().marshal(form);
    try (FileOutputStream fis = new FileOutputStream(file);
         OutputStreamWriter osw = new OutputStreamWriter(fis, StandardCharsets.UTF_8);
         Writer out = new BufferedWriter(osw)) {
      out.write(jsonString.replaceFirst("\n", "")
          .replace("    ", "  "));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
