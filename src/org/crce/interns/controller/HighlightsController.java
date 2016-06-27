package org.crce.interns.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.crce.interns.beans.ApplicantCSVBean;
import org.crce.interns.beans.FileReader;
import org.crce.interns.beans.PlacementStatsBean;
import org.crce.interns.model.TotalNoOfStudents;
import org.crce.interns.service.AssignTPCService;
import org.crce.interns.service.CSVFileGenerator;
import org.crce.interns.service.ConstantValues;
import org.crce.interns.service.ManageApplicantsService;
import org.crce.interns.service.ProfileService;
import org.crce.interns.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HighlightsController implements ConstantValues {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private StatisticsService statisticsService;

	@Autowired
	private AssignTPCService userService;

	@Autowired
	private CSVFileGenerator csvService;

	@Autowired
	private ManageApplicantsService crudService;

	private static final int BUFFER_SIZE = 4096;

	private static final Logger logger = Logger.getLogger(HighlightsController.class.getName());

	@RequestMapping(value = "/Statistics", method = RequestMethod.GET)
	public ModelAndView view(HttpServletRequest request) {
		// String year = (String) request.getAttribute("year");
		// String year = "2016";
		// TotalNoOfStudents total =
		// statisticsService.getTotalNoOfStudents(year);
		ModelAndView model = new ModelAndView("list");
		// model.addObject("totalStudents", total);
		return model;
	}

	@RequestMapping(value = "/tpclist", method = RequestMethod.GET)
	public ModelAndView tpclist(@RequestParam("year") String curYear, final RedirectAttributes redirectAttributes) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("users", userService.viewTPCs(curYear));
		return new ModelAndView("tpclist", modelMap);
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)

	public ModelAndView stats(@RequestParam("year") String curYear, final RedirectAttributes redirectAttributes) {
		Map<Integer, Map<String, PlacementStatsBean>> result = statisticsService.list();
		
		TotalNoOfStudents total = statisticsService.getTotalNoOfStudents(curYear);
		ModelAndView model = new ModelAndView("stats");
		model.addObject("totalStudents", total);
		return model;
	}

	@RequestMapping(value = "/company", method = RequestMethod.GET)

	public ModelAndView company(@RequestParam("year") String curYear, final RedirectAttributes redirectAttributes) {

		return new ModelAndView("CompaniesPage");
	}

	@RequestMapping(value = "/studentlist", method = RequestMethod.GET)
	public ModelAndView studentList(@RequestParam("year") String curYear, final RedirectAttributes redirectAttributes) {
		try {
			Map<String, Set<String>> result = profileService.totalStudents(curYear);

			ModelAndView model = new ModelAndView("studentlist");

			model.addObject("comps", result.get(ConstantValues.COMPS));
			model.addObject("it", result.get(ConstantValues.IT));
			model.addObject("elex", result.get(ConstantValues.ELEX));
			model.addObject("prod", result.get(ConstantValues.PROD));

			return model;
		} catch (Exception e) {
			logger.error(e);

			return new ModelAndView("500");
		}
	}

	@RequestMapping(value = "/test-yearwise", method = RequestMethod.GET)

	public ModelAndView year(HttpServletRequest request) {
		try {
			profileService.listProfessionalProfile("2016");
			return new ModelAndView("list");
		} catch (Exception e) {
			logger.error(e);

			return new ModelAndView("500");
		}
	}

}
