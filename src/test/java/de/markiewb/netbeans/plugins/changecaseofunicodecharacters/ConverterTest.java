/*
 * Copyright 2014 Benno Markiewicz (benno.markiewicz@googlemail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.markiewb.netbeans.plugins.changecaseofunicodecharacters;

import de.markiewb.netbeans.plugins.changecaseofunicodecharacters.Converter.ConvertMode;
import org.junit.Test;

/**
 *
 * @author markiewb
 */
public class ConverterTest {

    @Test
    public void testConvert_LowerCase() {
        Converter instance = new Converter();
        assert "\\\\u00fc".equals(instance.convert("\\\\u00fc", ConvertMode.LOWERCASE));
        assert "\\\\u00fc".equals(instance.convert("\\\\u00FC", ConvertMode.LOWERCASE));
        assert "\\\\u00fc".equals(instance.convert("\\\\u00fC", ConvertMode.LOWERCASE));
    }

    @Test
    public void testConvert_UpperCase() {
        Converter instance = new Converter();
        assert "\\\\u00FC".equals(instance.convert("\\\\u00fc", ConvertMode.UPPERCASE));
        assert "\\\\u00FC".equals(instance.convert("\\\\u00FC", ConvertMode.UPPERCASE));
        assert "\\\\u00FC".equals(instance.convert("\\\\u00fC", ConvertMode.UPPERCASE));
    }

}
