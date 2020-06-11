package com.crudapp.controller;

import com.crudapp.dao.CourseDao;
import com.crudapp.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {

    @Autowired
    private CourseDao courseDao;

    @RequestMapping("/index")
    public ModelAndView home(Model model) {
        try {
            model.addAttribute("courses", courseDao.getCourses());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("index");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/course/add")
    public ModelAndView addCourse(@ModelAttribute Course course) throws Exception {
        try {
            courseDao.addCourse(course);
        } catch (Exception e) {
            return new ModelAndView("redirect:/error");
        }
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/course/delete")
    public ModelAndView deleteCourse(int courseId) throws Exception {
        try {
            courseDao.deleteCourse(courseId);
        } catch (Exception e) {
            return new ModelAndView("redirect:/error");
        }
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/course/edit")
    public String editCourse(Model model, int courseId) throws Exception {
        Course courseObj = null;
        try {
            courseObj = courseDao.editCourse(courseId);
            model.addAttribute("courses", courseDao.getCourses());
            model.addAttribute("course", courseObj);
        } catch (Exception e) {
            return "error";
        }
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/course/search")
    public String getCourse(Model model, @RequestParam String search) {
        try {
            model.addAttribute("courses", courseDao.getCourse(search));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("courseSearch", search);
        return "index";
    }

}

