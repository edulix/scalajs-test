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

import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.Event

import scala.scalajs.js.annotation.JSExport

import scala.scalajs.js.JSApp

/**
  * @author Eduardo Robles Elvira &lt;edulix@nvotes.com&gt;
  */
@JSExport
object Main extends JSApp {

  case class Contact(name: Var[String], email: Var[String])

  val data = Vars.empty[Contact]

  @dom
  def table = {
    <div>
      <button
        onclick={ event: Event =>
          data.get += Contact(Var("Eduardo Robles"), Var("edulix@nvotes.com"))
        }
      >
        Add a contact
      </button>
    </div>
    <table border="1" cellPadding="5">
      <thead>
        <tr>
          <th>Name</th>
          <th>E-mail</th>
          <th>Operation</th>
        </tr>
      </thead>
      <tbody>
        {
          for (contact <- data) yield {
            <tr>
              <td>
                {contact.name.each}
              </td>
              <td>
                {contact.email.each}
              </td>
              <td>
                <button
                  onclick={ event: Event =>
                    contact.name := "Modified Name"
                  }
                >
                  Modify the name
                </button>
              </td>
            </tr>
          }
        }
      </tbody>
    </table>
  }

  @JSExport
  def main(): Unit = {
    println("Hello world!")
    dom.render(document.body, table)
  }

}