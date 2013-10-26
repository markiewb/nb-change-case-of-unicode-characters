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
