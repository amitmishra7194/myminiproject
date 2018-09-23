package com.amit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amit.dto.CustomerDTO;
import com.amit.dto.CustomerResultDTO;
import com.amit.dto.EmployeeDTO;
import com.amit.dto.EmployeeResultDTO;
import com.amit.dto.StudentDTO;
import com.amit.dto.StudentResultDTO;
import com.amit.dto.UserDTO;
import com.amit.dto.UserInsertDTO;
import com.amit.service.CustomerService;
import com.amit.service.EmployeeService;
import com.amit.service.StudentService;
import com.amit.service.UserInsertService;
import com.amit.service.UserService;
import com.amit.validator.LoginValidator;
import com.nt.command.CustomerCommand;
import com.nt.command.EmployeeCommand;
import com.nt.command.StudentCommand;
import com.nt.command.UploadCommand;
import com.nt.command.UserCommand;
import com.nt.command.UserInsertCommand;

import nl.captcha.Captcha;

@Controller
public class UserController {
	private static final String DOWNLOD_PATH = "E:/springfileuploads";

	@Autowired
	private UserService service;
	@SuppressWarnings("unused")
	@Autowired
	private LoginValidator validator;
	@Autowired
	private StudentService studentService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserInsertService userInsertService;

	@RequestMapping(value = "welcome2.htm", method = RequestMethod.GET)
	public String welcomePage() {

		return "welcome2";
	}

	@RequestMapping(value = "/about_us2.htm", method = RequestMethod.GET)
	public String aboutUsPage() {

		return "about_us";
	}

	@RequestMapping(value = "/contact_us2.htm", method = RequestMethod.GET)
	public String contactUsPage() {

		return "contact_us2";
	}

	@RequestMapping(value = "/login_page.htm", method = RequestMethod.GET)
	public String loginPage(Map<String, UserCommand> map) {

		UserCommand cmd = null;
		cmd = new UserCommand();
		cmd.setUser("raja12");
		cmd.setPwd("rani23");
		// keep Command class obj as model attribute
		map.put("userCmd", cmd);

		return "login_page";
	}

	@RequestMapping(value = "/login_page.htm", method = RequestMethod.POST)
	public String processLoginPage(Map<String, Object> map, @ModelAttribute("userCmd") UserCommand cmd,
			HttpSession session) {

		UserCommand command = null;
		// convert model Attribute to Command class obj
		command = (UserCommand) cmd;
		UserDTO dto = null;
		String msg = null;
		String userName = null;
		Calendar cal = null;
		int hour = 0;
		// supporting logic to use validations
		/*
		 * if (validator.supports(UserCommand.class))
		 * validator.validate(command, errors); if (errors.hasErrors()) return
		 * "login_page"; ,BindingResult errors
		 */ // set form data into dto
		dto = new UserDTO();
		dto.setUser(command.getUser());
		dto.setPwd(command.getPwd());

		// use Service
		msg = service.verifyUser(dto);
		map.put("msg", msg);
		userName = dto.getUser();
		map.put("userName", userName);

		// generate wish msg
		cal = Calendar.getInstance();
		hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour < 12)
			map.put("wMsg", "Hi Good Morning " + userName);
		else if (hour < 16)
			map.put("wMsg", "Hi Good AfterNoon " + userName);
		else if (hour < 20)
			map.put("wMsg", "Hi Good Evening " + userName);
		else
			map.put("wMsg", "Hi Good Night " + userName);
		/*
		 * if(msg.equalsIgnoreCase("Invalid User")){ return "login_page"; }
		 * else{ return "home_page";
		 */

		String answer = null;
		Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		answer = command.getCaptcha();

