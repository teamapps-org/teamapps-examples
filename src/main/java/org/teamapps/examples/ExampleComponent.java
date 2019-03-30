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
package org.teamapps.examples;

import org.teamapps.ux.component.Component;

public class ExampleComponent {

	private int width = 0;
	private int height = 700;
	private Component component;

	public ExampleComponent(int width, int height, Component component) {
		this.width = width;
		this.height = height;
		this.component = component;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Component getComponent() {
		return component;
	}
}
