package com.test.struts.struts2basic.struts2starter.action;

import com.test.struts.struts2basic.struts2starter.service.TutorialFinderService;

public class TutorialAction {

	public String execute() {

		TutorialFinderService tutorialFinderService = new TutorialFinderService();
		String bestTutorialSite = tutorialFinderService.getBestTutorialSite();
		System.out.println("Best Tutorial Site: " + bestTutorialSite);
		return "success";
	}
}
