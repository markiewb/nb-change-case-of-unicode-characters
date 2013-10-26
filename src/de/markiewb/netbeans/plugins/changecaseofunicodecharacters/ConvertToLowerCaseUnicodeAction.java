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
        id = "de.markiewb.netbeans.plugins.changecaseofunicodecharacters.ConvertToLowerCaseUnicodeAction"
)
@ActionRegistration(
        displayName = "#CTL_ConvertToLowerCaseUnicodeAction"
)
@ActionReferences(
        {
            @ActionReference(path = "Editors/text/x-properties/Popup", position = 0)
        })
@Messages("CTL_ConvertToLowerCaseUnicodeAction=Convert unicode chars to lowercase")
public final class ConvertToLowerCaseUnicodeAction implements ActionListener {

    private final DataObject context;

    public ConvertToLowerCaseUnicodeAction(DataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        ConvertMode codeMode = ConvertMode.LOWERCASE;
        new Converter().convertUnicodeCharacters(context.getPrimaryFile(), ConvertMode.LOWERCASE);
    }
}
