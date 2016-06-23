/*
 * Copyright (c) 2012. JSpringBot. All Rights Reserved.
 *
 * See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The JSpringBot licenses this file to You under the Apache License, Version 2.0
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

package org.jspringbot.keyword.test.data;

import org.jspringbot.KeywordInfo;
import org.springframework.stereotype.Component;

@Component
@KeywordInfo(name = "Get Test Data Header By Index",
        parameters = {"index", "columnIndex"},
        description = "Get Test Data Header By Index. \n\n" +
                      "Sample test data csv: \n" +
                      "| URL      | PARAM NAME | PARAM VALUE | \n" +
                      "| ${url_1} | id         | 1           | \n" +
                      "| ${url_2} | name       | value       | \n" +
                      "Sample usage: \n\n" +
                      "|          |                               |   |   | *Returns* | \n" +
                      "| ${value} | Get Test Data Header By Index | 1 | 0 | ${url_2}  | \n" +
                      "Since index 1 is \n\n" +
                      "| ${url_2} | name       | value       |\n" +
                      "and columnIndex 0 is ${url_2} \n\n" +
                      "See `Get Test Data Header By Name`, `Introduction`")
public class GetTestDataHeaderByIndex extends AbstractTestDataKeyword {

    @Override
    public Object execute(Object[] params) {
        return helper.getHeaderByIndex(Integer.parseInt(String.valueOf(params[0])), Integer.parseInt(String.valueOf(params[1])));
    }
}
