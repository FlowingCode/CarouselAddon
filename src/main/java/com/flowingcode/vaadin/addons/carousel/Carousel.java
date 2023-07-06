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

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

/**
 * A component that displays a slideshow of slides.
 * By default the slides will be displayed with navigation buttons, autoplay and swipe enabled.
 * You can configure the slideshow by adding custom parameters, such as duration of transition,
 * start position, maximum height and disabling swipe.
 */
@SuppressWarnings("serial")
@Tag("l2t-paper-slider")
@HtmlImport("bower_components/l2t-paper-slider/l2t-paper-slider.html")
@NpmPackage(value = "@xpertsea/paper-slider", version = "3.0.0")
@JsModule("@xpertsea/paper-slider/l2t-paper-slider.js")
public class Carousel extends Component implements HasSize {

  private static final String HIDE_NAV = "hide-nav";
  private static final String DISABLE_SWIPE = "disable-swipe";
  private static final String POSITION = "position";
  private static final String SLIDE_DURATION = "slide-duration";
  private static final String AUTO_PROGRESS = "auto-progress";
  private static final int DEFAULT_SLIDE_DURATION = 2;

  private Slide[] slides;

  public Carousel(Slide... paperSlides) {
    this.setSlides(paperSlides);
    updateSlides(paperSlides);
    initProperties();
  }

  private void updateSlides(Slide... paperSlides) {
    for (Slide slide : paperSlides) {
      this.getElement().appendChild(slide.getElement());
    }
  }

  private void initProperties() {
    this.setAutoProgress(false);
    this.setSlideDuration(DEFAULT_SLIDE_DURATION);
    this.setStartPosition(0);
    this.setDisableSwipe(false);
    this.setHideNavigation(false);
  }

  // PROPERTIES
  public Slide[] getSlides() {
    return slides;
  }

  public void setSlides(Slide[] slides) {
    this.slides = slides;
    updateSlides(slides);
  }

  public boolean isAutoProgress() {
    return this.getElement().getProperty(AUTO_PROGRESS, false);
  }

  public void setAutoProgress(boolean autoProgress) {
    this.getElement().setAttribute(AUTO_PROGRESS, autoProgress);
  }

  public int getSlideDuration() {
	return this.getElement().getProperty(SLIDE_DURATION, 0);
  }

  public void setSlideDuration(int slideDuration) {
	this.getElement().setProperty(SLIDE_DURATION, slideDuration);
  }

  public int getStartPosition() {
    return this.getElement().getProperty(POSITION, 0);
  }

  public void setStartPosition(int startPosition) {
	this.getElement().setAttribute(POSITION, "" + startPosition);
  }

  public boolean isDisableSwipe() {
    return this.getElement().getProperty(DISABLE_SWIPE, false);
  }

  public void setDisableSwipe(boolean disableSwipe) {
	this.getElement().setAttribute(DISABLE_SWIPE, disableSwipe);
  }

  public boolean isHideNavigation() {
    return this.getElement().getProperty(HIDE_NAV, false);
  }

  public void setHideNavigation(boolean hideNavigation) {
	this.getElement().setAttribute(HIDE_NAV, hideNavigation);
  }

  // FLUENT API
  public Carousel withAutoProgress() {
    this.setAutoProgress(true);
    return this;
  }

  public Carousel withoutSwipe() {
    this.setDisableSwipe(true);
    return this;
  }

  public Carousel withoutNavigation() {
    this.setHideNavigation(false);
    return this;
  }

  public Carousel withSlideDuration(int slideDuration) {
    this.setSlideDuration(slideDuration);
    return this;
  }

  public Carousel withStartPosition(int startPosition) {
    this.setStartPosition(startPosition);
    return this;
  }

  // SIZING
  @Override
  public void setHeight(String height) {
	  HasSize.super.setHeight(height);
    getElement().getStyle().set("--paper-slide-height", height);
  }

  @Override
  public String getHeight() {
    return getElement().getStyle().get("--paper-slide-height");
  }

  // METHODS
  /** Move to the next slide */
  public void moveNext() {
    this.getElement().callJsFunction("moveNext");
  }

  /** Move to the previous slide */
  public void movePrev() {
    this.getElement().callJsFunction("movePrev");
  }

  /**
   * Move to a specific slide
   *
   * @param slide
   */
  public void movePos(int slide) {
    this.getElement().callJsFunction("movePos", "" + slide);
  }

  // EVENTS
  @DomEvent("position-changed")
  public static class SlideChangeEvent extends ComponentEvent<Carousel> {
    private String position;

    public SlideChangeEvent(
        Carousel source, boolean fromClient, @EventData("event.detail.value") String position) {
      super(source, fromClient);
      this.position = position;
    }

    public String getPosition() {
      return position;
    }
  }

  public Registration addChangeListener(ComponentEventListener<SlideChangeEvent> listener) {
    return addListener(SlideChangeEvent.class, listener);
  }
}
