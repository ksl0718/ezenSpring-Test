package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	
	private final QuestionService qService;
	private final AnswerService aService;
	
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id,
			@RequestParam(value="content") String content) {
		//@PathVariable : 주소갑(쿼리스트링값)을 받아올때 사용
		//   - 주소의 변수값을 받아올때 사용
		//   - 값을 무조건 하나만 받아올 수 있음
		//@RequestParam : 여러개의 값을 받아올때 사용.
		//   - 사용자가 입력한 값을 받아올때 사용
		//
		try {
			Question q = this.qService.getQuestion(id);
			this.aService.create(q, content);
		} catch(PpakchimException e) {
			e.printStackTrace();
		}
		
		return String.format("redirect:/detail/%s", id);
	}
}
