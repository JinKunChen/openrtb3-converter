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

package net.media.converters.request23toRequest30;

import static java.util.Objects.nonNull;

import com.fasterxml.jackson.databind.JavaType;
import java.util.Collection;
import net.media.config.Config;
import net.media.exceptions.OpenRtbConverterException;
import net.media.openrtb25.request.Banner;
import net.media.openrtb25.request.Format;
import net.media.openrtb3.DisplayPlacement;
import net.media.utils.CommonConstants;
import net.media.utils.JacksonObjectMapperUtils;
import net.media.utils.Provider;

/**
 * Created by rajat.go on 03/04/19.
 */
public class BannerToDisplayPlacementConverter
    extends net.media.converters.request25toRequest30.BannerToDisplayPlacementConverter {

  private static final JavaType javaTypeForFormatCollection = JacksonObjectMapperUtils.getMapper()
      .getTypeFactory()
      .constructCollectionType(Collection.class, Format.class);

  public void enhance(
      Banner banner, DisplayPlacement displayPlacement, Config config, Provider converterProvider)
      throws OpenRtbConverterException {
    if (banner == null || displayPlacement == null) {
      return;
    }
    if (nonNull(banner.getExt())) {
      if (banner.getExt().containsKey(CommonConstants.VCM)) {
        banner.setVcm((Integer) banner.getExt().get(CommonConstants.VCM));
        banner.getExt().remove(CommonConstants.VCM);
      }
      if (banner.getExt().containsKey(CommonConstants.FORMAT)) {
        try {
          banner.setFormat(JacksonObjectMapperUtils.getMapper()
              .convertValue(banner.getExt().get(CommonConstants.FORMAT),
                  javaTypeForFormatCollection));
        } catch (Exception e) {
          throw new OpenRtbConverterException(
              "Error in setting banner.format from banner.ext" + ".format", e);
        }
        banner.getExt().remove(CommonConstants.FORMAT);
      }
    }
    super.enhance(banner, displayPlacement, config, converterProvider);
  }
}
