package net.media.converters.request25toRequest30;

import net.media.driver.Conversion;
import net.media.exceptions.OpenRtbConverterException;
import net.media.config.Config;
import net.media.converters.Converter;
import net.media.openrtb25.request.Asset;
import net.media.openrtb25.request.Content;
import net.media.openrtb25.request.NativeRequestBody;
import net.media.openrtb3.AssetFormat;
import net.media.openrtb3.NativeFormat;
import net.media.utils.CollectionToCollectionConverter;
import net.media.utils.Provider;
import net.media.utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Created by rajat.go on 03/01/19.
 */

public class NativeRequestBodyToNativeFormatConverter implements Converter<NativeRequestBody,
  NativeFormat> {

  @Override
  public NativeFormat map(NativeRequestBody nativeRequestBody, Config config, Provider converterProvider) throws OpenRtbConverterException {
    if ( nativeRequestBody == null ) {
      return null;
    }
    NativeFormat nativeFormat = new NativeFormat();
    enhance(nativeRequestBody, nativeFormat, config, converterProvider);
    return nativeFormat;
  }

  @Override
  public void enhance(NativeRequestBody nativeRequestBody, NativeFormat nativeFormat, Config
    config, Provider converterProvider) throws OpenRtbConverterException {
    if ( nativeRequestBody == null || nativeFormat == null) {
      return;
    }
    nativeFormat.setExt(Utils.copyMap(nativeRequestBody.getExt(), config));
    if (nonNull(nativeRequestBody.getContextsubtype())) {
      if (isNull(nativeFormat.getExt())) {
        nativeFormat.setExt(new HashMap<>());
      }
      nativeFormat.getExt().put("contextsubtype", nativeRequestBody.getContextsubtype());
    }
    if (nonNull(nativeRequestBody.getAdunit())) {
      if (isNull(nativeFormat.getExt())) {
        nativeFormat.setExt(new HashMap<>());
      }
      nativeFormat.getExt().put("adunit", nativeRequestBody.getAdunit());
    }
    if (nonNull(nativeRequestBody.getLayout())) {
      if (isNull(nativeFormat.getExt())) {
        nativeFormat.setExt(new HashMap<>());
      }
      nativeFormat.getExt().put("layout", nativeRequestBody.getLayout());
    }
    if (nonNull(nativeRequestBody.getVer())) {
      if (isNull(nativeFormat.getExt())) {
        nativeFormat.setExt(new HashMap<>());
      }
      nativeFormat.getExt().put("ver", nativeRequestBody.getVer());
    }
    Converter<Asset, AssetFormat> assetAssetFormatConverter = converterProvider.fetch(new Conversion<>
      (Asset.class, AssetFormat.class));
    nativeFormat.setAsset( CollectionToCollectionConverter.convert( nativeRequestBody.getAssets()
      , assetAssetFormatConverter, config, converterProvider ) );

  }


}