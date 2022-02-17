/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.metastorage.common.command;

import org.apache.ignite.raft.client.Command;

/**
 * Represents invoke command with nested conditions and execution branches.
 */
public class MultiInvokeCommand implements Command {
    /** If statement to invoke. */
    private final IfInfo iif;

    /**
     * Constructs new multi-invoke command.
     *
     * @param iif if statement.
     */
    public MultiInvokeCommand(IfInfo iif) {
        this.iif = iif;
    }

    /**
     * Returns if statement.
     *
     * @return if statement.
     */
    public IfInfo iif() {
        return iif;
    }
}