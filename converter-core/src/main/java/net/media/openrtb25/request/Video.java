package net.media.openrtb25.request;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

public class Video {


  @NotEmpty
  private Collection<String> mimes;

  private Integer minduration;

  private Integer maxduration;

  private Collection<Integer> protocols;

  private Integer w;

  private Integer h;

  private Integer startdelay;

  private Integer linearity;

  private Integer skip;

  private Integer placement;

  private Integer skipmin;

  private Integer skipafter;

  private Integer sequence;

  private Collection<Integer> battr;

  private Integer maxextended;

  private Integer minbitrate;

  private Integer maxbitrate;

  private Integer boxingallowed;

  private Collection<Integer> playbackmethod;

  private Integer playbackend;

  private Collection<Integer> delivery;

  private Integer pos;

  private Collection<Banner> companionad;

  private Collection<Integer> api;

  private Collection<Integer> companiontype;

  private Map<String, Object> ext;

  public @NotEmpty Collection<String> getMimes() {
    return this.mimes;
  }

  public Integer getMinduration() {
    return this.minduration;
  }

  public Integer getMaxduration() {
    return this.maxduration;
  }

  public Collection<Integer> getProtocols() {
    return this.protocols;
  }

  public Integer getW() {
    return this.w;
  }

  public Integer getH() {
    return this.h;
  }

  public Integer getStartdelay() {
    return this.startdelay;
  }

  public Integer getLinearity() {
    return this.linearity;
  }

  public Integer getSkip() {
    return this.skip;
  }

  public Integer getPlacement() {
    return this.placement;
  }

  public Integer getSkipmin() {
    return this.skipmin;
  }

  public Integer getSkipafter() {
    return this.skipafter;
  }

  public Integer getSequence() {
    return this.sequence;
  }

  public Collection<Integer> getBattr() {
    return this.battr;
  }

  public Integer getMaxextended() {
    return this.maxextended;
  }

  public Integer getMinbitrate() {
    return this.minbitrate;
  }

  public Integer getMaxbitrate() {
    return this.maxbitrate;
  }

  public Integer getBoxingallowed() {
    return this.boxingallowed;
  }

  public Collection<Integer> getPlaybackmethod() {
    return this.playbackmethod;
  }

  public Integer getPlaybackend() {
    return this.playbackend;
  }

  public Collection<Integer> getDelivery() {
    return this.delivery;
  }

  public Integer getPos() {
    return this.pos;
  }

  public Collection<Banner> getCompanionad() {
    return this.companionad;
  }

  public Collection<Integer> getApi() {
    return this.api;
  }

  public Collection<Integer> getCompaniontype() {
    return this.companiontype;
  }

  public Map<String, Object> getExt() {
    return this.ext;
  }

  public void setMimes(@NotEmpty Collection<String> mimes) {
    this.mimes = mimes;
  }

  public void setMinduration(Integer minduration) {
    this.minduration = minduration;
  }

  public void setMaxduration(Integer maxduration) {
    this.maxduration = maxduration;
  }

  public void setProtocols(Collection<Integer> protocols) {
    this.protocols = protocols;
  }

  public void setW(Integer w) {
    this.w = w;
  }

  public void setH(Integer h) {
    this.h = h;
  }

  public void setStartdelay(Integer startdelay) {
    this.startdelay = startdelay;
  }

  public void setLinearity(Integer linearity) {
    this.linearity = linearity;
  }

  public void setSkip(Integer skip) {
    this.skip = skip;
  }

  public void setPlacement(Integer placement) {
    this.placement = placement;
  }

  public void setSkipmin(Integer skipmin) {
    this.skipmin = skipmin;
  }

  public void setSkipafter(Integer skipafter) {
    this.skipafter = skipafter;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  public void setBattr(Collection<Integer> battr) {
    this.battr = battr;
  }

  public void setMaxextended(Integer maxextended) {
    this.maxextended = maxextended;
  }

  public void setMinbitrate(Integer minbitrate) {
    this.minbitrate = minbitrate;
  }

  public void setMaxbitrate(Integer maxbitrate) {
    this.maxbitrate = maxbitrate;
  }

  public void setBoxingallowed(Integer boxingallowed) {
    this.boxingallowed = boxingallowed;
  }

  public void setPlaybackmethod(Collection<Integer> playbackmethod) {
    this.playbackmethod = playbackmethod;
  }

  public void setPlaybackend(Integer playbackend) {
    this.playbackend = playbackend;
  }

  public void setDelivery(Collection<Integer> delivery) {
    this.delivery = delivery;
  }

  public void setPos(Integer pos) {
    this.pos = pos;
  }

  public void setCompanionad(Collection<Banner> companionad) {
    this.companionad = companionad;
  }

  public void setApi(Collection<Integer> api) {
    this.api = api;
  }

  public void setCompaniontype(Collection<Integer> companiontype) {
    this.companiontype = companiontype;
  }

  public void setExt(Map<String, Object> ext) {
    this.ext = ext;
  }
}