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

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedOutputStream;
import java.io.IOException;

import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author markiewb
 */
final class Converter
{

    String convert(String text, ConvertMode codeMode)
    {
        Pattern pattern = Pattern.compile("\\\\u(?<code>[A-Za-z0-9]{4})");

        Set<String> allCodes = new HashSet<String>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
        {
            allCodes.add(matcher.group("code"));
        }

        for (String originalCode : allCodes)
        {

            String convertedCode = convertCase(codeMode, originalCode);
            text = text.replaceAll("u" + originalCode, "u" + convertedCode);

        }

        return text;
    }

    private String convertCase(ConvertMode mode, String text) throws AssertionError
    {
        String res;
        switch (mode)
        {
            case UPPERCASE:
                res = text.toUpperCase();
                break;
            case LOWERCASE:
                res = text.toLowerCase();
                break;
            default:
                throw new AssertionError(mode.name());
        }
        return res;
    }

    public void convertUnicodeCharacters(FileObject file, ConvertMode codeMode) {
        try {
            final String converted = new Converter().convert(file.asText(), codeMode);
            BufferedOutputStream os = new BufferedOutputStream(file.getOutputStream());
            os.write(converted.getBytes("ASCII"));
            os.flush();
            os.close();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public enum ConvertMode
    {

        UPPERCASE, LOWERCASE
    }

}
