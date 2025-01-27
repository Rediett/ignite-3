/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.cli.call.metric;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.inject.Inject;
import java.util.List;
import org.apache.ignite.internal.cli.call.CallInitializedIntegrationTestBase;
import org.apache.ignite.internal.cli.call.node.metric.NodeMetricEnableCall;
import org.apache.ignite.internal.cli.call.node.metric.NodeMetricEnableCallInput;
import org.apache.ignite.internal.cli.call.node.metric.NodeMetricListCall;
import org.apache.ignite.internal.cli.core.call.CallOutput;
import org.apache.ignite.internal.cli.core.call.StringCallInput;
import org.apache.ignite.rest.client.model.MetricSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/** Tests for {@link NodeMetricListCall} and {@link NodeMetricEnableCall}. */
class ItMetricCallsTest extends CallInitializedIntegrationTestBase {

    @Inject
    NodeMetricListCall nodeMetricListCall;

    @Inject
    NodeMetricEnableCall nodeMetricEnableCall;

    @Test
    @DisplayName("Should display empty node metric list when cluster is up and running")
    void nodeMetricList() {
        // Given
        var input = new StringCallInput(NODE_URL);

        // When
        CallOutput<List<MetricSource>> output = nodeMetricListCall.execute(input);

        // Then
        assertThat(output.hasError()).isFalse();
        // And
        assertThat(output.body()).isEmpty();
    }

    @Test
    @DisplayName("Should display error message when enabling nonexistent metric source and is cluster up and running")
    void nodeMetricEnable() {
        // Given
        var input = NodeMetricEnableCallInput.builder()
                .endpointUrl(NODE_URL)
                .srcName("no.such.metric")
                .enable(true)
                .build();

        // When
        CallOutput<String> output = nodeMetricEnableCall.execute(input);

        // Then
        assertThat(output.hasError()).isTrue();
    }

    @Test
    @DisplayName("Should display error message when disabling nonexistent metric source and is cluster up and running")
    void nodeMetricDisable() {
        // Given
        var input = NodeMetricEnableCallInput.builder()
                .endpointUrl(NODE_URL)
                .srcName("no.such.metric")
                .enable(false)
                .build();

        // When
        CallOutput<String> output = nodeMetricEnableCall.execute(input);

        // Then
        assertThat(output.hasError()).isTrue();
    }
}
