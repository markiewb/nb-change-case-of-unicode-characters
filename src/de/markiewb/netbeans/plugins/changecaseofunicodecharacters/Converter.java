package de.markiewb.netbeans.plugins.changecaseofunicodecharacters;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
