/**
 *  Copyright 2012-2015 Nicolas Rémond (@nremond)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.github.nremond

import java.nio.charset.StandardCharsets.UTF_8
import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._


@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class Pbkdf2Benchmark {
  
  private val password = "password".getBytes(UTF_8)
  private val salt = "salty".getBytes(UTF_8)

  @Benchmark
  def pbkdf2_sha256(): Array[Byte] = {
    PBKDF2(password, salt, 20000, 32, "HmacSHA256")
  }

  @Benchmark
  def pbkdf2_sha512(): Array[Byte] = {
    PBKDF2(password, salt, 20000, 32, "HmacSHA512")
  }
}