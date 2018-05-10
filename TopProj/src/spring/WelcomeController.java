package spring;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import kek.*;
import kekdao.*;

import org.hibernate.HibernateException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class WelcomeController {
	BookingDao bD = Factory.getInstance().getBookingDao();
	ClientDao cD = Factory.getInstance().getClientDao();
	Place_for_sellDao psD = Factory.getInstance().getPlace_for_sellDao();
	PlaceDao pD = Factory.getInstance().getPlaceDao();
	ScenarioDao sD = Factory.getInstance().getScenarioDao();
	ShowDao shD = Factory.getInstance().getShowDao();
	TheaterDao tD = Factory.getInstance().getTheaterDao();
	Worker_in_showDao wsD = Factory.getInstance().getWorker_in_showDao();
	Worker_in_theaterDao wtD = Factory.getInstance().getWorker_in_theaterDao();
	WorkerDao wD = Factory.getInstance().getWorkerDao();
	HallDao hD = Factory.getInstance().getHallDao();
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value = "/bookings")
	public String bookings(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, Model model) {
		try {
			if (id == null) {
				String temp = "U must be logged in";
				model.addAttribute("loginf", temp);
				return "main";
			}
			Client temp = cD.getById(Integer.parseInt(id.getValue()));
			System.out.println(temp.getClient_id());
			List<Booking> bookingsList = bD.getByClient(temp);
			model.addAttribute("bookingsList", bookingsList);
			return "bookings";
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model) {
		return "error";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@CookieValue(value = "id", required = false) Cookie id, HttpServletResponse response, Model model) {
		try {
			Cookie ck1 = new Cookie("id", null);
			Cookie ck2 = new Cookie("pass", null); 
			ck1.setMaxAge(0);
			ck2.setMaxAge(0);
			response.addCookie(ck1);
			response.addCookie(ck2);
			String loginf = "Welcome";
			model.addAttribute("loginf", loginf);
			return "main";
		} catch (HibernateException ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(@CookieValue(value = "id", required = false) Cookie id, Model model) {
		String loginf = "Welcome";
		if (id != null) {
			loginf = "Welcome, " + id.getValue();
		}
		model.addAttribute("loginf", loginf);
		try {
			return "main";
		} catch (HibernateException ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String mainLogin(Client cl, HttpServletResponse response, Model model) {
		try {
			
			Cookie ck1 = new Cookie("id", Integer.toString(cl.getClient_id()));
			Cookie ck2 = new Cookie("pass", cl.getPassword());
			ck1.setMaxAge(3600);
			ck2.setMaxAge(3600);
			response.addCookie(ck1);
			response.addCookie(ck2);
			String loginf = "Not Logged IN";
			if ((cD.getById(cl.getClient_id())).getPassword().equals(cl.getPassword())) {
				loginf = "Succesfull Login with ID" + Integer.toString(cl.getClient_id());
			}
			model.addAttribute("loginf", loginf);
			
			return "main";
		} catch (HibernateException ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/theaters", method = RequestMethod.GET)
	public String getTheaters(Model model) {
		try {
			List<Theater> th = tD.getAll();
			model.addAttribute("theaters", th);
			return "theaters";
		} catch (HibernateException ex) {
			return "error";
		}
	}
	@RequestMapping(value = "/theaters", method = RequestMethod.POST)
	public String getTheatersbyName(@ModelAttribute Theater theat, Model model) {
		try {
			List<Theater> th = tD.getByName(theat.getName());
			model.addAttribute("theaters", th);
			return "theaters";
		} catch (HibernateException ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/theater", method = RequestMethod.GET)
	public String getTheater(@RequestParam(value="id", required = true) int id, Model model) {
		Theater th = tD.getById(id);
		List<Shows> sh = shD.getByScTh(null, th);
		
		List<tempSh> tmp = new ArrayList<tempSh>();
		for (Shows s : sh) {
			tempSh tmp2 = new tempSh();
			tmp2.setDat(s.getDat());
			tmp2.setShow_id(s.getShow_id());
			tmp2.setSc_name(s.getScenario().getSource_name());
			tmp2.setDuration(s.getDuration());
			tmp.add(tmp2);
		}
		model.addAttribute("lst", tmp);
		model.addAttribute("theat", th);
		return "theater";
	}
	
	
	@RequestMapping(value = "/stars", method = RequestMethod.POST)
	public String getStarsbyName(@ModelAttribute Worker worke, Model model) {
		try {
			List<Worker> temp = wD.getByName(worke.getName(), worke.getLast_name());
			model.addAttribute("workers", temp);
			return "stars";
		} catch (HibernateException ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/stars", method = RequestMethod.GET)
	public String getStars(@ModelAttribute Worker worke, Model model) {
		try {
			List<Worker> temp = wD.getAll();
			model.addAttribute("workers", temp);
			return "stars";
		} catch (HibernateException ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/star", method = RequestMethod.GET)
	public String getStar(@RequestParam(value="id", required = true) int id, Model model) {
		try {
			Worker tempworker = new Worker();
			tempworker.setWorker_id(id);
			List<Worker_in_show> temp = wsD.getByWorkerI(tempworker);
			model.addAttribute("temp", temp);
			Worker star = wD.getById(id);
			model.addAttribute("star", star);
			return "star";
		} catch (HibernateException ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String getShow(@RequestParam(value="id", required = true) int id, Model model) {
		try {
			Shows s = shD.getById(id);
			tempSh tmp2 = new tempSh();
			tmp2.setDat(s.getDat());
			tmp2.setShow_id(s.getShow_id());
			tmp2.setSc_name(s.getScenario().getSource_name());
			tmp2.setDuration(s.getDuration());
			tmp2.setTheater_name(shD.getShowsTheater(s).getName());
			tmp2.setScenario_id(s.getScenario().getScenario_id());
			tmp2.setTheater_id(shD.getShowsTheater(s).getTheater_id());
			model.addAttribute("s", tmp2);
			
			List<Worker_in_show> wis = wsD.getByShowI(s);
			model.addAttribute("wis", wis);
			
			List<Place_for_sell> pfsList = psD.getByShow(s);
			List<Place_for_sell> pfsListRes = new ArrayList<Place_for_sell>();
			for (int i = 0; i < pfsList.size(); ++i) {
				if (pfsList.get(i).getFree() == 1) {
					pfsListRes.add(pfsList.get(i));
				}
			}
			model.addAttribute("pfsList", pfsListRes);
			
			return "show";
		} catch(Throwable ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/shows", method = RequestMethod.GET)
	public String getShows(@RequestParam("sc") String sc_name, @RequestParam("th") String th_name, Model model) {
		try {
			System.out.println("KEK" + sc_name + "Name here");
			System.out.println("KEK" + th_name + "Name here");
			List<Shows> temp1 = new ArrayList<Shows>();
			if (sc_name != "" && th_name != "") {
				
				List<Scenario> tsc = sD.getByParam(null, sc_name);
				List<Theater> tth = tD.getByName(th_name);
				for (Scenario sc : tsc) {
					System.out.println(sc.getScenario_id());
					for (Theater th : tth) {
						System.out.println(th.getTheater_id());
						temp1.addAll(shD.getByScTh(sc, th));
					}
				}
			} else {
				if (sc_name == "" && th_name == "") {
					temp1 = shD.getAll();
				} else {
					if (sc_name == "") {
						List<Theater> tth = tD.getByName(th_name);
						for (Theater th : tth) {
							temp1.addAll(shD.getByScTh(null, th));
						}
					}
					if (th_name == "") {
						List<Scenario> tsc = sD.getByParam(null, sc_name);
						for (Scenario sc : tsc) {
							temp1.addAll(shD.getByScTh(sc, null));
						}
					}
					
				}
			}
			List<tempSh> res = new ArrayList<tempSh>();
			/*tempSh tmp2 = new tempSh(); 
			 * WTF?????*/
			for (Shows s : temp1) {
				tempSh tmp2 = new tempSh();
				tmp2.setDat(s.getDat());
				tmp2.setShow_id(s.getShow_id());
				tmp2.setSc_name(s.getScenario().getSource_name());
				tmp2.setDuration(s.getDuration());
				tmp2.setTheater_name(shD.getShowsTheater(s).getName());
				tmp2.setTheater_id(shD.getShowsTheater(s).getTheater_id());
				res.add(tmp2);
			}
			model.addAttribute("res", res);
			for (tempSh i : res) {
				System.out.println(i.getShow_id());
			}
			
			return "shows";
		} catch(Throwable ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/scenarios", method = RequestMethod.GET)
	public String getScenarios(@RequestParam("sc_name") String sc_name, @RequestParam("sc_author") String sc_author, Model model) {
		try {
			List<Scenario> sc_list = new ArrayList<Scenario>();
			if (sc_name == "" && sc_author == "") {
				sc_list = sD.getByParam(null, null);
			} else if (sc_name != "" && sc_author != "") {
				sc_list = sD.getByParam(sc_author, sc_name);
			} else if (sc_name != "") {
				sc_list = sD.getByParam(null, sc_name);
			} else if (sc_author != "") {
				sc_list = sD.getByParam(sc_author, null);
			}
			model.addAttribute("sc_list", sc_list);
			return "scenarios";
		} catch(Throwable ex) {
			return "error";
		}

	}
	@RequestMapping(value = "/scenario", method = RequestMethod.GET)
	public String getScenario(@RequestParam(value="id", required = true) int id, Model model) {
		try {
			Scenario sce = sD.getById(id);
			model.addAttribute("s", sce);
			List<Shows> ss = shD.getByScTh(sce, null);;
			model.addAttribute("ss", ss);
			System.out.println("Servlet scenario Ok");
			return "scenario";
		} catch(Throwable ex) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getOrder(@RequestParam(value="id", required = true) int id, Model model) {
		try {
			Place_for_sell place =  psD.getById(id);
			model.addAttribute("cur_place", place);
			return "order";
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getOrder(@RequestParam(value="place_id", required = true) int place_id, 
			@CookieValue(value = "id", required = false) Cookie ck_id, Model model) {
		try {
			if (ck_id == null) {
				String loginf = "Log IN, please";
				model.addAttribute("loginf", loginf);
				return "main";
			}
			int client_id = Integer.parseInt(ck_id.getValue());
			Place_for_sell place = psD.getById(place_id);
			if (place == null) {
				throw new Throwable("No Such Place_for_sell");
			}
			model.addAttribute("cur_place", place);
			String bookres = "";
			if (place.getFree() == 1) {
				Booking temp = new Booking();
				Client cur = cD.getById(client_id);
				if (cur == null) {
					bookres = "No such Client_id!";
				} else {
					place.setFree(0);
					psD.update(place);
					temp.setClient(cur);
					temp.setPlace(place);
					int temp_book = bD.create(temp);
					String str_id = "?";
					str_id = Integer.toString(temp_book);
					bookres = "Successfully Booked! Your book id: " + str_id;
				}
			} else {
				bookres = "Place is not Free!";
			}
			model.addAttribute("bookres", bookres);
			return "book";
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/register")
	public String register(@ModelAttribute Client cl, Model model) {
		try {
			String result = "";
			System.out.println(cl.getPassword());
			if (cl.getLast_name() == null && cl.getName() == null && cl.getPassword() == null ||
					cl.getLast_name().equals("") && cl.getName().equals("") && cl.getPassword().equals("")) {
				result = "";
			} else if (cl.getPassword().equals("") || cl.getPassword() == null) {
					result = "Password can not be blank!";
				} else {
					int result_id = cD.create(cl);
					if (result_id == 0) {
						return "error";
					} else {
						result = "Successfully Registered! Your id is: " + Integer.toString(result_id);
					}
				}
			model.addAttribute("result", result);
			return "register";
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addpage")
	public String addPage(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, Model model) {
		try {
			if (id == null || pass == null) {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
			if (cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
					&& id.getValue().equals("1")) {
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addsc")
	public String addScenario(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="source_name", required = false) String source_name,
			@RequestParam(value="author", required = false) String author,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Scenario temp = new Scenario();
				temp.setAuthor(author);
				temp.setSource_name(source_name);
				int res = sD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addth")
	public String addTheater(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="address", required = false) String address,
			@RequestParam(value="bio", required = false) String bio,
			@RequestParam(value="name", required = false) String name,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Theater temp  = new Theater();
				temp.setAddress(address);
				temp.setBio(bio);
				temp.setName(name);
				int res = tD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addwo")
	public String addWorker(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="name", required = false) String name,
			@RequestParam(value="last_name", required = false) String last_name,
			@RequestParam(value="bio", required = false) String bio,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Worker temp  = new Worker();
				temp.setBio(bio);
				temp.setLast_name(last_name);
				temp.setName(name);
				int res = wD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addws")
	public String addWS(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="worker_id", required = false) int worker_id,
			@RequestParam(value="show_id", required = false) int show_id,
			@RequestParam(value="role", required = false) String role,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Worker_in_show temp  = new Worker_in_show();
				temp.setRole(role);
				temp.setShow_id(shD.getById(show_id));
				temp.setWorker_id(wD.getById(worker_id));
				int res = wsD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addwt")
	public String addWT(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="worker_id", required = false) int worker_id,
			@RequestParam(value="theater_id", required = false) int theater_id,
			@RequestParam(value="role", required = false) String role,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Worker_in_theater temp  = new Worker_in_theater();
				temp.setRole(role);
				temp.setTheater_id(tD.getById(theater_id));
				temp.setWorker_id(wD.getById(worker_id));
				int res = wtD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addsh")
	public String addsh(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="hall", required = true) int hall,
			@RequestParam(value="scenario", required = false) int scenario,
			@RequestParam(value="dat", required = false) Date dat,
			@RequestParam(value="duration", required = false) int duration,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Shows temp  = new Shows();
				temp.setDuration(duration);
				temp.setDat(dat);
				temp.setHall(hD.getById(hall));
				temp.setScenario(sD.getById(scenario));
				System.out.println(temp.getDat());
				int res = shD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addpl")
	public String addpl(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="hall_id", required = false) int hall,
			@RequestParam(value="row_num", required = false) int row_num,
			@RequestParam(value="num", required = false) int num,
			@RequestParam(value="type", required = false) char type,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Place temp = new Place();
				temp.setHall(hD.getById(hall));
				temp.setNum(num);
				temp.setRow_num(row_num);
				temp.setType(type);
				int res = pD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addps")
	public String addpl(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="place", required = false) int place,
			@RequestParam(value="show", required = false) int show,
			@RequestParam(value="price", required = false) int price,
			@RequestParam(value="free", required = false) int free,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Place_for_sell temp = new Place_for_sell();
				temp.setFree(free);
				temp.setPlace(pD.getById(place));
				temp.setPrice(price);
				temp.setShow(shD.getById(show));
				int res = psD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/addha")
	public String addHall(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="theater", required = false) int theater,
			@RequestParam(value="num", required = false) int num,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				Hall temp = new Hall();
				temp.setTheater(tD.getById(theater));
				temp.setNum(num);
				int res = hD.create(temp);
				String resStr = "Successfully Added! Id: " + Integer.toString(res);
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/del")
	public String del(@CookieValue(value = "id", required = false) Cookie id, 
			@CookieValue(value = "pass", required = false) Cookie pass, 
			@RequestParam(value="type", required = true) String type,
			@RequestParam(value="id", required = true) int del_id,
			HttpServletResponse response,
			Model model) {
		try {
			if ((id != null && pass != null) && 
			(cD.getById(Integer.parseInt(id.getValue())).getPassword().equals(pass.getValue())
			&& id.getValue().equals("1"))) {
				String resStr = "Successfully Deleted! ID: " + Integer.toString(del_id);;
				switch(type) {
					case "Place":
						Place temp1 = pD.getById(del_id);
						if (temp1 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						pD.delete(temp1);
						break;
					case "Booking":
						Booking temp2 = bD.getById(del_id);
						if (temp2 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						bD.delete(temp2);
						break;
					case "Hall":
						Hall temp3 = hD.getById(del_id);
						if (temp3 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						hD.delete(temp3);
						break;
					case "Theater":
						Theater temp4 = tD.getById(del_id);
						if (temp4 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						tD.delete(temp4);
						break;
					case "Show":
						Shows temp5 = shD.getById(del_id);
						if (temp5 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						shD.delete(temp5);
						break;
					case "Place for Sell":
						Place_for_sell temp6 = psD.getById(del_id);
						if (temp6 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						psD.delete(temp6);
						break;
					case "Worker":
						Worker temp7 = wD.getById(del_id);
						if (temp7 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						wD.delete(temp7);
						break;
					case "Worker in show":
						Worker_in_show temp8 = wsD.getById(del_id);
						if (temp8 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						wsD.delete(temp8);
						break;
					case "Worker in theater":
						Worker_in_theater temp9 = wtD.getById(del_id);
						if (temp9 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						wtD.delete(temp9);
						break;
					case "Scenario":
						Scenario temp10 = sD.getById(del_id);
						if (temp10 == null) {
							resStr = "No Such ID! Id: " + Integer.toString(del_id);
							break;
						}
						sD.delete(temp10);
						break;
					default:
						return "error";
				}
				model.addAttribute("status", resStr);
				return "addpage";
			} else {
				String temp = "U must be logged in as admin";
				model.addAttribute("loginf", temp);
				return "main";
			}
		} catch(Throwable ex) {
			System.out.println(ex.getMessage());
			return "error";
		}
	}
	
	
	
	
	
}

















