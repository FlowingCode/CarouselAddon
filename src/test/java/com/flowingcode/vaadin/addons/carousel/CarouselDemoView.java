/*-
 * #%L
 * Carousel Addon
 * %%
 * Copyright (C) 2018 - 2020 Flowing Code
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

import com.flowingcode.vaadin.addons.DemoLayout;
import com.flowingcode.vaadin.addons.GithubLink;
import com.flowingcode.vaadin.addons.demo.TabbedDemo;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route(value = "carousel", layout = DemoLayout.class)
@GithubLink("https://github.com/FlowingCode/CarouselAddon")
public class CarouselDemoView extends TabbedDemo {

	private static final String LISTENER_DEMO = "Slide Listener";
	private static final String AUTOPROGRESS_DEMO = "Auto Progress";
	private static final String BUTTONS_DEMO = "Slide Buttons";
	private static final String LISTENER_SOURCE = "https://github.com/FlowingCode/CarouselAddon/blob/master/src/test/java/com/flowingcode/vaadin/addons/carousel/ListenerDemo.java";
	private static final String AUTPROGRESS_SOURCE = "https://github.com/FlowingCode/CarouselAddon/blob/master/src/test/java/com/flowingcode/vaadin/addons/carousel/AutoProgressDemo.java";
	private static final String BUTTONS_SOURCE = "https://github.com/FlowingCode/CarouselAddon/blob/master/src/test/java/com/flowingcode/vaadin/addons/carousel/SlideButtonsDemo.java";

	public CarouselDemoView() {
		addDemo(new ListenerDemo(), LISTENER_DEMO, LISTENER_SOURCE);
		addDemo(new AutoProgressDemo(), AUTOPROGRESS_DEMO, AUTPROGRESS_SOURCE);
		addDemo(new SlideButtonsDemo(), BUTTONS_DEMO, BUTTONS_SOURCE);
		setSizeFull();
	}
}
