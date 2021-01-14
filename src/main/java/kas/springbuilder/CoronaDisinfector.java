/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package kas.springbuilder;

import kas.springbuilder.interfaces.Announcer;
import kas.springbuilder.interfaces.InjectByType;
import kas.springbuilder.interfaces.Policeman;

@Deprecated
public class CoronaDisinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room) {

        announcer.announce("start disinfection, get out!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("disinfection finished");
    }

    private void desinfect(Room room) {
        System.out.println("desinfecting");
    }
}