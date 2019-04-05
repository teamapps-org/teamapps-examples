/*-
 * ========================LICENSE_START=================================
 * TeamApps
 * ---
 * Copyright (C) 2014 - 2019 TeamApps.org
 * ---
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
 * =========================LICENSE_END==================================
 */
package org.teamapps.examples.components.fields.textfields;


import org.teamapps.documentation.generator.annotation.TeamAppsDocClass;
import org.teamapps.documentation.generator.annotation.TeamAppsDocMethod;
import org.teamapps.icon.material.MaterialIcon;
import org.teamapps.ux.component.Component;
import org.teamapps.ux.component.field.TextField;
import org.teamapps.ux.session.CurrentSessionContext;

@TeamAppsDocClass(title = "Text Field")
public class TextFieldExample {

	/**
	 * <p>
	 *     <code>TextField</code> is a component for user text input. The <code>value</code> is of type <code>String</code>.
	 * </p>
	 * <p>
	 *     The field's value can be accessed via <code>getValue()</code>.
	 * </p>
	 */
	@TeamAppsDocMethod(title = "", images = "TextField-intro.png")
	public Component intro() {
		TextField textField = new TextField();
		textField.onValueChanged.addListener(text -> {
			CurrentSessionContext.get().showNotification(MaterialIcon.MESSAGE, "Value changed: " + text);
			System.out.println(textField.getValue());
		});
		textField.setEmptyText("Please enter text...");
		return textField;
	}

	/**
	 * <p>
	 *     <code>emptyText</code> specifies the placeholder text while the text field is empty.
	 * </p>
	 */
	@TeamAppsDocMethod(title = "Empty Text", images = "TextField-emptyText.png")
	public Component emptyText() {
		TextField textField = new TextField();
		textField.setEmptyText("Please enter your user name...");
		return textField;
	}

	/**
	 * <p>
	 *     <code>maxCharacters</code> can be used to limit maximum number of characters.
	 *     When the user reaches the limit, additional text input will be ignored.
	 * </p>
	 */
	@TeamAppsDocMethod(title = "Maximum Characters")
	public Component maxCharacters() {
		TextField textField = new TextField();
		textField.setMaxCharacters(10);
		return textField;
	}

	/**
	 * <p>
	 *     If <code>showClearButton</code> is true, the text field displays a small "delete" button on the right.
	 * </p>
	 */
	@TeamAppsDocMethod(title = "Clear Button", images = "TextField-showClearButton.png")
	public Component showClearButton() {
		TextField textField = new TextField();
		textField.setShowClearButton(true);
		textField.setValue("Some text");
		return textField;
	}

	/**
	 * <p>
	 *     <code>TextField</code> provides the following events:
	 * </p>
	 * <div class="table-responsive">
	 *  <table class="events-table">
	 *      <tr>
	 *          <th>Event</th>
	 *          <th>Type</th>
	 *          <th>Description</th>
	 *      </tr>
	 *      <tr>
	 *          <td>onValueChanged</td>
	 *          <td>String</td>
	 *          <td>
	 *              Fired when the user commits the change by hitting <kbd>enter</kbd> or leaving the field.
	 *          </td>
	 *      </tr>
	 *      <tr>
	 *          <td>onTextInput</td>
	 *          <td>String</td>
	 *          <td>
	 *              Fired whenever the user changes the content of the field. This event is debounced by 250ms.
	 *          I.e. when the user makes a sequence of key presses with less than 250ms in between each press, only the first and the last of them will trigger an <code>onTextInput</code> event.
	 *          </td>
	 *      </tr>
	 *      <tr>
	 *          <td>onSpecialKeyPressed</td>
	 *          <td>SpecialKey</td>
	 *          <td>
	 *              Currently only fired when the user presses the <kbd>enter</kbd> or <kbd>escape</kbd> key.
	 *          </td>
	 *      </tr>
	 *  </table>
	 * </div>
	 */
	@TeamAppsDocMethod(title = "Events")
	public Component events() {
		TextField textField = new TextField();
		textField.onValueChanged.addListener(text -> {
			CurrentSessionContext.get().showNotification(MaterialIcon.MESSAGE, "Value changed: " + text);
		});
		textField.onTextInput.addListener(text -> {
			CurrentSessionContext.get().showNotification(MaterialIcon.MESSAGE, "Text input: " + text);
		});
		textField.onSpecialKeyPressed.addListener(specialKey -> {
			CurrentSessionContext.get().showNotification(MaterialIcon.MESSAGE, "Special key pressed: " + specialKey.name());
		});
		return textField;
	}
}
