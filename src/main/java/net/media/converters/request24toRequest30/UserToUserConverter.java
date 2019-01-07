package net.media.converters.request24toRequest30;

import lombok.AllArgsConstructor;
import net.media.config.Config;
import net.media.converters.Converter;
import net.media.openrtb24.request.Data;
import net.media.openrtb24.request.Geo;
import net.media.openrtb24.request.User;
import net.media.utils.ListToListConverter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UserToUserConverter implements Converter<User, net.media.openrtb3.User> {

  private Converter<Geo, net.media.openrtb3.Geo> geoToGeoConverter;
  private Converter<Data, net.media.openrtb3.Data> dataDataConverter;

  @Override
  public net.media.openrtb3.User map(User source, Config config) {
    if ( source == null ) {
      return null;
    }

    net.media.openrtb3.User user1 = new net.media.openrtb3.User();

    inhance( source, user1, config );

    return user1;
  }

  @Override
  public void inhance(User source, net.media.openrtb3.User target, Config config) {
    if(source == null)
      return;
    target.setId( source.getId() );
    target.setBuyeruid( source.getBuyeruid() );
    target.setYob( source.getYob() );
    target.setGender( source.getGender() );
    target.setKeywords( source.getKeywords() );
    target.setGeo( geoToGeoConverter.map( source.getGeo(), config ) );
    target.setData( ListToListConverter.convert( source.getData(), dataDataConverter, config ) );
    Map<String, Object> map = source.getExt();
    if ( map != null ) {
      target.setExt( new HashMap<String, Object>( map ) );
    }
    if(source.getExt() == null)
      return;
    target.setConsent((String) source.getExt().get("consent"));
    target.getExt().remove("consent");
  }
}
