package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GunchimController {

	private final QuestionService qr;
	
	@GetMapping("/ssak")
	public String hell() {
		return "question_list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		//model : 템플릿(HTML)에 전달할 내용을 넘겨주는 클래스
//		List<Question> qList = this.qr.findAll();
		List<Question> qList = this.qr.getList();
		
		//addAttribute : 템플릿에 전달할 객체를 지정하는 메서드
		//템플릿(HTML)에서 보게될 명칭, 넘길 객체 순으로 작성
		model.addAttribute("questionList", qList);
		return "question_list";
	}
	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) throws PpakchimException {
		Question q = this.qr.getQuestion(id);
		model.addAttribute("question", q);
		return "question_detail";
	}
	@GetMapping("/create")
	public String questionCreate() {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String questionCreate(@RequestParam(value="subject") String subject,
								 @RequestParam(value="content") String content) {
		this.qr.create(subject,content);
		return "redirect:/list";
	}
	
}
