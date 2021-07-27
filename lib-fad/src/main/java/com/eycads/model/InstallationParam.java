package com.eycads.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "InstallationParam")
@XmlType(name = "InstallationParam")
@XmlAccessorType(XmlAccessType.FIELD)
public class InstallationParam implements Serializable {

  @JsonbProperty("latitude")
  private Double latitude;

  @JsonbProperty("longitude")
  private Double longitude;

  @JsonbProperty("height")
  private Double height;

  @JsonbProperty("heightType")
  private String heightType;

  @JsonbProperty("antennaAzimuth")
  private Integer antennaAzimuth;

  @JsonbProperty("azimuthRadiationPattern")
  private List<AzimuthRadiationPattern> azimuthRadiationPattern;

}
