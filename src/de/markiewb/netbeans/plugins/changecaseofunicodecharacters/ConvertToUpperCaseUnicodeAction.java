package de.markiewb.netbeans.plugins.changecaseofunicodecharacters;

import de.markiewb.netbeans.plugins.changecaseofunicodecharacters.Converter.ConvertMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.loaders.DataObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "de.markiewb.netbeans.plugins.changecaseofunicodecharacters.ConvertToUpperCaseUnicodeAction"
)
@ActionRegistration(
        displayName = "#CTL_ConvertToUpperCaseUnicodeAction"
)
@ActionReferences(
        {
            @ActionReference(path = "Editors/text/x-properties/Popup", position = 0)
        })
@Messages("CTL_ConvertToUpperCaseUnicodeAction=Convert unicode chars to uppercase")
public final class ConvertToUpperCaseUnicodeAction implements ActionListener {

    private final DataObject context;

    public ConvertToUpperCaseUnicodeAction(DataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        new Converter().convertUnicodeCharacters(context.getPrimaryFile(), ConvertMode.UPPERCASE);
    }
}
