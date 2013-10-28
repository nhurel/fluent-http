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
package net.codestory.http.compilers;

import static org.assertj.core.api.Assertions.*;

import java.io.*;
import java.nio.file.*;

import org.junit.*;

public class CoffeeCompilerTest {
  @Test
  public void empty() throws IOException {
    String js = Compiler.compile(Paths.get("empty.coffee"), "");

    assertThat(js).isEqualTo("\n");
  }

  @Test
  public void coffee() throws IOException {
    String js = Compiler.compile(Paths.get("file.coffee"), "life=42");

    assertThat(js).isEqualTo("var life;\n\nlife = 42;\n");
  }
}
