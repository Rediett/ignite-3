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

package org.apache.ignite.internal.configuration.tree;

/**
 * An interface for traversing a tree.
 */
public interface TraversableTreeNode {
    /**
     * Accept the visitor.
     *
     * @param key Name of the node retrieved from its holder object.
     * @param visitor Configuration visitor.
     * @param <T> Parameter type of the passed visitor.
     * @return Whatever {@code visitor} returned.
     */
    <T> T accept(String key, ConfigurationVisitor<T> visitor);
}
