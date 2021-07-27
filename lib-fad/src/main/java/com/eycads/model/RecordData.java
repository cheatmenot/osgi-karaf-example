package com.eycads.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "RecordData")
@XmlType(name = "RecordData")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecordData implements Serializable {

  @JsonbProperty("id")
  private String id;

  @JsonbProperty("installationParam")
  private InstallationParam installationParam;

}
