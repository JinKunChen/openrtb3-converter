/*
 * Copyright  2019 - present. MEDIA.NET ADVERTISING FZ-LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.media.converters.response25toresponse30;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.media.config.Config;
import net.media.converters.Converter;
import net.media.exceptions.OpenRtbConverterException;
import net.media.openrtb25.response.Bid;
import net.media.openrtb3.Video;
import net.media.utils.CommonConstants;
import net.media.utils.Provider;

/**
 * @author shiva.b
 */
public class BidToVideoConverter implements Converter<Bid, Video> {

  @Override
  public Video map(Bid source, Config config, Provider converterProvider)
      throws OpenRtbConverterException {
    if (source == null) {
      return null;
    }
    Video video = new Video();
    enhance(source, video, config, converterProvider);
    return video;
  }

  @Override
  public void enhance(Bid source, Video target, Config config, Provider converterProvider)
      throws OpenRtbConverterException {
    if (source == null || target == null) {
      return;
    }
    target.setAdm(source.getAdm());
    if (nonNull(source.getApi())) {
      List<Integer> api = new ArrayList<>();
      api.add(source.getApi());
      target.setApi(api);
    }
    target.setCurl(source.getNurl());

    if (nonNull(source.getExt())) {
      Map<String, Object> ext = source.getExt();
      try {
        target.setCtype((Integer) ext.get(CommonConstants.CTYPE));
        source.getExt().remove(CommonConstants.CTYPE);
        target.setDur((Integer) ext.get(CommonConstants.DUR));
        source.getExt().remove(CommonConstants.DUR);
        target.setMime((Collection<String>) ext.get(CommonConstants.MIME));
        source.getExt().remove(CommonConstants.MIME);
      } catch (Exception e) {
        throw new OpenRtbConverterException("error while type casting bid.ext content", e);
      }
    }
  }
}
