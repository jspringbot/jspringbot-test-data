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
@KeywordInfo(name = "Get Test Data Content By Name",
        description = "Get Test Data Content By Name. \n\n" +
                      "Sample test data csv: \n" +
                      "| URL      | JSON PATH | EXPECTED VALUE |                     | \n" +
                      "| ${url_1} |           |                | # <- index 0        | \n" +
                      "|          | status    | ok             | # <- contentIndex 0 | \n" +
                      "|          | message   | success        | # <- contentIndex 1 | \n" +
                      "| ${url_2} |           |                | # <- index 1        | \n" +
                      "|          | status    | done           | # <- contentIndex 0 | \n" +
                      "|          | message   | completed      | # <- contentIndex 1 | \n" +
                      "Sample usage: \n" +
                      "|          |                               |   |   |                | *Returns* | \n" +
                      "| ${value} | Get Test Data Content By Name | 1 | 0 | EXPECTED VALUE | done      | \n" +
                      "See `Introduction`",
        parameters = {"index", "contentIndex", "contentColumnName"})
public class GetTestDataContentByName extends AbstractTestDataKeyword {

    @Override
    public Object execute(Object[] params) {
        return helper.getContentByName(Integer.parseInt(String.valueOf(params[0])), Integer.parseInt(String.valueOf(params[1])), String.valueOf(params[2]));
    }
}
