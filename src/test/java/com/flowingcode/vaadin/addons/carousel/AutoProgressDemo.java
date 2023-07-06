/*-
 * #%L
 * Carousel Addon
 * %%
 * Copyright (C) 2018 - 2021 Flowing Code
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

import com.flowingcode.vaadin.addons.demo.DemoSource;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Auto Progress")
@DemoSource
@Route(value = "carousel/auto-progress", layout = CarouselDemoView.class)
@SuppressWarnings("serial")
public class AutoProgressDemo extends VerticalLayout {

  public AutoProgressDemo() {
	Slide s1 = new Slide(CarouselDemoView.createSlideContent("Slide 1", "https://www.flowingcode.com/wp-content/uploads/2018/04/birthday-3021071_640.jpg"));
	Slide s2 = new Slide(CarouselDemoView.createSlideContent("Slide 2", "https://2.bp.blogspot.com/-nvtIfgN8duc/XKUQh9VEyFI/AAAAAAAABT8/mE7P45E2uqwWlkKimAmes7fT2rdW9UDWwCEwYBhgL/s320/anniversary_1.jpg"));
	Slide s3 = new Slide(CarouselDemoView.createSlideContent("Slide 3", "https://www.flowingcode.com/wp-content/uploads/2020/04/photo4blog-300x300.jpg"));
	Slide s4 = new Slide(CarouselDemoView.createSlideContent("Slide 4", "https://www.flowingcode.com/wp-content/uploads/2021/03/happy_birthday_2.jpg"));


    Carousel c =
        new Carousel(s1, s2, s3, s4)
            .withAutoProgress()
            .withSlideDuration(2)
            .withStartPosition(1)
            .withoutSwipe();
    c.setSizeFull();

    add(c);
  }

}
