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
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("l2t-paper-slider")
@HtmlImport("bower_components/l2t-paper-slider/l2t-paper-slider.html")
@NpmPackage(value = "@xpertsea/paper-slider", version = "3.0.0")
@JsModule("@xpertsea/paper-slider/l2t-paper-slider.js")
public class Carousel extends Component implements HasSize {

	private static final int DEFAULT_SLIDE_DURATION = 2;
	
	private Slide[] slides;
	private boolean autoProgress;
	private int slideDuration = DEFAULT_SLIDE_DURATION;
	private int startPosition;
	private boolean disableSwipe;
	private boolean hideNavigation;

	public Carousel(Slide... paperSlides) {
		this.setSlides(paperSlides);
		updateSlides(paperSlides);
	}

	private void updateSlides(Slide... paperSlides) {
		for (Slide slide : paperSlides) {
			this.getElement().appendChild(slide.getElement());
		}
		updateProperties();
	}

	private void updateProperties() {
		if (autoProgress)
			this.getElement().setAttribute("auto-progress", "true");
		if (disableSwipe)
			this.getElement().setAttribute("disable-swipe", "true");
		if (hideNavigation)
			this.getElement().setAttribute("hide-nav", "true");
		this.getElement().setAttribute("slide-duration", "" + this.slideDuration);
		this.getElement().setAttribute("position", "" + this.startPosition);
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
		return autoProgress;
	}

	public void setAutoProgress(boolean autoProgress) {
		this.autoProgress = autoProgress;
	}

	public int getSlideDuration() {
		return slideDuration;
	}

	public void setSlideDuration(int slideDuration) {
		this.slideDuration = slideDuration;
	}

	public int getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	public boolean isDisableSwipe() {
		return disableSwipe;
	}

	public void setDisableSwipe(boolean disableSwipe) {
		this.disableSwipe = disableSwipe;
	}

	public boolean isHideNavigation() {
		return hideNavigation;
	}

	public void setHideNavigation(boolean hideNavigation) {
		this.hideNavigation = hideNavigation;
	}

	// FLUENT API
	public Carousel withAutoProgress() {
		this.autoProgress = true;
		updateProperties();
		return this;
	}

	public Carousel withoutSwipe() {
		this.disableSwipe = true;
		updateProperties();
		return this;
	}

	public Carousel withoutNavigation() {
		this.hideNavigation = true;
		updateProperties();
		return this;
	}

	public Carousel withSlideDuration(int slideDuration) {
		this.slideDuration = slideDuration;
		updateProperties();
		return this;
	}

	public Carousel withStartPosition(int startPosition) {
		this.startPosition = startPosition;
		updateProperties();
		return this;
	}


	// SIZING
	@Override
	public void setHeight(String height) {
		getElement().getStyle().set("--paper-slide-height", height);
	}

	@Override
	public String getHeight() {
		return getElement().getStyle().get("--paper-slide-height");
	}
	
	// METHODS
	/**
	 * Move to the next slide
	 */
	public void moveNext() {
		this.getElement().callJsFunction("moveNext");
	}
	
	/**
	 * Move to the previous slide
	 */
	public void movePrev() {
		this.getElement().callJsFunction("movePrev");
	}
	
	/**
	 * Move to a specific slide
	 * @param slide
	 */
	public void movePos(int slide) {
		this.getElement().callJsFunction("movePos", ""+slide);
	}

	// EVENTS
	@DomEvent("position-changed")
	public static class SlideChangeEvent extends ComponentEvent<Carousel> {
		public SlideChangeEvent(Carousel source, boolean fromClient) {
			super(source, true);
		}
	}

	public Registration addChangeListener(ComponentEventListener<SlideChangeEvent> listener) {
		return addListener(SlideChangeEvent.class, listener);
	}
	
	

}
