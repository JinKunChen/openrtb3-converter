package net.media.converters.request30toRequest25;

import net.media.config.Config;
import net.media.converters.Converter;
import net.media.driver.Conversion;
import net.media.openrtb3.Geo;
import net.media.utils.Provider;
import net.media.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class GeoToGeoConverter implements Converter<Geo, net.media.openrtb25.request.Geo> {
  @Override
  public net.media.openrtb25.request.Geo map(Geo source, Config config, Provider<Conversion, Converter> converterProvider) {
    if ( source == null ) {
      return null;
    }

    net.media.openrtb25.request.Geo geo1 = new net.media.openrtb25.request.Geo();

    enhance(source, geo1, config, converterProvider );

    return geo1;
  }

  @Override
  public void enhance(Geo source, net.media.openrtb25.request.Geo target, Config config, Provider<Conversion, Converter> converterProvider) {
    if(source == null || target == null)
      return;
    target.setIpservice( source.getIpserv() );
    target.setAccuracy( source.getAccur() );
    target.setType( source.getType() );
    target.setRegion( source.getRegion() );
    target.setMetro( source.getMetro() );
    target.setCity( source.getCity() );
    target.setZip( source.getZip() );
    target.setCountry( source.getCountry() );
    target.setLat( source.getLat() );
    target.setLon( source.getLon() );
    target.setUtcoffset( source.getUtcoffset() );
    target.setLastfix( source.getLastfix() );
    Map<String, Object> map = source.getExt();
    if(map == null)
      return;
    if(source.getExt().containsKey("regionfips104")) {
      target.setRegionfips104((String) source.getExt().get("regionfips104"));
      source.getExt().remove("regionfips104");
    }
    target.setExt( Utils.copyMap(map, config) );
  }
}
