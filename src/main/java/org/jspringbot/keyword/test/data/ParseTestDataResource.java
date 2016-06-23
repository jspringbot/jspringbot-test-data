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
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceEditor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@KeywordInfo(name = "Parse Test Data Resource",
        parameters = {"resource"},
        description = "Parse Test Data Resource. \n\n" +
                      "Example: \n" +
                      "| Parse Test Data Resource | classpath:simple-test-data.csv | \n" +
                "See `Parse State Test Data Resource`, `Introduction`")
public class ParseTestDataResource extends AbstractTestDataKeyword {

    @Override
    public Object execute(Object[] params) {
        ResourceEditor editor = new ResourceEditor();
        editor.setAsText(String.valueOf(params[0]));

        try {
            helper.parseResource((Resource) editor.getValue());
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("Invalid resource %s.", String.valueOf(params[0])));
        }

        return null;
    }
}
