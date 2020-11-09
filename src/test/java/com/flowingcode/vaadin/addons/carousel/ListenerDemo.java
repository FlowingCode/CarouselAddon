/*-
 * #%L
 * Carousel Addon
 * %%
 * Copyright (C) 2018 - 2019 Flowing Code
 * %%
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
 * #L%
 */
package com.flowingcode.vaadin.addons.carousel;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@SuppressWarnings("serial")
public class ListenerDemo extends VerticalLayout {

	public ListenerDemo() {
		Slide s1 = new Slide(createSlideContent("Slide 1", "green"));
		Slide s2 = new Slide(createSlideContent("Slide 2", "blue"));
		Slide s3 = new Slide(createSlideContent("Slide 3", "red"));
		Slide s4 = new Slide(createSlideContent("Slide 4", "yellow"));

		Carousel c = new Carousel(s1, s2, s3, s4);
		c.setWidth("100%");
		c.setHeight("180px");
		c.addChangeListener(e -> Notification.show("Slide Changed!", 1000, Position.BOTTOM_START));

		add(c);
	}

	private Component createSlideContent(String string, String color) {
		H1 label = new H1(string);
		label.getStyle().set("margin-top", "auto");
		label.getStyle().set("margin-bottom", "auto");
		VerticalLayout d = new VerticalLayout(label);
		d.setAlignItems(Alignment.CENTER);
		d.setSizeFull();
		d.getStyle().set("background-color", color);
		return d;
	}
}
