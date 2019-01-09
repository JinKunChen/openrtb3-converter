package net.media.converters.request30toRequest25;

import net.media.config.Config;
import net.media.converters.Converter;
import net.media.openrtb24.request.Banner;
import net.media.openrtb24.request.Format;
import net.media.openrtb3.DisplayFormat;
import net.media.openrtb3.DisplayPlacement;
import net.media.utils.CollectionUtils;
import net.media.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class DisplayPlacementToBannerConverter implements Converter<DisplayPlacement, Banner> {
  @Override
  public Banner map(DisplayPlacement displayPlacement, Config config) {
    if ( displayPlacement == null ) {
      return null;
    }
    if (nonNull(displayPlacement.getNativefmt())) {
      return null;
    }
    Banner banner = new Banner();
    enhance(displayPlacement, banner, config);
    return banner;
  }

  @Override
  public void enhance(DisplayPlacement displayPlacement, Banner banner, Config config) {
    if (isNull(displayPlacement) || isNull(banner)) {
      return;
    }
    banner.setMimes(Utils.copyList(displayPlacement.getMime(), config));
    banner.setFormat( displayFormatListToFormatList( displayPlacement.getDisplayfmt(), config ) );
    if (nonNull(displayPlacement.getDisplayfmt())) {
      for (DisplayFormat displayFormat : displayPlacement.getDisplayfmt()) {
        if (!CollectionUtils.isEmpty(displayFormat.getExpdir())) {
          List<Integer> formatExpdir = new ArrayList<>(displayFormat.getExpdir());
          if (isNull(banner.getExpdir())) {
            banner.setExpdir(formatExpdir);
          } else {
            banner.setExpdir((List<Integer>) org.apache.commons.collections.CollectionUtils.union
              (banner.getExpdir(), formatExpdir));
          }
        }
      }
    }
    banner.setW( displayPlacement.getW() );
    banner.setH( displayPlacement.getH() );
    banner.setPos( displayPlacement.getPos() );
    banner.setTopframe( displayPlacement.getTopframe() );
    banner.setApi(Utils.copyList(displayPlacement.getApi(), config));
    Map<String, Object> map = displayPlacement.getExt();
    if ( map != null ) {
      banner.setExt(Utils.copyMap(map, config));
      if (map.containsKey("btype")) {
        banner.setBtype(Utils.copyList((List<Integer>) map.get("btype"), config));
        banner.getExt().remove("btype");
      }
    }
    if (nonNull(displayPlacement.getUnit())) {
      if (isNull(banner.getExt())) {
        banner.setExt(new HashMap<>());
      }
      banner.getExt().put("unit", displayPlacement.getUnit());
    }
  }

  private List<Format> displayFormatListToFormatList(List<DisplayFormat> list, Config config) {
    if ( list == null ) {
      return null;
    }

    List<Format> list1 = new ArrayList<Format>( list.size() );
    for ( DisplayFormat displayFormat : list ) {
      list1.add( displayFormatToFormat( displayFormat, config ) );
    }

    return list1;
  }

  private Format displayFormatToFormat(DisplayFormat displayFormat, Config config) {
    if ( displayFormat == null ) {
      return null;
    }

    Format format = new Format();

    format.setW( displayFormat.getW() );
    format.setH( displayFormat.getH() );
    format.setWratio( displayFormat.getWratio() );
    format.setHratio( displayFormat.getHratio() );
    Map<String, Object> map = displayFormat.getExt();
    if ( map != null ) {
      format.setExt(Utils.copyMap(map, config));
      format.setWmin((Integer) map.get("wmin"));
    }

    return format;
  }
}
