/**
 * Copyright (C) 2013 all@code-story.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package net.codestory.http;

import net.codestory.http.payload.*;
import net.codestory.http.testhelpers.*;

import org.junit.*;

public class RedirectTest extends AbstractWebServerTest {
  @Test
  public void redirect() {
    server.configure(routes -> routes.
        get("/", Payload.seeOther("/login")).
        get("/login", "LOGIN").
        get("/dynamic/", "Dynamic"));

    get("/").produces("LOGIN");
    get("/section/").produces("text/plain", "Hello index");
    get("/section").produces("text/plain", "Hello index");
    get("/dynamic/").produces("text/html", "Dynamic");
    get("/dynamic").produces("text/html", "Dynamic");
  }
}
