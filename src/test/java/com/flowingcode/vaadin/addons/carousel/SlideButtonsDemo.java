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
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Slide Buttons")
@DemoSource
@Route(value = "carousel/slide-buttons", layout = CarouselDemoView.class)
@SuppressWarnings("serial")
public class SlideButtonsDemo extends VerticalLayout {

  public SlideButtonsDemo() {
    Slide s1 = new Slide(CarouselDemoView.createSlideContent("Slide 1", "https://www.flowingcode.com/wp-content/uploads/2018/04/birthday-3021071_640.jpg"));
    Slide s2 = new Slide(CarouselDemoView.createSlideContent("Slide 2", "https://2.bp.blogspot.com/-nvtIfgN8duc/XKUQh9VEyFI/AAAAAAAABT8/mE7P45E2uqwWlkKimAmes7fT2rdW9UDWwCEwYBhgL/s320/anniversary_1.jpg"));
    Slide s3 = new Slide(CarouselDemoView.createSlideContent("Slide 3", "https://www.flowingcode.com/wp-content/uploads/2020/04/photo4blog-300x300.jpg"));
    Slide s4 = new Slide(CarouselDemoView.createSlideContent("Slide 4", "https://www.flowingcode.com/wp-content/uploads/2021/03/happy_birthday_2.jpg"));


    final Carousel cf = new Carousel(s1, s2, s3, s4).withoutNavigation();
    cf.setSizeFull();
    Button next = new Button(">>");
    Button prev = new Button("<<");
    Button last = new Button(">|");
    Button first = new Button("|<");
    next.addClickListener(e -> cf.moveNext());
    prev.addClickListener(e -> cf.movePrev());
    last.addClickListener(e -> cf.movePos(3));
    first.addClickListener(e -> cf.movePos(0));

    cf.addChangeListener(e -> Notification.show("Slide Changed!", 1000, Position.BOTTOM_START));
    HorizontalLayout btns = new HorizontalLayout(first, prev, next, last);
    btns.setAlignItems(Alignment.CENTER);
    btns.setJustifyContentMode(JustifyContentMode.CENTER);
    btns.setWidthFull();
    add(cf, btns);
  }

}
