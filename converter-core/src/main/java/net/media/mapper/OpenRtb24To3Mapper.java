package net.media.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.media.OpenRtbConverter;
import net.media.OpenRtbConverterException;
import net.media.config.Config;
import net.media.enums.AdType;
import net.media.openrtb25.response.BidResponse;
import net.media.openrtb3.OpenRTB;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.naming.ConfigurationException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class OpenRtb24To3Mapper {

  public static void main(String[] args) {
    try {
      new OpenRtb24To3Mapper().test();
    } catch (IOException e){
      System.out.println("Phatna  hihe"+e.getMessage());
    } catch (ConfigurationException e) {
      e.printStackTrace();
    } catch (OpenRtbConverterException e) {
      e.printStackTrace();
    }
  }

  private void test() throws IOException, OpenRtbConverterException, ConfigurationException {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("25To30Test.json").getFile());
    OpenRtb24To3MapperImpl impl = new OpenRtb24To3MapperImpl(null);
    Config config = new Config();
    config.setBannerTemplate("");
    config.setValidate(false);
    config.setNativeRequestAsString(true);
    config.setAdType(AdType.BANNER);
    OpenRtbConverter openRtbConverter = new OpenRtbConverter(config);

    byte[] jsonData = Files.readAllBytes(file.toPath());
    ObjectMapper objectMapper = new ObjectMapper();

    List<ResponseTestPojo> testList = objectMapper.readValue(jsonData, new
      TypeReference<ArrayList<ResponseTestPojo>>() {});
    long start = System.nanoTime();
    for (int i = 0; i < 1; i++) {
      for (ResponseTestPojo response : testList) {
        AdType adType = null;
        for (AdType adType1 : AdType.values()) {
          if (nonNull(response.getType()) && adType1.name().equals(response.getType())) {
            adType = adType1;
            break;
          }
        }
        if (isNull(adType)) {
          System.out.println("invalid ad type");
          continue;
        }

        config.setAdType(adType);
        try {
//          OpenRTB response30 = openRtbConverter.convert(config, response.getResponse25(), BidResponse
//            .class, OpenRTB.class);
          BidResponse  bidResponse = openRtbConverter.convert(config, response.getResponse30(), OpenRTB.class, BidResponse.class);
//          System.out.println(objectMapper.writeValueAsString(response30));
//          System.out.println(objectMapper.writeValueAsString(response.getResponse25()));
          System.out.println(objectMapper.writeValueAsString(bidResponse));
          System.out.println(objectMapper.writeValueAsString(response.getResponse25()));

        }
        catch (Exception e){
          e.printStackTrace();
        }

        //System.out.println( objectMapper.writeValueAsString(response30));
        //System.out.println( objectMapper.writeValueAsString(response.getResponse30()));
        //System.out.println(response30.equals(response.getResponse30()));

      /*BidResponse response24 = impl.map(response.getResponse30(), adType);
      System.out.println(objectMapper.writeValueAsString(response24));
      System.out.println(objectMapper.writeValueAsString(response.getResponse25()));
      System.out.println(response24.equals(response.getResponse25()));*/
      }
    }
    long end = System.nanoTime();
    System.out.println("Total time : " +  (end - start)/100000);
  }

}
