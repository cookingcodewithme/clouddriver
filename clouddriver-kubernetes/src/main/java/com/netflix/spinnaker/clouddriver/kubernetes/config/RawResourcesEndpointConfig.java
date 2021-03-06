/*
 * Copyright 2020 Coveo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.netflix.spinnaker.clouddriver.kubernetes.config;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class RawResourcesEndpointConfig {
  private Set<String> kinds = new HashSet<>();
  private Set<String> omitKinds = new HashSet<>();

  public void validate() {
    if (!omitKinds.isEmpty() && !kinds.isEmpty()) {
      throw new IllegalArgumentException("At most one of 'kinds' and 'omitKinds' can be specified");
    }
  }
}
