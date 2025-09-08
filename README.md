[![Published on Vaadin Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/carousel-addon)
[![Stars on vaadin.com/directory](https://img.shields.io/vaadin-directory/star/carousel-addon.svg)](https://vaadin.com/directory/component/carousel-addon)
[![Build Status](https://jenkins.flowingcode.com/buildStatus/icon?job=Carousel-addon)](https://jenkins.flowingcode.com/job/Carousel-addon)
[![Javadoc](https://img.shields.io/badge/javadoc-00b4f0)](https://javadoc.flowingcode.com/artifact/com.flowingcode.addons.carousel/carousel-addon)

# Carousel Addon for Vaadin 14+

This is a carousel addon, based on `l2t-paper-slider` (from @xpertsea/paper-slider)

## Online demo

Try the add-on demo at http://addonsv24.flowingcode.com/carousel

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to https://vaadin.com/directory/component/carousel-addon

## Building and running demo

git clone https://github.com/FlowingCode/CarouselAddon.git
mvn clean install jetty:run

To see the demo, navigate to http://localhost:8080/

## Development with Eclipse IDE

For further development of this add-on, the following tool-chain is recommended:
- Eclipse IDE
- m2e wtp plug-in (install it from Eclipse Marketplace)
- Vaadin Eclipse plug-in (install it from Eclipse Marketplace)
- JRebel Eclipse plug-in (install it from Eclipse Marketplace)
- Chrome browser

### Importing project

Choose File > Import... > Existing Maven Projects

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine. 

### Debugging

To debug project and make code modifications on the fly in the server-side, right-click the project and choose Debug As > Debug on Server. Navigate to http://localhost:8080/ to see the application.
 
## Release notes

### Version 2.0.0
- First release compatible with Vaadin 14 NPM mode
### Version 1.0.0
- First release of the addon

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases.

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome. There are two primary ways you can contribute: by reporting issues or by submitting code changes through pull requests. To ensure a smooth and effective process for everyone, please follow the guidelines below for the type of contribution you are making.

#### 1. Reporting Bugs and Requesting Features

Creating an issue is a highly valuable contribution. If you've found a bug or have an idea for a new feature, this is the place to start.

* Before creating an issue, please check the existing issues to see if your topic is already being discussed.
* If not, create a new issue, choosing the right option: "Bug Report" or "Feature Request". Try to keep the scope minimal but as detailed as possible.

> **A Note on Bug Reports**
> 
> Please complete all the requested fields to the best of your ability. Each piece of information, like the environment versions and a clear description, helps us understand the context of the issue.
> 
> While all details are important, the **[minimal, reproducible example](https://stackoverflow.com/help/minimal-reproducible-example)** is the most critical part of your report. It's essential because it removes ambiguity and allows our team to observe the problem firsthand, exactly as you are experiencing it.

#### 2. Contributing Code via Pull Requests

As a first step, please refer to our [Development Conventions](https://github.com/FlowingCode/DevelopmentConventions) page to find information about Conventional Commits & Code Style requirements.

Then, follow these steps for creating a contribution:
 
- Fork this project.
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- For commit message, use [Conventional Commits](https://github.com/FlowingCode/DevelopmentConventions/blob/main/conventional-commits.md) to describe your change.
- Send a pull request for the original project.
- Comment on the original issue that you have implemented a fix for it.


## License & Author

This add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

CarouselAddon is written by Flowing Code S.A.

# Developer Guide

## Getting started

Here is a simple example on how to try out the add-on component:

    	Slide s1 = new Slide(createSlideContent("Slide 1","green"));
    	Slide s2 = new Slide(createSlideContent("Slide 2","blue"));
    	Slide s3 = new Slide(createSlideContent("Slide 3","red"));
    	Slide s4 = new Slide(createSlideContent("Slide 4","yellow"));

    	Carousel c = new Carousel(s1,s2,s3,s4);
    	c.setWidth("100%");
    	c.setHeight("180px");
    	c.addChangeListener(e->Notification.show("changed!",1000,Position.BOTTOM_END));

For a more comprehensive example, see com.flowingcode.vaadin.addons.carousel.DemoView

## Features

### Fluent API

    	c = new Carousel(s1,s2,s3,s4)
    			.withAutoProgress()
    			.withSlideDuration(4)
    			.withStartPosition(1);

### Server-side listeners

    	c.addChangeListener(e->Notification.show("changed!",1000,Position.BOTTOM_END));

### Server-side methods

    	Button next = new Button(">>");
    	next.addClickListener(e->cf.moveNext());
    	Button prev = new Button("<<");
    	prev.addClickListener(e->cf.movePrev());
    	Button last = new Button(">|");
    	last.addClickListener(e->cf.movePos(3));
    	Button first = new Button("|<");
    	first.addClickListener(e->cf.movePos(0));

## Special configuration when using Spring

By default, Vaadin Flow only includes `com/vaadin/flow/component` to be always scanned for UI components and views. For this reason, the add-on might need to be allowed in order to display correctly. 

To do so, just add `com.flowingcode` to the `vaadin.allowed-packages` property (Vaadin 14-23: `vaadin.whitelisted-packages`) in `src/main/resources/application.properties`, like:

```
vaadin.allowed-packages = com.vaadin,org.vaadin,dev.hilla,com.flowingcode
```

More information on Spring scanning configuration [here](https://vaadin.com/docs/latest/integrations/spring/configuration/#configure-the-scanning-of-packages).
