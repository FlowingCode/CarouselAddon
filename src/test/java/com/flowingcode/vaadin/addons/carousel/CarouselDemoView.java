/*-
 * #%L
 * Carousel Addon
 * %%
 * Copyright (C) 2018 - 2024 Flowing Code
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
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@ParentLayout(DemoLayout.class)
@Route("carousel")
@GithubLink("https://github.com/FlowingCode/CarouselAddon")
public class CarouselDemoView extends TabbedDemo {

  public CarouselDemoView() {
    addDemo(ListenerDemo.class);
    addDemo(AutoProgressDemo.class);
    addDemo(SlideButtonsDemo.class);
    addDemo(CustomThemeDemo.class);
    setSizeFull();
  }

  public static Component createSlideContent(String string, String image) {
    Div result = new Div();
    result.getStyle().set("width", "auto");
    result.getStyle().set("height", "100%");
    result.getStyle().set("background-image", "url('" + image + "')");
    result.getStyle().set("background-size", "cover");
    result.getStyle().set("background-repeat", "no-repeat");
    result.getStyle().set("background-position", "50% 50%");
    return result;
  }
}
