package com.eycads.model;

import com.eycads.constants.FormatConstants;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@XmlRootElement(name = "EscFad")
@XmlType(name = "EscFad")
@XmlAccessorType(XmlAccessType.FIELD)
public class EscFad implements Serializable {

  @JsonbDateFormat(FormatConstants.DATE_DDMMYYYY)
  @JsonbProperty("startTime")
  private ZonedDateTime startTime;

  @JsonbDateFormat(FormatConstants.DATE_DDMMYYYY)
  @JsonbProperty("endTime")
  private ZonedDateTime endTime;

  @JsonbProperty("recordData")
  private List<RecordData> recordData;

}
