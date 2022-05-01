package fi.haagahelia.bookingtutor.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import fi.haagahelia.bookingtutor.domain.LanguageEntity;
import fi.haagahelia.bookingtutor.domain.LessonEntity;
import fi.haagahelia.bookingtutor.domain.TutorEntity;
import fi.haagahelia.bookingtutor.repository.LanguageRepository;
import fi.haagahelia.bookingtutor.repository.LessonRepository;
import fi.haagahelia.bookingtutor.repository.TutorRepository;

@Controller
public class WebController {
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private LanguageRepository langRepository;
    @Autowired
    private LessonRepository lessonRepository;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    // @return a Rest API Json file with all the languages in database
    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    public @ResponseBody List<LanguageEntity> langListRest() {
        return (List<LanguageEntity>) langRepository.findAll();
    }

    // @return a Rest API Json file of language with a specific Id
    @RequestMapping(value = "/language/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<LanguageEntity> findLangRest(@PathVariable("id") Long Id) {
        return langRepository.findById(Id);
    }

    // @return a Rest API Json file of all the lessons in database

    @RequestMapping(value = "/lessons", method = RequestMethod.GET)
    public @ResponseBody List<LessonEntity> lessonListRest() {
        return (List<LessonEntity>) lessonRepository.findAll();
    }

    // @return a Rest API Json file of lesson with a specific Id

    @RequestMapping(value = "/lesson/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<LessonEntity> findLessonRest(@PathVariable("id") Long Id) {
        return lessonRepository.findById(Id);
    }

    // @return Admin page

    @RequestMapping(value = "/lessonlist")
    public String lessonList(Model model) {
        model.addAttribute("lesson", new LessonEntity());
        model.addAttribute("lessons", lessonRepository.findAll());
        return "lessonlist";
    }

    // @return a Rest API Json file with all the tutors

    @RequestMapping(value = "/tutors", method = RequestMethod.GET)
    public @ResponseBody List<TutorEntity> tutorListRest() {
        return (List<TutorEntity>) tutorRepository.findAll();
    }

    // @return a Rest API Json file of the tutor with a specific Id

    @RequestMapping(value = "/tutor/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<TutorEntity> findTutorRest(@PathVariable("id") Long Id) {
        return tutorRepository.findById(Id);
    }

    // @return the html page list of all tutors

    @RequestMapping(value = "/tutorlist")
    public String tutorList(Model model) {
        model.addAttribute("tutors", tutorRepository.findAll());
        return "tutorlist";
    }

    // @return a Rest API Json file of the schedule with a specific Id

    @RequestMapping(value = "/schedule/{id}")
    public String schedule(@PathVariable("id") Long tutorId, Model model) {
        model.addAttribute("tutors", tutorRepository.findById(tutorId).get());
        return "schedule";
    }

    // @return booktutor page

    @RequestMapping(value = "/booktutor")
    public String bookTutor(Model model) {
        model.addAttribute("lesson", new LessonEntity());
        model.addAttribute("language", langRepository.findAll());
        model.addAttribute("tutors", tutorRepository.findAll());

        return "booktutor";
    }

    // @return a form to edit

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long lessonId, Model model) {
        model.addAttribute("lesson", lessonRepository.findById(lessonId).get());
        model.addAttribute("languages", langRepository.findAll());
        model.addAttribute("tutors", tutorRepository.findAll());

        return "editlesson";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(LessonEntity lesson) {
        lessonRepository.save(lesson);

        return "redirect:tutorlist";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(LessonEntity lesson) {
        lessonRepository.save(lesson);

        return "redirect:lessonlist";
    }

}
