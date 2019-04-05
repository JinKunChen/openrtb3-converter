package net.media.openrtb3;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Request {

  private static final Integer DEFAULT_WSEAT = 1;

  @NotEmpty
  private String id;
  private Integer test;
  private Integer tmax;
  private Integer at;
  private Collection<String> cur = new ArrayList<String>(){{add("USD");}};
  private Collection<String> seat;
  private Integer wseat = DEFAULT_WSEAT;
  private String cdata;
  @NotNull
  @Valid
  private Source source;
  @NotNull
  @Valid
  private Collection<Item> item;
  @JsonProperty("package")
  private Integer pack;
  @NotNull
  @Valid
  private Context context;
  private Map<String, Object> ext;

  public @NotEmpty String getId() {
    return this.id;
  }

  public Integer getTest() {
    return this.test;
  }

  public Integer getTmax() {
    return this.tmax;
  }

  public Integer getAt() {
    return this.at;
  }

  public Collection<String> getCur() {
    return this.cur;
  }

  public Collection<String> getSeat() {
    return this.seat;
  }

  public Integer getWseat() {
    return this.wseat;
  }

  public String getCdata() {
    return this.cdata;
  }

  public @NotNull @Valid Source getSource() {
    return this.source;
  }

  public @NotNull @Valid Collection<Item> getItem() {
    return this.item;
  }

  public Integer getPack() {
    return this.pack;
  }

  public @NotNull @Valid Context getContext() {
    return this.context;
  }

  public Map<String, Object> getExt() {
    return this.ext;
  }

  public void setId(@NotEmpty String id) {
    this.id = id;
  }

  public void setTest(Integer test) {
    this.test = test;
  }

  public void setTmax(Integer tmax) {
    this.tmax = tmax;
  }

  public void setAt(Integer at) {
    this.at = at;
  }

  public void setCur(Collection<String> cur) {
    this.cur = cur;
  }

  public void setSeat(Collection<String> seat) {
    this.seat = seat;
  }

  public void setWseat(Integer wseat) {
    this.wseat = wseat;
  }

  public void setCdata(String cdata) {
    this.cdata = cdata;
  }

  public void setSource(@NotNull @Valid Source source) {
    this.source = source;
  }

  public void setItem(@NotNull @Valid Collection<Item> item) {
    this.item = item;
  }

  public void setPack(Integer pack) {
    this.pack = pack;
  }

  public void setContext(@NotNull @Valid Context context) {
    this.context = context;
  }

  public void setExt(Map<String, Object> ext) {
    this.ext = ext;
  }
}