		if (captcha.isCorrect(answer) && msg.equalsIgnoreCase("Valid User")) {
			map.put("message", "Valid Repsonse");
			return "home_page";
		} else {
			map.put("message", "Invalid response");
			return "login_page";
		}
	}// method

	@RequestMapping(value = "/list_studs.htm", method = RequestMethod.GET)
	public String showStudentList(Map<String, Object> map) {
		// Prepare List<StudentDTO> object
		List<StudentDTO> listStudentDTO = new ArrayList<StudentDTO>();
		// use service
		listStudentDTO = studentService.fetchStudents();
		map.put("listStudentDTO", listStudentDTO);
		return "list_studs";
	}

	@RequestMapping(value = "/home_page.htm", method = RequestMethod.GET)
	public String showHomePage() {

		return "home_page";
	}

	@RequestMapping(value = "/delete_studs.htm", method = RequestMethod.GET)
	public String deleteStudent(Map<String, Object> map, @RequestParam("sid") String id) {
		int no = Integer.parseInt(id);
		String msg1 = studentService.removeStudentByNo(no);
		List<StudentDTO> listStudDTO = studentService.fetchStudents();
		map.put("listStudentDTO", listStudDTO);
		map.put("result", msg1);
		return "list_studs";
	}

	@RequestMapping(value = "/insert_studs.htm", method = RequestMethod.GET)
	public String showInsertStudentForm(@ModelAttribute("studCmd") StudentCommand cmd) {

		return "insert_studs";
	}

	@RequestMapping(value = "/insert_studs.htm", method = RequestMethod.POST)
	public String insertStudent(Map<String, Object> map, @ModelAttribute("studCmd") StudentCommand command) {
		StudentCommand studCommand = null;
		String result = null;
		StudentDTO dto = null;
		// type cast command to empCommand
		studCommand = (StudentCommand) command;
		// convert command obj to dto obj
		dto = new StudentDTO();
		BeanUtils.copyProperties(studCommand, dto);
		result = studentService.registerStudent(dto);
		map.put("studCommand", studCommand);
		map.put("result", result);
		return "insert_studs";
	}

	@RequestMapping(value = "edit_stud.htm", method = RequestMethod.GET)
	public ModelAndView showUpdateStudentForm(Map<String, Object> map, @RequestParam("sid") String sid,
			@ModelAttribute("studCmd") StudentCommand cmd) {
		int no = 0;
		StudentDTO dto = null;
		ModelAndView mav = null;
		no = Integer.parseInt(sid);
		dto = studentService.fetchStudentByNo(no);
		BeanUtils.copyProperties(dto, cmd);
		mav = new ModelAndView();
		mav.addObject(cmd);
		mav.setViewName("edit_stud");
		return mav;
	}

	@RequestMapping(value = "edit_stud.htm", method = RequestMethod.POST)
	public String updateStudent(Map<String, Object> map, @ModelAttribute("studCmd") StudentCommand cmd) {
		StudentCommand studCommand = null;
		StudentDTO dto = null;
		String result = null;
		List<StudentDTO> listStudDTO = null;
		studCommand = (StudentCommand) cmd;
		dto = new StudentDTO();
		BeanUtils.copyProperties(studCommand, dto);
		// use service
		result = studentService.updateStudentData(dto);
		listStudDTO = studentService.fetchStudents();

		map.put("listStuds", listStudDTO);
		map.put("result", result);
		map.put("studCmd", studCommand);

		return "edit_stud";
	}

	@RequestMapping(value = "/searchStud.htm", method = RequestMethod.GET)
	public String searchStudentPage() {

		return "search_studs";
	}

	@RequestMapping(value = "/searchStud.htm", method = RequestMethod.POST)
	public String processSearchStudent(Map<String, Object> map, @ModelAttribute("studCmd") StudentCommand cmd) {
		StudentCommand command = null;
		StudentDTO dto = null;
		List<StudentResultDTO> listRDTO = null;
		// convert cmd data to EmployeeCommand
		command = (StudentCommand) cmd;

		dto = new StudentDTO();
		BeanUtils.copyProperties(command, dto);
		listRDTO = studentService.processSearchStudent(dto);
		map.put("listStudentDTO", listRDTO);
		return "list_studs";

	}

	// EmployeeServices

	@RequestMapping(value = "/list_emps.htm", method = RequestMethod.GET)
	public String showEmployeeList(Map<String, Object> map) {
		// Prepare List<StudentDTO> object
		List<EmployeeDTO> listEmployeeDTO = new ArrayList<EmployeeDTO>();
		// use service
		listEmployeeDTO = employeeService.fetchEmployees();
		map.put("listEmployeeDTO", listEmployeeDTO);
		return "list_emps";
	}

	@RequestMapping(value = "/insert_emps.htm", method = RequestMethod.GET)
	public String showInsertEmployeeForm(@ModelAttribute("empCmd") EmployeeCommand cmd) {

		return "insert_emps";
	}

	@RequestMapping(value = "/insert_emps.htm", method = RequestMethod.POST)
	public String insertEmployee(Map<String, Object> map, @ModelAttribute("empCmd") EmployeeCommand command) {
		EmployeeCommand empCommand = null;
		String result = null;
		EmployeeDTO dto = null;
		// type cast command to empCommand
		empCommand = (EmployeeCommand) command;
		// convert command obj to dto obj
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(empCommand, dto);
		result = employeeService.registerEmployee(dto);
		map.put("empCommand", empCommand);
		map.put("result", result);
		if (result.equalsIgnoreCase("Employee Registration Fail"))
			return "error";
		else
			return "insert_emps";
	}

	@RequestMapping(value = "edit_emp.htm", method = RequestMethod.GET)
	public ModelAndView showUpdateEmployeeForm(Map<String, Object> map, @RequestParam("eid") String eid,
			@ModelAttribute("empCmd") EmployeeCommand cmd) {
		int no = 0;
		EmployeeDTO dto = null;
		ModelAndView mav = null;
		no = Integer.parseInt(eid);
		dto = employeeService.fetchEmployeeByNo(no);
		BeanUtils.copyProperties(dto, cmd);
		mav = new ModelAndView();
		mav.addObject(cmd);
		mav.setViewName("edit_emp");
		return mav;
	}

	@RequestMapping(value = "edit_emp.htm", method = RequestMethod.POST)
	public String updateEmployee(Map<String, Object> map, @ModelAttribute("empCmd") EmployeeCommand cmd) {
		EmployeeCommand empCommand = null;
		EmployeeDTO dto = null;
		String result = null;
		List<EmployeeDTO> listEmpDTO = null;
		empCommand = (EmployeeCommand) cmd;
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(empCommand, dto);
		// use service
		result = employeeService.updateEmployeeData(dto);
		listEmpDTO = employeeService.fetchEmployees();

		map.put("listEmps", listEmpDTO);
		map.put("result", result);
		map.put("empCmd", empCommand);

		return "edit_emp";
	}

	@RequestMapping(value = "/delete_emp.htm", method = RequestMethod.GET)
	public String deleteEmployee(Map<String, Object> map, @RequestParam("eid") String id) {
		int no = Integer.parseInt(id);
		String msg1 = employeeService.removeEmployeeByNo(no);
		List<EmployeeDTO> listEmpDTO = employeeService.fetchEmployees();
		map.put("listEmployeeDTO", listEmpDTO);
		map.put("result", msg1);
		return "list_emps";
	}

	@RequestMapping(value = "/searchEmp.htm", method = RequestMethod.GET)
	public String searchEmployeePage() {

		return "search_emps";
	}

	@RequestMapping(value = "/searchEmp.htm", method = RequestMethod.POST)
	public String processSearchEmployee(Map<String, Object> map, @ModelAttribute("empCmd") EmployeeCommand cmd) {
		EmployeeCommand command = null;
		EmployeeDTO dto = null;
		List<EmployeeResultDTO> listRDTO = null;
		// convert cmd data to EmployeeCommand
		command = (EmployeeCommand) cmd;

		dto = new EmployeeDTO();
		BeanUtils.copyProperties(command, dto);
		System.out.println();
		listRDTO = employeeService.process(dto);
		map.put("listEmployeeDTO", listRDTO);
		return "list_emps";

	}

	// customer Part

	@RequestMapping(value = "/list_custs.htm", method = RequestMethod.GET)
	public String showCustomerList(Map<String, Object> map) {
		// Prepare List<StudentDTO> object
		List<CustomerDTO> listCustomerDTO = new ArrayList<CustomerDTO>();
		// use service
		listCustomerDTO = customerService.fetchCustomers();
		map.put("listCustomerDTO", listCustomerDTO);
		return "list_custs";
	}

	@RequestMapping(value = "/insert_custs.htm", method = RequestMethod.GET)
	public String showInsertCustomerForm(@ModelAttribute("custCmd") CustomerCommand cmd) {

		return "insert_custs";
	}

	@RequestMapping(value = "/insert_custs.htm", method = RequestMethod.POST)
	public String insertCustomer(Map<String, Object> map, @ModelAttribute("custCmd") CustomerCommand command) {
		CustomerCommand custCommand = null;
		String result = null;
		CustomerDTO dto = null;
		// type cast command to empCommand
		custCommand = (CustomerCommand) command;
		// convert command obj to dto obj
		dto = new CustomerDTO();
		BeanUtils.copyProperties(custCommand, dto);
		result = customerService.registerCustomer(dto);
		map.put("custCommand", custCommand);
		map.put("result", result);
		return "insert_custs";
	}

	@RequestMapping(value = "edit_custs.htm", method = RequestMethod.GET)
	public ModelAndView showUpdateCustomerForm(Map<String, Object> map, @RequestParam("cid") String cid,
			@ModelAttribute("custCmd") CustomerCommand cmd) {
		int no = 0;
		CustomerDTO dto = null;
		ModelAndView mav = null;
		no = Integer.parseInt(cid);
		dto = customerService.fetchCustomerByNo(no);
		BeanUtils.copyProperties(dto, cmd);
		mav = new ModelAndView();
		mav.addObject(cmd);
		mav.setViewName("edit_cust");
		return mav;
	}

	@RequestMapping(value = "edit_custs.htm", method = RequestMethod.POST)
	public String updateCustomer(Map<String, Object> map, @ModelAttribute("custCmd") CustomerCommand cmd) {
		CustomerCommand custCommand = null;
		CustomerDTO dto = null;
		String result = null;
		List<CustomerDTO> listCustDTO = null;
		custCommand = (CustomerCommand) cmd;
		dto = new CustomerDTO();
		BeanUtils.copyProperties(custCommand, dto);
		// use service
		result = customerService.updateCustomerData(dto);
		listCustDTO = customerService.fetchCustomers();

		map.put("listCusts", listCustDTO);
		map.put("result", result);
		map.put("custCmd", custCommand);

		return "edit_cust";
	}

	@RequestMapping(value = "/delete_custs.htm", method = RequestMethod.GET)
	public String deleteCustomer(Map<String, Object> map, @RequestParam("cid") String id) {
		int no = Integer.parseInt(id);
		String msg1 = customerService.removeCustomerByNo(no);
		List<CustomerDTO> listCustDTO = customerService.fetchCustomers();
		map.put("listCustomerDTO", listCustDTO);
		map.put("result", msg1);
		return "list_custs";
	}

	@RequestMapping(value = "/searchCust.htm", method = RequestMethod.GET)
	public String searchCustomerPage() {

		return "search_custs";
	}

	@RequestMapping(value = "/searchCust.htm", method = RequestMethod.POST)
	public String processSearchCustomer(Map<String, Object> map, @ModelAttribute("custCmd") CustomerCommand cmd) {
		CustomerCommand command = null;
		CustomerDTO dto = null;
		List<CustomerResultDTO> listRDTO = null;
		// convert cmd data to EmployeeCommand
		command = (CustomerCommand) cmd;

		dto = new CustomerDTO();
		BeanUtils.copyProperties(command, dto);
		listRDTO = customerService.processSearchCustomer(dto);
		map.put("listCustomerDTO", listRDTO);
		return "list_custs";

	}

	@RequestMapping(value = "/register_page.htm", method = RequestMethod.GET)
	public String showSinUpPage(@ModelAttribute("userCmd") UserInsertCommand cmd) {

		return "register_page";
	}

	@RequestMapping(value = "/register_page.htm", method = RequestMethod.POST)
	public String insertUser(Map<String, Object> map, @ModelAttribute("userCmd") UserInsertCommand command) {
		UserInsertCommand userCommand = null;
		String result = null;
		UserInsertDTO dto = null;
		// type cast command to empCommand
		userCommand = (UserInsertCommand) command;
		// convert command obj to dto obj
		dto = new UserInsertDTO();
		BeanUtils.copyProperties(userCommand, dto);
		result = userInsertService.registerUser(dto);
		map.put("userCommand", userCommand);
		map.put("result", result);
		return "register_page";
	}

	@RequestMapping(value = "/upload.htm", method = RequestMethod.GET)
	public String showForm(Map<String, Object> model) {
		UploadCommand cmd = null;
		// create Command class object
		cmd = new UploadCommand();
		// add command object to Model attribute
		model.put("uplCmd", cmd);
		return "form_file_upload";
	}// method

	@RequestMapping(value = "/upload.htm", method = RequestMethod.POST)
	public String uploadFile(Map<String, Object> model, @ModelAttribute("uplCmd") UploadCommand cmd) throws Exception {
		String destLocation = "e:/springfileuploads";
		File file = null;
		InputStream is = null;
		OutputStream os = null;
		// Create Dest Location folder if not available
		file = new File(destLocation);
		if (!file.exists()) {
			file.mkdir();
		}
		// get Input Stream representing uploaded file
		is = cmd.getFile().getInputStream();
		// get OutpuStream piointing to empty Dest file
		os = new FileOutputStream(file.getPath() + "/" + cmd.getFile().getOriginalFilename());
		// complete file uploading
		IOUtils.copy(is, os);

		// add uploded file name as model attribute
		model.put("upl_filename", cmd.getFile().getOriginalFilename() + " File Uploaded Successfully");

		return "form_file_upload";
	}// method

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/filedownload.htm")
	public String showHomePage(Map<String, Object> model) {
		File TargetFolder = null;
		File lof[] = null;
		List<String> d_files_list = null;
		// get All the file names from target folder
		TargetFolder = new File(DOWNLOD_PATH);
		lof = TargetFolder.listFiles();
		d_files_list = new ArrayList();
		for (File file : lof) {
			if (!file.isDirectory()) {
				d_files_list.add(file.getName());
			}
		}
		// add list of files to model
		model.put("filesList", d_files_list);

		return "view_files";
	}// method

	@RequestMapping("/download.htm")
	public void download(HttpServletResponse res, @RequestParam("file_name") String fileName) throws Exception {
		File file = null;
		InputStream is = null;
		OutputStream os = null;
		// file downloading settings
		res.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
		// locate the file to be downloaded
		file = new File(DOWNLOD_PATH + "/" + fileName);
		// create InputStream pointing to file to be downloaded
		is = new FileInputStream(file);
		// create Output Stream pointing to response object
		os = res.getOutputStream();
		// Copy the file content to response object
		IOUtils.copy(is, os);
	}// method

	@RequestMapping(value = "/shop1.htm", method = RequestMethod.GET)
	public String shop1() {

		return "shop1";
	}

	@RequestMapping(value = "/shop2.htm", method = RequestMethod.GET)
	public String shop2() {

		return "shop2";
	}

	@RequestMapping(value = "/shop3.htm", method = RequestMethod.GET)
	public String shop3() {

		return "shop3";
	}

	@RequestMapping(value = "/shop4.htm", method = RequestMethod.GET)
	public String shop4() {

		return "shop4";
	}

	@RequestMapping(value = "/shop5.htm", method = RequestMethod.GET)
	public String shop5() {

		return "shop5";
	}

	@RequestMapping(value = "/shop6.htm", method = RequestMethod.GET)
	public String shop6() {

		return "shop6";
	}

	@RequestMapping(value = "/shop7.htm", method = RequestMethod.GET)
	public String shop7() {

		return "shop7";
	}

	@RequestMapping(value = "/shop8.htm", method = RequestMethod.GET)
	public String shop8() {

		return "shop8";
	}

}
