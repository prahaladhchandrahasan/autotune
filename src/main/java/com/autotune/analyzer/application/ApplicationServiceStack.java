/*******************************************************************************
 * Copyright (c) 2020, 2021 Red Hat, IBM Corporation and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.autotune.analyzer.application;

import com.autotune.analyzer.k8sObjects.AutotuneConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * An ApplicationServiceStack represents a microservice, and can have multiple
 * stack layers on different levels. (runtime, container, framework, etc)
 *
 * application: "petclinic",
 * namespace: "default"
 * serviceStackLayers:
 * -  layer_name: container
 *    layer_level: 0
 *    details: generic container tunables
 *    tunables:
 *    - name: memoryLimit
 *      value_type: double
 *      upper_bound: 300M
 *      lower_bound: 150M
 *      queries:
 *        datasource:
 *        - name: 'prometheus'
 *          query: 'container_memory_working_set_bytes{$CONTAINER_LABEL$="", $POD_LABEL$="$POD$"}'
 *      slo_class:
 *      - response_time
 *      - throughput
 */
public class ApplicationServiceStack
{
	private final String stackName;
	private final String namespace;
	private Map<String, AutotuneConfig> applicationServiceStackLayers;

	public ApplicationServiceStack(String stackName, String namespace) {
		this.stackName = stackName;
		this.namespace = namespace;

		this.applicationServiceStackLayers = new HashMap<>();
	}

	public String getNamespace() {
		return namespace;
	}

	public String getStackName() {
		return stackName;
	}

	public Map<String, AutotuneConfig> getApplicationServiceStackLayers() {
		return applicationServiceStackLayers;
	}

	public void setApplicationServiceStackLayers(Map<String, AutotuneConfig> applicationServiceStackLayers) {
		this.applicationServiceStackLayers = applicationServiceStackLayers;
	}

	@Override
	public String toString() {
		return "ApplicationServiceStack{" +
				"stackName='" + stackName + '\'' +
				", namespace='" + namespace + '\'' +
				", stackLayers=" + applicationServiceStackLayers +
				'}';
	}
}
