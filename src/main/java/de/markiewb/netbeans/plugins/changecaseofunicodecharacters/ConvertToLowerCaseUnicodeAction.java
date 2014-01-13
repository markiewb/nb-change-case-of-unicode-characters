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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.loaders.DataObject;
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
        new Converter().convertUnicodeCharacters(context.getPrimaryFile(), ConvertMode.LOWERCASE);
    }
}