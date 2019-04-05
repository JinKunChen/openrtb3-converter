package net.media.converters.response30toresponse25;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.media.driver.Conversion;
import net.media.exceptions.OpenRtbConverterException;
import net.media.config.Config;
import net.media.converters.Converter;
import net.media.enums.AdType;
import net.media.openrtb25.response.Bid;
import net.media.openrtb25.response.nativeresponse.NativeResponse;
import net.media.openrtb3.Display;
import net.media.openrtb3.Native;
import net.media.template.MacroMapper;
import net.media.utils.JacksonObjectMapper;
import net.media.utils.Provider;
import net.media.utils.Utils;

import java.io.IOException;
import java.util.HashMap;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class DisplayToBidConverter implements Converter<Display,Bid> {

  public Bid map(Display source, Config config, Provider converterProvider) throws OpenRtbConverterException {
    if(isNull(source) || isNull(config))
      return  null;
    Bid  bid = new Bid();
    enhance(source,bid,config, converterProvider);
    return bid;
  }

  public  void enhance(Display source, Bid target, Config config, Provider converterProvider) throws OpenRtbConverterException {
    Converter<Native, NativeResponse> nativeBidConverter = converterProvider.fetch(new Conversion<>
      (Native.class, NativeResponse.class));

    if(isNull(source) || isNull(target) || isNull(config))
      return ;

    ObjectMapper mapper = Utils.getMapper();
    target.setH(source.getH());
    target.setW(source.getW());
    target.setWratio(source.getWratio());
    target.setHratio(source.getHratio());
    if(nonNull(source.getApi())  && source.getApi().size()>0)
      target.setApi(source.getApi().iterator().next());
    if(isNull(target.getExt())){
      target.setExt(new HashMap<>());
    }
    target.getExt().put("ctype",source.getCtype());

    target.getExt().put("priv",source.getPriv());
    target.getExt().put("curl",source.getCurl());
    if (isEmpty(target.getNurl())) {
      target.setNurl(source.getCurl());
    }
    target.getExt().put("event",source.getEvent());
    target.getExt().put("mime",source.getMime());
    if(nonNull(source.getExt()))
      target.getExt().putAll(source.getExt());

    if (config.getAdType(target.getId()) == AdType.NATIVE) {
      target.getExt().put("native",source.get_native());
      if (nonNull(source.get_native())) {
        NativeResponse _native = nativeBidConverter.map(source.get_native(),config, converterProvider);
        if(config.getNativeResponseAsString()){
          try {
            target.setAdm(JacksonObjectMapper.getMapper().writeValueAsString(_native));
          }catch (IOException e){
            throw new  OpenRtbConverterException("error occured while  serializing native response",e);
          }
        }else
          target.setAdm(_native);
      }
      else if (nonNull(source.getAdm())){
        try {
          Native native3 = null;
          if(source.getAdm() instanceof String){
            native3 = mapper.readValue((String) source.getAdm(), Native.class);
          }
          else
          {
            native3 = mapper.convertValue(source.getAdm(), Native.class);
          }
          NativeResponse _native = nativeBidConverter.map(native3,config, converterProvider);
          target.setAdm(_native);
        } catch (IOException e) {
          throw new OpenRtbConverterException("error occured while mapping native object", e);
        }
      }
    }
    else {
      target.getExt().put("banner",source.getBanner());
      if (nonNull(source.getAdm())){
        target.setAdm(source.getAdm());
      }
    }

  }
}