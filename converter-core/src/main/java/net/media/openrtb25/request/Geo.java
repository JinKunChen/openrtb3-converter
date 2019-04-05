package net.media.openrtb25.request;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static java.util.Objects.isNull;


public class Geo {
  private Integer type;
  private String region;
  private String regionfips104;
  private String metro;
  private String city;
  private String zip;
  private Integer utcoffset;
  private String country;
  private Float lat;
  private Float lon;
  private Integer accuracy;
  private Integer lastfix;
  private Integer ipservice;
  private Map<String, Object> ext;

  public Geo() {
  }

  public Integer getType() {
    return this.type;
  }

  public String getRegion() {
    return this.region;
  }

  public String getRegionfips104() {
    return this.regionfips104;
  }

  public String getMetro() {
    return this.metro;
  }

  public String getCity() {
    return this.city;
  }

  public String getZip() {
    return this.zip;
  }

  public Integer getUtcoffset() {
    return this.utcoffset;
  }

  public String getCountry() {
    return this.country;
  }

  public Float getLat() {
    return this.lat;
  }

  public Float getLon() {
    return this.lon;
  }

  public Integer getAccuracy() {
    return this.accuracy;
  }

  public Integer getLastfix() {
    return this.lastfix;
  }

  public Integer getIpservice() {
    return this.ipservice;
  }

  public Map<String, Object> getExt() {
    return this.ext;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public void setRegionfips104(String regionfips104) {
    this.regionfips104 = regionfips104;
  }

  public void setMetro(String metro) {
    this.metro = metro;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public void setUtcoffset(Integer utcoffset) {
    this.utcoffset = utcoffset;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setLat(Float lat) {
    this.lat = lat;
  }

  public void setLon(Float lon) {
    this.lon = lon;
  }

  public void setAccuracy(Integer accuracy) {
    this.accuracy = accuracy;
  }

  public void setLastfix(Integer lastfix) {
    this.lastfix = lastfix;
  }

  public void setIpservice(Integer ipservice) {
    this.ipservice = ipservice;
  }

  public void setExt(Map<String, Object> ext) {
    this.ext = ext;
  }

  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Geo)) return false;
    final Geo other = (Geo) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$type = this.getType();
    final Object other$type = other.getType();
    if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
    final Object this$region = this.getRegion();
    final Object other$region = other.getRegion();
    if (this$region == null ? other$region != null : !this$region.equals(other$region))
      return false;
    final Object this$regionfips104 = this.getRegionfips104();
    final Object other$regionfips104 = other.getRegionfips104();
    if (this$regionfips104 == null ? other$regionfips104 != null : !this$regionfips104.equals(other$regionfips104))
      return false;
    final Object this$metro = this.getMetro();
    final Object other$metro = other.getMetro();
    if (this$metro == null ? other$metro != null : !this$metro.equals(other$metro)) return false;
    final Object this$city = this.getCity();
    final Object other$city = other.getCity();
    if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
    final Object this$zip = this.getZip();
    final Object other$zip = other.getZip();
    if (this$zip == null ? other$zip != null : !this$zip.equals(other$zip)) return false;
    final Object this$utcoffset = this.getUtcoffset();
    final Object other$utcoffset = other.getUtcoffset();
    if (this$utcoffset == null ? other$utcoffset != null : !this$utcoffset.equals(other$utcoffset))
      return false;
    final Object this$country = this.getCountry();
    final Object other$country = other.getCountry();
    if (this$country == null ? other$country != null : !this$country.equals(other$country))
      return false;
    final Object this$lat = this.getLat();
    final Object other$lat = other.getLat();
    if (this$lat == null ? other$lat != null : !this$lat.equals(other$lat)) return false;
    final Object this$lon = this.getLon();
    final Object other$lon = other.getLon();
    if (this$lon == null ? other$lon != null : !this$lon.equals(other$lon)) return false;
    final Object this$accuracy = this.getAccuracy();
    final Object other$accuracy = other.getAccuracy();
    if (this$accuracy == null ? other$accuracy != null : !this$accuracy.equals(other$accuracy))
      return false;
    final Object this$lastfix = this.getLastfix();
    final Object other$lastfix = other.getLastfix();
    if (this$lastfix == null ? other$lastfix != null : !this$lastfix.equals(other$lastfix))
      return false;
    final Object this$ipservice = this.getIpservice();
    final Object other$ipservice = other.getIpservice();
    if (this$ipservice == null ? other$ipservice != null : !this$ipservice.equals(other$ipservice))
      return false;
    final Object this$ext = this.getExt();
    final Object other$ext = other.getExt();
    if (this$ext == null ? other$ext != null : !this$ext.equals(other$ext)) return false;
    return true;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $type = this.getType();
    result = result * PRIME + ($type == null ? 43 : $type.hashCode());
    final Object $region = this.getRegion();
    result = result * PRIME + ($region == null ? 43 : $region.hashCode());
    final Object $regionfips104 = this.getRegionfips104();
    result = result * PRIME + ($regionfips104 == null ? 43 : $regionfips104.hashCode());
    final Object $metro = this.getMetro();
    result = result * PRIME + ($metro == null ? 43 : $metro.hashCode());
    final Object $city = this.getCity();
    result = result * PRIME + ($city == null ? 43 : $city.hashCode());
    final Object $zip = this.getZip();
    result = result * PRIME + ($zip == null ? 43 : $zip.hashCode());
    final Object $utcoffset = this.getUtcoffset();
    result = result * PRIME + ($utcoffset == null ? 43 : $utcoffset.hashCode());
    final Object $country = this.getCountry();
    result = result * PRIME + ($country == null ? 43 : $country.hashCode());
    final Object $lat = this.getLat();
    result = result * PRIME + ($lat == null ? 43 : $lat.hashCode());
    final Object $lon = this.getLon();
    result = result * PRIME + ($lon == null ? 43 : $lon.hashCode());
    final Object $accuracy = this.getAccuracy();
    result = result * PRIME + ($accuracy == null ? 43 : $accuracy.hashCode());
    final Object $lastfix = this.getLastfix();
    result = result * PRIME + ($lastfix == null ? 43 : $lastfix.hashCode());
    final Object $ipservice = this.getIpservice();
    result = result * PRIME + ($ipservice == null ? 43 : $ipservice.hashCode());
    final Object $ext = this.getExt();
    result = result * PRIME + ($ext == null ? 43 : $ext.hashCode());
    return result;
  }

  protected boolean canEqual(Object other) {
    return other instanceof Geo;
  }

  public String toString() {
    return "net.media.openrtb25.request.Geo(type=" + this.getType() + ", region=" + this.getRegion() + ", regionfips104=" + this.getRegionfips104() + ", metro=" + this.getMetro() + ", city=" + this.getCity() + ", zip=" + this.getZip() + ", utcoffset=" + this.getUtcoffset() + ", country=" + this.getCountry() + ", lat=" + this.getLat() + ", lon=" + this.getLon() + ", accuracy=" + this.getAccuracy() + ", lastfix=" + this.getLastfix() + ", ipservice=" + this.getIpservice() + ", ext=" + this.getExt() + ")";
  }
}