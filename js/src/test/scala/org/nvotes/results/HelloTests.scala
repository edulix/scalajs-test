// This file is part of nvotes-results.
// Copyright (C) 2016  Agora Voting SL <legal@agoravoting.com>
//
// nvotes-results is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License.
//
// nvotes-results is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with nvotes-results.  If not, see <http://www.gnu.org/licenses/>.

package org.nvotes.results

import utest._

object HelloTests extends TestSuite{
  val tests = this{
    'test1{
      throw new Exception("test1")
    }
    'test2{
      1
    }
    'test3{
      val a = List[Byte](1, 2)
      a(10)
    }
  }
}