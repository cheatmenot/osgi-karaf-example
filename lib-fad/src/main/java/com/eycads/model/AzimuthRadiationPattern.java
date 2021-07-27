package com.eycads.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "AzimuthRadiationPattern")
@XmlType(name = "AzimuthRadiationPattern")
@XmlAccessorType(XmlAccessType.FIELD)
public class AzimuthRadiationPattern implements Serializable {

  @JsonbProperty("angle")
  private Integer angle;

  @JsonbProperty("gain")
  private Integer gain;
}
