package net.media.converters.request30toRequest24;

import lombok.AllArgsConstructor;
import net.media.config.Config;
import net.media.converters.Converter;
import net.media.openrtb3.Data;
import net.media.openrtb3.Geo;
import net.media.openrtb3.User;
import net.media.utils.ListToListConverter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UserToUserConverter implements Converter<User, net.media.openrtb24.request.User> {

  private Converter<Geo, net.media.openrtb24.request.Geo> geoGeoConverter;
  private Converter<Data, net.media.openrtb24.request.Data> dataDataConverter;

  @Override
  public net.media.openrtb24.request.User map(User source, Config config) {
    if ( source == null ) {
      return null;
    }

    net.media.openrtb24.request.User user1 = new net.media.openrtb24.request.User();

    inhance( source, user1, config );

    return user1;
  }

  @Override
  public void inhance(User source, net.media.openrtb24.request.User target, Config config) {
    if(source == null)
      return;
    target.setId( source.getId() );
    target.setBuyeruid( source.getBuyeruid() );
    target.setYob( source.getYob() );
    target.setGender( source.getGender() );
    target.setGeo( geoGeoConverter.map( source.getGeo(), config ) );
    target.setKeywords( source.getKeywords() );
    target.setData( ListToListConverter.convert( source.getData(), dataDataConverter, config ) );
    Map<String, Object> map = source.getExt();
    if ( map != null ) {
      target.setExt( new HashMap<String, Object>( map ) );
    }
    if(source.getConsent() != null) {
      if(target.getExt() == null)
        target.setExt(new HashMap<>());
      target.getExt().put("consent", source.getConsent());
    }
  }
}
