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

package net.media.converters.request30toRequest24;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.HashMap;
import net.media.config.Config;
import net.media.exceptions.OpenRtbConverterException;
import net.media.openrtb3.Device;
import net.media.utils.CommonConstants;
import net.media.utils.Provider;

/**
 * Created by rajat.go on 03/04/19.
 */
public class DeviceToDeviceConverter
    extends net.media.converters.request30toRequest25.DeviceToDeviceConverter {

  public void enhance(
      Device source,
      net.media.openrtb25.request.Device target,
      Config config,
      Provider converterProvider)
      throws OpenRtbConverterException {
    if (source == null || target == null) {
      return;
    }
    super.enhance(source, target, config, converterProvider);
    if (nonNull(target.getMccmnc())) {
      if (isNull(target.getExt())) {
        target.setExt(new HashMap<>());
      }
      target.getExt().put(CommonConstants.MCCMNC, target.getMccmnc());
      target.setMccmnc(null);
    }
  }
}
